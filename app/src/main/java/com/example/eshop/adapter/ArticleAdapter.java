package com.example.eshop.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eshop.R;
import com.example.eshop.model.Article;
import com.example.eshop.model.Category;

import java.util.List;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder> {

    Context context;
    List<Article> articleList;

    public ArticleAdapter(Context context, List<Article> articleList) {
        this.context = context;
        this.articleList = articleList;
    }

    @NonNull
    @Override
    public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View articleItems = LayoutInflater.from(context).inflate(R.layout.article_item, parent, false);
        return new ArticleAdapter.ArticleViewHolder(articleItems);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleViewHolder holder, int position) {
        holder.articleBg.setCardBackgroundColor(Color.parseColor(articleList.get(position).getColor()));
        int imageId = context.getResources().getIdentifier("ic_" + articleList.get(position).getImg(),
                "drawable", context.getPackageName());
        holder.articleImage.setImageResource(imageId);
        holder.articleTitle.setText(articleList.get(position).getTitle());
        holder.articleDate.setText(articleList.get(position).getDate());
        holder.articleLevel.setText(articleList.get(position).getLevel());
    }

    @Override
    public int getItemCount() {
        return articleList.size();
    }

    public static final class ArticleViewHolder extends RecyclerView.ViewHolder {

        CardView articleBg;
        ImageView articleImage;
        TextView articleTitle, articleDate, articleLevel;
        public ArticleViewHolder(@NonNull View itemView) {
            super(itemView);
            articleBg = itemView.findViewById(R.id.articleBg);
            articleImage = itemView.findViewById(R.id.articleImageView);
            articleTitle = itemView.findViewById(R.id.articleTitleTextView);
            articleDate = itemView.findViewById(R.id.articleDateTextView);
            articleLevel = itemView.findViewById(R.id.articleLevelTextView);
        }
    }
}
