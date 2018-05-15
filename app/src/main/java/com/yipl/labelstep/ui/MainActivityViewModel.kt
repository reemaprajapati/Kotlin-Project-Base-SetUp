package com.yipl.labelstep.ui

import android.arch.lifecycle.LiveData
import com.yipl.labelstep.data.Repository
import com.yipl.labelstep.data.entity.StandardsEntity
import com.yipl.labelstep.data.entity.SupplierEntity
import com.yipl.labelstep.util.SchedulerProvider
import io.reactivex.Observable

class MainActivityViewModel (private val repository: Repository, private val schedulerProvider: SchedulerProvider) {
//
//    fun getPosts(): Observable<Boolean> = repository.getPosts()
//
//    fun showPosts(): LiveData<List<Post>> = repository.showPosts()

    fun getStandards() : Observable<StandardsEntity> = repository.getStandards()
    fun getSuppliers() : Observable<SupplierEntity> = repository.getSuppliers()


}