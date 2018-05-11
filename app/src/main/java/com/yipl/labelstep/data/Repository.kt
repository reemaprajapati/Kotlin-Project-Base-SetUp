package com.yipl.labelstep.data

import android.arch.lifecycle.LiveData
import com.yipl.labelstep.api.ApiService
import com.yipl.labelstep.data.dao.PostDao
import com.yipl.labelstep.data.model.Post
import com.yipl.labelstep.data.model.PostEntity
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor(private val apiService: ApiService, private val dao: PostDao) {

    fun getPosts(): Observable<Boolean> =
            apiService.getPosts().map { t: List<PostEntity> ->
                //            run {
//                for (post in t) {
//                    dao.insertPosts(post)
//                }
//            }
                insert(t)
            }


    fun insert(post: List<PostEntity>): Boolean {
        for (item in post) {
            dao.insertPosts(item)
        }
        return true
    }

    fun showPosts(): LiveData<List<Post>> = dao.selectAll()
}