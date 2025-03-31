package com.example.nhom27_btvn_tuan4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    private TextView txtInfo;
    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Initialize UI components
        txtInfo = findViewById(R.id.keoachInput);
        btnBack = findViewById(R.id.btnBack);

        // Get data from intent
        Intent intent = getIntent();
        if (intent != null) {
            String name = intent.getStringExtra("NAME");
            String id = intent.getStringExtra("ID");
            String className = intent.getStringExtra("CLASS");
            String phone = intent.getStringExtra("PHONE");
            String plan = intent.getStringExtra("PLAN");
            String year = intent.getStringExtra("YEAR");
            String majors = intent.getStringExtra("MAJORS");

            // Display data in TextView
            String displayText = "Họ và Tên: " + name + "\n"
                    + "MSSV: " + id + "\n"
                    + "Lớp: " + className + "\n"
                    + "SDT: " + phone + "\n"
                    + "Sinh viên năm: " + year + "\n"
                    + "Chuyên ngành: " + (majors.isEmpty() ? "Không chọn" : majors) + "\n"
                    + "Kế hoạch: " + plan;

            txtInfo.setText(displayText);
        }

        // Handle back button
        btnBack.setOnClickListener(v -> finish());
    }
}