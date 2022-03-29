package com.example.core.data.cache

import android.content.Context
import android.content.SharedPreferences
import com.example.core.domain.CorePrefs
import com.example.core.util.StrictModePermitter.permitDiskReads

class CorePrefsImpl(private val context: Context) : CorePrefs {
    /**
     * @EncryptedSharedPreferences to block the super user from hacking into
     * the shared preferences file and reading sensitive user data
     */
    private val prefs: SharedPreferences by lazy {
        permitDiskReads {
            context.getSharedPreferences(
                "app_prefs",
                Context.MODE_PRIVATE
            )
        }
    }

}