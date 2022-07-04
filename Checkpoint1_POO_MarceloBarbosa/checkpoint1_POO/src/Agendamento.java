import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class Agendamento {

    private Recolhedor recolhedor;
    private Usuario residente;
    private Organizacao organizacao;
    private Date data;

    private int id;
    //criar uma array pro material
    private ArrayList<Material> listaMaterial = new ArrayList<>();
    private Veiculo veiculo;

    public ArrayList<Material> getListaMaterial() {
        return listaMaterial;
    }

    public void setListaMaterial(ArrayList<Material> listaMaterial) {
        this.listaMaterial = listaMaterial;
    }

    public void imprimirRecibo(){
        System.out.println("Recibo de Busca");
        System.out.println("Buscar Material de : " + this.residente.getNome());
        this.residente.imprimirEndereco();
        System.out.println("Recolhedor: " + this.recolhedor.getNome());
        System.out.println("Empresa Entrega: " + this.organizacao.getNome());
        this.organizacao.imprimirEndereco();
        System.out.println("Valor total a pagar: R$ " + calcularTotal());
    }
    public void addMateriais(Material material){
        listaMaterial.add(material);
    };

    private double calcularTotal(){
        double soma=0.0;
        for (Material m:listaMaterial){
            soma+=m.calculaPreco();
        }
        return soma;
    };


    public void escolhaVeiculo(Veiculo veiculo){
        this.veiculo = veiculo;
    }

    public Agendamento(Usuario residente, Recolhedor recolhedor, Organizacao organizacao, Date data) throws DataException {
        Date hoje = new Date();
        
        if(data.before(hoje)) {
        	throw new DataException("Data do agendamento deve ser posterior a hoje.");
        }
        
        this.id = GeradorId();
        this.residente = residente;
        this.recolhedor = recolhedor;
        this.organizacao = organizacao;
        this.data = data;
        
    }

    public int GeradorId() {
    	Random gerador = new Random();
    	return gerador.nextInt();
    }
    
    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }
    public Recolhedor getRecolhedor() {
        return recolhedor;
    }

    public void setRecolhedor(Recolhedor recolhedor) {
        this.recolhedor = recolhedor;
    }

    public Usuario getResidente() {
        return residente;
    }

    public void setResidente(Usuario residente) {
        this.residente = residente;
    }

    public Organizacao getOrganizacao() {
        return organizacao;
    }

    public void setOrganizacao(Organizacao organizacao) {
        this.organizacao = organizacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

}
