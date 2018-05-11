package com.yipl.labelstep.ui

import android.databinding.BaseObservable
import android.databinding.Bindable
import com.yipl.labelstep.data.model.Post

class PostViewModel : BaseObservable() {
    lateinit var post: Post
    @Bindable
    fun getTitle(): String {
        return post.title
    }

    @Bindable
    fun getBody():String{
        return post.body
    }
}