package com.example.fragmentdemo

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_news_content.*

class NewsContentActivity : AppCompatActivity() {
    companion object{
        fun actionStart(context: Context,news: News) {
            val intent=Intent(context,NewsContentActivity::class.java).apply {
                putExtra("news_data",news)
            }
            context.startActivity(intent)
        }


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_content)
        //获取转入的新闻内容对象
        val newsData=intent.getParcelableExtra<News>("news_data")
        if (newsData!=null){
        val fragment=NewsContent as NewsContentFragment
            fragment.refresh(newsData)
        }

        supportActionBar?.hide()//标题弃掉
    }

}