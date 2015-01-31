-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Apr 15, 2014 at 04:39 AM
-- Server version: 5.6.12-log
-- PHP Version: 5.4.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `pass`
--
CREATE DATABASE IF NOT EXISTS `pass` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `pass`;

-- --------------------------------------------------------

--
-- Table structure for table `passtb`
--

CREATE TABLE IF NOT EXISTS `passtb` (
  `pass_id` int(22) NOT NULL,
  `passphrase` varchar(250) NOT NULL,
  PRIMARY KEY (`pass_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `passtb`
--

INSERT INTO `passtb` (`pass_id`, `passphrase`) VALUES
(1010, 'GFxV3OQN9X1wCwNNKuugig==');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
