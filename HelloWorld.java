public class HelloWorld {

    public static void main (String[] args) {
        String ambiente = args[0];
        String nome = args[1];
        if (ambiente.equals("Casa")) {
            System.out.print(nome + " está em "  + args[0]);}
            else {
                System.out.print(nome + " não está em casa, só vai chegar mais tarde da " + args[0]);
        }
    }
}
