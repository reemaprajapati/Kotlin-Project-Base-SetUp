package com.yipl.labelstep.ui

import android.arch.lifecycle.LiveData
import com.yipl.labelstep.api.model.IpAddress
import com.yipl.labelstep.data.Repository
import com.yipl.labelstep.data.dao.PostDao
import com.yipl.labelstep.data.model.Post
import com.yipl.labelstep.util.SchedulerProvider
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class MainActivityViewModel(private val repository: Repository, private val schedulerProvider: SchedulerProvider) {

    fun getPosts(): Observable<Boolean> = repository.getPosts()

    fun showPosts(): LiveData<List<Post>> = repository.showPosts()
}