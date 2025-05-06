-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 29, 2025 at 09:46 AM
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
  `zipCode` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

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

-- --------------------------------------------------------

--
-- Table structure for table `cluster`
--

CREATE TABLE `cluster` (
  `clusterID` int(11) NOT NULL,
  `clusterName` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

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

-- --------------------------------------------------------

--
-- Table structure for table `school_year`
--

CREATE TABLE `school_year` (
  `yearID` int(11) NOT NULL AUTO_INCREMENT,
  `year_start` int(11) NOT NULL,
  `year_end` int(11) NOT NULL,
  `month_start` varchar(10) NOT NULL,
  `monthEnd` varchar(10) NOT NULL,
  `day_start` int(11) NOT NULL,
  `day_end` int(11) NOT NULL,
  PRIMARY KEY (`yearID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `settings_attendance`
--

CREATE TABLE `settings_attendance` (
  `settingsID` varchar(50) NOT NULL,
  `start` int(2) NOT NULL,
  `end` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `StudentID` int(11) NOT NULL,
  `deleted` int(1) NOT NULL,
  `deleted_at` varchar(50) DEFAULT NULL,
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

-- --------------------------------------------------------

--
-- Table structure for table `student_guardian`
--

CREATE TABLE `student_guardian` (
  `studentID` int(11) NOT NULL,
  `guardianID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexes for dumped tables
--

ALTER TABLE `address`
  ADD KEY `Student_ID` (`studentID`);

ALTER TABLE `attendance_log`
  ADD PRIMARY KEY (`logID`),
  ADD KEY `Log_ID` (`recordID`),
  ADD KEY `Student_ID` (`student_id`);

ALTER TABLE `attendance_record`
  ADD PRIMARY KEY (`recordID`);

ALTER TABLE `cluster`
  ADD PRIMARY KEY (`clusterID`);

ALTER TABLE `db_changes_log`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `guardian`
  ADD PRIMARY KEY (`guardianID`);

ALTER TABLE `student`
  ADD PRIMARY KEY (`StudentID`),
  ADD KEY `ClusterID` (`ClusterID`),
  ADD KEY `yearID` (`yearID`);

ALTER TABLE `student_guardian`
  ADD KEY `Student_ID` (`studentID`),
  ADD KEY `Guardian_ID` (`guardianID`);

--
-- AUTO_INCREMENT for table `db_changes_log`
--
ALTER TABLE `db_changes_log`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

ALTER TABLE `address`
  ADD CONSTRAINT `address_ibfk_1` FOREIGN KEY (`studentID`) REFERENCES `student` (`StudentID`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `attendance_log`
  ADD CONSTRAINT `attendance_log_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `student` (`StudentID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `attendance_log_ibfk_2` FOREIGN KEY (`recordID`) REFERENCES `attendance_record` (`recordID`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `student`
  ADD CONSTRAINT `student_ibfk_1` FOREIGN KEY (`ClusterID`) REFERENCES `cluster` (`clusterID`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `student_guardian`
  ADD CONSTRAINT `student_guardian_ibfk_1` FOREIGN KEY (`studentID`) REFERENCES `student` (`StudentID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `student_guardian_ibfk_2` FOREIGN KEY (`guardianID`) REFERENCES `guardian` (`guardianID`) ON DELETE CASCADE ON UPDATE CASCADE;

COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
