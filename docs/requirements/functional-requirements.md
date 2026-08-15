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

**Descrição:**
O sistema deve permitir ao usuário a criação de tarefas

**Dados obrigatórios:**
- Título

**Dados opcionais:**
- Descrição
- Categoria
- Prazo
- Prioridade

**Critérios de aceitação:**
- O título inserido deve possuir mais de 2 caracteres
- O título inserido não pode ser igual ao de uma tarefa já existente
- A tarefa deve iniciar com status BACKLOG

### RF-002 - Atualizar dados da tarefa

**Descrição:**
O usuário pode atualizar dados relacionados a tarefa

**Dados passíveis de atualização:**
- Título
- Descrição
- Categoria
- Prazo
- Prioridade
- Status

**Critérios de aceitação:**
- O título atualizado deve possuir mais de 2 caracteres
- A categoria só pode ser atualizada para uma existente no sistema
- A data de prazo atualizada não pode ser anterior à data atual

### RF-003 - Atualizar status da tarefa

**Descrição:**
O usuário pode atualizar o status da tarefa

**Critérios de aceitação:**
- Só deve ser permitido alterar o status para um dos status disponíveis
- Uma tarefa cancelada não pode ser atualizada diretamente para finalizada

### RF-004 - Buscar e filtrar tarefa
**Descrição:**
O sistema deve permitir que o usuário consulte a lista de tarefas existentes, podendo filtrar por título, status e categoria

### RF-005 - Excluir tarefa
**Descrição:**
O usuário pode excluir uma tarefa

**Critérios de aceitação:**
- A tarefa a ser excluída deve existir
- Ao excluir a tarefa, o usuário não terá mais acesso aos dados dela

### RF-006 - Criar categoria
**Descrição:**
O usuário pode criar categorias para organizar melhor suas tarefas

**Dados obrigatórios:**
- Título

**Dados opcionais:**
- Descrição

**Critérios de aceitação:**
- O título deve possuir mais de 2 caracteres
- A categoria criada deve aparecer na listagem de categorias

### RF-007 - Atualizar dados de categoria
**Descrição:**
O usuário pode atualizar dados de uma categoria existente

**Dados passíveis de atualização:**
- Título
- Categoria

**Critérios de aceitação**
- O título atualizado deve possuir mais de 2 caracteres
- A atualização deve refletir em todas as tarefas que possuam essa categoria

### RF-008 - Listar categorias
**Descrição:**
O sistema deve permitir que o usuário consulte a lista de categorias existentes, para que possa atribuir uma categoria a uma tarefa

### RF-009 - Excluir categoria
**Descrição**
O usuário pode excluir uma categoria existente

**Critérios de aceitação**
- A categoria a ser excluída deve existir
- Ao excluir a categoria, as tarefas que possuem a categoria excluída devem ter suas referências à ela removidas

### RF-010 - Acessar histórico de alterações de tarefa
**Descrição**
O usuário pode acessar o histórico de alterações realizadas em uma tarefa, tais como: mudança de título, alteração de status, atribuição de categoria, etc

**Critérios de aceitação**
- O histórico será apresentado em forma de lista, organizada de forma decrescente de acordo com a data e horário das alterações
- O histórico deve apresentar: alvo da alteração, valor anterior, valor atualizado e data/horário da atualização
- O usuário não pode realizar alterações no histórico, somente consultá-lo


## 4. Regras de Negócio

### RN-001
Toda tarefa deve possuir um título e iniciar com status backlog

### RN-002
Toda alteração na tarefa gera um registro de alteração para histórico

### RN-003
As tarefas podem ser filtradas por: título, status, categoria

### RN-004
O status da tarefa pode ser alterado seguindo a regra:
- BACKLOG -> ON PROGRESS / CANCELLED
- ON PROGRESS -> BACKLOG / DONE / CANCELLED
- DONE -> não pode ter alteração de status
- CANCELLED -> não póde ter alteração de status

### RN-005
O sistema deve sinalizar ao usuário quando o prazo de uma tarefa ON PROGRESS estiver próximo de ser atingido

### RN-006
O sistema deve sinalizar ao usuário quando o prazo de uma tarefa ON PROGRESS ultrapassar a data estimada sem que haja nova atualização de status 


## 5. Histórico de alterações
2026-08-15: Versão completa inicial de requisitos
