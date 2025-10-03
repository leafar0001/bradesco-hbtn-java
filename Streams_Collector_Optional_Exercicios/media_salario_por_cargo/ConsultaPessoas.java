import java.util.*;
import java.util.stream.Collectors;

public class ConsultaPessoas {

    // Método para calcular a média de salário por cargo
    public static Map<String, Double> obterMediaSalarioPorCargo(List<Pessoa> pessoas) {
        return pessoas.stream()
                .collect(Collectors.groupingBy(
                        Pessoa::getCargo,                   // agrupa por cargo
                        Collectors.averagingDouble(Pessoa::getSalario)  // calcula média do salário
                ));
    }
}

