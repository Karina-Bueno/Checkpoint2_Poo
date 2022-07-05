
import java.util.ArrayList;

public class UsuarioFactory {
    private static UsuarioFactory instance;
    private UsuarioFactory(){};
    public static UsuarioFactory getInstance(){
        if(instance == null){
            instance = new UsuarioFactory();
        }
        return instance;
    }
    
    private ArrayList<Recolhedor> listaRecolhedor = new ArrayList<>();
    
    private ArrayList<Organizacao> listaOrganizacao = new ArrayList<>();
    
    public Usuario criarUsuario (String tipo,int cpf_cnpj, String nome, String email, String telefone){
        if (tipo.equals("D")){
            Residente residente = new Residente();
            residente.setNome(nome);
            residente.setEmail(email);
            residente.setTelefone(telefone);
            residente.setCpf_cnpj(cpf_cnpj);
            return residente;
        }
        else if (tipo.equals("R")){
            Recolhedor recolhedor = new Recolhedor();
            recolhedor.setNome(nome);
            recolhedor.setEmail(email);
            recolhedor.setTelefone(telefone);
            recolhedor.setCpf_cnpj(cpf_cnpj);
            listaRecolhedor.add(recolhedor);
            return recolhedor;
        }
        else if (tipo.equals("O")){
            Organizacao organizacao = new Organizacao();
            organizacao.setNome(nome);
            organizacao.setEmail(email);
            organizacao.setTelefone(telefone);
            organizacao.setCpf_cnpj(cpf_cnpj);
            listaOrganizacao.add(organizacao);
            return organizacao;
        }
        return null;
    }
    
	public ArrayList<Recolhedor> getListaRecolhedor() {
		return listaRecolhedor;
	}
	public ArrayList<Organizacao> getListaOrganizacao() {
		return listaOrganizacao;
	}
    
}
