package com.tim3333.angelinvest.myportofolio

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.affirmation.data.DataViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.tim3333.angelinvest.databinding.FragmentMyportofolioBinding
import com.tim3333.angelinvest.myportofolio.interested.InterestedFragment
import com.tim3333.angelinvest.myportofolio.invested.InvestedFragment
import com.tim3333.angelinvest.myportofolio.portofolio.PortofolioFragment

class MyPortofolioFragment : Fragment() {
    private lateinit var binding: FragmentMyportofolioBinding
    private lateinit var auth: FirebaseAuth
    val database = Firebase.database

    private val model: DataViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMyportofolioBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val portofolioFragment = PortofolioFragment()
        val investedFragment = InvestedFragment()
        val interestedFragment = InterestedFragment()
        auth = Firebase.auth
        val user = auth.currentUser
        database.getReference("users").child("${user?.uid}").child("name").get().addOnSuccessListener {
            binding.tvName.setText(it.value.toString())
            model._myUser.name=it.value.toString()
        }.addOnFailureListener {
            Log.e("firebase", "Error getting data", it)
        }
        childFragmentManager.beginTransaction().apply {
            replace(binding.fragmentMyPortofolio.id, portofolioFragment)
            commit()
        }
        binding.btnPortofolio.setOnClickListener {
            childFragmentManager.beginTransaction().apply {
                replace(binding.fragmentMyPortofolio.id, portofolioFragment)
                commit()
            }
        }
        binding.btnInterested.setOnClickListener {
            childFragmentManager.beginTransaction().apply {
                replace(binding.fragmentMyPortofolio.id, interestedFragment)
                commit()
            }
        }
        binding.btnInvested.setOnClickListener {
            childFragmentManager.beginTransaction().apply {
                replace(binding.fragmentMyPortofolio.id, investedFragment)
                commit()
            }
        }
    }
}