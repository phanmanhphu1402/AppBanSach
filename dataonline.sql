-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th5 10, 2023 lúc 06:51 PM
-- Phiên bản máy phục vụ: 10.4.28-MariaDB
-- Phiên bản PHP: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `dataonline`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sanpham`
--

CREATE TABLE `sanpham` (
  `id` int(11) NOT NULL,
  `tensanpham` varchar(100) NOT NULL,
  `hinhanh` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `sanpham`
--

INSERT INTO `sanpham` (`id`, `tensanpham`, `hinhanh`) VALUES
(1, 'Trang chủ', 'https://th.bing.com/th/id/OIP.XIQitD8nMdlLs9jS4jmoPwAAAA?w=166&h=183&c=7&r=0&o=5&dpr=1.3&pid=1.7'),
(2, 'Sách cũ', 'https://th.bing.com/th/id/OIP.Lw-c_jUqYmTnrYYqJKWpwAHaEo?w=248&h=180&c=7&r=0&o=5&dpr=1.3&pid=1.7'),
(3, 'Sách mới', 'https://andromeda.vn/data/images/knigi31.jpg'),
(4, 'Liên hệ', 'https://th.bing.com/th/id/OIP.1sVJRrXm3F5y8lUY6mw4ZgHaHa?w=167&h=180&c=7&r=0&o=5&dpr=1.3&pid=1.7'),
(5, 'Thông tin', 'https://th.bing.com/th/id/OIP.ncOCV5LVCL8j70Edjgyn6QHaGy?w=185&h=180&c=7&r=0&o=5&dpr=1.3&pid=1.7'),
(6, 'Quản lý', 'https://th.bing.com/th/id/OIP.puMo9ITfruXP8iQx9cYcqwHaGJ?w=239&h=197&c=7&r=0&o=5&dpr=1.3&pid=1.7');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sanphammoi`
--

CREATE TABLE `sanphammoi` (
  `id` int(11) NOT NULL,
  `tensp` varchar(250) NOT NULL,
  `giasp` varchar(100) NOT NULL,
  `hinhanh` text NOT NULL,
  `mota` text NOT NULL,
  `loai` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `sanphammoi`
--

INSERT INTO `sanphammoi` (`id`, `tensp`, `giasp`, `hinhanh`, `mota`, `loai`) VALUES
(1, 'Lối sống tối giản của người Nhật', '107000', 'https://th.bing.com/th/id/OIP.I_yhYf0jUSmKJI6lsilQ5wHaHa?w=159&h=180&c=7&r=0&o=5&dpr=1.3&pid=1.7', 'Giá bìa: 95.000đ\r\nThể loại: Tâm lý – Kỹ năng sống\r\nTác giả: Sasaki Fumio\r\nNăm xuất bản: 06/2018\r\nNhà xuất bản: Nhà xuất bản Lao Động\r\nSố trang: 294 Trang', 2),
(2, 'Giới hạn của bạn là xuất phát điểm của tôi', '59000', 'https://muagitot.com/upload_images/images/2022/05/19/review-gioi-han-cua-ban-chi-la-x.jpg', 'Ngày xuất bản: 2018-07-07 17:59:55\r\nKích thước: 14.5 x 20.5 cm\r\nDịch Giả: Lộc Vân\r\nLoại bìa: Bìa mềm\r\nSố trang: 280\r\nNhà xuất bản: Nhà Xuất Bản Thế Giới', 2),
(3, 'Không ai có thể làm tổn thương bạn trừ khi bạn cho phép', '86000', 'https://muagitot.com/upload_images/images/2022/05/19/266010964_1339805756495908_23252.jpg', 'Ngày xuất bản: 2021-09-01 00:00:00\r\nKích thước: 14.5 x 20.5 cm\r\nDịch Giả: Sun Tzô\r\nLoại bìa: Bìa mềm\r\nSố trang: 304\r\nNhà xuất bản: Nhà Xuất Bản Dân Trí', 2),
(4, 'Đời ngắn đừng ngủ dài', '55000', 'https://muagitot.com/upload_images/images/2022/05/19/review-sach-doi-ngan-dung-ngu-da.jpg', 'Ngày xuất bản: 2018-12-01 00:00:00\r\nKích thước: 13 x 20.5 cm\r\nLoại bìa: Bìa mềm\r\nSố trang: 228\r\nNhà xuất bản: NXB Trẻ', 2),
(5, 'Ba người thầy vĩ đại', '66000', 'https://muagitot.com/upload_images/images/2022/05/19/httpsd3t3ozftmdmh3i_cloudfront_n.jpg', 'Ngày xuất bản: 2019-10-01 00:00:00\r\nKích thước: 14.5 x 20.5 cm\r\nLoại bìa: Bìa mềm\r\nSố trang: 330\r\nNhà xuất bản: Nhà Xuất Bản Lao Động', 2),
(6, 'Mèo và triết lý nhân sinh', '126000', 'https://muagitot.com/upload_images/images/2022/05/19/m_o_v_tri_t_l_nh_n_sinh_-_nh_4.jpg', 'Ngày xuất bản: 2021-10-10 00:00:00\r\nKích thước: 13 x 20 cm\r\nDịch Giả: Ngọc Xoài\r\nLoại bìa: Bìa cứng\r\nSố trang: 276\r\nNhà xuất bản: Nhà Xuất Bản Thanh Niên', 2),
(7, 'Ổn định hay tự do', '93000', 'https://muagitot.com/upload_images/images/2022/05/19/7e0e80a5bbefce6c9a65558613a4ee3a.jpg', 'Ngày xuất bản: 2021-06-15 00:00:00\r\nKích thước: 14.5 x 20.5 cm\r\nDịch Giả: Hoa Lộc\r\nLoại bìa: Bìa mềm\r\nSố trang: 284\r\nNhà xuất bản: Nhà Xuất Bản Văn Học', 2),
(8, 'Osho - Từ bi', '94000', 'https://muagitot.com/upload_images/images/2022/05/19/5826_tu-bi.jpg', 'Ngày xuất bản: 2020-09-15 00:00:00\r\nKích thước: 14.5 x 20.5 cm\r\nLoại bìa: Bìa gập\r\nSố trang: 228\r\nNhà xuất bản: Nhà Xuất Bản Văn Hóa - Văn Nghệ TP.HCM', 2),
(9, 'Đời còn dài hà tất phải hoang mang', '86000', 'https://muagitot.com/upload_images/images/2022/05/19/sach-doi-con-dai-ha-tat-phai-hoa.jpg', 'Ngày xuất bản: 2019-04-01 14:26:23\r\nKích thước: 14,5 x 20,5 cm\r\nDịch Giả: Phan Lưu Ly\r\nLoại bìa: Bìa mềm\r\nSố trang: 456', 2),
(10, 'Giữa thế gian ồn ào sống một đời giản đơn', '67000', 'https://muagitot.com/upload_images/images/2022/05/19/ba980ca505a6d0550770a5a629762bf2.jpg', 'Xuất bản: 3/2021\r\nTrọng lượng: 320 gr\r\nNXB: Thanh Niên\r\nSố trang: 248 trang', 2),
(11, 'Túp lều bác Tôm', '190000', 'https://sachxua.vn/wp-content/uploads/2019/12/sach-hiem-tup-leu-bac-tom-1971-600x800.jpg', 'Tác phẩm : Túp lều của bác Tom \r\nTác giả : Harriet Beecher Stowe\r\nNgười đọc: Ngọc Minh', 1),
(12, 'Quẳng gánh lo đi và vui sống', '150000', 'https://sachxua.vn/wp-content/uploads/2019/12/sach-hiem-quang-ganh-lo-di-va-vui-song-1956.jpg', 'Tác giả: Dale Carnegie\r\nThể loại: Tâm Lý - Kỹ Năng Sống\r\nSố chương: 29', 1),
(13, 'ngày ở nước Tý hon', '90000', 'https://sachxua.vn/wp-content/uploads/2019/12/sach-hiem-3-ngay-o-nuoc-ty-hon-1976-600x806.jpg', 'TÁC GIẢ: Vladimir Levshin\r\nDỊCH GIẢ: Nguyễn Tiến Dũng\r\nNHÀ XUẤT BẢN: NXB Thế Giới\r\nNHÀ PHÁT HÀNH: Sputnik Education', 1),
(14, 'Đất Rừng Phương Nam', '80000', 'https://sachxua.vn/wp-content/uploads/2019/12/sach-hiem-dat-rung-phuong-nam-1966-600x401.jpg', 'Chuyên mục: Văn Học Thiếu Nhi\r\nTác Giả: Đoàn Giỏi', 1),
(15, 'Truyện Kiều', '85000', 'https://sachxua.vn/wp-content/uploads/2019/12/sach-hiem-truyen-kieu-1936-va-1927.jpg', 'Chuyên mục: Văn Học Việt Nam\r\nTác Giả: Nguyễn Du', 1),
(16, 'Đại Việt sử ký toàn thư', '185000', 'https://sachxua.vn/wp-content/uploads/2019/12/sach-hiem-dai-viet-su-ky-toan-thu-1983-600x851.jpg', 'Tác giả: Ngô Sỹ Liên\r\nDanh mục: Chính trị - Lịch sử', 1),
(17, 'Đời mưa gió', '230000', 'https://sachxua.vn/wp-content/uploads/2019/12/sach-hiem-doi-mua-gio-1934.jpg', 'Tác giả: Nhất Linh, Khái Hưng\r\nNXB: NXB Hội Nhà Văn\r\nSố trang: 207\r\n', 1),
(18, 'Kỹ nghệ lấy Tây', '170000', 'https://sachxua.vn/wp-content/uploads/2019/12/sach-hiem-ky-nghe-lay-tay-1935-600x800.jpg', 'Chuyên mục: Văn Học Việt Nam\r\nTác Giả: Vũ Trọng Phụng', 1),
(19, 'Đại Nam quốc âm tự vị', '155000', 'https://sachxua.vn/wp-content/uploads/2019/12/sach-hiemdai-nam-quac-am-tu-vi-tro-lai-1895-600x800.jpg', 'Tác giả: Huình Tịnh Của\r\nNgày xuất bản: 03/2018\r\n', 1),
(20, 'Lục Vân Tiên', '140000', 'https://sachxua.vn/wp-content/uploads/2019/12/sach-hiem-luc-van-tien-1970.jpg', 'Nhà cung cấp: Đông A\r\nTác giả: Nguyễn Đình Chiểu\r\nNhà xuất bản: NXB Văn Học', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `email` varchar(250) NOT NULL,
  `pass` varchar(250) NOT NULL,
  `username` varchar(100) NOT NULL,
  `mobile` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `user`
--

INSERT INTO `user` (`id`, `email`, `pass`, `username`, `mobile`) VALUES
(4, 'thanh123@gmail.com', '123456', 'thanh 123', '0123456789'),
(5, 'thanh123456@gmail.com', '123456', 'thanh 123', '0123456789'),
(6, 'ltthanh@gmail.com', '123', 'thanh', '123456');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `sanphammoi`
--
ALTER TABLE `sanphammoi`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT cho bảng `sanphammoi`
--
ALTER TABLE `sanphammoi`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT cho bảng `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
