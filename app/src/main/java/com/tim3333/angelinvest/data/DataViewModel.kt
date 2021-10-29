package com.example.affirmation.data

import android.content.ContentValues
import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.affirmation.model.Startup
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.tim3333.angelinvest.model.User

class DataViewModel : ViewModel() {
//private val model: DataViewModel by viewModels()

    private lateinit var auth: FirebaseAuth
    val database = Firebase.database
    val startupsDB = database.getReference("startups")
    private var _spotlight = mutableListOf<Startup>()
    private var _agriculture = mutableListOf<Startup>()
    private var _foodBeverage = mutableListOf<Startup>()
    private var _technology = mutableListOf<Startup>()
    var _myUser = User()
    fun myUser(): User{
        loadUser()
        return _myUser
    }
    fun spotlight(): MutableList<Startup> {
        loadSpotlight()
        return _spotlight
    }

    fun agriculture(): MutableList<Startup> {
        loadAgriculture()
        return _agriculture
    }

    fun foodBeverage(): MutableList<Startup> {
        loadFoodBeverage()
        return _foodBeverage
    }

    fun technology(): MutableList<Startup> {
        loadTechnology()
        return _technology
    }

    fun loadSpotlight() {

        startupsDB.child("agrikultur").child("x").addValueEventListener(object : ValueEventListener {
            var kv = mutableListOf<String>()

            override fun onDataChange(dataSnapshot: DataSnapshot) {

                for (postSnapshot in dataSnapshot.children) {
                    kv.add(postSnapshot.value.toString())
                }
                Log.w(ContentValues.TAG, "loadPost: ${kv[0]}")
                _spotlight.add(Startup(kv[0], kv[1], kv[2].toInt(), kv[3], kv[4], kv[5].toInt(), kv[6].toInt(), kv[7], kv[8], kv[9].toInt()))
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.w(ContentValues.TAG, "loadPost:onCancelled", databaseError.toException())
            }
        })
        startupsDB.child("food&beverage").child("z").addValueEventListener(object : ValueEventListener {
            var kv = mutableListOf<String>()

            override fun onDataChange(dataSnapshot: DataSnapshot) {

                for (postSnapshot in dataSnapshot.children) {
                    kv.add(postSnapshot.value.toString())
                }
                Log.w(ContentValues.TAG, "loadPost: ${kv[0]}")
                _spotlight.add(Startup(kv[0], kv[1], kv[2].toInt(), kv[3], kv[4], kv[5].toInt(), kv[6].toInt(), kv[7], kv[8], kv[9].toInt()))
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.w(ContentValues.TAG, "loadPost:onCancelled", databaseError.toException())
            }
        })
        startupsDB.child("teknology").child("y").addValueEventListener(object : ValueEventListener {
            var kv = mutableListOf<String>()

            override fun onDataChange(dataSnapshot: DataSnapshot) {

                for (postSnapshot in dataSnapshot.children) {
                    kv.add(postSnapshot.value.toString())
                }
                Log.w(ContentValues.TAG, "loadPost: ${kv[0]}")
                _spotlight.add(Startup(kv[0], kv[1], kv[2].toInt(), kv[3], kv[4], kv[5].toInt(), kv[6].toInt(), kv[7], kv[8], kv[9].toInt()))
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.w(ContentValues.TAG, "loadPost:onCancelled", databaseError.toException())
            }
        })
    }

    fun loadAgriculture() {
        var indexTemp = mutableListOf<String>()
        startupsDB.child("agrikultur").addValueEventListener(object : ValueEventListener {


            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (postSnapshot in dataSnapshot.children) {
                    indexTemp.add(postSnapshot.key.toString())
                }
                Log.w(ContentValues.TAG, "loadPost: ${indexTemp}")
                for (i in 0..indexTemp.size - 1) {
                    Log.w(ContentValues.TAG, "OK: $i")
                    startupsDB.child("agrikultur").child(indexTemp[i]).addValueEventListener(object : ValueEventListener {
                        var kv = mutableListOf<String>()

                        override fun onDataChange(dataSnapshot: DataSnapshot) {

                            for (postSnapshot in dataSnapshot.children) {
                                kv.add(postSnapshot.value.toString())
                            }
                            Log.w(ContentValues.TAG, "OK: ${kv[0]}")
                            _agriculture.add(Startup(kv[0], kv[1], kv[2].toInt(), kv[3], kv[4], kv[5].toInt(), kv[6].toInt(), kv[7], kv[8], kv[9].toInt()))
                        }

                        override fun onCancelled(databaseError: DatabaseError) {
                            Log.w(ContentValues.TAG, "loadPost:onCancelled", databaseError.toException())
                        }
                    })
                }


            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.w(ContentValues.TAG, "loadPost:onCancelled", databaseError.toException())
            }
        })

    }

    fun loadFoodBeverage() {
        var indexTemp = mutableListOf<String>()
        startupsDB.child("food&beverage").addValueEventListener(object : ValueEventListener {


            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (postSnapshot in dataSnapshot.children) {
                    indexTemp.add(postSnapshot.key.toString())
                }
                Log.w(ContentValues.TAG, "loadPost: ${indexTemp}")
                for (i in 0..indexTemp.size - 1) {
                    Log.w(ContentValues.TAG, "OK: $i")
                    startupsDB.child("food&beverage").child(indexTemp[i]).addValueEventListener(object : ValueEventListener {
                        var kv = mutableListOf<String>()

                        override fun onDataChange(dataSnapshot: DataSnapshot) {

                            for (postSnapshot in dataSnapshot.children) {
                                kv.add(postSnapshot.value.toString())
                            }
                            Log.w(ContentValues.TAG, "OK: ${kv[0]}")
                            _foodBeverage.add(Startup(kv[0], kv[1], kv[2].toInt(), kv[3], kv[4], kv[5].toInt(), kv[6].toInt(), kv[7], kv[8], kv[9].toInt()))
                        }

                        override fun onCancelled(databaseError: DatabaseError) {
                            Log.w(ContentValues.TAG, "loadPost:onCancelled", databaseError.toException())
                        }
                    })
                }


            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.w(ContentValues.TAG, "loadPost:onCancelled", databaseError.toException())
            }
        })
    }

    fun loadTechnology() {
        var indexTemp = mutableListOf<String>()
        startupsDB.child("teknology").addValueEventListener(object : ValueEventListener {


            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (postSnapshot in dataSnapshot.children) {
                    indexTemp.add(postSnapshot.key.toString())
                }
                Log.w(ContentValues.TAG, "loadPost: ${indexTemp}")
                for (i in 0..indexTemp.size - 1) {
                    Log.w(ContentValues.TAG, "OK: $i")
                    startupsDB.child("teknology").child(indexTemp[i]).addValueEventListener(object : ValueEventListener {
                        var kv = mutableListOf<String>()

                        override fun onDataChange(dataSnapshot: DataSnapshot) {

                            for (postSnapshot in dataSnapshot.children) {
                                kv.add(postSnapshot.value.toString())
                            }
                            Log.w(ContentValues.TAG, "OK: ${kv[0]}")
                            _technology.add(Startup(kv[0], kv[1], kv[2].toInt(), kv[3], kv[4], kv[5].toInt(), kv[6].toInt(), kv[7], kv[8], kv[9].toInt()))
                        }

                        override fun onCancelled(databaseError: DatabaseError) {
                            Log.w(ContentValues.TAG, "loadPost:onCancelled", databaseError.toException())
                        }
                    })
                }


            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.w(ContentValues.TAG, "loadPost:onCancelled", databaseError.toException())
            }
        })
    }

    fun loadUser(){

        auth = Firebase.auth
        val user = auth.currentUser
        val userDB = database.getReference("users").child("${user?.uid}")

        _myUser.email=user?.email.toString()
        _myUser.id=user?.uid.toString()
        userDB.child("name").get().addOnSuccessListener {
            _myUser.name = it.value.toString()
            Log.d("NAME", _myUser.name.toString())
        }.addOnFailureListener {
            Log.e("firebase", "Error getting data", it)
        }
        userDB.child("total").get().addOnSuccessListener {
            _myUser.total=it.value.toString().toInt()
            Log.d("TOTAL", _myUser.total.toString())
        }.addOnFailureListener{
            Log.e("firebase", "Error getting data", it)
        }

        userDB.child("${user?.uid}").child("assets").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (postSnapshot in dataSnapshot.children) {
                    _myUser.assets?.put(postSnapshot.key.toString(), postSnapshot.value.toString().toInt())
                }
                Log.d("ASSET", _myUser.assets.toString())
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Getting Post failed, log a message
                Log.w(ContentValues.TAG, "loadPost:onCancelled", databaseError.toException())
                // ...
            }
        })

        userDB.child("${user?.uid}").child("favourite").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (postSnapshot in dataSnapshot.children) {
                    _myUser.favourite?.put(postSnapshot.key.toString(), postSnapshot.value.toString())
                }
                Log.d("FAV", _myUser.favourite.toString())
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Getting Post failed, log a message
                Log.w(ContentValues.TAG, "loadPost:onCancelled", databaseError.toException())
                // ...
            }
        })





    }

}
