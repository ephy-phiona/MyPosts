package dev.phiona.myposts

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.phiona.myposts.databinding.RetrofitListItemBinding

class RetrofitRvAdapter(var postList: List<Post>
) : RecyclerView.Adapter<RetrofitRvAdapter.RetrofitViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RetrofitViewHolder {
        var bindingView =
            RetrofitListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RetrofitViewHolder(bindingView)
    }

    override fun onBindViewHolder(holder: RetrofitViewHolder, position: Int) {
        var currentItem = postList.get(position)
        val context = holder.itemView.context


        with(holder.bindingView) {
//            tvId.text = currentItem.Id
            tvBody.text = currentItem.body
//            tvTittle.text = currentItem.Tittle
            tvUserId.text = currentItem.userId

            val context=holder.itemView.context
            cvContacts.setOnClickListener{
                val intent=Intent(context,CommentActivity::class.java)
                intent.putExtra("POST_ID", currentItem.id)
                context.startActivity(intent)
            }
        }

    }

    override fun getItemCount(): Int {
        return postList.size
    }

class RetrofitViewHolder(var bindingView: RetrofitListItemBinding) :
    RecyclerView.ViewHolder(bindingView.root) {

}
}