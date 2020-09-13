import java.util.Objects;

public class Fracao {
    private int numerador;

    private int denominador;

    private boolean sinal;

    private boolean nulo;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fracao fracao = (Fracao) o;
        fracaoNula(fracao.numerador, fracao.denominador);
        if(nulo){
            return this.getValorNumerico() == fracao.getValorNumerico();
        }
        return this.getValorNumerico() == fracao.getValorNumerico() &&
                sinal == fracao.sinal;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numerador, denominador, sinal);
    }

    /**
     * Construtor.
     * O sinal da fração é passado no parâmetro específico.
     *
     * @param numerador O numerador (inteiro não-negativo)
     * @param denominador O denominador (inteiro positivo)
     * @param positiva se true, a fração será positiva; caso contrário, será negativa
     */
    public Fracao(int numerador, int denominador, boolean positiva) {
        this.numerador = numerador;
        this.denominador = denominador;
        this.sinal = positiva;
        fracaoNula(numerador,denominador);
    }

    /**
     * @return um double com o valor numérico desta fração
     */
    public double getValorNumerico() {
        double resultado;
        fracaoNula(numerador, denominador);
        if(nulo){return 0;}
        resultado = (double)numerador/denominador;
        if(sinal){
            return resultado;
        }
        return -resultado;
    }

    /**
     * Retorna uma fração que é equivalente a esta fração (this),
     * e que é irredutível (numerador e denominador primos entre si).
     * Em outras palavras, retorna a fração geratriz desta fração.
     *
     * @return uma fração irredutível equivalente a esta;
     *         no caso desta fração JÁ SER ela própria irredutível, retorna this
     */
    public Fracao getFracaoGeratriz() {
        int mdc = mdc(numerador, denominador);
        Fracao fracaoGeratriz = new Fracao(numerador/mdc, denominador/mdc, sinal);
        if(fracaoGeratriz.getValorNumerico() == this.getValorNumerico()){
            return this;
        }
        return fracaoGeratriz;
    }

    public int getNumerador() {
        return numerador;
    }

    public int getDenominador() {
        return denominador;
    }

    public boolean isPositiva() {
        if(nulo == true){
            return false;
        }
        return sinal;
    }

    //metodos adicionais

    public void fracaoNula(int numerador, int denominador){
        if(numerador == 0 || denominador == 0) {
            nulo = true;
        }else {
            nulo = false;
        }
    }

    public int mdc(int numerador, int denominador){     //Algoritmo de Euclides
        if(denominador == 0){
            return numerador;
        }
        else {
            return mdc(denominador, numerador%denominador);
        }
    }

}
