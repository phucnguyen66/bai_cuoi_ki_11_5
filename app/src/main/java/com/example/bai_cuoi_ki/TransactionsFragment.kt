package com.example.bai_cuoi_ki

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment

class TransactionsFragment : Fragment(R.layout.secon) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val button1: Button = view.findViewById(R.id.de_vl)
        button1.setOnClickListener {
            showClassSelectionDialog("Cấp 1", arrayOf("Lớp 1", "Lớp 2", "Lớp 3", "Lớp 4", "Lớp 5")) { selectedClass ->
                saveSelectedClass(selectedClass)
                val intent = Intent(requireActivity(), cap1_main::class.java)
                startActivity(intent)
            }
        }

        val vua: Button = view.findViewById(R.id.vua)
        vua.setOnClickListener {
            showClassSelectionDialog("Cấp 2", arrayOf("Lớp 6", "Lớp 7", "Lớp 8", "Lớp 9")) { selectedClass ->
                saveSelectedClass(selectedClass)
                val intent = Intent(requireActivity(), cap2_main::class.java)
                startActivity(intent)
            }
        }

        val kho: Button = view.findViewById(R.id.kho)
        kho.setOnClickListener {
            showClassSelectionDialog("Cấp 3", arrayOf("Lớp 10", "Lớp 11", "Lớp 12")) { selectedClass ->
                saveSelectedClass(selectedClass)
                val intent = Intent(requireActivity(), cap3_main::class.java)
                startActivity(intent)
            }
        }
    }

    private fun showClassSelectionDialog(title: String, classes: Array<String>, onClassSelected: (String) -> Unit) {
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Chọn lớp cho $title")
        builder.setItems(classes) { _, which ->
            val selectedClass = classes[which]
            onClassSelected(selectedClass)
        }
        builder.setNegativeButton("Hủy", null)
        builder.show()
    }

    private fun saveSelectedClass(className: String) {
        val sharedPref = requireActivity().getSharedPreferences("LUA_CHON_LOP", Context.MODE_PRIVATE)
        with(sharedPref.edit()) {
            putString("lop_da_chon", className)
            apply()
        }
    }
}