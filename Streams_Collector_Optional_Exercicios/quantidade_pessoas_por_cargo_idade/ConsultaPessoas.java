import java.util.*;
import java.util.stream.Collectors;

public class ConsultaPessoas {

    public static Map<String, Map<Integer, Long>> obterContagemPessoasPorCargoEIdade(List<Pessoa> pessoas) {
        return pessoas.stream()
                .collect(Collectors.groupingBy(
                        Pessoa::getCargo,                             // primeiro nível: cargo
                        Collectors.groupingBy(
                                Pessoa::getIdade,                       // segundo nível: idade
                                Collectors.counting()                   // contar quantas pessoas com essa idade
                        )
                ));
    }
}
