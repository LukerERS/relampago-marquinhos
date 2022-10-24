package com.example.relampagomarquinhos

import androidx.appcompat.app.AppCompatActivity
import com.example.relampagomarquinhos.repository.RaceRepository
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository = RaceRepository.instance()

        repository.getAll{ races ->

        }



        /*val race = Race(
            "402",
            10.5f,
            Timestamp.now(),
            "Toretto"
        )
        repository.save(
            race
        )*/
    }
}