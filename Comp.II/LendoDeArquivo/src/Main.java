import java.io.File;
import java.util.Scanner;

public class Main {

    public static boolean arquivoValido = true;
    public static int linhasInvalida = 0;

    public static void main(String[] args) {
        float media = -1;

        Scanner scanner = new Scanner(System.in);

        while(media < 0){
            System.out.println("Digite o nome do arquivo: ");

            String nomeDoArquivo = scanner.nextLine();
            try {
                media = calcularMedia(nomeDoArquivo);
            } catch (ArquivoCorrompidoException e) {
                System.out.println("O Arquivo esta corrompido com " + e.getLinhasInvalidas() + " linhas invalidas. Corrija o arquivo!");
                return;
            }
        }

        System.out.println("A media da turma é: " + media);


    }

    public static float calcularMedia(String nomeDoArquivo) throws ArquivoCorrompidoException {
        File arquivo = new File(nomeDoArquivo);
        Scanner scanner = null;
        float somatorio = 0;
        float nota;
        int denominador = 0;
        try {
            scanner = new Scanner(arquivo);
        }catch (Exception FileNotFoundException){
            System.out.println("Arquivo não encontrado, digite novamente o nome do arquivo");
            return -1;
        }

        while(scanner.hasNext()) {
            try {
                nota = scanner.nextFloat();
                if (nota <= 10 && nota >= 0) {
                    somatorio += nota;
                    denominador++;
                }else{
                    linhasInvalida++;
                }
            } catch (Exception e) {
                linhasInvalida++;
            }
        }
        if(linhasInvalida > denominador){
            ArquivoCorrompidoException e = new ArquivoCorrompidoException();
            e.setLinhasInvalidas(linhasInvalida);
            throw e;
        }

        return somatorio/denominador;
    }
}
