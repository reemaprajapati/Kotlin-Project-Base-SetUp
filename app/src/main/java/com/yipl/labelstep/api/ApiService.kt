package com.yipl.labelstep.api
import android.arch.lifecycle.LiveData
import com.yipl.labelstep.api.model.IpAddress
import com.yipl.labelstep.data.model.Post
import com.yipl.labelstep.data.model.PostEntity
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET

interface ApiService {

//    @GET(".")
//    fun getJsonResponse(): Single<IpAddress>

    @GET("/posts")
    fun getPosts():Observable<List<PostEntity>>


}