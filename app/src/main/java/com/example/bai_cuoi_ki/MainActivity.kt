package com.example.bai_cuoi_ki

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore
fun pushDataToFirebase_baigiai_normal() {
    val database = FirebaseDatabase.getInstance()
    val myRef = database.getReference("Calculations")

    val danhSachBaiToan = mapOf(
        // Lớp 6
        "1" to mapOf(
            "deToan" to "12 * 3",
            "dapAn" to 36,
            "lop" to 6
        ),
        "2" to mapOf(
            "deToan" to "144 / 12",
            "dapAn" to 12,
            "lop" to 6
        ),
        "3" to mapOf(
            "deToan" to "25 + 17 - 8",
            "dapAn" to 34,
            "lop" to 6
        ),
        "4" to mapOf(
            "deToan" to "5 * (6 + 2)",
            "dapAn" to 40,
            "lop" to 6
        ),
        "5" to mapOf(
            "deToan" to "(18 + 6) / 3",
            "dapAn" to 8,
            "lop" to 6
        ),
        "6" to mapOf(
            "deToan" to "72 / (4 * 3)",
            "dapAn" to 6,
            "lop" to 6
        ),
        "7" to mapOf(
            "deToan" to "100 - 25 * 2",
            "dapAn" to 50,
            "lop" to 6
        ),
        "8" to mapOf(
            "deToan" to "2x = 10",
            "dapAn" to 5,
            "lop" to 6
        ),
        "9" to mapOf(
            "deToan" to "3x + 2 = 11",
            "dapAn" to 3,
            "lop" to 6
        ),
        "10" to mapOf(
            "deToan" to "x / 4 = 7",
            "dapAn" to 28,
            "lop" to 6
        ),

        // Lớp 7
        "11" to mapOf(
            "deToan" to "2(x + 3) = 14",
            "dapAn" to 4,
            "lop" to 7
        ),
        "12" to mapOf(
            "deToan" to "(x - 5) * 3 = 21",
            "dapAn" to 12,
            "lop" to 7
        ),
        "13" to mapOf(
            "deToan" to "40% của 80",
            "dapAn" to 32,
            "lop" to 7
        ),
        "14" to mapOf(
            "deToan" to "0.25 * 200",
            "dapAn" to 50,
            "lop" to 7
        ),
        "15" to mapOf(
            "deToan" to "Tìm x: x + 15 = 60",
            "dapAn" to 45,
            "lop" to 7
        ),
        "16" to mapOf(
            "deToan" to "Tìm x: 3x - 4 = 11",
            "dapAn" to 5,
            "lop" to 7
        ),
        "17" to mapOf(
            "deToan" to "Tìm x: x / 2 + 3 = 9",
            "dapAn" to 12,
            "lop" to 7
        ),
        "18" to mapOf(
            "deToan" to "16^2",
            "dapAn" to 256,
            "lop" to 7
        ),
        "19" to mapOf(
            "deToan" to "√81",
            "dapAn" to 9,
            "lop" to 7
        ),
        "20" to mapOf(
            "deToan" to "(-3)^2 + 4",
            "dapAn" to 13,
            "lop" to 7
        ),

        // Lớp 8
        "21" to mapOf(
            "deToan" to "Giải phương trình: 2x² - 8 = 0",
            "dapAn" to "x = ±2",
            "lop" to 8
        ),
        "22" to mapOf(
            "deToan" to "Tính (2x + 3)(x - 1)",
            "dapAn" to "2x² + x - 3",
            "lop" to 8
        ),
        "23" to mapOf(
            "deToan" to "Phân tích đa thức: x² - 4",
            "dapAn" to "(x - 2)(x + 2)",
            "lop" to 8
        ),
        "24" to mapOf(
            "deToan" to "Giải phương trình: 3x - 2y = 5 với x = 1",
            "dapAn" to "y = -1",
            "lop" to 8
        ),
        "25" to mapOf(
            "deToan" to "Tính diện tích hình chữ nhật có chiều dài 5cm, rộng 3cm",
            "dapAn" to 15,
            "lop" to 8
        ),
        "26" to mapOf(
            "deToan" to "Tính thể tích hình lập phương cạnh 4cm",
            "dapAn" to 64,
            "lop" to 8
        ),
        "27" to mapOf(
            "deToan" to "Rút gọn phân thức: (x² - 9)/(x - 3)",
            "dapAn" to "x + 3",
            "lop" to 8
        ),
        "28" to mapOf(
            "deToan" to "Giải bất phương trình: 2x + 5 > 11",
            "dapAn" to "x > 3",
            "lop" to 8
        ),
        "29" to mapOf(
            "deToan" to "Tìm x biết |x - 3| = 5",
            "dapAn" to "x = 8 hoặc x = -2",
            "lop" to 8
        ),
        "30" to mapOf(
            "deToan" to "Tính √(25 + 144)",
            "dapAn" to 13,
            "lop" to 8
        ),

        // Lớp 9
        "31" to mapOf(
            "deToan" to "Giải hệ phương trình: {2x + y = 5; x - y = 1}",
            "dapAn" to "x = 2; y = 1",
            "lop" to 9
        ),
        "32" to mapOf(
            "deToan" to "Giải phương trình: x² - 5x + 6 = 0",
            "dapAn" to "x = 2 hoặc x = 3",
            "lop" to 9
        ),
        "33" to mapOf(
            "deToan" to "Tính sin(30°)",
            "dapAn" to 0.5,
            "lop" to 9
        ),
        "34" to mapOf(
            "deToan" to "Cho tam giác ABC vuông tại A, AB=3, AC=4. Tính BC",
            "dapAn" to 5,
            "lop" to 9
        ),
        "35" to mapOf(
            "deToan" to "Rút gọn: √(50) + √(18)",
            "dapAn" to "8√2",
            "lop" to 9
        ),
        "36" to mapOf(
            "deToan" to "Tìm giá trị nhỏ nhất của hàm số y = x² - 4x + 5",
            "dapAn" to 1,
            "lop" to 9
        ),
        "37" to mapOf(
            "deToan" to "Giải phương trình lượng giác: sinx = 1/2",
            "dapAn" to "x = 30° + k360° hoặc x = 150° + k360°",
            "lop" to 9
        ),
        "38" to mapOf(
            "deToan" to "Tính thể tích hình nón có r=3, h=4 (π=3.14)",
            "dapAn" to 37.68,
            "lop" to 9
        ),
        "39" to mapOf(
            "deToan" to "Tính diện tích mặt cầu bán kính 5cm (π=3.14)",
            "dapAn" to 314,
            "lop" to 9
        ),
        "40" to mapOf(
            "deToan" to "Cho hàm số y = 2x + 3. Tìm y khi x = -1",
            "dapAn" to 1,
            "lop" to 9
        )
    )

    myRef.setValue(danhSachBaiToan)
        .addOnSuccessListener { Log.d("Firebase", "Dữ liệu đã được đẩy lên Firebase thành công!") }
        .addOnFailureListener { Log.e("Firebase", "Lỗi khi đẩy dữ liệu", it) }
}

fun pushDataToFirebase_baigiaicap1() {
    val database = FirebaseDatabase.getInstance()
    val myRef = database.getReference("bai_toan")

    val danhSachBaiToan = mapOf(
        // Lớp 1 (20 bài)
        "1" to mapOf("deToan" to "Hồng có 8 que tính, Lan có 2 que tính. Hỏi cả hai bạn có bao nhiêu que tính?", "dapAn" to 10, "lop" to 1),
        "2" to mapOf("deToan" to "Cành trên có 10 con chim, cành dưới có 5 con chim. Hỏi có tất cả bao nhiêu con chim?", "dapAn" to 15, "lop" to 1),
        "3" to mapOf("deToan" to "Lớp 1B có 33 bạn, lớp 1C có 30 bạn. Hỏi cả hai lớp có tất cả bao nhiêu bạn?", "dapAn" to 63, "lop" to 1),
        "4" to mapOf("deToan" to "Thùng thứ nhất có 15 quả bóng, thùng thứ hai có 11 quả. Hỏi cả hai thùng có bao nhiêu quả bóng?", "dapAn" to 26, "lop" to 1),
        "5" to mapOf("deToan" to "Mẹ mua 16 quả cam, bà cho thêm 3 quả nữa. Hỏi có tất cả bao nhiêu quả cam?", "dapAn" to 19, "lop" to 1),
        "6" to mapOf("deToan" to "Trong vườn có 12 cây táo và 7 cây lê. Hỏi có bao nhiêu cây tất cả?", "dapAn" to 19, "lop" to 1),
        "7" to mapOf("deToan" to "Bạn An có 14 viên kẹo, bạn ăn 2 viên. Hỏi còn lại bao nhiêu viên?", "dapAn" to 12, "lop" to 1),
        "8" to mapOf("deToan" to "Lớp 1A có 20 bạn nam và 15 bạn nữ. Hỏi lớp có bao nhiêu học sinh?", "dapAn" to 35, "lop" to 1),
        "9" to mapOf("deToan" to "Hộp bút có 10 cái bút, lấy ra 3 cái. Hỏi còn lại mấy cái?", "dapAn" to 7, "lop" to 1),
        "10" to mapOf("deToan" to "Giỏ có 18 quả trứng, thêm 2 quả nữa. Hỏi có bao nhiêu quả trứng?", "dapAn" to 20, "lop" to 1),
        "11" to mapOf("deToan" to "Bác nông dân thu hoạch 25kg thóc, bán đi 5kg. Hỏi còn lại bao nhiêu kg?", "dapAn" to 20, "lop" to 1),
        "12" to mapOf("deToan" to "Có 30 con gà, 12 con chạy đi. Hỏi còn lại bao nhiêu con?", "dapAn" to 18, "lop" to 1),
        "13" to mapOf("deToan" to "Tủ sách có 40 quyển, mẹ mua thêm 10 quyển. Hỏi có tất cả bao nhiêu quyển?", "dapAn" to 50, "lop" to 1),
        "14" to mapOf("deToan" to "Bình có 50 viên bi, cho bạn 20 viên. Hỏi Bình còn mấy viên?", "dapAn" to 30, "lop" to 1),
        "15" to mapOf("deToan" to "Có 60 bông hoa, hái 25 bông. Hỏi còn lại bao nhiêu bông?", "dapAn" to 35, "lop" to 1),
        "16" to mapOf("deToan" to "Đàn vịt có 45 con, 15 con xuống ao. Hỏi trên bờ còn bao nhiêu con?", "dapAn" to 30, "lop" to 1),
        "17" to mapOf("deToan" to "Cửa hàng có 38 cái bánh, bán 18 cái. Hỏi còn lại bao nhiêu cái?", "dapAn" to 20, "lop" to 1),
        "18" to mapOf("deToan" to "Lớp học có 25 cái ghế, thêm 5 cái nữa. Hỏi có tất cả bao nhiêu cái?", "dapAn" to 30, "lop" to 1),
        "19" to mapOf("deToan" to "Hộp có 20 viên phấn, dùng hết 12 viên. Hỏi còn lại mấy viên?", "dapAn" to 8, "lop" to 1),
        "20" to mapOf("deToan" to "Vườn nhà Nam có 15 cây xoài và 10 cây ổi. Hỏi có tất cả bao nhiêu cây?", "dapAn" to 25, "lop" to 1),

        // Lớp 2 (20 bài)
        "21" to mapOf("deToan" to "Tú có 1 chục quyển vở, được thưởng 5 quyển nữa. Hỏi Tú có bao nhiêu quyển?", "dapAn" to 15, "lop" to 2),
        "22" to mapOf("deToan" to "Huệ có 2 chục bút chì, mẹ mua thêm 5 cái. Hỏi Huệ có bao nhiêu bút chì?", "dapAn" to 25, "lop" to 2),
        "23" to mapOf("deToan" to "Tổ Một làm 20 lá cờ, tổ Hai làm 10 lá. Hỏi cả hai tổ làm bao nhiêu lá cờ?", "dapAn" to 30, "lop" to 2),
        "24" to mapOf("deToan" to "Một ngày có 24 giờ, đã qua 15 giờ. Hỏi còn lại bao nhiêu giờ?", "dapAn" to 9, "lop" to 2),
        "25" to mapOf("deToan" to "Bao gạo nặng 50kg, đã dùng 25kg. Hỏi còn lại bao nhiêu kg?", "dapAn" to 25, "lop" to 2),
        "26" to mapOf("deToan" to "Có 3 chục quả cam, xếp vào 5 đĩa. Hỏi mỗi đĩa có mấy quả?", "dapAn" to 6, "lop" to 2),
        "27" to mapOf("deToan" to "Một tuần có 7 ngày, 3 tuần có bao nhiêu ngày?", "dapAn" to 21, "lop" to 2),
        "28" to mapOf("deToan" to "Có 18 lít dầu chia đều vào 3 can. Hỏi mỗi can có mấy lít?", "dapAn" to 6, "lop" to 2),
        "29" to mapOf("deToan" to "Mỗi gói kẹo có 5 cái, hỏi 6 gói có bao nhiêu cái kẹo?", "dapAn" to 30, "lop" to 2),
        "30" to mapOf("deToan" to "Mỗi lọ hoa cắm 3 bông, hỏi 7 lọ cắm bao nhiêu bông?", "dapAn" to 21, "lop" to 2),
        "31" to mapOf("deToan" to "Có 45 học sinh xếp thành 5 hàng. Hỏi mỗi hàng có mấy bạn?", "dapAn" to 9, "lop" to 2),
        "32" to mapOf("deToan" to "Mỗi hộp có 4 cái bánh, 9 hộp có bao nhiêu cái bánh?", "dapAn" to 36, "lop" to 2),
        "33" to mapOf("deToan" to "Có 28 viên bi chia đều cho 4 bạn. Hỏi mỗi bạn được mấy viên?", "dapAn" to 7, "lop" to 2),
        "34" to mapOf("deToan" to "Mỗi bàn có 2 học sinh, lớp có 15 bàn. Hỏi có bao nhiêu học sinh?", "dapAn" to 30, "lop" to 2),
        "35" to mapOf("deToan" to "Có 36 quả cam xếp vào các đĩa, mỗi đĩa 6 quả. Hỏi cần mấy đĩa?", "dapAn" to 6, "lop" to 2),
        "36" to mapOf("deToan" to "Mỗi túi đựng 5kg gạo, 8 túi đựng bao nhiêu kg?", "dapAn" to 40, "lop" to 2),
        "37" to mapOf("deToan" to "Có 40 cái kẹo chia đều cho 5 bạn. Hỏi mỗi bạn được mấy cái?", "dapAn" to 8, "lop" to 2),
        "38" to mapOf("deToan" to "Mỗi ngày đọc 4 trang sách, 9 ngày đọc bao nhiêu trang?", "dapAn" to 36, "lop" to 2),
        "39" to mapOf("deToan" to "Có 30 bông hoa cắm vào 5 lọ. Hỏi mỗi lọ có mấy bông?", "dapAn" to 6, "lop" to 2),
        "40" to mapOf("deToan" to "Mỗi hộp có 3 viên bi, 10 hộp có bao nhiêu viên bi?", "dapAn" to 30, "lop" to 2),

        // Lớp 3 (20 bài)
        "41" to mapOf("deToan" to "Hải có 25 viên bi, Nam nhiều hơn Hải 20 viên. Hỏi Nam có bao nhiêu viên?", "dapAn" to 45, "lop" to 3),
        "42" to mapOf("deToan" to "Lớp 3A có 34 học sinh, nhiều hơn lớp 3B 4 bạn. Hỏi lớp 3B có bao nhiêu bạn?", "dapAn" to 30, "lop" to 3),
        "43" to mapOf("deToan" to "Tùng có 36 bóng bay, nhiều hơn Toàn 5 quả. Hỏi Toàn có bao nhiêu quả?", "dapAn" to 31, "lop" to 3),
        "44" to mapOf("deToan" to "Vườn nhà Nam có 28 cây bưởi, nhiều hơn cây cam 20 cây. Hỏi có bao nhiêu cây cam?", "dapAn" to 8, "lop" to 3),
        "45" to mapOf("deToan" to "Nhà An có 32 con gà, ít hơn nhà Tú 20 con. Hỏi nhà Tú có bao nhiêu con?", "dapAn" to 52, "lop" to 3),
        "46" to mapOf("deToan" to "Một cửa hàng bán được 135 lít dầu, buổi chiều bán ít hơn buổi sáng 28 lít. Hỏi buổi chiều bán bao nhiêu lít?", "dapAn" to 107, "lop" to 3),
        "47" to mapOf("deToan" to "Một hình chữ nhật có chiều dài 12cm, chiều rộng 8cm. Tính chu vi hình đó.", "dapAn" to 40, "lop" to 3),
        "48" to mapOf("deToan" to "Tính: 125 + 378", "dapAn" to 503, "lop" to 3),
        "49" to mapOf("deToan" to "Tính: 456 - 189", "dapAn" to 267, "lop" to 3),
        "50" to mapOf("deToan" to "Tìm x: x + 125 = 400", "dapAn" to 275, "lop" to 3),
        "51" to mapOf("deToan" to "Tìm x: x - 75 = 125", "dapAn" to 200, "lop" to 3),
        "52" to mapOf("deToan" to "Có 360 quyển sách xếp vào 9 ngăn. Hỏi mỗi ngăn có bao nhiêu quyển?", "dapAn" to 40, "lop" to 3),
        "53" to mapOf("deToan" to "Một năm có 12 tháng, 5 năm có bao nhiêu tháng?", "dapAn" to 60, "lop" to 3),
        "54" to mapOf("deToan" to "Mỗi thùng có 24 chai nước, 8 thùng có bao nhiêu chai?", "dapAn" to 192, "lop" to 3),
        "55" to mapOf("deToan" to "Một sợi dây dài 72cm cắt thành 8 đoạn bằng nhau. Hỏi mỗi đoạn dài bao nhiêu cm?", "dapAn" to 9, "lop" to 3),
        "56" to mapOf("deToan" to "Mỗi hộp bút có 12 cái, 6 hộp có bao nhiêu cái bút?", "dapAn" to 72, "lop" to 3),
        "57" to mapOf("deToan" to "Một bao gạo nặng 50kg, 7 bao như thế nặng bao nhiêu kg?", "dapAn" to 350, "lop" to 3),
        "58" to mapOf("deToan" to "Một tuần lễ có 7 ngày, 4 tuần lễ có bao nhiêu ngày?", "dapAn" to 28, "lop" to 3),
        "59" to mapOf("deToan" to "Mỗi giờ có 60 phút, 5 giờ có bao nhiêu phút?", "dapAn" to 300, "lop" to 3),
        "60" to mapOf("deToan" to "Một thùng dầu đựng 45 lít, 6 thùng đựng bao nhiêu lít?", "dapAn" to 270, "lop" to 3),

        // Lớp 4 (20 bài)
        "61" to mapOf("deToan" to "Hoàng có 25 nhãn vở, ít hơn Thanh 20 cái. Hỏi Thanh có bao nhiêu cái?", "dapAn" to 45, "lop" to 4),
        "62" to mapOf("deToan" to "Lan có 42 que tính, ít hơn Hoa 20 que. Hỏi Hoa có bao nhiêu que?", "dapAn" to 62, "lop" to 4),
        "63" to mapOf("deToan" to "Đàn gà có 45 con, sau khi bán còn lại 20 con. Hỏi đã bán bao nhiêu con?", "dapAn" to 25, "lop" to 4),
        "64" to mapOf("deToan" to "Một hình chữ nhật có chiều dài 15cm, chiều rộng bằng 1/3 chiều dài. Tính diện tích.", "dapAn" to 75, "lop" to 4),
        "65" to mapOf("deToan" to "Tính: 2/5 + 3/10", "dapAn" to "7/10", "lop" to 4),
        "66" to mapOf("deToan" to "Tính: 5/6 - 1/3", "dapAn" to "1/2", "lop" to 4),
        "67" to mapOf("deToan" to "Tìm x: x × 12 = 144", "dapAn" to 12, "lop" to 4),
        "68" to mapOf("deToan" to "Tìm x: x : 8 = 15", "dapAn" to 120, "lop" to 4),
        "69" to mapOf("deToan" to "Một ô tô đi 180km trong 3 giờ. Hỏi mỗi giờ đi được bao nhiêu km?", "dapAn" to 60, "lop" to 4),
        "70" to mapOf("deToan" to "Có 245kg gạo chia vào 7 bao. Hỏi mỗi bao có bao nhiêu kg?", "dapAn" to 35, "lop" to 4),
        "71" to mapOf("deToan" to "Một hình vuông có chu vi 36cm. Tính độ dài cạnh hình vuông.", "dapAn" to 9, "lop" to 4),
        "72" to mapOf("deToan" to "Tính giá trị biểu thức: 125 × 3 + 75", "dapAn" to 450, "lop" to 4),
        "73" to mapOf("deToan" to "Tính giá trị biểu thức: 480 : 6 + 120", "dapAn" to 200, "lop" to 4),
        "74" to mapOf("deToan" to "Một thửa ruộng hình chữ nhật có chiều dài 25m, chiều rộng 15m. Tính diện tích.", "dapAn" to 375, "lop" to 4),
        "75" to mapOf("deToan" to "Một cửa hàng có 365 ngày. Hỏi có bao nhiêu tuần lễ và mấy ngày?", "dapAn" to "52 tuần 1 ngày", "lop" to 4),
        "76" to mapOf("deToan" to "Một năm không nhuận có bao nhiêu ngày?", "dapAn" to 365, "lop" to 4),
        "77" to mapOf("deToan" to "Tính: 25 × 11", "dapAn" to 275, "lop" to 4),
        "78" to mapOf("deToan" to "Tính: 125 × 8", "dapAn" to 1000, "lop" to 4),
        "79" to mapOf("deToan" to "Tính: 246 : 6", "dapAn" to 41, "lop" to 4),
        "80" to mapOf("deToan" to "Tính: 525 : 5", "dapAn" to 105, "lop" to 4),

        // Lớp 5 (20 bài)
        "81" to mapOf("deToan" to "Năm nay Hoàng 9 tuổi, nhiều hơn Nam 2 tuổi. Hỏi Nam mấy tuổi?", "dapAn" to 7, "lop" to 5),
        "82" to mapOf("deToan" to "Con 13 tuổi, kém mẹ 25 tuổi. Hỏi mẹ bao nhiêu tuổi?", "dapAn" to 38, "lop" to 5),
        "83" to mapOf("deToan" to "Một thửa ruộng hình chữ nhật có chiều dài 80m, chiều rộng bằng 1/2 chiều dài. Tính diện tích.", "dapAn" to 3200, "lop" to 5),
        "84" to mapOf("deToan" to "Một ô tô đi 135km trong 3 giờ. Hỏi 5 giờ đi được bao nhiêu km?", "dapAn" to 225, "lop" to 5),
        "85" to mapOf("deToan" to "Tính: 3/5 + 2/7", "dapAn" to "31/35", "lop" to 5),
        "86" to mapOf("deToan" to "Tính: 5/6 - 3/4", "dapAn" to "1/12", "lop" to 5),
        "87" to mapOf("deToan" to "Tính: 2 3/5 + 1 4/5", "dapAn" to "4 2/5", "lop" to 5),
        "88" to mapOf("deToan" to "Tính: 4 1/2 - 2 3/4", "dapAn" to "1 3/4", "lop" to 5),
        "89" to mapOf("deToan" to "Tìm x: x × 3/5 = 6/7", "dapAn" to "10/7", "lop" to 5),
        "90" to mapOf("deToan" to "Tìm x: x : 2/3 = 5/6", "dapAn" to "5/9", "lop" to 5),
        "91" to mapOf("deToan" to "Một hình thoi có độ dài hai đường chéo là 12cm và 8cm. Tính diện tích.", "dapAn" to 48, "lop" to 5),
        "92" to mapOf("deToan" to "Một hình tam giác có đáy 15cm, chiều cao 8cm. Tính diện tích.", "dapAn" to 60, "lop" to 5),
        "93" to mapOf("deToan" to "Một hình tròn có bán kính 7cm. Tính chu vi hình tròn (π=3.14).", "dapAn" to 43.96, "lop" to 5),
        "94" to mapOf("deToan" to "Một bể nước hình hộp chữ nhật có chiều dài 2m, rộng 1.5m, cao 1m. Tính thể tích.", "dapAn" to 3, "lop" to 5),
        "95" to mapOf("deToan" to "Một người đi bộ 15km trong 3 giờ. Hỏi trong 5 giờ đi được bao nhiêu km?", "dapAn" to 25, "lop" to 5),
        "96" to mapOf("deToan" to "Một đội công nhân làm xong công việc trong 10 ngày. Hỏi 5 ngày làm được mấy phần công việc?", "dapAn" to "1/2", "lop" to 5),
        "97" to mapOf("deToan" to "Tính: 0.75 + 1.25", "dapAn" to 2.0, "lop" to 5),
        "98" to mapOf("deToan" to "Tính: 3.6 - 1.8", "dapAn" to 1.8, "lop" to 5),
        "99" to mapOf("deToan" to "Tính: 2.5 × 4", "dapAn" to 10.0, "lop" to 5),
        "100" to mapOf("deToan" to "Tính: 6.4 : 2", "dapAn" to 3.2, "lop" to 5)
    )

    myRef.setValue(danhSachBaiToan)
        .addOnSuccessListener { Log.d("Firebase", "Dữ liệu đã được đẩy lên Firebase thành công!") }
        .addOnFailureListener { Log.e("Firebase", "Lỗi khi đẩy dữ liệu", it) }
}
fun pushDataToFirebase_baihinhcap1() {
    val database = FirebaseDatabase.getInstance()
    val myRef = database.getReference("Bai_hinh")

    val danhSachBaiToanHinh = mapOf(
        // Lớp 1
        "1" to mapOf("deToan" to "Một hình vuông có cạnh 4 cm. Hỏi chu vi của hình vuông là bao nhiêu?", "dapAn" to 16, "lop" to 1),
        "2" to mapOf("deToan" to "Một hình vuông có cạnh dài 3 cm. Hỏi diện tích của hình vuông là bao nhiêu?", "dapAn" to 9, "lop" to 1),
        "3" to mapOf("deToan" to "Một hình chữ nhật có chiều dài 6 cm, chiều rộng 4 cm. Hỏi chu vi của hình chữ nhật là bao nhiêu?", "dapAn" to 20, "lop" to 1),
        "4" to mapOf("deToan" to "Một hình tròn có bán kính 5 cm. Hỏi đường kính của hình tròn là bao nhiêu?", "dapAn" to 10, "lop" to 1),
        "5" to mapOf("deToan" to "Một hình vuông có chu vi 12 cm. Hỏi cạnh của hình vuông dài bao nhiêu?", "dapAn" to 3, "lop" to 1),
        "6" to mapOf("deToan" to "Một hình chữ nhật có chu vi 20 cm, chiều dài là 6 cm. Hỏi chiều rộng là bao nhiêu?", "dapAn" to 4, "lop" to 1),
        "7" to mapOf("deToan" to "Một hình vuông có diện tích 25 cm². Hỏi cạnh của hình vuông dài bao nhiêu?", "dapAn" to 5, "lop" to 1),
        "8" to mapOf("deToan" to "Một hình chữ nhật có diện tích 24 cm², chiều dài là 6 cm. Hỏi chiều rộng là bao nhiêu?", "dapAn" to 4, "lop" to 1),
        "9" to mapOf("deToan" to "Một hình tròn có bán kính 3 cm. Hỏi diện tích của hình tròn là bao nhiêu?", "dapAn" to 28.27, "lop" to 1),
        "10" to mapOf("deToan" to "Một hình vuông có cạnh dài 7 cm. Hỏi chu vi của hình vuông là bao nhiêu?", "dapAn" to 28, "lop" to 1),

        // Lớp 2
        "11" to mapOf("deToan" to "Một hình vuông có cạnh dài 6 cm. Hỏi diện tích của hình vuông là bao nhiêu?", "dapAn" to 36, "lop" to 2),
        "12" to mapOf("deToan" to "Một hình chữ nhật có chiều dài 8 cm, chiều rộng 5 cm. Hỏi chu vi của hình chữ nhật là bao nhiêu?", "dapAn" to 26, "lop" to 2),
        "13" to mapOf("deToan" to "Một hình tròn có bán kính 7 cm. Hỏi đường kính của hình tròn là bao nhiêu?", "dapAn" to 14, "lop" to 2),
        "14" to mapOf("deToan" to "Một hình vuông có diện tích 64 cm². Hỏi cạnh của hình vuông dài bao nhiêu?", "dapAn" to 8, "lop" to 2),
        "15" to mapOf("deToan" to "Một hình chữ nhật có chu vi 40 cm, chiều dài là 12 cm. Hỏi chiều rộng là bao nhiêu?", "dapAn" to 8, "lop" to 2),
        "16" to mapOf("deToan" to "Một hình vuông có chu vi 24 cm. Hỏi cạnh của hình vuông dài bao nhiêu?", "dapAn" to 6, "lop" to 2),
        "17" to mapOf("deToan" to "Một hình chữ nhật có diện tích 30 cm², chiều dài là 6 cm. Hỏi chiều rộng là bao nhiêu?", "dapAn" to 5, "lop" to 2),
        "18" to mapOf("deToan" to "Một hình tròn có bán kính 10 cm. Hỏi diện tích của hình tròn là bao nhiêu?", "dapAn" to 314, "lop" to 2),
        "19" to mapOf("deToan" to "Một hình vuông có chu vi 32 cm. Hỏi cạnh của hình vuông dài bao nhiêu?", "dapAn" to 8, "lop" to 2),
        "20" to mapOf("deToan" to "Một hình chữ nhật có chiều dài 10 cm, chiều rộng 6 cm. Hỏi diện tích của hình chữ nhật là bao nhiêu?", "dapAn" to 60, "lop" to 2),

        // Lớp 3
        "21" to mapOf("deToan" to "Một hình vuông có chu vi 36 cm. Hỏi cạnh của hình vuông dài bao nhiêu?", "dapAn" to 9, "lop" to 3),
        "22" to mapOf("deToan" to "Một hình chữ nhật có chiều dài 12 cm, chiều rộng 7 cm. Hỏi chu vi của hình chữ nhật là bao nhiêu?", "dapAn" to 38, "lop" to 3),
        "23" to mapOf("deToan" to "Một hình tròn có bán kính 9 cm. Hỏi đường kính của hình tròn là bao nhiêu?", "dapAn" to 18, "lop" to 3),
        "24" to mapOf("deToan" to "Một hình vuông có diện tích 121 cm². Hỏi cạnh của hình vuông dài bao nhiêu?", "dapAn" to 11, "lop" to 3),
        "25" to mapOf("deToan" to "Một hình chữ nhật có chu vi 40 cm, chiều dài là 14 cm. Hỏi chiều rộng là bao nhiêu?", "dapAn" to 6, "lop" to 3),
        "26" to mapOf("deToan" to "Một hình vuông có chu vi 48 cm. Hỏi cạnh của hình vuông dài bao nhiêu?", "dapAn" to 12, "lop" to 3),
        "27" to mapOf("deToan" to "Một hình chữ nhật có diện tích 56 cm², chiều dài là 7 cm. Hỏi chiều rộng là bao nhiêu?", "dapAn" to 8, "lop" to 3),
        "28" to mapOf("deToan" to "Một hình tròn có bán kính 8 cm. Hỏi diện tích của hình tròn là bao nhiêu?", "dapAn" to 201.06, "lop" to 3),
        "29" to mapOf("deToan" to "Một hình vuông có chu vi 56 cm. Hỏi cạnh của hình vuông dài bao nhiêu?", "dapAn" to 14, "lop" to 3),
        "30" to mapOf("deToan" to "Một hình chữ nhật có diện tích 72 cm², chiều dài là 9 cm. Hỏi chiều rộng là bao nhiêu?", "dapAn" to 8, "lop" to 3),

        // Lớp 4
        "31" to mapOf("deToan" to "Một hình vuông có chu vi 60 cm. Hỏi cạnh là bao nhiêu?", "dapAn" to 15, "lop" to 4),
        "32" to mapOf("deToan" to "Một hình chữ nhật có chiều dài 16 cm, chiều rộng 8 cm. Hỏi diện tích là bao nhiêu?", "dapAn" to 128, "lop" to 4),
        "33" to mapOf("deToan" to "Một hình tròn có bán kính 12 cm. Hỏi diện tích của hình tròn là bao nhiêu?", "dapAn" to 452.39, "lop" to 4),
        "34" to mapOf("deToan" to "Một hình vuông có diện tích 225 cm². Hỏi cạnh của hình vuông dài bao nhiêu?", "dapAn" to 15, "lop" to 4),
        "35" to mapOf("deToan" to "Một hình chữ nhật có chu vi 80 cm, chiều dài là 24 cm. Hỏi chiều rộng là bao nhiêu?", "dapAn" to 16, "lop" to 4),
        "36" to mapOf("deToan" to "Một hình vuông có chu vi 72 cm. Hỏi cạnh của hình vuông dài bao nhiêu?", "dapAn" to 18, "lop" to 4),
        "37" to mapOf("deToan" to "Một hình chữ nhật có diện tích 96 cm², chiều dài là 12 cm. Hỏi chiều rộng là bao nhiêu?", "dapAn" to 8, "lop" to 4),
        "38" to mapOf("deToan" to "Một hình tròn có bán kính 14 cm. Hỏi diện tích của hình tròn là bao nhiêu?", "dapAn" to 615.75, "lop" to 4),
        "39" to mapOf("deToan" to "Một hình vuông có diện tích 400 cm². Hỏi cạnh của hình vuông dài bao nhiêu?", "dapAn" to 20, "lop" to 4),
        "40" to mapOf("deToan" to "Một hình chữ nhật có chu vi 60 cm, chiều dài là 18 cm. Hỏi chiều rộng là bao nhiêu?", "dapAn" to 12, "lop" to 4),

        // Lớp 5
        "41" to mapOf("deToan" to "Một hình vuông có chu vi 80 cm. Hỏi cạnh của hình vuông dài bao nhiêu?", "dapAn" to 20, "lop" to 5),
        "42" to mapOf("deToan" to "Một hình chữ nhật có chiều dài 20 cm, chiều rộng 12 cm. Hỏi diện tích của hình chữ nhật là bao nhiêu?", "dapAn" to 240, "lop" to 5),
        "43" to mapOf("deToan" to "Một hình tròn có bán kính 16 cm. Hỏi diện tích của hình tròn là bao nhiêu?", "dapAn" to 804.25, "lop" to 5),
        "44" to mapOf("deToan" to "Một hình vuông có diện tích 625 cm². Hỏi cạnh của hình vuông dài bao nhiêu?", "dapAn" to 25, "lop" to 5),
        "45" to mapOf("deToan" to "Một hình chữ nhật có chu vi 72 cm, chiều dài là 26 cm. Hỏi chiều rộng là bao nhiêu?", "dapAn" to 10, "lop" to 5),
        "46" to mapOf("deToan" to "Một hình vuông có chu vi 100 cm. Hỏi cạnh của hình vuông dài bao nhiêu?", "dapAn" to 25, "lop" to 5),
        "47" to mapOf("deToan" to "Một hình chữ nhật có diện tích 120 cm², chiều dài là 15 cm. Hỏi chiều rộng là bao nhiêu?", "dapAn" to 8, "lop" to 5),
        "48" to mapOf("deToan" to "Một hình tròn có bán kính 18 cm. Hỏi diện tích của hình tròn là bao nhiêu?", "dapAn" to 1017.88, "lop" to 5),
        "49" to mapOf("deToan" to "Một hình vuông có diện tích 900 cm². Hỏi cạnh của hình vuông dài bao nhiêu?", "dapAn" to 30, "lop" to 5),
        "50" to mapOf("deToan" to "Một hình chữ nhật có chu vi 80 cm, chiều dài là 25 cm. Hỏi chiều rộng là bao nhiêu?", "dapAn" to 15, "lop" to 5)
    )

    myRef.setValue(danhSachBaiToanHinh)
        .addOnSuccessListener { Log.d("Firebase", "Dữ liệu đã được đẩy lên Firebase thành công!") }
        .addOnFailureListener { Log.e("Firebase", "Lỗi khi đẩy dữ liệu", it) }
}

fun pushDataToFirebase_baigiaicap2() {
    val database = FirebaseDatabase.getInstance()
    val myRef = database.getReference("bai_toan_cap2")

    val danhSachBaiToan = mapOf(
        // Lớp 6
        "1" to mapOf("deToan" to "Một ô tô đi từ A đến B với vận tốc 60 km/h trong 3 giờ. Hỏi quãng đường từ A đến B dài bao nhiêu km?", "dapAn" to 180, "lop" to 6),
        "2" to mapOf("deToan" to "Một hình vuông có diện tích 81 cm². Hỏi cạnh của hình vuông dài bao nhiêu?", "dapAn" to 9, "lop" to 6),
        "3" to mapOf("deToan" to "Một mảnh đất hình chữ nhật có chiều dài 30m và chiều rộng 20m. Hỏi diện tích mảnh đất đó?", "dapAn" to 600, "lop" to 6),
        "4" to mapOf("deToan" to "Một chiếc xe máy đi quãng đường 120 km trong 2 giờ. Hỏi vận tốc trung bình của xe máy là bao nhiêu km/h?", "dapAn" to 60, "lop" to 6),
        "5" to mapOf("deToan" to "Một hình tròn có bán kính 7 cm. Hỏi diện tích của hình tròn là bao nhiêu? (Lấy π ≈ 3.14)", "dapAn" to 153.94, "lop" to 6),
        "6" to mapOf("deToan" to "Một lớp học có 45 học sinh, trong đó có 20 học sinh nữ. Hỏi số học sinh nam trong lớp?", "dapAn" to 25, "lop" to 6),
        "7" to mapOf("deToan" to "Một bể nước hình hộp chữ nhật có chiều dài 4m, chiều rộng 2m và chiều cao 3m. Hỏi thể tích của bể nước?", "dapAn" to 24, "lop" to 6),
        "8" to mapOf("deToan" to "Một chiếc xe buýt chạy với vận tốc 50 km/h. Hỏi sau 4 giờ, xe đã đi được bao nhiêu km?", "dapAn" to 200, "lop" to 6),
        "9" to mapOf("deToan" to "Một người đi xe đạp từ A đến B với vận tốc 12 km/h. Hỏi sau 5 giờ, người đó đã đi được bao nhiêu km?", "dapAn" to 60, "lop" to 6),
        "10" to mapOf("deToan" to "Một hộp hình vuông có diện tích 16 cm². Hỏi chiều dài của một cạnh của hộp?", "dapAn" to 4, "lop" to 6),
        "11" to mapOf("deToan" to "Một lớp học có 40 học sinh, trong đó có 25 học sinh giỏi. Hỏi số học sinh không giỏi?", "dapAn" to 15, "lop" to 6),
        "12" to mapOf("deToan" to "Một hình tam giác có đáy dài 10cm và chiều cao 8cm. Hỏi diện tích của hình tam giác là bao nhiêu?", "dapAn" to 40, "lop" to 6),
        "13" to mapOf("deToan" to "Một người đi bộ 30 phút mỗi ngày với vận tốc 4 km/h. Hỏi trong 1 tuần (7 ngày), người đó đi được bao nhiêu km?", "dapAn" to 28, "lop" to 6),
        "14" to mapOf("deToan" to "Một hình chữ nhật có chiều dài 5m và chiều rộng 3m. Hỏi diện tích của hình chữ nhật đó?", "dapAn" to 15, "lop" to 6),
        "15" to mapOf("deToan" to "Một lớp học có 50 học sinh, trong đó có 30 học sinh giỏi. Hỏi số học sinh không giỏi?", "dapAn" to 20, "lop" to 6),
        "16" to mapOf("deToan" to "Một hình vuông có diện tích 36 cm². Hỏi cạnh của hình vuông dài bao nhiêu?", "dapAn" to 6, "lop" to 6),
        "17" to mapOf("deToan" to "Một cửa hàng bán một sản phẩm với giá 500,000 VND. Nếu giảm giá 10%, hỏi số tiền giảm là bao nhiêu?", "dapAn" to 50000, "lop" to 6),
        "18" to mapOf("deToan" to "Một cửa hàng bán một sản phẩm với giá 300,000 VND. Nếu giảm giá 20%, hỏi số tiền giảm là bao nhiêu?", "dapAn" to 60000, "lop" to 6),
        "19" to mapOf("deToan" to "Một người tiết kiệm được 10% số tiền lương hàng tháng. Nếu lương của người đó là 12 triệu đồng, hỏi số tiền tiết kiệm mỗi tháng là bao nhiêu?", "dapAn" to 1200000, "lop" to 6),
        "20" to mapOf("deToan" to "Một bể chứa nước có thể chứa 800 lít nước. Hiện tại bể chứa đã có 600 lít. Hỏi cần thêm bao nhiêu lít nước để đầy?", "dapAn" to 200, "lop" to 6),

        // Lớp 7
        "21" to mapOf("deToan" to "Một đoàn tàu đi từ A đến B mất 5 giờ với vận tốc 80 km/h. Hỏi quãng đường từ A đến B dài bao nhiêu km?", "dapAn" to 400, "lop" to 7),
        "22" to mapOf("deToan" to "Một hình tròn có bán kính 10 cm. Hỏi chu vi của hình tròn đó là bao nhiêu? (Lấy π ≈ 3.14)", "dapAn" to 62.8, "lop" to 7),
        "23" to mapOf("deToan" to "Một hình chữ nhật có chiều dài 12m và chiều rộng 8m. Hỏi diện tích của hình chữ nhật?", "dapAn" to 96, "lop" to 7),
        "24" to mapOf("deToan" to "Một người đi bộ 3 giờ với vận tốc 5 km/h. Hỏi quãng đường mà người đó đã đi?", "dapAn" to 15, "lop" to 7),
        "25" to mapOf("deToan" to "Một chiếc xe máy đi quãng đường 150 km trong 3 giờ. Hỏi vận tốc trung bình của xe máy là bao nhiêu km/h?", "dapAn" to 50, "lop" to 7),
        "26" to mapOf("deToan" to "Một bể nước có thể chứa 500 lít nước. Hiện tại đã có 200 lít. Hỏi cần thêm bao nhiêu lít để đầy?", "dapAn" to 300, "lop" to 7),
        "27" to mapOf("deToan" to "Một hình vuông có cạnh dài 10 cm. Hỏi diện tích của hình vuông?", "dapAn" to 100, "lop" to 7),
        "28" to mapOf("deToan" to "Một chiếc ô tô đi từ A đến B với vận tốc 60 km/h trong 4 giờ. Hỏi quãng đường từ A đến B dài bao nhiêu km?", "dapAn" to 240, "lop" to 7),
        "29" to mapOf("deToan" to "Một chiếc xe buýt đi với vận tốc 70 km/h. Hỏi sau 2 giờ, xe đã đi được bao nhiêu km?", "dapAn" to 140, "lop" to 7),
        "30" to mapOf("deToan" to "Một người tiết kiệm được 8% số tiền lương hàng tháng. Nếu lương của người đó là 9 triệu đồng, hỏi số tiền tiết kiệm mỗi tháng là bao nhiêu?", "dapAn" to 720000, "lop" to 7),

        // Lớp 8
        "31" to mapOf("deToan" to "Một hình chữ nhật có chiều dài 18cm và chiều rộng 12cm. Hỏi diện tích của hình chữ nhật?", "dapAn" to 216, "lop" to 8),
        "32" to mapOf("deToan" to "Một chiếc ô tô chạy với vận tốc 72 km/h. Hỏi sau 5 giờ, ô tô đã đi được bao nhiêu km?", "dapAn" to 360, "lop" to 8),
        "33" to mapOf("deToan" to "Một hình tròn có bán kính 14 cm. Hỏi diện tích của hình tròn? (Lấy π ≈ 3.14)", "dapAn" to 615.44, "lop" to 8),
        "34" to mapOf("deToan" to "Một người tiết kiệm được 15% số tiền lương hàng tháng. Nếu lương của người đó là 15 triệu đồng, hỏi số tiền tiết kiệm mỗi tháng là bao nhiêu?", "dapAn" to 2250000, "lop" to 8),
        "35" to mapOf("deToan" to "Một hình tam giác có đáy dài 12cm và chiều cao 8cm. Hỏi diện tích của hình tam giác?", "dapAn" to 48, "lop" to 8),
        "36" to mapOf("deToan" to "Một bể nước có thể chứa 1000 lít nước. Hiện tại đã có 600 lít. Hỏi cần thêm bao nhiêu lít để đầy?", "dapAn" to 400, "lop" to 8),
        "37" to mapOf("deToan" to "Một đoàn tàu chạy với vận tốc 90 km/h. Hỏi sau 6 giờ, tàu đã đi được bao nhiêu km?", "dapAn" to 540, "lop" to 8),
        "38" to mapOf("deToan" to "Một hình vuông có diện tích 144 cm². Hỏi cạnh của hình vuông dài bao nhiêu?", "dapAn" to 12, "lop" to 8),
        "39" to mapOf("deToan" to "Một cửa hàng bán một sản phẩm với giá 500,000 VND. Nếu giảm giá 15%, hỏi số tiền giảm là bao nhiêu?", "dapAn" to 75000, "lop" to 8),
        "40" to mapOf("deToan" to "Một chiếc xe buýt đi quãng đường 240 km trong 5 giờ. Hỏi vận tốc trung bình của xe buýt là bao nhiêu km/h?", "dapAn" to 48, "lop" to 8),

        // Lớp 9
        "41" to mapOf("deToan" to "Một hình tròn có bán kính 10cm. Hỏi diện tích của hình tròn? (Lấy π ≈ 3.14)", "dapAn" to 314, "lop" to 9),
        "42" to mapOf("deToan" to "Một hình chữ nhật có chiều dài 20m và chiều rộng 12m. Hỏi diện tích của hình chữ nhật?", "dapAn" to 240, "lop" to 9),
        "43" to mapOf("deToan" to "Một đoàn tàu đi từ A đến B mất 4 giờ với vận tốc 100 km/h. Hỏi quãng đường từ A đến B dài bao nhiêu km?", "dapAn" to 400, "lop" to 9),
        "44" to mapOf("deToan" to "Một hình vuông có diện tích 256 cm². Hỏi cạnh của hình vuông dài bao nhiêu?", "dapAn" to 16, "lop" to 9),
        "45" to mapOf("deToan" to "Một bể nước có thể chứa 2000 lít nước. Hiện tại đã có 1200 lít. Hỏi cần thêm bao nhiêu lít để đầy?", "dapAn" to 800, "lop" to 9),
        "46" to mapOf("deToan" to "Một chiếc ô tô đi quãng đường 500 km trong 5 giờ. Hỏi vận tốc của ô tô là bao nhiêu km/h?", "dapAn" to 100, "lop" to 9),
        "47" to mapOf("deToan" to "Một hình tròn có bán kính 7cm. Hỏi chu vi của hình tròn? (Lấy π ≈ 3.14)", "dapAn" to 43.96, "lop" to 9),
        "48" to mapOf("deToan" to "Một chiếc xe máy chạy với vận tốc 50 km/h. Hỏi sau 3 giờ, xe đã đi được bao nhiêu km?", "dapAn" to 150, "lop" to 9),
        "49" to mapOf("deToan" to "Một cửa hàng bán một sản phẩm với giá 400,000 VND. Nếu giảm giá 20%, hỏi số tiền giảm là bao nhiêu?", "dapAn" to 80000, "lop" to 9),
        "50" to mapOf("deToan" to "Một chiếc xe buýt chạy với vận tốc 60 km/h. Hỏi sau 7 giờ, xe đã đi được bao nhiêu km?", "dapAn" to 420, "lop" to 9)
    )

    myRef.setValue(danhSachBaiToan)
        .addOnSuccessListener { Log.d("Firebase", "Dữ liệu đã được đẩy lên Firebase thành công!") }
        .addOnFailureListener { Log.e("Firebase", "Lỗi khi đẩy dữ liệu", it) }
}


fun pushDataToFirebase_baihinhcap2() {
    val database = FirebaseDatabase.getInstance()
    val myRef = database.getReference("Bai_hinh_cap2")

    val danhSachBaiToanHinh = mapOf(
        // Lớp 6
        "1" to mapOf("deToan" to "Một hình chữ nhật có chiều dài 12cm, chiều rộng 8cm. Hỏi diện tích của hình chữ nhật là bao nhiêu?", "dapAn" to 96, "lop" to 6),
        "2" to mapOf("deToan" to "Một hình vuông có cạnh dài 10cm. Hỏi chu vi của hình vuông là bao nhiêu?", "dapAn" to 40, "lop" to 6),
        "3" to mapOf("deToan" to "Một hình tròn có bán kính 7cm. Hỏi chu vi của hình tròn là bao nhiêu? (Lấy π ≈ 3)", "dapAn" to 42, "lop" to 6),
        "4" to mapOf("deToan" to "Một hình lập phương có cạnh dài 5cm. Hỏi thể tích của hình lập phương đó là bao nhiêu?", "dapAn" to 125, "lop" to 6),
        "5" to mapOf("deToan" to "Một hình hộp chữ nhật có các kích thước 4m, 3m, 2m. Hỏi thể tích của hình hộp là bao nhiêu?", "dapAn" to 24, "lop" to 6),
        "6" to mapOf("deToan" to "Một hình tròn có đường kính 14cm. Hỏi diện tích của hình tròn là bao nhiêu? (Lấy π ≈ 3)", "dapAn" to 147, "lop" to 6),
        "7" to mapOf("deToan" to "Một hình tam giác có đáy dài 10cm, chiều cao 6cm. Hỏi diện tích của hình tam giác là bao nhiêu?", "dapAn" to 30, "lop" to 6),
        "8" to mapOf("deToan" to "Một hình lập phương có diện tích một mặt là 16cm². Hỏi diện tích toàn phần của hình lập phương?", "dapAn" to 96, "lop" to 6),
        "9" to mapOf("deToan" to "Một hình lăng trụ đứng có đáy là hình vuông cạnh 6cm, chiều cao 10cm. Hỏi thể tích của hình lăng trụ?", "dapAn" to 360, "lop" to 6),
        "10" to mapOf("deToan" to "Một hình cầu có bán kính 3cm. Hỏi thể tích của hình cầu là bao nhiêu? (Lấy π ≈ 3)", "dapAn" to 108, "lop" to 6),
        "11" to mapOf("deToan" to "Một hình trụ có bán kính đáy 5cm, chiều cao 7cm. Hỏi thể tích của hình trụ là bao nhiêu? (Lấy π ≈ 3)", "dapAn" to 525, "lop" to 6),
        "12" to mapOf("deToan" to "Một hình nón có bán kính đáy 6cm, chiều cao 8cm. Hỏi thể tích của hình nón là bao nhiêu? (Lấy π ≈ 3)", "dapAn" to 288, "lop" to 6),
        "13" to mapOf("deToan" to "Một hình hộp chữ nhật có chiều dài 6m, chiều rộng 4m và chiều cao 3m. Hỏi diện tích toàn phần của hình hộp?", "dapAn" to 108, "lop" to 6),
        "14" to mapOf("deToan" to "Một hình lăng trụ có đáy là tam giác vuông với hai cạnh góc vuông là 5cm và 12cm, chiều cao 10cm. Hỏi thể tích của hình lăng trụ?", "dapAn" to 300, "lop" to 6),
        "15" to mapOf("deToan" to "Một hình chóp có đáy là hình chữ nhật với các cạnh 8cm và 6cm, chiều cao của hình chóp là 9cm. Hỏi thể tích của hình chóp?", "dapAn" to 144, "lop" to 6),
        "16" to mapOf("deToan" to "Một hình cầu có đường kính 10cm. Hỏi diện tích mặt cầu là bao nhiêu? (Lấy π ≈ 3)", "dapAn" to 300, "lop" to 6),
        "17" to mapOf("deToan" to "Một hình nón có đường kính đáy 10cm, chiều cao 12cm. Hỏi diện tích xung quanh của hình nón? (Lấy π ≈ 3)", "dapAn" to 180, "lop" to 6),
        "18" to mapOf("deToan" to "Một hình trụ có diện tích đáy là 100cm², chiều cao 10cm. Hỏi thể tích của hình trụ?", "dapAn" to 1000, "lop" to 6),
        "19" to mapOf("deToan" to "Một hình chóp có đáy là tam giác đều cạnh 6cm, chiều cao của hình chóp là 8cm. Hỏi thể tích của hình chóp?", "dapAn" to 48, "lop" to 6),
        "20" to mapOf("deToan" to "Một hình hộp chữ nhật có diện tích một mặt là 48cm², chiều cao 4cm. Hỏi thể tích của hình hộp?", "dapAn" to 192, "lop" to 6),

// Lớp 7
        "21" to mapOf("deToan" to "Một hình chữ nhật có chiều dài 15cm, chiều rộng 9cm. Hỏi diện tích của hình chữ nhật là bao nhiêu?", "dapAn" to 135, "lop" to 7),
        "22" to mapOf("deToan" to "Một hình vuông có cạnh dài 12cm. Hỏi chu vi của hình vuông là bao nhiêu?", "dapAn" to 48, "lop" to 7),
        "23" to mapOf("deToan" to "Một hình tròn có bán kính 6cm. Hỏi chu vi của hình tròn là bao nhiêu? (Lấy π ≈ 3)", "dapAn" to 36, "lop" to 7),
        "24" to mapOf("deToan" to "Một hình lập phương có cạnh dài 8cm. Hỏi thể tích của hình lập phương đó là bao nhiêu?", "dapAn" to 512, "lop" to 7),
        "25" to mapOf("deToan" to "Một hình hộp chữ nhật có các kích thước 5m, 4m, 3m. Hỏi thể tích của hình hộp là bao nhiêu?", "dapAn" to 60, "lop" to 7),
        "26" to mapOf("deToan" to "Một hình tròn có đường kính 18cm. Hỏi diện tích của hình tròn là bao nhiêu? (Lấy π ≈ 3)", "dapAn" to 306, "lop" to 7),
        "27" to mapOf("deToan" to "Một hình tam giác có đáy dài 14cm, chiều cao 8cm. Hỏi diện tích của hình tam giác là bao nhiêu?", "dapAn" to 56, "lop" to 7),
        "28" to mapOf("deToan" to "Một hình lập phương có diện tích một mặt là 36cm². Hỏi diện tích toàn phần của hình lập phương?", "dapAn" to 216, "lop" to 7),
        "29" to mapOf("deToan" to "Một hình lăng trụ đứng có đáy là hình vuông cạnh 10cm, chiều cao 12cm. Hỏi thể tích của hình lăng trụ?", "dapAn" to 1200, "lop" to 7),
        "30" to mapOf("deToan" to "Một hình cầu có bán kính 5cm. Hỏi thể tích của hình cầu là bao nhiêu? (Lấy π ≈ 3)", "dapAn" to 250, "lop" to 7),
        "31" to mapOf("deToan" to "Một hình trụ có bán kính đáy 6cm, chiều cao 9cm. Hỏi thể tích của hình trụ là bao nhiêu? (Lấy π ≈ 3)", "dapAn" to 1017, "lop" to 7),
        "32" to mapOf("deToan" to "Một hình nón có bán kính đáy 7cm, chiều cao 10cm. Hỏi thể tích của hình nón là bao nhiêu? (Lấy π ≈ 3)", "dapAn" to 462, "lop" to 7),
        "33" to mapOf("deToan" to "Một hình hộp chữ nhật có chiều dài 8m, chiều rộng 6m và chiều cao 5m. Hỏi diện tích toàn phần của hình hộp?", "dapAn" to 268, "lop" to 7),
        "34" to mapOf("deToan" to "Một hình lăng trụ có đáy là tam giác vuông với hai cạnh góc vuông là 6cm và 8cm, chiều cao 12cm. Hỏi thể tích của hình lăng trụ?", "dapAn" to 288, "lop" to 7),
        "35" to mapOf("deToan" to "Một hình chóp có đáy là hình chữ nhật với các cạnh 10cm và 8cm, chiều cao của hình chóp là 12cm. Hỏi thể tích của hình chóp?", "dapAn" to 480, "lop" to 7),
        "36" to mapOf("deToan" to "Một hình cầu có đường kính 12cm. Hỏi diện tích mặt cầu là bao nhiêu? (Lấy π ≈ 3)", "dapAn" to 432, "lop" to 7),
        "37" to mapOf("deToan" to "Một hình nón có đường kính đáy 14cm, chiều cao 16cm. Hỏi diện tích xung quanh của hình nón? (Lấy π ≈ 3)", "dapAn" to 672, "lop" to 7),
        "38" to mapOf("deToan" to "Một hình trụ có diện tích đáy là 150cm², chiều cao 15cm. Hỏi thể tích của hình trụ?", "dapAn" to 2250, "lop" to 7),
        "39" to mapOf("deToan" to "Một hình chóp có đáy là tam giác đều cạnh 12cm, chiều cao của hình chóp là 15cm. Hỏi thể tích của hình chóp?", "dapAn" to 720, "lop" to 7),
        "40" to mapOf("deToan" to "Một hình hộp chữ nhật có diện tích một mặt là 120cm², chiều cao 6cm. Hỏi thể tích của hình hộp?", "dapAn" to 720, "lop" to 7),

        // Lớp 8
        "41" to mapOf("deToan" to "Một hình chữ nhật có chiều dài 16cm, chiều rộng 9cm. Hỏi diện tích của hình chữ nhật là bao nhiêu?", "dapAn" to 144, "lop" to 8),
        "42" to mapOf("deToan" to "Một hình vuông có cạnh dài 14cm. Hỏi chu vi của hình vuông là bao nhiêu?", "dapAn" to 56, "lop" to 8),
        "43" to mapOf("deToan" to "Một hình tròn có bán kính 8cm. Hỏi chu vi của hình tròn là bao nhiêu? (Lấy π ≈ 3)", "dapAn" to 48, "lop" to 8),
        "44" to mapOf("deToan" to "Một hình lập phương có cạnh dài 9cm. Hỏi thể tích của hình lập phương đó là bao nhiêu?", "dapAn" to 729, "lop" to 8),
        "45" to mapOf("deToan" to "Một hình hộp chữ nhật có các kích thước 6m, 5m, 4m. Hỏi thể tích của hình hộp là bao nhiêu?", "dapAn" to 120, "lop" to 8),
        "46" to mapOf("deToan" to "Một hình tròn có đường kính 20cm. Hỏi diện tích của hình tròn là bao nhiêu? (Lấy π ≈ 3)", "dapAn" to 314, "lop" to 8),
        "47" to mapOf("deToan" to "Một hình tam giác có đáy dài 16cm, chiều cao 10cm. Hỏi diện tích của hình tam giác là bao nhiêu?", "dapAn" to 80, "lop" to 8),
        "48" to mapOf("deToan" to "Một hình lập phương có diện tích một mặt là 81cm². Hỏi diện tích toàn phần của hình lập phương?", "dapAn" to 486, "lop" to 8),
        "49" to mapOf("deToan" to "Một hình lăng trụ đứng có đáy là hình vuông cạnh 12cm, chiều cao 15cm. Hỏi thể tích của hình lăng trụ?", "dapAn" to 2160, "lop" to 8),
        "50" to mapOf("deToan" to "Một hình cầu có bán kính 10cm. Hỏi thể tích của hình cầu là bao nhiêu? (Lấy π ≈ 3)", "dapAn" to 1000, "lop" to 8),
        "51" to mapOf("deToan" to "Một hình trụ có bán kính đáy 8cm, chiều cao 14cm. Hỏi thể tích của hình trụ là bao nhiêu? (Lấy π ≈ 3)", "dapAn" to 1344, "lop" to 8),
        "52" to mapOf("deToan" to "Một hình nón có bán kính đáy 9cm, chiều cao 12cm. Hỏi thể tích của hình nón là bao nhiêu? (Lấy π ≈ 3)", "dapAn" to 972, "lop" to 8),
        "53" to mapOf("deToan" to "Một hình hộp chữ nhật có chiều dài 10m, chiều rộng 8m và chiều cao 7m. Hỏi diện tích toàn phần của hình hộp?", "dapAn" to 344, "lop" to 8),
        "54" to mapOf("deToan" to "Một hình lăng trụ có đáy là tam giác vuông với hai cạnh góc vuông là 7cm và 24cm, chiều cao 15cm. Hỏi thể tích của hình lăng trụ?", "dapAn" to 2520, "lop" to 8),
        "55" to mapOf("deToan" to "Một hình chóp có đáy là hình chữ nhật với các cạnh 12cm và 10cm, chiều cao của hình chóp là 16cm. Hỏi thể tích của hình chóp?", "dapAn" to 960, "lop" to 8),
        "56" to mapOf("deToan" to "Một hình cầu có đường kính 16cm. Hỏi diện tích mặt cầu là bao nhiêu? (Lấy π ≈ 3)", "dapAn" to 768, "lop" to 8),
        "57" to mapOf("deToan" to "Một hình nón có đường kính đáy 18cm, chiều cao 20cm. Hỏi diện tích xung quanh của hình nón? (Lấy π ≈ 3)", "dapAn" to 972, "lop" to 8),
        "58" to mapOf("deToan" to "Một hình trụ có diện tích đáy là 150cm², chiều cao 18cm. Hỏi thể tích của hình trụ?", "dapAn" to 2700, "lop" to 8),
        "59" to mapOf("deToan" to "Một hình chóp có đáy là tam giác đều cạnh 10cm, chiều cao của hình chóp là 13cm. Hỏi thể tích của hình chóp?", "dapAn" to 433, "lop" to 8),
        "60" to mapOf("deToan" to "Một hình hộp chữ nhật có diện tích một mặt là 120cm², chiều cao 9cm. Hỏi thể tích của hình hộp?", "dapAn" to 1080, "lop" to 8),
        // Lớp 9
        "61" to mapOf("deToan" to "Một hình chữ nhật có chiều dài 25cm, chiều rộng 18cm. Hỏi diện tích của hình chữ nhật là bao nhiêu?", "dapAn" to 450, "lop" to 9),
        "62" to mapOf("deToan" to "Một hình vuông có cạnh dài 20cm. Hỏi diện tích của hình vuông là bao nhiêu?", "dapAn" to 400, "lop" to 9),
        "63" to mapOf("deToan" to "Một hình tròn có bán kính 12cm. Hỏi diện tích của hình tròn là bao nhiêu? (Lấy π ≈ 3)", "dapAn" to 432, "lop" to 9),
        "64" to mapOf("deToan" to "Một hình lập phương có cạnh dài 10cm. Hỏi thể tích của hình lập phương đó là bao nhiêu?", "dapAn" to 1000, "lop" to 9),
        "65" to mapOf("deToan" to "Một hình hộp chữ nhật có các kích thước 8m, 6m, 4m. Hỏi thể tích của hình hộp là bao nhiêu?", "dapAn" to 192, "lop" to 9),
        "66" to mapOf("deToan" to "Một hình tròn có đường kính 24cm. Hỏi diện tích của hình tròn là bao nhiêu? (Lấy π ≈ 3)", "dapAn" to 452.16, "lop" to 9),
        "67" to mapOf("deToan" to "Một hình tam giác có đáy dài 16cm, chiều cao 9cm. Hỏi diện tích của hình tam giác là bao nhiêu?", "dapAn" to 72, "lop" to 9),
        "68" to mapOf("deToan" to "Một hình lập phương có diện tích một mặt là 81cm². Hỏi diện tích toàn phần của hình lập phương?", "dapAn" to 486, "lop" to 9),
        "69" to mapOf("deToan" to "Một hình lăng trụ đứng có đáy là hình vuông cạnh 12cm, chiều cao 15cm. Hỏi thể tích của hình lăng trụ?", "dapAn" to 2160, "lop" to 9),
        "70" to mapOf("deToan" to "Một hình cầu có bán kính 8cm. Hỏi thể tích của hình cầu là bao nhiêu? (Lấy π ≈ 3)", "dapAn" to 2144, "lop" to 9),
        "71" to mapOf("deToan" to "Một hình trụ có bán kính đáy 10cm, chiều cao 12cm. Hỏi thể tích của hình trụ là bao nhiêu? (Lấy π ≈ 3)", "dapAn" to 3768, "lop" to 9),
        "72" to mapOf("deToan" to "Một hình nón có bán kính đáy 9cm, chiều cao 14cm. Hỏi thể tích của hình nón là bao nhiêu? (Lấy π ≈ 3)", "dapAn" to 1197, "lop" to 9),
        "73" to mapOf("deToan" to "Một hình hộp chữ nhật có chiều dài 10m, chiều rộng 8m và chiều cao 5m. Hỏi diện tích toàn phần của hình hộp?", "dapAn" to 360, "lop" to 9),
        "74" to mapOf("deToan" to "Một hình lăng trụ có đáy là tam giác vuông với hai cạnh góc vuông là 9cm và 15cm, chiều cao 18cm. Hỏi thể tích của hình lăng trụ?", "dapAn" to 1215, "lop" to 9),
        "75" to mapOf("deToan" to "Một hình chóp có đáy là hình chữ nhật với các cạnh 12cm và 7cm, chiều cao của hình chóp là 15cm. Hỏi thể tích của hình chóp?", "dapAn" to 630, "lop" to 9),
        "76" to mapOf("deToan" to "Một hình cầu có đường kính 16cm. Hỏi diện tích mặt cầu là bao nhiêu? (Lấy π ≈ 3)", "dapAn" to 768, "lop" to 9),
        "77" to mapOf("deToan" to "Một hình nón có đường kính đáy 18cm, chiều cao 20cm. Hỏi diện tích xung quanh của hình nón? (Lấy π ≈ 3)", "dapAn" to 1017, "lop" to 9),
        "78" to mapOf("deToan" to "Một hình trụ có diện tích đáy là 150cm², chiều cao 15cm. Hỏi thể tích của hình trụ?", "dapAn" to 2250, "lop" to 9),
        "79" to mapOf("deToan" to "Một hình chóp có đáy là tam giác đều cạnh 10cm, chiều cao của hình chóp là 12cm. Hỏi thể tích của hình chóp?", "dapAn" to 400, "lop" to 9),
        "80" to mapOf("deToan" to "Một hình hộp chữ nhật có diện tích một mặt là 100cm², chiều cao 6cm. Hỏi thể tích của hình hộp?", "dapAn" to 600, "lop" to 9)
    )

    myRef.setValue(danhSachBaiToanHinh)
        .addOnSuccessListener { Log.d("Firebase", "Dữ liệu đã được đẩy lên Firebase thành công!") }
        .addOnFailureListener { Log.e("Firebase", "Lỗi khi đẩy dữ liệu", it) }
}
fun pushDataToFirebase_baigiaicap3() {
    val database = FirebaseDatabase.getInstance()
    val myRef = database.getReference("bai_toan_cap3")

    val danhSachBaiToan = mapOf(
        // Lớp 10
        "1" to mapOf("deToan" to "Một người gửi 10 triệu đồng vào ngân hàng với lãi suất 6% mỗi năm. Sau 5 năm, số tiền người đó nhận được là bao nhiêu?", "dapAn" to 13400, "lop" to 10),
        "2" to mapOf("deToan" to "Một đội công nhân có 8 người làm xong một công việc trong 12 ngày. Hỏi nếu có 12 người thì làm xong trong bao nhiêu ngày?", "dapAn" to 8, "lop" to 10),
        "3" to mapOf("deToan" to "Một chiếc xe di chuyển quãng đường 240 km trong 4 giờ. Hỏi vận tốc trung bình của xe là bao nhiêu km/h?", "dapAn" to 60, "lop" to 10),
        "4" to mapOf("deToan" to "Một cửa hàng giảm giá 20% cho một sản phẩm có giá ban đầu 500 nghìn đồng. Hỏi giá sau giảm là bao nhiêu nghìn đồng?", "dapAn" to 400, "lop" to 10),
        "5" to mapOf("deToan" to "Một lớp có 40 học sinh, trong đó có 16 học sinh là nữ. Hỏi số học sinh nam chiếm bao nhiêu phần trăm?", "dapAn" to 60, "lop" to 10),
        "6" to mapOf("deToan" to "Một bể nước hình hộp chữ nhật có chiều dài 2m, chiều rộng 1.5m, chiều cao 1m. Hỏi thể tích của bể là bao nhiêu lít nước?", "dapAn" to 3000, "lop" to 10),
        "7" to mapOf("deToan" to "Một cửa hàng bán một sản phẩm với giá 240 nghìn đồng, lãi 20% so với giá gốc. Hỏi giá gốc của sản phẩm là bao nhiêu nghìn đồng?", "dapAn" to 200, "lop" to 10),
        "8" to mapOf("deToan" to "Một công ty cần sản xuất 600 sản phẩm trong 10 ngày. Hỏi mỗi ngày phải sản xuất bao nhiêu sản phẩm?", "dapAn" to 60, "lop" to 10),
        "9" to mapOf("deToan" to "Một người chạy bộ với vận tốc 10 km/h. Hỏi sau 1 giờ 30 phút người đó chạy được bao nhiêu km?", "dapAn" to 15, "lop" to 10),
        "10" to mapOf("deToan" to "Một hình lập phương có thể tích 125 cm³. Hỏi diện tích toàn phần của hình lập phương?", "dapAn" to 150, "lop" to 10),
        "11" to mapOf("deToan" to "Một con tàu đi từ A đến B mất 5 giờ với vận tốc 50 km/h. Hỏi quãng đường từ A đến B là bao nhiêu km?", "dapAn" to 250, "lop" to 10),
        "12" to mapOf("deToan" to "Một hình trụ có bán kính đáy 7cm, chiều cao 10cm. Hỏi thể tích của hình trụ là bao nhiêu cm³? (Lấy π ≈ 3)", "dapAn" to 1470, "lop" to 10),
        "13" to mapOf("deToan" to "Một người mua một chiếc xe với giá 20 triệu đồng. Sau một năm giá trị xe giảm 10%. Hỏi sau một năm xe còn giá trị bao nhiêu triệu đồng?", "dapAn" to 18, "lop" to 10),
        "14" to mapOf("deToan" to "Một người gửi tiết kiệm 15 triệu đồng với lãi suất 5% mỗi năm. Hỏi sau 3 năm số tiền nhận được là bao nhiêu? (làm tròn)", "dapAn" to 17300, "lop" to 10),
        "15" to mapOf("deToan" to "Một học sinh làm bài kiểm tra gồm 50 câu hỏi, trong đó đúng 42 câu. Hỏi số phần trăm bài làm đúng là bao nhiêu?", "dapAn" to 84, "lop" to 10),
        "16" to mapOf("deToan" to "Một hình chóp tứ giác đều có cạnh đáy 6cm, chiều cao 9cm. Hỏi thể tích của hình chóp?", "dapAn" to 108, "lop" to 10),
        "17" to mapOf("deToan" to "Một cửa hàng có 120 sản phẩm, trong một ngày bán được 30 sản phẩm. Hỏi số sản phẩm còn lại chiếm bao nhiêu phần trăm tổng số ban đầu?", "dapAn" to 75, "lop" to 10),
        "18" to mapOf("deToan" to "Một công ty sản xuất 500 sản phẩm trong 20 ngày. Hỏi trung bình mỗi ngày công ty sản xuất bao nhiêu sản phẩm?", "dapAn" to 25, "lop" to 10),
        "19" to mapOf("deToan" to "Một gia đình sử dụng 300 số điện mỗi tháng. Biết giá mỗi số điện là 2 nghìn đồng. Hỏi tổng số tiền điện phải trả là bao nhiêu nghìn đồng?", "dapAn" to 600, "lop" to 10),
        "20" to mapOf("deToan" to "Một hình cầu có thể tích 972π cm³. Hỏi bán kính của hình cầu là bao nhiêu cm?", "dapAn" to 9, "lop" to 10),

        // Lớp 11
        "21" to mapOf("deToan" to "Một đội bóng có 15 cầu thủ, mỗi cầu thủ có chiều cao trung bình là 1.75m. Hỏi chiều cao trung bình của đội bóng là bao nhiêu?", "dapAn" to 1.75, "lop" to 11),
        "22" to mapOf("deToan" to "Tính diện tích mặt cầu có bán kính 5cm. (Lấy π ≈ 3)", "dapAn" to 75, "lop" to 11),
        "23" to mapOf("deToan" to "Một chiếc xe chạy từ A đến B với tốc độ 60 km/h, rồi từ B đến C với tốc độ 80 km/h. Tính vận tốc trung bình của cả chặng đường.", "dapAn" to 68, "lop" to 11),
        "24" to mapOf("deToan" to "Một hình nón có bán kính đáy 4cm, chiều cao 6cm. Tính thể tích của hình nón. (Lấy π ≈ 3)", "dapAn" to 72, "lop" to 11),
        "25" to mapOf("deToan" to "Một đoạn đường có chiều dài 500m. Một người đi bộ trong 10 phút với tốc độ 30m/phút. Hỏi người đó đi được bao nhiêu mét?", "dapAn" to 300, "lop" to 11),
        "26" to mapOf("deToan" to "Một xe tải chở 1200 kg hàng hóa. Nếu mỗi chuyến xe chỉ chở được 150 kg thì cần bao nhiêu chuyến xe để chở hết số hàng?", "dapAn" to 8, "lop" to 11),
        "27" to mapOf("deToan" to "Tính thể tích của một hình trụ có bán kính đáy 6cm, chiều cao 10cm. (Lấy π ≈ 3)", "dapAn" to 1080, "lop" to 11),
        "28" to mapOf("deToan" to "Một cửa hàng bán một sản phẩm với giá 500 nghìn đồng, lợi nhuận 25%. Tính giá gốc của sản phẩm.", "dapAn" to 400, "lop" to 11),
        "29" to mapOf("deToan" to "Một đoạn đường dài 120 km, nếu đi với vận tốc 60 km/h thì mất 2 giờ. Tính thời gian cần thiết nếu đi với vận tốc 40 km/h.", "dapAn" to 3, "lop" to 11),
        "30" to mapOf("deToan" to "Một chiếc máy tính có giá 15 triệu đồng. Sau khi giảm giá 10%, chiếc máy tính này còn giá bao nhiêu?", "dapAn" to 13500, "lop" to 11),
        "31" to mapOf("deToan" to "Một hình chóp có đáy là hình vuông với cạnh đáy dài 6cm và chiều cao 8cm. Tính thể tích của hình chóp.", "dapAn" to 96, "lop" to 11),
        "32" to mapOf("deToan" to "Một hình cầu có bán kính 4cm. Tính thể tích của hình cầu. (Lấy π ≈ 3)", "dapAn" to 192, "lop" to 11),
        "33" to mapOf("deToan" to "Một người mua một chiếc xe với giá 25 triệu đồng. Sau một năm giá trị xe giảm 5%. Hỏi sau một năm xe còn giá trị bao nhiêu triệu đồng?", "dapAn" to 23.75, "lop" to 11),
        "34" to mapOf("deToan" to "Một cửa hàng bán sản phẩm với giá 450 nghìn đồng. Sau khi giảm giá 15%, sản phẩm này có giá bao nhiêu?", "dapAn" to 382.5, "lop" to 11),
        "35" to mapOf("deToan" to "Tính chu vi của một hình tròn có bán kính 7cm. (Lấy π ≈ 3)", "dapAn" to 42, "lop" to 11),
        "36" to mapOf("deToan" to "Một đội bóng có 12 cầu thủ, trong đó có 4 cầu thủ ghi được bàn thắng. Hỏi tỷ lệ phần trăm các cầu thủ ghi bàn trong đội bóng?", "dapAn" to 33.33, "lop" to 11),
        "37" to mapOf("deToan" to "Một công ty cần sản xuất 1200 sản phẩm trong 15 ngày. Hỏi mỗi ngày công ty phải sản xuất bao nhiêu sản phẩm?", "dapAn" to 80, "lop" to 11),
        "38" to mapOf("deToan" to "Một thùng nước có thể chứa 200 lít. Nếu một chiếc máy bơm có thể bơm 20 lít nước mỗi phút, hỏi thời gian cần thiết để bơm đầy thùng nước là bao lâu?", "dapAn" to 10, "lop" to 11),
        "39" to mapOf("deToan" to "Một hộp hình hộp chữ nhật có chiều dài 8cm, chiều rộng 5cm và chiều cao 10cm. Tính thể tích của hộp.", "dapAn" to 400, "lop" to 11),
        "40" to mapOf("deToan" to "Một chiếc máy bay di chuyển với vận tốc 500 km/h. Hỏi trong 6 giờ máy bay sẽ di chuyển được bao nhiêu km?", "dapAn" to 3000, "lop" to 11),

        // Lớp 12
        "41" to mapOf("deToan" to "Một người gửi 20 triệu đồng vào ngân hàng với lãi suất 7% mỗi năm. Sau 3 năm, số tiền nhận được là bao nhiêu?", "dapAn" to 24600, "lop" to 12),
        "42" to mapOf("deToan" to "Một đội công nhân có 5 người làm xong công việc trong 12 ngày. Hỏi nếu có 15 người thì công việc sẽ hoàn thành trong bao nhiêu ngày?", "dapAn" to 4, "lop" to 12),
        "43" to mapOf("deToan" to "Một cửa hàng giảm giá 15% cho một sản phẩm có giá ban đầu 600 nghìn đồng. Hỏi giá sau giảm là bao nhiêu?", "dapAn" to 510, "lop" to 12),
        "44" to mapOf("deToan" to "Một chiếc xe ô tô chạy với vận tốc 90 km/h. Hỏi trong 5 giờ xe sẽ di chuyển được bao nhiêu km?", "dapAn" to 450, "lop" to 12),
        "45" to mapOf("deToan" to "Một đội bóng có 11 cầu thủ. Nếu mỗi cầu thủ ghi được 3 bàn thắng, hỏi tổng số bàn thắng của đội là bao nhiêu?", "dapAn" to 33, "lop" to 12),
        "46" to mapOf("deToan" to "Tính diện tích của một hình tròn có bán kính 8cm. (Lấy π ≈ 3)", "dapAn" to 192, "lop" to 12),
        "47" to mapOf("deToan" to "Một chiếc máy bay di chuyển từ A đến B trong 4 giờ với vận tốc 200 km/h. Hỏi quãng đường từ A đến B là bao nhiêu km?", "dapAn" to 800, "lop" to 12),
        "48" to mapOf("deToan" to "Một công ty sản xuất 1000 sản phẩm trong 20 ngày. Hỏi trung bình mỗi ngày công ty sản xuất bao nhiêu sản phẩm?", "dapAn" to 50, "lop" to 12),
        "49" to mapOf("deToan" to "Một hình vuông có cạnh dài 10 cm. Tính diện tích của hình vuông.", "dapAn" to 100, "lop" to 12),
        "50" to mapOf("deToan" to "Một người mua một chiếc xe máy với giá 30 triệu đồng. Sau 2 năm giá trị xe giảm 12%. Hỏi giá trị xe còn lại là bao nhiêu?", "dapAn" to 26.4, "lop" to 12)
    )

    // Đẩy dữ liệu lên Firebase
    myRef.setValue(danhSachBaiToan)
        .addOnSuccessListener { Log.d("Firebase", "Dữ liệu đã được đẩy lên Firebase thành công!") }
        .addOnFailureListener { Log.e("Firebase", "Lỗi khi đẩy dữ liệu", it) }
}
fun pushDataToFirebase_baihinhcap3() {
    val database = FirebaseDatabase.getInstance()
    val myRef = database.getReference("Bai_hinh_cap3")

   val danhSachBaiToan = mapOf(
        // Lớp 10
        "1" to mapOf("deToan" to "Tính diện tích của một tam giác vuông có chiều dài đáy là 6 cm, chiều cao là 8 cm.", "dapAn" to 24, "lop" to 10),
        "2" to mapOf("deToan" to "Tính thể tích của một hình hộp chữ nhật có chiều dài 5 cm, chiều rộng 4 cm, chiều cao 10 cm.", "dapAn" to 200, "lop" to 10),
        "3" to mapOf("deToan" to "Tính diện tích toàn phần của một hình cầu có bán kính 7 cm.", "dapAn" to 196, "lop" to 10),
        "4" to mapOf("deToan" to "Tính thể tích của một hình trụ có bán kính đáy 4 cm, chiều cao 10 cm.", "dapAn" to 160, "lop" to 10),
        "5" to mapOf("deToan" to "Tính chu vi của một hình tròn có bán kính 5 cm.", "dapAn" to 31.4, "lop" to 10),
        "6" to mapOf("deToan" to "Tính diện tích của một hình vuông có cạnh dài 10 cm.", "dapAn" to 100, "lop" to 10),
        "7" to mapOf("deToan" to "Một hình chóp tứ giác đều có cạnh đáy 6 cm, chiều cao 9 cm. Tính thể tích của hình chóp.", "dapAn" to 108, "lop" to 10),
        "8" to mapOf("deToan" to "Tính diện tích xung quanh của một hình trụ có bán kính đáy 3 cm, chiều cao 10 cm.", "dapAn" to 180, "lop" to 10),
        "9" to mapOf("deToan" to "Tính diện tích mặt cầu có bán kính 5 cm.", "dapAn" to 100, "lop" to 10),
        "10" to mapOf("deToan" to "Tính thể tích của một hình nón có bán kính đáy 3 cm, chiều cao 9 cm.", "dapAn" to 81, "lop" to 10),

        // Lớp 11
        "11" to mapOf("deToan" to "Tính thể tích của một hình cầu có bán kính 6 cm.", "dapAn" to 432, "lop" to 11),
        "12" to mapOf("deToan" to "Tính diện tích mặt ngoài của một hình trụ có bán kính đáy 4 cm, chiều cao 15 cm.", "dapAn" to 376, "lop" to 11),
        "13" to mapOf("deToan" to "Tính thể tích của một hình chóp tứ giác đều có cạnh đáy 8 cm, chiều cao 12 cm.", "dapAn" to 256, "lop" to 11),
        "14" to mapOf("deToan" to "Tính chu vi của một hình tròn có bán kính 7 cm.", "dapAn" to 43.96, "lop" to 11),
        "15" to mapOf("deToan" to "Tính diện tích của một tam giác vuông có cạnh góc vuông là 12 cm và 16 cm.", "dapAn" to 96, "lop" to 11),
        "16" to mapOf("deToan" to "Tính thể tích của một hình nón có bán kính đáy 5 cm, chiều cao 12 cm.", "dapAn" to 300, "lop" to 11),
        "17" to mapOf("deToan" to "Tính diện tích của một hình vuông có diện tích là 144 cm².", "dapAn" to 12, "lop" to 11),
        "18" to mapOf("deToan" to "Tính diện tích toàn phần của một hình cầu có bán kính 9 cm.", "dapAn" to 324, "lop" to 11),
        "19" to mapOf("deToan" to "Tính diện tích xung quanh của một hình trụ có bán kính đáy 8 cm, chiều cao 14 cm.", "dapAn" to 704, "lop" to 11),
        "20" to mapOf("deToan" to "Tính thể tích của một hình hộp chữ nhật có chiều dài 10 cm, chiều rộng 5 cm, chiều cao 12 cm.", "dapAn" to 600, "lop" to 11),

        // Lớp 12
        "21" to mapOf("deToan" to "Tính diện tích mặt cầu có bán kính 10 cm.", "dapAn" to 400, "lop" to 12),
        "22" to mapOf("deToan" to "Tính thể tích của một hình cầu có bán kính 8 cm.", "dapAn" to 2144, "lop" to 12),
        "23" to mapOf("deToan" to "Tính diện tích toàn phần của một hình trụ có bán kính đáy 6 cm, chiều cao 12 cm.", "dapAn" to 432, "lop" to 12),
        "24" to mapOf("deToan" to "Tính thể tích của một hình hộp chữ nhật có chiều dài 6 cm, chiều rộng 4 cm, chiều cao 15 cm.", "dapAn" to 360, "lop" to 12),
        "25" to mapOf("deToan" to "Tính diện tích mặt ngoài của một hình nón có bán kính đáy 3 cm, chiều cao 4 cm.", "dapAn" to 75.4, "lop" to 12),
        "26" to mapOf("deToan" to "Tính thể tích của một hình nón có bán kính đáy 9 cm, chiều cao 12 cm.", "dapAn" to 3053, "lop" to 12),
        "27" to mapOf("deToan" to "Tính chu vi của một hình tròn có bán kính 12 cm.", "dapAn" to 75.36, "lop" to 12),
        "28" to mapOf("deToan" to "Tính diện tích xung quanh của một hình chóp tứ giác đều có cạnh đáy 7 cm, chiều cao 8 cm.", "dapAn" to 196, "lop" to 12),
        "29" to mapOf("deToan" to "Tính thể tích của một hình chóp tứ giác đều có cạnh đáy 6 cm, chiều cao 10 cm.", "dapAn" to 120, "lop" to 12),
        "30" to mapOf("deToan" to "Tính diện tích của một hình vuông có cạnh dài 15 cm.", "dapAn" to 225, "lop" to 12)
    )

    myRef.setValue(danhSachBaiToan)
        .addOnSuccessListener { Log.d("Firebase", "Dữ liệu đã được đẩy lên Firebase thành công!") }
        .addOnFailureListener { Log.e("Firebase", "Lỗi khi đẩy dữ liệu", it) }
}
fun pushDataToFirebase_calculation2() {
    val database = FirebaseDatabase.getInstance()
    val myRef = database.getReference("calculations2")

    val danhSachPhepTinhCap3 = mapOf(
        // Lớp 10
        "1" to mapOf("deToan" to "Tính: 2^3 + 5 × 2 - 6?", "dapAn" to 12, "lop" to 10),
        "2" to mapOf("deToan" to "Giải phương trình: 3x - 9 = 0. Tìm x?", "dapAn" to 3, "lop" to 10),
        "3" to mapOf("deToan" to "Tính: (5 + 3) × 2?", "dapAn" to 16, "lop" to 10),
        "4" to mapOf("deToan" to "Tính: √49 + 3^2?", "dapAn" to 16, "lop" to 10),
        "5" to mapOf("deToan" to "Giải bất phương trình: 2x - 3 > 5?", "dapAn" to 5, "lop" to 10),
        "6" to mapOf("deToan" to "Tính: 7! ÷ (5! × 2!)?", "dapAn" to 21, "lop" to 10),
        "7" to mapOf("deToan" to "Tính tổng: 1 + 3 + 5 + ... + 99?", "dapAn" to 2500, "lop" to 10),
        "8" to mapOf("deToan" to "Tính giá trị biểu thức: (2^4 - 4) ÷ 2", "dapAn" to 6, "lop" to 10),
        "9" to mapOf("deToan" to "Tính: log₂(32)", "dapAn" to 5, "lop" to 10),
        "10" to mapOf("deToan" to "Giải phương trình: x² - 5x + 6 = 0. Nghiệm lớn nhất?", "dapAn" to 3, "lop" to 10),
        "11" to mapOf("deToan" to "Tính: 3^3 + 2^4", "dapAn" to 35, "lop" to 10),
        "12" to mapOf("deToan" to "Tính giá trị: 100 - 6 × (5 + 2)", "dapAn" to 58, "lop" to 10),
        "13" to mapOf("deToan" to "Giải phương trình: 5x + 4 = 29", "dapAn" to 5, "lop" to 10),
        "14" to mapOf("deToan" to "Tính: (3^2 + 4^2)", "dapAn" to 25, "lop" to 10),
        "15" to mapOf("deToan" to "Tính: √(81) + √(16)", "dapAn" to 13, "lop" to 10),
        "16" to mapOf("deToan" to "Tính: (15 - 3) ÷ 3 + 2", "dapAn" to 6, "lop" to 10),
        "17" to mapOf("deToan" to "Giải phương trình: x/2 + 3 = 5", "dapAn" to 4, "lop" to 10),
        "18" to mapOf("deToan" to "Tính giá trị: 2024 ÷ 8", "dapAn" to 253, "lop" to 10),
        "19" to mapOf("deToan" to "Tính: 6! ÷ 4!", "dapAn" to 30, "lop" to 10),
        "20" to mapOf("deToan" to "Tính: Tổng các số chẵn từ 2 đến 100", "dapAn" to 2550, "lop" to 10),

        // Lớp 11
        "21" to mapOf("deToan" to "Giải phương trình: 2x - 5 = 9", "dapAn" to 7, "lop" to 11),
        "22" to mapOf("deToan" to "Tính đạo hàm của f(x) = x² tại x = 3", "dapAn" to 6, "lop" to 11),
        "23" to mapOf("deToan" to "Tính tích phân: ∫(2x) dx từ 0 đến 3", "dapAn" to 9, "lop" to 11),
        "24" to mapOf("deToan" to "Tính: lim(x→∞) (3x² + 2)/(x² + 1)", "dapAn" to 3, "lop" to 11),
        "25" to mapOf("deToan" to "Giải hệ: x + y = 6; x - y = 2. Tìm x?", "dapAn" to 4, "lop" to 11),
        "26" to mapOf("deToan" to "Tính: log₁₀(1000)", "dapAn" to 3, "lop" to 11),
        "27" to mapOf("deToan" to "Tìm giá trị lớn nhất của hàm số f(x) = -x² + 4x?", "dapAn" to 4, "lop" to 11),
        "28" to mapOf("deToan" to "Tính: sin²(30°) + cos²(30°)?", "dapAn" to 1, "lop" to 11),
        "29" to mapOf("deToan" to "Tính đạo hàm: f(x) = 3x^3 tại x = 1", "dapAn" to 9, "lop" to 11),
        "30" to mapOf("deToan" to "Tính tích phân: ∫(x) dx từ 1 đến 2", "dapAn" to 1.5, "lop" to 11),
        "31" to mapOf("deToan" to "Tính giới hạn: lim(x→0) sin(x)/x", "dapAn" to 1, "lop" to 11),
        "32" to mapOf("deToan" to "Giải phương trình: x² - 4 = 0. Nghiệm dương?", "dapAn" to 2, "lop" to 11),
        "33" to mapOf("deToan" to "Tính: cos(0°)", "dapAn" to 1, "lop" to 11),
        "34" to mapOf("deToan" to "Tính tích phân: ∫(x²) dx từ 0 đến 2", "dapAn" to 8/3.0, "lop" to 11),
        "35" to mapOf("deToan" to "Tính giá trị cực tiểu của hàm f(x) = x² - 4x + 5", "dapAn" to 1, "lop" to 11),
        "36" to mapOf("deToan" to "Giải: 3x² = 27", "dapAn" to 3, "lop" to 11),
        "37" to mapOf("deToan" to "Tính log₄(64)", "dapAn" to 3, "lop" to 11),
        "38" to mapOf("deToan" to "Tìm đạo hàm cấp hai của f(x) = x³", "dapAn" to 6, "lop" to 11),
        "39" to mapOf("deToan" to "Tính: tan(45°)", "dapAn" to 1, "lop" to 11),
        "40" to mapOf("deToan" to "Tính: e^0", "dapAn" to 1, "lop" to 11),

        // Lớp 12
        "41" to mapOf("deToan" to "Tính đạo hàm f(x) = e^x tại x = 0", "dapAn" to 1, "lop" to 12),
        "42" to mapOf("deToan" to "Tính tích phân: ∫(e^x) dx từ 0 đến 1", "dapAn" to 1.718, "lop" to 12),
        "43" to mapOf("deToan" to "Giải phương trình: ln(x) = 0", "dapAn" to 1, "lop" to 12),
        "44" to mapOf("deToan" to "Tính: lim(x→0) (1 - cosx)/x²", "dapAn" to 0.5, "lop" to 12),
        "45" to mapOf("deToan" to "Giải phương trình: sinx = 1/2 (x ∈ [0,π])", "dapAn" to 1.047, "lop" to 12),
        "46" to mapOf("deToan" to "Tính diện tích hình phẳng giới hạn bởi y = x và y = x² trên [0,1]", "dapAn" to 1/6.0, "lop" to 12),
        "47" to mapOf("deToan" to "Tính tích phân: ∫(1/x) dx từ 1 đến e", "dapAn" to 1.0, "lop" to 12),
        "48" to mapOf("deToan" to "Giải phương trình: e^x = 7. Tính ln(7)", "dapAn" to 1.945, "lop" to 12),
        "49" to mapOf("deToan" to "Tính: ∫(x³) dx từ 0 đến 1", "dapAn" to 0.25, "lop" to 12),
        "50" to mapOf("deToan" to "Tính giá trị lớn nhất của f(x) = -x² + 6x", "dapAn" to 9, "lop" to 12),
        "51" to mapOf("deToan" to "Giải: ln(e²) = ?", "dapAn" to 2, "lop" to 12),
        "52" to mapOf("deToan" to "Tính đạo hàm: f(x) = ln(x²)", "dapAn" to 2, "lop" to 12),
        "53" to mapOf("deToan" to "Tính diện tích hình tròn bán kính 5", "dapAn" to 78.5, "lop" to 12),
        "54" to mapOf("deToan" to "Tính: e^(ln3)", "dapAn" to 3.0, "lop" to 12),
        "55" to mapOf("deToan" to "Giải phương trình: 2^x = 8", "dapAn" to 3, "lop" to 12),
        "56" to mapOf("deToan" to "Tính đạo hàm: f(x) = 1/x tại x = 2", "dapAn" to -0.25, "lop" to 12),
        "57" to mapOf("deToan" to "Tính thể tích khối cầu bán kính 3", "dapAn" to 113.1, "lop" to 12),
        "58" to mapOf("deToan" to "Tính tích phân: ∫(sinx) dx từ 0 đến π", "dapAn" to 2.0, "lop" to 12),
        "59" to mapOf("deToan" to "Giải bất phương trình: ln(x) > 0", "dapAn" to 2, "lop" to 12),
        "60" to mapOf("deToan" to "Tính thể tích hình nón R = 5, h = 10", "dapAn" to 261.8, "lop" to 12)
    )

    myRef.setValue(danhSachPhepTinhCap3)
        .addOnSuccessListener { Log.d("Firebase", "Đẩy dữ liệu thành công!") }
        .addOnFailureListener { Log.e("Firebase", "Lỗi khi đẩy dữ liệu", it) }
}

class MainActivity : AppCompatActivity() {
    private lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button: Button = findViewById(R.id.start0)
        db = FirebaseFirestore.getInstance()
        val calculation: MutableMap<String, Any> = HashMap()
        calculation["expression"] = "2 + 3"
        calculation["result"] = "5"
        db.collection("calculations")
            .add(calculation)
        val sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE)
        val loggedInUser = sharedPreferences.getString("loggedInUser", null)
        pushDataToFirebase_calculation2()
        button.setOnClickListener {
            if (loggedInUser != null) {
                // Có tài khoản đã lưu
                val intent = Intent(this, SecondActivity::class.java)
                startActivity(intent)
            } else {
                // Chưa có ai đăng nhập
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }
        }

            // Khởi động Activity mới
}
    }
