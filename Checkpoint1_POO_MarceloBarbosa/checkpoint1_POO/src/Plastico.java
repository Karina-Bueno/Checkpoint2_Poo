public class Plastico extends Material implements CobrarTaxa{
    private double taxa = 1.10;
    public Plastico(double valor, double peso) {
        super(valor, peso);
    }

    public Plastico(){};
    //sobrescrita da classe pai Material.
    public Double calculaPreco() {
        if (this.getPeso() > 0 ) {
            return this.getValor();
        } else {
            return calcularValor(getPeso(), taxa);
        }
    }

    //implementação da interface CalcularTaxa.
    @Override
    public double calcularValor(double peso, double taxa) {
        return peso * this.getValor() * taxa;
    }

    @Override
    public double calcularValor(double peso, double taxa, double taxaRisco) {return 0;}
}
