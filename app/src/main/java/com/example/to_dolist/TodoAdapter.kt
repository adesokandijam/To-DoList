package com.example.to_dolist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TodoAdapter(private val to_do_list: List<Todo>, private val listener:OnItemClickListener) : RecyclerView.Adapter<TodoAdapter.ExampleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.to_do_list, parent, false)

        return ExampleViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {
        val currentItem = to_do_list[position]

        holder.imageView.setImageResource(currentItem.imageResource)
        holder.textView.text = currentItem.text
    }

    override fun getItemCount() = to_do_list.size


    inner class ExampleViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView), View.OnClickListener
    {
        val imageView: ImageView = itemView.findViewById(R.id.image_view)
        val textView:TextView = itemView.findViewById(R.id.textView)


        init
        {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position:Int = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }
    }

    interface OnItemClickListener
    {
        fun onItemClick(position: Int)
    }
}