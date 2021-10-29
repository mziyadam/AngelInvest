package com.tim3333.angelinvest

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.affirmation.data.DataViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.tim3333.angelinvest.databinding.ActivityLobbyBinding

class Lobby : AppCompatActivity() {
    private val model: DataViewModel by viewModels()
    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityLobbyBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLobbyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = Firebase.auth
        val user = auth.currentUser
        binding.btnLogout.setOnClickListener {
            auth.signOut()
            startActivity(
                Intent(
                    applicationContext,
                    Login::class.java
                )
            )
        }
        binding.btnRv.setOnClickListener {

            startActivity(
                Intent(
                    applicationContext,
                    MainActivity::class.java
                )
            )
        }
        val database = Firebase.database
        val myRef = database.getReference("users")
        myRef.child("${user?.uid}").child("assets").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val value = dataSnapshot.getValue()
                Log.d(TAG, "Value is: $value")
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException())
            }
        })
        /*myRef.child("${user?.uid}").child("assets").get().addOnSuccessListener {
            binding.tvMid.text=it.value.toString()
            Log.i("firebase", "Got value ${it.value}")
        }.addOnFailureListener{
            Log.e("firebase", "Error getting data", it)
        }*/
        myRef.child("${user?.uid}").child("assets").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                var keyz : String=""
                var valz : String=""
                for (postSnapshot in dataSnapshot.children) {
                    keyz=postSnapshot.key.toString()
                    valz=postSnapshot.value.toString()

                    // TODO: handle the post
                    Log.d(TAG, "onChildAdded:" + keyz)

                }
                binding.tvMid.text="$keyz : $valz"

            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Getting Post failed, log a message
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException())
                // ...
            }
        })

    /*
        myRef.addChildEventListener(object : ChildEventListener {
            override fun onChildAdded(dataSnapshot: DataSnapshot, previousChildName: String?) {
                Log.d(TAG, "onChildAdded:" + dataSnapshot.key!!)

                // A new comment has been added, add it to the displayed list
                val comment = dataSnapshot.key!!
                binding.tvMid.text=comment.toString()
                // ...
            }

        })*/
    }
}