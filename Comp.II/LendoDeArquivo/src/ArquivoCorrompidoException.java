public class ArquivoCorrompidoException extends Exception {

    private int linhasInvalidas = 0;

    public int getLinhasInvalidas() {
        return linhasInvalidas;
    }

    public void setLinhasInvalidas(int linhasInvalidas) {
        this.linhasInvalidas = linhasInvalidas;
    }


}
