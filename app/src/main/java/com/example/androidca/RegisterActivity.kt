package com.example.androidca

import android.content.IntentFilter
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity:AppCompatActivity() {
    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var getVerificationCodeButton: Button
    private lateinit var verificationCodeTextView: TextView
    private lateinit var registerButton: Button
    private lateinit var smsReceiver: SMSReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // 绑定视图
        usernameEditText = findViewById(R.id.usernameEditText)
        passwordEditText = findViewById(R.id.passwordEditText)
        getVerificationCodeButton = findViewById(R.id.getVerificationCodeButton)
        verificationCodeTextView = findViewById(R.id.verificationCodeTextView)
        registerButton = findViewById(R.id.registerButton)

        // 短信接收器
        smsReceiver = SMSReceiver()
        val filter = IntentFilter("android.provider.Telephony.SMS_RECEIVED")
        registerReceiver(smsReceiver, filter)

        // 获取验证码按钮
        getVerificationCodeButton.setOnClickListener {
            val username = usernameEditText.text.toString()

            if (username.isEmpty()) {
                Toast.makeText(this, "Please enter your username", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // 模拟发送验证码
            sendTestSMS("5554", "Your verification code is: 1234")
        }

        // 注册按钮
        registerButton.setOnClickListener {
            Toast.makeText(this, "Registration Complete!", Toast.LENGTH_SHORT).show()
        }
    }

    // 模拟发送短信
    private fun sendTestSMS(phoneNumber: String, message: String) {
        // 使用 Android Studio Device Manager 或控制台发送短信
        Toast.makeText(this, "Simulating SMS to $phoneNumber: $message", Toast.LENGTH_SHORT).show()
    }

    // 更新验证码显示
    fun updateVerificationCode(code: String) {
        runOnUiThread {
            verificationCodeTextView.text = code
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(smsReceiver)
    }
}