package io.github.towor.mvvmjetpacktraining.memoList

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.github.towor.mvvmjetpacktraining.R
import io.github.towor.mvvmjetpacktraining.data.Memo
import kotlinx.android.synthetic.main.recyclerview_row.view.*

class MemoListAdapter (context: Context): RecyclerView.Adapter<MemoListAdapter.MemoViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var memos = emptyList<Memo>()

    class MemoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val memoItemView = itemView.findViewById<TextView>(R.id.tv_memo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemoViewHolder {
        val itemView = inflater.inflate(R.layout.recyclerview_row, parent, false)
        return MemoViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return memos.size
    }

    override fun onBindViewHolder(holder: MemoViewHolder, position: Int) {
        val current = memos[position]
        holder.memoItemView.text = current.memo
    }

    fun setMemos(memos: List<Memo>){
        this.memos = memos
        notifyDataSetChanged()
    }
}