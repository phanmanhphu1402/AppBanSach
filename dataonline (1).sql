-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th5 16, 2023 lúc 02:55 AM
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
-- Cấu trúc bảng cho bảng `chitietdonhang`
--

CREATE TABLE `chitietdonhang` (
  `iddonhang` int(11) NOT NULL,
  `idsp` int(11) NOT NULL,
  `soluong` int(11) NOT NULL,
  `gia` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `chitietdonhang`
--

INSERT INTO `chitietdonhang` (`iddonhang`, `idsp`, `soluong`, `gia`) VALUES
(9, 20, 1, '140000'),
(9, 19, 2, '155000'),
(10, 20, 1, '140000'),
(10, 19, 2, '155000'),
(11, 20, 1, '140000'),
(11, 19, 2, '155000'),
(12, 20, 1, '140000'),
(12, 19, 2, '155000'),
(13, 20, 1, '140000'),
(13, 19, 2, '155000'),
(14, 20, 1, '140000'),
(14, 19, 2, '155000'),
(15, 20, 1, '140000'),
(15, 19, 2, '155000'),
(16, 20, 1, '140000'),
(16, 19, 2, '155000'),
(17, 20, 1, '140000'),
(17, 19, 2, '155000'),
(18, 20, 1, '140000'),
(18, 19, 2, '155000'),
(19, 20, 1, '140000'),
(19, 19, 2, '155000'),
(20, 20, 1, '140000'),
(20, 19, 2, '155000'),
(21, 20, 1, '140000'),
(21, 19, 2, '155000'),
(22, 20, 1, '140000'),
(22, 19, 2, '155000'),
(23, 20, 1, '140000'),
(23, 19, 2, '155000'),
(24, 20, 1, '140000'),
(24, 19, 2, '155000'),
(29, 20, 1, '140000'),
(29, 19, 2, '155000'),
(30, 20, 1, '140000'),
(30, 19, 2, '155000'),
(31, 20, 1, '140000'),
(31, 19, 2, '155000'),
(32, 20, 1, '140000'),
(32, 19, 2, '155000'),
(33, 20, 1, '140000'),
(33, 19, 2, '155000'),
(34, 20, 1, '140000'),
(34, 19, 2, '155000'),
(35, 20, 1, '140000'),
(35, 19, 2, '155000'),
(36, 18, 1, '170000'),
(36, 16, 2, '185000'),
(37, 18, 1, '170000'),
(37, 16, 2, '185000'),
(38, 18, 1, '170000'),
(38, 16, 2, '185000'),
(39, 18, 1, '170000'),
(39, 16, 2, '185000'),
(40, 18, 1, '170000'),
(40, 16, 2, '185000'),
(41, 18, 1, '170000'),
(41, 16, 2, '185000'),
(42, 18, 1, '170000'),
(42, 16, 2, '185000'),
(43, 20, 1, '140000'),
(43, 19, 2, '155000'),
(44, 20, 1, '140000'),
(44, 19, 2, '155000'),
(45, 20, 1, '140000'),
(45, 19, 2, '155000'),
(46, 20, 1, '140000'),
(46, 19, 2, '155000'),
(47, 20, 1, '140000'),
(47, 17, 2, '230000'),
(48, 20, 2, '140000'),
(48, 19, 2, '155000'),
(49, 16, 2, '185000'),
(49, 15, 2, '85000'),
(49, 14, 2, '80000'),
(50, 16, 1, '185000'),
(50, 15, 2, '85000'),
(52, 13, 1, '90000'),
(52, 15, 2, '85000'),
(53, 17, 2, '230000'),
(53, 20, 1, '140000'),
(54, 20, 1, '140000'),
(54, 20, 1, '140000'),
(54, 20, 1, '140000'),
(55, 19, 1, '155000'),
(56, 19, 1, '155000'),
(57, 19, 1, '155000'),
(58, 19, 1, '155000'),
(59, 19, 1, '155000'),
(60, 19, 1, '155000'),
(61, 19, 1, '155000'),
(62, 19, 1, '155000'),
(63, 19, 1, '155000'),
(64, 19, 1, '155000'),
(65, 19, 1, '155000'),
(66, 20, 1, '140000'),
(67, 20, 1, '140000'),
(68, 17, 1, '230000'),
(69, 13, 1, '90000'),
(70, 15, 1, '85000');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `donhang`
--

CREATE TABLE `donhang` (
  `id` int(11) NOT NULL,
  `iduser` int(11) NOT NULL,
  `diachi` text NOT NULL,
  `sodienthoai` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `soluong` int(11) NOT NULL,
  `tongtien` varchar(255) NOT NULL,
  `trangthai` int(2) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `donhang`
--

INSERT INTO `donhang` (`id`, `iduser`, `diachi`, `sodienthoai`, `email`, `soluong`, `tongtien`, `trangthai`) VALUES
(41, 11, '70b', '1234567890', 'lytienthanhs2@gmail.com', 0, '540000', 0),
(42, 11, '70b', '1234567890', 'lytienthanhs2@gmail.com', 0, '540000', 0),
(43, 11, '70c', '1234567890', 'lytienthanhs2@gmail.com', 0, '450000', 4),
(44, 2, '123 5246', '0123123123', 'lytienthanhs2@gmail.com', 4, '250000', 0),
(45, 11, '70c', '1234567890', 'lytienthanhs2@gmail.com', 0, '450000', 0),
(46, 11, 'lang bam', '1234567890', 'lytienthanhs2@gmail.com', 0, '450000', 2),
(47, 11, 'lam bam 2', '1234567890', 'lytienthanhs2@gmail.com', 3, '600000', 0),
(48, 11, 'abc', '1234567890', 'lytienthanhs2@gmail.com', 4, '590000', 0),
(49, 11, 'xyz', '1234567890', 'lytienthanhs2@gmail.com', 6, '700000', 0),
(50, 11, 'gz gz gz', '1234567890', 'lytienthanhs2@gmail.com', 3, '355000', 0),
(51, 11, 'gr gr gr', '1234567890', 'lytienthanhs2@gmail.com', 3, '460000', 0),
(52, 11, 'tr tr tr', '1234567890', 'lytienthanhs2@gmail.com', 3, '260000', 0),
(53, 11, 'ui ui ui', '1234567890', 'lytienthanhs2@gmail.com', 3, '600000', 0),
(54, 9, 'q1', '1234567890', 'ltt@gmail.com', 3, '420000', 2),
(55, 15, 'ko co', '069796949594', 'user1@gmail.com', 1, '155000', 3),
(56, 15, 'ko co', '069796949594', 'user1@gmail.com', 1, '155000', 0),
(57, 15, 'ko co', '069796949594', 'user1@gmail.com', 1, '155000', 0),
(58, 15, 'ko co', '069796949594', 'user1@gmail.com', 1, '155000', 0),
(59, 15, 'ko co', '069796949594', 'user1@gmail.com', 1, '155000', 0),
(60, 15, 'ko co', '069796949594', 'user1@gmail.com', 1, '155000', 0),
(61, 15, 'ko co', '069796949594', 'user1@gmail.com', 1, '155000', 3),
(62, 15, 'ko co', '069796949594', 'user1@gmail.com', 1, '155000', 0),
(63, 15, 'ko co', '069796949594', 'user1@gmail.com', 1, '155000', 0),
(64, 15, 'ko co', '069796949594', 'user1@gmail.com', 1, '155000', 2),
(65, 15, 'ko co', '069796949594', 'user1@gmail.com', 1, '155000', 2),
(66, 15, 'ngu', '069796949594', 'user1@gmail.com', 1, '140000', 3),
(67, 15, 'ko bt', '069796949594', 'user1@gmail.com', 1, '140000', 0),
(68, 15, 'cv', '069796949594', 'user1@gmail.com', 1, '230000', 0),
(69, 15, 'hn', '069796949594', 'user1@gmail.com', 1, '90000', 2),
(70, 15, 'm', '069796949594', 'user1@gmail.com', 1, '85000', 0);

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
(6, 'Quản lý', 'https://th.bing.com/th/id/OIP.puMo9ITfruXP8iQx9cYcqwHaGJ?w=239&h=197&c=7&r=0&o=5&dpr=1.3&pid=1.7'),
(7, 'Đơn hàng', 'https://th.bing.com/th/id/OIP.puMo9ITfruXP8iQx9cYcqwHaGJ?w=239&h=197&c=7&r=0&o=5&dpr=1.3&pid=1.7');

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
  `mobile` varchar(15) NOT NULL,
  `uid` text NOT NULL,
  `token` text NOT NULL,
  `status` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `user`
--

INSERT INTO `user` (`id`, `email`, `pass`, `username`, `mobile`, `uid`, `token`, `status`) VALUES
(15, 'user1@gmail.com', '123456', 'user user 1', '069796949594', 'UFsvbBmTfWXJNZbtUMzzijvQtIs1', 'ff7ZOINqT42IQXa-9cFfNH:APA91bHMIJCi3XC8L4xS2saER8-39B1K6AuGCGORUQKj8yhop2IERnxds2ZLH99yGH6H3O3G-pI9NB_Jawz_ycplTceYU1HeO2NX5jCwPvcdk4hr55mIb0q0tSiR3hfz5AhMfNxgDh7u', 0),
(16, 'admin1@gmail.com', '123456', 'admin1', '0986532656', 'xgjdiK0d6cfeSPksMnNkbHLk1yq2', 'eXVQDIakTfGES84Y3Jxzd0:APA91bFK_2aYoN7Gb41MSGn5Szj5JWYBe9zxmRKhxgRjIxWz0-htrVtXYHdb_Nu4J27nCuIS2CnweqQYkTAFQE3LCfqGWhJJFNe4-SU7g2yFO4oo9CMB16LRXXbCj6DxlpajAj8faJcj', 1);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `donhang`
--
ALTER TABLE `donhang`
  ADD PRIMARY KEY (`id`);

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
-- AUTO_INCREMENT cho bảng `donhang`
--
ALTER TABLE `donhang`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=71;

--
-- AUTO_INCREMENT cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT cho bảng `sanphammoi`
--
ALTER TABLE `sanphammoi`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT cho bảng `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
