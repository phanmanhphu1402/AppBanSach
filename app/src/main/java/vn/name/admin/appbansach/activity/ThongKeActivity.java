package vn.name.admin.appbansach.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.util.Log;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import vn.name.admin.appbansach.R;
import vn.name.admin.appbansach.retrofit.ApiBanSach;
import vn.name.admin.appbansach.retrofit.RetrofitClient;
import vn.name.admin.appbansach.utils.Utils;

public class ThongKeActivity extends AppCompatActivity {
    PieChart pieChart;
    Toolbar toolbar;
    CompositeDisposable compositeDisposable = new CompositeDisposable();
    ApiBanSach apiBanSach;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_ke);
        apiBanSach = RetrofitClient.getInstance(Utils.BASE_URL).create(ApiBanSach.class);
        initView();
        getDataChart();
        ActionToolBar();

    }

    private void getDataChart() {
        List<PieEntry> listdata = new ArrayList<>();
        compositeDisposable.add(apiBanSach.getthongKe()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(thongKeModel -> {
                    if (thongKeModel.isSuccess()){
                        for (int i = 0; i < thongKeModel.getResult().size(); i++) {
                            String tensp = thongKeModel.getResult().get(i).getTensp();
                            int tong = thongKeModel.getResult().get(i).getTong();
                            listdata.add(new PieEntry(tong, tensp));
                        }
                        PieDataSet pieDataSet = new PieDataSet(listdata, "Thống kê");
                        PieData data = new PieData();
                        data.setDataSet(pieDataSet);
                        data.setValueTextSize(12f);
                        data.setValueFormatter(new PercentFormatter(pieChart));
                        pieDataSet.setColors(ColorTemplate.MATERIAL_COLORS);

                        pieChart.setData(data);
                        pieChart.animateXY(2000,2000);
                        pieChart.setUsePercentValues(true);
                        pieChart.getDescription().setEnabled(false);
                        pieChart.invalidate();
                    }
                },
                        throwable -> {
                            Log.d("TAG", "getDataChart: "+throwable.getMessage());
                        }));
    }

    private void initView() {
        toolbar = findViewById(R.id.toobartk);
        pieChart = findViewById(R.id.piechar);
    }

    private void ActionToolBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(view -> finish());
    }

    @Override
    protected void onDestroy() {
        compositeDisposable.clear();
        super.onDestroy();
    }
}