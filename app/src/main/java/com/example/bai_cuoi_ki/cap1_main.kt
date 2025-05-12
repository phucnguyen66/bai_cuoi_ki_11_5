package com.example.bai_cuoi_ki

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class cap1_main : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cap1_main)
        val bcc: Button = findViewById(R.id.bcc)
        bcc.setOnClickListener {
            val intent1 = Intent(this, com.example.bai_cuoi_ki.xembangcuuchuong::class.java)
            startActivity(intent1)
        }
        val quay: Button = findViewById(R.id.quay_lai)
        quay.setOnClickListener {
            // Khởi động Activity mới
            finish()

        }
        // Nút Dễ
        val button1: Button = findViewById(R.id.xem)
        button1.setOnClickListener {
            val intent1 = Intent(this, com.example.bai_cuoi_ki.ctcap1::class.java)
            startActivity(intent1)
        }
        val sharedPref = getSharedPreferences("LUA_CHON_LOP", Context.MODE_PRIVATE)
        val lopString = sharedPref.getString("lop_da_chon", "Lớp 1") ?: "Lớp 1"
        val lopDaChon = lopString.filter { it.isDigit() }.toInt()
        val chedoTextView: TextView = findViewById(R.id.chedo)
        chedoTextView.text = "Mời chọn chế độ của lớp $lopDaChon"

        // Nút Vừa
        val vua: Button = findViewById(R.id.lambai)
        vua.setOnClickListener {
            val intent1 = Intent(this, com.example.bai_cuoi_ki.EasyActivity::class.java)
            startActivity(intent1)
        }
        val vua2: Button = findViewById(R.id.lambai_2)
        vua2.setOnClickListener {
            val intent1 = Intent(this, com.example.bai_cuoi_ki.cap1_baigiai::class.java)
            startActivity(intent1)
        }
        val vua3: Button = findViewById(R.id.lambai_3)
        vua3.setOnClickListener {
            val intent1 = Intent(this, com.example.bai_cuoi_ki.cap1_baihinh::class.java)
            startActivity(intent1)
        }

    }

}

