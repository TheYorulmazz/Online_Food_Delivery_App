package com.theyorulmazz.myrestaurant.Adaptor;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.theyorulmazz.myrestaurant.Domain.FoodDomain;
import com.theyorulmazz.myrestaurant.Helper.ManagementCart;
import com.theyorulmazz.myrestaurant.Interface.ChangeNumberItemsListener;
import com.theyorulmazz.myrestaurant.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CartListAdapter extends RecyclerView.Adapter<CartListAdapter.ViewHolder> {
    private ArrayList<FoodDomain> foodDomains;
    private ManagementCart managementCart;
    private ChangeNumberItemsListener changeNumberItemsListener;

    public CartListAdapter(ArrayList<FoodDomain> foodDomains, ManagementCart managementCart, ChangeNumberItemsListener changeNumberItemsListener){
        this.foodDomains = foodDomains;
        this.managementCart = managementCart;
        this.changeNumberItemsListener = changeNumberItemsListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position){

    }

    @Override
    public int getItemCount(){
        return foodDomains.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title,feeEachItem;
        ImageView pic,plusItem,minusItem;
        TextView totialEachItem, num;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            title=itemView.findViewById(R.id.titleCartTxt);
        }
    }
}
