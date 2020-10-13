import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class CalculadorIntersecaoEsperto extends CalculadorIntersecao<Integer> {

    @Override
    public int getQuantidadeElementosEmComum(List<Integer> lista1, List<Integer> lista2) {
        HashSet list2 = new HashSet(lista2);

        lista1.retainAll(list2);

        return lista1.size();
    }
}
