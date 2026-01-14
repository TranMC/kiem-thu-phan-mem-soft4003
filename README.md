# Kiểm Thử Phần Mềm - SOFT4003

## Giới thiệu
Dự án này chứa các tài liệu và mã nguồn, bài tập liên quan đến môn học **Kiểm thử phần mềm (SOFT4003)**.


## Bài 1: Nguyên lí của kiểm thử
- Đường dẫn tới trang bài tập: [Can't Unsee](https://cantunsee.space/)
- Số lần làm: 03
- Ngày thực hiện: 5/1/2026


![https://cantunsee.space/](kiemthu01.png)

---
## Bài 2: Quy trình kiểm thử
### Mô tả bài toán

#### StudentAnalyzer
Chương trình phân tích điểm số của sinh viên với các chức năng:

1. **countExcellentStudents**: Đếm số lượng sinh viên xuất sắc (điểm >= 8.0)
   - Chỉ tính các điểm hợp lệ trong khoảng [0, 10]
   - Bỏ qua các giá trị null hoặc ngoài phạm vi

2. **calculateValidAverage**: Tính điểm trung bình của các điểm hợp lệ
   - Chỉ tính các điểm trong khoảng [0, 10]
   - Bỏ qua các giá trị null hoặc ngoài phạm vi
   - Trả về 0 nếu không có điểm hợp lệ

### Công nghệ sử dụng

| Công nghệ | Mô tả |
|-----------|-------|
| Java | Ngôn ngữ lập trình chính |
| Maven | Công cụ quản lý dự án và phụ thuộc |
| JUnit 5 | Thư viện kiểm thử đơn vị |

## Cách chạy chương trình

#### Yêu cầu hệ thống
- Java Development Kit (JDK) phiên bản 8 trở lên
- Maven phiên bản 3.6 trở lên

#### Bước chuẩn bị

1. **Cài đặt Java JDK**
   - Tải và cài đặt JDK từ trang chính thức của Oracle hoặc sử dụng phiên bản mã nguồn mở như OpenJDK
   - Thiết lập biến môi trường `JAVA_HOME` để chỉ tới thư mục cài đặt JDK

2. **Cài đặt Maven**

   **Cách 1: Cài đặt thủ công (tất cả hệ điều hành)**
   - Tải Maven từ https://maven.apache.org/
   - Giải nén file và lưu vào thư mục yêu thích
   - Thiết lập biến môi trường `MAVEN_HOME` để chỉ tới thư mục Maven
   - Thêm `%MAVEN_HOME%\bin` (Windows) hoặc `$MAVEN_HOME/bin` (Linux/Mac) vào biến `PATH`

   **Cách 2: Sử dụng Chocolatey (Windows - khuyến nghị)**
   - Mở CMD với quyền quản trị viên (nếu chưa có Chocolatey):
     ```bash
     winget install -e --id Chocolatey.Chocolatey
     ```
   - Cài đặt Maven:
     ```bash
     choco install maven
     ```

3. **Kiểm tra cài đặt**
   ```bash
   java -version
   mvn -version
   ```
---
#### Tải dự án
```bash
git clone <đường-dẫn-repo>
cd unit-test
```

#### Biên dịch dự án
```bash
mvn clean compile
```

#### Chạy tất cả ca kiểm thử
```bash
mvn test
```

#### Chạy kiểm thử cụ thể
```bash
mvn test -Dtest=StudentAnalyzerTest #testCountExcellentStudents_normalCase
```

#### Xem kết quả kiểm thử
Kết quả chi tiết được lưu trong thư mục: `unit-test/target/surefire-reports/`
- File báo cáo XML: `TEST-StudentAnalyzerTest.xml`
- File báo cáo text: `StudentAnalyzerTest.txt`

### Chi tiết các ca kiểm thử

| Tên kiểm thử | Mô tả |
|-------------|-------|
| testCountExcellentStudents_normalCase | Đếm sinh viên xuất sắc với dữ liệu hỗn hợp |
| testCountExcellentStudents_allValid | Đếm khi tất cả điểm đều hợp lệ |
| testCountExcellentStudents_emptyList | Đếm với danh sách rỗng |
| testCalculateValidAverage_mixedValues | Tính trung bình với giá trị hỗn hợp |
| testCalculateValidAverage_boundaryValues | Tính trung bình với giá trị biên |
| testCalculateValidAverage_emptyList | Tính trung bình với danh sách rỗng |

---
## Bài 3: Kiểm thử tĩnh

### Yêu cầu đề bài: Kiểm thử tự động End-to-End với Cypress

#### Cài đặt Cypress

**Yêu cầu:**
- [Node.js](https://nodejs.org/en/download) phiên bản 14 trở lên
- Sử dụng một trình soạn thảo được hỗ trợ

**Các bước cài đặt:**

1. Tạo thư mục dự án:
```bash
mkdir cypress-exercise
cd cypress-exercise
npm init -y
```

2. Cài đặt Cypress:
```bash
npm install cypress --save-dev
```

#### Kịch bản kiểm thử

**1. Đăng nhập thành công**

*Mục tiêu:* Xác minh đăng nhập với thông tin hợp lệ

*Các bước:*
- Truy cập https://www.saucedemo.com
- Nhập username: `standard_user`, password: `secret_sauce`
- Click nút "Login"
- Xác minh URL chứa `/inventory.html`

![Kịch bản 1](cypress-exercise/cypress/screenshots/login_spec.cy.js/login-success.png)

---

**2. Đăng nhập thất bại**

*Mục tiêu:* Kiểm tra thông báo lỗi khi đăng nhập sai

*Các bước:*
- Truy cập https://www.saucedemo.com
- Nhập username: `invalid_user`, password: `wrong_password`
- Click nút "Login"
- Xác minh hiển thị lỗi: "Username and password do not match"

![Kịch bản 2](cypress-exercise/cypress/screenshots/login_spec.cy.js/login-failed.png)

---

**3. Thêm sản phẩm vào giỏ hàng**

*Mục tiêu:* Kiểm tra thêm sản phẩm vào giỏ

*Các bước:*
- Đăng nhập (`standard_user/secret_sauce`)
- Click "Add to cart" cho sản phẩm đầu tiên
- Xác minh badge giỏ hàng hiển thị: 1

![Kịch bản 3](cypress-exercise/cypress/screenshots/cart_spec.cy.js/cart-add-product.png)

---

**4. Lọc sản phẩm theo giá**

*Mục tiêu:* Kiểm tra bộ lọc sắp xếp sản phẩm

*Các bước:*
- Đăng nhập với thông tin hợp lệ
- Chọn bộ lọc "Price (low to high)"
- Xác minh sản phẩm đầu tiên có giá thấp nhất

![Kịch bản 4](cypress-exercise/cypress/screenshots/cart_spec.cy.js/cart-sort-price-low-to-high.png)

---

**5. Xóa sản phẩm khỏi giỏ hàng**

*Mục tiêu:* Kiểm tra xóa sản phẩm trong giỏ

*Các bước:*
- Đăng nhập (`standard_user/secret_sauce`)
- Click "Add to cart" cho sản phẩm đầu tiên
- Xác minh badge giỏ hàng: 1
- Click "Remove"
- Xác minh badge giỏ hàng biến mất

![Demo xóa sản phẩm](cypress-exercise/cypress/videos/cart_spec.cy.js.gif)

---

**6. Quy trình thanh toán hoàn chỉnh**

*Mục tiêu:* Kiểm thử luồng thanh toán từ đầu đến cuối

*Các bước:*
- Đăng nhập (`standard_user/secret_sauce`)
- Thêm sản phẩm đầu tiên vào giỏ
- Click vào icon giỏ hàng, sau đó "Checkout"
- Điền thông tin: First Name: `John`, Last Name: `Doe`, Zip: `12345`
- Click "Continue"
- Xác minh URL chứa `/checkout-step-two.html`

![Demo xóa sản phẩm](cypress-exercise/cypress/videos/checkout_spec.cy.js.gif)

---
<p align="center"> © 2026 TranMC</p>

