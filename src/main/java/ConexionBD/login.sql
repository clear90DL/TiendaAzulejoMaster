-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 18-12-2025 a las 01:45:47
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
-- Base de datos: `login`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categorias`
--

CREATE TABLE `categorias` (
  `ID` int(11) NOT NULL,
  `DESCRIPCION` varchar(255) DEFAULT NULL,
  `NOMBRE` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `categorias`
--

INSERT INTO `categorias` (`ID`, `DESCRIPCION`, `NOMBRE`) VALUES
(1, 'Azulejo para pisos interiores y exteriores', 'Pisos'),
(2, 'Azulejo para pared de baño y cocina', 'Pared'),
(3, 'Azulejo decorativo con patrones o relieves', 'Decorativo'),
(4, 'Azulejo resistente al agua', 'Baño'),
(6, 'Azulejo rústico para exteriores', 'Exterior'),
(7, 'Azulejo estilo madera', 'Madera'),
(8, 'Azulejo tipo piedra', 'Roca'),
(9, 'Pared falso', 'Techo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `ID` int(11) NOT NULL,
  `primer_nombre` varchar(100) NOT NULL,
  `segundo_nombre` varchar(100) DEFAULT NULL,
  `apellido_paterno` varchar(100) NOT NULL,
  `apellido_materno` varchar(100) DEFAULT NULL,
  `tipo_de_cliente` varchar(50) NOT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `correo_electronico` varchar(120) DEFAULT NULL,
  `rfc` varchar(20) DEFAULT NULL,
  `calle` varchar(150) DEFAULT NULL,
  `numeroExterior` varchar(20) DEFAULT NULL,
  `numeroInterior` varchar(20) DEFAULT NULL,
  `colonia` varchar(100) DEFAULT NULL,
  `codigoPostal` varchar(10) DEFAULT NULL,
  `municipio` varchar(100) DEFAULT NULL,
  `ciudad` varchar(100) DEFAULT NULL,
  `referencia` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`ID`, `primer_nombre`, `segundo_nombre`, `apellido_paterno`, `apellido_materno`, `tipo_de_cliente`, `telefono`, `correo_electronico`, `rfc`, `calle`, `numeroExterior`, `numeroInterior`, `colonia`, `codigoPostal`, `municipio`, `ciudad`, `referencia`) VALUES
(25, 'Juan', 'Carlos', 'García', 'López', 'empresa', '7571112023', 'juan@email.com', '', '', '', '', '', '', '', 'CDMX', ''),
(26, 'María', 'Elena', 'Rodríguez', 'Martínez', 'empresa', '5559876543', 'maria@email.com', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'CDMX', NULL),
(29, 'Pedro', NULL, 'González', 'Ramírez', 'MAYORISTA', '5553456789', 'pedro@email.com', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'CDMX', NULL),
(31, 'María', 'Elena', 'Rodríguez', 'Martínez', 'empresa', '5559876543', 'maria.rodriguez@email.com', 'ROME750215DEF', 'Calle Morelos', '45', 'B', 'Del Valle', '03100', 'Benito Juárez', 'Ciudad de México', 'Frente al parque'),
(32, 'Carlos', '', 'Hernández', 'Gómez', 'empresa', '555567890', 'carlos.hernandez@email.com', 'HECG820310GHI', 'Eje Central', '789', '', 'Narvarte', '03020', 'Benito Juárez', 'Ciudad de México', 'Esquina con Tlalpan'),
(33, 'Ana', 'Isabel', 'Pérez', 'Sánchez', 'MINORISTA', '555-234-5678', 'ana.perez@email.com', 'PEAI880525JKL', 'Calzada de Tlalpan', '1500', '301', 'Portales', '03300', 'Benito Juárez', 'Ciudad de México', 'Edificio blanco, 3er piso'),
(34, 'Pedro', NULL, 'González', 'Ramírez', 'MAYORISTA', '555-345-6789', 'pedro.gonzalez@email.com', 'GORP900630MNO', 'Av. Insurgentes', '2500', NULL, 'Nápoles', '03810', 'Benito Juárez', 'Ciudad de México', 'Local 5, plaza comercial'),
(35, 'Laura', 'Patricia', 'Fernández', 'Díaz', 'MAYORISTA', '555-567-8901', 'laura.fernandez@email.com', 'FEDL851212PQR', 'Av. Universidad', '1200', 'B', 'Copilco', '04360', 'Coyoacán', 'Ciudad de México', 'Cerca de CU'),
(36, 'Roberto', 'Alberto', 'Martínez', 'Vázquez', 'MAYORISTA', '555-678-9012', 'roberto.martinez@email.com', 'MAVR770707STU', 'Coyoacán', '89', NULL, 'Del Carmen', '04100', 'Coyoacán', 'Ciudad de México', 'Frente a mercado'),
(37, 'Sofía', NULL, 'López', 'Castro', 'MAYORISTA', '555-789-0123', 'sofia.lopez@email.com', 'LOCS920818VWX', 'Miguel Ángel de Quevedo', '340', '2', 'Churubusco', '04200', 'Coyoacán', 'Ciudad de México', 'Entre División del Norte'),
(38, 'Miguel', 'Ángel', 'Torres', 'Ortega', 'ESPECIAL', '555-890-1234', 'miguel.torres@email.com', 'TOOM830404YZA', 'Av. División del Norte', '2001', NULL, 'Extremadura Insurgentes', '03740', 'Benito Juárez', 'Ciudad de México', 'Oficinas Torres'),
(39, 'Carmen', NULL, 'Ruiz', 'Flores', 'ESPECIAL', '555-901-2345', 'carmen.ruiz@email.com', 'RUFC910101BCD', 'Av. Río Churubusco', '500', 'Piso 3', 'Xoco', '03330', 'Benito Juárez', 'Ciudad de México', 'Edificio corporativo'),
(40, 'José', 'Antonio', 'Morales', 'Jiménez', 'ESPECIAL', '555-012-3456', 'jose.morales@email.com', 'MOJA800808EFG', 'Calzada Ermita Iztapalapa', '1000', NULL, 'Santa María Aztahuacán', '09500', 'Iztapalapa', 'Ciudad de México', 'Bodega grande'),
(41, 'Patricia', 'Gabriela', 'Ortiz', 'Navarro', 'ESPECIAL', '555-112-2334', 'patricia.ortiz@email.com', 'ORPN870707HIJ', 'Calzada San Juan de Aragón', '600', 'Local 12', 'San Juan de Aragón', '07969', 'Gustavo A. Madero', 'Ciudad de México', 'Plaza comercial'),
(42, 'Francisco', NULL, 'Castillo', 'Mendoza', 'FRECUENTE', '555-223-3445', 'francisco.castillo@email.com', 'CAMF850505KLM', 'Av. Tláhuac', '800', 'A', 'Santa Catarina', '04000', 'Coyoacán', 'Ciudad de México', 'Cerca del metro'),
(43, 'Gabriela', 'María', 'Reyes', 'Guerrero', 'FRECUENTE', '555-334-4556', 'gabriela.reyes@email.com', 'REGG920202NOP', 'Eje 6 Sur', '1234', NULL, 'Álamos', '03400', 'Benito Juárez', 'Ciudad de México', 'Entre calles'),
(44, 'Javier', 'Enrique', 'Álvarez', 'Romero', 'FRECUENTE', '555-445-5667', 'javier.alvarez@email.com', 'ALJR881212QRS', 'Av. Coyoacán', '567', 'B', 'Del Valle Norte', '03103', 'Benito Juárez', 'Ciudad de México', 'Frente a banco'),
(45, 'Daniela', NULL, 'Méndez', 'Herrera', 'FRECUENTE', '555-556-6778', 'daniela.mendez@email.com', 'MEHD930303TUV', 'Av. San Jerónimo', '890', 'Piso 2', 'La Otra Banda', '01090', 'Álvaro Obregón', 'Ciudad de México', 'Oficina 201'),
(46, 'Ricardo', 'Javier', 'Silva', 'Pacheco', 'MINORISTA', '555-667-7889', 'ricardo.silva@email.com', 'SIPR791111WXY', 'Paseo de la Reforma', '222', NULL, 'Tabacalera', '06030', 'Cuauhtémoc', 'Ciudad de México', 'Edificio histórico'),
(47, 'Verónica', 'Alejandra', 'Vega', 'Ríos', 'MINORISTA', '555-778-8990', 'veronica.vega@email.com', 'VERV860606ZAB', 'Av. Chapultepec', '400', '3', 'Roma Norte', '06700', 'Cuauhtémoc', 'Ciudad de México', 'Departamento 3B'),
(48, 'Luis', 'Fernando', 'Cortés', 'Miranda', 'MAYORISTA', '555-889-9001', 'luis.cortes@email.com', 'COLM740404CDE', 'Av. Cuauhtémoc', '1200', NULL, 'Narvarte Poniente', '03020', 'Benito Juárez', 'Ciudad de México', 'Local comercial'),
(49, 'Elena', NULL, 'Suárez', 'Montes', 'ESPECIAL', '555-990-0112', 'elena.suarez@email.com', 'SUME900909FGH', 'Calzada de la Viga', '1500', 'Bodega 5', 'Michoacán', '08830', 'Iztacalco', 'Ciudad de México', 'En el mercado'),
(50, 'PUBLICO', 'GENERAL', '', '', 'empresa', '000000000', '', '', '', '', '', '', '', '', '', ''),
(51, 'Claudio', '', 'De Jesus', 'Espindola', 'frecuente', '7571090640', 'clajesus175@gmail.com', '22155788966', 'Bella vista', '', '', 'Cuauhtemoc', '41300', 'Tlapa de comonfort', '', 'Enfrente de la casa de salud');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_pedido`
--

CREATE TABLE `detalle_pedido` (
  `id_detalle` int(11) NOT NULL,
  `id_pedido` int(11) DEFAULT NULL,
  `id_producto` int(11) DEFAULT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `precio_unitario` decimal(10,2) DEFAULT NULL,
  `subtotal` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `detalle_pedido`
--

INSERT INTO `detalle_pedido` (`id_detalle`, `id_pedido`, `id_producto`, `cantidad`, `precio_unitario`, `subtotal`) VALUES
(1, 3, 1, 2, 500.00, NULL),
(2, 4, 1, 2, 500.00, NULL),
(3, 5, 1, 2, 500.00, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_venta`
--

CREATE TABLE `detalle_venta` (
  `id_detalle` int(11) NOT NULL,
  `id_venta` int(11) DEFAULT NULL,
  `id_producto` int(11) DEFAULT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `precio_unitario` decimal(10,2) DEFAULT NULL,
  `subtotal` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `detalle_venta`
--

INSERT INTO `detalle_venta` (`id_detalle`, `id_venta`, `id_producto`, `cantidad`, `precio_unitario`, `subtotal`) VALUES
(1, 1, 1, 2, 500.00, 1000.00),
(2, 2, 2, 3, 300.00, 900.00),
(3, 4, 2, 2, 300.00, 600.00),
(4, 5, 2, 2, 300.00, 600.00),
(5, 6, 2, 1, 300.00, 300.00),
(6, 7, 1, 1, 500.00, 500.00),
(7, 8, 1, 2, 500.00, 1000.00),
(8, 9, 1, 2, 500.00, 1000.00),
(10, 11, 2, 5, 300.00, 1500.00),
(11, 12, 2, 2, 300.00, 600.00);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `informacion_empresa`
--

CREATE TABLE `informacion_empresa` (
  `id_empresa` int(11) NOT NULL,
  `nombre_empresa` varchar(100) DEFAULT NULL,
  `direccion` varchar(150) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `web_site` varchar(100) DEFAULT NULL,
  `logo_imagen` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `informacion_empresa`
--

INSERT INTO `informacion_empresa` (`id_empresa`, `nombre_empresa`, `direccion`, `email`, `telefono`, `web_site`, `logo_imagen`) VALUES
(1, 'TIENDA AZULEJO SANTA FE', 'Col. Aviación', 'tienda@email.com', '7571101120', 'http://tiendaazulejo.com', 'C:\\Users\\Usuario\\Documents\\Proyecto_azulejo\\TiendaAzulejo\\src\\main\\resources\\imagenes\\tipos-materiales-azulejos2-1024x493.jpg');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedido`
--

CREATE TABLE `pedido` (
  `id_pedido` int(11) NOT NULL,
  `id_cliente` int(11) DEFAULT NULL,
  `fecha_pedido` datetime DEFAULT current_timestamp(),
  `estado` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `pedido`
--

INSERT INTO `pedido` (`id_pedido`, `id_cliente`, `fecha_pedido`, `estado`) VALUES
(1, 25, '2025-12-14 18:03:57', 'Pendiente'),
(2, 26, '2025-12-14 18:03:57', 'Entregado'),
(3, 25, '2025-12-15 03:10:17', 'Cancelado'),
(4, 25, '2025-12-15 03:13:43', 'Entregado'),
(5, 51, '2025-12-15 23:37:10', 'Entregado');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `permiso_usuario`
--

CREATE TABLE `permiso_usuario` (
  `id_permiso` int(11) NOT NULL,
  `id_usuario` int(11) DEFAULT NULL,
  `permiso` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `permiso_usuario`
--

INSERT INTO `permiso_usuario` (`id_permiso`, `id_usuario`, `permiso`) VALUES
(29, 5, 'CLIENTES'),
(30, 5, 'CONFIGURACION'),
(31, 5, 'PRODUCTOS'),
(32, 5, 'PROVEEDOR'),
(33, 5, 'USUARIOS'),
(34, 5, 'VENTAS'),
(39, 5, 'REPORTES'),
(40, 5, 'PEDIDOS'),
(41, 10, 'VENTAS'),
(43, 11, 'VENTAS'),
(44, 11, 'PEDIDOS');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `IDPRODUCTO` int(11) NOT NULL,
  `CODIGO` varchar(255) DEFAULT NULL,
  `COLOR` varchar(255) DEFAULT NULL,
  `DIMENSION` varchar(255) DEFAULT NULL,
  `MATERIAL` varchar(255) DEFAULT NULL,
  `NOMBRE` varchar(255) DEFAULT NULL,
  `PRECIOCOMPRA` int(11) DEFAULT NULL,
  `PRECIOVENTA` int(11) DEFAULT NULL,
  `STOCKDISPONIBLE` int(11) DEFAULT NULL,
  `fk_categoria` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`IDPRODUCTO`, `CODIGO`, `COLOR`, `DIMENSION`, `MATERIAL`, `NOMBRE`, `PRECIOCOMPRA`, `PRECIOVENTA`, `STOCKDISPONIBLE`, `fk_categoria`) VALUES
(1, '21', 'Blanco', '60x60', 'Mármol', 'Azulejo Mármol Blanco', 250, 500, 1472, 1),
(2, '80', 'Café', '60x70', 'Mármol', 'Azulejo Mármol Café', 250, 300, 200, 2),
(3, '45', 'Gris', '45x45', 'Porcelanato', 'Azulejo Gris Mate', 200, 270, 115, 2),
(4, '52', 'Azul', '30x60', 'Cerámica', 'Azulejo Azul', 150, 210, 40, 4),
(6, '33', 'rojo', '20x20', 'marmol', 'Azulejo premium', 100, 130, 100, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedores`
--

CREATE TABLE `proveedores` (
  `ID` int(11) NOT NULL,
  `NOMBRE_PROVEEDOR` varchar(100) DEFAULT NULL,
  `NOMBRE_CONTACTO` varchar(100) DEFAULT NULL,
  `TIPO_PROVEEDOR` varchar(50) DEFAULT NULL,
  `TELEFONO1` varchar(20) DEFAULT NULL,
  `TELEFONO2` varchar(20) DEFAULT NULL,
  `CORREO` varchar(100) DEFAULT NULL,
  `RFC` varchar(20) DEFAULT NULL,
  `CALLE` varchar(100) DEFAULT NULL,
  `NUMERO_INTERIOR` varchar(20) DEFAULT NULL,
  `NUMERO_EXTERIOR` varchar(20) DEFAULT NULL,
  `COLONIA` varchar(100) DEFAULT NULL,
  `MUNICIPIO` varchar(100) DEFAULT NULL,
  `CIUDAD` varchar(100) DEFAULT NULL,
  `CODIGO_POSTAL` varchar(10) DEFAULT NULL,
  `REFERENCIA` varchar(200) DEFAULT NULL,
  `ESTADO` varchar(20) DEFAULT 'ACTIVO',
  `FECHA_REGISTRO` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `proveedores`
--

INSERT INTO `proveedores` (`ID`, `NOMBRE_PROVEEDOR`, `NOMBRE_CONTACTO`, `TIPO_PROVEEDOR`, `TELEFONO1`, `TELEFONO2`, `CORREO`, `RFC`, `CALLE`, `NUMERO_INTERIOR`, `NUMERO_EXTERIOR`, `COLONIA`, `MUNICIPIO`, `CIUDAD`, `CODIGO_POSTAL`, `REFERENCIA`, `ESTADO`, `FECHA_REGISTRO`) VALUES
(1, 'Azulejos del Centro', 'Roberto Martínez', 'MAYORISTA', '5551234567', NULL, 'contacto@azucentro.com', NULL, NULL, NULL, NULL, NULL, NULL, 'CDMX', NULL, NULL, 'ACTIVO', NULL),
(2, 'Materiales Rivera', 'Laura Rivera', 'MAYORISTA', '5553456789', NULL, 'ventas@materialesrivera.com', NULL, NULL, NULL, NULL, NULL, NULL, 'CDMX', NULL, NULL, 'ACTIVO', NULL),
(3, 'Cerámicas Altura', 'Sofía Hernández', 'DISTRIBUIDOR', '5554567890', NULL, 'contacto@ceralt.com', NULL, NULL, NULL, NULL, NULL, NULL, 'CDMX', NULL, NULL, 'ACTIVO', NULL),
(4, 'Azulejos del Centro', 'Roberto Martínez', 'MAYORISTA', '555-123-4567', '555-234-5678', 'contacto@azucentro.com', 'AZC800101ABC', 'Avenida Central', '2B', '120', 'Centro', 'Cuauhtémoc', 'Ciudad de México', '06000', 'Frente al mercado central', 'Activo', '2025-12-01'),
(5, 'Materiales Rivera', 'Laura Rivera', 'MAYORISTA', '555-345-6789', NULL, 'ventas@materialesrivera.com', 'MARR850505DFG', 'Calle Hidalgo', NULL, '45', 'San Rafael', 'Cuauhtémoc', 'Ciudad de México', '06470', 'Entre Reforma y Sullivan', 'Activo', '2025-12-01'),
(6, 'Cerámicas Altura', 'Sofía Hernández', 'Materiales', '7574441521', '', 'contacto@ceralt.com', 'CEHA900909HIJ', 'Eje 3 Sur', '1', '789', 'Narvarte', 'Benito Juárez', 'Ciudad de México', '03020', 'Esquina con Av. Cuauhtémoc', 'Activo', '2025-12-01'),
(7, 'Pisos y Muros León', 'Carlos León', 'MAYORISTA', '555-567-8901', NULL, 'info@pymleon.com', 'PMLE820202KLM', 'Av. Universidad', '12A', '1560', 'Copilco', 'Coyoacán', 'Ciudad de México', '04360', 'Frente a Plaza Copilco', 'Activo', '2025-12-01'),
(8, 'Distribuidora Torreón', 'Héctor Torres', 'DISTRIBUIDOR', '555-678-9012', NULL, 'contacto@distorren.com', 'DITO780818NOP', 'Av. Revolución', NULL, '2300', 'Mixcoac', 'Benito Juárez', 'Ciudad de México', '03920', 'Al lado del hospital', 'Activo', '2025-12-01'),
(9, 'Azulejos Premium', 'Patricia Ávila', 'MAYORISTA', '555-789-0123', '555-890-1234', 'ventas@azupremium.com', 'AZPR851212PQR', 'Miguel Ángel de Quevedo', NULL, '450', 'Churubusco', 'Coyoacán', 'Ciudad de México', '04200', 'Frente a autoservicio', 'Activo', '2025-12-01'),
(10, 'Materiales del Sur', 'Ricardo Juárez', 'CONSTRUCTOR', '555-890-1234', NULL, 'contacto@matsur.com', 'MASU840404RST', 'Calzada de Tlalpan', '3', '2100', 'Portales', 'Benito Juárez', 'Ciudad de México', '03300', 'Edificio gris', 'Activo', '2025-12-01'),
(11, 'Cerámica Moderna2', 'Gabriela Méndez', 'Trasporte', '555-901-2345', '555-345-6780', 'ventas@ceramoderna.com', 'CEMO870707UVW', 'Av. Coyoacán', '5', '679', 'Del Valle Norte', 'Benito Juárez', 'Ciudad de México', '03103', 'A un lado de banco', 'Activo', '2025-12-01'),
(12, 'Azultek México', 'Fernando Ortiz', 'FABRICANTE', '555-012-3456', NULL, 'info@azultek.mx', 'AZMX900101XYZ', 'Eje Central', '102', '890', 'Doctores', 'Cuauhtémoc', 'Ciudad de México', '06720', 'En frente del edificio rojo', 'Activo', '2025-12-01'),
(13, 'Pisos Industriales SA', 'María Gómez', 'MAYORISTA', '555-112-2334', '555-223-3445', 'contacto@pisosind.com', 'PIIN780505ABC', 'Av. del Taller', NULL, '233', 'Transito', 'Cuauhtémoc', 'Ciudad de México', '06820', 'Junto al taller mecánico', 'Activo', '2025-12-01'),
(14, 'Proveedora Roma', 'Javier Ruiz', 'DISTRIBUIDOR', '555-334-4556', NULL, 'ventas@proveroma.com', 'PRRM920202BCD', 'Av. Chapultepec', '9A', '400', 'Roma Norte', 'Cuauhtémoc', 'Ciudad de México', '06700', 'Departamento 3C', 'Activo', '2025-12-01'),
(15, 'Azulejos Monterrey', 'Daniel Torres', 'FABRICANTE', '555-445-5667', '555-556-6778', 'contacto@azumty.com', 'AZMT800303CDE', 'Av. San Borja', NULL, '150', 'Del Valle', 'Benito Juárez', 'Ciudad de México', '03100', 'Planta baja', 'Activo', '2025-12-01'),
(16, 'Cerámicas Imperial', 'Julia Ríos', 'MAYORISTA', '555-667-7889', NULL, 'ventas@cerimperial.com', 'CEIM820707EFG', 'Reforma Sur', '4', '324', 'Tabacalera', 'Cuauhtémoc', 'Ciudad de México', '06030', 'Edificio histórico', 'Activo', '2025-12-01'),
(17, 'Distribuidora Azteca', 'Luis Aguilar', 'DISTRIBUIDOR', '555-778-8990', NULL, 'contacto@distazteca.com', 'DAZT800909FGH', 'Calle Puebla', NULL, '89', 'Roma Sur', 'Cuauhtémoc', 'Ciudad de México', '06760', 'Esquina con Tonalá', 'Activo', '2025-12-01'),
(18, 'Pisos Elegantes', 'Rocío Vargas', 'MAYORISTA', '555-889-9001', '555-990-0112', 'ventas@pisoselegantes.com', 'PIEL870101HIJ', 'Avenida Juárez', NULL, '500', 'Centro', 'Cuauhtémoc', 'Ciudad de México', '06010', 'Frente al museo', 'Activo', '2025-12-01'),
(19, 'Cerámicas del Valle', 'Marco Hernández', 'DISTRIBUIDOR', '555-101-2020', NULL, 'info@cerval.com', 'CEVA920520KLN', 'Division del Norte', '102', '2300', 'Del Valle', 'Benito Juárez', 'Ciudad de México', '03100', 'Junto a farmacia', 'Activo', '2025-12-01'),
(21, 'Azulejos del Sur', 'Edgar Morales', 'MAYORISTA', '555-303-4040', NULL, 'ventas@azusur.com', 'AZSU810405RST', 'Tlalpan', NULL, '2870', 'Huipulco', 'Tlalpan', 'Ciudad de México', '14370', 'A un costado del hospital', 'Activo', '2025-12-01'),
(22, 'Cerámicas Confort', 'Paty Robles', 'DISTRIBUIDOR', '555-404-5050', '555-505-6060', 'info@cerconfort.com', 'CECF780808UVW', 'La Viga', '21', '1200', 'Michoacán', 'Iztacalco', 'Ciudad de México', '08830', 'Bodega 12', 'Activo', '2025-12-01'),
(23, 'Example', 'example', 'Materiales', '7571090640', '', 'exmple@gmail.com', '', '', '', '', 'Mirasol', '', '', '', '', 'ACTIVO', '2025-12-15');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol`
--

CREATE TABLE `rol` (
  `ID` int(11) NOT NULL,
  `DESCRIPCION` varchar(255) DEFAULT NULL,
  `NOMBREROL` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `rol`
--

INSERT INTO `rol` (`ID`, `DESCRIPCION`, `NOMBREROL`) VALUES
(1, 'Rol administrador', 'admin'),
(2, 'Rol usuario', 'user');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `ID` int(11) NOT NULL,
  `NOMBREUSUARIO` varchar(255) DEFAULT NULL,
  `CONTRASENIA` varchar(255) DEFAULT NULL,
  `fk_rol` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`ID`, `NOMBREUSUARIO`, `CONTRASENIA`, `fk_rol`) VALUES
(4, 'ALVARO', '12345', 1),
(5, 'Administrador', '123', 1),
(8, 'user', '123', 2),
(10, 'jose', '12334', 2),
(11, 'Vendedor', '123', 2),
(12, 'sara', '12334', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `venta`
--

CREATE TABLE `venta` (
  `id_venta` int(11) NOT NULL,
  `id_cliente` int(11) DEFAULT NULL,
  `fecha_venta` datetime DEFAULT current_timestamp(),
  `total` decimal(10,2) DEFAULT NULL,
  `monto_recibido` decimal(10,2) DEFAULT 0.00,
  `cambio` decimal(10,2) DEFAULT 0.00,
  `estado_pago` varchar(20) DEFAULT 'PENDIENTE'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `venta`
--

INSERT INTO `venta` (`id_venta`, `id_cliente`, `fecha_venta`, `total`, `monto_recibido`, `cambio`, `estado_pago`) VALUES
(1, 25, '2025-12-14 18:04:06', 1500.00, 0.00, 0.00, 'PENDIENTE'),
(2, 26, '2025-12-14 18:04:06', 2300.00, 0.00, 0.00, 'PENDIENTE'),
(4, 50, '2025-12-15 01:59:54', 600.00, 0.00, 0.00, 'PENDIENTE'),
(5, 50, '2025-12-15 02:07:23', 600.00, 0.00, 0.00, 'PENDIENTE'),
(6, 50, '2025-12-15 02:48:42', 300.00, 0.00, 0.00, 'PENDIENTE'),
(7, 50, '2025-12-15 02:51:01', 500.00, 0.00, 0.00, 'PENDIENTE'),
(8, 50, '2025-12-15 03:06:33', 1000.00, 2000.00, 1000.00, 'PAGADO'),
(9, 50, '2025-12-15 07:36:33', 1000.00, 2000.00, 1000.00, 'PAGADO'),
(11, 50, '2025-12-15 07:56:50', 1500.00, 0.00, 0.00, 'PENDIENTE'),
(12, 50, '2025-12-15 07:57:05', 600.00, 700.00, 100.00, 'PAGADO');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `venta_exitosa`
--

CREATE TABLE `venta_exitosa` (
  `ID_VENTA` int(11) NOT NULL,
  `CANTIDAD` int(11) DEFAULT NULL,
  `CODIGO_PRODUCTO` int(11) DEFAULT NULL,
  `DESCUENTO` int(11) DEFAULT NULL,
  `FECHA` datetime DEFAULT NULL,
  `NOMBRE_PRODUCTO` varchar(255) DEFAULT NULL,
  `PRECIO_UNITARIO` int(11) DEFAULT NULL,
  `TOTAL` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `categorias`
--
ALTER TABLE `categorias`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `detalle_pedido`
--
ALTER TABLE `detalle_pedido`
  ADD PRIMARY KEY (`id_detalle`),
  ADD KEY `id_pedido` (`id_pedido`),
  ADD KEY `id_producto` (`id_producto`);

--
-- Indices de la tabla `detalle_venta`
--
ALTER TABLE `detalle_venta`
  ADD PRIMARY KEY (`id_detalle`),
  ADD KEY `id_venta` (`id_venta`),
  ADD KEY `id_producto` (`id_producto`);

--
-- Indices de la tabla `informacion_empresa`
--
ALTER TABLE `informacion_empresa`
  ADD PRIMARY KEY (`id_empresa`);

--
-- Indices de la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD PRIMARY KEY (`id_pedido`),
  ADD KEY `id_cliente` (`id_cliente`);

--
-- Indices de la tabla `permiso_usuario`
--
ALTER TABLE `permiso_usuario`
  ADD PRIMARY KEY (`id_permiso`),
  ADD KEY `id_usuario` (`id_usuario`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`IDPRODUCTO`),
  ADD KEY `fk_categoria` (`fk_categoria`);

--
-- Indices de la tabla `proveedores`
--
ALTER TABLE `proveedores`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `rol`
--
ALTER TABLE `rol`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `fk_rol` (`fk_rol`);

--
-- Indices de la tabla `venta`
--
ALTER TABLE `venta`
  ADD PRIMARY KEY (`id_venta`),
  ADD KEY `id_cliente` (`id_cliente`);

--
-- Indices de la tabla `venta_exitosa`
--
ALTER TABLE `venta_exitosa`
  ADD PRIMARY KEY (`ID_VENTA`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `categorias`
--
ALTER TABLE `categorias`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `clientes`
--
ALTER TABLE `clientes`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=52;

--
-- AUTO_INCREMENT de la tabla `detalle_pedido`
--
ALTER TABLE `detalle_pedido`
  MODIFY `id_detalle` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `detalle_venta`
--
ALTER TABLE `detalle_venta`
  MODIFY `id_detalle` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `informacion_empresa`
--
ALTER TABLE `informacion_empresa`
  MODIFY `id_empresa` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `pedido`
--
ALTER TABLE `pedido`
  MODIFY `id_pedido` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `permiso_usuario`
--
ALTER TABLE `permiso_usuario`
  MODIFY `id_permiso` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=45;

--
-- AUTO_INCREMENT de la tabla `productos`
--
ALTER TABLE `productos`
  MODIFY `IDPRODUCTO` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `proveedores`
--
ALTER TABLE `proveedores`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT de la tabla `rol`
--
ALTER TABLE `rol`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `venta`
--
ALTER TABLE `venta`
  MODIFY `id_venta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `venta_exitosa`
--
ALTER TABLE `venta_exitosa`
  MODIFY `ID_VENTA` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `detalle_pedido`
--
ALTER TABLE `detalle_pedido`
  ADD CONSTRAINT `detalle_pedido_ibfk_1` FOREIGN KEY (`id_pedido`) REFERENCES `pedido` (`id_pedido`),
  ADD CONSTRAINT `detalle_pedido_ibfk_2` FOREIGN KEY (`id_producto`) REFERENCES `productos` (`IDPRODUCTO`);

--
-- Filtros para la tabla `detalle_venta`
--
ALTER TABLE `detalle_venta`
  ADD CONSTRAINT `detalle_venta_ibfk_1` FOREIGN KEY (`id_venta`) REFERENCES `venta` (`id_venta`) ON DELETE CASCADE,
  ADD CONSTRAINT `detalle_venta_ibfk_2` FOREIGN KEY (`id_producto`) REFERENCES `productos` (`IDPRODUCTO`);

--
-- Filtros para la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD CONSTRAINT `pedido_ibfk_1` FOREIGN KEY (`id_cliente`) REFERENCES `clientes` (`ID`);

--
-- Filtros para la tabla `permiso_usuario`
--
ALTER TABLE `permiso_usuario`
  ADD CONSTRAINT `permiso_usuario_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`ID`);

--
-- Filtros para la tabla `productos`
--
ALTER TABLE `productos`
  ADD CONSTRAINT `productos_ibfk_1` FOREIGN KEY (`fk_categoria`) REFERENCES `categorias` (`ID`);

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`fk_rol`) REFERENCES `rol` (`ID`);

--
-- Filtros para la tabla `venta`
--
ALTER TABLE `venta`
  ADD CONSTRAINT `venta_ibfk_1` FOREIGN KEY (`id_cliente`) REFERENCES `clientes` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
