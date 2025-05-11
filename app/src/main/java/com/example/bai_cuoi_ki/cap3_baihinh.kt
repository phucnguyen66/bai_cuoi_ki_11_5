package com.example.bai_cuoi_ki


import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.content.SharedPreferences
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.bai_cuoi_ki.R.layout.cap1_baigiai
import kotlin.random.Random
import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


class cap3_baihinh : AppCompatActivity() {
    private var kq: Int = 0 // Biến toàn cục
    private val maxBai = 10 // Giới hạn số bài làm, ví dụ là 5 bài

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cap1_baigiai)

        val database = Firebase.database
        val calculationsRef = database.getReference("Bai_hinh_cap3")

        val sharedPref = getSharedPreferences("LUA_CHON_LOP", Context.MODE_PRIVATE)
        val lopString = sharedPref.getString("lop_da_chon", "Lớp 10") ?: "Lớp 10"
        val lopDaChon = lopString.filter { it.isDigit() }.toInt()
        var kq: Int = 0
        val maxBai = 10
        var sobai = intent.getIntExtra("sobai", 0)
        var dung = intent.getIntExtra("dung_1", 0)
        var sai = intent.getIntExtra("sai_1", 0)
        var dem = 0

        val quay: Button = findViewById(R.id.quay_lai)
        quay.setOnClickListener { finish() }

        val dung_tv: TextView = findViewById(R.id.dung)
        val sai_tv: TextView = findViewById(R.id.sai)
        val so_bai: TextView = findViewById(R.id.sobai)
        val numone: TextView = findViewById(R.id.num1)

        dung_tv.text = "Đúng: $dung"
        sai_tv.text = "Sai: $sai"
        sobai++
        so_bai.text = "Bài: $sobai"

        fun handleAnswers(kq: Int) {
            val button1: Button = findViewById(R.id.kq1)
            val button2: Button = findViewById(R.id.kq2)
            val button3: Button = findViewById(R.id.kq3)
            val button4: Button = findViewById(R.id.kq4)
            val buttonda: TextView = findViewById(R.id.abc)

            val ran1 = (kq - 10..kq + 10).random()
            val ran2 = (kq - 10..kq + 10).random()
            val ran3 = (kq - 10..kq + 10).random()
            val (x, y, z,a) = makeUniqueRecursive4(kq, ran1, ran2,ran3)
            val answers = arrayListOf(x, y, z,a).shuffled()

            button1.text = "A:   ${answers[0].toString()}"
            button2.text = "B:   ${answers[1].toString()}"
            button3.text = "C:   ${answers[2].toString()}"
            button4.text = "D:   ${answers[3].toString()}"

            val correctIndex = answers.indexOf(kq) + 1

            fun handleClick(index: Int, button: Button) {
                dem++
                if (index == correctIndex) {
                    dung++
                    buttonda.text = "Đúng, kết quả là $kq"
                    dung(button)
                } else {
                    sai++
                    buttonda.text = "Sai rồi bạn êy, kết quả là $kq"
                    sai(button)
                }
                dis4(button1, button2, button3,button4)
            }

            button1.setOnClickListener { handleClick(1, button1) }
            button2.setOnClickListener { handleClick(2, button2) }
            button3.setOnClickListener { handleClick(3, button3) }
            button4.setOnClickListener { handleClick(4, button4) }

        }

        calculationsRef.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val problemsList = mutableListOf<Pair<String, Int>>()
                for (data in snapshot.children) {
                    val expression = data.child("deToan").getValue(String::class.java)

                    // Xử lý dapAn: Kiểm tra nhiều kiểu dữ liệu (String, Long, Int)
                    val dapAnValue = data.child("dapAn").value
                    val result = when (dapAnValue) {
                        is String -> dapAnValue.toIntOrNull()
                        is Long -> dapAnValue.toInt()
                        is Int -> dapAnValue
                        else -> null
                    }

                    // Xử lý lop: Kiểm tra cả Long và Int
                    val lopValue = data.child("lop").value
                    val lop = when (lopValue) {
                        is Long -> lopValue.toInt()
                        is Int -> lopValue
                        else -> null
                    }

                    // Kiểm tra dữ liệu hợp lệ và lọc theo lớp
                    if (expression != null && result != null && lop == lopDaChon) {
                        problemsList.add(Pair(expression, result))
                    }
                }

                if (problemsList.isNotEmpty()) {
                    val randomProblem = problemsList.random()
                    numone.text = randomProblem.first
                    kq = randomProblem.second
                    handleAnswers(kq)
                } else {
                    Toast.makeText(
                        this@cap3_baihinh,
                        "Không tìm thấy bài toán cho lớp $lopDaChon",
                        Toast.LENGTH_SHORT
                    ).show()
                    finish()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Log.e("Firebase", "Error fetching data: ${error.message}")
            }
        })

        val chuyen1: Button = findViewById(R.id.chuyen)
        chuyen1.setOnClickListener {
            if (sobai >= maxBai) {
                val sharedPreferences = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
                val loggedInUser = sharedPreferences.getString("loggedInUser", "")
                val userId = "$loggedInUser"
                val chuDe = "bài tập trắc nghiệm toán hình cấp 3- lớp $lopDaChon"
                val ngayThang = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(Date())
                val baigiai = "baihinhcap3"

                luuKetQuaCaoNhat(userId, dung, sai, ngayThang, baigiai, chuDe)

                val kqkc = dung * 10 / maxBai
                Toast.makeText(
                    this,
                    "Bạn đã làm đủ số bài, điểm của bạn là $kqkc",
                    Toast.LENGTH_SHORT
                ).show()
                finish()
            } else if (dem > 0 && sobai < maxBai) {
                val intent1 = Intent(this, com.example.bai_cuoi_ki.cap3_baihinh::class.java)
                intent1.putExtra("sobai", sobai)
                intent1.putExtra("dung_1", dung)
                intent1.putExtra("sai_1", sai)
                finish()
                startActivity(intent1)
            } else {
                Toast.makeText(this, "Bạn chưa chọn đáp án", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
