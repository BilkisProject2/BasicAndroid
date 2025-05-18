package com.example.androidpractice.RecModuleofcurd

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.example.androidpractice.R
import com.example.androidpractice.model.adapterdc

class RecAdapter(var item:ArrayList<adapterdc>):RecyclerView.Adapter<RecAdapter.Viewholder>() {
    lateinit var mlistner:onitemclicklistner
   interface onitemclicklistner  {
       fun onitemclick(position: Int)
   }

    fun setonitemclicklistner(listener:onitemclicklistner){
        mlistner= listener
    }

    class Viewholder(item:View, listener: onitemclicklistner):RecyclerView.ViewHolder(item) {
        var namess = item.findViewById<TextView>(R.id.textView)
        var surname = item.findViewById<TextView>(R.id.textView2)
        var imges= item.findViewById<ImageView>(R.id.imge)
        init {
            item.setOnClickListener {
                listener.onitemclick(adapterPosition)
            }
        }
    }
    fun deleteItem(position: Int) {
        item.removeAt(position)
        notifyItemRemoved(position)
    }

    fun editdata(position: Int, modeloflist: adapterdc){
        item[position]= modeloflist

        notifyItemChanged(position)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
var li = LayoutInflater.from(parent.context).inflate(R.layout.sample,parent,false)
        return  Viewholder(li,mlistner)
    }

    override fun getItemCount(): Int {
return  item.size
    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
var item = item[position]
        holder.namess.text=item.name
        holder.surname.text= item.surname
        holder.imges.setImageResource(item.img)
    }
}