package com.yipl.labelstep.ui

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
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

class MainActivity : AppCompatActivity() {
//
//    override fun getLayout(): Int {
//        return R.layout.activity_main
//    }


    lateinit var adapter: ListsAdapter
    @Inject
    lateinit var mainActivityViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        Stetho.initializeWithDefaults(this);
        setContentView(R.layout.activity_main)
        setUpRecyclerview()
        button_getdata.setOnClickListener(View.OnClickListener {
            mainActivityViewModel.getPosts().subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe()
        })
        showPosts()

    }
    fun setUpRecyclerview() {
        recyclerview.layoutManager = LinearLayoutManager(this)
        adapter = ListsAdapter(this)
        recyclerview.adapter = adapter
    }

    fun showPosts() {
        mainActivityViewModel.showPosts().observe(this, Observer<List<Post>> { list -> adapter.swapData(list!!) })
    }

}


