package vn.name.admin.appbansach.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import vn.name.admin.appbansach.databinding.ActivityThemuserBinding;
import vn.name.admin.appbansach.model.User;
import vn.name.admin.appbansach.retrofit.ApiBanSach;
import vn.name.admin.appbansach.retrofit.RetrofitClient;
import vn.name.admin.appbansach.utils.Utils;

public class ThemUserActivity extends AppCompatActivity {
    ActivityThemuserBinding binding;
    ApiBanSach apiBanSach;
    CompositeDisposable compositeDisposable = new CompositeDisposable();
    boolean flag = false;
    User userSua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityThemuserBinding.inflate(getLayoutInflater());
        apiBanSach = RetrofitClient.getInstance(Utils.BASE_URL).create(ApiBanSach.class);
        setContentView(binding.getRoot());
        initView();
        initControl();
        ActionToolBar();
        Intent intent = getIntent();
        userSua = (User) intent.getSerializableExtra("suaUser");
        if (userSua == null) {
            flag = false;
        }else{
            flag = true;
            binding.btnthemuser.setText("Sửa thông tin user");
            binding.addemail.setText(userSua.getEmail());
            binding.addpass.setText(userSua.getPass());
            binding.adduser.setText(userSua.getUsername());
            binding.addSDT.setText(userSua.getMobile());
        }
    }
    private void ActionToolBar() {

        setSupportActionBar(binding.toolbarthemsp);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        binding.toolbarthemsp.setNavigationOnClickListener(view -> finish());
    }

    private void initControl() {
        binding.btnthemuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag==false){
                    themUser();
                }else {
                    suaUser();
                }
            }
        });
    }
    private void suaUser() {
        String str_email = binding.addemail.getText().toString().trim();
        String str_pass = binding.addpass.getText().toString().trim();
        String str_user = binding.adduser.getText().toString().trim();
        String str_mobile = binding.addSDT.getText().toString().trim();
        if (TextUtils.isEmpty(str_email) || TextUtils.isEmpty(str_pass) || TextUtils.isEmpty(str_user) || TextUtils.isEmpty(str_mobile)){
            Toast.makeText(getApplicationContext(), "Vui lòng nhập đủ thông tin", Toast.LENGTH_SHORT).show();
        }else{
            compositeDisposable.add(apiBanSach.suaUser(str_email, str_pass, str_user, str_mobile,userSua.getId())
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                            userModel -> {
                                if (userModel.isSuccess()){
                                    Toast.makeText(getApplicationContext(), userModel.getMessage(), Toast.LENGTH_SHORT).show();
                                }else {
                                    Toast.makeText(getApplicationContext(),userModel.getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            },
                            throwable -> {
                                Toast.makeText(getApplicationContext(), throwable.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                    ));
        }
    }

    private void themUser() {
        String str_email = binding.addemail.getText().toString().trim();
        String str_pass = binding.addpass.getText().toString().trim();
        String str_user = binding.adduser.getText().toString().trim();
        String str_mobile = binding.addSDT.getText().toString().trim();
        if (TextUtils.isEmpty(str_email) || TextUtils.isEmpty(str_pass) || TextUtils.isEmpty(str_user) || TextUtils.isEmpty(str_mobile)){
            Toast.makeText(getApplicationContext(), "Vui lòng nhập đủ thông tin" + str_pass, Toast.LENGTH_SHORT).show();
        }else{
            compositeDisposable.add(apiBanSach.themUser(str_email,str_pass,str_user,str_mobile)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                            userModel -> {
                                if (userModel.isSuccess()){
                                    Toast.makeText(getApplicationContext(), userModel.getMessage(), Toast.LENGTH_SHORT).show();
                                }else {
                                    Toast.makeText(getApplicationContext(),userModel.getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            },
                            throwable -> {
                                Toast.makeText(getApplicationContext(), throwable.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                    ));
        }
    }
    private void initView() {

    }
    @Override
    protected void onDestroy() {
        compositeDisposable.clear();
        super.onDestroy();
    }
}