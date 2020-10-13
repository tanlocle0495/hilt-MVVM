package com.loc.lt.android.mvvm

import android.content.Intent
import android.os.Bundle
import com.loc.lt.android.mvvm.ui.base.BaseActivity
import com.loc.lt.android.mvvm.ui.example.ExampleActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn.setOnClickListener {
            startActivity(Intent(this@MainActivity, ExampleActivity::class.java))
        }
    }
}