package com.example.bai_cuoi_ki

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
<<<<<<< HEAD
import android.widget.Toast
=======
>>>>>>> a4755c26eed3cb3e8d60a4fa1f0a113688066e57
import androidx.appcompat.app.AppCompatActivity

class cap3_main : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cap23_main)
        val sharedPref = getSharedPreferences("LUA_CHON_LOP", Context.MODE_PRIVATE)
        val lopString = sharedPref.getString("lop_da_chon", "Lớp 9") ?: "Lớp 9"
        val lopDaChon = lopString.filter { it.isDigit() }.toInt()
        val chedoTextView: TextView = findViewById(R.id.chedo)
        chedoTextView.text = "Mời chọn chế độ của lớp $lopDaChon"
        // Nút Dễ
        val button1: Button = findViewById(R.id.xem)
        button1.setOnClickListener {
            val intent1 = Intent(this, com.example.bai_cuoi_ki.ctcap3::class.java)
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
            val intent1 = Intent(this, com.example.bai_cuoi_ki.cap3_baigiai::class.java)
            startActivity(intent1)
        }
        val vua2: Button = findViewById(R.id.lambai2)
        vua2.setOnClickListener {
            val intent1 = Intent(this, com.example.bai_cuoi_ki.hard_main::class.java)
            startActivity(intent1)
        }
        val vua3: Button = findViewById(R.id.lambai3)
        vua3.setOnClickListener {
            val intent1 = Intent(this, com.example.bai_cuoi_ki.cap3_baihinh::class.java)
            startActivity(intent1)
        }
<<<<<<< HEAD
        val vua4: Button = findViewById(R.id.lambai_tn)

        vua4.setOnClickListener {

            if (lopDaChon == 12) {
                val intent1 = Intent(this, com.example.bai_cuoi_ki.SelectMadeActivity::class.java)
                startActivity(intent1)
            } else {
                Toast.makeText(this, "Bạn chưa đủ điều kiện để làm bài!", Toast.LENGTH_SHORT).show()
            }
        }
=======
>>>>>>> a4755c26eed3cb3e8d60a4fa1f0a113688066e57

    }

}

