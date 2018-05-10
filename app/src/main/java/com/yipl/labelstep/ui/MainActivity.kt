package com.yipl.labelstep.ui

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.yipl.labelstep.R
import com.yipl.labelstep.data.model.Post
import com.yipl.labelstep.databinding.ActivityMainBinding
import com.yipl.labelstep.ui.adapter.ListsAdapter
import dagger.android.AndroidInjection
import dagger.android.DaggerActivity
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.internal.operators.observable.ObservableElementAt
import io.reactivex.rxkotlin.subscribeBy
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private val compositeDisposable by lazy { CompositeDisposable() }

    lateinit var binding: ActivityMainBinding
    lateinit var adapter: ListsAdapter
    @Inject
    lateinit var mainActivityViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)

        setContentView(R.layout.activity_main)
//        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        setUpRecyclerview()
//        compositeDisposable.add(mainActivityViewModel.showDataFromApi()
//                .subscribeBy(onSuccess = {
//                    Log.d("MainActivity", it.ip)
//                }, onError = {
//                    Log.d("MainActivity", it.message)
//                }))

        mainActivityViewModel.showPosts().observe(this, Observer<List<Post>> { list -> adapter.swapData(list!!) })

    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
        compositeDisposable.dispose()
    }

    fun setUpRecyclerview() {
        recyclerview.layoutManager = LinearLayoutManager(this)
        adapter = ListsAdapter(this)
        recyclerview.adapter = adapter
    }
}


