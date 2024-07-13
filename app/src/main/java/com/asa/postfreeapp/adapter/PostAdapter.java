package com.asa.postfreeapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.asa.postfreeapp.R;
import com.asa.postfreeapp.models.response.PostsItem;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder>{
    private List<PostsItem> postsItemList;
    private Context context;
    private OnClickListener onClickListener;

    public PostAdapter(List<PostsItem> postsItemList, Context context) {
        this.postsItemList = postsItemList;
        this.context = context;
    }

    public PostAdapter(List<PostsItem> postsItemList, Context context, OnClickListener onClickListener) {
        this.postsItemList = postsItemList;
        this.context = context;
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.post_gird_card_item_layout,null,false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        PostsItem postsItem = postsItemList.get(position);
        if(postsItem.getTitle() != null){
            holder.title.setText(postsItem.getTitle().toString());
        }
        if(postsItem.getBody() != null){
            holder.body.setText(postsItem.getBody());
        }
        if(postsItem.getViews() != 0){
            holder.view.setText(""+postsItem.getViews());
        }
        if(postsItem.getReactions() != null){
            holder.like.setText(""+postsItem.getReactions().getLikes());
        }
        if(postsItem.getReactions() != null){
            holder.dislike.setText(""+postsItem.getReactions().getDislikes());
        }
        if(!postsItem.getTags().isEmpty()){
            TagAdapter tagAdapter = new TagAdapter(postsItem.getTags(), context);
            holder.recyclerViewTag.setAdapter(tagAdapter);
            holder.recyclerViewTag.setLayoutManager(new GridLayoutManager(context,1,RecyclerView.HORIZONTAL,false));
        }
        holder.postCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickListener.onClickCard(v, postsItem);
            }
        });
    }

    @Override
    public int getItemCount() {
        return postsItemList.size();
    }

    public static class PostViewHolder extends RecyclerView.ViewHolder{
        TextView title, body, like, dislike, view;
        RecyclerView recyclerViewTag;
        CardView postCard;
        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tvPostTitle);
            body = itemView.findViewById(R.id.tvPostBody);
            like = itemView.findViewById(R.id.tvPostLike);
            dislike = itemView.findViewById(R.id.tvPostDislike);
            view = itemView.findViewById(R.id.tvPostView);
            recyclerViewTag = itemView.findViewById(R.id.recyclerViewTags);
            postCard = itemView.findViewById(R.id.postCard);
        }
    }
    public interface OnClickListener{
        void onClickCard(View view, PostsItem postsItem);
    }
}
