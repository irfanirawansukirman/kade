package c.gits.mydriver

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * Dibuat oleh Irfan Irawan Sukirman
 * @Copyright 2018
 */
open class BaseActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun openActivity(appCompatActivity: AppCompatActivity){
        startActivity(Intent(this@BaseActivity, appCompatActivity::class.java))
    }
}