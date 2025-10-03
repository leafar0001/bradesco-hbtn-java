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

    // Agrupa pessoas pelo cargo filtrando apenas quem tem idade acima de 40 anos
    public static Map<String, List<Pessoa>> obterPessoasPorCargoAcimaDe40anos(List<Pessoa> pessoas) {
        return pessoas.stream()
                      .collect(Collectors.groupingBy(
                          Pessoa::getCargo,
                          Collectors.filtering(p -> p.getIdade() > 40, Collectors.toList())
                      ));
    }
}