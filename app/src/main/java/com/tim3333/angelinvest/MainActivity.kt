package com.tim3333.angelinvest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tim3333.angelinvest.databinding.ActivityMainBinding
import com.tim3333.angelinvest.explore.ExploreFragment
import com.tim3333.angelinvest.notification.NotificationFragment
import com.tim3333.angelinvest.portofolio.PortofolioFragment
import com.tim3333.angelinvest.profile.ProfileFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val exploreFragment = ExploreFragment()
        val portofolioFragment = PortofolioFragment()
        val notificationFragment = NotificationFragment()
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
        binding.btnPortofolio.setOnClickListener {
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