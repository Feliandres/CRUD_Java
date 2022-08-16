-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 16-08-2022 a las 05:36:14
-- Versión del servidor: 10.4.22-MariaDB
-- Versión de PHP: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `crud_java`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `pid` int(11) NOT NULL,
  `pnombre` varchar(30) NOT NULL,
  `pciudad` varchar(30) NOT NULL,
  `pprecio` double(5,2) NOT NULL,
  `pcantidad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`pid`, `pnombre`, `pciudad`, `pprecio`, `pcantidad`) VALUES
(1, 'Zapatos Adidas 2020', 'UIO', 210.00, 15),
(2, 'Sudadera Jordan', 'GYE', 5.00, 58),
(3, 'Medias M Roland', 'UIO', 125.00, 15),
(4, 'Cinturon', 'UIO', 10.00, 45),
(5, 'Chompa N', 'UIO', 50.00, 216),
(6, 'Abrigo Lana', 'GYE', 30.00, 15),
(7, 'Licra Deportiva', 'GYE', 5.00, 60),
(8, 'Short', 'GYE', 15.00, 200),
(10, 'Tennis B', 'Cuenca', 175.00, 69),
(11, 'Zapatos Adidas 2022', 'UIO', 230.00, 20),
(12, 'Calentador Jordan', 'GYE', 70.00, 58),
(13, 'Ropa interio CK', 'UIO', 20.00, 15),
(14, 'Cinturon', 'UIO', 10.00, 45),
(15, 'Chompa NY', 'UIO', 50.00, 200),
(16, 'Abrigo Reebok', 'GYE', 40.00, 15),
(17, 'Camisa sin manga', 'GYE', 3.00, 60),
(18, 'Short', 'GYE', 15.00, 200),
(19, 'Camisa Adidas', 'GYE', 10.00, 40),
(20, 'Zapatillas Sk', 'Cuenca', 175.00, 69),
(21, 'Zapatos Nike 2021', 'UIO', 210.00, 15),
(22, 'Sudadera Jordan', 'GYE', 5.00, 58),
(23, 'Medias M Roland', 'UIO', 125.00, 15),
(24, 'Cinturon', 'UIO', 10.00, 45),
(25, 'Chompa N', 'UIO', 50.00, 216),
(26, 'Abrigo Lana', 'GYE', 30.00, 15),
(27, 'Licra Deportiva', 'GYE', 5.00, 60),
(28, 'Short', 'GYE', 15.00, 200),
(29, 'Camisa Reebok', 'GYE', 15.00, 30),
(30, 'Tennis B', 'Cuenca', 175.00, 69),
(31, 'Zapatos Nike 2022', 'UIO', 230.00, 20),
(32, 'Calentador Jordan', 'GYE', 70.00, 58),
(33, 'Ropa interio CK', 'UIO', 20.00, 15),
(34, 'Cinturon', 'UIO', 10.00, 45),
(35, 'Chompa NY', 'UIO', 50.00, 200),
(36, 'Abrigo Reebok', 'GYE', 40.00, 15),
(37, 'Camisa sin manga', 'GYE', 3.00, 60),
(38, 'Short', 'GYE', 15.00, 200),
(39, 'Camisa Adidas', 'GYE', 10.00, 40),
(40, 'Zapatillas Sk', 'Cuenca', 175.00, 69),
(41, 'Zapatos Reebok 2020', 'UIO', 210.00, 15),
(42, 'Sudadera A', 'GYE', 5.00, 58),
(43, 'Medias M Nike', 'UIO', 125.00, 15),
(44, 'Cinturon', 'UIO', 10.00, 45),
(45, 'Chompa N', 'UIO', 50.00, 216),
(46, 'Abrigo Lana', 'GYE', 30.00, 15),
(47, 'Licra Deportiva', 'GYE', 5.00, 60),
(48, 'traje de banio', 'GYE', 15.00, 200),
(49, 'Camisa Reebok', 'GYE', 15.00, 30),
(50, 'Tennis B', 'Cuenca', 175.00, 69),
(51, 'Zapatos Reebok 2022', 'UIO', 230.00, 20),
(52, 'Calentador Jordan', 'GYE', 70.00, 58),
(53, 'Ropa interio CK', 'UIO', 20.00, 15),
(54, 'Cinturon', 'UIO', 10.00, 45),
(55, 'Chompa NY', 'UIO', 50.00, 200),
(56, 'Abrigo Reebok', 'GYE', 40.00, 15),
(57, 'Camisa sin manga', 'GYE', 3.00, 60),
(58, 'Short', 'GYE', 15.00, 200),
(59, 'Camisa Adidas', 'GYE', 10.00, 40),
(60, 'Zapatillas Sk', 'Cuenca', 175.00, 69),
(61, 'Zapatos Adidas 2020', 'UIO', 210.00, 15),
(62, 'Sudadera Jordan', 'GYE', 5.00, 58),
(63, 'Medias M Roland', 'UIO', 125.00, 15),
(64, 'Cinturon', 'UIO', 10.00, 45),
(65, 'Chompa N', 'UIO', 50.00, 216),
(66, 'Abrigo Lana', 'GYE', 30.00, 15),
(67, 'Licra Deportiva', 'GYE', 5.00, 60),
(68, 'Short', 'GYE', 15.00, 200),
(69, 'Camisa Reebok', 'GYE', 15.00, 30),
(70, 'Tennis B', 'Cuenca', 175.00, 69),
(71, 'Zapatos Adidas 2022', 'UIO', 230.00, 20),
(72, 'Calentador Jordan', 'GYE', 70.00, 58),
(73, 'Ropa interio CK', 'UIO', 20.00, 15),
(74, 'Cinturon', 'UIO', 10.00, 45),
(75, 'Chompa NY', 'UIO', 50.00, 200),
(76, 'Abrigo Reebok', 'GYE', 40.00, 15),
(77, 'Camisa sin manga', 'GYE', 3.00, 60),
(78, 'Short', 'GYE', 15.00, 200),
(79, 'Camisa Adidas', 'GYE', 10.00, 40),
(80, 'Zapatillas Sk', 'Cuenca', 175.00, 69),
(81, 'Sudadera Jordan', 'GYE', 5.00, 58),
(82, 'Zapatos Adidas 2020', 'UIO', 210.00, 15),
(83, 'Sudadera Jordan', 'GYE', 5.00, 58),
(84, 'Medias M Roland', 'UIO', 125.00, 15),
(85, 'Cinturon', 'UIO', 10.00, 45),
(86, 'Chompa N', 'UIO', 50.00, 216),
(87, 'Abrigo Lana', 'GYE', 30.00, 15),
(88, 'Licra Deportiva', 'GYE', 5.00, 60),
(89, 'Short', 'GYE', 15.00, 200),
(90, 'Camisa Reebok', 'GYE', 15.00, 30),
(91, 'Tennis B', 'Cuenca', 175.00, 69),
(92, 'Zapatos Adidas 2022', 'UIO', 230.00, 20),
(93, 'Calentador Jordan', 'GYE', 70.00, 58),
(94, 'Ropa interio CK', 'UIO', 20.00, 15),
(95, 'Cinturon', 'UIO', 10.00, 45),
(96, 'Chompa NY', 'UIO', 50.00, 200),
(97, 'Abrigo Reebok', 'GYE', 40.00, 15),
(98, 'Camisa sin manga', 'GYE', 3.00, 60),
(99, 'Short', 'GYE', 15.00, 200),
(100, 'Camisa Adidas', 'GYE', 10.00, 40),
(101, 'Zapatillas Sk', 'Cuenca', 175.00, 69),
(102, 'Zapatos Nike 2021', 'UIO', 210.00, 15),
(103, 'Sudadera Jordan', 'GYE', 5.00, 58),
(104, 'Medias M Roland', 'UIO', 125.00, 15),
(105, 'Cinturon', 'UIO', 10.00, 45),
(106, 'Chompa N', 'UIO', 50.00, 216),
(107, 'Abrigo Lana', 'GYE', 30.00, 15),
(108, 'Licra Deportiva', 'GYE', 5.00, 60),
(109, 'Short', 'GYE', 15.00, 200),
(110, 'Camisa Reebok', 'GYE', 15.00, 30),
(111, 'Tennis B', 'Cuenca', 175.00, 69),
(112, 'Zapatos Nike 2022', 'UIO', 230.00, 20),
(113, 'Calentador Jordan', 'GYE', 70.00, 58),
(114, 'Ropa interio CK', 'UIO', 20.00, 15),
(115, 'Cinturon', 'UIO', 10.00, 45),
(116, 'Chompa NY', 'UIO', 50.00, 200),
(117, 'Abrigo Reebok', 'GYE', 40.00, 15),
(118, 'Camisa sin manga', 'GYE', 3.00, 60),
(119, 'Short', 'GYE', 15.00, 200),
(120, 'Camisa Adidas', 'GYE', 10.00, 40),
(121, 'Zapatillas Sk', 'Cuenca', 175.00, 69),
(122, 'Zapatos Reebok 2020', 'UIO', 210.00, 15),
(123, 'Sudadera A', 'GYE', 5.00, 58),
(125, 'Cinturon', 'UIO', 10.00, 45),
(126, 'Chompa N', 'UIO', 50.00, 216),
(127, 'Abrigo Lana', 'GYE', 30.00, 15),
(128, 'Licra Deportiva', 'GYE', 5.00, 60),
(129, 'traje de banio', 'GYE', 15.00, 200),
(130, 'Camisa Reebok', 'GYE', 15.00, 30),
(131, 'Tennis B', 'Cuenca', 175.00, 69),
(132, 'Zapatos Reebok 2022', 'UIO', 230.00, 20),
(133, 'Calentador Jordan', 'GYE', 70.00, 58),
(134, 'Ropa interio CK', 'UIO', 20.00, 15),
(135, 'Cinturon', 'UIO', 10.00, 45),
(136, 'Chompa NY', 'UIO', 50.00, 200),
(137, 'Abrigo Reebok', 'GYE', 40.00, 15),
(138, 'Camisa sin manga', 'GYE', 3.00, 60),
(139, 'Short', 'GYE', 15.00, 200),
(140, 'Camisa Adidas', 'GYE', 10.00, 40),
(141, 'Zapatillas Sk', 'Cuenca', 175.00, 69),
(142, 'Zapatos Adidas 2020', 'UIO', 210.00, 15),
(143, 'Sudadera Jordan', 'GYE', 5.00, 58),
(144, 'Medias M Roland', 'UIO', 125.00, 15),
(145, 'Cinturon', 'UIO', 10.00, 45),
(146, 'Chompa N', 'UIO', 50.00, 216),
(147, 'Abrigo Lana', 'GYE', 30.00, 15),
(148, 'Licra Deportiva', 'GYE', 5.00, 60),
(149, 'Short', 'GYE', 15.00, 200),
(150, 'Camisa Reebok', 'GYE', 15.00, 30),
(151, 'Tennis B', 'Cuenca', 175.00, 69),
(152, 'Zapatos Adidas 2022', 'UIO', 230.00, 20),
(153, 'Calentador Jordan', 'GYE', 70.00, 58),
(154, 'Ropa interio CK', 'UIO', 20.00, 15),
(155, 'Cinturon', 'UIO', 10.00, 45),
(157, 'Abrigo Reebok', 'GYE', 40.00, 15),
(158, 'Camisa sin manga', 'GYE', 3.00, 60),
(159, 'Short', 'GYE', 15.00, 200),
(160, 'Camisa Adidas', 'GYE', 10.00, 40),
(161, 'Zapatillas Sk', 'Cuenca', 175.00, 69),
(162, 'Zapatos Adidas 2020', 'UIO', 210.00, 15),
(163, 'Sudadera Jordan', 'GYE', 5.00, 58),
(164, 'Medias M Roland', 'UIO', 125.00, 15),
(165, 'Cinturon', 'UIO', 10.00, 45),
(166, 'Chompa N', 'UIO', 50.00, 216),
(167, 'Abrigo Lana', 'GYE', 30.00, 15),
(168, 'Licra Deportiva', 'GYE', 5.00, 60),
(170, 'Camisa Reebok', 'GYE', 15.00, 30),
(171, 'Tennis B', 'Cuenca', 175.00, 69),
(172, 'Zapatos Adidas 2022', 'UIO', 230.00, 20),
(173, 'Calentador Jordan', 'GYE', 70.00, 58),
(174, 'Ropa interio CK', 'UIO', 20.00, 15),
(175, 'Cinturon', 'UIO', 10.00, 45),
(176, 'Chompa NY', 'UIO', 50.00, 200),
(177, 'Abrigo Reebok 23', 'GYE', 40.23, 151),
(179, 'Short', 'GYE', 15.00, 200),
(181, 'Zapatillas Sk', 'Cuenca', 175.00, 69),
(182, 'Cinturon', 'UIO', 16.66, 14);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id_usuario` int(11) NOT NULL,
  `nom_usuario` varchar(15) NOT NULL,
  `apel_usuario` varchar(15) NOT NULL,
  `mail_usuario` varchar(30) NOT NULL,
  `cell_usuario` varchar(10) NOT NULL,
  `password_usuario` varchar(15) NOT NULL,
  `confirm_password_usuario` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id_usuario`, `nom_usuario`, `apel_usuario`, `mail_usuario`, `cell_usuario`, `password_usuario`, `confirm_password_usuario`) VALUES
(7, 'fefe', 'fefe', 'fefe@fefe', '123123', '12', '12'),
(9, 'asd', 'asda', 'asd@asd', '1231231', '12', '12'),
(10, 'adsf1', 'asdf', 'adf@adf', '123123', '123', '123'),
(11, 'fefe1', 'fefe2', 'fefe@fefe1.com', '12313', '12', '12'),
(12, 'Jenny', 'Pazmino', 'jennypazmino@gmail.com', '0992695606', 'peras2022', 'peras2022'),
(13, 'Felipe ', 'Pazmiño', 'felipe.pazmino@epn.edu.ec', '0984507476', '123', '123');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`pid`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id_usuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `productos`
--
ALTER TABLE `productos`
  MODIFY `pid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=184;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id_usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
