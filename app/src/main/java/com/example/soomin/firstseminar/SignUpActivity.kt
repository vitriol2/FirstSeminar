package com.example.soomin.firstseminar

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_sign_up.*
import net.yslibrary.android.keyboardvisibilityevent.KeyboardVisibilityEvent
import net.yslibrary.android.keyboardvisibilityevent.KeyboardVisibilityEventListener
import java.text.SimpleDateFormat
import java.util.*

class SignUpActivity : AppCompatActivity(), KeyboardVisibilityEventListener {
    override fun onVisibilityChanged(isOpen: Boolean) {
        if(isOpen) {
            sv_sign_up_act.scrollTo(0, sv_sign_up_act.bottom)
        }else
            sv_sign_up_act.scrollTo(0, sv_sign_up_act.top)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        KeyboardVisibilityEvent.setEventListener(this, this)

        et_sign_up_act_name.setOnFocusChangeListener { v, hasFocus ->
            if(hasFocus == true) {
                v.setBackgroundResource(R.drawable.edittext_border_yellow)
            } else {
                v.setBackgroundResource(R.drawable.edittext_border)
            }
        }
        et_sign_up_act_id.setOnFocusChangeListener { v, hasFocus ->
            if(hasFocus == true) {
                v.setBackgroundResource(R.drawable.edittext_border_yellow)
            } else {
                v.setBackgroundResource(R.drawable.edittext_border)
            }
        }
        et_sign_up_act_pw.setOnFocusChangeListener { v, hasFocus ->
            if(hasFocus == true) {
                v.setBackgroundResource(R.drawable.edittext_border_yellow)
            } else {
                v.setBackgroundResource(R.drawable.edittext_border)
            }
        }
        et_sign_up_act_pwcheck.setOnFocusChangeListener { v, hasFocus ->
            if(hasFocus == true) {
                v.setBackgroundResource(R.drawable.edittext_border_yellow)
            } else {
                v.setBackgroundResource(R.drawable.edittext_border)
            }
        }

        btn_sign_up_act_signup.setOnClickListener {
            if(et_sign_up_act_name.text.isEmpty()) {
                et_sign_up_act_name.requestFocus()
            } else if( et_sign_up_act_id.text.isEmpty()) {
                et_sign_up_act_id.requestFocus()
            } else if( et_sign_up_act_pw.text.isEmpty()) {
                et_sign_up_act_pw.requestFocus()
            } else if(et_sign_up_act_pwcheck.text.isEmpty()) {
                et_sign_up_act_pwcheck.requestFocus()
            }
            else {
                finish()
            }
        }

        fun postSignUpResponse() {
            val simpleDataFormat = SimpleDateFormat("hh/M/yyyy hh:mm:ss")
            val e_time = simpleDataFormat.format(Date())

            val intent = Intent()
            intent.putExtra("End_time", e_time)
            setResult(Activity.RESULT_OK, intent)
        }
    }
}
