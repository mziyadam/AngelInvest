package com.tim3333.angelinvest

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.tim3333.angelinvest.databinding.ActivityRegisterBinding

class Register : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = Firebase.auth
    }

    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        if(currentUser != null){
            startActivity(
                Intent(
                    applicationContext,
                    Lobby::class.java
                )
            )
        }
        binding.btnRegister.setOnClickListener {
            if(binding.etPasswordRegister.text.toString().equals(binding.etRepasswordRegister.text.toString()))
            createAccount(binding.etUsernameRegister.text.toString(),binding.etPasswordRegister.text.toString())
            else
                Toast.makeText(baseContext, "Register gagal",
                    Toast.LENGTH_SHORT).show()
        }
        binding.btnToLogin.setOnClickListener {
            startActivity(
                Intent(
                    applicationContext,
                    Login::class.java
                )
            )
        }
    }
    private fun createAccount(email: String, password: String) {
        // [START create_user_with_email]
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "createUserWithEmail:success")

                    val user = auth.currentUser
                    val database = Firebase.database
                    val myRef = database.getReference("users").child("${user?.uid}")

                    myRef.child("email").setValue("${user?.email}")
                    startActivity(
                        Intent(
                            applicationContext,
                            Lobby::class.java
                        )
                    )
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "createUserWithEmail:failure", task.exception)
                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()

                }
            }
        // [END create_user_with_email]
    }
}