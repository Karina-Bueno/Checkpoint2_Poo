public class Veiculo {
    private String placa;
    private String marca;
    private int modelo;

    public void imprimirVeiculo(){
        System.out.println(this.placa + " " + this.modelo + " " + this.marca);
    }

    public Veiculo(String placa, String marca, int modelo) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
    }
    
    public enum ModeloCarro {
    	PICAPE(1),
    	CAMINHAO(2),
    	SEDAN(3),
    	FURGAO(4),
    	HATCH(5);
    	
    	public int valorCarro;
		ModeloCarro(int i) {
			valorCarro = i;
		}
		
		public int getValor() {
			return valorCarro;
		}
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getModelo() {
        return modelo;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }
}
