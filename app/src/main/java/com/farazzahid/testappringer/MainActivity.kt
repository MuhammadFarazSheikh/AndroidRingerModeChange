package com.farazzahid.testappringer

import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.media.AudioManager
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M
                && !(getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager).isNotificationPolicyAccessGranted) {
            val intent = Intent(
                    Settings.ACTION_NOTIFICATION_POLICY_ACCESS_SETTINGS)
            startActivityForResult(intent,1000)
        }

        btnRingerModeNormaL.setOnClickListener {
            (getSystemService(Context.AUDIO_SERVICE) as AudioManager).ringerMode = AudioManager.RINGER_MODE_NORMAL;
        }

        btnRingerModeSilent.setOnClickListener {
            (getSystemService(Context.AUDIO_SERVICE) as AudioManager).ringerMode = AudioManager.RINGER_MODE_SILENT;
        }

        btnRingerModeVibrate.setOnClickListener {
            (getSystemService(Context.AUDIO_SERVICE) as AudioManager).ringerMode = AudioManager.RINGER_MODE_VIBRATE;
        }
    }
}