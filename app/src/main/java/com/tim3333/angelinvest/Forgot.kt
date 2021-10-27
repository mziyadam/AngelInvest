package com.tim3333.angelinvest

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.tim3333.angelinvest.databinding.ActivityForgotBinding

class Forgot : AppCompatActivity() {

    private lateinit var binding: ActivityForgotBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityForgotBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnForgotSend.setOnClickListener {
            Firebase.auth.sendPasswordResetEmail(binding.etEmailForgot.text.toString())
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Log.d(TAG, "Email sent.")
                        startActivity(
                            Intent(
                                applicationContext,
                                Login::class.java
                            )
                        )
                    }
                }
        }
    }
}