package com.example.fragmentdemo

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat
import java.util.*

class Mainxinwen(private val fruitList: List<Mainceshi>): RecyclerView.Adapter<Mainxinwen.ViewHolder>() {
    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val name_textVie: TextView=view.findViewById(R.id.name_textVie)
        val imageID: ImageView=view.findViewById(R.id.imageView5)
        val xid: TextView=view.findViewById(R.id.xid)
        val cun: TextView=view.findViewById(R.id.cun)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.xinwen_content, parent, false)
        val viewHashtable =ViewHolder(view)
//        viewHashtable.name_textVie.setOnClickListener { Toast.makeText(parent.context,"你点击了子视图", Toast.LENGTH_SHORT).show() }
//        viewHashtable.imageID.setOnClickListener { Toast.makeText(parent.context,"你点击图片", Toast.LENGTH_SHORT).show() }
//        viewHashtable.cun.setOnClickListener { Toast.makeText(parent.context,"你点击评价", Toast.LENGTH_SHORT).show() }
//        viewHashtable.xid.setOnClickListener { Toast.makeText(parent.context,"你点击时间", Toast.LENGTH_SHORT).show() }
//        viewHashtable.itemView.setOnClickListener {
//            val  intent = Intent(parent.context,)
//        }
        //跳转页面获取他的子视图
        viewHashtable.name_textVie.setOnClickListener{
            val intent = Intent(parent.context,NewsContentActivity::class.java)
            parent.context.startActivity(intent)

        }
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val fruit =fruitList[position]
        holder.name_textVie.text = fruit.name_textVie
        holder.imageID.setImageResource(fruit.imageView5)
       holder.xid.text=getTime()
        holder.cun.text=fruit.cun
    }
    fun  getTime():String{
        val data = Date()
        val dateFormat = SimpleDateFormat("HH:mm:ss", Locale.CHINA)
        return dateFormat.format(data)
    }
    override fun getItemCount()=fruitList.count()

}