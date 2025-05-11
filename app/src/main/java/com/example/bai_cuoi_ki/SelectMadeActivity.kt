package com.example.bai_cuoi_ki

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.*

class SelectMadeActivity : AppCompatActivity() {

    private lateinit var madeGroup: RadioGroup
    private lateinit var btnStart: Button
    private lateinit var timeSpinner: Spinner
    private lateinit var database: DatabaseReference
    private lateinit var btnquaylai: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_made)

        madeGroup = findViewById(R.id.madeGroup)
        btnStart = findViewById(R.id.btnStart)
        timeSpinner = findViewById(R.id.timeSpinner)
        database = FirebaseDatabase.getInstance().reference
        btnquaylai = findViewById(R.id.quaylai)
        // Gán dữ liệu cho Spinner thời gian
        val timeOptions = listOf("15 phút", "30 phút", "45 phút", "60 phút")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, timeOptions)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        timeSpinner.adapter = adapter

        loadMadeListFromFirebase()
btnquaylai.setOnClickListener{
    finish()
}
        btnStart.setOnClickListener {
            val selectedId = madeGroup.checkedRadioButtonId
            if (selectedId == -1) {
                Toast.makeText(this, "Vui lòng chọn mã đề!", Toast.LENGTH_SHORT).show()
            } else {
                val selectedRadio = findViewById<RadioButton>(selectedId)
                val selectedMade = selectedRadio.text.toString()
                val selectedTimeStr = timeSpinner.selectedItem.toString()
                val selectedTimeMinutes = selectedTimeStr.replace(" phút", "").toInt()

                val intent = Intent(this, QuestionActivity::class.java)
                intent.putExtra("made", selectedMade)
                intent.putExtra("time_minutes", selectedTimeMinutes)
                startActivity(intent)
            }
        }

    }

    private fun loadMadeListFromFirebase() {
        database.child("Question").addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (madeSnapshot in snapshot.children) {
                    val madeKey = madeSnapshot.key
                    if (madeKey != null) {
                        val radio = RadioButton(this@SelectMadeActivity).apply {
                            text = madeKey
                        }
                        madeGroup.addView(radio)
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@SelectMadeActivity, "Lỗi tải mã đề", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
