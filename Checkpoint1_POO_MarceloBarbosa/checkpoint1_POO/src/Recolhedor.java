import java.util.ArrayList;
import java.util.Arrays;

public class Recolhedor extends Usuario {

    private ArrayList<Veiculo> listaVeiculo = new ArrayList<>() ;
    
    private boolean disponivel = true;

    public Recolhedor(){};

    public Recolhedor(int cpf_cnpj, String nome, String email, String telefone) {
        super(cpf_cnpj, nome, email, telefone);

    }

    public void cadastrarVeiculo(String placa, String marca, int modelo) {
    	listaVeiculo.add(new Veiculo(placa, marca, modelo));
    }

    public boolean selecionarVeiculo(int modelo){
        for (Veiculo veiculo : listaVeiculo) {
			if(veiculo.getModelo() == modelo) {
				return true;
			}
		}
        return false;
    }

	public boolean isDisponivel() {
		return disponivel;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}
}
