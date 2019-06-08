package com.example.soomin.firstseminar

import android.content.Context
import android.graphics.drawable.Drawable
import android.support.v4.view.PagerAdapter
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide

class ImageAdapter(private val ctx : Context, private val imageList : ArrayList<Int>) : PagerAdapter(){
    override fun isViewFromObject(p0: View, p1: Any): Boolean {
        return p0 == p1
    }

    override fun getCount(): Int = imageList.size

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        var img = ImageView(ctx)
        img.scaleType = ImageView.ScaleType.CENTER
        img.setBackgroundResource(imageList[position])
        container.addView(img, 0)

        return img
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as ImageView)
    }
}