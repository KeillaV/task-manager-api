# Requisitos Funcionais

## 1. Introdução
Este documento descreve os requisitos funcionais do sistema Task Manager, uma aplicação pessoal para gerenciamento de tarefas.
O sistema será utilizado inicialmente por um único usuário.

## 2. Escopo
O sistema permitirá:

- criação e gerenciamento de tarefas;
- organização por status e categorias;
- acompanhamento de status das tarefas;
- registro de histórico de alteração de tarefas;


## 3. Requisitos Funcionais

### RF-001 - Criar tarefa

**Descrição**
O sistema deve permitir ao usuário a criação de tarefas

**Dados obrigatórios**
- Título

**Dados opcionais**
- Descrição
- Categoria
- Prazo
- Prioridade

**Critérios de aceitação**
- O título inserido deve possuir mais de 2 caracteres
- O título inserido não pode ser igual ao de uma tarefa já existente
- A tarefa deve iniciar com status BACKLOG

### RF-002 - Atualizar dados da tarefa

**Descrição**
O sistema deve permitir a atualização de dados relacionados a tarefa

**Dados passíveis de atualização**
- Título
- Descrição
- Categoria
- Prazo
- Prioridade
- Status

**Critérios de aceitação**
- O título atualizado deve possuir mais de 2 caracteres
- A categoria só pode ser atualizada para uma existente no sistema
- A data de prazo atualizada não pode ser anterior à data atual

### RF-003 - Atualizar status da tarefa

**Descrição**
O sistema deve permitir a atualização do status da tarefa

**Critérios de aceitação**
- Só deve ser permitido alterar o status para um dos status disponíveis
- Uma tarefa cancelada não pode ser atualizada diretamente para finalizada

### RF-004 - Buscar e filtrar tarefa
**Descrição**
**Critérios de aceitação**

### RF-005 - Excluir tarefa
**Descrição**
**Critérios de aceitação**

### RF-006 - Criar categoria
**Descrição**
**Critérios de aceitação**

### RF-007 - Atualizar dados de categoria
**Descrição**
**Critérios de aceitação**

### RF-008 - Excluir categoria
**Descrição**
**Critérios de aceitação**

### RF-009 - Acessar histórico de alterações de tarefa
**Descrição**
**Critérios de aceitação**


## 4. Regras de Negócio

### RN-001
Toda tarefa deve possuir um título e iniciar com status backlog

### RN-002

## 5. Histórico de alterações
