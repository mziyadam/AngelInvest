package com.tim3333.angelinvest

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.tim3333.angelinvest.databinding.ActivityLoginBinding

class Login : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Initialize Firebase Auth
        auth = Firebase.auth
    }
    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        Log.w(TAG,currentUser?.email.toString())
        if(currentUser != null){
            startActivity(
                Intent(
                    applicationContext,
                    Lobby::class.java
                )
            )
        }
        binding.btnForgot.setOnClickListener{
            startActivity(
                Intent(
                    applicationContext,
                    Forgot::class.java
                )
            )
        }
        binding.btnLogin.setOnClickListener {
            signIn(binding.etUsername.text.toString(),binding.etPassword.text.toString())
        }
        binding.btnToRegister.setOnClickListener {
            startActivity(
                Intent(
                    applicationContext,
                    Register::class.java
                )
            )
        }
    }
    private fun signIn(email: String, password: String) {
        // [START sign_in_with_email]
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "signInWithEmail:success")

                    startActivity(
                        Intent(
                            applicationContext,
                            Lobby::class.java
                        )
                    )
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "signInWithEmail:failure", task.exception)
                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()

                }
            }
        // [END sign_in_with_email]
    }
}