package vn.name.admin.appbansach.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import vn.name.admin.appbansach.R;
import vn.name.admin.appbansach.retrofit.ApiBanSach;
import vn.name.admin.appbansach.retrofit.RetrofitClient;
import vn.name.admin.appbansach.utils.Utils;

public class SachMoiMainActivity extends AppCompatActivity {
    Toolbar toolbar;
    ImageView img_search;
    ApiBanSach apiBanSach;
    int loai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sach_moi_main);
        apiBanSach = RetrofitClient.getInstance(Utils.BASE_URL).create(ApiBanSach.class);
        loai = getIntent().getIntExtra("loai",2);
        AnhXa();
        ActionToolBar();
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

    private void AnhXa() {
        img_search = findViewById(R.id.img_search);
        toolbar = findViewById(R.id.toobar);
        img_search.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), SearchActivity.class);
            startActivity(intent);
        });
    }
}