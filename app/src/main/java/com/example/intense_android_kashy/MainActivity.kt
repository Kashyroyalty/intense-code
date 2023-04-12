package com.example.intense_android_kashy

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var btnsms: Button
    lateinit var btnemail: Button
    lateinit var btncamera: Button
    lateinit var btnshare: Button
    lateinit var btnmpesa: Button
    lateinit var btncall: Button
    lateinit var btnweb: Button
    lateinit var btnmap: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnsms = findViewById(R.id.btnsms)
        btnemail = findViewById(R.id.btnemail)
        btncamera = findViewById(R.id.btncamera)
        btnshare = findViewById(R.id.btnshare)
        btnmpesa = findViewById(R.id.btnmpesa)
        btncall = findViewById(R.id.btncall)
        btnweb = findViewById(R.id.btnweb)
        btnmap = findViewById(R.id.btnmap)


        btnsms.setOnClickListener {
            val uri: Uri = Uri.parse("smsto:0758824190")
            val intent = Intent(Intent.ACTION_SENDTO, uri)
            intent.putExtra("sms_body", "please call for reference ")
            startActivity(intent)

        }
        btnemail.setOnClickListener {
            val emailIntent = Intent(
                Intent.ACTION_SENDTO,
                Uri.fromParts("mailto", "sharonnagi13@gmail.com", null)
            )
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "JOB APPLICATION")
            emailIntent.putExtra(
                Intent.EXTRA_TEXT,
                "Dear sir, I am applying for a it specialist in your company"
            )
            startActivity(Intent.createChooser(emailIntent, "send email...."))

        }
        btncamera.setOnClickListener {
            val takePictureintent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(takePictureintent, 1)
        }
        btnmpesa.setOnClickListener {
            val simToolKitIntent = applicationContext.packageManager.getLaunchIntentForPackage("com.android.stk")
            simToolKitIntent?.let { startActivity(it) }
        }

    }
}
