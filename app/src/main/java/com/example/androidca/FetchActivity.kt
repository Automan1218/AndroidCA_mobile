package com.example.androidca

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FetchActivity : AppCompatActivity() {
    private lateinit var urlEditText: EditText
    private lateinit var fetchButton: Button
    private lateinit var progressBar: ProgressBar
    private lateinit var imageGrid: RecyclerView
    private lateinit var imageAdapter: ImageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fetch)

        // 初始化视图
        urlEditText = findViewById(R.id.urlEditText)
        fetchButton = findViewById(R.id.fetchButton)
        progressBar = findViewById(R.id.progressBar)
        imageGrid = findViewById(R.id.imageGrid)

        // 初始化 RecyclerView
        imageGrid.layoutManager = GridLayoutManager(this, 3)
        imageAdapter = ImageAdapter(emptyList())
        imageGrid.adapter = imageAdapter

        // 设置按钮点击事件
        fetchButton.setOnClickListener {
            val url = urlEditText.text.toString()
            if (url.isEmpty()) {
                Toast.makeText(this, "Please enter a URL", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // 开始下载图片
            fetchImages(url)
        }
    }

    private fun fetchImages(url: String) {
        // 显示进度条
        progressBar.visibility = View.VISIBLE

        // 模拟图片下载（这里需要实现真实的网络请求）
        // 注意：真实的实现需要解析网页并下载图片
        val images = List(20) { "https://via.placeholder.com/150" } // 示例图片链接
        progressBar.visibility = View.GONE

        // 更新 RecyclerView
        imageAdapter.updateImages(images)
    }
}
