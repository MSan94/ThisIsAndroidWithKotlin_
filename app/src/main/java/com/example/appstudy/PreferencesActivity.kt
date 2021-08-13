package com.example.appstudy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceManager
import com.example.appstudy.databinding.ActivityPreferencesBinding
import com.example.appstudy.preferences.SettingFragment

class PreferencesActivity : AppCompatActivity() {
    val binding by lazy { ActivityPreferencesBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val shared = PreferenceManager.getDefaultSharedPreferences(this)
        val checkboxValue = shared.getBoolean("key_add_shortcut", false)
        val switchValue = shared.getBoolean("key_switch_on",false)
        val name = shared.getString("key_edit_name", "")
        val selected = shared.getString("key_set_item","")

    }
}