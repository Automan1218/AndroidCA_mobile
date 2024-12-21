package com.example.androidca

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var imageGrid: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 检查登录状态
        checkLoginStatus()
        setContentView(R.layout.activity_main)
    }

    private fun checkLoginStatus() {
        val isLoggedIn = getSharedPreferences("UserPrefs", MODE_PRIVATE).getBoolean("isLoggedIn", false)
        if (!isLoggedIn) {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish() // 确保主界面不会停留在栈中
        }
    }
}
