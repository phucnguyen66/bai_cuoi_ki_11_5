package com.example.bai_cuoi_ki

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.*
import java.text.SimpleDateFormat
import java.util.*

class QuestionActivity : AppCompatActivity() {

    private lateinit var questionContainer: LinearLayout
    private val database: DatabaseReference = FirebaseDatabase.getInstance().reference
    private val totalQuestions = 50
    private val questions = mutableListOf<Question>()
    private val answers = mutableMapOf<Int, String>() // Lưu đáp án người dùng
    private lateinit var timerTextView: TextView
    private var timer: CountDownTimer? = null
    private var totalTimeMillis: Long = 0L
    private lateinit var made: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        // Lấy dữ liệu từ Intent đúng cách
        val selectedTimeMinutes = intent.getIntExtra("time_minutes", 30)
        totalTimeMillis = selectedTimeMinutes * 60 * 1000L
        made = intent.getStringExtra("made") ?: "made1"

        timerTextView = findViewById(R.id.timerTextView)
        questionContainer = findViewById(R.id.questionContainer)

        startCountdown()
        loadQuestionsFromFirebase()
    }

    private fun startCountdown() {
        timer = object : CountDownTimer(totalTimeMillis, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val minutes = millisUntilFinished / 1000 / 60
                val seconds = (millisUntilFinished / 1000) % 60
                timerTextView.text = String.format("Thời gian còn lại: %02d:%02d", minutes, seconds)
            }

            override fun onFinish() {
                Toast.makeText(this@QuestionActivity, "Hết thời gian làm bài!", Toast.LENGTH_LONG).show()
                val score = calculateScore()
                saveResult(score, 50 - score, "bài tập ôn tập thi tốt nghiệp lớp 12 - hết giờ")
                finish()
            }
        }.start()
    }

    private fun loadQuestionsFromFirebase() {
        database.child("Question").child(made)
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    for (i in 1..totalQuestions) {
                        val qSnap = snapshot.child(i.toString())
                        val question = Question(
                            deBai = qSnap.child("deBai").value.toString(),
                            dapan = qSnap.child("dapan").value.toString(),
                            sai1 = qSnap.child("sai1").value.toString(),
                            sai2 = qSnap.child("sai2").value.toString(),
                            sai3 = qSnap.child("sai3").value.toString()
                        )
                        questions.add(question)
                    }
                    displayAllQuestions()
                }

                override fun onCancelled(error: DatabaseError) {
                    Toast.makeText(this@QuestionActivity, "Lỗi tải dữ liệu!", Toast.LENGTH_SHORT).show()
                }
            })
    }

    private fun displayAllQuestions() {
        questionContainer.removeAllViews()

        for (i in questions.indices) {
            val question = questions[i]

            val questionText = TextView(this).apply {
                text = "${i + 1}. ${question.deBai}"
                textSize = 18f
                setTextColor(Color.BLACK)
                setPadding(0, 16, 0, 8)
            }

            val radioGroup = RadioGroup(this).apply {
                orientation = RadioGroup.VERTICAL
            }

            val answerList = listOf(
                question.dapan,
                question.sai1,
                question.sai2,
                question.sai3
            ).shuffled()

            for (ans in answerList) {
                val radio = RadioButton(this).apply {
                    text = ans
                    setTextColor(Color.BLACK)
                }
                if (answers[i] == ans) {
                    radio.isChecked = true
                }
                radioGroup.addView(radio)
            }

            radioGroup.setOnCheckedChangeListener { _, checkedId ->
                val selected = radioGroup.findViewById<RadioButton>(checkedId)
                answers[i] = selected.text.toString()
            }

            questionContainer.addView(questionText)
            questionContainer.addView(radioGroup)
        }

        // Thêm nút Nộp bài
        val btnSubmit = Button(this).apply {
            text = "Nộp bài"
            setBackgroundColor(Color.parseColor("#6200EE"))
            setTextColor(Color.WHITE)
            setPadding(16, 16, 16, 16)
            setOnClickListener {
                val unansweredCount = totalQuestions - answers.size
                val score = calculateScore()

                if (unansweredCount > 0) {
                    AlertDialog.Builder(this@QuestionActivity)
                        .setTitle("Bạn chưa hoàn thành bài!")
                        .setMessage("Bạn còn $unansweredCount câu chưa trả lời. Bạn có muốn nộp bài không?")
                        .setPositiveButton("Nộp bài") { _, _ ->
                            saveResult(score, 50 - score, "bài tập ôn tập thi tốt nghiệp lớp 12 - chưa làm: $unansweredCount")
                            Toast.makeText(this@QuestionActivity, "Bạn được $score / $totalQuestions điểm", Toast.LENGTH_LONG).show()
                            finish()
                        }
                        .setNegativeButton("Không", null)
                        .show()
                } else {
                    saveResult(score, 0, "bài tập ôn tập thi tốt nghiệp lớp 12")
                    Toast.makeText(this@QuestionActivity, "Bạn được $score / $totalQuestions điểm", Toast.LENGTH_LONG).show()
                    finish()
                }
            }
        }

        questionContainer.addView(btnSubmit)
    }

    private fun calculateScore(): Int {
        var score = 0
        for (i in 0 until totalQuestions) {
            if (answers[i] == questions[i].dapan) {
                score++
            }
        }
        return score
    }

    private fun saveResult(score: Int, wrong: Int, chuDe: String) {
        val sharedPreferences = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
        val loggedInUser = sharedPreferences.getString("loggedInUser", "")
        val ngayThang = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(Date())
        val baigiai = "ontaptotnghiep12"
        val userId = "$loggedInUser"

        luuKetQuaCaoNhat(userId, score, wrong, ngayThang, baigiai, chuDe)
    }

    override fun onDestroy() {
        super.onDestroy()
        timer?.cancel()
    }
}
