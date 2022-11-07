package com.example.relampagomarquinhos

import androidx.appcompat.app.AppCompatActivity
import com.example.relampagomarquinhos.repository.RaceRepository
import android.os.Bundle
import com.example.relampagomarquinhos.fragment.RegisterRaceFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository = RaceRepository.instance()

        repository.getAll{ races ->

        }

        val dialogRegister = RegisterRaceFragment()
        dialogRegister.show(supportFragmentManager, "DialogRegister")
    }
}