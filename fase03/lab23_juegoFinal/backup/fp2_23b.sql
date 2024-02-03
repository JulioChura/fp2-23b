-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 03-02-2024 a las 05:26:33
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `fp2_23b`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `jugadores`
--

CREATE TABLE `jugadores` (
  `id_jugador` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `racha_victorias` int(11) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `jugadores`
--

INSERT INTO `jugadores` (`id_jugador`, `password`, `racha_victorias`) VALUES
('a', '1', 0),
('b', '1', 0),
('julio', '123', 0),
('Lorena', '123', 0),
('Ruben', '123', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `partidas`
--

CREATE TABLE `partidas` (
  `id_partida` int(11) NOT NULL,
  `id_jugador1` varchar(255) DEFAULT NULL,
  `id_jugador2` varchar(255) DEFAULT NULL,
  `estado` int(11) DEFAULT NULL,
  `arena` varchar(255) DEFAULT NULL,
  `reino_1` varchar(255) NOT NULL,
  `reino_2` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `partidas`
--

INSERT INTO `partidas` (`id_partida`, `id_jugador1`, `id_jugador2`, `estado`, `arena`, `reino_1`, `reino_2`) VALUES
(1, NULL, NULL, 1, 'Montaña', '', ''),
(2, NULL, NULL, 1, 'Bosque', '', ''),
(3, NULL, NULL, 1, 'Bosque', '', ''),
(4, 'a', 'b', 1, 'Montaña', '', ''),
(5, 'a', 'b', 1, 'Montaña', 'Caballero4x9', 'Caballero10x8'),
(6, 'a', 'b', 1, 'Montaña', 'Caballero4x9', 'Caballero10x8'),
(7, 'a', 'b', 1, 'Montaña', 'fp2_23b', 'fp2_23b'),
(8, 'a', 'b', 1, 'Bosque', 'Castilla-Aragón', 'Moros'),
(9, 'Julio', 'Lorena', 1, 'Bosque', 'Castilla-Aragón', 'Francia');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `soldados`
--

CREATE TABLE `soldados` (
  `id_soldado` int(11) NOT NULL,
  `id_partida` int(11) DEFAULT NULL,
  `id_jugador` varchar(255) DEFAULT NULL,
  `fila` int(11) DEFAULT NULL,
  `columna` int(11) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `tipo` varchar(255) DEFAULT NULL,
  `ataque` int(11) DEFAULT NULL,
  `defensa` int(11) DEFAULT NULL,
  `vida` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `soldados`
--

INSERT INTO `soldados` (`id_soldado`, `id_partida`, `id_jugador`, `fila`, `columna`, `nombre`, `tipo`, `ataque`, `defensa`, `vida`) VALUES
(1, 3, NULL, 0, 0, 'Espad1x1', 'Espadachin', 10, 8, 8),
(2, 3, NULL, 2, 3, 'Caballero3x4', 'Caballero', 13, 7, 12),
(3, 3, NULL, 2, 6, 'Arquero3x7', 'Arquero', 7, 3, 6),
(4, 3, NULL, 2, 7, 'Caballero3x8', 'Caballero', 13, 7, 10),
(5, 3, NULL, 3, 0, 'Caballero4x1', 'Caballero', 13, 7, 11),
(6, 3, NULL, 8, 0, 'Lancero9x1', 'Spearman', 5, 10, 7),
(7, 3, NULL, 9, 0, 'Arquero10x1', 'Arquero', 7, 3, 6),
(8, 3, NULL, 9, 1, 'Lancero10x2', 'Spearman', 5, 10, 6),
(9, 3, NULL, 9, 6, 'Espad10x7', 'Espadachin', 10, 8, 9),
(10, 3, NULL, 5, 1, 'Espad6x2', 'Espadachin', 10, 8, 8),
(11, 4, 'a', 0, 5, 'Caballero1x6', 'Caballero', 13, 7, 12),
(12, 4, 'a', 1, 0, 'Arquero2x1', 'Arquero', 7, 3, 7),
(13, 4, 'a', 1, 6, 'Caballero2x7', 'Caballero', 13, 7, 12),
(14, 4, 'a', 1, 8, 'Arquero2x9', 'Arquero', 7, 3, 3),
(15, 4, 'a', 2, 5, 'Caballero3x6', 'Caballero', 13, 7, 11),
(16, 4, 'a', 9, 6, 'Lancero10x7', 'Spearman', 5, 10, 6),
(17, 4, 'a', 9, 7, 'Caballero10x8', 'Caballero', 13, 7, 11),
(18, 4, 'b', 0, 3, 'Arquero1x4', 'Arquero', 7, 3, 7),
(19, 4, 'b', 1, 9, 'Arquero2x10', 'Arquero', 7, 3, 4),
(20, 4, 'b', 2, 4, 'Arquero3x5', 'Arquero', 7, 3, 3),
(21, 4, 'b', 3, 6, 'Arquero4x7', 'Arquero', 7, 3, 5),
(22, 4, 'b', 3, 8, 'Caballero4x9', 'Caballero', 13, 7, 10),
(23, 5, 'a', 0, 3, 'fp2_23b', 'Arquero', 7, 3, 7),
(24, 5, 'a', 1, 9, 'fp2_23b', 'Arquero', 7, 3, 4),
(25, 5, 'a', 2, 4, 'fp2_23b', 'Arquero', 7, 3, 3),
(26, 5, 'a', 3, 6, 'fp2_23b', 'Arquero', 7, 3, 5),
(27, 5, 'a', 3, 8, 'fp2_23b', 'Caballero', 13, 7, 10),
(28, 5, 'b', 0, 5, 'fp2_23b', 'Caballero', 13, 7, 12),
(29, 5, 'b', 1, 0, 'fp2_23b', 'Arquero', 7, 3, 7),
(30, 5, 'b', 1, 6, 'fp2_23b', 'Caballero', 13, 7, 12),
(31, 5, 'b', 1, 8, 'fp2_23b', 'Arquero', 7, 3, 3),
(32, 5, 'b', 2, 5, 'fp2_23b', 'Caballero', 13, 7, 11),
(33, 5, 'b', 9, 6, 'fp2_23b', 'Espadachin', 5, 10, 6),
(34, 5, 'b', 9, 7, 'fp2_23b', 'Caballero', 13, 7, 11),
(35, 6, 'a', 0, 3, 'fp2_23b', 'Arquero', 7, 3, 7),
(36, 6, 'a', 1, 9, 'fp2_23b', 'Arquero', 7, 3, 4),
(37, 6, 'a', 3, 4, 'fp2_23b', 'Arquero', 7, 3, 3),
(38, 6, 'a', 3, 6, 'fp2_23b', 'Arquero', 7, 3, 5),
(39, 6, 'a', 3, 8, 'fp2_23b', 'Caballero', 13, 7, 10),
(40, 6, 'b', 0, 5, 'fp2_23b', 'Caballero', 13, 7, 12),
(41, 6, 'b', 1, 6, 'fp2_23b', 'Caballero', 13, 7, 12),
(42, 6, 'b', 1, 8, 'fp2_23b', 'Arquero', 7, 3, 3),
(43, 6, 'b', 2, 5, 'fp2_23b', 'Caballero', 13, 7, 11),
(44, 6, 'b', 9, 0, 'fp2_23b', 'Arquero', 7, 3, 7),
(45, 6, 'b', 9, 6, 'fp2_23b', 'Espadachin', 5, 10, 6),
(46, 6, 'b', 9, 7, 'fp2_23b', 'Caballero', 13, 7, 11),
(47, 7, 'a', 0, 5, 'fp2_23b', 'Caballero', 13, 7, 12),
(48, 7, 'a', 1, 6, 'fp2_23b', 'Caballero', 13, 7, 12),
(49, 7, 'a', 1, 8, 'fp2_23b', 'Arquero', 7, 3, 3),
(50, 7, 'a', 2, 5, 'fp2_23b', 'Caballero', 13, 7, 11),
(51, 7, 'a', 9, 0, 'fp2_23b', 'Arquero', 7, 3, 7),
(52, 7, 'a', 9, 6, 'fp2_23b', 'Espadachin', 5, 10, 6),
(53, 7, 'a', 9, 7, 'fp2_23b', 'Caballero', 13, 7, 11),
(54, 7, 'b', 0, 3, 'fp2_23b', 'Arquero', 7, 3, 7),
(55, 7, 'b', 1, 9, 'fp2_23b', 'Arquero', 7, 3, 4),
(56, 7, 'b', 3, 4, 'fp2_23b', 'Arquero', 7, 3, 3),
(57, 7, 'b', 3, 6, 'fp2_23b', 'Arquero', 7, 3, 5),
(58, 7, 'b', 3, 8, 'fp2_23b', 'Caballero', 13, 7, 10),
(59, 8, 'a', 0, 0, 'Lancero1x1', 'Lancero', 5, 10, 8),
(60, 8, 'a', 3, 8, 'Espad4x9', 'Espadachin', 10, 8, 9),
(61, 8, 'a', 5, 1, 'Espad6x2', 'Espadachin', 10, 8, 8),
(62, 8, 'a', 7, 0, 'Lancero8x1', 'Lancero', 5, 10, 7),
(63, 8, 'b', 3, 9, 'Lancero4x10', 'Lancero', 5, 10, 8),
(64, 8, 'b', 4, 8, 'Caballero5x9', 'Caballero', 13, 7, 10),
(65, 8, 'b', 5, 9, 'Arquero6x10', 'Arquero', 7, 3, 6),
(66, 8, 'b', 6, 0, 'Caballero7x1', 'Caballero', 13, 7, 10),
(67, 8, 'b', 6, 8, 'Lancero7x9', 'Lancero', 5, 10, 6),
(68, 8, 'b', 7, 5, 'Arquero8x6', 'Arquero', 7, 3, 7),
(69, 8, 'b', 7, 6, 'Lancero8x7', 'Lancero', 5, 10, 7),
(70, 8, 'b', 9, 1, 'Arquero10x2', 'Arquero', 7, 3, 5),
(71, 9, 'Julio', 9, 8, 'Espad10x9', 'Espadachin', 10, 8, 10),
(72, 9, 'Lorena', 0, 0, 'Caballero9x8', 'Caballero', 13, 7, 12),
(73, 9, 'Lorena', 1, 9, 'Caballero2x10', 'Caballero', 13, 7, 11),
(74, 9, 'Lorena', 2, 7, 'Lancero3x8', 'Lancero', 5, 10, 5),
(75, 9, 'Lorena', 4, 4, 'Lancero5x5', 'Lancero', 5, 10, 6),
(76, 9, 'Lorena', 4, 7, 'Caballero5x8', 'Caballero', 13, 7, 11),
(77, 9, 'Lorena', 6, 4, 'Arquero7x5', 'Arquero', 7, 3, 4),
(78, 9, 'Lorena', 6, 5, 'Caballero7x6', 'Caballero', 13, 7, 10),
(79, 9, 'Lorena', 9, 4, 'Arquero10x5', 'Arquero', 7, 3, 6);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `jugadores`
--
ALTER TABLE `jugadores`
  ADD PRIMARY KEY (`id_jugador`);

--
-- Indices de la tabla `partidas`
--
ALTER TABLE `partidas`
  ADD PRIMARY KEY (`id_partida`),
  ADD KEY `id_jugador1` (`id_jugador1`),
  ADD KEY `id_jugador2` (`id_jugador2`);

--
-- Indices de la tabla `soldados`
--
ALTER TABLE `soldados`
  ADD PRIMARY KEY (`id_soldado`),
  ADD KEY `id_partida` (`id_partida`),
  ADD KEY `id_jugador` (`id_jugador`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `partidas`
--
ALTER TABLE `partidas`
  MODIFY `id_partida` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `soldados`
--
ALTER TABLE `soldados`
  MODIFY `id_soldado` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=80;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `partidas`
--
ALTER TABLE `partidas`
  ADD CONSTRAINT `partidas_ibfk_1` FOREIGN KEY (`id_jugador1`) REFERENCES `jugadores` (`id_jugador`),
  ADD CONSTRAINT `partidas_ibfk_2` FOREIGN KEY (`id_jugador2`) REFERENCES `jugadores` (`id_jugador`);

--
-- Filtros para la tabla `soldados`
--
ALTER TABLE `soldados`
  ADD CONSTRAINT `soldados_ibfk_1` FOREIGN KEY (`id_partida`) REFERENCES `partidas` (`id_partida`),
  ADD CONSTRAINT `soldados_ibfk_2` FOREIGN KEY (`id_jugador`) REFERENCES `jugadores` (`id_jugador`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
