package com.example.listpariwisata

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

@Suppress("DEPRECATION")
class DetailedActivity(private val detailedDesc: Int) : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detailed)

        val wisata = intent.getParcelableExtra<WisataModel>("wisata")
        if (wisata !=null){
            val wisataName : TextView = findViewById(R.id.detailedActivityTv)
            val wisataImage : ImageView = findViewById(R.id.detailedActivityIv)
            val detailedActivity : TextView = findViewById(detailedDesc)

            wisataName.text = wisata.wisataName
            wisataImage.setImageResource(wisata.wisataImage)
            detailedActivity.text = wisata.detailedActivity
        }
        }


    }