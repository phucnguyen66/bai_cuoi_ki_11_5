package com.example.bai_cuoi_ki

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*

class LichSuFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: LichSuAdapter
    private val danhSachLichSu = mutableListOf<LichSuModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate layout fragment_lich_su.xml
        return inflater.inflate(R.layout.fragment_lich_su, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        recyclerView = view.findViewById(R.id.recyclerViewLichSu)
        adapter = LichSuAdapter(danhSachLichSu)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

        val sharedPreferences = requireContext().getSharedPreferences("UserPrefs", AppCompatActivity.MODE_PRIVATE)
        val userId = sharedPreferences.getString("loggedInUser", "") ?: ""

        if (userId.isNotEmpty()) {
            loadLichSuTuFirebase(userId)
        }
    }

    private fun loadLichSuTuFirebase(userId: String) {
        val databaseRef = FirebaseDatabase.getInstance().getReference("ket_qua").child(userId)

        databaseRef.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                danhSachLichSu.clear()
                for (item in snapshot.children) {
                    val ngayThang = item.child("ngayThang").getValue(String::class.java) ?: ""
                    val chuDe = item.child("tieude").getValue(String::class.java) ?: ""
                    val dung = item.child("dung").getValue(Long::class.java)?.toInt() ?: 0
                    val sai = item.child("sai").getValue(Long::class.java)?.toInt() ?: 0

                    danhSachLichSu.add(LichSuModel(ngayThang, chuDe, dung, sai))
                }
                adapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(requireContext(), "Lỗi: ${error.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
