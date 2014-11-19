-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Nov 19, 2014 at 02:36 AM
-- Server version: 5.6.20
-- PHP Version: 5.5.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `hotelmanagement`
--

-- --------------------------------------------------------

--
-- Table structure for table `paymententity`
--

CREATE TABLE IF NOT EXISTS `paymententity` (
  `ID` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `registerentity`
--

CREATE TABLE IF NOT EXISTS `registerentity` (
`id` bigint(20) NOT NULL,
  `age` varchar(255) DEFAULT NULL,
  `contactNumber` varchar(255) DEFAULT NULL,
  `emailAddress` varchar(255) DEFAULT NULL,
  `firstName` varchar(255) DEFAULT NULL,
  `homeAddress` varchar(255) DEFAULT NULL,
  `lastName` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `zip` varchar(255) DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `registerentity`
--

INSERT INTO `registerentity` (`id`, `age`, `contactNumber`, `emailAddress`, `firstName`, `homeAddress`, `lastName`, `password`, `state`, `zip`) VALUES
(1, '12', '1233', 'a@com', 'sdf', 'zxc', 'sdf', '123', 'zxc', 'zxc');

-- --------------------------------------------------------

--
-- Table structure for table `reservationentity`
--

CREATE TABLE IF NOT EXISTS `reservationentity` (
  `ID` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `roommanagement`
--

CREATE TABLE IF NOT EXISTS `roommanagement` (
  `ID` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `roommanagemententity`
--

CREATE TABLE IF NOT EXISTS `roommanagemententity` (
  `ID` bigint(20) NOT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `PRICE` bigint(20) DEFAULT NULL,
  `ROOMNUMBER` varchar(255) DEFAULT NULL,
  `STATUS` tinyint(1) DEFAULT '0',
  `TYPEROOM` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `sequence`
--

CREATE TABLE IF NOT EXISTS `sequence` (
  `SEQ_NAME` varchar(50) NOT NULL,
  `SEQ_COUNT` decimal(38,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sequence`
--

INSERT INTO `sequence` (`SEQ_NAME`, `SEQ_COUNT`) VALUES
('SEQ_GEN', '0');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `paymententity`
--
ALTER TABLE `paymententity`
 ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `registerentity`
--
ALTER TABLE `registerentity`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `reservationentity`
--
ALTER TABLE `reservationentity`
 ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `roommanagement`
--
ALTER TABLE `roommanagement`
 ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `roommanagemententity`
--
ALTER TABLE `roommanagemententity`
 ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `sequence`
--
ALTER TABLE `sequence`
 ADD PRIMARY KEY (`SEQ_NAME`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `registerentity`
--
ALTER TABLE `registerentity`
MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
