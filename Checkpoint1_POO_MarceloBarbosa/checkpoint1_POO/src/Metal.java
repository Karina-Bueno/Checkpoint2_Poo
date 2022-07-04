public class Metal extends Material implements CobrarTaxa {

    private double addTaxa = 1.10;

    public Metal(){};
    public Metal(double valor, double peso) {
        super(valor, peso);
    }
    //sobrescrita da classe pai.
    @Override
    public Double calculaPreco() {
        if (this.getPeso() == 0){
            return 0.0;
        }
        else if (this.getPeso() <= 5 ) {
            return this.getValor() ;
        }
        else {
            return calcularValor(this.getPeso(),addTaxa);
        }
    }
    //implementação da interface CalcularTaxa.
    @Override
    public double calcularValor(double peso, double taxa) {
            return peso * this.getValor() * taxa;
    }

    @Override
    public double calcularValor(double peso, double taxa, double taxaRisco) {
        return 0;
    }
}
