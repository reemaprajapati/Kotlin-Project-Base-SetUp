package com.yipl.labelstep.ui

import android.os.Bundle
import android.util.Log
import com.facebook.stetho.Stetho
import com.yipl.labelstep.R
import com.yipl.labelstep.base.BaseActivity
import com.yipl.labelstep.data.AppPreferences
import com.yipl.labelstep.databinding.ActivityMainBinding
import dagger.android.AndroidInjection
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    lateinit var appPreferences: AppPreferences

    override fun isDataBindingEnabled(): Boolean {
        return true
    }

    override fun getLayout(): Int {
        return R.layout.activity_main
    }

    fun getBinding(): ActivityMainBinding {
        return binding as ActivityMainBinding
    }

    //    lateinit var adapter: ListsAdapter
    @Inject
    lateinit var mainActivityViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        Stetho.initializeWithDefaults(this);
        appPreferences.example = "Test"

//        setUpRecyclerview()
        getBinding().buttonGetdata.setOnClickListener({
            Log.e("MainActivity", appPreferences.example);
//            mainActivityViewModel.getPosts().subscribeOn(Schedulers.io())
//                    .observeOn(AndroidSchedulers.mainThread())
//                    .subscribe()


        })
//        showPosts()
    }

//    fun setUpRecyclerview() {
//        getBinding().recyclerview.layoutManager = LinearLayoutManager(this)
//        adapter = ListsAdapter(this)
//        getBinding().recyclerview.adapter = adapter
//    }
//
//    fun showPosts() {
//        mainActivityViewModel.showPosts().observe(this, Observer<List<Post>> { list -> adapter.swapData(list!!) })
//    }

}


