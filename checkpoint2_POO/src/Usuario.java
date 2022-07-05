public class Usuario implements Comparable<Usuario> {

	protected int cpf_cnpj;
	protected String nome;
	protected String email;
	protected String telefone;
	private Endereco endereco;

	public Usuario(int id, String nome, String email, String telefone) {
		this.cpf_cnpj = id;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
	}

	public Usuario() {
	};

	public void cadastrarEndereco(String logradouro, String referencia, String bairro, int cep) {
		this.endereco = new Endereco(logradouro, referencia, bairro, cep);
	}

	public void imprimirEndereco() {
		this.endereco.imprimirEndereco();
	}

	@Override
	public int compareTo(Usuario o) {
		if (o.cpf_cnpj == this.cpf_cnpj) {
			//System.out.println("Usuário já cadastrado");
			return 0;
		} else if (o.cpf_cnpj < this.cpf_cnpj) {
			//System.out.println("Usuário menor que o outro");
			return -1;
		} else {
			//System.out.println("Usuário maior que o outro");
			return 1;
		}
	}

	public int getCpf_cnpj() {
		return cpf_cnpj;
	}

	public void setCpf_cnpj(int cpf_cnpj) {
		this.cpf_cnpj = cpf_cnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}
