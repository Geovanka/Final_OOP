-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 07, 2024 at 02:32 PM
-- Server version: 10.4.19-MariaDB
-- PHP Version: 8.0.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `restomanagement`
--

-- --------------------------------------------------------

--
-- Table structure for table `menubali`
--

CREATE TABLE `menubali` (
  `MenuID` char(4) NOT NULL CHECK (`MenuID` regexp '^M0[0-9][0-9]$'),
  `MenuName` varchar(50) NOT NULL,
  `Price` int(11) NOT NULL,
  `MenuType` varchar(50) NOT NULL,
  `Narasi` varchar(1000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `menubali`
--

INSERT INTO `menubali` (`MenuID`, `MenuName`, `Price`, `MenuType`, `Narasi`) VALUES
('M001', 'Kentang Kukus', 25000, 'Main', NULL),
('M002', 'Sop Bebek', 30000, 'Main', NULL),
('M003', 'Tahu Bakar', 10000, 'Main', NULL),
('M004', 'Ikan Mentah', 35000, 'SpecialMenu', 'Ikan Mentah adalah hidangan segar yang menghadirkan keautentikan rasa laut dalam setiap gigitan. Potongan ikan yang segar dan lembut disajikan dengan tata letak artistik, menciptakan pengalaman menyantap yang sederhana namun elegan.'),
('M005', 'Waffle Goreng', 20000, 'SpecialMenu', '\"Waffle Goreng\" adalah perpaduan sempurna antara kelembutan waffle tradisional dan kegaringan hasil gorengan. Setiap gigitan mengungkap tekstur yang renyah di luar, sementara bagian dalamnya tetap lembut dan beraroma manis. Disajikan dengan topping favorit, waffle goreng menjadi sajian yang memikat selera dengan sentuhan inovatif pada cita rasa klasik.');

-- --------------------------------------------------------

--
-- Table structure for table `menubandung`
--

CREATE TABLE `menubandung` (
  `MenuID` char(4) NOT NULL CHECK (`MenuID` regexp '^M0[0-9][0-9]$'),
  `MenuName` varchar(50) NOT NULL,
  `Price` int(11) NOT NULL,
  `MenuType` varchar(50) NOT NULL,
  `Narasi` varchar(1000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `menubandung`
--

INSERT INTO `menubandung` (`MenuID`, `MenuName`, `Price`, `MenuType`, `Narasi`) VALUES
('M001', 'Kentang Kukus', 25000, 'Main', NULL),
('M002', 'Sop Bebek', 30000, 'Main', NULL),
('M003', 'Tahu Bakar', 10000, 'Main', NULL),
('M004', 'Ikan Mentah', 35000, 'SpecialMenu', 'Ikan Mentah adalah hidangan segar yang menghadirkan keautentikan rasa laut dalam setiap gigitan. Potongan ikan yang segar dan lembut disajikan dengan tata letak artistik, menciptakan pengalaman menyantap yang sederhana namun elegan.'),
('M005', 'Waffle Goreng', 20000, 'SpecialMenu', '\"Waffle Goreng\" adalah perpaduan sempurna antara kelembutan waffle tradisional dan kegaringan hasil gorengan. Setiap gigitan mengungkap tekstur yang renyah di luar, sementara bagian dalamnya tetap lembut dan beraroma manis. Disajikan dengan topping favorit, waffle goreng menjadi sajian yang memikat selera dengan sentuhan inovatif pada cita rasa klasik.');

-- --------------------------------------------------------

--
-- Table structure for table `menujakarta`
--

CREATE TABLE `menujakarta` (
  `MenuID` char(4) NOT NULL CHECK (`MenuID` regexp '^M0[0-9][0-9]$'),
  `MenuName` varchar(50) NOT NULL,
  `Price` int(11) NOT NULL,
  `MenuType` varchar(50) NOT NULL,
  `Narasi` varchar(1000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `menujakarta`
--

INSERT INTO `menujakarta` (`MenuID`, `MenuName`, `Price`, `MenuType`, `Narasi`) VALUES
('M001', 'Kentang Kukus', 25000, 'Main', NULL),
('M002', 'Sop Bebek', 30000, 'Main', NULL),
('M003', 'Tahu Bakar', 10000, 'Main', NULL),
('M004', 'Ikan Mentah', 35000, 'SpecialMenu', 'Ikan Mentah adalah hidangan segar yang menghadirkan keautentikan rasa laut dalam setiap gigitan. Potongan ikan yang segar dan lembut disajikan dengan tata letak artistik, menciptakan pengalaman menyantap yang sederhana namun elegan.'),
('M005', 'Waffle Goreng', 20000, 'SpecialMenu', '\"Waffle Goreng\" adalah perpaduan sempurna antara kelembutan waffle tradisional dan kegaringan hasil gorengan. Setiap gigitan mengungkap tekstur yang renyah di luar, sementara bagian dalamnya tetap lembut dan beraroma manis. Disajikan dengan topping favorit, waffle goreng menjadi sajian yang memikat selera dengan sentuhan inovatif pada cita rasa klasik.');

-- --------------------------------------------------------

--
-- Table structure for table `menupadang`
--

CREATE TABLE `menupadang` (
  `MenuID` char(4) NOT NULL CHECK (`MenuID` regexp '^M1[0-9][0-9]$'),
  `MenuName` varchar(50) NOT NULL,
  `Price` int(11) NOT NULL,
  `MenuType` varchar(50) NOT NULL,
  `Narasi` varchar(1000) DEFAULT NULL,
  `Location` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `menupadang`
--

INSERT INTO `menupadang` (`MenuID`, `MenuName`, `Price`, `MenuType`, `Narasi`, `Location`) VALUES
('M101', 'Kentang Kukus', 25000, 'Local', NULL, NULL),
('M102', 'Sop Bebek', 30000, 'Local', NULL, NULL),
('M103', 'Tahu Bakar', 10000, 'Local', NULL, NULL),
('M104', 'Udang Hidup', 40000, 'LocalSpecial', 'Udang Hidup menghadirkan pengalaman kuliner yang segar dan autentik. Udang yang hidup, segar dari lautan, disajikan dengan tampilan menarik. Sensasi kenyal dan manisnya daging udang langsung dapat dinikmati, mempersembahkan kelezatan laut yang penuh keaslian dalam setiap suap.', 'Atlantis'),
('M105', 'Es Krim Panas', 15000, 'LocalSpecial', 'Es Krim Panas adalah kombinasi unik antara es krim lembut dan panci panas, menciptakan sensasi menyantap yang luar biasa. Aroma manis dan tekstur yang kontras menawarkan pengalaman kuliner yang tak terlupakan.', 'Mediterania');

-- --------------------------------------------------------

--
-- Table structure for table `menusamarinda`
--

CREATE TABLE `menusamarinda` (
  `MenuID` char(4) NOT NULL CHECK (`MenuID` regexp '^M1[0-9][0-9]$'),
  `MenuName` varchar(50) NOT NULL,
  `Price` int(11) NOT NULL,
  `MenuType` varchar(50) NOT NULL,
  `Narasi` varchar(1000) DEFAULT NULL,
  `Location` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `menusamarinda`
--

INSERT INTO `menusamarinda` (`MenuID`, `MenuName`, `Price`, `MenuType`, `Narasi`, `Location`) VALUES
('M101', 'Kentang Kukus', 25000, 'Local', NULL, NULL),
('M102', 'Sop Bebek', 30000, 'Local', NULL, NULL),
('M103', 'Tahu Bakar', 10000, 'Local', NULL, NULL),
('M104', 'Udang Hidup', 40000, 'LocalSpecial', 'Udang Hidup menghadirkan pengalaman kuliner yang segar dan autentik. Udang yang hidup, segar dari lautan, disajikan dengan tampilan menarik. Sensasi kenyal dan manisnya daging udang langsung dapat dinikmati, mempersembahkan kelezatan laut yang penuh keaslian dalam setiap suap.', 'Atlantis'),
('M105', 'Es Krim Panas', 15000, 'LocalSpecial', 'Es Krim Panas adalah kombinasi unik antara es krim lembut dan panci panas, menciptakan sensasi menyantap yang luar biasa. Aroma manis dan tekstur yang kontras menawarkan pengalaman kuliner yang tak terlupakan.', 'Mediterania');

-- --------------------------------------------------------

--
-- Table structure for table `menusurabaya`
--

CREATE TABLE `menusurabaya` (
  `MenuID` char(4) NOT NULL CHECK (`MenuID` regexp '^M1[0-9][0-9]$'),
  `MenuName` varchar(50) NOT NULL,
  `Price` int(11) NOT NULL,
  `MenuType` varchar(50) NOT NULL,
  `Narasi` varchar(1000) DEFAULT NULL,
  `Location` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `menusurabaya`
--

INSERT INTO `menusurabaya` (`MenuID`, `MenuName`, `Price`, `MenuType`, `Narasi`, `Location`) VALUES
('M101', 'Kentang Kukus', 25000, 'Local', NULL, NULL),
('M102', 'Sop Bebek', 30000, 'Local', NULL, NULL),
('M103', 'Tahu Bakar', 10000, 'Local', NULL, NULL),
('M104', 'Udang Hidup', 40000, 'LocalSpecial', 'Udang Hidup menghadirkan pengalaman kuliner yang segar dan autentik. Udang yang hidup, segar dari lautan, disajikan dengan tampilan menarik. Sensasi kenyal dan manisnya daging udang langsung dapat dinikmati, mempersembahkan kelezatan laut yang penuh keaslian dalam setiap suap.', 'Atlantis'),
('M105', 'Es Krim Panas', 15000, 'LocalSpecial', 'Es Krim Panas adalah kombinasi unik antara es krim lembut dan panci panas, menciptakan sensasi menyantap yang luar biasa. Aroma manis dan tekstur yang kontras menawarkan pengalaman kuliner yang tak terlupakan.', 'Mediterania');

-- --------------------------------------------------------

--
-- Table structure for table `mscity`
--

CREATE TABLE `mscity` (
  `CityID` char(4) NOT NULL,
  `CityName` varchar(15) NOT NULL,
  `BranchType` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `mscity`
--

INSERT INTO `mscity` (`CityID`, `CityName`, `BranchType`) VALUES
('C001', 'Bandung', 'Main'),
('C002', 'Jakarta', 'Main'),
('C003', 'Bali', 'Main'),
('C004', 'Surabaya', 'Local'),
('C005', 'Samarinda', 'Local'),
('C006', 'Padang', 'Local');

-- --------------------------------------------------------

--
-- Table structure for table `msemployee`
--

CREATE TABLE `msemployee` (
  `EmployeeID` char(5) NOT NULL,
  `EmployeeName` varchar(25) NOT NULL,
  `CityID` char(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `msemployee`
--

INSERT INTO `msemployee` (`EmployeeID`, `EmployeeName`, `CityID`) VALUES
('BD001', 'Alice', 'C001'),
('BD002', 'Nonoh', 'C001'),
('BL001', 'Pepe', 'C003'),
('BL002', 'Ebet', 'C003'),
('JK001', 'Broski', 'C002'),
('JK002', 'Jakron', 'C002'),
('PD001', 'Kebin', 'C006'),
('PD002', 'Naom', 'C006'),
('SB001', 'Moka', 'C004'),
('SB002', 'Bibi', 'C004'),
('SM001', 'Cici', 'C005'),
('SM002', 'Nolan', 'C005');

-- --------------------------------------------------------

--
-- Table structure for table `msorder`
--

CREATE TABLE `msorder` (
  `OrderID` char(4) NOT NULL CHECK (`OrderID` regexp '^O[0-9][0-9][0-9]$'),
  `ReservationID` char(4) NOT NULL CHECK (`ReservationID` regexp '^R[0-9][0-9][0-9]$'),
  `MenuID` char(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `msorder`
--

INSERT INTO `msorder` (`OrderID`, `ReservationID`, `MenuID`) VALUES
('O001', 'R001', 'M001'),
('O002', 'R001', 'M005'),
('O003', 'R002', 'M101'),
('O004', 'R002', 'M105'),
('O005', 'R003', 'M103'),
('O006', 'R003', 'M104'),
('O007', 'R003', 'M004'),
('O008', 'R001', 'M003'),
('O009', 'R001', 'M002');

-- --------------------------------------------------------

--
-- Table structure for table `msreservation`
--

CREATE TABLE `msreservation` (
  `ReservationID` char(4) NOT NULL,
  `ReservationName` varchar(25) NOT NULL,
  `TotalTable` int(11) NOT NULL,
  `TableType` varchar(10) NOT NULL,
  `TotalPerson` int(11) NOT NULL,
  `ReservationStatus` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `msreservation`
--

INSERT INTO `msreservation` (`ReservationID`, `ReservationName`, `TotalTable`, `TableType`, `TotalPerson`, `ReservationStatus`) VALUES
('R001', 'Edith', 1, 'Romantic', 2, 'in reserve'),
('R002', 'Killian', 1, 'General', 4, 'in order'),
('R003', 'Cliff', 1, 'Family', 7, 'finalized');

-- --------------------------------------------------------

--
-- Table structure for table `transactiondetail`
--

CREATE TABLE `transactiondetail` (
  `TransactionID` char(5) NOT NULL CHECK (`TransactionID` regexp '^TR[0-9][0-9][0-9]$'),
  `EmployeeID` char(5) NOT NULL,
  `ReservationID` char(4) NOT NULL CHECK (`ReservationID` regexp '^R[0-9][0-9][0-9]$')
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `transactiondetail`
--

INSERT INTO `transactiondetail` (`TransactionID`, `EmployeeID`, `ReservationID`) VALUES
('TR001', 'BD001', 'R001'),
('TR002', 'JK001', 'R002'),
('TR003', 'BL001', 'R003');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `menubali`
--
ALTER TABLE `menubali`
  ADD PRIMARY KEY (`MenuID`);

--
-- Indexes for table `menubandung`
--
ALTER TABLE `menubandung`
  ADD PRIMARY KEY (`MenuID`);

--
-- Indexes for table `menujakarta`
--
ALTER TABLE `menujakarta`
  ADD PRIMARY KEY (`MenuID`);

--
-- Indexes for table `menupadang`
--
ALTER TABLE `menupadang`
  ADD PRIMARY KEY (`MenuID`);

--
-- Indexes for table `menusamarinda`
--
ALTER TABLE `menusamarinda`
  ADD PRIMARY KEY (`MenuID`);

--
-- Indexes for table `menusurabaya`
--
ALTER TABLE `menusurabaya`
  ADD PRIMARY KEY (`MenuID`);

--
-- Indexes for table `mscity`
--
ALTER TABLE `mscity`
  ADD PRIMARY KEY (`CityID`);

--
-- Indexes for table `msemployee`
--
ALTER TABLE `msemployee`
  ADD PRIMARY KEY (`EmployeeID`),
  ADD KEY `CityID` (`CityID`);

--
-- Indexes for table `msorder`
--
ALTER TABLE `msorder`
  ADD PRIMARY KEY (`OrderID`),
  ADD KEY `ReservationID` (`ReservationID`);

--
-- Indexes for table `msreservation`
--
ALTER TABLE `msreservation`
  ADD PRIMARY KEY (`ReservationID`);

--
-- Indexes for table `transactiondetail`
--
ALTER TABLE `transactiondetail`
  ADD PRIMARY KEY (`TransactionID`),
  ADD KEY `EmployeeID` (`EmployeeID`),
  ADD KEY `ReservationID` (`ReservationID`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `msemployee`
--
ALTER TABLE `msemployee`
  ADD CONSTRAINT `msemployee_ibfk_1` FOREIGN KEY (`CityID`) REFERENCES `mscity` (`CityID`);

--
-- Constraints for table `msorder`
--
ALTER TABLE `msorder`
  ADD CONSTRAINT `msorder_ibfk_1` FOREIGN KEY (`ReservationID`) REFERENCES `msreservation` (`ReservationID`);

--
-- Constraints for table `transactiondetail`
--
ALTER TABLE `transactiondetail`
  ADD CONSTRAINT `transactiondetail_ibfk_1` FOREIGN KEY (`EmployeeID`) REFERENCES `msemployee` (`EmployeeID`),
  ADD CONSTRAINT `transactiondetail_ibfk_2` FOREIGN KEY (`ReservationID`) REFERENCES `msreservation` (`ReservationID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
