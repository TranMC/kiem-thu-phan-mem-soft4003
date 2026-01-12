# Kiểm Thử Phần Mềm - SOFT4003

##  Giới thiệu
Dự án này chứa các tài liệu và mã nguồn, bài tập liên quan đến môn học **Kiểm thử phần mềm (SOFT4003)**.


## Bài 1: Nguyên lí của kiểm thử
- Đường dẫn tới trang bài tập: [Can't Unsee](https://cantunsee.space/)
- Số lần làm: 03
- Ngày thực hiện: 5/1/2026


![https://cantunsee.space/](kiemthu01.png)

## Bài 2: Quy trình kiểm thử
###  Mô tả bài toán

#### StudentAnalyzer
Chương trình phân tích điểm số của sinh viên với các chức năng:

1. **countExcellentStudents**: Đếm số lượng sinh viên xuất sắc (điểm >= 8.0)
   - Chỉ tính các điểm hợp lệ trong khoảng [0, 10]
   - Bỏ qua các giá trị null hoặc ngoài phạm vi

2. **calculateValidAverage**: Tính điểm trung bình của các điểm hợp lệ
   - Chỉ tính các điểm trong khoảng [0, 10]
   - Bỏ qua các giá trị null hoặc ngoài phạm vi
   - Trả về 0 nếu không có điểm hợp lệ

###  Cách chạy chương trình

#### Yêu cầu
- Java JDK 8 trở lên
- Maven

#### Biên dịch dự án
```bash
cd unit-test
mvn clean compile
```


###  Cách chạy test

#### Chạy tất cả ca kiểm thử
```bash
cd unit-test
mvn test
```

#### Chạy một kiểm thử cụ thể
```bash
mvn test -Dtest=StudentAnalyzerTest#testCountExcellentStudents_normalCase
```

#### Test cases bao gồm:
- **testCountExcellentStudents_normalCase**: Kiểm thử đếm sinh viên xuất sắc với dữ liệu hỗn hợp
- **testCountExcellentStudents_allValid**: Kiểm thử với tất cả điểm đều hợp lệ
- **testCountExcellentStudents_emptyList**: Kiểm thử với danh sách rỗng
- **testCalculateValidAverage_mixedValues**: Kiểm thử tính trung bình với giá trị hỗn hợp
- **testCalculateValidAverage_boundaryValues**: Kiểm thử với giá trị biên
- **testCalculateValidAverage_emptyList**: Kiểm thử tính trung bình với danh sách rỗng

---
<p align="center"> © 2026 TranMC</p>

