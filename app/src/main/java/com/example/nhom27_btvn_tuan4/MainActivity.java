package com.example.nhom27_btvn_tuan4;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.nhom27_btvn_tuan4.SecondActivity;

public class MainActivity extends AppCompatActivity {
    private EditText nameInput, idInput, classInput, sdtInput, kehoachInput;
    private RadioGroup radioGroup;
    private CheckBox checkHTN, checkDT, checkVT;
    private Button btnSendData;
    private static final int PERMISSION_REQUEST_CODE = 123;
    private static final int CAMERA_REQUEST_CODE = 101;
    private Button btnCall, btnSMS, btnCamera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI components
        nameInput = findViewById(R.id.nameInput);
        idInput = findViewById(R.id.idInput);
        classInput = findViewById(R.id.classInput);
        sdtInput = findViewById(R.id.sdtInput);
        kehoachInput = findViewById(R.id.keoachInput);
        radioGroup = findViewById(R.id.radioGroup);
        checkHTN = findViewById(R.id.checkHTN);
        checkDT = findViewById(R.id.checkDT);
        checkVT = findViewById(R.id.checkVT);
        btnSendData = findViewById(R.id.btnsendData);

        btnCall = findViewById(R.id.btnCall);
        btnSMS = findViewById(R.id.btnSMS);
        btnCamera = findViewById(R.id.btnCamera);

        btnCall.setOnClickListener(v -> handleCall());
        btnSMS.setOnClickListener(v -> handleSMS());
        btnCamera.setOnClickListener(v -> handleCamera());
        
        // Set button click listener
        btnSendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendDataToSecondActivity();
            }
        });
    }

    private void handleCall() {
        String phoneNumber = sdtInput.getText().toString();
        if (phoneNumber.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập số điện thoại", Toast.LENGTH_SHORT).show();
            return;
        }

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, PERMISSION_REQUEST_CODE);
        } else {
            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phoneNumber));
            startActivity(intent);
        }
    }

    private void handleSMS() {
        String phoneNumber = sdtInput.getText().toString();
        if (phoneNumber.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập số điện thoại", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:" + phoneNumber));
        intent.putExtra("sms_body", "Nội dung tin nhắn mẫu");
        startActivity(intent);
    }

    private void handleCamera() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, PERMISSION_REQUEST_CODE);
        } else {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, CAMERA_REQUEST_CODE);
        }
    }


    private void sendDataToSecondActivity() {
        String name = nameInput.getText().toString();
        String id = idInput.getText().toString();
        String className = classInput.getText().toString();
        String phone = sdtInput.getText().toString();
        String plan = kehoachInput.getText().toString();

        // Get selected RadioButton
        int selectedRadioId = radioGroup.getCheckedRadioButtonId();
        String year = "";
        if (selectedRadioId != -1) {
            RadioButton selectedRadioButton = findViewById(selectedRadioId);
            year = selectedRadioButton.getText().toString();
        }

        // Get selected CheckBoxes
        StringBuilder majors = new StringBuilder();
        if (checkHTN.isChecked()) majors.append("Máy tính - HTN, ");
        if (checkDT.isChecked()) majors.append("Điện tử, ");
        if (checkVT.isChecked()) majors.append("Viễn thông, ");

        // Remove trailing comma and space
        if (majors.length() > 0) {
            majors.setLength(majors.length() - 2);
        }

        // Create intent and pass data
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        intent.putExtra("NAME", name);
        intent.putExtra("ID", id);
        intent.putExtra("CLASS", className);
        intent.putExtra("PHONE", phone);
        intent.putExtra("PLAN", plan);
        intent.putExtra("YEAR", year);
        intent.putExtra("MAJORS", majors.toString());
        startActivity(intent);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_REQUEST_CODE && resultCode == RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            // Xử lý ảnh chụp được ở đây (ví dụ: hiển thị hoặc lưu trữ)
            Toast.makeText(this, "Ảnh đã được chụp", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Quyền đã được cấp", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Quyền bị từ chối", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
