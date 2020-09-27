public class Produto {

    private static long idIncrement = 1;

    private final long id;

    private int pesoEmGramas;

    private float precoEmReais;

    private String categoria;

    private int quantidadeEmEstoque;


    //Construtor
    public Produto(int pesoEmGramas, float precoEmReais, String categoria){
        this.id = idIncrement++;
        this.pesoEmGramas = pesoEmGramas;
        this.precoEmReais = precoEmReais;
        this.categoria = categoria;

        quantidadeEmEstoque = 0;
    }

    public void setQuantidadeEmEstoque(int quantidade){
        quantidadeEmEstoque = quantidadeEmEstoque + quantidade;
    }

    public int getQuantidadeEmEstoque(){
        return quantidadeEmEstoque;
    }

    public float getPrecoEmReais(){
        return precoEmReais;
    }

    public long getId() {
        return id;
    }

    public int getPesoEmGramas() {
        return pesoEmGramas;
    }

    public String getCategoria() {
        return categoria;
    }
}
