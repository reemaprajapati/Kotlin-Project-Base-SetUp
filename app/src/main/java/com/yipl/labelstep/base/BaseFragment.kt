package com.yipl.labelstep.base

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


public abstract class BaseFragment : Fragment() {

    abstract fun getLayout(): Int

    protected lateinit var binding: ViewDataBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view: View
        if (isDataBindingEnabled()) {
            binding = DataBindingUtil.inflate(inflater, getLayout(), container, false)
            view = binding.root
        } else {
            view = inflater.inflate(getLayout(), container, false)
        }
        setHasOptionsMenu(true)
        return view

    }

    protected fun isDataBindingEnabled(): Boolean {
        return false
    }

}