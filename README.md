#  Biblioteca Digital — Projeto P2

Sistema de gerenciamento de biblioteca digital desenvolvido em **Java 21** para a disciplina de **Estruturas de Dados** do curso de **Análise e Desenvolvimento de Sistemas (ADS) — Fatec Carapicuíba**.

O projeto aplica três estruturas de dados — **lista duplamente encadeada**, **fila genérica** e **tabela hash** — em um cenário real de biblioteca, integrando-as em um sistema funcional com menu de console.

---

##  Estrutura do Projeto

```
biblioteca/
│
├── ── ETAPA 1 — Classes de Domínio e Lista Duplamente Encadeada ──
│
├── Livro.java                 # 1.1  Classe de domínio (ISBN, título, autor, ano, disponível)
├── Usuario.java               # 1.2  Classe de domínio (matrícula, nome, email)
├── NoDuplo.java               # 1.3  Nó da lista dupla (tipo concreto Livro)
├── ListaDupla.java            # 1.3  Lista duplamente encadeada com navegação bidirecional
├── TesteEtapa1.java           #      Programa de teste da Etapa 1
│
├── ── ETAPA 2 — Fila Genérica e Gestão de Empréstimos ──
│
├── No.java                    # 2.1  Nó genérico No<T>
├── Fila.java                  # 2.2  Fila genérica (FIFO) com No<T>
├── FilaVaziaException.java    # 2.2  Exceção ao desenfileirar fila vazia
├── GestorEmprestimos.java     # 2.3  Coordena empréstimos e filas de espera
├── TesteEtapa2.java           #      Programa de teste da Etapa 2
│
├── ── ETAPA 3 — Tabela Hash e Catálogo Indexado ──
│
├── Entrada.java               # 3.1  Par chave-valor com encadeamento (colisões)
├── NossoHash.java             # 3.2  Tabela hash genérica (capacidade 16, encadeamento externo)
├── Catalogo.java              # 3.3  Catálogo de livros indexado por ISBN
├── TesteEtapa3.java           #      Programa de teste da Etapa 3
│
├── ── INTEGRAÇÃO FINAL ──
│
├── BibliotecaDigital.java     # 3.4  Sistema completo com menu de console
└── README.md
```

---

##  Pré-requisitos

- **Java JDK 17+** (testado com OpenJDK 21)

Verifique a instalação:

```bash
java -version
javac -version
```

---

##  Como Compilar e Executar

### 1. Clone o repositório

```bash
git clone https://github.com/adsonlima98/projeto_p2_machion.git
```

### 2. Compile todos os arquivos

```bash
javac *.java
```

### 3. Execute os testes por etapa

```bash
java TesteEtapa1    # Lista duplamente encadeada
java TesteEtapa2    # Fila genérica + empréstimos
java TesteEtapa3    # Tabela hash + catálogo
```

### 4. Execute o sistema completo (menu interativo)

```bash
java BibliotecaDigital
```

---

##  Detalhamento das Etapas

### Etapa 1 — Classes de Domínio e Lista Duplamente Encadeada

| Subetapa | Arquivo | Descrição |
|----------|---------|-----------|
| 1.1 | `Livro.java` | Atributos privados (`isbn`, `titulo`, `autor`, `anoPub`, `disponivel`). Construtor inicia `disponivel = true`. Métodos `toString()` no formato `[ISBN] Titulo - Autor (Ano) [STATUS]` e `equals()` por ISBN. |
| 1.2 | `Usuario.java` | Atributos `matricula`, `nome`, `email`. Construtor completo, getters, setter para email, `toString()`, `equals()` por matrícula. |
| 1.3 | `NoDuplo.java` | Nó com `Livro info`, ponteiros `proximo` e `anterior`. Tipo concreto (sem genéricos). |
| 1.3 | `ListaDupla.java` | `insereInicio`, `insereFim`, `removePrimeiro`, `removeUltimo`, `buscarPorIsbn`, `listarDoInicio`, `listarDoFim`, `tamanho`. |

**O que o teste demonstra:** inserções mistas (início/fim), navegação nos dois sentidos, busca por ISBN existente e inexistente, `equals` entre livros, remoções sequenciais até a lista vazia.

---

### Etapa 2 — Fila Genérica e Gestão de Empréstimos

| Subetapa | Arquivo | Descrição |
|----------|---------|-----------|
| 2.1 | `No.java` | Nó genérico `No<T>` com `info` e `proximo`. |
| 2.2 | `Fila.java` | Fila FIFO com `enfileira`, `desenfileira` (lança `FilaVaziaException`), `primeiro`, `filaVazia`, `tamanho`, `toString` no formato `[A]->[B]->[C]->\\`. Ao esvaziar, atribui `null` a `ultimo` para evitar memory leak. |
| 2.2 | `FilaVaziaException.java` | `RuntimeException` lançada ao desenfileirar fila vazia. |
| 2.3 | `GestorEmprestimos.java` | Usa `NossoHash<String, Fila<Usuario>>` internamente. Métodos: `solicitarEmprestimo` (empresta ou enfileira), `devolverLivro` (devolve com atendimento automático do próximo), `listarFilaDeEspera`. |

**O que o teste demonstra:** operações básicas da fila genérica, cenário completo de empréstimo → fila de espera → devolução com atendimento automático → devolução com fila vazia.

---

### Etapa 3 — Tabela Hash e Catálogo Indexado

| Subetapa | Arquivo | Descrição |
|----------|---------|-----------|
| 3.1 | `Entrada.java` | Par `(key, value)` com `proximo` para encadeamento em colisões. |
| 3.2 | `NossoHash.java` | Array de `Entrada<K,V>[]` com capacidade 16. Função hash: `Math.abs(key.hashCode()) % capacidade`. Inserção no início da cadeia. Métodos: `put`, `get`, `containsKey`, `containsValue` (varredura completa — o hash é calculado sobre a chave, não o valor), `exibeMap`. |
| 3.3 | `Catalogo.java` | Encapsula `NossoHash<String, Livro>`. Métodos: `cadastrar`, `buscar`, `existe`, `exibirCatalogo`. |

**O que o teste demonstra:** `put`/`get` com tipos simples, chave repetida (novo valor à frente da cadeia), `containsKey`/`containsValue`, visualização do `exibeMap` mostrando colisões reais, e o `Catalogo` com livros.

---

### Integração Final (3.4) — `BibliotecaDigital.java`

O sistema completo integra as três estruturas simultaneamente:

| Estrutura | Papel no sistema |
|-----------|-----------------|
| `Catalogo` (`NossoHash`) | Localização instantânea de livros por ISBN (O(1) amortizado) |
| `ListaDupla` | Acervo navegável — inserção, remoção, listagem nos dois sentidos |
| `GestorEmprestimos` (`Fila<Usuario>`) | Gerencia fila de espera por livro (FIFO) |

**Menu de console:**

```
1 - Cadastrar livro
2 - Buscar livro por ISBN
3 - Listar acervo do inicio ao fim
4 - Listar acervo do fim ao inicio
5 - Solicitar emprestimo (usuario + ISBN)
6 - Devolver livro (ISBN)
7 - Ver fila de espera de um livro
0 - Sair
```

---

##  Conexão com o Projeto I

No Projeto I, `VetorDinamico` e `PilhaProcesso` eram estruturas de tipo concreto que precisavam ser reescritas para cada tipo de dado. Este Projeto II resolve isso com **genéricos**: `No<T>`, `Fila<T>`, `NossoHash<K,V>` e `Entrada<K,V>` funcionam para qualquer tipo, eliminando duplicação de código. A `ListaDupla` foi mantida com tipo concreto `Livro` de propósito para consolidar a diferença prática.

---

## Autores

| Nome | RA |
|------|-----|
| Adson Lima de Jesus | 1430482511035 |
| Mariana Borgato dos Anjos | 1430482511046 |
| Pedro Henrique Vendite Manoel | 1430482511040 |
| Pietro Zonta Vieira | 1430482511007 |
| Vyctoria Karina da Silva | 1430482613042 |

**ADS — Fatec Carapicuíba | 3º Semestre | 2026**
