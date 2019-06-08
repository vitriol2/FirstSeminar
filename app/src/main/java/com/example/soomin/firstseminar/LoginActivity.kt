package com.example.soomin.firstseminar

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.soomin.firstseminar.db.SharedPreferenceController
import kotlinx.android.synthetic.main.activity_login.*
import net.yslibrary.android.keyboardvisibilityevent.KeyboardVisibilityEvent
import net.yslibrary.android.keyboardvisibilityevent.KeyboardVisibilityEventListener
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.startActivityForResult
import org.jetbrains.anko.toast
import java.text.SimpleDateFormat
import java.util.*

class LoginActivity : AppCompatActivity(), KeyboardVisibilityEventListener {
    private val TAG = "LoginActivity"
    private val REQUEST_CODE_FOR_RESULT = 24

    override fun onVisibilityChanged(isOpen: Boolean) {
        if(isOpen) {
            sv_login_act.scrollTo(0, sv_login_act.bottom)
            ll_login_act_signup.visibility = View.GONE
        } else {
            sv_login_act.scrollTo(0, sv_login_act.top)
            ll_login_act_signup.visibility = View.VISIBLE

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        setFocusListeners()
        setClickListeners()

        KeyboardVisibilityEvent.setEventListener(this, this)
    }

    private fun setClickListeners() {
        btn_login_act_signup.setOnClickListener {
            Log.v(TAG, "Login Try")
            if(et_login_act_id.text.isEmpty()) {
                et_login_act_id.requestFocus()

                Log.v(TAG, "v")
            } else if(et_login_act_pw.text.isEmpty()) {
                et_login_act_pw.requestFocus()
                Log.v(TAG, "vv")
            } else {
                val id = et_login_act_id.text.toString()
                Log.v(TAG, "vvv")
//                startActivity<MainActivity>()
                val intent = Intent()
                intent.putExtra("id", id)
                setResult(Activity.RESULT_OK, intent)

                SharedPreferenceController.setUserId(this, id)
            }
        }

        ll_login_act_signup.setOnClickListener {

            val simpleDateFormat = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
            val s_time = simpleDateFormat.format(Date())


            startActivityForResult<SignUpActivity>(REQUEST_CODE_FOR_RESULT, "start_time" to s_time)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == 24) {
            if(resultCode == Activity.RESULT_OK) {
                val e_time = data!!.getStringExtra("End_Time")

                Log.v("vvv", "vvv")
                toast("End Time : ${e_time}")
            }
        }
    }

    private fun setFocusListeners() {
        et_login_act_id.setOnFocusChangeListener { v, hasFocus ->
            if(hasFocus) {
                et_login_act_id.setBackgroundResource(R.drawable.edittext_border_yellow)
            } else {
                et_login_act_id.setBackgroundResource(R.drawable.edittext_border)
            }
        }
        et_login_act_pw.setOnFocusChangeListener { v, hasFocus ->
            if(hasFocus) {
                et_login_act_pw.setBackgroundResource(R.drawable.edittext_border_yellow)
            } else {
                et_login_act_pw.setBackgroundResource(R.drawable.edittext_border)
            }
        }
    }




}
