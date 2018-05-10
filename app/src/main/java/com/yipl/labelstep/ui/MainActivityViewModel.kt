package com.yipl.labelstep.ui

import android.arch.lifecycle.LiveData
import com.yipl.labelstep.api.model.IpAddress
import com.yipl.labelstep.data.Repository
import com.yipl.labelstep.data.model.Post
import com.yipl.labelstep.util.SchedulerProvider
import io.reactivex.Single

class MainActivityViewModel(private val repository: Repository, private val schedulerProvider: SchedulerProvider) {

    fun showDataFromApi(): Single<IpAddress> = repository.getDataFromApi()
            .compose(schedulerProvider.getSchedulersForSingle())

    fun showPosts():LiveData<List<Post>> = repository.getPosts()
}