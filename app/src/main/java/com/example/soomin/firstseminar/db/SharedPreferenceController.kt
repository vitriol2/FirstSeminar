package com.example.soomin.firstseminar.db

import android.content.Context

object SharedPreferenceController {

    val MY_ACCOUNT = "unique_string"

    fun setUserId(ctx : Context, time : String) {
        val preference = ctx.getSharedPreferences(MY_ACCOUNT, Context.MODE_PRIVATE)
        val editor = preference.edit()
        editor.putString("u_id", time)
        editor.commit()
    }

    fun getUserId(ctx : Context) : String{
        val preference = ctx.getSharedPreferences(MY_ACCOUNT, Context.MODE_PRIVATE)
        return preference.getString("u_id", "")
    }

    fun clearUID(ctx : Context) {
        val preference = ctx.getSharedPreferences(MY_ACCOUNT, Context.MODE_PRIVATE)
        val editor = preference.edit()
        editor.clear()
        editor.commit()
    }
}