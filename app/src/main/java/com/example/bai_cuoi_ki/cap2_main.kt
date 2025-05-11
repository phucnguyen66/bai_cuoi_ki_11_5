package com.example.bai_cuoi_ki

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class cap2_main : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cap23_main)
        val sharedPref = getSharedPreferences("LUA_CHON_LOP", Context.MODE_PRIVATE)
        val lopString = sharedPref.getString("lop_da_chon", "Lớp 6") ?: "Lớp 6"
        val lopDaChon = lopString.filter { it.isDigit() }.toInt()
        val chedoTextView: TextView = findViewById(R.id.chedo)
        chedoTextView.text = "Mời chọn chế độ của lớp $lopDaChon"
        // Nút Dễ
        val button1: Button = findViewById(R.id.xem)
        button1.setOnClickListener {
            val intent1 = Intent(this, com.example.bai_cuoi_ki.ctcap2::class.java)
            startActivity(intent1)
        }
        val quay: Button = findViewById(R.id.quay_lai)
        quay.setOnClickListener {
            // Khởi động Activity mới
            finish()

        }

        // Nút Vừa
        val vua1: Button = findViewById(R.id.lambai1)
        vua1.setOnClickListener {
            val intent1 = Intent(this, com.example.bai_cuoi_ki.cap2_baigiai::class.java)
            startActivity(intent1)
        }
        val vua2: Button = findViewById(R.id.lambai2)
        vua2.setOnClickListener {
            val intent1 = Intent(this, com.example.bai_cuoi_ki.normal_main::class.java)
            startActivity(intent1)
        }
        val vua3: Button = findViewById(R.id.lambai3)
        vua3.setOnClickListener {
            val intent1 = Intent(this, com.example.bai_cuoi_ki.cap2_baihinh::class.java)
            startActivity(intent1)
        }

    }

}

