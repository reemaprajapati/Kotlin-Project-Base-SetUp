package com.yipl.labelstep.base

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar


public abstract class BaseActivity : AppCompatActivity() {

    protected lateinit var toolbar: Toolbar

    protected lateinit var binding: ViewDataBinding

    abstract fun getLayout(): Int


    open fun isDataBindingEnabled(): Boolean {
        return false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (!isDataBindingEnabled()) {
            setContentView(getLayout());
        } else {
            binding = DataBindingUtil.setContentView(this, getLayout());
        }
    }

}