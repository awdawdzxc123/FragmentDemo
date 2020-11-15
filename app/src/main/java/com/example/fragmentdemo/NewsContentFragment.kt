package com.example.fragmentdemo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_ftiaozhuan.*

class NewsContentFragment:Fragment() {
    private lateinit var news: News
    companion object{
        const val KEY: String = "KEY"
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.activity_ftiaozhuan, container, false)
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (savedInstanceState != null) {
            savedInstanceState.getParcelable<News>(KEY)?.let { refresh(it) }
        }
    }
    fun refresh(name: News){
        ContentLayout.visibility=View.VISIBLE
        title.text=name.title
        time.text=name.time
        comment.text=name.comment
        editor.text=name.editor
        img.setImageResource(name.img)
        content.text=name.content
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        //这里存在NULL的情况，当Fragment没有新闻内容时旋转，要判断news是否已初始化
        if (::news.isInitialized) {
            outState.putParcelable(KEY, news)
        }
    }
}