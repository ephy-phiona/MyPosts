package dev.phiona.myposts

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.phiona.myposts.databinding.CommentListItemBinding


class CommentsRvAdapter (var commentsList: List<Post>
) : RecyclerView.Adapter<CommentsRvAdapter.CommentsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentsViewHolder {
        var bindingView =
            CommentListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CommentsViewHolder(bindingView)
    }

    override fun onBindViewHolder(holder: CommentsViewHolder, position: Int) {
        var currentItem = commentsList.get(position)
        val context = holder.itemView.context


        with(holder.bindingView) {
//            tvId.text = currentItem.Id
            tvCommentBody.text = currentItem.body
//            tvTittle.text = currentItem.Tittle
            tvUserName.text = currentItem.userId

            val context=holder.itemView.context
            cvComments.setOnClickListener{
                val intent= Intent(context, CommentActivity::class.java)
                intent.putExtra("COMMENT_ID", currentItem.id)
                context.startActivity(intent)
            }
        }

    }

    override fun getItemCount(): Int {
        return commentsList.size
    }

    class CommentsViewHolder(var bindingView: CommentListItemBinding) :
        RecyclerView.ViewHolder(bindingView.root) {

    }
}

