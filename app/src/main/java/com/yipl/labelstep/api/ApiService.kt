package com.yipl.labelstep.api
import com.yipl.labelstep.data.API.STANDARD_LIST
import com.yipl.labelstep.data.API.SUPPLIER_LIST
import com.yipl.labelstep.data.entity.StandardsEntity
import com.yipl.labelstep.data.entity.SupplierEntity
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Header

interface ApiService {

//    @GET(".")
//    fun getJsonResponse(): Single<IpAddress>

//    @GET("/posts")
//    fun getPosts():Observable<List<PostEntity>>

    @GET(STANDARD_LIST)
    fun getStandards(@Header("Authorization") authHeader: String): Observable<StandardsEntity>

    @GET(SUPPLIER_LIST)
    fun getSuppliers(@Header("Authorization") authHeader: String): Observable<SupplierEntity>

}