package com.example.eshop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.eshop.adapter.ArticleAdapter;
import com.example.eshop.adapter.CategoryAdapter;
import com.example.eshop.model.Article;
import com.example.eshop.model.Category;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView categoryRecycler, articleRecycler;
    CategoryAdapter categoryAdapter;
    ArticleAdapter articleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category(1, "Games"));
        categoryList.add(new Category(2, "Sites"));
        categoryList.add(new Category(3, "Language"));
        categoryList.add(new Category(4, "Other"));
        setCategoryRecycler(categoryList);

        List<Article> articleList = new ArrayList<>();
        articleList.add(new Article(1, "java_2","Java\ndeveloper",
                "1 january", "littles", "#424345"));
        articleList.add(new Article(1, "python","Python\ndeveloper",
                "1 january", "littles", "#9FA52D"));
        //articleList.add(new Article(3, "Language"));
        //articleList.add(new Article(4, "Other"));
        setArticleRecycler(articleList);

    }

    private void setArticleRecycler(List<Article> articleList) {
        RecyclerView.LayoutManager layoutManager =
                new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        articleRecycler = findViewById(R.id.articleRecycler);
        articleRecycler.setLayoutManager(layoutManager);
        articleAdapter = new ArticleAdapter(this, articleList);
        articleRecycler.setAdapter(articleAdapter);
    }

    private void setCategoryRecycler(List<Category> categoryList) {
        RecyclerView.LayoutManager layoutManager =
                new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        categoryRecycler = findViewById(R.id.categoryRecycler);
        categoryRecycler.setLayoutManager(layoutManager);
        categoryAdapter = new CategoryAdapter(this, categoryList);
        categoryRecycler.setAdapter(categoryAdapter);
    }
}