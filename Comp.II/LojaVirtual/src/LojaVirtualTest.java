import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LojaVirtualTest {

    public static final String CATEGORIA_DE_LIVROS = "Publicacoes";
    public static final String CATEGORIA_DE_ROUPAS = "Vestuario";

    private LojaVirtual lojinha;

    private Produto produto1;

    private Roupa roupa1;

    private Livro livro1;

    @Before
    public void setUp(){
        lojinha = new LojaVirtual();

        produto1 = new Produto(240, 150, "Perfumaria");
        roupa1 = new Roupa(150, 35, CATEGORIA_DE_ROUPAS, 'M', "vermelho");
        livro1 = new Livro(300 , 25,CATEGORIA_DE_LIVROS, "Blah", "Joaozinho", 2012, 300);


        lojinha.incluirProdutoNoEstoque(roupa1,100);
        lojinha.incluirProdutoNoEstoque(livro1, 60);
        lojinha.incluirProdutoNoEstoque(produto1,50);
    }

    @Test
    public void incluirProdutoNoEstoque() {
        //Teste de inclusao de itens na loja
        assertEquals("Deve retornar o estoque TOTAL da loja",210,lojinha.getTamanhoEstoque());
        assertEquals("Deve retornar o estoque de LIVROS da loja",60, lojinha.getTamanhoEstoque(livro1));
        assertEquals("Deve retornar o estoque de ROUPAS da loja",100, lojinha.getTamanhoEstoque(roupa1));
        assertEquals("Deve retornar o estoque de produtos da loja",50, lojinha.getTamanhoEstoque(produto1));

        //teste do arraylist
        assertEquals(3, lojinha.getItensAVenda());

        //teste de inclusao de mais produtos já criados
        lojinha.incluirProdutoNoEstoque(roupa1,50);
        assertEquals("Deve retornar o estoque de ROUPAS da loja",150, lojinha.getTamanhoEstoque(roupa1));
        lojinha.incluirProdutoNoEstoque(produto1,40);
        assertEquals("Deve retornar o estoque de produtos da loja",90, lojinha.getTamanhoEstoque(produto1));
        lojinha.incluirProdutoNoEstoque(livro1,20);
        assertEquals("Deve retornar o estoque de LIVROS da loja",80, lojinha.getTamanhoEstoque(livro1));

        assertEquals(3, lojinha.getItensAVenda());

    }

    @Test
    public void efetuarVendaTest() {
        //teste de venda normal
        assertEquals("Venda Efetuada!", lojinha.efetuarVenda(produto1,45));
        assertEquals("Deve retornar o estoque de ROUPAS da loja",5, lojinha.getTamanhoEstoque(produto1));

        //teste de fluxo de caixa
        assertEquals(6750, lojinha.getValorTotalEmVendas(),0.0001);

        //teste de venda do estoque completo
        assertEquals("Venda Efetuada!",lojinha.efetuarVenda(livro1,60));
        assertEquals("Deve retornar o estoque de LIVROS da loja",0, lojinha.getTamanhoEstoque(livro1));
        assertEquals(2, lojinha.getItensAVenda());

        //teste de fluxo de caixa
        assertEquals(8250, lojinha.getValorTotalEmVendas(),0.0001);

        //teste de compra acima do estoque
        assertEquals("A quantidade pedida é maior que o estoque", lojinha.efetuarVenda(roupa1,102));

    }

}