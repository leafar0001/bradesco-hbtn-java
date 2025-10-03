import java.util.*;
import java.util.stream.Collectors;
class ConsultaPessoas {
    public static TreeMap<String, TreeSet<Pessoa>> obterPessoasAgrupadasPorCargoEmOrdemReversa(List<Pessoa> pessoas) {
        return pessoas.stream()
            .collect(Collectors.groupingBy(
                Pessoa::getCargo,
                () -> new TreeMap<>(Comparator.reverseOrder()), // cargos em ordem reversa
                Collectors.toCollection(TreeSet::new)          // TreeSet de pessoas, ordenado pelo compareTo
            ));
    }
}