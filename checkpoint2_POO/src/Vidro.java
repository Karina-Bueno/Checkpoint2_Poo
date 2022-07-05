public class Vidro extends Material implements CobrarTaxa{
    private double addRisco = 1.25;
    private double taxa = 1.10;

    public Vidro(){};
    
    public Vidro(double valor, double peso, double addRisco, double taxa) {
		super(valor, peso);
		this.addRisco = addRisco;
		this.taxa = taxa;
	}


	//sobrescrita da classe pai Material.
    @Override
    public Double calculaPreco() {
        if (this.getPeso() == 0){
            return 0.0;
        }
        else if (this.getPeso() <= 1 ) {
            return calcularValor(this.getPeso(),taxa);
        }
        else {
            return calcularValor(this.getPeso(),taxa,addRisco);

        }
    }


    //implementação da interface CalcularTaxa.
    @Override
    public double calcularValor(double peso, double taxa) {
        return peso*this.getValor()*taxa;
    }

    @Override
    public double calcularValor(double peso, double taxa, double taxaRisco) {
        return peso * this.getValor() * taxa * taxaRisco;
    }
}
