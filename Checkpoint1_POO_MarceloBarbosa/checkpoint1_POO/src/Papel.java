public class Papel extends Material{
    public Papel(double valor, double peso) {
        super(valor, peso);
    }
    public Papel(){};
    //sobrescrita da classe pai Material.
    @Override
    public Double calculaPreco() {
        if (this.getPeso() > 0 ) {
            return this.getValor();
        } else {
            return 0.0;
        }
    }
}
