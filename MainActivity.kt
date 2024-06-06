package com.example.listpariwisata

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity(var wisataadapter: WisataAdapter) : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var detailedActivity: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        recyclerView = findViewById(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this)

        val wisataList = ArrayList<WisataModel>()

        wisataList.add(WisataModel("Pasar Tanah Abang Blok A dan Blok B",R.drawable.pasar_tanah_abang_jakarta1))
        wisataList.add(WisataModel("Monumen Nasional",R.drawable.monumen_nasional_jakarta2))
        wisataList.add(WisataModel("Museum Nasional Indonesia",R.drawable.museum_nasional_indonesia_jakarta3))
        wisataList.add(WisataModel("Taman Wisata Alam Mangrove Angke Kapuk",R.drawable.taman_wisata_alam_mangrove_angke_kapuk_jakarta4))
        wisataList.add(WisataModel("Pantai Marunda",R.drawable.pantai_marunda_jakarta5))
        wisataList.add(WisataModel("Aquarium Jakarta",R.drawable.aquarium_jakarta6))
        wisataList.add(WisataModel("Dufan(Dunia Fantasy)",R.drawable.dufan_jakarta7))
        wisataList.add(WisataModel("Kota Tua",R.drawable.kota_tua_jakarta8))
        wisataList.add(WisataModel("Ocean Dream Samudra",R.drawable.ocean_dream_samudra_jakarta9))
        wisataList.add(WisataModel("Ancol",R.drawable.ancol_jakarta10))
        wisataList.add(WisataModel("TMII",R.drawable.taman_mini_indonesia_indah_jakarta11))

        detailedActivity = arrayOf(
            getString(R.string.pasar_tanah_abang),
            getString(R.string.monumen_nasional),
            getString(R.string.museum_nasional_indonesia),
            getString(R.string.taman_wisata_alam_mangrove_angke_kapuk),
            getString(R.string.pantai_marunda),
            getString(R.string.aquarium_jakarta),
            getString(R.string.dufan),
            getString(R.string.kota_tua),
            getString(R.string.ocean_dream_samudra),
            getString(R.string.ancol),
            getString(R.string.tmii)
        )

        val items = wisataList("wisataName")

        wisataadapter = WisataAdapter("wisataName", "wisataImage")
        recyclerView.adapter = wisataadapter

        wisataadapter.onItemClick = {WisataModel
            val intent = Intent(this ,DetailedActivity::class.java)
            intent.putExtra("wisata" , it)
            startActivity(intent)

        }

    }

    private fun wisataList(s: String): Any {
        TODO("Not yet implemented")
    }

}