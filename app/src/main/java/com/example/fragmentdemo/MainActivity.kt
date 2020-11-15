package com.example.fragmentdemo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity() {
    //标记单双页面,false为单面,true为双页面
    private var isTwoPane=false
    private val newsList = ArrayList<News>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //判断单双页面
        isTwoPane =NewsContentTwoPane!=null
        supportActionBar?.hide()//标题弃掉
        initNewsList()
        RecyclerViewTest.layoutManager= LinearLayoutManager(this)
        val adapter =NewsAdapter(newsList)
        RecyclerViewTest.adapter =adapter

    }
    private fun initNewsList() {
        repeat(1) {
            newsList.add(
                News("","","",R.drawable.img_4,"","","Win10升级控制面板不对劲,教你找回经典界面11444444444444444444444444444444444444444444444","10:21","888评",R.drawable.img_4)
            )

        }
    }


    inner class NewsAdapter(private val newsList: ArrayList<News>):RecyclerView.Adapter<NewsAdapter.ViewHolder>(){
        inner class  ViewHolder(view:View):RecyclerView.ViewHolder(view) {
            val name_textVie: TextView = view.findViewById(R.id.name_textVie)
            val xid: TextView = view.findViewById(R.id.xid)
            val cun: TextView = view.findViewById(R.id.cun)
            val imageView5: ImageView = view.findViewById(R.id.imageView5)
    }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.xinwen_content, parent, false)
            val viewHolder = ViewHolder(view)
            viewHolder.name_textVie.setOnClickListener {
                //获取点击的项
                val Mainceshi = newsList[viewHolder.adapterPosition]
                if (isTwoPane) {
                    val fragment = NewsContentTwoPane as NewsContentFragment
                    fragment.refresh(Mainceshi)
                } else {
                    NewsContentActivity.actionStart(parent.context, Mainceshi)
                }
            }
            return viewHolder
        }
        override fun onBindViewHolder(holder: ViewHolder, position: Int) {

            val news = newsList[position]
           holder.name_textVie.text =news.name_textVie
            holder.cun.text =news.cun
            holder.xid.text=getTime()
            holder.imageView5.setImageResource(news.imageView5)
        }
        fun  getTime():String{
            val data = Date()
            val dateFormat = SimpleDateFormat("HH:mm:ss", Locale.CHINA)
            return dateFormat.format(data)
        }
         override   fun getItemCount() = newsList.size
    }
}