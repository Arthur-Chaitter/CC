public class Disciplina {
    private final String codigo;

    private String nome;

    private int creditos;

    private String nomeDepartamento;

    private String descricao;

    private String[] itensEmenta;

    //construtor
    public Disciplina(String codigo, String nome){
        this.codigo = codigo;
        this.nome = nome;
    }

    //Getters
    public String getCodigo(){
        return codigo;
    }

    public String getNome(){
        return nome;
    }

    public int getCreditos(){
        return creditos;
    }

    public String getNomeDepartamento(){
        return nomeDepartamento;
    }

    public String getDescricao(){
        return descricao;
    }

    //Setters

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setCreditos(int creditos){
        this.creditos = creditos;
    }

    public void setNomeDepartamento(String nomeDepartamento){
        this.nomeDepartamento = nomeDepartamento;
    }

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

    //metodos

    public void adicionarItemEmenta(String item){
        //ToDo: IMPLEMENT ME
    }



}
