package com.yipl.labelstep.base

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar


public abstract class BaseActivity : AppCompatActivity() {

    protected lateinit var toolbar: Toolbar
    public lateinit var binding : ViewDataBinding

    abstract fun getLayout(): Int

    fun isDataBindingEnabled(): Boolean {
        return false
    }

    public fun isToolbarEnabled(): Boolean {
        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (!isDataBindingEnabled()) {
            setContentView(getLayout());
        } else {
            binding = DataBindingUtil.setContentView(this, getLayout());
        }
        if (isToolbarEnabled()) initializeToolbar();

    }

    public fun initializeToolbar() {
//        toolbar = findViewById (R.id.toolbar);
//        if (toolbar != null)
//            setSupportActionBar(toolbar);
    }
}