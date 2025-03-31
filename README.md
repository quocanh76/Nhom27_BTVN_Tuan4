# Ứng Dụng Quản Lý Thông Tin Sinh Viên Tích Hợp thêm Tiện Ích Gọi Điện, SMS và Chụp Ảnh

## 📌 Giới Thiệu  
Ứng dụng Android giúp thu thập và quản lý thông tin sinh viên một cách hiệu quả. Dữ liệu được chuyển từ `MainActivity` sang `SecondActivity` để tổng hợp và hiển thị chi tiết.
Các thông tin bao gồm:  
- **Họ và tên**  
- **Mã số sinh viên (MSSV)**  
- **Lớp**  
- **Số điện thoại (SDT)**  
- **Sinh viên năm mấy** (Lựa chọn qua RadioButton)  
- **Chuyên ngành** (Lựa chọn qua CheckBox)  
- **Kế hoạch phát triển bản thân**  


## 🚀 Tính Năng  
- **Nhập thông tin và hiển thị**:  
✅ Nhập thông tin sinh viên từ `MainActivity`  
✅ Gửi dữ liệu sang `SecondActivity`  
✅ Hiển thị thông tin đã nhập tại `SecondActivity`  
✅ Hỗ trợ lựa chọn năm học và chuyên ngành  

- **Tích hợp tiện ích**:  
  📞 Gọi tới số điện thoại đã được nhập.  
  📩 Soạn SMS nhanh với số điện thoại đã nhập.  
  📸 Chụp ảnh từ camera.

## 📂 Cấu Trúc Dự Án
- activity_main.xml # Giao diện màn hình nhập thông tin  <br>
- activity_second.xml # Giao diện màn hình hiển thị thông tin  <br>
- MainActivity.java # Xử lý nhập, gửi dữ liệu và sử dụng các tiện ích  <br>
- SecondActivity.java # Xử lý nhận và hiển thị dữ liệu <br>

## 📱 Hướng Dẫn Sử Dụng
- Nhập thông tin vào các trường tại MainActivity.
- Chọn năm học (RadioButton) và chuyên ngành (CheckBox).
- Nhấn "GỬI THÔNG TIN" để xem tổng hợp ở SecondActivity.
- Sử dụng tiện ích:

  📞 Gọi điện: Nhấn nút điện thoại → Mở ứng dụng gọi. <br>
  📩 SMS: Nhấn nút SMS → Soạn tin nhắn mẫu.<br>
  📸 Chụp ảnh: Nhấn nút camera → Chụp và xác nhận. <br>
  
## 📝 Ghi Chú  
- Nếu không chọn năm học hoặc chuyên ngành, ứng dụng sẽ hiển thị "Không chọn".  
- Dữ liệu được truyền qua `Intent` giữa các Activity.  

## 📷 Hình ảnh minh họa  
 <br>
<img src = "https://github.com/user-attachments/assets/2f680c2e-509b-4f34-b61f-9eff2e755f04" width ="200"/>
<img src = "https://github.com/user-attachments/assets/6376f816-0f5f-42cf-ab2a-a07f05cdac76" width ="200"/>
<img src = "https://github.com/user-attachments/assets/23553986-0012-4872-9c4c-54d2726026a2" width ="200"/>
<img src = "https://github.com/user-attachments/assets/2cea723e-3a2c-4da5-ab04-a16084c18d36" width ="200"/>
<img src = "https://github.com/user-attachments/assets/019ee2ca-995e-448b-811b-1d1fcd757838" width ="200"/>
<img src = "https://github.com/user-attachments/assets/19290a39-a54e-4808-9bcb-036801d9de57" width ="200"/>

<br>

## 📧 Tác Giả
Ứng dụng được phát triển bởi:
**Nhóm 27**
<br>
**21200026 - Nguyễn Trường An**
<br>
**21200027 - Hà Quốc Anh**.  
