public class Aluno{
    // atributo! (regra geral: todos private!)
    private String nome;
    private final long dre;
    private final int anoDeMatricula;
    private int creditosAcumulados;     //somatorio dos creditos

    private float cra;                  //cra = somatorio_d [media * creditos / creditos acumulados]

    private int quantDisciplinasCursadas;
    private ItemDeHistorico[] disciplinasCursadas;

    // construtor !
    public Aluno(long dre, int anoDeMatricula, String nome){
        this.dre = dre;
        this.nome = nome;
        this.anoDeMatricula = anoDeMatricula;
        this.disciplinasCursadas = new ItemDeHistorico[16];
    }

    // metodos

    //GETTERS
    public String getNome(){
        return nome == null ? "Sem nome" : nome;
        //ou equivalente a
        //if(nome == null){
        //  return "Sem nome"
        //} return nome;
    }

    public long getDre(){
        return this.dre;
    }

    public float getCra(){
        return this.cra;
    }

    public ItemDeHistorico[] getDisciplinasCursadas() {
        return disciplinasCursadas;
    }

    public int getQuantDisciplinasCursadas() {
        return quantDisciplinasCursadas;
    }

    public int getCreditosAcumulados(){
        return creditosAcumulados;
    }


    /* NÃO QUEREMOS UM SETTER COMO ESTE ABAIXO!!!!!
       PORQUE NÃO FAZ SENTIDO PERMITIR ESCREVER DIRETAMENTE NO CRA DO ALUNO,
       UMA VEZ QUE SE TRATA DE UM CAMPO QUE DEVE SER CALCULADO EM FUNÇÃO DE OUTROS */

        //    public void setCra(float cra) {
        //        if (cra < 0 || cra > 10) {
        //            // ToDo: lançar uma exceção
        //            return;
        //        }
        //        this.cra = cra;
        //    }

    public int getAnoDeMatricula(){
        return anoDeMatricula;
    }

    // SETTERS

    public void setNome(String nome) {
        if(nome.length() > 30){
            //ToDo: Laançar uma excessão
        }
        this.nome = nome;
    }

    //Metodos normais
    String retornarHistoricoAsString(){
        String resultado = "";
        for (int i = 0; i < this.quantDisciplinasCursadas; i++) {
            ItemDeHistorico item = this.disciplinasCursadas[i];
            //MAB001 - media 6.5 - 4 creditos - 2020.1
            resultado = resultado + item.getDisciplina().getCodigo() +
                        " - media " + item.getMediaFinal() +
                        " - " + item.getDisciplina().getCreditos() + " creditos" +
                        " - " + item.getAno() + "." + item.getSemestre();
            if(i < this.quantDisciplinasCursadas - 1){
                resultado = resultado + "\n";
            }
        }
        return resultado;
    }

    public void registrarConclusaoDisciplina(Disciplina disciplina,
                                             float mediaFinal,
                                             int anoConclusao, //ToDo default para ano corrente
                                             int semestreConclusao) {

        ItemDeHistorico novoItem  = new ItemDeHistorico(disciplina, this, anoConclusao, semestreConclusao,mediaFinal);
        this.disciplinasCursadas[this.quantDisciplinasCursadas] = novoItem;
        this.quantDisciplinasCursadas++;

        //recupero o numerador corrente(antes da nova disciplina)
        float numeradorCorrente = this.cra * this.creditosAcumulados;

        int creditos = disciplina.getCreditos();
        this.creditosAcumulados += creditos;

        //atualizar o CRA do aluno
        float novaParcela = creditos * mediaFinal;
        this.cra =(numeradorCorrente + novaParcela) / this.creditosAcumulados;
    }



    @Override
    public String toString(){
        return String.format("%s (DRE: %d)", this.nome, this.dre);
    }
}