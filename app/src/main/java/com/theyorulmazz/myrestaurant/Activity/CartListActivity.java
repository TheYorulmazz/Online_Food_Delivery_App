package com.theyorulmazz.myrestaurant.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.theyorulmazz.myrestaurant.Adaptor.CartListAdapter;
import com.theyorulmazz.myrestaurant.Helper.ManagementCart;
import com.theyorulmazz.myrestaurant.Interface.ChangeNumberItemsListener;
import com.theyorulmazz.myrestaurant.R;

import org.w3c.dom.Text;

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
        setContentView(R.layout.activity_cart_list_activity);
        
        managementCart=new ManagementCart(this);
        
        initView();
        initList();
        CalculateCart();
        bottomNavigation();
    }

    private void bottomNavigation(){
        FloatingActionButton floatingActionButton=findViewById(R.id.CartBtn);
        LinearLayout homeBtn=findViewById(R.id.homeBtn);
        TextView exitBtn=findViewById(R.id.exitBtn);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                startActivity(new Intent(CartListActivity.this,MainActivity.class));
            }
        });
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                startActivity(new Intent(CartListActivity.this,MainActivity.class));
            }
        });
        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                managementCart.getListCart().clear();
                adapter.notifyDataSetChanged();
                CalculateCart();
                startActivity(new Intent(CartListActivity.this,MainActivity.class));
                emptyTxt.setVisibility(View.VISIBLE);
                scrollView.setVisibility(View.GONE);
                Toast.makeText(CartListActivity.this, "Siparişiniz Onaylandı", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void initView(){
        recyclerViewList=findViewById(R.id.recyclerView);
        TotalFeeTxt=findViewById(R.id.TotalFeeTxt);
        taxTxt=findViewById(R.id.taxTxt);
        deliveryTxt=findViewById(R.id.deliveryTxt);
        totalTxt=findViewById(R.id.TotalTxt);
        emptyTxt=findViewById(R.id.emptyTxt);
        scrollView=findViewById(R.id.scrollView3);
        recyclerViewList=findViewById(R.id.CartView);
    }
    private void initList(){
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerViewList.setLayoutManager(linearLayoutManager);
        adapter=new CartListAdapter(managementCart.getListCart(), this, new ChangeNumberItemsListener() {
            @Override
            public void changed(){
                CalculateCart();
            }
        });

        recyclerViewList.setAdapter(adapter);
        if (managementCart.getListCart().isEmpty()){
            emptyTxt.setVisibility(View.VISIBLE);
            scrollView.setVisibility(View.GONE);
        }else {
            emptyTxt.setVisibility(View.GONE);
            scrollView.setVisibility(View.VISIBLE);
        }
    }
    private void CalculateCart(){
        double percentTax=0.02;

        double delivery=Math.round(managementCart.getTotalFee()*3)/100;
        tax=Math.round(managementCart.getTotalFee()*percentTax*100)/100;
        double total=Math.round((managementCart.getTotalFee()+tax+delivery)*100)/100;
        double itemTotal=Math.round(managementCart.getTotalFee()*100)/100;

        TotalFeeTxt.setText(itemTotal+"₺");
        taxTxt.setText(tax+"₺");
        deliveryTxt.setText(delivery+"₺");
        totalTxt.setText(total+"₺");
    }
}