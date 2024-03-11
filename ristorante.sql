-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Mar 11, 2024 alle 17:21
-- Versione del server: 10.4.32-MariaDB
-- Versione PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ristorante`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `admin`
--

CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `admin`
--

INSERT INTO `admin` (`id`, `username`, `password`) VALUES
(1, 'admin', 'admin');

-- --------------------------------------------------------

--
-- Struttura della tabella `ordine`
--

CREATE TABLE `ordine` (
  `id` int(11) NOT NULL,
  `data_ora_ordine` datetime NOT NULL,
  `data_ora_ritiro` datetime NOT NULL,
  `importo` double NOT NULL,
  `id_utente` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `ordine_piatto`
--

CREATE TABLE `ordine_piatto` (
  `id_piatto` int(11) NOT NULL,
  `id_ordine` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `piatto`
--

CREATE TABLE `piatto` (
  `id` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `prezzo` double NOT NULL,
  `descrizione` varchar(255) NOT NULL,
  `categoria` varchar(50) NOT NULL,
  `copertina` longtext DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `piatto`
--

INSERT INTO `piatto` (`id`, `nome`, `prezzo`, `descrizione`, `categoria`, `copertina`) VALUES
(1, 'Bruschetta', 7.99, 'Pane tostato con pomodoro fresco, aglio, basilico e olio d\'oliva', 'antipasti', NULL),
(2, 'Caprese', 9.99, 'Mozzarella di bufala con pomodoro fresco, basilico e olio d\'oliva', 'antipasti', NULL),
(3, 'Calamari fritti', 12.99, 'Calamari freschi fritti e serviti con salsa cocktail', 'antipasti', NULL),
(4, 'Spaghetti alla carbonara', 11.99, 'Spaghetti con uovo, pancetta, pecorino e pepe nero', 'primi', NULL),
(5, 'Risotto ai funghi', 13.99, 'Risotto cremoso con funghi porcini freschi e parmigiano', 'primi', NULL),
(6, 'Lasagne al forno', 14.99, 'Lasagne fatte in casa con ragù di carne e besciamella', 'primi', NULL),
(7, 'Bistecca alla fiorentina', 25.99, 'Bistecca di manzo alla griglia servita con contorno di patate arrosto', 'secondi', NULL),
(8, 'Filetto di salmone', 18.99, 'Filetto di salmone fresco alla griglia con salsa al limone', 'secondi', NULL),
(9, 'Pollo al curry', 16.99, 'Pollo marinato cotto lentamente in salsa di curry con riso basmati', 'secondi', NULL),
(10, 'Tiramisù', 8.99, 'Dolce italiano fatto con savoiardi, caffè, mascarpone e cacao', 'dolci', NULL),
(11, 'Panna cotta', 7.99, 'Dolce italiano cremoso servito con salsa alla frutta', 'dolci', NULL),
(12, 'Gelato misto', 6.99, 'Selezione di gelati artigianali con gusti assortiti', 'dolci', NULL),
(13, 'Acqua naturale', 2.99, 'Acqua minerale naturale in bottiglia', 'bevande', NULL),
(14, 'Vino rosso Chianti', 15.99, 'Vino rosso toscano proveniente dalla regione del Chianti', 'bevande', NULL),
(15, 'Caffè espresso', 1.99, 'Caffè espresso italiano appena preparato', 'bevande', NULL);

-- --------------------------------------------------------

--
-- Struttura della tabella `utente`
--

CREATE TABLE `utente` (
  `id` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `cognome` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `immagine` longtext DEFAULT NULL,
  `numero_carta` varchar(16) DEFAULT NULL,
  `data_di_nascita` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `utente`
--

INSERT INTO `utente` (`id`, `nome`, `cognome`, `username`, `password`, `immagine`, `numero_carta`, `data_di_nascita`) VALUES
(1, 'Mario', 'Rossi', 'user1', 'Pass1!', NULL, '1234567890123456', '1990-05-15'),
(2, 'Giulia', 'Bianchi', 'user2', 'Pass1!', NULL, '9876543210987654', '1985-09-21'),
(3, 'Luca', 'Verdi', 'user3', 'Pass1!', NULL, '4567890123456789', '1988-12-03');

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `ordine`
--
ALTER TABLE `ordine`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_id_utente` (`id_utente`);

--
-- Indici per le tabelle `ordine_piatto`
--
ALTER TABLE `ordine_piatto`
  ADD KEY `fk_id_piatto` (`id_piatto`),
  ADD KEY `fk_id_ordine` (`id_ordine`);

--
-- Indici per le tabelle `piatto`
--
ALTER TABLE `piatto`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `utente`
--
ALTER TABLE `utente`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT per la tabella `ordine`
--
ALTER TABLE `ordine`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la tabella `piatto`
--
ALTER TABLE `piatto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT per la tabella `utente`
--
ALTER TABLE `utente`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `ordine`
--
ALTER TABLE `ordine`
  ADD CONSTRAINT `fk_id_utente` FOREIGN KEY (`id_utente`) REFERENCES `utente` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limiti per la tabella `ordine_piatto`
--
ALTER TABLE `ordine_piatto`
  ADD CONSTRAINT `fk_id_ordine` FOREIGN KEY (`id_ordine`) REFERENCES `ordine` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_id_piatto` FOREIGN KEY (`id_piatto`) REFERENCES `piatto` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
