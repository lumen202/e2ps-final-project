-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 11, 2025 at 05:29 AM
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
(10, 10, '', '', 'Barangay Agutayan Hilongos Leyte', '', 0),
(11, 11, 'Albuera', 'Leyte', 'Soob', 'Poblacion', 0),
(12, 12, 'Albuera', 'Leyte', '', 'Setio.wangag', 0),
(13, 13, 'Albuera', 'Leyte', 'Sanico', 'Laping', 0),
(14, 14, 'Baybay City', 'Leyte', '', 'Brgy.Igang', 0),
(15, 15, 'Hilongos', 'Leyte', 'Mabini St.', 'Eastern Brgy.', 0),
(16, 16, 'Mahaplag', 'Leyte', 'Sitio Inanggihan', 'Brgy Union', 0),
(17, 17, '', '', 'BRGY. SAN ISIDRO MAHAPLAG LEYTE', '', 0),
(18, 18, 'poblacion mahaplag', 'leyte', '', 'Sitio tomoy brgy', 0),
(19, 19, 'kananga', 'Leyte', '', 'Natubgan', 0),
(20, 20, 'Hilongos', 'Leyte', '', 'Barangay Agutayan', 0);

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
(1, 6, 1, 730, 1130, 0, 0),
(2, 5, 1, 730, 1130, 0, 0),
(3, 3, 1, 730, 1130, 0, 0),
(4, 4, 1, 730, 1130, 0, 0),
(6, 10, 1, 0, 0, 0, 0),
(9, 6, 2, 730, 1130, 1300, 1630),
(10, 5, 2, 730, 1130, 1300, 1630),
(11, 3, 2, 730, 1130, 1300, 1630),
(13, 4, 2, 730, 1130, 0, 0),
(14, 12, 1, 730, 1130, 1300, 1630),
(15, 13, 11, 0, 1543, 1543, 1545),
(16, 13, 12, 0, 1550, 1550, 1552),
(17, 14, 15, 1104, 1104, 0, 0),
(18, 14, 12, 1108, 1108, 1435, 0),
(19, 15, 3, 730, 1130, 1300, 1630),
(20, 16, 3, 730, 1130, 1300, 1630),
(21, 17, 3, 730, 1130, 1300, 1630),
(22, 14, 19, 0, 1509, 1509, 1539),
(23, 15, 11, 730, 1130, 1300, 1630),
(24, 16, 12, 730, 1130, 1300, 1630),
(25, 16, 11, 730, 1130, 1300, 1630),
(26, 17, 11, 730, 1130, 1300, 1630),
(27, 14, 14, 0, 1631, 1631, 1632);

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
(3, 3, 5, 2025),
(4, 3, 6, 2025),
(5, 3, 4, 2025),
(6, 3, 3, 2025),
(10, 7, 2, 2024),
(11, 7, 1, 2024),
(12, 3, 7, 2025),
(13, 4, 8, 2025),
(14, 4, 10, 2025),
(15, 4, 1, 2025),
(16, 4, 2, 2025),
(17, 4, 3, 2025);

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
(74, 'Baybay'),
(75, 'Albuera'),
(76, 'Albuera'),
(77, 'Albuera'),
(78, 'Baybay'),
(79, 'Hilongos'),
(80, 'Mahaplag'),
(81, 'Mahaplag'),
(82, 'Mahaplag'),
(83, 'Kananga'),
(84, 'Baybay');

-- --------------------------------------------------------

--
-- Table structure for table `db_changes_log`
--

CREATE TABLE `db_changes_log` (
  `id` bigint(20) NOT NULL,
  `table_name` varchar(100) NOT NULL,
  `change_type` varchar(20) NOT NULL,
  `change_timestamp` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

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
(17, '', '', '', '', ''),
(18, '', '', '', '', ''),
(19, 'First s', 'Last', 'Middle', 'Sibling', '21'),
(20, '', '', '', '', ''),
(21, 'wala', '', '', '', ''),
(22, '', '', '', '', '');

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
(1, 2024, 2025, 'August', 'June', 12, 27),
(2, 2025, 2026, 'SEPTEMBER', 'JUNE', 1, 30),
(3, 2027, 2028, 'SEPTEMBER', 'JUNE', 1, 30),
(4, 2025, 2026, 'SEPTEMBER', 'JUNE', 1, 30),
(5, 2029, 2030, 'SEPTEMBER', 'JUNE', 1, 30),
(6, 2030, 2031, 'SEPTEMBER', 'JUNE', 1, 30),
(7, 2020, 2026, 'SEPTEMBER', 'JUNE', 1, 30),
(8, 2021, 2026, 'SEPTEMBER', 'JUNE', 1, 30);

-- --------------------------------------------------------

--
-- Table structure for table `settings_attendance`
--

CREATE TABLE `settings_attendance` (
  `settingsID` varchar(50) NOT NULL,
  `start` int(2) NOT NULL,
  `end` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `settings_attendance`
--

INSERT INTO `settings_attendance` (`settingsID`, `start`, `end`) VALUES
('July 2024', 1, 31),
('April 2025', 1, 30),
('March 2025', 1, 31),
('February 2025', 1, 28),
('December 2024', 1, 31),
('January 2025', 1, 31),
('August 2024', 1, 31),
('September 2024', 1, 30),
('October 2024', 1, 31),
('November 2024', 1, 30),
('May 2025', 1, 31),
('June 2025', 1, 30);

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `StudentID` int(11) NOT NULL,
  `deleted` int(1) NOT NULL,
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

INSERT INTO `student` (`StudentID`, `deleted`, `yearID`, `FirstName`, `LastName`, `MiddleName`, `NameExtension`, `Email`, `Status`, `ContactInfo`, `DateofBirth`, `Fare`, `ClusterID`) VALUES
(1, 1, 1, 'Daniel', 'Dela Torre', 'Estremos', '', 'delatorredaniel2006@gmail.com', 'Active', '09935927942', '2025-03-18', 50, 65),
(2, 1, 1, 'Jay Anthony', 'De Villena', 'Almosa', '', 'godsanthony15@gmail.com', 'Active', '09563796024', '2025-03-18', 100, 66),
(3, 1, 1, 'Shallei Elizabeth', 'Laping', 'Sanico', '', 'shalleielizabethlaping06@gmail', 'Active', '09938790415', '2025-03-18', 0, 67),
(4, 1, 1, 'Reymark', 'Fernandez', 'Caputol', '', 'reymarkfernandez71@gmail.com', 'Active', '09480266342', '2025-03-18', 0, 68),
(5, 1, 1, 'Joshua', 'Diniega', 'Rubillos', '', 'jdiniega202@gmail.com', 'Active', '09208883990', '2025-03-18', 0, 69),
(6, 1, 1, 'Roniljess', 'Matugas', 'Ereve', '', 'roniljessmatugas@gmail.com', 'Active', '09704525110', '2025-03-18', 0, 70),
(7, 1, 1, 'MYRA', 'PADALAPAT', 'OLAYBAR', '', '121649100034@r8.deped.gov.ph', 'Active', '09208839244', '2025-03-18', 0, 71),
(8, 1, 1, 'Marco', 'Dichon', 'Galagar', '', 'marcopain99@gmail.com', 'Active', '09471415988', '2025-03-18', 0, 72),
(9, 1, 1, 'Cherry Anne', 'Erlandez', 'Zagado', '', 'cherryanneerlandez96@gmail.com', 'Active', '09269797129', '2025-03-18', 0, 73),
(10, 1, 1, 'Vicente', 'Costado', 'Tahil', 'Jr', 'vicentecostadojr@gmail.com', 'Active', '09368248415', '2025-03-18', 0, 74),
(11, 0, 1, 'Daniel', 'Dela Torre', 'Estremos', '', 'delatorredaniel2006@gmail.com', 'Active', '09935927942', '2025-03-28', 500, 75),
(12, 0, 1, 'Jay Anthony', 'De Villena', 'Almosa', '', 'godsanthony15@gmail.com', 'Active', '09563796024', '2025-03-28', 0, 76),
(13, 1, 1, 'Shallei Elizabeth', 'Laping', 'Sanico', '', 'shalleielizabethlaping06@gmail', 'Active', '09938790415', '2025-03-28', 0, 77),
(14, 0, 1, 'Reymark', 'Fernandez', 'Caputol', '', 'reymarkfernandez71@gmail.com', 'Active', '09480266342', '2025-03-28', 0, 78),
(15, 0, 1, 'Joshua', 'Diniega', 'Rubillos', '', 'jdiniega202@gmail.com', 'Active', '09208883990', '2025-03-28', 0, 79),
(16, 0, 1, 'Roniljess', 'Matugas', 'Ereve', '', 'roniljessmatugas@gmail.com', 'Active', '09704525110', '2025-03-28', 0, 80),
(17, 0, 1, 'MYRA', 'PADALAPAT', 'OLAYBAR', '', '121649100034@r8.deped.gov.ph', 'Active', '09208839244', '2025-03-28', 0, 81),
(18, 0, 1, 'Marco', 'Dichon', 'Galagar', '', 'marcopain99@gmail.com', 'Active', '09471415988', '2025-03-28', 0, 82),
(19, 0, 1, 'Cherry Anne', 'Erlandez', 'Zagado', '', 'cherryanneerlandez96@gmail.com', 'Active', '09269797129', '2025-03-28', 0, 83),
(20, 0, 1, 'Vicente', 'Costado', 'Tahil', 'Jr', 'vicentecostadojr@gmail.com', 'Active', '09368248415', '2025-03-28', 0, 84);

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
(5, 16),
(1, 19),
(3, 20),
(7, 21),
(11, 22);

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
-- Indexes for table `db_changes_log`
--
ALTER TABLE `db_changes_log`
  ADD PRIMARY KEY (`id`);

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
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `db_changes_log`
--
ALTER TABLE `db_changes_log`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

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
