# Instalando JDK

## Menu
[Aula 1 - Objetivos do módulo](#aula-1)  
[Aula 2 - JDK vs JRE](#aula-2)  
[Aula 3 - Istalando e configurando o JDK](#aula-3)  
[Aula 4 - Compilando e rodando o código](#aula-4)

## Revisando
O que vimos até aqui é que o Java tem uma estrutura de fácil port do código para outros sistemas e dispositivos porque ele trabalha com maquinas virtuais, o fluxo do desenvolvimento e execução das soluções escrita em java são:
1. Desenvolvimento do código Java `.java`
2. Compilação do JAVAC em Byte Code `.class`
3. Instalação da JVM para o dispositivo alvo:
    * Linux
    * Windowns
    * Mac
4. JVM executa o `.class` para a solução funcionar na máquina desejada.

A difenreça do java para outras linguagens é que ele tem o conceito de se escrever uma vez e e rode em todos os lugares, que tenha uma JVM compátivel, já outras linguagens usam um código nativo para o sistema alvo da aplicação, para poder rodar o programa em outras máquinas é necessário escrever um código específico para linguagem alvo.

Exemplos: C, C++, Rust ... 



## Aula 1
Nesta aula vamos ver quais são os objetivos do módulo.

1. Explicar o que o JVM (Java Virtual Manchine) 
    * Máquina virtual que possibilita a execução do código `.java` em diversos dispositivos.
2. Fazer o download do JDK para desenvolver código
    * Aprendendo a fazer o download em diferentes sistemas operacionais.
3. Escrever um programa Java em um Editor de Texto
4. Compilar um programa 
5. Ver em execução

## Aula 2 
Vimos a diferença principal entre o JDK e o JRE, o primeiro permite desenvolver e executar código `.java`, enquanto o segundo só vai executar o código.

## Aula 3
Nesta aula aprendemos como baixar o JDK e fazer a configuração das variáveis de ambiente, as explicações a seguir serâo no Windows que é o meu sistema.

### Instação
1. Selecionar o sistema operacional
2. Escolher forma de instação

[JDK LTS](https://www.oracle.com/br/java/technologies/downloads/#jdk21-windows)
-> Neste link vamos ser direcionado para baixar o JDK mais recente .

### Configuração das variáveis de ambiente.

1. Acesse o seguinte caminho:
   - **Este Computador → Propriedades → Configurações avançadas do sistema → Variáveis de ambiente**

2. Descubra onde o Java foi instalado:
   - Normalmente, o caminho padrão é: `C:\Program Files\Java\jdk-<número da versão>`

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

### Instalçao VS Code
[VS Code](https://code.visualstudio.com/) -> Basta acessar o site e clicar em download, na maioria do sitemas é só um instalador, caso tenha dúvidas acesse a [documentação](https://code.visualstudio.com/docs)

### Criar arquivo Java
Para criar um arquivo Java no VS Code é só criar um novo arquivo com o final `.java`.

Quando criamos um arquivo Java temos que criar a classe dele. O nome da classe e do arquivo tem que ser iguais.

### Compilando o Java
Como falamos anteriormente nós desenvolvemos o código em `.java` e executamos o código em `.class` para que isto aconteça é necessário usar o `javac + arquivo.java` para que tenha esta transição e a JVM consiga executar.

### Executando o arquivo
`java + nome_class` -> No terminal para executar o código compilado.
Se nós só executarmos o arquivo como ele está agora vamos ter um erro. 
```Java
public class HelloWorld {
    
}
```
* Este erro ocorre porque não existe um metódo principal. O metódo principal é referência de onde a aplicação deve começar a ser executada.
```Java
public static void main (String[] args) {
        
    }
```
* Esta é a estrutura base do metódo principal, a seguir vou explciar cada ponto.
    * `public` -> Indica que o método pode ser acessado de qualquer lugar
    * `static` -> Significa que o metódo pertence a classe, não precisa criar um objeto para funcionar. 
    * `void` -> O void indica que o método não retorna nada. No main, ele precisa ser void, senão a JVM não consegue iniciar o programa. Em outros métodos, você pode usar int, String, etc., mas aí o retorno é obrigatório.
    * `main` -> Nome padrão do metódo principal, é como se fosse no front o `index.html`, arquivo principal da aplicação que o navegador vai ler primeiro.
    * `(String[] args)` -> No caso do main tem que ser esse módelo, a única alteração possível é o nome da variável(args). Quando for outro método é possível usar outros parametros e até misturar a depender do input ou da resposta. 

Mas de forma geral, tendo isto o erro vai desaperecer porque agora temos o ponto inicial da leitura da classe. Quando compilamos e executamos o código do jeito que esta não vai acontecer nada, para que acontece algo nos temos que escrever o que queremos dentro deste metodo principal.

`System.out.print("Hello World");` ->  quando adicionamos isso ao metódo principal estamos fazendo como se fosse o alert do JS ou o print do python, pedindo pra que quando o arquivo for executado ele escreva Hello World. Se fizermos uma pequena alteração é possível que o arquivo pegue uma informação que escrevemos e adicione ao print.

`System.out.print("Olá" + args[0]);` -> Desta forma estamos falando que o que adicionarmos ao lado do nome da classe quuando chamarmos no terminal.

`java HelloWorld escrtio` -> Vai imprimir "Ola + escrito "

Cada espaço que eu dou na hora de executar a função como fiz a cima vai ocupar um espaço diferente na string, o valor só vai ser armazenado temporariamente se estiver descriminado anteriormente. Caso não vai ser ignorado no print. 

```Java
public static void main (String[] args) {
        String ambiente = args[0];
        String nome = args[1];
        if (ambiente.equals("Casa")) {
            System.out.print(nome + " está em "  + args[0]);}
            else {
                System.out.print(nome + " não está em casa, só vai chegar mais tarde da " + args[0]);
        }
    }
```

Dessa forma colocamos múltiplas variáveis, repare que as variáveis tem que estar tipadas para dar certo. Podemos passar vários argumento na hora de executar o Java, porém, somente aqueles que foram chamados no metódo e que foram selecionados para ser impressos é que serão exibidos.

`if (ambiente.equalsIgnoreCase("Casa"))` -> Independente da forma que casa estiver escrita, maiuscula ou minuscula, o ambiente vai ser chamada se as duas palavras tiverem os mesmos caracteres na ordem disposta. 