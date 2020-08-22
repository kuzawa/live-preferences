package me.ibrahimsn.livepreferences

import android.app.Application
import android.preference.PreferenceManager
import android.util.Log
import androidx.lifecycle.Observer
import me.ibrahimsn.library.LiveSharedPreferences

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        val preferences = PreferenceManager.getDefaultSharedPreferences(this)
        val liveSharedPreferences = LiveSharedPreferences(preferences)

        preferences.edit().putString("exampleString", "xxx").apply()

        liveSharedPreferences
            .getString("exampleString", "default")
            .observeForever(Observer {
                Log.d("###", it)
            })
    }

}
