-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 20, 2025 at 05:24 PM
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
(2, 2, 'Albuera', 'Leyte', '', 'Setio.wangag', 0),
(3, 3, 'Albuera', 'Leyte', 'Sanico', 'Laping', 0),
(4, 4, 'Baybay City', 'Leyte', '', 'Brgy.Igang', 0),
(5, 5, 'Hilongos', 'Leyte', 'Mabini St.', 'Eastern Brgy.', 0),
(6, 6, 'Mahaplag', 'Leyte', 'Sitio Inanggihan', 'Brgy Union', 0),
(7, 7, '', '', 'BRGY. SAN ISIDRO MAHAPLAG LEYTE', '', 0),
(8, 8, 'poblacion mahaplag', 'leyte', '', 'Sitio tomoy brgy', 0),
(9, 9, 'kananga', 'Leyte', '', 'Natubgan', 0),
(10, 10, 'Hilongos', 'Leyte', '', 'Barangay Agutayan', 0),
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
(1, 1, 5, 137, 137, 0, 0),
(2, 1, 1, 730, 1130, 1300, 1630);

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
(1, 4, 4, 2025);

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
(1, 'Albuera'),
(2, 'Albuera'),
(3, 'Albuera'),
(4, 'Baybay'),
(5, 'Hilongos'),
(6, 'Mahaplag'),
(7, 'Mahaplag'),
(8, 'Mahaplag'),
(9, 'Kananga'),
(10, 'Baybay'),
(11, 'Albuera'),
(12, 'Albuera'),
(13, 'Albuera'),
(14, 'Baybay'),
(15, 'Hilongos'),
(16, 'Mahaplag'),
(17, 'Mahaplag'),
(18, 'Mahaplag'),
(19, 'Kananga'),
(20, 'Baybay'),
(21, 'Albuera'),
(22, 'Albuera'),
(23, 'Albuera'),
(24, 'Baybay'),
(25, 'Hilongos'),
(26, 'Mahaplag'),
(27, 'Mahaplag'),
(28, 'Mahaplag'),
(29, 'Kananga'),
(30, 'Baybay'),
(31, 'Albuera'),
(32, 'Albuera'),
(33, 'Albuera'),
(34, 'Baybay'),
(35, 'Hilongos'),
(36, 'Mahaplag'),
(37, 'Mahaplag'),
(38, 'Mahaplag'),
(39, 'Kananga'),
(40, 'Baybay'),
(41, 'Albuera'),
(42, 'Albuera'),
(43, 'Albuera'),
(44, 'Baybay'),
(45, 'Hilongos'),
(46, 'Mahaplag'),
(47, 'Mahaplag'),
(48, 'Mahaplag'),
(49, 'Kananga'),
(50, 'Baybay');

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
(18, 'Jane', 'Doe', 'Dane', 'Mother', '092033312');

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
(13, 2026, 2027, 'SEPTEMBER', 'OCTOBER', 1, 31);

-- --------------------------------------------------------

--
-- Table structure for table `settings_attendance`
--

CREATE TABLE `settings_attendance` (
  `settingsID` varchar(100) NOT NULL,
  `start` int(11) NOT NULL,
  `end` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `settings_attendance`
--

INSERT INTO `settings_attendance` (`settingsID`, `start`, `end`) VALUES
('April 2025', 1, 30),
('August 2024', 1, 31),
('December 2024', 1, 31),
('February 2025', 1, 28),
('January 2025', 1, 31),
('July 2024', 1, 31),
('March 2025', 1, 31),
('May 2025', 1, 31),
('November 2024', 1, 30),
('October 2024', 1, 31),
('September 2024', 1, 30);

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `StudentID` int(11) NOT NULL,
  `deleted` int(1) NOT NULL,
  `deleted_at` datetime DEFAULT NULL,
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

INSERT INTO `student` (`StudentID`, `deleted`, `deleted_at`, `yearID`, `FirstName`, `LastName`, `MiddleName`, `NameExtension`, `Email`, `Status`, `ContactInfo`, `DateofBirth`, `Fare`, `ClusterID`) VALUES
(1, 0, NULL, 1, 'Daniel', 'Dela Torre', 'Estremos', '', 'delatorredaniel2006@gmail.com', 'Active', '09935927942', '2025-03-30', 201, 31),
(2, 0, NULL, 1, 'Jay Anthony', 'De Villena', 'Almosa', '', 'godsanthony15@gmail.com', 'Active', '09563796024', '2025-03-30', 0, 32),
(3, 0, NULL, 1, 'Shallei Elizabeth', 'Laping', 'Sanico', '', 'shalleielizabethlaping06@gmail', 'Active', '09938790415', '2025-03-30', 0, 33),
(4, 0, NULL, 1, 'Reymark', 'Fernandez', 'Caputol', '', 'reymarkfernandez71@gmail.com', 'Active', '09480266342', '2025-03-30', 0, 34),
(5, 0, NULL, 1, 'Joshua', 'Diniega', 'Rubillos', '', 'jdiniega202@gmail.com', 'Active', '09208883990', '2025-03-30', 0, 35),
(6, 0, NULL, 1, 'Roniljess', 'Matugas', 'Ereve', '', 'roniljessmatugas@gmail.com', 'Active', '09704525110', '2025-03-30', 0, 36),
(7, 0, NULL, 1, 'MYRA', 'PADALAPAT', 'OLAYBAR', '', '121649100034@r8.deped.gov.ph', 'Active', '09208839244', '2025-03-30', 0, 37),
(8, 0, NULL, 1, 'Marco', 'Dichon', 'Galagar', '', 'marcopain99@gmail.com', 'Active', '09471415988', '2025-03-30', 0, 38),
(9, 0, NULL, 1, 'Cherry Anne', 'Erlandez', 'Zagado', '', 'cherryanneerlandez96@gmail.com', 'Active', '09269797129', '2025-03-30', 0, 39),
(10, 0, NULL, 1, 'Vicente', 'Costado', 'Tahil', 'Jr', 'vicentecostadojr@gmail.com', 'Active', '09368248415', '2025-03-30', 0, 40),
(11, 0, NULL, 2, 'Daniel', 'Dela Torre', 'Estremos', '', 'delatorredaniel2006@gmail.com', 'Active', '09935927942', '2025-03-30', 0, 41),
(12, 0, NULL, 2, 'Jay Anthony', 'De Villena', 'Almosa', '', 'godsanthony15@gmail.com', 'Active', '09563796024', '2025-03-30', 0, 42),
(13, 0, NULL, 2, 'Shallei Elizabeth', 'Laping', 'Sanico', '', 'shalleielizabethlaping06@gmail', 'Active', '09938790415', '2025-03-30', 0, 43),
(14, 0, NULL, 2, 'Reymark', 'Fernandez', 'Caputol', '', 'reymarkfernandez71@gmail.com', 'Active', '09480266342', '2025-03-30', 0, 44),
(15, 0, NULL, 2, 'Joshua', 'Diniega', 'Rubillos', '', 'jdiniega202@gmail.com', 'Active', '09208883990', '2025-03-30', 0, 45),
(16, 0, NULL, 2, 'Roniljess', 'Matugas', 'Ereve', '', 'roniljessmatugas@gmail.com', 'Active', '09704525110', '2025-03-30', 0, 46),
(17, 0, NULL, 2, 'MYRA', 'PADALAPAT', 'OLAYBAR', '', '121649100034@r8.deped.gov.ph', 'Active', '09208839244', '2025-03-30', 0, 47),
(18, 0, NULL, 2, 'Marco', 'Dichon', 'Galagar', '', 'marcopain99@gmail.com', 'Active', '09471415988', '2025-03-30', 0, 48),
(19, 0, NULL, 2, 'Cherry Anne', 'Erlandez', 'Zagado', '', 'cherryanneerlandez96@gmail.com', 'Active', '09269797129', '2025-03-30', 0, 49),
(20, 0, NULL, 2, 'Vicente', 'Costado', 'Tahil', 'Jr', 'vicentecostadojr@gmail.com', 'Active', '09368248415', '2025-03-30', 0, 50),
(21, 0, NULL, 1, 'Jonh', 'Doe', 'Son', 'Sr.', 'jaskalas@gmail.com', 'Active', '091234', '2015-04-04', 23, 24),
(22, 1, NULL, 1, 'Jonh', 'Doe', 'Son', 'Sr.', 'jaskalas@gmail.com', 'Active', '091234', '2015-04-04', 23, 24),
(23, 0, NULL, 1, 'MYRA', 'PADALAPAT', 'OLAYBAR', '', '121649100034@r8.deped.gov.ph', 'Active', '09208839244', '2025-03-30', 0, 47);

--
-- Triggers `student`
--
DELIMITER $$
CREATE TRIGGER `student_before_insert` BEFORE INSERT ON `student` FOR EACH ROW BEGIN
  IF NEW.deleted = 1 THEN
    SET NEW.deleted_at = CURRENT_TIMESTAMP;
  END IF;
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `student_before_update` BEFORE UPDATE ON `student` FOR EACH ROW BEGIN
  -- change this IF to OLD.deleted = 0 AND NEW.deleted = 1
  -- if you only want to record when it goes from 0→1
  IF NEW.deleted <> OLD.deleted THEN
    SET NEW.deleted_at = CURRENT_TIMESTAMP;
  END IF;
END
$$
DELIMITER ;

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
(1, 18);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `address`
--
ALTER TABLE `address`
  ADD PRIMARY KEY (`addressID`),
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
-- Indexes for table `settings_attendance`
--
ALTER TABLE `settings_attendance`
  ADD UNIQUE KEY `settingsID` (`settingsID`);

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
-- AUTO_INCREMENT for table `address`
--
ALTER TABLE `address`
  MODIFY `addressID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT for table `attendance_log`
--
ALTER TABLE `attendance_log`
  MODIFY `logID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=66;

--
-- AUTO_INCREMENT for table `attendance_record`
--
ALTER TABLE `attendance_record`
  MODIFY `recordID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=123;

--
-- AUTO_INCREMENT for table `cluster`
--
ALTER TABLE `cluster`
  MODIFY `clusterID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=51;

--
-- AUTO_INCREMENT for table `guardian`
--
ALTER TABLE `guardian`
  MODIFY `guardianID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT for table `school_year`
--
ALTER TABLE `school_year`
  MODIFY `yearID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
  MODIFY `StudentID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

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
  ADD CONSTRAINT `student_ibfk_1` FOREIGN KEY (`ClusterID`) REFERENCES `cluster` (`clusterID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `student_ibfk_2` FOREIGN KEY (`yearID`) REFERENCES `school_year` (`yearID`);

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
