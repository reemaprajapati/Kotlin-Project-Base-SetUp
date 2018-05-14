package com.yipl.labelstep.ui

import android.arch.lifecycle.Observer
import android.databinding.ViewDataBinding
import android.os.Bundle

import android.support.v7.widget.LinearLayoutManager
import com.facebook.stetho.Stetho
import com.yipl.labelstep.R
import com.yipl.labelstep.base.BaseActivity
import com.yipl.labelstep.data.model.Post
import com.yipl.labelstep.databinding.ActivityMainBinding
import com.yipl.labelstep.ui.adapter.ListsAdapter
import dagger.android.AndroidInjection
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity() {

    override fun isDataBindingEnabled(): Boolean {
        return true
    }

    override fun getLayout(): Int {
        return R.layout.activity_main
    }

    fun  getBinding(): ActivityMainBinding {
        return binding as ActivityMainBinding
    }


    lateinit var adapter: ListsAdapter
    @Inject
    lateinit var mainActivityViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        Stetho.initializeWithDefaults(this);
//        setContentView(R.layout.activity_main)

        setUpRecyclerview()
        getBinding().buttonGetdata.setOnClickListener({
            mainActivityViewModel.getPosts().subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe()
        })
        showPosts()
    }

    fun setUpRecyclerview() {
        getBinding().recyclerview.layoutManager = LinearLayoutManager(this)
        adapter = ListsAdapter(this)
        getBinding().recyclerview.adapter = adapter
    }

    fun showPosts() {
        mainActivityViewModel.showPosts().observe(this, Observer<List<Post>> { list -> adapter.swapData(list!!) })
    }

}


