-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 09, 2017 at 11:46 PM
-- Server version: 5.7.14
-- PHP Version: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ps_tuzilastvo`
--

-- --------------------------------------------------------

--
-- Table structure for table `korisnik`
--

CREATE TABLE `korisnik` (
  `korisnikID` int(10) NOT NULL,
  `korisnickoIme` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `sifra` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `korisnik`
--

INSERT INTO `korisnik` (`korisnikID`, `korisnickoIme`, `sifra`) VALUES
(1, 'sale', '12345'),
(2, 'djole', '12345'),
(3, 'a', 'a');

-- --------------------------------------------------------

--
-- Table structure for table `mesto`
--

CREATE TABLE `mesto` (
  `mestoID` int(10) NOT NULL,
  `naziv` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ptt` int(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `mesto`
--

INSERT INTO `mesto` (`mestoID`, `naziv`, `ptt`) VALUES
(1, 'Beograd', 11000),
(3, 'Jagodina', 35000),
(6, 'Kragujevac', 34000),
(7, 'Cacak', 32000),
(8, 'Zajecar', 19000),
(9, 'Leskovac', 16000),
(10, 'Vranje', 17500),
(11, 'Novi Sad', 21000);

-- --------------------------------------------------------

--
-- Table structure for table `osumnjiceni`
--

CREATE TABLE `osumnjiceni` (
  `osumnjiceniID` int(10) NOT NULL,
  `imePrezime` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `JMBG` varchar(13) COLLATE utf8_unicode_ci DEFAULT NULL,
  `datumRodjenja` date DEFAULT NULL,
  `adresa` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `zanimanje` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `osudjivanost` tinyint(1) DEFAULT '0',
  `mestoID` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `osumnjiceni`
--

INSERT INTO `osumnjiceni` (`osumnjiceniID`, `imePrezime`, `JMBG`, `datumRodjenja`, `adresa`, `zanimanje`, `osudjivanost`, `mestoID`) VALUES
(1, 'Milos Markovic', '0311956854548', '1956-11-03', 'Vojvode Vlahovica 34', 'poljoprivrednik', 0, 3),
(3, 'Dragan Ikonic', '2907964954456', '1964-07-29', 'Nikole Pasica 23', 'student', 1, 9),
(5, 'Stevica Jelic', '2907976957426', '1976-07-29', 'Cara Dusana 23', 'komercijalista', 1, 3),
(6, 'Marko Otasevic', '2307994625321', '1994-07-23', 'Bulevar Kralja Aleksandra 354', 'programer', 1, 11),
(7, 'Ivana Jovicic', '0703993652125', '1993-03-07', 'Albanske Spomenice 64', 'kozmeticar', 0, 6),
(10, 'Aleksandar Randjelovic', '1706994525652', '1994-06-17', 'Milosa Obilica 21', 'programer', 0, 1);

-- --------------------------------------------------------

--
-- Table structure for table `predmet`
--

CREATE TABLE `predmet` (
  `predmetID` int(10) NOT NULL,
  `delo` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `opisDela` varchar(300) COLLATE utf8_unicode_ci DEFAULT NULL,
  `obrazlozenje` varchar(300) COLLATE utf8_unicode_ci DEFAULT NULL,
  `stanjePredmeta` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `tuzilacID` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `predmet`
--

INSERT INTO `predmet` (`predmetID`, `delo`, `opisDela`, `obrazlozenje`, `stanjePredmeta`, `tuzilacID`) VALUES
(1, 'Ubistvo', '17.12.2014. oko 16:10 sati mladic (24) hicima iz vatrenog oruzja usmrtio zensku osobu (60).', 'Mladic je zatekao zensku osobu u prevari sa drugim muskarcem.', 'u toku', 2),
(2, 'Razbojnistvo', 'Iz trafike u Cacku provalnici su odneli duvanske proizvode razlicitih proizvodjaca. Provala u trafiku, vlasnistvo Fabrike duvana Beograd, dogodila se 22.5.2017. u Ulici Karadjordjeva bb.', 'Pljackasi su nacinili fizicku stetu samoj trafici.', 'zavrsen', 4);

-- --------------------------------------------------------

--
-- Table structure for table `tuzilac`
--

CREATE TABLE `tuzilac` (
  `tuzilacID` int(10) NOT NULL,
  `imePrezime` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `dostupan` tinyint(1) DEFAULT '1',
  `radniStaz` int(10) DEFAULT NULL,
  `brojPredmeta` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `tuzilac`
--

INSERT INTO `tuzilac` (`tuzilacID`, `imePrezime`, `dostupan`, `radniStaz`, `brojPredmeta`) VALUES
(1, 'Dejan Veljkovic', 1, 10, 154),
(2, 'Dragan Kalabic', 0, 25, 320),
(3, 'Milos Djokic', 1, 12, 132),
(4, 'Dragan Ilic', 1, 5, 45);

-- --------------------------------------------------------

--
-- Table structure for table `vodjenje`
--

CREATE TABLE `vodjenje` (
  `vodjenjeID` int(10) NOT NULL,
  `predmetID` int(10) NOT NULL,
  `osumnjiceniID` int(10) NOT NULL,
  `datumOd` date DEFAULT NULL,
  `datumDo` date DEFAULT NULL,
  `opis` varchar(300) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `vodjenje`
--

INSERT INTO `vodjenje` (`vodjenjeID`, `predmetID`, `osumnjiceniID`, `datumOd`, `datumDo`, `opis`) VALUES
(2, 2, 6, '2017-07-03', '2017-07-12', 'dsaadsdasdas'),
(7, 1, 1, '2017-07-20', '2017-07-06', 'assadsadasdas'),
(8, 2, 6, '2017-07-06', '2017-07-19', 'sdfdfd');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `korisnik`
--
ALTER TABLE `korisnik`
  ADD PRIMARY KEY (`korisnikID`);

--
-- Indexes for table `mesto`
--
ALTER TABLE `mesto`
  ADD PRIMARY KEY (`mestoID`);

--
-- Indexes for table `osumnjiceni`
--
ALTER TABLE `osumnjiceni`
  ADD PRIMARY KEY (`osumnjiceniID`),
  ADD KEY `mestoID` (`mestoID`);

--
-- Indexes for table `predmet`
--
ALTER TABLE `predmet`
  ADD PRIMARY KEY (`predmetID`),
  ADD KEY `tuzilacID` (`tuzilacID`);

--
-- Indexes for table `tuzilac`
--
ALTER TABLE `tuzilac`
  ADD PRIMARY KEY (`tuzilacID`);

--
-- Indexes for table `vodjenje`
--
ALTER TABLE `vodjenje`
  ADD PRIMARY KEY (`vodjenjeID`,`predmetID`,`osumnjiceniID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `korisnik`
--
ALTER TABLE `korisnik`
  MODIFY `korisnikID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `mesto`
--
ALTER TABLE `mesto`
  MODIFY `mestoID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT for table `osumnjiceni`
--
ALTER TABLE `osumnjiceni`
  MODIFY `osumnjiceniID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `predmet`
--
ALTER TABLE `predmet`
  MODIFY `predmetID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `tuzilac`
--
ALTER TABLE `tuzilac`
  MODIFY `tuzilacID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `vodjenje`
--
ALTER TABLE `vodjenje`
  MODIFY `vodjenjeID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `osumnjiceni`
--
ALTER TABLE `osumnjiceni`
  ADD CONSTRAINT `FK_mesto` FOREIGN KEY (`mestoID`) REFERENCES `mesto` (`mestoID`);

--
-- Constraints for table `predmet`
--
ALTER TABLE `predmet`
  ADD CONSTRAINT `FK_tuzilac` FOREIGN KEY (`tuzilacID`) REFERENCES `tuzilac` (`tuzilacID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
