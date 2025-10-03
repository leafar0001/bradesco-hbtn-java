import java.util.*;
import java.util.stream.Collectors;
class ConsultaPessoas {

    // Agrupa pessoas pelo cargo
    public static Map<String, List<Pessoa>> obterPessoasPorCargo(List<Pessoa> pessoas) {
        return pessoas.stream()
                      .collect(Collectors.groupingBy(Pessoa::getCargo));
    }

    // Agrupa idades das pessoas pelo cargo
    public static Map<String, List<Integer>> obterIdadePorCargo(List<Pessoa> pessoas) {
        return pessoas.stream()
                      .collect(Collectors.groupingBy(
                          Pessoa::getCargo,
                          Collectors.mapping(Pessoa::getIdade, Collectors.toList())
                      ));
    }
}