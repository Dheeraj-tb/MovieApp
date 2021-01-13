package com.example.testbooktutorial

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        initFragment()
    }

    private fun initFragment(){
        supportFragmentManager.beginTransaction()
            .replace(R.id.frag, MainFragment.newInstance()).commitNow()
    }
}

// TODO event bus
// TODO RxJava vs Coroutine