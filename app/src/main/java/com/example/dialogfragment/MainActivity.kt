package com.example.dialogfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),MyDialogFragment.DialogListener {

    val TAG="MainActivity"
    val dialogFragment = MyDialogFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txt.setOnClickListener{
            showDialog()
        }

    }

    private fun showDialog(){

        val ft = supportFragmentManager.beginTransaction()
        val prev = supportFragmentManager.findFragmentByTag("dialog")
        if (prev != null)
        {
            ft.remove(prev)
        }
        ft.addToBackStack(null)
        dialogFragment.show(ft, "dialog")


    }

    override fun onFinishEditDialog() {
        Log.i(TAG,"onFinieEditDialog")
        dialogFragment.dismiss()
    }
}
