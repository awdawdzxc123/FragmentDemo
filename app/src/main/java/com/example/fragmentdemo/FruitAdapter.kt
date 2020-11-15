package com.example.fragmentdemo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

class FruitAdapter(context: Context, private val resource: Int, data: List<News>) :
    ArrayAdapter<News>(context, resource, data) {

    private val resourceId =resource
    inner  class ViewHolder(
        val title: TextView,
        val time: TextView,
        val comment: TextView,
        val editor: TextView,
        val img: ImageView,
        val content: TextView
    )

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val viewHolder:ViewHolder
        val view: View
        if (convertView==null) {
            view = LayoutInflater.from(context).inflate(resourceId, parent, false)

            val title: TextView = view.findViewById(R.id.title)
            val time: TextView = view.findViewById(R.id.time)
            val comment: TextView = view.findViewById(R.id.comment)
            val editor: TextView = view.findViewById(R.id.editor)
            val img: ImageView = view.findViewById(R.id.img)
            val content: TextView = view.findViewById(R.id.content)
            viewHolder =ViewHolder(title, time, comment, editor,img,content)
            view.tag=viewHolder

        }else{
            view =convertView
            viewHolder=view.tag as ViewHolder
        }

        val fruit=getItem(position)
        if (fruit != null){
            viewHolder.title.text=fruit.title
            viewHolder.time.text=fruit.time
            viewHolder.comment.text=fruit.comment
            viewHolder.editor.text=fruit.editor
            viewHolder.img.setImageResource(fruit.img)
            viewHolder.content.text=fruit.content
        }
        return view
    }

//    fun  getTime():String{
//        val data = Date()
//        val dateFormat = SimpleDateFormat("HH:mm:ss", Locale.CHINA)
//        return dateFormat.format(data)
//    }
}