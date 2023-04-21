package com.example.encryptedsharedprefsdemo

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey

class CryptoUtils {

    private val TAG = "CRYPTO-UTILS-TAG"

    fun saveToSharedPrefs(
        sharedPrefsFileName: String,
        context: Context,
        lookupAlias: String,
        plainText: String
    ) {
        val masterKey = MasterKey.Builder(context)
            .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
            .build()

        val sharedPreferences: SharedPreferences = EncryptedSharedPreferences.create(
            context,
            sharedPrefsFileName,
            masterKey,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )

        with(sharedPreferences.edit()) {
            putString(lookupAlias, plainText)
            apply()
            Log.d(TAG, "saveToSharedPrefs: saved to encrypted shared prefs")
        }
    }
}