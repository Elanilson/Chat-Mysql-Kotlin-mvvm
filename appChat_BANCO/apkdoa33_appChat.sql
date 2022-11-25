-- phpMyAdmin SQL Dump
-- version 4.9.7
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Tempo de geração: 25/11/2022 às 18:10
-- Versão do servidor: 5.7.23-23
-- Versão do PHP: 7.4.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `apkdoa33_appChat`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `conversas`
--

CREATE TABLE `conversas` (
  `id` int(11) NOT NULL,
  `idUsuario` int(11) DEFAULT NULL,
  `data_create` timestamp NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Despejando dados para a tabela `conversas`
--

INSERT INTO `conversas` (`id`, `idUsuario`, `data_create`) VALUES
(1, 1, '2022-11-24 13:54:55'),
(2, 3, '2022-11-24 17:11:47'),
(3, 5, '2022-11-24 17:11:47');

-- --------------------------------------------------------

--
-- Estrutura para tabela `mensagens`
--

CREATE TABLE `mensagens` (
  `id` int(11) NOT NULL,
  `idConversa` int(11) NOT NULL,
  `idUsuario` int(11) DEFAULT NULL,
  `texto` text COLLATE utf8_unicode_ci,
  `data_create` timestamp NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Despejando dados para a tabela `mensagens`
--

INSERT INTO `mensagens` (`id`, `idConversa`, `idUsuario`, `texto`, `data_create`) VALUES
(1, 1, 1, 'oi?', '2022-11-25 21:06:46'),
(2, 1, 5, 'oi! Tudo!', '2022-11-25 21:06:59'),
(3, 1, 1, 'Ola, Mundo.', '2022-11-25 21:07:25'),
(4, 1, 5, 'yes', '2022-11-25 21:07:31'),
(5, 1, 5, 'kotlin mvvm', '2022-11-25 21:07:55'),
(6, 1, 1, 'kotlin mvp', '2022-11-25 21:08:02');

-- --------------------------------------------------------

--
-- Estrutura para tabela `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL,
  `idConversa` int(11) NOT NULL,
  `imagem` text,
  `nome` varchar(150) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Despejando dados para a tabela `usuarios`
--

INSERT INTO `usuarios` (`id`, `idConversa`, `imagem`, `nome`) VALUES
(1, 5, 'https://avatars.githubusercontent.com/u/54327522?v=4', 'Elanilson de Jesus'),
(2, 2, 'https://imagenswhatsapp.blog.br/wp-content/uploads/2021/10/fotos-para-perfil-whatsapp-gratis-564x500.jpg', 'Rafaela MT'),
(3, 3, 'https://i.ytimg.com/vi/-AMbVaYtwcE/maxresdefault.jpg', 'Joao Afonso'),
(4, 4, 'https://gr3web.com.br/wp-content/uploads/2022/07/Fotos-para-homem-perfil-de-WhatsApp-02.jpg', 'Tiago Silva'),
(5, 5, 'https://thumbs.dreamstime.com/b/ilustra%C3%A7%C3%A3o-masculina-do-vetor-da-pessoa-dos-desenhos-animados-retrato-cara-car%C3%A1ter-afro-novo-avatar-homem-100786112.jpg', 'Pedrinho'),
(6, 6, 'https://t1.pb.ltmcdn.com/pt/posts/5/3/3/a_psicologia_das_cores_nas_fotos_de_perfil_335_1_600.jpg', 'Marcela');

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `conversas`
--
ALTER TABLE `conversas`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `mensagens`
--
ALTER TABLE `mensagens`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `conversas`
--
ALTER TABLE `conversas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `mensagens`
--
ALTER TABLE `mensagens`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de tabela `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
