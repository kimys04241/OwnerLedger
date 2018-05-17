package com.ysking.ownerledger.activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.ysking.ownerledger.R;
import com.ysking.ownerledger.dailydata.DailyData;
import com.ysking.ownerledger.database.DailyDB;
import com.ysking.ownerledger.date.DateManager;
import com.ysking.ownerledger.fragments.FragmentDaily;

public class ActivityModifyDaily extends AppCompatActivity {

    String date;

    DailyDB db;

    DailyData dailyData;

    TextView tvModifyDivide;
    TextView tvSum;
    EditText editSum;
    TextView tvCategory;
    EditText editCategory;
    TextView tvClassification;
    EditText editClassification;
    TextView tvConnection;
    EditText editConnection;
    TextView tvMemo;
    EditText editMemo;
    Button btnModify;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_daily);

        int[] split=DateManager.getCheckedDate();
        date=String.format("%d-%02d-%02d", split[0], split[1], split[2]);

        db=new DailyDB(this);

        dailyData=(DailyData) FragmentDaily.getPreItemView().getTag();


        Toolbar toolbar=findViewById(R.id.toolbar);
        findId();
        toolbar.setTitle(date);
        setSupportActionBar(toolbar);
    }

    private void findId(){
        tvModifyDivide=findViewById(R.id.tv_modify_divide);
        tvSum=findViewById(R.id.tv_sum);
        editSum=findViewById(R.id.edit_sum);
        tvCategory=findViewById(R.id.tv_category);
        editCategory=findViewById(R.id.edit_category);
        tvClassification=findViewById(R.id.tv_classification);
        editClassification=findViewById(R.id.edit_classification);
        tvConnection=findViewById(R.id.tv_connection);
        editConnection=findViewById(R.id.edit_connection);
        tvMemo=findViewById(R.id.tv_memo);
        editMemo=findViewById(R.id.edit_memo);
        btnModify=findViewById(R.id.btn_modify);

        contentInit();
    }

    private void contentInit(){
        if(dailyData.getDivision().equals(DailyData.divisionSales)){
            tvSum.setText("매출금액");
            tvClassification.setText("매출분류");

        }else if(dailyData.getDivision().equals(DailyData.divisionPurchase)){
            tvSum.setText("매입금액");
            tvClassification.setText("매입분류");
        }
        tvModifyDivide.setText(dailyData.getDivision());
        editSum.setText(dailyData.getSales());
        editCategory.setText(dailyData.getCategory());
        editClassification.setText(dailyData.getClassification());
        editConnection.setText(dailyData.getConnection());
        editMemo.setText(dailyData.getMemo());
    }

    public void clickBtnModify(View v){
        dailyData=new DailyData(dailyData.getNo(), date, tvModifyDivide.getText().toString(), editSum.getText().toString(),
                editCategory.getText().toString(), editClassification.getText().toString(), editConnection.getText().toString(),
                editMemo.getText().toString());
        db.updateByNo(date, dailyData);
        finish();
    }
}
