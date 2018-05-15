package com.yipl.labelstep.data

import android.content.Context
import android.net.ConnectivityManager
import com.yipl.labelstep.api.ApiService
import com.yipl.labelstep.data.dao.DatabaseDao
import com.yipl.labelstep.data.entity.StandardsEntity
import com.yipl.labelstep.exception.NetworkConnectionException
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class Repository @Inject constructor(private val context: Context, private val apiService: ApiService, private val dao: DatabaseDao) {

    fun getStandards(): Observable<StandardsEntity> {
        if (isThereInternetConnection()) {
            return apiService.getStandards("Bearer "+ "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOjI2LCJpc3MiOiJodHRwOi8vbHMuc3RhZ2luZy55aXBsLmNvbS5ucC8vYXBpL2xvZ2luIiwiaWF0IjoxNTI2MzYyODgzLCJleHAiOjE1MjY0NDkyODMsIm5iZiI6MTUyNjM2Mjg4MywianRpIjoiUjZJNFVyZWNrUUxlRDZ3ZiJ9.ugLzN92A6DuZ9hAxZPNOUQacQCJM-dGw7qVCQySyxAU")
                    .doOnNext { standardEntity: StandardsEntity? ->
                        run {
                            for (entity in standardEntity!!.data) {
                                dao.insertStandard(entity)
                                for (criteria in entity.criteriaList){
                                    dao.insertCriteria(criteria)
                                }
                            }
                        }
                    }
                    .doOnError { t: Throwable? -> t!!.printStackTrace() }
        } else run { return Observable.error(NetworkConnectionException()) }
    }

//    fun getPosts(): Observable<Boolean> =
//            apiService.getPosts().map { t: List<PostEntity> ->
//                //            run {
////                for (post in t) {
////                    dao.insertPosts(post)
////                }
////            }
//                insert(t)
//            }
//
//
//    fun insert(post: List<PostEntity>): Boolean {
//        for (item in post) {
//            dao.insertPosts(item)
//        }
//        return true
//    }
//
//    fun showPosts(): LiveData<List<Post>> = dao.selectAll()


    fun isThereInternetConnection(): Boolean {
        val isConnected: Boolean
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        isConnected = networkInfo != null && networkInfo.isConnectedOrConnecting

        return isConnected
    }

}