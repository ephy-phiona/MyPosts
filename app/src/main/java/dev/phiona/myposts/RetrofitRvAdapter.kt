package dev.phiona.myposts

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.phiona.myposts.databinding.RetrofitListItemBinding

class RetrofitRvAdapter(var context: Context, var postList: List<Post>
) : RecyclerView.Adapter<RetrofitViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RetrofitViewHolder {
        var bindingView =
            RetrofitListItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return RetrofitViewHolder(bindingView)
    }

    override fun onBindViewHolder(holder: RetrofitViewHolder, position: Int) {
        var currentItem = postList.get(position)
//        val context = holder.itemView.context

        with(holder.bindingView) {
            tvId.text = currentItem.Id
            tvBody.text = currentItem.userId
            tvTittle.text = currentItem.Tittle
            tvBody.text = currentItem.Body
        }

    }

    override fun getItemCount(): Int {
        return postList.size
    }
}

class RetrofitViewHolder(var bindingView: RetrofitListItemBinding) :
    RecyclerView.ViewHolder(bindingView.root) {

}