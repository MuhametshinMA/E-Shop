package com.example.eshop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.eshop.model.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_page);
        ListView ordersListView = findViewById(R.id.orderListView);
        List<String> articleTitle = new ArrayList<>();
        for (int i = 0; i < MainActivity.articleListAllCategory.size(); i++) {
            if (Order.items_id.contains(MainActivity.articleListAllCategory.get(i).getId())) {
                articleTitle.add(MainActivity.articleListAllCategory.get(i).getTitle());
            }
        }
        ordersListView.setAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, articleTitle));
    }
}