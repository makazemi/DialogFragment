package com.example.dialogfragment

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.DialogFragment

class MyDialogFragment :DialogFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val dialog=super.onCreateDialog(savedInstanceState)

        dialog.setCancelable(false)
        dialog.setCanceledOnTouchOutside(false)
        return dialog
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dialog_loading, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        val editText = view.findViewById<EditText>(R.id.inMobile)
//        val btnDone = view.findViewById<Button>(R.id.btnDone)
//        btnDone.setOnClickListener(object: View.OnClickListener {
//            override fun onClick(view:View) {
//                val dialogListener = activity as DialogListener
//                dialogListener.onFinishEditDialog(editText.text.toString())
//                dismiss()
//            }
//        })

        val dialogListener = activity as DialogListener
        val txt_message=view.findViewById<TextView>(R.id.loadingMessage)
        txt_message.text="لطفا تا وزن کشی مجدد شکیبا باشید"
        val btn_cancel=view.findViewById<Button>(R.id.btn_cancel)
        btn_cancel.setOnClickListener {
            dialogListener.onFinishEditDialog()
        }
    }

    interface DialogListener {
        fun onFinishEditDialog()
    }
}