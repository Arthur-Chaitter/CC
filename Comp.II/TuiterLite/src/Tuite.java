import java.util.ArrayList;

public class Tuite<T> {

    private final Usuario autor;
    private final String texto;


    private static ArrayList<String> hashtags;
    public T anexo;

    public Tuite(Usuario autor, String texto) {
        this.autor = autor;
        this.texto = texto;

        this.hashtags = new ArrayList<>();
    }

    public void anexarAlgo(T anexo) {
        this.anexo = anexo;
    }

    public T getAnexo() {
        return anexo;
    }

    public Usuario getAutor() {
        return this.autor;
    }

    public String getTexto() {
        return this.texto;
    }

    public ArrayList<String> getHashtags() {
        String[] palavras = texto.split("[\\s,.!?;:]");
        for (String msg : palavras) {
            if(msg.startsWith("#")){
                hashtags.add(msg);
            }
        }

        return hashtags;
    }

}
