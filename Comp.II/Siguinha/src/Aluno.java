public class Aluno{
    // atributo! (regra geral: todos private!)
    private String nome;
    private final long dre;
    private int creditosAcumulados;     //somatorio dos creditos

    private float cra;                  //cra = somatorio_d [media * creditos / creditos acumulados]

    private int quantDisciplinasCursadas;
    private String[] disciplinasCursadas;

    // construtor !
    public Aluno(long dre, String nome){
        this.dre = dre;
        this.nome = nome;

        this.disciplinasCursadas = new String[16];
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

    public String[] getDisciplinasCursadas() {
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

    // SETTERS

    public void setNome(String nome) {
        if(nome.length() > 30){
            //ToDo: Laançar uma excessão
        }
        this.nome = nome;
    }

    //Metodos normais
    void imprimirHistorico() {
        //ToDo: Implement Me!
    }

    public void registrarConclusaoDisciplina(String codigoDisciplina, int quantCreditos, float mediaFinal){
        this.disciplinasCursadas[this.quantDisciplinasCursadas] = codigoDisciplina;
        this.quantDisciplinasCursadas++;

        //recupero o numerador corrente(antes da nova disciplina)
        float numeradorCorrente = this.cra * this.creditosAcumulados;

        this.creditosAcumulados += quantCreditos;

        //atualizar o CRA do aluno
        float novaParcela = quantCreditos * mediaFinal;
        this.cra =(numeradorCorrente + novaParcela) / this.creditosAcumulados;
    }

    @Override
    public String toString(){
        return String.format("%s (DRE: %d)", this.nome, this.dre);
    }
}