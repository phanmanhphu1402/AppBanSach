package vn.name.admin.appbansach.activity;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.github.dhaval2404.imagepicker.ImagePicker;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;


import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.name.admin.appbansach.R;
import vn.name.admin.appbansach.databinding.ActivityThemspBinding;
import vn.name.admin.appbansach.model.MessageModel;
import vn.name.admin.appbansach.model.SanPhamMoi;
import vn.name.admin.appbansach.retrofit.ApiBanSach;
import vn.name.admin.appbansach.retrofit.RetrofitClient;
import vn.name.admin.appbansach.utils.Utils;

public class ThemSpActivity extends AppCompatActivity {
    Spinner spinner;
    int loai = 0;
    ActivityThemspBinding binding;
    ApiBanSach apiBanSach;
    CompositeDisposable compositeDisposable = new CompositeDisposable();
    String mediaPath;
    SanPhamMoi sanPhamSua;
    boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityThemspBinding.inflate(getLayoutInflater());
        apiBanSach = RetrofitClient.getInstance(Utils.BASE_URL).create(ApiBanSach.class);
        setContentView(binding.getRoot());
        initView();
        initData();
        Intent intent = getIntent();
        sanPhamSua = (SanPhamMoi) intent.getSerializableExtra("sua");
        if (sanPhamSua == null){
            //them moi
            flag = false;
        }else {
            //sua
            flag = true;
            binding.btnthem.setText("Sửa sản phẩm");
            //showdata
            binding.mota.setText(sanPhamSua.getMota());
            binding.giasp.setText(sanPhamSua.getGiasp());
            binding.tensp.setText(sanPhamSua.getTensp());
            binding.hinhanh.setText(sanPhamSua.getHinhanh());
            binding.spinnerLoai.setSelection(sanPhamSua.getLoai());
        }
    }

    private void initData() {
        List<String> stringList = new ArrayList<>();
        stringList.add("Vui lòng chọn loại");
        stringList.add("loại 1");
        stringList.add("loại 2");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,stringList);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long id) {
                loai = i;
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        binding.btnthem.setOnClickListener(v -> {
            if (flag==false){
                themsanpham();
            }else {
                suaSanPham();
            }

        });
        binding.imgcamera.setOnClickListener(new View.OnClickListener() {
            @Override
            //bat cam
            public void onClick(View v) {
                ImagePicker.with(ThemSpActivity.this)
                        .crop()	    			//Crop image(Optional), Check Customization for more option
                        .compress(1024)			//Final image size will be less than 1 MB(Optional)
                        .maxResultSize(1080, 1080)	//Final image resolution will be less than 1080 x 1080(Optional)
                        .start();
            }
        });
    }

    private void suaSanPham() {
        String str_ten = binding.tensp.getText().toString().trim();
        String str_gia = binding.giasp.getText().toString().trim();
        String str_mota = binding.mota.getText().toString().trim();
        String str_hinhanh = binding.hinhanh.getText().toString().trim();
        if (TextUtils.isEmpty(str_ten) || TextUtils.isEmpty(str_gia) || TextUtils.isEmpty(str_mota) || TextUtils.isEmpty(str_hinhanh) || loai ==0){
            Toast.makeText(getApplicationContext(), "Vui lòng nhập đủ thông tin", Toast.LENGTH_SHORT).show();
        }else{
            compositeDisposable.add(apiBanSach.updateSp(str_ten,str_gia,str_hinhanh,str_mota,loai,sanPhamSua.getId())
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                            messageModel -> {
                                if (messageModel.isSuccess()){
                                    Toast.makeText(getApplicationContext(), messageModel.getMessage(), Toast.LENGTH_SHORT).show();
                                }else {
                                    Toast.makeText(getApplicationContext(),messageModel.getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            },
                            throwable -> {
                                Toast.makeText(getApplicationContext(), throwable.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                    ));
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mediaPath = data.getDataString();
        uploadMultipleFiles();
        Log.d("log",  "onActivityResult: " + mediaPath);
    }

    private void themsanpham() {
        String str_ten = binding.tensp.getText().toString().trim();
        String str_gia = binding.giasp.getText().toString().trim();
        String str_mota = binding.mota.getText().toString().trim();
        String str_hinhanh = binding.hinhanh.getText().toString().trim();
        if (TextUtils.isEmpty(str_ten) || TextUtils.isEmpty(str_gia) || TextUtils.isEmpty(str_mota) || TextUtils.isEmpty(str_hinhanh) || loai ==0){
            Toast.makeText(getApplicationContext(), "Vui lòng nhập đủ thông tin", Toast.LENGTH_SHORT).show();
        }else{
            compositeDisposable.add(apiBanSach.insertSp(str_ten,str_gia,str_hinhanh,str_mota,(loai))
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                            messageModel -> {
                                if (messageModel.isSuccess()){
                                    Toast.makeText(getApplicationContext(), messageModel.getMessage(), Toast.LENGTH_SHORT).show();
                                }else {
                                    Toast.makeText(getApplicationContext(),messageModel.getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            },
                            throwable -> {
                                Toast.makeText(getApplicationContext(), throwable.getMessage(), Toast.LENGTH_SHORT).show();
                            }     
                    ));
        }
    }
    private String getPath(Uri uri){
        String result;
        Cursor cursor = getContentResolver().query(uri,null, null, null, null);
        if (cursor == null){
            result = uri.getPath();
        }else{
            cursor.moveToFirst();
            int index = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
            result = cursor.getString(index);
            cursor.close();
        }
        return result;
    }

    // Uploading Image/Video
    private void uploadMultipleFiles() {
        Uri uri = Uri.parse(mediaPath);
        File file = new File(getPath(uri));
        RequestBody requestBody1 = RequestBody.create(MediaType.parse("*/*"), file);
        MultipartBody.Part fileToUpload1 = MultipartBody.Part.createFormData("file", file.getName(), requestBody1);
        Call< MessageModel > call = apiBanSach.uploadFile(fileToUpload1);
        call.enqueue(new Callback <MessageModel>() {
            @Override
            public void onResponse(Call<MessageModel> call, Response<MessageModel> response) {
                MessageModel messageModel = response.body();
                if (messageModel != null) {
                    if (messageModel.isSuccess()) {
                        binding.hinhanh.setText(messageModel.getName());
                    }else {
                        Toast.makeText(getApplicationContext(),messageModel.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Log.d("TAG", "onResponse: "+ messageModel.toString());
                }
            }
            @Override
            public void onFailure(Call<MessageModel> call, Throwable t) {
                Log.d("log", "onFailure: "+ t.getMessage());
            }
        });
    }

    private void initView() {
        spinner = findViewById(R.id.spinner_loai);
    }
    @Override
    protected void onDestroy() {
        compositeDisposable.clear();
        super.onDestroy();
    }
}