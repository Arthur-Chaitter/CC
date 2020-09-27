import java.util.ArrayList;

public class LojaVirtual {

    private ArrayList<Produto> estoque;

    private boolean tenhoEmEstoque;

    private int tamanhoTotalDoEstoque;

    private float fluxoDoCaixa;

    public LojaVirtual(){
        this.estoque = new ArrayList<>();
        this.fluxoDoCaixa = 0;
        this.tamanhoTotalDoEstoque = 0;
        this.tenhoEmEstoque = false;
    }

    public void incluirProdutoNoEstoque(Produto produto, int quantidade){
        for (Produto p : estoque) {
            if(p.equals(produto)){
                tenhoEmEstoque = true;
                break;
            }
        }

        if(!tenhoEmEstoque){
            estoque.add(produto);
        }
        produto.setQuantidadeEmEstoque(quantidade);
        tamanhoTotalDoEstoque += quantidade;
    }

    public String efetuarVenda(Produto produto, int quantidade){
        for (Produto p : estoque) {
            if(p.equals(produto)){
                tenhoEmEstoque = true;
                break;
            }
        }
        if(!tenhoEmEstoque){
            return "Item em falta";
        }
        if(produto.getQuantidadeEmEstoque() < quantidade){
            return "A quantidade pedida é maior que o estoque";
        }
        else if(produto.getQuantidadeEmEstoque() == quantidade){
            estoque.remove(produto);
            produto.setQuantidadeEmEstoque(-quantidade);
            fluxoDoCaixa += produto.getPrecoEmReais() * quantidade;

            return "Venda Efetuada!";
        }

        produto.setQuantidadeEmEstoque(-quantidade);
        fluxoDoCaixa += produto.getPrecoEmReais() * quantidade;

        return "Venda Efetuada!";
    }

    public int getTamanhoEstoque(Produto produto){
        return produto.getQuantidadeEmEstoque();
    }


    public int getTamanhoEstoque(){
        return tamanhoTotalDoEstoque;
    }

    public int getItensAVenda(){
        return estoque.size();
    }

    public float getValorTotalEmVendas(){
        return fluxoDoCaixa;
    }

    //teste do toString()
    public static void main(String[] args) {
        String CATEGORIA_DE_LIVROS = "Publicacoes";
        String CATEGORIA_DE_ROUPAS = "Vestuario";

        Roupa roupa1;

        Livro livro1;

        roupa1 = new Roupa(150, 35, CATEGORIA_DE_ROUPAS, 'M', "vermelho");
        livro1 = new Livro(300 , 25,CATEGORIA_DE_LIVROS, "Blah", "Joaozinho", 2012, 300);

        System.out.println(roupa1);
        System.out.println(livro1);
    }
}
