package com.example.eshop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.eshop.model.Order;

public class ArticlePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_page);

        ConstraintLayout articleBg = findViewById(R.id.articleBg);
        ImageView articleImage = findViewById(R.id.articleImage);
        TextView articleTitleTextView = findViewById(R.id.articleTitleTextView);
        TextView articleDateText = findViewById(R.id.articleDateText);
        TextView articleLevelText = findViewById(R.id.articleLevelText);
        TextView articleDescription = findViewById(R.id.articleDescription);

        articleBg.setBackgroundColor(getIntent().getIntExtra("articleBg", 0));
        articleImage.setImageResource(getIntent().getIntExtra("articleImage", 0));
        articleTitleTextView.setText(getIntent().getStringExtra("articleTitle"));
        articleDateText.setText(getIntent().getStringExtra("articleDate"));
        articleLevelText.setText(getIntent().getStringExtra("articleLevel"));
        articleDescription.setText(getIntent().getStringExtra("articleText"));
    }
    public void addToCart(View view) {
        int item_id = getIntent().getIntExtra("articleId", 0);
        Order.items_id.add(item_id);
        Toast.makeText(this, "Article added!", Toast.LENGTH_LONG).show();
    }
}