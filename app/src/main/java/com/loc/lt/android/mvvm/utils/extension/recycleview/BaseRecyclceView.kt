package com.loc.lt.android.mvvm.utils.extension.recycleview

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


class BaseRecycleView<out T, VH : RecyclerView.ViewHolder>(
    data: List<T>, val onSuccess: ((t: ClickedItem) -> Unit)
) : RecyclerView.Adapter<VH>() {
    private var list: List<T> = ArrayList()

    init {
        this.list = data
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        TODO("Not yet implemented")
    }

    interface ClickedItem {
        fun itemClicked(position: Int, data: Any)

    }
}


//
//class MainAdapter(
//    private val users: ArrayList<User>
//) : RecyclerView.Adapter<MainAdapter.DataViewHolder>() {
//
//    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        fun bind(user: User) {
//            itemView.textViewUserName.text = user.name
//            itemView.textViewUserEmail.text = user.email
//            Glide.with(itemView.imageViewAvatar.context)
//                .load(user.avatar)
//                .into(itemView.imageViewAvatar)
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
//        DataViewHolder(
//            LayoutInflater.from(parent.context).inflate(
//                R.layout.item_layout, parent,
//                false
//            )
//        )
//
//    override fun getItemCount(): Int = users.size
//
//    override fun onBindViewHolder(holder: DataViewHolder, position: Int) =
//        holder.bind(users[position])
//
//    fun addData(list: List<User>) {
//        users.addAll(list)
//    }
//}