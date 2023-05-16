package vn.name.admin.appbansach.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import vn.name.admin.appbansach.R;
import vn.name.admin.appbansach.adapter.UserAdapter;
import vn.name.admin.appbansach.model.EventBus.SuaXoaEvent;
import vn.name.admin.appbansach.model.User;
import vn.name.admin.appbansach.retrofit.ApiBanSach;
import vn.name.admin.appbansach.retrofit.RetrofitClient;
import vn.name.admin.appbansach.utils.Utils;

public class QuanLiUserActivity extends AppCompatActivity {
    Toolbar toolbar;
    ImageView img_them, img_search;
    RecyclerView recyclerView;
    CompositeDisposable compositeDisposable = new CompositeDisposable();
    ApiBanSach apiBanSach;

    List<User> list;


    UserAdapter adapter;
    User userSuaXoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_li_user);
        apiBanSach = RetrofitClient.getInstance(Utils.BASE_URL).create(ApiBanSach.class);
        initView();
        initControl();
        getUserMoi();
        ActionToolBar();
    }

    private void getUserMoi() {
        compositeDisposable.add(apiBanSach.getUserMoi()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(userModel -> {
                    if (userModel.isSuccess()){
                        list = userModel.getResult();
                        adapter = new UserAdapter(getApplicationContext(), list);
                        recyclerView.setAdapter(adapter);
                    }
                },
                        throwble -> {
                            Toast.makeText(getApplicationContext(), "Không kết nối được với sever"+throwble.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                        ));
    }

    private void ActionToolBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(view -> finish());
    }

    private void initView() {
        toolbar = findViewById(R.id.toolbarquanliuser);
        img_search = findViewById(R.id.img_search);
        img_them = findViewById(R.id.img_them);
        recyclerView = findViewById(R.id.recycler_qluser);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,1);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (item.getTitle().equals("Sửa")){
            suaUser();
        }else if (item.getTitle().equals("Xóa")){
            xoaUser();
        }
        return super.onContextItemSelected(item);
    }

    private void xoaUser() {compositeDisposable.add(apiBanSach.xoaUser(userSuaXoa.getId())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                    messageModel -> {
                        if (messageModel.isSuccess()){
                            Toast.makeText(getApplicationContext(), messageModel.getMessage(), Toast.LENGTH_SHORT).show();
                            getUserMoi();
                        }else {
                            Toast.makeText(getApplicationContext(), messageModel.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    },
                    throwable -> {
                        Log.d("log",throwable.getMessage());
                    }
            ));

    }

    private void suaUser() {
        Intent intent = new Intent(getApplicationContext(),ThemUserActivity.class);
        intent.putExtra("suaUser", userSuaXoa);
        startActivity(intent);
    }

    private void initControl() {
        img_them.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), ThemUserActivity.class);
            startActivity(intent);
        });
        img_search.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), SearchUserActivity.class);
            startActivity(intent);
        });
    }

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)

    public void eventSuaXoa(SuaXoaEvent event){
        if(event != null){
            userSuaXoa = event.getUser();
        }
    }

    @Override
    protected void onDestroy() {
        compositeDisposable.clear();
        super.onDestroy();
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
}