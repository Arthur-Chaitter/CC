public class Livro extends Produto {

    private final String titulo;

    private final String autor;

    private final int anoDePublicacao;

    private final int numeroDePaginas;



    public Livro(int pesoEmGramas, float precoEmReais, String categoria,String titulo, String autor, int anoDePublicacao, int numeroDePaginas){
        super(pesoEmGramas, precoEmReais, categoria);
        this.titulo = titulo;
        this.autor = autor;
        this.anoDePublicacao = anoDePublicacao;
        this.numeroDePaginas = numeroDePaginas;

    }
    @Override
    public String toString(){
        return "Informaçoes Sobre o Livro - Autor: " + this.autor + ", Titulo: " + this.titulo + ", Ano de publicacao: " +
                this.anoDePublicacao + ", Numero de Paginas: " + this.numeroDePaginas + ", Peso em gramas: " + super.getPesoEmGramas() +
                ", Preço em Reais: " + super.getPrecoEmReais() + ", Categoria: " + super.getCategoria();
    }
}
