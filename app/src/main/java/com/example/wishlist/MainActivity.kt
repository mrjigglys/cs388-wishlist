package com.example.wishlist

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var items: List<Item>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val itemsRv = findViewById<RecyclerView>(R.id.itemsRv)
        //Set items to empty list
        items = emptyList()
        //Attach adapter to RecyclerView
        var adapter = ItemAdapter(items)
        itemsRv.adapter = adapter
        itemsRv.layoutManager = LinearLayoutManager(this)

        val nameText = findViewById<EditText>(R.id.nameText)
        val priceText = findViewById<EditText>(R.id.priceText)
        val linkText = findViewById<EditText>(R.id.linkText)
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            //When submit button is pressed, add Item to items and reattach adapter
            val newItem = Item(nameText.text.toString(), priceText.text.toString(), linkText.text.toString())
            items = items + newItem
            adapter = ItemAdapter(items)
            itemsRv.adapter = adapter
            itemsRv.layoutManager = LinearLayoutManager(this)
        }

    }
}