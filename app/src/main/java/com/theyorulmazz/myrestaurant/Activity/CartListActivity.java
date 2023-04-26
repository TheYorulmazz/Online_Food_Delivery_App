package com.theyorulmazz.myrestaurant.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ScrollView;
import android.widget.TextView;

import com.theyorulmazz.myrestaurant.Helper.ManagementCart;
import com.theyorulmazz.myrestaurant.R;

public class CartListActivity extends AppCompatActivity {
private RecyclerView.Adapter adapter;
private  RecyclerView recyclerViewList;
private ManagementCart managementCart;
TextView TotalFeeTxt,taxTxt,deliveryTxt,totalTxt,emptyTxt;
private double tax;
private ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_list_avtivity);
        
        managementCart=new ManagementCart(this);
        
        initView();
    }

    private void initView(){
        recyclerViewList=findViewById(R.id.recyclerView);
        TotalFeeTxt=findViewById(R.id.TotalFeeTxt);
        taxTxt=findViewById(R.id.taxTxt);
        deliveryTxt=findViewById(R.id.deliveryTxt);
        totalTxt=findViewById(R.id.TotalTxt);
        emptyTxt=findViewById(R.id.emptyTxt);
        scrollView=findViewById(R.id.scrollView3);
    }
    private void initList(){
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerViewList.setLayoutManager(linearLayoutManager);

    }
}