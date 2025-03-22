# Instalando JDK

## Menu
[Aula 1 - Objetivos do módulo](#aula-1)  
[Aula 2 - JDK vs JRE](#aula-2)  
[Aula 3 - Instalando e configurando o JDK](#aula-3)  
[Aula 4 - Compilando e rodando o código](#aula-4)

## Revisando
O que vimos até aqui é que o Java tem uma estrutura de fácil portabilidade do código para outros sistemas e dispositivos, porque ele trabalha com máquinas virtuais. O fluxo do desenvolvimento e execução das soluções escritas em Java é:

1. Desenvolvimento do código Java `.java`
2. Compilação com o `javac` em Bytecode `.class`
3. Instalação da JVM no dispositivo alvo:
    * Linux
    * Windows
    * Mac
4. A JVM executa o `.class` para a solução funcionar na máquina desejada.

A diferença do Java para outras linguagens é que ele tem o conceito de "escreva uma vez e execute em qualquer lugar", desde que haja uma JVM compatível. Outras linguagens costumam gerar código nativo para o sistema alvo, o que exige uma nova compilação (ou adaptação) para rodar em outras máquinas.

Exemplos: C, C++, Rust...

## Aula 1
Nesta aula vamos ver quais são os objetivos do módulo:

1. Explicar o que é a JVM (Java Virtual Machine) 
   * Máquina virtual que possibilita a execução do código `.java` em diversos dispositivos.
2. Fazer o download do JDK para desenvolver código
   * Aprender a fazer o download em diferentes sistemas operacionais.
3. Escrever um programa Java em um editor de texto
4. Compilar um programa
5. Executar o programa

## Aula 2
Vimos a diferença principal entre o JDK e o JRE. O primeiro permite **desenvolver e executar** código `.java`, enquanto o segundo **apenas executa** o código.

## Aula 3
Nesta aula aprendemos como baixar o JDK e configurar as variáveis de ambiente. As explicações a seguir são no Windows, que é o meu sistema.

### Instalação
1. Selecionar o sistema operacional
2. Escolher a forma de instalação

[JDK LTS](https://www.oracle.com/br/java/technologies/downloads/#jdk21-windows)  
→ Neste link seremos direcionados para baixar a versão mais recente do JDK.

### Configuração das variáveis de ambiente

1. Acesse o seguinte caminho:  
   **Este Computador → Propriedades → Configurações avançadas do sistema → Variáveis de ambiente**

2. Descubra onde o Java foi instalado:  
   Normalmente, o caminho padrão é: `C:\Program Files\Java\jdk-<número da versão>`

3. Crie uma nova **variável de sistema**:
   - **Nome da variável:** `JAVA_HOME`
   - **Valor da variável:** o caminho onde o Java foi instalado  
     *(exemplo: `C:\Program Files\Java\jdk-21`)*

4. Edite a variável `Path` do sistema:
   - Na mesma tela de **Variáveis de ambiente**, localize a variável chamada `Path` e clique em **Editar**
   - Clique em **Novo** e adicione o seguinte valor: `%JAVA_HOME%\bin`

5. Para testar se deu tudo certo:
   - Abra o Prompt de Comando (cmd)
   - Digite os comandos abaixo:
     ```
     java -version
     javac -version
     ```
   - Se tudo estiver configurado corretamente, será exibida a versão do Java instalada.

## Aula 4

### Instalação do VS Code
[VS Code](https://code.visualstudio.com/) → Basta acessar o site e clicar em "Download". Na maioria dos sistemas é só executar o instalador. Em caso de dúvidas, acesse a [documentação](https://code.visualstudio.com/docs).

### Criar arquivo Java
Para criar um arquivo Java no VS Code, basta criar um novo arquivo com a extensão `.java`.

Quando criamos um arquivo Java, precisamos criar uma **classe**. O nome da classe e do arquivo devem ser iguais.

### Compilando o Java
Como vimos anteriormente, desenvolvemos o código em `.java` e o executamos como `.class`. Para isso, usamos:
```bash
javac Arquivo.java
```
Isso compila o arquivo para bytecode que a JVM consegue executar.

### Executando o arquivo
```bash
java NomeDaClasse
```
Esse comando executa o código compilado. Mas se apenas executarmos o código vazio:
```java
public class HelloWorld {

}
```
Teremos um erro, pois **não existe um método principal (main)**. O método principal é o ponto de entrada da aplicação.

```java
public static void main(String[] args) {

}
```

### Estrutura do método principal
* `public` → Indica que o método pode ser acessado de qualquer lugar
* `static` → Significa que o método pertence à classe, não precisa criar um objeto para funcionar
* `void` → Indica que o método não retorna nada. No `main`, ele precisa ser `void`, senão a JVM não consegue iniciar o programa. Em outros métodos, você pode usar `int`, `String`, etc., mas o retorno passa a ser obrigatório.
* `main` → Nome padrão do método principal. É como o `index.html` no front-end: o primeiro ponto lido.
* `(String[] args)` → No caso do `main`, esse formato é obrigatório (somente o nome da variável pode mudar). Em outros métodos, você pode usar outros parâmetros.

Tendo isso definido, o erro desaparece. Mas a aplicação ainda não faz nada, pois não tem nenhum comando dentro do `main`. Podemos adicionar um `print`:

```java
System.out.print("Hello World");
```
Esse comando é equivalente ao `alert` do JS ou ao `print` do Python. Ele imprime uma mensagem no terminal.

### Usando argumentos
Podemos usar argumentos passados na execução:
```java
System.out.print("Olá " + args[0]);
```
Se executarmos:
```bash
java HelloWorld João
```
A saída será:
```
Olá João
```
Cada palavra passada é um argumento separado. Ou seja:
```bash
java HelloWorld casa João
```
`args[0] = "casa"`  
`args[1] = "João"`

Esses argumentos só são armazenados temporariamente durante a execução.

### Exemplo com múltiplas variáveis
```java
public static void main(String[] args) {
    String ambiente = args[0];
    String nome = args[1];

    if (ambiente.equals("Casa")) {
        System.out.print(nome + " está em " + ambiente);
    } else {
        System.out.print(nome + " não está em casa, só vai chegar mais tarde da " + ambiente);
    }
}
```

As variáveis precisam estar tipadas corretamente. Podemos passar vários argumentos, mas só serão usados os que forem manipulados no código.

Para ignorar diferenças entre maiúsculas e minúsculas:
```java
if (ambiente.equalsIgnoreCase("Casa"))
```
Assim, "casa", "Casa" ou "CASA" serão tratados da mesma forma.
