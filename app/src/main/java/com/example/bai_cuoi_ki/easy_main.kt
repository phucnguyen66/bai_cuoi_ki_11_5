package com.example.bai_cuoi_ki
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.bai_cuoi_ki.R.layout.easy_main
import com.google.firebase.database.FirebaseDatabase
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import kotlin.random.Random

fun luuKetQuaCaoNhat(userId: String, dung: Int, sai: Int, ngayThang: String, chuDe: String,tieude: String) {
    val database = FirebaseDatabase.getInstance()
    val ketQuaRef = database.getReference("ket_qua").child(userId).push()

    val ketQuaMap = mapOf(
        "dung" to dung,
        "sai" to sai,
        "ngayThang" to ngayThang,
        "chuDe" to chuDe,
        "tieude" to tieude
    )

    ketQuaRef.setValue(ketQuaMap)
        .addOnSuccessListener {
            Log.d("Firebase", "Lưu kết quả thành công.")
        }
        .addOnFailureListener { error ->
            Log.e("Firebase", "Lỗi khi lưu kết quả: ${error.message}")
        }
}
fun dis(button1:Button,button2:Button,button3:Button){
    button1.setEnabled(false)
    button2.setEnabled(false)
    button3.setEnabled(false)
}
fun dis4(button1:Button,button2:Button,button3:Button,button4:Button){
    button1.setEnabled(false)
    button2.setEnabled(false)
    button3.setEnabled(false)
    button4.setEnabled(false)
}
fun dung(dung:Button)
{
    dung.setBackgroundColor(Color.GREEN)
    dung.setTextColor(Color.BLACK)

}
fun sai(sai:Button)
{
    sai.setBackgroundColor(Color.RED)
    sai.setTextColor(Color.BLACK)


}
fun makeUniqueRecursive3(a: Int, b: Int, c: Int): Triple<Int, Int, Int> {
    // Nếu 3 số khác nhau thì trả về luôn
    if (a != b && a != c && b != c) {
        return Triple(a, b, c)
    }

    // Nếu có số trùng thì random lại và gọi đệ quy
    val newB = Random.nextInt(1, 101)
    val newC = Random.nextInt(1, 101)

    return makeUniqueRecursive3(a, newB, newC)
}
fun safeRandom(from: Int, to: Int): Int {
    // Nếu phạm vi không hợp lệ, trả về một số mặc định để tránh lỗi
    return if (from < to && to <= Int.MAX_VALUE) {
        Random.nextInt(from, to)
    } else {
        from // hoặc bất kỳ số nào bạn muốn, miễn không bị lỗi
    }
}

fun makeUniqueRecursive4(kq: Int, vararg candidates: Int): List<Int> {
    val resultSet = mutableSetOf<Int>()
    resultSet.add(kq)

    // Thêm các ứng viên ban đầu nếu khác nhau và chưa có
    for (c in candidates) {
        if (c != kq) resultSet.add(c)
    }

    // Nếu chưa đủ 4 đáp án, tiếp tục sinh ngẫu nhiên và thêm
    while (resultSet.size < 4) {
        val wrong = Random.nextInt(kq - 10, kq + 50)
        if (wrong != kq) resultSet.add(wrong)
    }

    return resultSet.toList()
}



class EasyActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    private val maxBai = 10 // Giới hạn số bài làm, ví dụ là 5 bài
    override fun onCreate(savedInstanceState: Bundle?) {

        var dem = 0
        var sobai = 0
        var dung = 0
        var sai = 0
        super.onCreate(savedInstanceState)
        setContentView(easy_main)
        val quay: Button = findViewById(R.id.quay_lai)
        quay.setOnClickListener {
            // Khởi động Activity mới
            finish()

        }

            dung = intent.getIntExtra("dung_1", 0)
            sai = intent.getIntExtra("sai_1", 0)
            val dung_tv: TextView = findViewById(R.id.dung)
            val sai_tv: TextView = findViewById(R.id.sai)
            dung_tv.text = "Đúng: $dung"
            sai_tv.text = "Sai: $sai"
            sobai = intent.getIntExtra("sobai", 0)
            sobai = sobai + 1
            var so_bai: TextView = findViewById(R.id.sobai)
            so_bai.text = "bài: $sobai"
            val randomInt = (1..20).random()
            val numone: TextView = findViewById(R.id.num1)
            numone.text = randomInt.toString()
            val randomInt2 = (1..20).random()
            val numtwo: TextView = findViewById(R.id.num2)
            numtwo.text = randomInt2.toString()
            val dau = (1..4).random()
            var kq = 0
            if (dau == 1) {
                kq = randomInt + randomInt2
                val main: TextView = findViewById(R.id.dau)
                main.text = "+"
            } else if (dau == 2) {
                kq = randomInt - randomInt2
                val main: TextView = findViewById(R.id.dau)
                main.text = "-"
            } else if (dau == 3) {
                kq = randomInt * randomInt2
                val main: TextView = findViewById(R.id.dau)
                main.text = "x"
            } else if (dau == 4) {
                kq = randomInt / randomInt2
                val main: TextView = findViewById(R.id.dau)
                main.text = "/"
            }
            var dung_final=0
            var sai_final=0
            var sobai_final=0
            var final = 2
            var ran1 = (kq - 10..kq + 10).random()
            var ran2 = (kq - 10..kq + 10).random()
            val (x, y, z) = makeUniqueRecursive3(kq, ran1, ran2)
            val a = arrayListOf(x, y, z)
            a.shuffle()
            val button1: Button = findViewById(R.id.kq1)
            button1.text = a[0].toString()
            if (a[0] == kq) final = 1
            val button2: Button = findViewById(R.id.kq2)
            button2.text = a[1].toString()
            if (a[1] == kq) final = 2
            val button3: Button = findViewById(R.id.kq3)
            button3.text = a[2].toString()
            if (a[2] == kq) final = 3
            val buttonda: TextView=findViewById(R.id.abc)


            button1.setOnClickListener {
                dem++
                val dex = 1
                if (dex == final) {
                    dung = dung + 1
                    dung_final=1
                    sobai_final=1
                    buttonda.text= "đúng, kết quả là $kq"
                    dung(button1)
                } else {
                    sai = sai + 1
                    buttonda.text= "sai rồi bạn êy, kết quả là $kq"
                    sai(button1)
                    sai_final=1
                    sobai_final=1
                }

                dis(button1, button2, button3)

            }
            button2.setOnClickListener {
                val dex = 2
                dem++
                if (dex == final) {
                    dung = dung + 1
                    dung_final=1
                    sobai_final=1
                    buttonda.text= "đúng, kết quả là $kq"
                    dung(button2)

                } else {
                    sai = sai + 1
                    buttonda.text= "sai rồi bạn êy, kết quả là $kq"
                    sai(button2)
                    sai_final=1
                    sobai_final=1
                }
                dis(button1, button2, button3)

            }
            button3.setOnClickListener {
                dem++
                val dex = 3
                if (dex == final) {
                    dung = dung + 1
                    dung_final=1
                    sobai_final=1

                    buttonda.text= "đúng, kết quả là $kq"
                    dung(button3)

                } else {
                    sai = sai + 1
                    buttonda.text= "sai rồi bạn êy, kết quả là $kq"
                    sai(button3)
                    sai_final=1
                    sobai_final=1
                }
                dis(button1, button2, button3)

            }

        val chuyen: Button = findViewById(R.id.chuyen)
        chuyen.setOnClickListener {
            if (sobai >= maxBai) {

                val sharedPreferences = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
                val loggedInUser = sharedPreferences.getString("loggedInUser", "")
                val userId = "$loggedInUser" // hoặc FirebaseAuth.getInstance().currentUser?.uid ?: ""
                val chuDe = "bài tập trắc nghiệm cấp 1"
                val ngayThang = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(Date())
                val baigiai: String="baicap1"
                luuKetQuaCaoNhat(userId, dung, sai, ngayThang,baigiai, chuDe)

                val kqkc = dung * 10 / maxBai
                Toast.makeText(this, "Bạn đã làm đủ số bài, điểm của bạn là $kqkc", Toast.LENGTH_SHORT).show()
                finish()


            }
            else if (dem > 0 && sobai < maxBai) {
                val intent1 = Intent(this, EasyActivity::class.java)
                intent1.putExtra("sobai", sobai)
                intent1.putExtra("dung_1", dung)
                intent1.putExtra("sai_1", sai)
                var kqkc=dung*10/maxBai
                finish()

                startActivity(intent1)
            } else {
                Toast.makeText(this, "Bạn chưa chọn đáp án", Toast.LENGTH_SHORT).show()
            }

        }


        }

}
