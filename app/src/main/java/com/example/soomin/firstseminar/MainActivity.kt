package com.example.soomin.firstseminar

import android.content.Intent
import android.graphics.drawable.Drawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.OrientationHelper
import android.util.Log
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"

    private val imageList = ArrayList<Int>()

    private val popularList = ArrayList<ToonData>()
    private val newList = ArrayList<ToonData>()
    private val finishList = ArrayList<ToonData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.v(TAG, "oncreate")


        imageList.add(R.drawable.bg_red)
        imageList.add(R.drawable.bg_green)
        imageList.add(R.drawable.bg_blue)

        setData()

        setViewpager(imageList)

        setRecyclerView()
    }

    private fun setData() {
        for(i in 1..4) {
            popularList.add(ToonData("인기 $i"))
            newList.add(ToonData("신규 $i"))
            finishList.add(ToonData("완결 $i"))
        }
    }

    private fun setRecyclerView() {
        rv_main_act_popular.adapter = ToonRecyclerAdapter(this, popularList)
        rv_main_act_popular.layoutManager = LinearLayoutManager(this, OrientationHelper.VERTICAL, false)

        rv_main_act_new.adapter = ToonRecyclerAdapter(this, newList)
        rv_main_act_new.layoutManager = LinearLayoutManager(this, OrientationHelper.VERTICAL, false)

        rv_main_act_finish.adapter = ToonRecyclerAdapter(this, finishList)
        rv_main_act_finish.layoutManager = LinearLayoutManager(this, OrientationHelper.VERTICAL, false)
    }

    private fun setViewpager(imgList : ArrayList<Int>) {
        vp_main_act.adapter = ImageAdapter(this, imgList)

        vp_main_act.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(p0: Int) {

            }

            override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {

            }

            override fun onPageSelected(p0: Int) {
                when(p0) {
                    0 -> {
                        dot1.setBackgroundResource(R.drawable.viewpager_dot_yellow)
                        dot2.setBackgroundResource(R.drawable.viewpager_dot_white)
                        dot3.setBackgroundResource(R.drawable.viewpager_dot_white)
                    }

                    1 -> {
                        dot1.setBackgroundResource(R.drawable.viewpager_dot_white)
                        dot2.setBackgroundResource(R.drawable.viewpager_dot_yellow)
                        dot3.setBackgroundResource(R.drawable.viewpager_dot_white)
                    }

                    2 -> {
                        dot1.setBackgroundResource(R.drawable.viewpager_dot_white)
                        dot2.setBackgroundResource(R.drawable.viewpager_dot_white)
                        dot3.setBackgroundResource(R.drawable.viewpager_dot_yellow)
                    }
                }
            }
        })
    }


}
