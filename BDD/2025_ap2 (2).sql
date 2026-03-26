-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : jeu. 26 mars 2026 à 15:40
-- Version du serveur : 10.4.27-MariaDB
-- Version de PHP : 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `2025_ap2`
--

-- --------------------------------------------------------

--
-- Structure de la table `adherent`
--

CREATE TABLE `adherent` (
  `num` varchar(20) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Déchargement des données de la table `adherent`
--

INSERT INTO `adherent` (`num`, `nom`, `prenom`, `email`) VALUES
('A001', 'Dupont', 'Lucas', 'lucas.dupont@gmail.com'),
('A002', 'Martin', 'Emma', 'emma.martin@gmail.com'),
('A003', 'Bernard', 'Hugo', 'hugo.bernard@gmail.com'),
('A004', 'Dubois', 'Chloé', 'chloe.dubois@gmail.com'),
('A005', 'Thomas', 'Léa', 'lea.thomas@gmail.com'),
('A006', 'Robert', 'Nathan', 'nathan.robert@gmail.com');

-- --------------------------------------------------------

--
-- Structure de la table `auteur`
--

CREATE TABLE `auteur` (
  `num` varchar(20) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `date_naissance` date DEFAULT NULL,
  `description` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Déchargement des données de la table `auteur`
--

INSERT INTO `auteur` (`num`, `nom`, `prenom`, `date_naissance`, `description`) VALUES
('AU001', 'Rowling', 'J.K.', '1965-07-31', 'Autrice de Harry Potter.'),
('AU002', 'Tolkien', 'J.R.R.', '1892-01-03', 'Auteur du Seigneur des Anneaux.'),
('AU003', 'Orwell', 'George', '1903-06-25', 'Auteur de 1984.'),
('AU004', 'Saint-Exupéry', 'Antoine de', '1900-06-29', 'Auteur du Petit Prince.'),
('AU005', 'Brown', 'Dan', '1964-06-22', 'Auteur de thrillers.'),
('AU006', 'Martin', 'George R.R.', '1948-09-20', 'Auteur de Game of Thrones.'),
('AU007', 'Hugo', 'Victor', '1802-02-26', 'Écrivain français majeur.'),
('AU008', 'Camus', 'Albert', '1913-11-07', 'Philosophe et écrivain.'),
('AU009', 'Zola', 'Émile', '1840-04-02', 'Naturalisme.'),
('AU010', 'Verne', 'Jules', '1828-02-08', 'Science-fiction.'),
('AU011', 'King', 'Stephen', '1947-09-21', 'Horreur moderne.');

-- --------------------------------------------------------

--
-- Structure de la table `livre`
--

CREATE TABLE `livre` (
  `ISBN` varchar(20) NOT NULL,
  `titre` varchar(50) NOT NULL,
  `prix` float NOT NULL,
  `adherent` varchar(20) DEFAULT NULL,
  `auteur` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Déchargement des données de la table `livre`
--

INSERT INTO `livre` (`ISBN`, `titre`, `prix`, `adherent`, `auteur`) VALUES
('9780140449136', 'Crime et Châtiment', 18.5, 'A004', 'AU007'),
('9780140449266', 'Les Frères Karamazov', 19, NULL, 'AU007'),
('9780141036144', '1984 (EN)', 13, 'A003', 'AU003'),
('9780141439600', 'Orgueil et Préjugés', 12.5, 'A005', 'AU007'),
('9780261102361', 'Le Hobbit', 18, 'A003', 'AU002'),
('9780261102385', 'Le Silmarillion', 19.5, NULL, 'AU002'),
('9780261103573', 'Le Seigneur des Anneaux', 25, 'A002', 'AU002'),
('9780307474278', 'Da Vinci Code', 18, 'A006', 'AU005'),
('9780307588371', 'Inferno', 19, 'A004', 'AU005'),
('9780307743657', 'Ça', 24, 'A002', 'AU011'),
('9780439064873', 'Harry Potter and the Chamber of Secrets (EN)', 21, 'A002', 'AU001'),
('9780450417399', 'Carrie', 14, 'A003', 'AU011'),
('9780451524935', '1984', 15, 'A001', 'AU003'),
('9780451526342', 'La Ferme des animaux', 12, NULL, 'AU003'),
('9780553103540', 'Game of Thrones', 22, 'A001', 'AU006'),
('9780553108033', 'A Clash of Kings', 23, 'A002', 'AU006'),
('9780553573404', 'A Storm of Swords', 24, NULL, 'AU006'),
('9780553579901', 'A Feast for Crows', 23.5, NULL, 'AU006'),
('9780747532699', 'Harry Potter à l\'école des sorciers', 20.5, 'A001', 'AU001'),
('9780747538493', 'Harry Potter et la Chambre des secrets', 21, 'A002', 'AU001'),
('9780747542155', 'Harry Potter et le Prisonnier d\'Azkaban', 21.5, 'A003', 'AU001'),
('9780747546245', 'Harry Potter et la Coupe de feu', 22, NULL, 'AU001'),
('9780747551003', 'Harry Potter et l\'Ordre du Phénix', 23, 'A004', 'AU001'),
('9781501142970', 'Shining', 21, NULL, 'AU011'),
('9781501175466', 'Doctor Sleep', 22, NULL, 'AU011'),
('9781501180989', 'The Outsider', 23, 'A004', 'AU011'),
('9782070360022', 'L\'Étranger', 14, 'A004', 'AU008'),
('9782070360534', 'Noces', 11, NULL, 'AU008'),
('9782070380914', 'La Peste', 15, NULL, 'AU008'),
('9782070409189', 'Les Misérables', 19, NULL, 'AU007'),
('9782070413117', 'Notre-Dame de Paris', 18, 'A003', 'AU007'),
('9782070451782', 'La Chute', 13.5, 'A006', 'AU008'),
('9782070612758', 'Le Petit Prince', 10, 'A005', 'AU004'),
('9782253004226', 'Germinal', 17, 'A005', 'AU009'),
('9782253004233', 'L\'Assommoir', 16, NULL, 'AU009'),
('9782253006329', 'Vingt mille lieues sous les mers', 16, 'A006', 'AU010'),
('9782253006336', 'Le Tour du monde en 80 jours', 15, 'A001', 'AU010'),
('9782253006343', 'Voyage au centre de la Terre', 15.5, NULL, 'AU010'),
('9782253010692', 'Thérèse Raquin', 14.5, 'A001', 'AU009'),
('9782253010708', 'Nana', 16.5, 'A002', 'AU009'),
('9782265097493', 'Anges et Démons', 17.5, NULL, 'AU005'),
('9782265097509', 'Le Symbole perdu', 18, 'A005', 'AU005');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `adherent`
--
ALTER TABLE `adherent`
  ADD PRIMARY KEY (`num`),
  ADD UNIQUE KEY `uq_adherent_email` (`email`);

--
-- Index pour la table `auteur`
--
ALTER TABLE `auteur`
  ADD PRIMARY KEY (`num`);

--
-- Index pour la table `livre`
--
ALTER TABLE `livre`
  ADD PRIMARY KEY (`ISBN`),
  ADD KEY `fk_livre_auteur` (`auteur`),
  ADD KEY `fk_livre_adherent` (`adherent`);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `livre`
--
ALTER TABLE `livre`
  ADD CONSTRAINT `fk_livre_adherent` FOREIGN KEY (`adherent`) REFERENCES `adherent` (`num`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_livre_auteur` FOREIGN KEY (`auteur`) REFERENCES `auteur` (`num`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
