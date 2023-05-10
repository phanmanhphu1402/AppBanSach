package vn.name.admin.appbansach.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import vn.name.admin.appbansach.R;
import vn.name.admin.appbansach.utils.Utils;

public class DangNhapActivity extends AppCompatActivity {
    TextView txtdangki;
    EditText email, pass;
    AppCompatButton btndangnhap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);
        initView();
        initControl();
    }

    private void initControl() {
        txtdangki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), DangKiActivity.class);
                startActivity(intent);
            }
        });
        btndangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void initView() {

        txtdangki = findViewById(R.id.txtdangki);
        email = findViewById(R.id.email);
        pass = findViewById(R.id.pass);
        btndangnhap = findViewById(R.id.btndangnhap);

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (Utils.user_curren.getEmail() != null && Utils.user_curren.getPass()!= null){
            email.setText(Utils.user_curren.getEmail());
            pass.setText(Utils.user_curren.getPass());
        }
    }
}