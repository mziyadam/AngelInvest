package com.tim3333.angelinvest.explore

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.affirmation.adapter.ItemAdapter
import com.example.affirmation.adapter.ItemAdapterSpotlight
import com.example.affirmation.data.Datasource
import com.tim3333.angelinvest.Lobby
import com.tim3333.angelinvest.databinding.FragmentExploreBinding

class ExploreFragment : Fragment() {
    private lateinit var binding: FragmentExploreBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreate(savedInstanceState)

        binding = FragmentExploreBinding.inflate(layoutInflater)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val myDataset1 = Datasource().loadSpotlight()
        val recyclerView1 = binding.rvSpotlight
        recyclerView1.adapter = ItemAdapterSpotlight(requireContext(),myDataset1)
        recyclerView1.setHasFixedSize(true)

        val myDataset2 = Datasource().loadFoodBeverage()
        val recyclerView2 = binding.rvFoodBeverage
        recyclerView2.adapter = ItemAdapter(requireContext(),myDataset2)
        recyclerView2.setHasFixedSize(true)

        val myDataset3 = Datasource().loadTechnology()
        val recyclerView3 = binding.rvTechnology
        recyclerView3.adapter = ItemAdapter(requireContext(),myDataset3)
        recyclerView3.setHasFixedSize(true)

        val myDataset4 = Datasource().loadAgriculture()
        val recyclerView4 = binding.rvAgriculture
        recyclerView4.adapter = ItemAdapter(requireContext(),myDataset4)
        recyclerView4.setHasFixedSize(true)
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