package provedores;

public class Sedex implements ProvedorFrete {
    public Frete calcularFrete(double peso, double valor) {
        double taxa = (peso > 1000) ? 0.10 : 0.05;
        return new Frete(valor * taxa, TipoProvedorFrete.SEDEX);
    }

    public TipoProvedorFrete obterTipoProvedorFrete() {
        return TipoProvedorFrete.SEDEX;
    }
}