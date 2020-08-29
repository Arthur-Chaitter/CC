import java.util.Scanner;

public class HelloWord {
    public static void main(String[] args) {
        Scanner meuScanner = new Scanner(System.in);

        System.out.println("Hello Word!");
        System.out.println("Digite seu nome, por favor: ");
        String nome = meuScanner.nextLine();

        System.out.println("Olá " + nome);

        int numero;
        numero = meuScanner.nextInt();

        String stringFormatada = String.format("Obrigado pelo numero %d, %s!",numero,nome);
        System.out.println(stringFormatada);
    }


}
