-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 24 Cze 2024, 09:27
-- Wersja serwera: 10.4.25-MariaDB
-- Wersja PHP: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `biblioteka`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `ksiazki`
--

CREATE TABLE `ksiazki` (
  `book_ID` int(11) NOT NULL,
  `book_author` varchar(255) NOT NULL,
  `book_name` varchar(255) NOT NULL,
  `book_ammount` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `ksiazki`
--

INSERT INTO `ksiazki` (`book_ID`, `book_author`, `book_name`, `book_ammount`) VALUES
(1, 'Adam Mickiewicz', 'Ogniem i Mieczem', 5),
(2, 'Adam Mickiewicz', 'Pan Tadeusz', 23),
(3, 'Henryk Sienkiewicz', 'W Pustyni i w Puszczy', 3),
(4, 'Antoine de Saint-Exupéry\r\n', 'Mały Książe', 1),
(5, 'Fiodor Dostojewski', 'Zbrodnia i Kara', 6),
(6, 'Weronika Ancerowicz', 'For Sure Not You', 1),
(7, 'Zofia Nałkowska', 'Medaliony', 5),
(8, 'Aleksandra Negrońska', 'Clone', 3),
(9, 'Aleksander Kamiński', 'Kamienie na szaniec', 5),
(10, 'Stefan Żeromski ', 'Syzyfowe Prace', 7),
(11, 'Aleksander Fredro ', 'Zemsta', 5),
(12, 'Juliusz Słowacki', 'Balladyna', 3),
(13, 'Grabowski SławomirNejman Marek', 'przygody kota filemona', 6);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `user`
--

CREATE TABLE `user` (
  `ID` int(11) NOT NULL,
  `imie` varchar(40) NOT NULL,
  `nazwisko` varchar(40) NOT NULL,
  `mail` varchar(100) NOT NULL,
  `haslo` varchar(2555) NOT NULL,
  `user_type` varchar(20) NOT NULL DEFAULT 'użytkownik'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `user`
--

INSERT INTO `user` (`ID`, `imie`, `nazwisko`, `mail`, `haslo`, `user_type`) VALUES
(1, 'Natan', 'Czernicki', 'natan.czernicki@gmail.com', 'admin123', 'admin'),
(2, 'imie', 'nazwisko', 'imie.nazwisko@mail.com', '123', 'użytkownik'),
(5, 'Asia', 'Biernacka', 'asia.biernacka257@gmail.com', 'Biernacka#', 'użytkownik'),
(6, 'admin', 'admin', 'admin', '123', 'admin');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `wyporzyczenia`
--

CREATE TABLE `wyporzyczenia` (
  `ID_wyp` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `book_id` int(11) NOT NULL,
  `data_wyp` date NOT NULL DEFAULT current_timestamp(),
  `data_zwrotu` date NOT NULL,
  `naleznosc` decimal(10,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `wyporzyczenia`
--

INSERT INTO `wyporzyczenia` (`ID_wyp`, `user_id`, `book_id`, `data_wyp`, `data_zwrotu`, `naleznosc`) VALUES
(1, 1, 11, '2024-06-17', '2024-07-15', '0'),
(2, 1, 12, '2024-06-17', '2024-07-15', '0'),
(4, 1, 7, '2024-06-17', '2024-07-15', '0'),
(12, 1, 11, '2024-06-18', '2024-07-16', '0'),
(14, 5, 9, '2024-06-18', '2024-07-16', '0'),
(17, 5, 2, '2024-06-18', '2024-07-16', '0'),
(19, 5, 4, '2024-06-20', '2024-07-18', '0'),
(20, 5, 10, '2024-06-20', '2024-07-18', '0'),
(21, 5, 13, '2024-06-20', '2024-07-18', '0'),
(22, 6, 4, '2024-06-22', '2024-07-20', '0'),
(23, 6, 6, '2024-06-22', '2024-07-20', '0'),
(24, 6, 9, '2024-06-22', '2024-07-20', '0'),
(25, 6, 12, '2024-06-22', '2024-07-20', '0'),
(27, 5, 10, '2024-06-23', '2024-07-21', '0');

--
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `ksiazki`
--
ALTER TABLE `ksiazki`
  ADD PRIMARY KEY (`book_ID`);

--
-- Indeksy dla tabeli `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`ID`);

--
-- Indeksy dla tabeli `wyporzyczenia`
--
ALTER TABLE `wyporzyczenia`
  ADD PRIMARY KEY (`ID_wyp`);

--
-- AUTO_INCREMENT dla zrzuconych tabel
--

--
-- AUTO_INCREMENT dla tabeli `ksiazki`
--
ALTER TABLE `ksiazki`
  MODIFY `book_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT dla tabeli `user`
--
ALTER TABLE `user`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT dla tabeli `wyporzyczenia`
--
ALTER TABLE `wyporzyczenia`
  MODIFY `ID_wyp` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
