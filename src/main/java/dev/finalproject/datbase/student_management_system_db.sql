-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 26, 2025 at 07:36 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `student_management_system_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `address`
--

CREATE TABLE `address` (
  `studentID` int(11) NOT NULL,
  `addressID` int(11) NOT NULL,
  `city` varchar(50) NOT NULL,
  `municipality` varchar(50) NOT NULL,
  `street` varchar(50) DEFAULT NULL,
  `barangay` varchar(50) DEFAULT NULL,
  `zipCode` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `address`
--

INSERT INTO `address` (`studentID`, `addressID`, `city`, `municipality`, `street`, `barangay`, `zipCode`) VALUES
(1, 1, 'Albuera', 'Leyte', 'Soob', 'Poblacion', 0),
(2, 2, 'Leyte', '', 'Setio.wangag', 'Albuera', 0),
(3, 3, '', '', 'Albuera Leyte', '', 0),
(4, 4, 'Leyte', '', 'Brgy.Igang', 'Baybay City', 0),
(5, 5, 'Leyte', '', 'Mabini St.', 'Eastern Brgy. Hilongos', 0),
(6, 6, '', '', 'Sitio Inanggihan Brgy Union', 'Mahaplag Leyte', 0),
(7, 7, '', '', 'BRGY. SAN ISIDRO MAHAPLAG LEYTE', '', 0),
(8, 8, 'leyte', '', 'Sitio tomoy brgy', 'poblacion mahaplag', 0),
(9, 9, '', '', 'Natubgan kananga Leyte', '', 0),
(10, 10, '', '', 'Barangay Agutayan Hilongos Leyte', '', 0);

-- --------------------------------------------------------

--
-- Table structure for table `attendance_log`
--

CREATE TABLE `attendance_log` (
  `logID` int(11) NOT NULL,
  `recordID` int(11) NOT NULL,
  `student_id` int(11) NOT NULL,
  `time_in_am` int(11) NOT NULL,
  `time_out_am` int(11) NOT NULL,
  `time_in_pm` int(11) NOT NULL,
  `time_out_pm` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `attendance_log`
--

INSERT INTO `attendance_log` (`logID`, `recordID`, `student_id`, `time_in_am`, `time_out_am`, `time_in_pm`, `time_out_pm`) VALUES
(1, 1, 1, 730, 1130, 1300, 1630),
(2, 2, 1, 730, 1130, 1300, 1630),
(3, 3, 1, 0, 0, 0, 0),
(5, 5, 1, 730, 1130, 1300, 1630),
(6, 6, 1, 730, 1130, 1300, 1630),
(7, 7, 1, 730, 1130, 1300, 1630),
(8, 8, 1, 730, 1130, 1300, 1630),
(9, 9, 1, 730, 1130, 1300, 1630),
(10, 10, 1, 730, 1130, 1300, 1630),
(11, 1, 2, 730, 1130, 1300, 1630),
(13, 1, 3, 3000, 3000, 3000, 3000),
(14, 2, 3, 3000, 3000, 3000, 3000),
(16, 3, 3, 730, 1130, 1300, 1630),
(17, 2, 4, 0, 0, 0, 0),
(18, 1, 4, 730, 1130, 1300, 1630),
(19, 2, 2, 730, 1130, 0, 0),
(20, 12, 1, 730, 1130, 1300, 1630),
(21, 13, 1, 730, 1130, 1300, 1630),
(22, 14, 1, 730, 1130, 1300, 1630),
(23, 15, 1, 730, 1130, 1300, 1630);

-- --------------------------------------------------------

--
-- Table structure for table `attendance_record`
--

CREATE TABLE `attendance_record` (
  `recordID` int(11) NOT NULL,
  `Month` int(2) NOT NULL,
  `Day` int(2) NOT NULL,
  `Year` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `attendance_record`
--

INSERT INTO `attendance_record` (`recordID`, `Month`, `Day`, `Year`) VALUES
(1, 3, 3, 2025),
(2, 3, 4, 2025),
(3, 3, 5, 2025),
(5, 3, 7, 2025),
(6, 3, 10, 2025),
(7, 3, 11, 2025),
(8, 3, 17, 2025),
(9, 3, 13, 2025),
(10, 3, 19, 2025),
(11, 3, 6, 2025),
(12, 7, 2, 2024),
(13, 9, 2, 2024),
(14, 9, 3, 2024),
(15, 9, 4, 2024);

-- --------------------------------------------------------

--
-- Table structure for table `cluster`
--

CREATE TABLE `cluster` (
  `clusterID` int(11) NOT NULL,
  `clusterName` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `cluster`
--

INSERT INTO `cluster` (`clusterID`, `clusterName`) VALUES
(0, 'Default'),
(1, 'Hilongos'),
(2, 'Default'),
(3, 'Default'),
(4, 'Default'),
(5, 'Default'),
(6, 'Default'),
(7, 'Default'),
(8, 'Default'),
(9, 'Default'),
(10, 'Default'),
(11, 'Default'),
(12, 'Default'),
(13, 'Default'),
(14, 'Default'),
(15, 'Default'),
(16, 'Default'),
(17, 'Default'),
(18, 'Default'),
(19, 'Default'),
(20, 'Default'),
(21, 'Default'),
(22, 'Default'),
(23, 'Default'),
(24, 'Default'),
(25, 'Default'),
(26, 'Default'),
(27, 'Default'),
(28, 'Default'),
(29, 'Default'),
(30, 'Default'),
(31, 'Default'),
(32, 'Default'),
(33, 'Default'),
(34, 'Default'),
(35, 'Default'),
(36, 'Default'),
(37, 'Default'),
(38, 'Default'),
(39, 'Default'),
(40, 'Default'),
(41, 'Default'),
(42, 'Default'),
(43, 'Default'),
(44, 'Default'),
(45, 'Albuera'),
(46, 'Albuera'),
(47, 'Albuera'),
(48, 'Baybay'),
(49, 'Hilongos'),
(50, 'Mahaplag'),
(51, 'Mahaplag'),
(52, 'Mahaplag'),
(53, 'Kananga'),
(54, 'Baybay'),
(55, 'Albuera'),
(56, 'Albuera'),
(57, 'Albuera'),
(58, 'Baybay'),
(59, 'Hilongos'),
(60, 'Mahaplag'),
(61, 'Mahaplag'),
(62, 'Mahaplag'),
(63, 'Kananga'),
(64, 'Baybay'),
(65, 'Albuera'),
(66, 'Albuera'),
(67, 'Albuera'),
(68, 'Baybay'),
(69, 'Hilongos'),
(70, 'Mahaplag'),
(71, 'Mahaplag'),
(72, 'Mahaplag'),
(73, 'Kananga'),
(74, 'Baybay');

-- --------------------------------------------------------

--
-- Table structure for table `guardian`
--

CREATE TABLE `guardian` (
  `guardianID` int(10) NOT NULL,
  `firstName` varchar(20) NOT NULL,
  `middleName` varchar(20) NOT NULL,
  `lastName` varchar(20) NOT NULL,
  `relationship` varchar(10) NOT NULL,
  `contactInfo` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `guardian`
--

INSERT INTO `guardian` (`guardianID`, `firstName`, `middleName`, `lastName`, `relationship`, `contactInfo`) VALUES
(13, 'Michael', 'B.', 'Doe', 'Father', '998877665'),
(16, 'Edna', 'Diniega', 'Rubillos', 'Mother', '123'),
(17, '', '', '', '', '');

-- --------------------------------------------------------

--
-- Table structure for table `school_year`
--

CREATE TABLE `school_year` (
  `yearID` int(11) NOT NULL,
  `year_start` int(11) NOT NULL,
  `year_end` int(11) NOT NULL,
  `month_start` varchar(10) NOT NULL,
  `monthEnd` varchar(10) NOT NULL,
  `day_start` int(11) NOT NULL,
  `day_end` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `school_year`
--

INSERT INTO `school_year` (`yearID`, `year_start`, `year_end`, `month_start`, `monthEnd`, `day_start`, `day_end`) VALUES
(1, 2024, 2025, 'August', 'June', 12, 27);

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `StudentID` int(11) NOT NULL,
  `Archieved` int(11) NOT NULL,
  `yearID` int(11) NOT NULL,
  `FirstName` varchar(20) NOT NULL,
  `LastName` varchar(20) NOT NULL,
  `MiddleName` varchar(20) NOT NULL,
  `NameExtension` varchar(10) DEFAULT NULL,
  `Email` varchar(30) NOT NULL,
  `Status` varchar(20) NOT NULL,
  `ContactInfo` varchar(15) DEFAULT NULL,
  `DateofBirth` date NOT NULL,
  `Fare` double NOT NULL,
  `ClusterID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`StudentID`, `Archieved`, `yearID`, `FirstName`, `LastName`, `MiddleName`, `NameExtension`, `Email`, `Status`, `ContactInfo`, `DateofBirth`, `Fare`, `ClusterID`) VALUES
(1, 0, 1, 'Daniel', 'Dela Torre', 'Estremos', '', 'delatorredaniel2006@gmail.com', 'Active', '09935927942', '2025-03-18', 50, 65),
(2, 0, 1, 'Jay Anthony', 'De Villena', 'Almosa', '', 'godsanthony15@gmail.com', 'Active', '09563796024', '2025-03-18', 100, 66),
(3, 0, 1, 'Shallei Elizabeth', 'Laping', 'Sanico', '', 'shalleielizabethlaping06@gmail', 'Active', '09938790415', '2025-03-18', 0, 67),
(4, 0, 1, 'Reymark', 'Fernandez', 'Caputol', '', 'reymarkfernandez71@gmail.com', 'Active', '09480266342', '2025-03-18', 0, 68),
(5, 0, 1, 'Joshua', 'Diniega', 'Rubillos', '', 'jdiniega202@gmail.com', 'Active', '09208883990', '2025-03-18', 0, 69),
(6, 0, 1, 'Roniljess', 'Matugas', 'Ereve', '', 'roniljessmatugas@gmail.com', 'Active', '09704525110', '2025-03-18', 0, 70),
(7, 0, 1, 'MYRA', 'PADALAPAT', 'OLAYBAR', '', '121649100034@r8.deped.gov.ph', 'Active', '09208839244', '2025-03-18', 0, 71),
(8, 0, 1, 'Marco', 'Dichon', 'Galagar', '', 'marcopain99@gmail.com', 'Active', '09471415988', '2025-03-18', 0, 72),
(9, 0, 1, 'Cherry Anne', 'Erlandez', 'Zagado', '', 'cherryanneerlandez96@gmail.com', 'Active', '09269797129', '2025-03-18', 0, 73),
(10, 0, 1, 'Vicente', 'Costado', 'Tahil', 'Jr', 'vicentecostadojr@gmail.com', 'Active', '09368248415', '2025-03-18', 0, 74);

-- --------------------------------------------------------

--
-- Table structure for table `student_guardian`
--

CREATE TABLE `student_guardian` (
  `studentID` int(11) NOT NULL,
  `guardianID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `student_guardian`
--

INSERT INTO `student_guardian` (`studentID`, `guardianID`) VALUES
(5, 16);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `address`
--
ALTER TABLE `address`
  ADD KEY `Student_ID` (`studentID`);

--
-- Indexes for table `attendance_log`
--
ALTER TABLE `attendance_log`
  ADD PRIMARY KEY (`logID`),
  ADD KEY `Log_ID` (`recordID`),
  ADD KEY `Student_ID` (`student_id`);

--
-- Indexes for table `attendance_record`
--
ALTER TABLE `attendance_record`
  ADD PRIMARY KEY (`recordID`);

--
-- Indexes for table `cluster`
--
ALTER TABLE `cluster`
  ADD PRIMARY KEY (`clusterID`);

--
-- Indexes for table `guardian`
--
ALTER TABLE `guardian`
  ADD PRIMARY KEY (`guardianID`);

--
-- Indexes for table `school_year`
--
ALTER TABLE `school_year`
  ADD PRIMARY KEY (`yearID`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`StudentID`),
  ADD KEY `ClusterID` (`ClusterID`),
  ADD KEY `yearID` (`yearID`);

--
-- Indexes for table `student_guardian`
--
ALTER TABLE `student_guardian`
  ADD KEY `Student_ID` (`studentID`),
  ADD KEY `Guardian_ID` (`guardianID`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `address`
--
ALTER TABLE `address`
  ADD CONSTRAINT `address_ibfk_1` FOREIGN KEY (`studentID`) REFERENCES `student` (`StudentID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `attendance_log`
--
ALTER TABLE `attendance_log`
  ADD CONSTRAINT `attendance_log_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `student` (`StudentID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `attendance_log_ibfk_2` FOREIGN KEY (`recordID`) REFERENCES `attendance_record` (`recordID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `student`
--
ALTER TABLE `student`
  ADD CONSTRAINT `student_ibfk_1` FOREIGN KEY (`ClusterID`) REFERENCES `cluster` (`clusterID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `student_guardian`
--
ALTER TABLE `student_guardian`
  ADD CONSTRAINT `student_guardian_ibfk_1` FOREIGN KEY (`studentID`) REFERENCES `student` (`StudentID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `student_guardian_ibfk_2` FOREIGN KEY (`guardianID`) REFERENCES `guardian` (`guardianID`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
