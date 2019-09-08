-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Sep 06, 2019 at 03:35 PM
-- Server version: 10.4.6-MariaDB
-- PHP Version: 7.1.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `userportal`
--

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `version` bigint(20) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `is_active` bit(1) NOT NULL,
  `date_created` datetime NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `age` int(11) DEFAULT NULL,
  `last_updated` datetime NOT NULL,
  `password` varchar(255) NOT NULL,
  `user_type` varchar(255) NOT NULL,
  `birth_date` datetime NOT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `phone_number` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `version`, `address`, `is_active`, `date_created`, `first_name`, `age`, `last_updated`, `password`, `user_type`, `birth_date`, `last_name`, `email`, `phone_number`) VALUES
(1, 0, 'Middle Badda Sha-6', b'1', '2019-09-06 19:13:35', 'Abdur', 26, '2019-09-06 19:13:35', '202cb962ac59075b964b07152d234b70', 'USER', '1993-09-06 00:00:00', 'Razzak', 'abdur.razzaq06@gmail.com', '17267033295'),
(2, 0, 'Middle Badda Sha-6', b'1', '2019-09-06 19:15:45', 'Abdus', 0, '2019-09-06 19:15:45', '202cb962ac59075b964b07152d234b70', 'USER', '2019-09-06 00:00:00', 'Samad', 'razzaq@gmail.com', '01726703329'),
(3, 0, 'Jalal road', b'1', '2019-09-06 19:16:39', 'Abul', 32, '2019-09-06 19:16:39', '202cb962ac59075b964b07152d234b70', 'USER', '1987-09-06 00:00:00', 'Kashem', 'abul@yahoo.com', '01838373738'),
(4, 0, 'America', b'1', '2019-09-06 19:17:16', 'Jon', 50, '2019-09-06 19:17:16', '202cb962ac59075b964b07152d234b70', 'USER', '1969-09-06 00:00:00', 'Lenon', 'jon@gmail.com', '02838383202'),
(5, 0, 'Bijoy shorony road', b'1', '2019-09-06 19:18:39', 'System', 63, '2019-09-06 19:18:39', '21232f297a57a5a743894a0e4a801fc3', 'ADMIN', '1956-09-06 00:00:00', 'Admin', 'admin@localhost.com', '01983383838'),
(6, 0, 'New York', b'1', '2019-09-06 19:19:47', 'Groovy', 26, '2019-09-06 19:19:47', 'caf1a3dfb505ffed0d024130f58c5cfa', 'USER', '1993-09-06 00:00:00', 'Grails', 'grails@yahoo.com', '02381363739'),
(7, 0, 'Link road', b'1', '2019-09-06 19:22:23', 'Normal', 22, '2019-09-06 19:22:23', 'e2fc714c4727ee9395f324cd2e7f331f', 'USER', '1997-09-06 00:00:00', 'User', 'user@hotmail.com', '01893837373'),
(8, 0, 'Boishakhy shorony', b'1', '2019-09-06 19:23:06', 'Mainul', 31, '2019-09-06 19:23:06', '827ccb0eea8a706c4c34a16891f84e7b', 'USER', '1988-09-06 00:00:00', 'Kabir', 'kabir@live.com', '01918373783'),
(9, 0, 'South Badd', b'1', '2019-09-06 19:24:13', 'Sultan', 32, '2019-09-06 19:24:13', '9af82031d374b97c9e73132a413cbdf5', 'USER', '1987-09-06 00:00:00', 'Mahmud', 'sultan@gmail.com', '01838474636'),
(10, 0, 'Farmgate dhaka', b'1', '2019-09-06 19:24:57', 'Abid', 34, '2019-09-06 19:24:57', '202cb962ac59075b964b07152d234b70', 'USER', '1985-03-03 00:00:00', 'Hasan', 'abid@yahoo.com', '01833737392'),
(11, 0, 'Shanti nogor', b'1', '2019-09-06 19:25:56', 'Opu', 24, '2019-09-06 19:25:56', '5985c96ec14b608ad0861b44d6fa93af', 'USER', '1994-12-16 00:00:00', 'Mia', 'opu@hotmail.com', '01846636992'),
(12, 0, 'Kollan pur', b'1', '2019-09-06 19:27:03', 'Istyiak', 31, '2019-09-06 19:27:03', 'c3d3c17b4ca7f791f85e1cc72f274af4', 'USER', '1988-04-04 00:00:00', 'Shuvro', 'shuvro@gmail.com', '0173937364543'),
(13, 0, 'Kollanpur bazar road', b'1', '2019-09-06 19:27:45', 'Munna', 27, '2019-09-06 19:27:45', 'cf72c35762cb653212e7edebf8bd53d8', 'USER', '1992-02-09 00:00:00', 'Mia', 'munna@gmail.com', '0173635373922');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_ob8kqyqqgmefl0aco34akdtpe` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
