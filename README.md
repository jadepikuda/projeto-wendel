# 😈 GESTÃO DE FILAS - FIM DO DESCONFORTO 😈

Este é um sistema interativo desenvolvido em **Java** com interface gráfica via `JOptionPane` (customizada com o tema Nimbus em estilo Roxo/Neon). O objetivo do projeto é gerenciar de forma eficiente uma fila de atendimento hospitalar, integrando o cadastro de pacientes e médicos plantonistas.

## 📝 Proposta do Sistema
O sistema simula o fluxo de um pronto-socorro ou clínica, permitindo organizar a fila de espera por prioridade de atendimento, registrar quais médicos estão trabalhando no plantão e listar o andamento da fila em tempo real, tudo com validações para evitar erros de dados vazios ou formatos inválidos.

---

## ⚙️ Requisitos Funcionais (RF)

* **RF01 (Cadastrar Paciente):** O sistema deve permitir cadastrar um paciente informando Nome, ID (apenas números) e Tipo de Prioridade (Alta / Normal), inserindo-o na fila de atendimento.
* **RF02 (Cadastrar Médico):** O sistema deve permitir registrar um médico de plantão informando Nome, CRM/ID e Especialidade.
* **RF03 (Visualizar Próximo):** O sistema deve exibir quem é a próxima pessoa (seja paciente ou médico) a ser atendida na fila, sem removê-la da lista.
* **RF04 (Listar Todos):** O sistema deve gerar um relatório visual com a lista atualizada de todas as pessoas que estão aguardando na fila.
* **RF05 (Tratamento de Erros):** O sistema deve validar as entradas de dados e disparar alertas caso o usuário tente cadastrar campos vazios ou letras no lugar de números.

---

## 🛠️ Conceitos de Programação Aplicados (Java)
Este projeto foi estruturado utilizando conceitos fundamentais de Programação Orientada a Objetos (POO):
* **Abstração e Herança:** A classe abstrata `Pessoa` serve de base para as classes específicas `Paciente` e `Medico`.
* **Polimorfismo:** Uso do método sobrescrito (`@Override`) `getDadosIdentificacao()` para exibir os dados corretos de cada tipo de pessoa na fila.
* **Tratamento de Exceções Customizadas:** Criação da classe `ValidacaoException` para interceptar e tratar erros de preenchimento de formulário.

---

## 🚀 Como Executar o Projeto

### Pré-requisitos
* Ter o **Java JDK** instalado (versão 8 ou superior).
* Uma IDE como IntelliJ IDEA, Eclipse ou NetBeans (opcional).

### Passo a Passo
1. Faça o download ou clone este repositório.
2. Abra os arquivos dentro do pacote/pasta `projeto` na sua IDE favorita.
3. Execute a classe `Main.java`.
4. Uma janela interativa roxa se abrirá na sua tela. Basta digitar o número da opção desejada!

---

## 🧑‍💻 Autoras
* Yasmin Viturino - https://github.com/Purplesugar-HTML
* Ana Lívia - https://github.com/jadepikuda
