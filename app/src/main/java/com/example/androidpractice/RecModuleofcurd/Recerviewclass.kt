package com.example.androidpractice.RecModuleofcurd

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.androidpractice.R
import com.example.androidpractice.databinding.ActivityRecerviewclassBinding
import model.adapterdc

class Recerviewclass : AppCompatActivity() {
    lateinit var binding: ActivityRecerviewclassBinding
    lateinit var adapter : RecAdapter
    private lateinit var list: ArrayList<adapterdc>
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityRecerviewclassBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContentView(binding.root)
        list= arrayListOf<adapterdc>()
        adapter= RecAdapter(list)
        // Initialize adapter

//       binding.recyclerView.layoutManager = LinearLayoutManager(this)
       binding.recyclerView.layoutManager = GridLayoutManager(this,2)
        list.add(adapterdc("Bilkis","Shaikh", R.drawable.baseline_nights_stay_24))
            list.add(adapterdc("Sameer","Shaikh", R.drawable.baseline_nights_stay_24))
            list.add(adapterdc("Aslam","Shaikh", R.drawable.baseline_nights_stay_24))
            list.add(adapterdc("Mehrunisha","Shaikh", R.drawable.baseline_nights_stay_24))
            list.add(adapterdc("Zafar","Ansari", R.drawable.baseline_nights_stay_24))
        binding.recyclerView.adapter= adapter
        binding.recyclerView.setHasFixedSize(true)


        adapter.setonitemclicklistner(object :RecAdapter.onitemclicklistner{
            override fun onitemclick(position: Int) {
var intent = Intent(this@Recerviewclass,detailed::class.java)
                intent.putExtra("name",list[position].name)
                intent.putExtra("surname",list[position].surname)
                intent.putExtra("img",list[position].img)
                startActivity(intent)
            }

        })

        adapter.setonitemclicklistner(object : RecAdapter.onitemclicklistner {
            override fun onitemclick(position: Int) {
                // Show a dialog before delete, optional
                AlertDialog.Builder(this@Recerviewclass)  // replace with your context
                    .setTitle("Delete Item")
                    .setMessage("Are you sure you want to delete this item?")
                    .setPositiveButton("Yes") { _, _ ->
                        adapter.deleteItem(position)
                    }
                    .setNegativeButton("No", null)
                    .show()
            }
        })


        binding.button2.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            val view = LayoutInflater.from(this).inflate(R.layout.alertdi, null)

            val nameInput = view.findViewById<EditText>(R.id.editTextText)
            val surnameInput = view.findViewById<EditText>(R.id.editTextText2)
            val image = view.findViewById<ImageView>(R.id.imageView2)
            val submitBtn = view.findViewById<Button>(R.id.button)

            builder.setView(view)
            builder.setCancelable(false)

            val dialog = builder.create()

            submitBtn.setOnClickListener {
                val name = nameInput.text.toString().trim()
                val surname = surnameInput.text.toString().trim()

                if (name.isEmpty() || surname.isEmpty()) {
                    nameInput.error = "Enter name"
                    surnameInput.error = "Enter surname"
                } else {
                    val newItem = adapterdc(name, surname, R.drawable.baseline_nights_stay_24)
                    list.add(newItem)
                    adapter.notifyItemInserted(list.size - 1)
                    dialog.dismiss()
                }
            }

            dialog.show()
        }

        adapter.setonitemclicklistner(object : RecAdapter.onitemclicklistner {
            override fun onitemclick(position: Int) {
                val layoutInflater = LayoutInflater.from(this@Recerviewclass)
                val dialogView = layoutInflater.inflate(R.layout.editesample, null)

                val sc = adapter.item[position]
                val image = dialogView.findViewById<ImageView>(R.id.imageView3)
                val nameEdit = dialogView.findViewById<EditText>(R.id.editTextText3)
                val surnameEdit = dialogView.findViewById<EditText>(R.id.editTextText4)

                nameEdit.setText(sc.name)
                surnameEdit.setText(sc.surname)
                image.setImageResource(sc.img)

                val alertDialog = AlertDialog.Builder(this@Recerviewclass)
                    .setView(dialogView)
                    .setTitle("EDIT DATA")
                    .setPositiveButton("OK") { dialog, _ ->
                        val newData = adapterdc(
                            nameEdit.text.toString(),
                            surnameEdit.text.toString(),
                            sc.img
                        )
                        adapter.editdata(position, newData)
                        dialog.dismiss()
                    }
                    .setNegativeButton("Cancel") { dialog, _ ->
                        dialog.dismiss()
                    }
                    .create()

                alertDialog.show()
            }
        })



    }
}