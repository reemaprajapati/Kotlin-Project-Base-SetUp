package com.yipl.labelstep.data

import android.arch.lifecycle.LiveData
import com.yipl.labelstep.api.ApiService
import com.yipl.labelstep.api.model.IpAddress
import com.yipl.labelstep.data.model.Post
import io.reactivex.Single

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor(private val apiService: ApiService) {

    fun getDataFromApi(): Single<IpAddress> = apiService.getJsonResponse()

    fun getPosts(): LiveData<List<Post>> = apiService.getPosts()
}