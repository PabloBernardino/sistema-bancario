# 💰 Sistema Bancário em Java

Projeto desenvolvido para praticar lógica de programação, estruturas de repetição, vetores, validações e manipulação de dados utilizando Java.

## 📋 Descrição

O Sistema Bancário é uma aplicação de console desenvolvida em Java que permite simular operações básicas de uma conta bancária.

O sistema possibilita:

* Criar contas bancárias
* Realizar login
* Depositar dinheiro
* Sacar dinheiro
* Transferir valores entre contas
* Consultar extrato
* Realizar logout

Todos os dados são armazenados temporariamente em memória utilizando vetores.

---

## 🚀 Funcionalidades

### Cadastro de Conta

* Cadastro de nome, e-mail e senha
* Validação de e-mail duplicado
* Limite máximo de contas cadastradas

### Login

* Autenticação por e-mail e senha
* Controle de sessão do usuário logado

### Depósito

* Adição de saldo na conta
* Validação de valores inválidos

### Saque

* Saque de valores da conta
* Verificação de saldo insuficiente

### Transferência

* Transferência entre contas
* Busca por e-mail do destinatário
* Validação de saldo
* Impede transferência para a própria conta
* Confirmação antes da transferência

### Extrato

* Exibição de:

    * Nome do titular
    * E-mail
    * Saldo atual
    * Status da conta

### Logout

* Encerramento da sessão do usuário

---

## 🛠️ Tecnologias Utilizadas

* Java
* Scanner
* Arrays (Vetores)
* Estruturas de Repetição
* Estruturas Condicionais
* Métodos

---

## 📚 Conceitos Praticados

Durante o desenvolvimento deste projeto foram praticados os seguintes conceitos:

* Variáveis
* Constantes
* Vetores
* Métodos
* Loops (for e do-while)
* Condições (if/else)
* Switch Case
* Validação de dados
* Organização de código
* Simulação de autenticação

---

## ▶️ Como Executar

1. Clone o repositório:

```bash
git clone https://github.com/SEU-USUARIO/sistema-bancario-java.git
```

2. Abra o projeto em sua IDE favorita.

3. Execute a classe:

```java
SistemaBancario.java
```

4. Utilize o menu para navegar pelo sistema.

---

## 📷 Exemplo do Menu

```text
================================
SISTEMA BANCÁRIO
================================

Usuário logado: Nenhum

1 - Criar conta
2 - Login
3 - Depositar
4 - Sacar
5 - Transferir
6 - Extrato
7 - Logout
0 - Sair
```

---

## 🎯 Objetivo do Projeto

Este projeto foi desenvolvido com fins educacionais para fortalecer a base em Java antes da utilização de Orientação a Objetos, Collections, Banco de Dados e Frameworks como Spring Boot.

---

## 🔮 Próximas Melhorias

* Implementação de Orientação a Objetos
* Classe Conta
* Histórico de transações
* Persistência em arquivo
* Integração com banco de dados
* Interface gráfica com JavaFX
* API REST com Spring Boot

---

## 👨‍💻 Autor

Desenvolvido por Pablo Bernardino.

Projeto criado para estudos e evolução na área de Desenvolvimento Java.
