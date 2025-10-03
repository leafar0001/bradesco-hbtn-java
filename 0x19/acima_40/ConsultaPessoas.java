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

   public static Map<String, List<Pessoa>> obterPessoasPorCargoAcimaDe40anos(List<Pessoa> pessoas) {
    // Obtém todos os cargos únicos da lista
    Set<String> cargos = pessoas.stream()
                                .map(Pessoa::getCargo)
                                .collect(Collectors.toSet());

    // Cria o Map garantindo todos os cargos e aplicando filtering
    return cargos.stream()
            .collect(Collectors.toMap(
                cargo -> cargo,
                cargo -> pessoas.stream()
                                .collect(Collectors.groupingBy(
                                    Pessoa::getCargo,
                                    Collectors.filtering(p -> p.getCargo().equals(cargo) && p.getIdade() > 40,
                                                         Collectors.toList())
                                )).get(cargo)
            ));
}



}