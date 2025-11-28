-- phpMyAdmin SQL Dump
-- version 5.2.3
-- https://www.phpmyadmin.net/
--
-- Host: mysql_container
-- Tempo de geração: 28/11/2025 às 15:07
-- Versão do servidor: 8.0.44
-- Versão do PHP: 8.3.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `lavatechdb`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `Agendamento`
--

CREATE TABLE `Agendamento` (
  `id` int NOT NULL,
  `dataHora` datetime NOT NULL,
  `status` varchar(50) NOT NULL,
  `cliente_id` int DEFAULT NULL,
  `veiculo_id` int DEFAULT NULL,
  `funcionario_id` int DEFAULT NULL,
  `servico_id` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Despejando dados para a tabela `Agendamento`
--

INSERT INTO `Agendamento` (`id`, `dataHora`, `status`, `cliente_id`, `veiculo_id`, `funcionario_id`, `servico_id`) VALUES
(1, '2025-10-02 10:00:00', 'Agendado', 1, 1, 1, 1),
(2, '2025-10-03 14:00:00', 'Agendado', 2, 2, 2, 2),
(3, '2025-10-04 09:30:00', 'Agendado', 3, 3, 3, 3);

-- --------------------------------------------------------

--
-- Estrutura para tabela `Cliente`
--

CREATE TABLE `Cliente` (
  `id` int NOT NULL,
  `nome` varchar(255) NOT NULL,
  `telefone` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Despejando dados para a tabela `Cliente`
--

INSERT INTO `Cliente` (`id`, `nome`, `telefone`) VALUES
(1, 'Julio Ferreira', '(51) 91234-5678'),
(2, 'Gabriel dos Santos', '(21) 98765-4321'),
(3, 'Pedro Gabriel', '(31) 99876-5432');

-- --------------------------------------------------------

--
-- Estrutura para tabela `Funcionario`
--

CREATE TABLE `Funcionario` (
  `id` int NOT NULL,
  `nome` varchar(255) NOT NULL,
  `cargo` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Despejando dados para a tabela `Funcionario`
--

INSERT INTO `Funcionario` (`id`, `nome`, `cargo`) VALUES
(1, 'Carla Pinheiro', 'Atendente'),
(2, 'Fernando Vieira', 'Técnico'),
(3, 'Kaio Silva', 'Gerente');

-- --------------------------------------------------------

--
-- Estrutura para tabela `Servico`
--

CREATE TABLE `Servico` (
  `id` int NOT NULL,
  `nome` varchar(255) NOT NULL,
  `descricao` text,
  `preco` float NOT NULL,
  `duracaoEstimadaMin` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Despejando dados para a tabela `Servico`
--

INSERT INTO `Servico` (`id`, `nome`, `descricao`, `preco`, `duracaoEstimadaMin`) VALUES
(1, 'Lavagem Completa', 'Lavagem externa e interna do veículo.', 50, 60),
(2, 'Polimento', 'Polimento da pintura do veículo para remoção de riscos.', 100, 90),
(3, 'Troca de Óleo', 'Troca do óleo do motor do veículo.', 150, 30);

-- --------------------------------------------------------

--
-- Estrutura para tabela `Usuario`
--

CREATE TABLE `Usuario` (
  `id` int NOT NULL,
  `nome` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `senhaHash` varchar(260) NOT NULL,
  `isAdmin` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Despejando dados para a tabela `Usuario`
--

INSERT INTO `Usuario` (`id`, `nome`, `email`, `senhaHash`, `isAdmin`) VALUES
(1, 'admin', 'admin@lavatech.com', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', 1),
(2, 'Gabriel Monteiro', 'gabriel@lavatech.com', 'd404559f602eab6fd602c8386c3f07a6d7a3e4f2f3d6a8a0f4b2e6a8e6f7b1e7', 0),
(3, 'Pedro França', 'pedro@lavatech.com', 'd404559f602eab6fd602c8386c3f07a6d7a3e4f2f3d6a8a0f4b2e6a8e6f7b1e7', 0),
(4, 'Admin Principal', 'admin.principal@lavatech.com', '0192023a7bbd73250516f069df18b500c8b1e0e985e6b1e1b6db1bcb0d3a1a3c', 1);

-- --------------------------------------------------------

--
-- Estrutura para tabela `Veiculo`
--

CREATE TABLE `Veiculo` (
  `id` int NOT NULL,
  `placa` varchar(10) NOT NULL,
  `marca` varchar(50) NOT NULL,
  `modelo` varchar(50) NOT NULL,
  `cor` varchar(20) NOT NULL,
  `ano` int NOT NULL,
  `cliente_id` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Despejando dados para a tabela `Veiculo`
--

INSERT INTO `Veiculo` (`id`, `placa`, `marca`, `modelo`, `cor`, `ano`, `cliente_id`) VALUES
(1, 'ABC-1234', 'Fiat', 'Palio', 'Preto', 2018, 1),
(2, 'XYZ-5678', 'Volkswagen', 'Gol', 'Branco', 2020, 2),
(3, 'JKL-9101', 'Chevrolet', 'Onix', 'Azul', 2022, 3);

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `Agendamento`
--
ALTER TABLE `Agendamento`
  ADD PRIMARY KEY (`id`),
  ADD KEY `cliente_id` (`cliente_id`),
  ADD KEY `veiculo_id` (`veiculo_id`),
  ADD KEY `funcionario_id` (`funcionario_id`),
  ADD KEY `servico_id` (`servico_id`);

--
-- Índices de tabela `Cliente`
--
ALTER TABLE `Cliente`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `Funcionario`
--
ALTER TABLE `Funcionario`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `Servico`
--
ALTER TABLE `Servico`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `Usuario`
--
ALTER TABLE `Usuario`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Índices de tabela `Veiculo`
--
ALTER TABLE `Veiculo`
  ADD PRIMARY KEY (`id`),
  ADD KEY `cliente_id` (`cliente_id`);

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `Agendamento`
--
ALTER TABLE `Agendamento`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `Cliente`
--
ALTER TABLE `Cliente`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `Funcionario`
--
ALTER TABLE `Funcionario`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `Servico`
--
ALTER TABLE `Servico`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `Usuario`
--
ALTER TABLE `Usuario`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de tabela `Veiculo`
--
ALTER TABLE `Veiculo`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Restrições para tabelas despejadas
--

--
-- Restrições para tabelas `Agendamento`
--
ALTER TABLE `Agendamento`
  ADD CONSTRAINT `Agendamento_ibfk_1` FOREIGN KEY (`cliente_id`) REFERENCES `Cliente` (`id`),
  ADD CONSTRAINT `Agendamento_ibfk_2` FOREIGN KEY (`veiculo_id`) REFERENCES `Veiculo` (`id`),
  ADD CONSTRAINT `Agendamento_ibfk_3` FOREIGN KEY (`funcionario_id`) REFERENCES `Funcionario` (`id`),
  ADD CONSTRAINT `Agendamento_ibfk_4` FOREIGN KEY (`servico_id`) REFERENCES `Servico` (`id`);

--
-- Restrições para tabelas `Veiculo`
--
ALTER TABLE `Veiculo`
  ADD CONSTRAINT `Veiculo_ibfk_1` FOREIGN KEY (`cliente_id`) REFERENCES `Cliente` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
