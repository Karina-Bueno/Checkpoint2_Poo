import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
public class Empresa {
	
    private String cnpj;
    private double papel = 3.0;
    private double plastico = 5.0;
    private double vidro = 10.0;
    private double metal = 20.0;
    
    //criar usuarios
    private ArrayList<Usuario> listaUsuario = new ArrayList<>();

    public Empresa(String cnpj) {
        this.cnpj = cnpj;
    }
    //adicionar usuario
    public Usuario addUsuario(Usuario usuario){
        listaUsuario.add(usuario);
        return usuario;
    }
    
    public Usuario getLocalizaResidente(int cpf_cnpj) throws UsuarioException{
    	Collections.sort(listaUsuario);
    	for (Usuario usuario : listaUsuario) {
			if(usuario.cpf_cnpj == cpf_cnpj) {
				return usuario;
			}
		}
    	throw new UsuarioException("Residente não localizado");
    }
    
    public Recolhedor getLocalizaRecolhedor(int modelo, ArrayList<Recolhedor> listaRecolhedor) throws UsuarioException{
    	Collections.sort(listaRecolhedor);
    	for (Recolhedor r : listaRecolhedor) {
    		if(r.selecionarVeiculo(modelo) && r.isDisponivel()) {
    			return r;
    		}
    	}
    	throw new UsuarioException("Recolhedor não encontrado");
    }
    
    public Organizacao getLocalizarOrganizacao(ArrayList<Organizacao> listaOrganizacao) throws UsuarioException {
    	Collections.sort(listaOrganizacao);
    	Random gerador = new Random();
    	int index = gerador.nextInt(listaOrganizacao.size());
    	return listaOrganizacao.get(index);
    }
    
    public Recolhedor getLocalizarRecolhedor(int id, ArrayList<Recolhedor> listaRecolhedor) throws UsuarioException {
    	Collections.sort(listaRecolhedor);
    	for (Recolhedor recolhedor : listaRecolhedor) {
			if(recolhedor.cpf_cnpj == id) {
				return recolhedor;
			}
		}
    	throw new UsuarioException("Recolhedor não encontrado");
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public ArrayList<Usuario> getListaUsuario() {
        return listaUsuario;
    }

    public void setListaUsuario(ArrayList<Usuario> listaUsuario) {
        this.listaUsuario = listaUsuario;
    }
	public double getPapel() {
		return papel;
	}
	public void setPapel(double papel) {
		this.papel = papel;
	}
	public double getPlastico() {
		return plastico;
	}
	public void setPlastico(double plastico) {
		this.plastico = plastico;
	}
	public double getVidro() {
		return vidro;
	}
	public void setVidro(double vidro) {
		this.vidro = vidro;
	}
	public double getMetal() {
		return metal;
	}
	public void setMetal(double metal) {
		this.metal = metal;
	}
    
}
