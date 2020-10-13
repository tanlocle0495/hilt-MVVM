package com.loc.lt.android.mvvm.utils.extension.recycleview

import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


fun RecyclerView.setLinearLayout() {
    layoutManager = LinearLayoutManager(this.context)
}

fun RecyclerView.setLinearDivider() {
    this.addItemDecoration(
        DividerItemDecoration(
            this.context,
            (this.layoutManager as LinearLayoutManager).orientation
        )
    )
}