package vn.name.admin.appbansach.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import vn.name.admin.appbansach.R;
import vn.name.admin.appbansach.adapter.SachCuAdapter;
import vn.name.admin.appbansach.model.SanPhamMoi;
import vn.name.admin.appbansach.retrofit.ApiBanSach;
import vn.name.admin.appbansach.retrofit.RetrofitClient;
import vn.name.admin.appbansach.utils.Utils;

public class SearchActivity extends AppCompatActivity {
    Toolbar toolbar;
    RecyclerView recyclerView;
    SachCuAdapter adaptersc;
    EditText edtseach;
    ApiBanSach apiBanSach;

    List<SanPhamMoi> sanPhamMoiList;
    CompositeDisposable compositeDisposable = new CompositeDisposable();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        apiBanSach = RetrofitClient.getInstance(Utils.BASE_URL).create(ApiBanSach.class);
        initView();
        ActionToolBar();
    }
    private void initView() {
        sanPhamMoiList = new ArrayList<>();
        edtseach = findViewById(R.id.edtseach);
        toolbar = findViewById(R.id.toobar);
        recyclerView = findViewById(R.id.recycleview_search);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        edtseach.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 0){
                    sanPhamMoiList.clear();
                    adaptersc = new SachCuAdapter(getApplicationContext(),sanPhamMoiList);
                    recyclerView.setAdapter(adaptersc);
                }else{
                    getDataSeach(s.toString());
                }
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }
    private void getDataSeach(String s) {
        sanPhamMoiList.clear();
        compositeDisposable.add(apiBanSach.search(s)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        sanPhamMoiModel -> {
                            if(sanPhamMoiModel.isSuccess()){
                                sanPhamMoiList = sanPhamMoiModel.getResult();
                                adaptersc = new SachCuAdapter(getApplicationContext(),sanPhamMoiList);
                                recyclerView.setAdapter(adaptersc);
                            }else{
                                Toast.makeText(getApplicationContext(),sanPhamMoiModel.getMessage(), Toast.LENGTH_SHORT).show();
                                sanPhamMoiList.clear();
                                adaptersc.notifyDataSetChanged();
                            }
                        },
                        throwable -> {
                            Toast.makeText(getApplicationContext(),throwable.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                ));
        }
    private void ActionToolBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    @Override
    protected void onDestroy() {
        compositeDisposable.clear();
        super.onDestroy();
    }
}