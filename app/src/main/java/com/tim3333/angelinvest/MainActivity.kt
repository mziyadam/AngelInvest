package com.tim3333.angelinvest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tim3333.angelinvest.databinding.ActivityMainBinding
import com.tim3333.angelinvest.explore.ExploreFragment
import com.tim3333.angelinvest.message.MessageFragment
import com.tim3333.angelinvest.myportofolio.MyPortofolioFragment
import com.tim3333.angelinvest.profile.ProfileFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val exploreFragment = ExploreFragment()
        val portofolioFragment = MyPortofolioFragment()
        val notificationFragment = MessageFragment()
        val profileFragment = ProfileFragment()
        supportFragmentManager.beginTransaction().apply {
            replace(binding.fragmentMain.id, exploreFragment)
            commit()
        }
        binding.btnExplore.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(binding.fragmentMain.id, exploreFragment)
                commit()
            }
        }
        binding.btnMyPortofolio.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(binding.fragmentMain.id, portofolioFragment)
                commit()
            }
        }
        binding.btnNotification.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(binding.fragmentMain.id, notificationFragment)
                commit()
            }
        }
        binding.btnProfile.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(binding.fragmentMain.id, profileFragment)
                commit()
            }
        }
    }
}