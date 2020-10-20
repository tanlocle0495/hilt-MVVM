package com.loc.lt.android.mvvm.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.loc.lt.android.mvvm.R
import com.loc.lt.android.mvvm.databinding.ActivityMain2Binding
import com.loc.lt.android.mvvm.utils.extension.afterTextChanged

class LoginActivity : AppCompatActivity() {
    private val viewModel: LoginViewModel by viewModels()
    private lateinit var  binding :ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityMain2Binding>(this, R.layout.activity_main2)
            .also { binding = it }
        setupUI()
    }

    private fun setupUI() {
        binding.password.afterTextChanged {
         ///   viewModel.setPassword(it)
        }

        binding.btnLogin.setOnClickListener {
            viewModel.savePassword()
        }
    }

}