package com.example.soomin.firstseminar

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.RelativeLayout
import com.example.soomin.firstseminar.db.SharedPreferenceController
import kotlinx.android.synthetic.main.activity_splash.*
import kotlinx.android.synthetic.main.toolbar_main.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.startActivityForResult
import org.jetbrains.anko.toast

class SplashActivity : AppCompatActivity() {
    val REQUEST_LOGIN_CODE = 24

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
/*
        btnMainLogin.setOnClickListener {
            // 기본
//            val intent = Intent(this, LoginActivity::class.java)
//            intent.putExtra("id", 1)
//            startActivity(intent)

            // anko
//            startActivity<LoginActivity>()

            startActivityForResult<LoginActivity>(REQUEST_LOGIN_CODE) // LoginActivity
        }

        btnMainClose.setOnClickListener {
            finish()
        }

*/
        // toolbar 설정
        configureTitleBar()

        // mainTab 설정
        configureMainTab()

        // 툴바 로그인 로그아웃 이미지 바꾸기
        img_toolbar_main_log.setOnClickListener {
            // 자동로그인이 되어있지 않은 상태라면
            if (SharedPreferenceController.getUserId(this) == "" ) {
                startActivity<LoginActivity>() // toolbar의 로그인 버튼을 눌렀을 때, 로그인 액티비티로 이동하도록
            }
            else { // 자동 로그인이 되어있는 상태라면
                // 현재 SharedPreferences에 저장되어 있는 값들을 모두 삭제한다.
                SharedPreferenceController.clearUID(this)
                // 하고 다시 configureTitleBar
                configureTitleBar()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_LOGIN_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                val login_id = data!!.getStringExtra("login_id")

                toast("${login_id}님, 환영합니다!")
            }
        }
    }

    // onResume은 액티비티가 최상단에 띄워질 때마다 호출된다.
    override fun onResume() {
        super.onResume()
        configureTitleBar()
    }

    // Toolbar의 로그인/로그아웃 버튼 이미지 설정
    private fun configureTitleBar() {
        if (SharedPreferenceController.getUserId(this) == "") {
            img_toolbar_main_log.isSelected = false
        }
        else {
            img_toolbar_main_log.isSelected = true
        }
    }

    //
    private fun configureMainTab() {
        vp_main_product.adapter = ProductMainPagerAdapter(supportFragmentManager, 3)
        vp_main_product.offscreenPageLimit = 2
        tl_main_category.setupWithViewPager(vp_main_product)

        val navCategoryMainLayout: View =
            (this.getSystemService(android.content.Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater)
                .inflate(R.layout.navigation_category_main, null, false)
        tl_main_category.getTabAt(0)!!.customView =
                navCategoryMainLayout.findViewById(R.id.rl_nav_category_main_all) as RelativeLayout
        tl_main_category.getTabAt(1)!!.customView =
                navCategoryMainLayout.findViewById(R.id.rl_nav_category_main_new) as RelativeLayout
        tl_main_category.getTabAt(2)!!.customView =
                navCategoryMainLayout.findViewById(R.id.rl_nav_category_main_end) as RelativeLayout

        vp_main_slider.adapter = SliderMainPagerAdapter(supportFragmentManager, 3)
        vp_main_slider.offscreenPageLimit = 2
        tl_main_indicator.setupWithViewPager(vp_main_slider)
    }

}
//
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//
//        if(requestCode ==REQUEST_CODE_REQUEST_LOGIN) {
//            if(resultCode == Activity.RESULT_OK) {
//                Log.v("activityResult", "success")
//                val id = data!!.getStringExtra("id")
//
//                toast("${id}님, 환영합니다")
//
//            }
//        }
//
//    }
//
//    override fun onResume() {
//        super.onResume()
//
//        configureTitleBar()
//    }
//

