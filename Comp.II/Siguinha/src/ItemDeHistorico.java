import java.util.Calendar;
import java.util.spi.CalendarDataProvider;

public class ItemDeHistorico{
    private Disciplina disciplina;

    private int ano;

    private int semestre;

    private float mediaFinal;

    private Aluno aluno;

    //construtor
    public ItemDeHistorico(Disciplina disciplina, Aluno aluno, int ano, int semestre, float mediaFinal){
        this.disciplina = disciplina;
        this.aluno = aluno;
        setAno(ano);
        this.semestre = semestre;
        this.mediaFinal = mediaFinal;
    }

    //Getters
    public Disciplina getDisciplina(){
        return disciplina;
    }

    public int getAno(){
        return ano;
    }

    public int getSemestre(){
        return semestre;
    }

    public float getMediaFinal(){
        return mediaFinal;
    }

    //Setters

    public void setDisciplina(Disciplina disciplina){
        this.disciplina = disciplina;
    }

    public void setAno(int ano){
        int anoCorrente = Calendar.getInstance().get(Calendar.YEAR);
        if(ano < aluno.getAnoDeMatricula() || ano > anoCorrente){
            //lançar excessao
            return; //sem setar ano
        }
        this.ano = ano;
    }

    public void setSemestre(int semestre){
        if(semestre < 1 || semestre > 2){
            //lançar excessao
            return; //sem setar semetre
        }
        this.semestre = semestre;
    }

    public void setMediaFinal(float mediaFinal){
        this.mediaFinal = mediaFinal;
    }

    //metodos

    public boolean obteveAprovação(){
        return this.mediaFinal >= Siguinha.MEDIA_MINIMA_APROVACAO;
    }

}
