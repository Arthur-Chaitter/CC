public class Roupa extends Produto{

    private final char tamanho;

    private String cor;


    public Roupa(int pesoEmGramas, float precoEmReais, String categoria, char tamanho, String cor){
        super(pesoEmGramas,precoEmReais,categoria);
        this.cor = cor;
        this.tamanho = tamanho;
    }

    @Override
    public String toString(){
        return "Informaçoes sobre a roupa - Peso em gramas da Roupa: " + super.getPesoEmGramas() + ", Preço em Reais: " + super.getPrecoEmReais() +
                ", Categoria: " + super.getCategoria() + ", Tamanho: " + this.tamanho + ", Cor: " + this.cor;
    }
}
