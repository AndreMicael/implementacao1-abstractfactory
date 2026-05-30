# GUI - Abstract Factory em Java

Projeto Java orientado a objetos que demonstra o padrao de projeto **Abstract Factory** (Fabrica Abstrata) usando um exemplo de interface grafica (GUI).

O objetivo e criar familias de componentes visuais relacionados (botao e checkbox) sem acoplar o codigo cliente as classes concretas (`WindowsButton`, `MacCheckbox`, etc.). A escolha entre **Windows** e **Mac** e feita por meio de fabricas concretas que implementam uma interface comum.

---

## O que e o padrao Abstract Factory?

O **Abstract Factory** fornece uma interface para criar familias de objetos relacionados, sem especificar suas classes concretas.

Neste projeto:

| Papel | Interface / Classe |
| --- | --- |
| Fabrica abstrata | `GUIFactory` |
| Fabricas concretas | `WindowsFactory`, `MacFactory` |
| Produtos abstratos | `Button`, `Checkbox` |
| Produtos concretos (Windows) | `WindowsButton`, `WindowsCheckbox` |
| Produtos concretos (Mac) | `MacButton`, `MacCheckbox` |
| Cliente | `Application` |

### Beneficio principal

A classe `Application` (cliente) **nao instancia** `WindowsButton`, `MacCheckbox` ou qualquer produto concreto. Ela recebe apenas um `GUIFactory` e chama:

- `createButton()`
- `createCheckbox()`

Assim, a criacao dos objetos fica isolada nas fabricas, respeitando o principio de **criacao sem depender de classes concretas**.

---

## Estrutura do projeto

```text
Implementacao java/
|-- README.md
|-- executar.ps1
|-- out/
`-- src/main/java/abstractfactory/
    |-- Main.java
    |-- Application.java
    |-- Plataforma.java
    |-- factory/
    |   |-- GUIFactory.java
    |   |-- WindowsFactory.java
    |   |-- MacFactory.java
    |   `-- GUIFactoryProvider.java
    `-- products/
        |-- Button.java
        |-- Checkbox.java
        |-- windows/
        |   |-- WindowsButton.java
        |   `-- WindowsCheckbox.java
        `-- mac/
            |-- MacButton.java
            `-- MacCheckbox.java
```

---

## Fluxo de execucao

```text
Main
  |
  +-- resolve plataforma (argumento ou deteccao automatica)
  |
  +-- GUIFactoryProvider.obterFabrica(plataforma)
  |         |
  |         +-- WindowsFactory (se windows)
  |         `-- MacFactory     (se mac)
  |
  `-- new Application(factory)
            |
            +-- factory.createButton()
            +-- factory.createCheckbox()
            `-- app.render()
```

---

## Requisitos

- Java JDK 17 ou superior
- Terminal com `javac` e `java` no PATH

Verifique a instalacao:

```powershell
java -version
javac -version
```

---

## Como rodar

### Opcao 1 - Script automatico (recomendado)

```powershell
cd "C:\Users\andre\Desktop\Implementacao java"

# Detecta o SO automaticamente
.\executar.ps1

# Windows (explicito)
.\executar.ps1 windows

# Mac (explicito)
.\executar.ps1 mac
```

### Opcao 2 - Compilacao e execucao manual

```powershell
cd "C:\Users\andre\Desktop\Implementacao java"

javac -encoding UTF-8 -d out (Get-ChildItem -Recurse -Filter *.java src\main\java | ForEach-Object { $_.FullName })

java "-Dfile.encoding=UTF-8" -cp out abstractfactory.Main windows
java "-Dfile.encoding=UTF-8" -cp out abstractfactory.Main mac
java "-Dfile.encoding=UTF-8" -cp out abstractfactory.Main
```

Sem argumento, o programa **detecta o sistema operacional** automaticamente via `System.getProperty("os.name")`.

> **Importante:** use `-encoding UTF-8` na compilacao para evitar erros de encoding no Windows.

---

## Saida esperada

### Windows

```text
Interface Windows:
Renderizando botao do Windows
Renderizando checkbox do Windows
```

### Mac

```text
Interface Mac:
Renderizando botao do Mac
Renderizando checkbox do Mac
```

### Argumento invalido

```text
Erro: Plataforma invalida: 'linux'. Use: windows ou mac.
Uso: java abstractfactory.Main [windows|mac]
```

---

## Descricao das classes

### Main

Classe principal. Le o argumento da linha de comando (`windows` ou `mac`), obtem a fabrica via `GUIFactoryProvider` e delega a renderizacao para `Application`.

Se nenhum argumento for passado, **detecta o SO automaticamente**.

### Application (cliente)

Recebe um `GUIFactory` no construtor e usa a fabrica para criar botao e checkbox. O metodo `render()` chama `paint()` em cada componente.

### GUIFactory (fabrica abstrata)

Interface que define os metodos de criacao:

```java
Button createButton();
Checkbox createCheckbox();
```

### WindowsFactory / MacFactory

Fabricas concretas. Cada uma retorna uma familia consistente de componentes:

| Fabrica | Botao | Checkbox |
| --- | --- | --- |
| `WindowsFactory` | `WindowsButton` | `WindowsCheckbox` |
| `MacFactory` | `MacButton` | `MacCheckbox` |

### GUIFactoryProvider

Centraliza a escolha da fabrica concreta com base no enum `Plataforma`. Evita que `Main` conheca `WindowsFactory` e `MacFactory` diretamente.

### Plataforma

Enum com os valores `WINDOWS` e `MAC`. Possui:

- `from(String)` — valida o argumento da linha de comando
- `detectarSistema()` — le `System.getProperty("os.name")` para escolher a plataforma

### Button e Checkbox (produtos abstratos)

Interfaces que definem o comportamento comum dos componentes. Todas as implementacoes concretas possuem o metodo `paint()`, que exibe a renderizacao no console.

---

## Como estender o projeto

Para adicionar uma nova familia de interface (ex.: **Linux**):

1. Criar produtos concretos em `products/linux/` (ex.: `LinuxButton`, `LinuxCheckbox`)
2. Criar `LinuxFactory` implementando `GUIFactory`
3. Adicionar `LINUX` no enum `Plataforma`
4. Incluir o novo case em `GUIFactoryProvider.obterFabrica()`

O cliente `Application` **nao precisa ser alterado**. Esse e um dos principais beneficios do padrao.

---

## Relacao com o exemplo original

Este projeto implementa o padrao Abstract Factory com o cenario classico de componentes de GUI:

| Elemento | Descricao |
| --- | --- |
| `GUIFactory` | Interface da fabrica abstrata |
| `createButton()` / `createCheckbox()` | Metodos de criacao |
| `WindowsFactory` / `MacFactory` | Fabricas concretas |
| `Application` | Cliente que usa a fabrica sem conhecer classes concretas |

---

## Contexto

Projeto academico de Programacao Orientada a Objetos demonstrando o padrao **Abstract Factory** com um dominio simples: renderizacao de componentes de interface grafica para diferentes sistemas operacionais.
