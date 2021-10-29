package com.tim3333.angelinvest.explore

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.affirmation.adapter.ItemAdapter
import com.example.affirmation.adapter.ItemAdapterSpotlight
import com.example.affirmation.data.DataViewModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.tim3333.angelinvest.Lobby
import com.tim3333.angelinvest.databinding.FragmentExploreBinding
class ExploreFragment : Fragment() {
    private lateinit var binding: FragmentExploreBinding
    private val model: DataViewModel by viewModels()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreate(savedInstanceState)

        binding = FragmentExploreBinding.inflate(layoutInflater)
        return binding.root


    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val myDataset1 = model.spotlight()
        val recyclerView1 = binding.rvSpotlight
        recyclerView1.adapter = ItemAdapterSpotlight(requireContext(),myDataset1)
        recyclerView1.setHasFixedSize(false)
        Firebase.database.getReference("startups").addValueEventListener(object : ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                recyclerView1.adapter = ItemAdapterSpotlight(requireContext(),myDataset1)
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.w(ContentValues.TAG, "loadPost:onCancelled", databaseError.toException())
            }
        })



        val myDataset2 = model.foodBeverage()
        val recyclerView2 = binding.rvFoodBeverage
        recyclerView2.adapter = ItemAdapter(requireContext(),myDataset2)
        recyclerView2.setHasFixedSize(false)
        var indexTemp2= mutableListOf<String>()
        Firebase.database.getReference("startups").child("food&beverage").addValueEventListener(object : ValueEventListener {


            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (postSnapshot in dataSnapshot.children) {
                    indexTemp2.add(postSnapshot.key.toString())
                }
                Log.w(ContentValues.TAG, "loadPost: ${indexTemp2}")
                for(i in 0..indexTemp2.size-1){
                    Log.w(ContentValues.TAG, "OKOKOK: $i")
                    Firebase.database.getReference("startups").child("food&beverage").child(indexTemp2[i]).addValueEventListener(object : ValueEventListener {
                        var kv = mutableListOf<String>()

                        override fun onDataChange(dataSnapshot: DataSnapshot) {

                            for (postSnapshot in dataSnapshot.children) {
                                kv.add(postSnapshot.value.toString())
                            }
                            Log.w(ContentValues.TAG, "OK: ${kv[0]}")
                            recyclerView2.adapter = ItemAdapter(requireContext(),myDataset2)
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


        val myDataset3 = model.technology()
        val recyclerView3 = binding.rvTechnology
        recyclerView3.adapter = ItemAdapter(requireContext(),myDataset3)
        recyclerView3.setHasFixedSize(false)
        var indexTemp3= mutableListOf<String>()
        Firebase.database.getReference("startups").child("teknology").addValueEventListener(object : ValueEventListener {


            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (postSnapshot in dataSnapshot.children) {
                    indexTemp3.add(postSnapshot.key.toString())
                }
                Log.w(ContentValues.TAG, "loadPost: ${indexTemp3}")
                for(i in 0..indexTemp3.size-1){
                    Log.w(ContentValues.TAG, "OK: $i")
                    Firebase.database.getReference("startups").child("teknology").child(indexTemp3[i]).addValueEventListener(object : ValueEventListener {
                        var kv = mutableListOf<String>()

                        override fun onDataChange(dataSnapshot: DataSnapshot) {

                            for (postSnapshot in dataSnapshot.children) {
                                kv.add(postSnapshot.value.toString())
                            }
                            Log.w(ContentValues.TAG, "OK: ${kv[0]}")
                            recyclerView3.adapter = ItemAdapter(requireContext(),myDataset3)
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



        val myDataset4 = model.agriculture()
        val recyclerView4 = binding.rvAgriculture
        recyclerView4.adapter = ItemAdapter(requireContext(),myDataset4)
        recyclerView4.setHasFixedSize(false)
        var indexTemp4= mutableListOf<String>()
        Firebase.database.getReference("startups").child("agrikultur").addValueEventListener(object : ValueEventListener {


            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (postSnapshot in dataSnapshot.children) {
                    indexTemp4.add(postSnapshot.key.toString())
                }
                Log.w(ContentValues.TAG, "loadPost: ${indexTemp4}")
                for(i in 0..indexTemp4.size-1){
                    Log.w(ContentValues.TAG, "OK: $i")
                    Firebase.database.getReference("startups").child("agrikultur").child(indexTemp4[i]).addValueEventListener(object : ValueEventListener {
                        var kv = mutableListOf<String>()

                        override fun onDataChange(dataSnapshot: DataSnapshot) {

                            for (postSnapshot in dataSnapshot.children) {
                                kv.add(postSnapshot.value.toString())
                            }
                            Log.w(ContentValues.TAG, "OK: ${kv[0]}")
                            recyclerView4.adapter = ItemAdapter(requireContext(),myDataset4)
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
        Firebase.database.getReference("startups").addValueEventListener(object : ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                recyclerView4.adapter = ItemAdapterSpotlight(requireContext(),myDataset4)
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.w(ContentValues.TAG, "loadPost:onCancelled", databaseError.toException())
            }
        })
        binding.btnBack.setOnClickListener {
            startActivity(
                Intent(
                    requireContext().applicationContext,
                    Lobby::class.java
                )
            )
        }
    }
}