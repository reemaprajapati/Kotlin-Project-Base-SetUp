package com.yipl.labelstep.api
import com.yipl.labelstep.data.API.STANDARD_LIST
import com.yipl.labelstep.data.entity.PostEntity
import com.yipl.labelstep.data.entity.StandardsEntity
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiService {

//    @GET(".")
//    fun getJsonResponse(): Single<IpAddress>

//    @GET("/posts")
//    fun getPosts():Observable<List<PostEntity>>

    @GET(STANDARD_LIST)
    fun getStandards(): Observable<StandardsEntity>

}