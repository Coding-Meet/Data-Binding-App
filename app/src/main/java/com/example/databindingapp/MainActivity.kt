package com.example.databindingapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.databindingapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val mainBinding: ActivityMainBinding by lazy {
        DataBindingUtil.setContentView(this@MainActivity,R.layout.activity_main)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding.printBtn.setOnClickListener {
            if (mainBinding.edTitle.text.toString().isEmpty()){
                mainBinding.edTitle.error = "Required"
            }else if (mainBinding.edDesc.text.toString().isEmpty()){
                mainBinding.edDesc.error = "Required"
            }else{
                mainBinding.titleStr = mainBinding.edTitle.text.toString()
                mainBinding.descrStr = mainBinding.edDesc.text.toString()

            }
        }


        mainBinding.dataBindingFragmentBtn.setOnClickListener {
            startActivity(Intent(this,LoadBlankActivity::class.java))
        }
    }
}