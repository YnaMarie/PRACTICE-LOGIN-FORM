package com.example.practiceactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioGroup
import android.widget.Toast
import com.example.practiceactivity.databinding.ActivityMainBinding


class Register : AppCompatActivity(), View.OnClickListener, RadioGroup.OnCheckedChangeListener {
    private lateinit var binding: ActivityMainBinding
    private var genderIndex = -1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener(this)
        binding.RGroup.setOnCheckedChangeListener(this)
    }

    override fun onClick(p0: View?) {
        if (binding.username.text.isEmpty()) {
            binding.username.error = "Required"
            return
        }
        if (binding.password.text.isEmpty()) {
            binding.password.error = "Required"
            return
        }
        if (binding.confirmPassword.text.isEmpty()) {
            binding.confirmPassword.error = "Required"
            return
        }
        if (binding.password.text.toString() != binding.confirmPassword.text.toString()) {
            binding.confirmPassword.error = "Password are not the same"
            binding.password.error = "Password are not the same"
            return
        }
        if (binding.firstName.text.isEmpty()) {
            binding.firstName.error = "Required"
            return
        }
        if (binding.lastName.text.isEmpty()) {
            binding.lastName.error = "Required"
            return
        }
        if (binding.Age.text.isEmpty()) {
            binding.Age.error = "Required"
            return
        }
        if (genderIndex == -1) {
            Toast.makeText(this, "Please specify your sex", Toast.LENGTH_SHORT).show()
            return
        }

        val intent = Intent(this,confirm::class.java)
        intent.putExtra("username",binding.username.text.toString())
        intent.putExtra("password",binding.password.text.toString())
        intent.putExtra("firstname",binding.firstName.text.toString())
        intent.putExtra("lastname",binding.lastName.text.toString())
        intent.putExtra("age",binding.Age.text.toString())
        intent.putExtra("genderIndex",genderIndex)
        startActivity(intent)
    }

    override fun onCheckedChanged(p0: RadioGroup?, p1: Int) {
        val radioB = binding.RGroup.findViewById<View>(p1)
        genderIndex = binding.RGroup.indexOfChild(radioB)
    }
}
