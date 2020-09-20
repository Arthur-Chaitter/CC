public class Album {

    private int totalFigurinhas;

    private int quantFigurinhasPorPacotinho;

    private Figurinha[] figurinhasColadas;

    private Figurinha[] figurinhasRepetidas;

    private int quantFigurinhasColadas = 0;

    private int quantFigurinhasRepetidas = 0;

    private int quantPacotinhosRecebidos = 0;

    private int quantFigurinhasFaltando = 0;

    public static final float PREENCHIMENTO_MINIMO_PARA_PERMITIR_AUTO_COMPLETAR = 0.9f;  // 90%



    public Album(int totalFigurinhas, int quantFigurinhasPorPacotinho) {
        this.totalFigurinhas = totalFigurinhas;
        this.quantFigurinhasPorPacotinho = quantFigurinhasPorPacotinho;
        figurinhasColadas = new Figurinha[200+1];
        figurinhasRepetidas = new Figurinha[300+1];

    }

    public void receberNovoPacotinho(Figurinha[] pacotinho) {
        quantPacotinhosRecebidos+=1;
        for (int i = 0; i < pacotinho.length; i++) {
            Figurinha figurinha = pacotinho[i];

            if(!possuiFigurinhaColada(figurinha)){
                figurinhasColadas[figurinha.getPosicao()] = figurinha;
                quantFigurinhasColadas++;
            }
            else{
                figurinhasRepetidas[figurinha.getPosicao()] = figurinha;
                quantFigurinhasRepetidas++;
            }

            quantFigurinhasFaltando = 200 - quantFigurinhasColadas;
        }

        // equivalentemente, usar um "for each" ToDo: IMPLEMENT ME!
        //for (Figurinha figurinha : pacotinho) {
        //}
    }

    public int getTotalPacotinhosRecebidos() {
        return quantPacotinhosRecebidos;
    }

    /**
     * Termina de preencher o álbum, desde que ele já esteja preenchido além de certa fração
     * mínima definida em Album.PREENCHIMENTO_MINIMO_PARA_PERMITIR_AUTO_COMPLETAR.
     *
     * Se o álbum não estiver ainda completo o suficiente para isso, este método simplesmente
     * não faz nada.
     */
    public void encomendarFigurinhasRestantes() {
        // ToDo IMPLEMENT ME!!!    (será preciso validar a regra dos 10%)
        if(quantFigurinhasColadas != 200*0.9){
            return;
        }else{
            for (int i = 1; i < 200; i++) {
                if(!possuiFigurinhaColada(i)){
                    Figurinha figurinha = new Figurinha(i, String.format("http://urlFakeDaFigurinha%d.jpg", i));
                    figurinhasColadas[i] = figurinha;
                    quantFigurinhasColadas++;
                    quantFigurinhasFaltando = 200 - quantFigurinhasColadas;
                }
            }
        }
    }

    public boolean possuiFigurinhaColada(int posicao) {
        if(this.figurinhasColadas[posicao] == null){
            return false;
        }
        return true;
    }

    public boolean possuiFigurinhaColada(Figurinha figurinha) {  // overload
        return possuiFigurinhaColada(figurinha.getPosicao());
    }

    public boolean possuiFigurinhaRepetida(int posicao) {
        if(this.figurinhasRepetidas[posicao] == null){
            return false;
        }
        return true;
    }

    public boolean possuiFigurinhaRepetida(Figurinha figurinha) {  // overload
        return possuiFigurinhaRepetida(figurinha.getPosicao());
    }

    public int getQuantFigurinhasColadas() {
        return quantFigurinhasColadas;
        // só pra retornar alguma coisa, evitando ainda o loop infinito nos testes quebrados
    }

    public int getQuantFigurinhasRepetidas() {
        return quantFigurinhasRepetidas;
    }

    public int getQuantFigurinhasFaltando() {
        return quantFigurinhasFaltando;
    }

}
