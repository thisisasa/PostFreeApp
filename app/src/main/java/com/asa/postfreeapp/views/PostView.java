package com.asa.postfreeapp.views;

import com.asa.postfreeapp.models.response.PostsItem;

import java.util.List;

public interface PostView {
    void onLoading();
    void onMidingLoading();
    void onError(String message);
    void onSuccess(String message);
    void onGetPostSuccess(List<PostsItem> postsItemList);
    void onGetPostByIdSuccess(PostsItem data);
}
