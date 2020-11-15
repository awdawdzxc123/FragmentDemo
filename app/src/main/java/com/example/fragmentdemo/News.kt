package com.example.fragmentdemo

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * title:新闻标题
 * time:发布时间
 * comment:评论数
 * img新闻配图
 * editor:主编
 * content:新闻内容
 */
@Parcelize
class News (
    val title:String,
    val time:String,
    val comment:String,
    val img:Int,
    val editor:String,
    val content:String,
    val name_textVie:String,val xid:String,val cun:String,val imageView5: Int
) :Parcelable