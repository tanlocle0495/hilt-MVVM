package com.loc.lt.android.mvvm.ui.example

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.loc.lt.android.mvvm.R
import com.loc.lt.android.mvvm.databinding.ActivityExampleBinding
import com.loc.lt.android.mvvm.ui.base.BaseActivity
import com.loc.lt.android.mvvm.ui.demo.viewmodel.ExampleViewModel
import com.loc.lt.android.mvvm.ui.example.adapter.ExampleAdapter
import com.loc.lt.android.mvvm.utils.Status
import com.loc.lt.android.mvvm.utils.extension.gone
import com.loc.lt.android.mvvm.utils.extension.recycleview.setLinearDivider
import com.loc.lt.android.mvvm.utils.extension.recycleview.setLinearLayout
import com.loc.lt.android.mvvm.utils.extension.visible
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ExampleActivity : BaseActivity() {

    private val viewModel: ExampleViewModel by viewModels()
    private val myAdapter by lazy { ExampleAdapter() }
    private lateinit var binding: ActivityExampleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_example)
        DataBindingUtil.setContentView<ActivityExampleBinding>(this, R.layout.activity_example)
            .also {
                binding = it
            }
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
                    binding.progressBar.gone()
                    it.data?.let { data -> myAdapter.setData(data) }
                    binding.refresh.visible()
                }
                Status.LOADING -> {
                    binding.progressBar.visible()
                }
                Status.ERROR -> {
                    binding.progressBar.gone()
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }
            }
        })
    }
}