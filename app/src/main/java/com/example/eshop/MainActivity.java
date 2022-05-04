package com.example.eshop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.eshop.adapter.ArticleAdapter;
import com.example.eshop.adapter.CategoryAdapter;
import com.example.eshop.model.Article;
import com.example.eshop.model.Category;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView categoryRecycler, articleRecycler;
    CategoryAdapter categoryAdapter;
    static ArticleAdapter articleAdapter;
    static List<Article> articleList;
    static List<Article> articleListAllCategory;
    ImageView filterImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        filterImageView = findViewById(R.id.filterImageView);
        filterImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAllArticles();
            }
        });

        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category(1, "Games"));
        categoryList.add(new Category(2, "Sites"));
        categoryList.add(new Category(3, "Language"));
        categoryList.add(new Category(4, "Other"));
        setCategoryRecycler(categoryList);

        articleList = new ArrayList<>();
        articleListAllCategory = new ArrayList<>();
        articleList.add(new Article(1, 3,"java_2","Java\ndeveloper",
                "1 january", "littles", "#424345", getString(R.string.article_java_description)));
        articleList.add(new Article(2, 3,"python","Python\ndeveloper",
                "30 january", "littles", "#9FA52D", getString(R.string.article_python_description)));
        articleList.add(new Article(3, 2,"node_js","Node JS\ndeveloper",
                "15 february", "littles", "#BB950E", getString(R.string.article_node_description)));
        articleList.add(new Article(4, 1,"unity","Unity\ndeveloper",
                "28 february", "littles", "#E18989", getString(R.string.article_unity_description)));
        articleList.add(new Article(5, 2,"full_stack","Full Stack\ndeveloper",
                "1 march", "middle", "#2C4994", getString(R.string.article_full_stack_description)));
        articleList.add(new Article(6, 2,"back_end","Back-End\ndeveloper",
                "15 march", "littles", "#40B5E7", getString(R.string.article_back_end_description)));
        articleListAllCategory.addAll(articleList);
        setArticleRecycler(articleList);
    }

    public void openShoppingCart(View view){
        Intent intent = new Intent(this, OrderPage.class);
        startActivity(intent);
    }

    private void showAllArticles() {
        articleList.clear();
        articleList.addAll(articleListAllCategory);
        articleAdapter.notifyDataSetChanged();
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

    public static void showCoursesByCategory(int category){
        List<Article> filterArticles = new ArrayList<>();
        for (int i = 0; i < articleListAllCategory.size(); i++) {
            if (articleListAllCategory.get(i).getCategory() == category) {
                filterArticles.add(articleListAllCategory.get(i));
            }
        }
        articleList.clear();
        articleList.addAll(filterArticles);
        articleAdapter.notifyDataSetChanged();
    }
}