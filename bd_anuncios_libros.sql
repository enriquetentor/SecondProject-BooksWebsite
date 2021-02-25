-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 25-02-2021 a las 16:52:44
-- Versión del servidor: 10.4.14-MariaDB
-- Versión de PHP: 7.4.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bd_anuncios_libros`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categorias`
--

CREATE TABLE `categorias` (
  `id` bigint(20) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `categorias`
--

INSERT INTO `categorias` (`id`, `description`, `name`) VALUES
(4, 'd', 'Misterio');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria_libro`
--

CREATE TABLE `categoria_libro` (
  `categoria_id` bigint(20) NOT NULL,
  `libro_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `libros`
--

CREATE TABLE `libros` (
  `id` bigint(20) NOT NULL,
  `author` varchar(255) DEFAULT NULL,
  `contact` varchar(255) DEFAULT NULL,
  `editorial` varchar(255) DEFAULT NULL,
  `isbn` varchar(255) DEFAULT NULL,
  `pages` int(11) NOT NULL,
  `price` double NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `libros`
--

INSERT INTO `libros` (`id`, `author`, `contact`, `editorial`, `isbn`, `pages`, `price`, `title`, `user_id`) VALUES
(1, 'Isaac Asimov', 'yo', 'editorial', 'isbn', 365, 4.99, 'Nemesis', 2),
(2, 'Haruki Murakami', 'yo', 'e', 'i', 520, 14.99, 'Tokyo Blues', 2),
(17, 'Fiódor Dostoyevski', 'c', 'e', 'i', 800, 19.99, 'Crimen y castigo', 2),
(18, 'Fiódor Dostoyevski', 'c', 'e', 'i', 800, 19.99, 'Los hermanos Karamazov', 2),
(19, 'Jean-Paul Sartre', 'c', 'e', 'i', 230, 3.99, 'La náusea', 2),
(20, 'Jean-Paul Sartre', 'c', 'e', 'i', 220, 4.99, 'El ser y la nada', 2),
(21, 'Carlos Ruiz Zafón', 'c', 'e', 'i', 590, 14.99, 'La sombra del viento', 2),
(22, 'Carlos Ruiz Zafón', 'cc', 'e', 'i', 610, 14.99, 'El juego del ángel', 2),
(28, 'Francisco Umbral', 'yo', 'Austral', 'i', 256, 4.99, 'Un ser de lejanías', 2),
(29, 'Tomás Moro', 'c', 'e', 'i', 200, 4.99, 'Utopía', 2),
(30, 'Philip K. Dick', 'c', 'e', 'i', 454, 5, '¿Sueñan los androides con ovejas eléctricas?', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `name`, `password`) VALUES
(2, 'kike', '123');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `categorias`
--
ALTER TABLE `categorias`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `categoria_libro`
--
ALTER TABLE `categoria_libro`
  ADD KEY `FK_qbmn9k5fpm47v3odd2aqm4vsr` (`libro_id`),
  ADD KEY `FK_d445r3u7hden6485bb32j7tni` (`categoria_id`);

--
-- Indices de la tabla `libros`
--
ALTER TABLE `libros`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_buyowphwf9oycir99vs4eumnx` (`user_id`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `categorias`
--
ALTER TABLE `categorias`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `libros`
--
ALTER TABLE `libros`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `categoria_libro`
--
ALTER TABLE `categoria_libro`
  ADD CONSTRAINT `FK_d445r3u7hden6485bb32j7tni` FOREIGN KEY (`categoria_id`) REFERENCES `categorias` (`id`),
  ADD CONSTRAINT `FK_qbmn9k5fpm47v3odd2aqm4vsr` FOREIGN KEY (`libro_id`) REFERENCES `libros` (`id`);

--
-- Filtros para la tabla `libros`
--
ALTER TABLE `libros`
  ADD CONSTRAINT `FK_buyowphwf9oycir99vs4eumnx` FOREIGN KEY (`user_id`) REFERENCES `usuarios` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
