package vn.name.admin.appbansach.activity;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.messaging.FirebaseMessaging;
import com.nex3z.notificationbadge.NotificationBadge;

import java.util.ArrayList;
import java.util.List;

import io.paperdb.Paper;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import vn.name.admin.appbansach.R;
import vn.name.admin.appbansach.adapter.LoaiSpAdapter;
import vn.name.admin.appbansach.adapter.SanPhamMoiAdapter;
import vn.name.admin.appbansach.model.LoaiSp;
import vn.name.admin.appbansach.model.SanPhamMoi;
import vn.name.admin.appbansach.model.User;
import vn.name.admin.appbansach.retrofit.ApiBanSach;
import vn.name.admin.appbansach.retrofit.RetrofitClient;
import vn.name.admin.appbansach.utils.Utils;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    ViewFlipper viewFlipper;
    RecyclerView recyclerViewManHinhChinh;
    NavigationView navigationView;
    ListView listViewManHinhChinh;
    DrawerLayout drawerLayout;
    LoaiSpAdapter loaiSpAdapter;
    List<LoaiSp> mangloaisp;
    CompositeDisposable compositeDisposable = new CompositeDisposable();
    ApiBanSach apiBanSach;
    List<SanPhamMoi> mangSpMoi;
    SanPhamMoiAdapter spAdapter;
    NotificationBadge badge;
    FrameLayout frameLayout;
    ImageView img_search;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        apiBanSach = RetrofitClient.getInstance(Utils.BASE_URL).create(ApiBanSach.class);
        Paper.init(this);
        if (Paper.book().read("user") != null){
            User user = Paper.book().read("user");
            Utils.user_current = user;
        }
        getToken();
        Anhxa();
        ActionBar();
        if (isConnected(this)){
            ActionViewFlipper();
            getLoaiSanPham();
            getSpMoi();
            getEventClick();
        }else {
            Toast.makeText(getApplicationContext(), "Không có internet, vui lòng kết nối", Toast.LENGTH_LONG).show();
        }
    }
    private void getToken(){
        FirebaseMessaging.getInstance().getToken().addOnSuccessListener(new OnSuccessListener<String>() {
            @Override
            public void onSuccess(String s) {
                if (!TextUtils.isEmpty(s)){
                    compositeDisposable.add(apiBanSach.updateToken(Utils.user_current.getId(),s)
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(messageModel -> {

                            },
                                    throwable -> {
                                Log.d("log", throwable.getMessage());
                                    }
                                    ));
                }
            }
        });
    }

    private void getEventClick() {
        listViewManHinhChinh.setOnItemClickListener((adapterView, view, i, l) -> {
            switch (i){
                case 0:
                    Intent trangchu = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(trangchu);
                    break;
                case 1:
                    Intent sachcu = new Intent(getApplicationContext(),SachCuMainActivity.class);
                    sachcu.putExtra("loai",1);
                    startActivity(sachcu);
                    break;
                case 2:
                    Intent sachmoi = new Intent(getApplicationContext(),SachMoiMainActivity.class);
                    sachmoi.putExtra("loai",2);
                    startActivity(sachmoi);
                    break;
                case 5:
                    Intent quanli = new Intent(getApplicationContext(),QuanLiActivity.class);
                    startActivity(quanli);
                    break;
                case 6:
                    Intent donhang = new Intent(getApplicationContext(),XemDonActivity.class);
                    startActivity(donhang);
                    break;
                case 7:
                    Intent chat = new Intent(getApplicationContext(), QLChatActivity.class);
                    startActivity(chat);
                    break;
                case 8:
                    Intent qluser = new Intent(getApplicationContext(),QuanLiUserActivity.class);
                    startActivity(qluser);
                    break;
                case 9:
                    Intent thongke = new Intent(getApplicationContext(),ThongKeActivity.class);
                    startActivity(thongke);
                    break;
                case 10:
                    // xoa key user
                    Paper.book().delete("user");
                    FirebaseAuth.getInstance().signOut();
                    Intent dangnhap = new Intent(getApplicationContext(), DangNhapActivity.class);
                    startActivity(dangnhap);
                    finish();
                    break;

            }
        });
    }

    private void getSpMoi() {
        compositeDisposable.add(apiBanSach.getSpMoi()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        sanPhamMoiModel -> {
                            if (sanPhamMoiModel.isSuccess()){
                                mangSpMoi = sanPhamMoiModel.getResult();
                                spAdapter = new SanPhamMoiAdapter(getApplicationContext(),mangSpMoi);
                                recyclerViewManHinhChinh.setAdapter(spAdapter);
                            }
                        },
                        throwable -> {
                            Toast.makeText(getApplicationContext(), "Không kết nối được với server"+throwable.getMessage(),Toast.LENGTH_LONG).show();
                        }
                ));
    }

    private void getLoaiSanPham() {

        compositeDisposable.add(apiBanSach.getLoaiSp().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        loaiSpModel -> {
                            if (loaiSpModel.isSuccess()){
                                mangloaisp = loaiSpModel.getResult();
                                mangloaisp.add(new LoaiSp("Chat vs user",""));
                                mangloaisp.add(new LoaiSp("Quản lý tài khoản",""));
                                mangloaisp.add(new LoaiSp("Thống kê",""));
                                mangloaisp.add(new LoaiSp("Đăng xuất",""));

                                // khoi tao adapter
                                loaiSpAdapter = new LoaiSpAdapter(getApplicationContext(), mangloaisp);
                                listViewManHinhChinh.setAdapter(loaiSpAdapter);
                            }
                        }
                ));
    }

    private void ActionViewFlipper() {
        List<String> mangquangcao = new ArrayList<>();
        mangquangcao.add("http://mauweb.monamedia.net/thegioididong/wp-content/uploads/2017/12/banner-Le-hoi-phu-kien-800-300.png");
        mangquangcao.add("http://mauweb.monamedia.net/thegioididong/wp-content/uploads/2017/12/banner-HC-Tra-Gop-800-300.png");
        mangquangcao.add("http://mauweb.monamedia.net/thegioididong/wp-content/uploads/2017/12/banner-big-ky-nguyen-800-300.jpg");
        for (int i = 0; i<mangquangcao.size(); i++){
            ImageView imageView = new ImageView(getApplicationContext());
            Glide.with(getApplicationContext()).load(mangquangcao.get(i)).into(imageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            viewFlipper.addView(imageView);
        }
        viewFlipper.setFlipInterval(3000);
        viewFlipper.setAutoStart(true);
        Animation slide_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_in_right);
        Animation slide_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_out_right);
        viewFlipper.setInAnimation(slide_in);
        viewFlipper.setOutAnimation(slide_out);
    }

    private void ActionBar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(android.R.drawable.ic_menu_sort_by_size);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }

    private void Anhxa(){
        img_search = findViewById(R.id.img_search);
        toolbar = findViewById(R.id.toobarmanhinhchinh);
        viewFlipper = findViewById(R.id.viewlipper);
        recyclerViewManHinhChinh = findViewById(R.id.recycleview);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,2);
        recyclerViewManHinhChinh.setLayoutManager(layoutManager);
        recyclerViewManHinhChinh.setHasFixedSize(true);
        listViewManHinhChinh = findViewById(R.id.listviewmanhinhchinh);
        navigationView = findViewById(R.id.navigationview);
        drawerLayout = findViewById(R.id.drawerlayout);
        badge = findViewById(R.id.menu_sl);
        frameLayout = findViewById(R.id.framegiohang);
        // khoi tao list
        mangloaisp = new ArrayList<>();
        mangSpMoi = new ArrayList<>();
        if (Utils.manggiohang == null){
            Utils.manggiohang = new ArrayList<>();
        }else {
            int totalItem = 0;
            for (int i=0; i<Utils.manggiohang.size(); i++){
                totalItem = totalItem + Utils.manggiohang.get(i).getSoluong();

            }
            badge.setText(String.valueOf(totalItem));
        }
        img_search.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), SearchActivity.class);
            startActivity(intent);
        });
        frameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent giohang = new Intent(getApplicationContext(), GioHangActivity.class);
                startActivity(giohang);
            }
        });
    }
    private boolean isConnected (Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo wifi = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        NetworkInfo mobile = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        if ((wifi != null && wifi.isConnected()) || (mobile != null && mobile.isConnected())){
            return true;
        }else{
            return false;
        }
    }

    @Override
    protected void onDestroy() {
        compositeDisposable.clear();
        super.onDestroy();
    }
}