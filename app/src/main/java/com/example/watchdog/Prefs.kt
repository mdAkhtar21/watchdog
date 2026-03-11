package com.example.watchdog

import android.content.Context

object Prefs {

    private const val PREF = "watchdog"
    private const val KEY = "pkg"

    fun setPackage(context: Context, pkg: String) {
        context.getSharedPreferences(PREF, Context.MODE_PRIVATE)
            .edit()
            .putString(KEY, pkg)
            .apply()
    }

    fun getPackage(context: Context): String {
        return context.getSharedPreferences(PREF, Context.MODE_PRIVATE)
            .getString(KEY, "") ?: ""
    }
}