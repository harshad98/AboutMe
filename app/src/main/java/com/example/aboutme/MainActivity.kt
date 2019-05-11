package com.example.aboutme

import android.app.Activity
import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text
import com.example.aboutme.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      // setContentView(R.layout.activity_main)
     binding = DataBindingUtil.setContentView(this,R.layout.activity_main)


      //  findViewById<Button>(R.id.done_button).setOnClickListener {
        //    addNickname(it)
        //}
        binding.doneButton.setOnClickListener{
            addNickname(it)
        }
    }
    private fun addNickname(view: View){
       binding.apply {
           nicknameText.text = binding.nicknameEdit.text
           invalidateAll()
           nicknameEdit.visibility = View.GONE
           doneButton.visibility = View.GONE
           nicknameText.visibility = View.VISIBLE
       }

        // Hide the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
