-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 29-01-2024 a las 16:23:45
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
-- Base de datos: `juego`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ejercitos`
--

CREATE TABLE `ejercitos` (
  `ID` int(11) NOT NULL,
  `Partida_ID` int(11) DEFAULT NULL,
  `Soldier1` int(11) DEFAULT NULL,
  `Soldier2` int(11) DEFAULT NULL,
  `Soldier3` int(11) DEFAULT NULL,
  `Soldier4` int(11) DEFAULT NULL,
  `Soldier5` int(11) DEFAULT NULL,
  `Soldier6` int(11) DEFAULT NULL,
  `Soldier7` int(11) DEFAULT NULL,
  `Soldier8` int(11) DEFAULT NULL,
  `Soldier9` int(11) DEFAULT NULL,
  `Soldier10` int(11) DEFAULT NULL,
  `Reino` varchar(50) DEFAULT NULL,
  `Territorio` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `ejercitos`
--

INSERT INTO `ejercitos` (`ID`, `Partida_ID`, `Soldier1`, `Soldier2`, `Soldier3`, `Soldier4`, `Soldier5`, `Soldier6`, `Soldier7`, `Soldier8`, `Soldier9`, `Soldier10`, `Reino`, `Territorio`) VALUES
(7, 10, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(8, 11, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(9, 12, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `jugadores`
--

CREATE TABLE `jugadores` (
  `Nombre` varchar(50) NOT NULL,
  `Contraseña` varchar(255) NOT NULL,
  `ResultadoUltimaPartida` int(11) DEFAULT 0,
  `Victorias` int(100) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `jugadores`
--

INSERT INTO `jugadores` (`Nombre`, `Contraseña`, `ResultadoUltimaPartida`, `Victorias`) VALUES
('Julio', '123456', 0, 1),
('Mariana', '123', 0, 8),
('user3223', '13254656', 0, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `partidas`
--

CREATE TABLE `partidas` (
  `ID` int(11) NOT NULL,
  `Jugador_Nombre` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `partidas`
--

INSERT INTO `partidas` (`ID`, `Jugador_Nombre`) VALUES
(11, 'Julio'),
(12, 'Mariana'),
(10, 'user3223');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `ejercitos`
--
ALTER TABLE `ejercitos`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `Partida_ID` (`Partida_ID`);

--
-- Indices de la tabla `jugadores`
--
ALTER TABLE `jugadores`
  ADD PRIMARY KEY (`Nombre`);

--
-- Indices de la tabla `partidas`
--
ALTER TABLE `partidas`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `Jugador_Nombre` (`Jugador_Nombre`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `ejercitos`
--
ALTER TABLE `ejercitos`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `partidas`
--
ALTER TABLE `partidas`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `ejercitos`
--
ALTER TABLE `ejercitos`
  ADD CONSTRAINT `ejercitos_ibfk_1` FOREIGN KEY (`Partida_ID`) REFERENCES `partidas` (`ID`);

--
-- Filtros para la tabla `partidas`
--
ALTER TABLE `partidas`
  ADD CONSTRAINT `partidas_ibfk_1` FOREIGN KEY (`Jugador_Nombre`) REFERENCES `jugadores` (`Nombre`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
