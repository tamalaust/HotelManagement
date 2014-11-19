-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Nov 19, 2014 at 11:25 AM
-- Server version: 5.5.39
-- PHP Version: 5.4.31

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
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `roommanagemententity`
--

CREATE TABLE IF NOT EXISTS `roommanagemententity` (
`id` bigint(20) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `price` bigint(20) DEFAULT NULL,
  `roomNumber` varchar(255) DEFAULT NULL,
  `status` bit(1) NOT NULL,
  `typeRoom` varchar(255) DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=11 ;

--
-- Dumping data for table `roommanagemententity`
--

INSERT INTO `roommanagemententity` (`id`, `description`, `price`, `roomNumber`, `status`, `typeRoom`) VALUES
(2, 'Its very good', 1000, '101', b'1', 'Luxury'),
(3, 'South faces', 1500, '102', b'1', 'Luxury'),
(4, 'Great view', 1500, '103', b'1', 'Luxury'),
(5, 'Nice', 800, '301', b'1', 'Deluxe'),
(6, 'Suitable for family', 800, '302', b'1', 'Deluxe'),
(7, 'Great for honymoon', 800, '303', b'1', 'Deluxe'),
(8, 'Great value', 500, '401', b'1', 'Economy'),
(9, 'Great value', 500, '402', b'1', 'Economy'),
(10, 'Great value', 500, '403', b'1', 'Economy');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `registerentity`
--
ALTER TABLE `registerentity`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `roommanagemententity`
--
ALTER TABLE `roommanagemententity`
 ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `registerentity`
--
ALTER TABLE `registerentity`
MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `roommanagemententity`
--
ALTER TABLE `roommanagemententity`
MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=11;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
