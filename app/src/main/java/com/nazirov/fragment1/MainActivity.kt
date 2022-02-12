package com.nazirov.fragment1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


class MainActivity : AppCompatActivity(), FirstFragment.FirstListener,
    SecondFragment.SecondListener {

    val TAG = MainActivity::class.java.toString()
    var firstFragment: FirstFragment? = null
    var secondFragment: SecondFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    override fun onFirstSend(str: String?) {
        secondFragment!!.updateSecondText("PDP")
    }

    override fun onSecondSend(str: String?) {
        firstFragment!!.updateFirstText("Academy")
    }

    fun initViews() {
        firstFragment = FirstFragment()
        secondFragment = SecondFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.frameFirst, firstFragment!!)
            .replace(R.id.frameSecond, secondFragment!!)
            .commit()
    }
}