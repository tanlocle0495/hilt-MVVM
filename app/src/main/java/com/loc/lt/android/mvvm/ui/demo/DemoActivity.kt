package com.loc.lt.android.mvvm.ui.demo

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.loc.lt.android.mvvm.R
import com.loc.lt.android.mvvm.databinding.ActivityDemoBinding
import com.loc.lt.android.mvvm.ui.base.BaseActivity
import com.loc.lt.android.mvvm.utils.Status
import com.loc.lt.android.mvvm.utils.extension.recycleview.setLinearDivider
import com.loc.lt.android.mvvm.utils.extension.recycleview.setLinearLayout

class DemoActivity : BaseActivity() {

    private val viewModel: DemoViewModel by viewModels()
    private val myAdapter by lazy { DemoAdapter() }

    private lateinit var binding: ActivityDemoBinding
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_demo)
        setupUI()
        setupObserver()
    }

    private fun setupUI() {
        binding.recycleView.apply {
            setLinearLayout()
            setLinearDivider()
            adapter = myAdapter
        }
    }

    private fun setupObserver() {
        viewModel.users.observe(this, Observer {
            when (it.status) {
                Status.SUCCESS -> {
                    it.data?.let { data -> myAdapter.setData(items = data) }
                }
                Status.LOADING -> {
                }
                Status.ERROR -> {

                }
            }
        })
    }
}