package com.aryasurya.myappbar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.aryasurya.myappbar.databinding.ActivityMenuBinding

class MenuActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMenuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Memasukkan option meu kw SearchBar
        binding.searchBar.inflateMenu(R.menu.option_menu)
        binding.searchBar.setOnMenuItemClickListener{ menuItem ->
            when(menuItem.itemId) {
                R.id.menu1-> {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }

        }

        with(binding) {
            searchView.setupWithSearchBar(searchBar)
            searchView
                .editText
                .setOnEditorActionListener { textView, actionId, event ->
                    searchBar.text = searchView.text
                    searchView.hide()
                    Toast.makeText(this@MenuActivity, searchView.text, Toast.LENGTH_SHORT).show()
                    false
                }
        }

    }
}