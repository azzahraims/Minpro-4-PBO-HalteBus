-- phpMyAdmin SQL Dump
-- version 5.2.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Oct 14, 2026 at 10:16 PM
-- Server version: 8.4.3
-- PHP Version: 8.5.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `manajemen_halte_bus`
--

-- --------------------------------------------------------

--
-- Table structure for table `halte`
--

CREATE TABLE `halte` (
  `id_halte` varchar(12) NOT NULL,
  `nama_halte` varchar(100) NOT NULL,
  `lokasi` varchar(150) NOT NULL,
  `kapasitas` int NOT NULL,
  `rute_bus` varchar(100) NOT NULL,
  `jenis_halte` varchar(20) NOT NULL,
  `detail_halte` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `halte`
--

INSERT INTO `halte` (`id_halte`, `nama_halte`, `lokasi`, `kapasitas`, `rute_bus`, `jenis_halte`, `detail_halte`) VALUES
('H001', 'Halte Taman Kota', 'Jalan Merdeka', 20, 'Rute A1', 'Reguler', 'Terminal Kota'),
('H002', 'Halte Pusat Kota', 'Jalan Sudirman', 40, 'Rute A2', 'Transit', 'Rute B2'),
('H003', 'Halte Universitas', 'Jalan Pendidikan', 25, 'Rute A3', 'Reguler', 'Terminal Kampus'),
('H004', 'Halte Stadion Utama', 'Jalan Bhayangkara', 50, 'Rute A6', 'Reguler', 'Terminal Stadion');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `halte`
--
ALTER TABLE `halte`
  ADD PRIMARY KEY (`id_halte`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
