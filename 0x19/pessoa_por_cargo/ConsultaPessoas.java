import java.util.*;
import java.util.stream.Collectors;
class ConsultaPessoas {
    public static Map<String, List<Pessoa>> obterPessoasPorCargo(List<Pessoa> pessoas) {
        return pessoas.stream()
                      .collect(Collectors.groupingBy(Pessoa::getCargo));
    }
}