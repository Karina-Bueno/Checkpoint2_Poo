import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Checkpoint {
    public static void main(String[] args) {
        Empresa empresa = new Empresa("123456789");
        UsuarioFactory usuario = UsuarioFactory.getInstance();
        MaterialFactory material = MaterialFactory.getInstance();
        int x = 1;
        int resposta = 0;
        int numero = 1;
        Scanner leia = new Scanner (System.in);

         String  nome;
         String  email;
         String telefone;
         int cpf_cnpj;
         String placa;
         String marca;
         int modelo;
         String logradouro;
         String referencia;
         String bairro;
         int cep;
         Date data;
         String dataStr;
         
        try {
			criarRecolhedorOrganizacao(empresa, usuario);
		} catch (UsuarioException e) {
			e.printStackTrace();
		}

        while (x != 0) {
            try {
                resposta = mostraMenu();

                while (resposta != 1 && resposta != 2 && resposta != 3 && resposta != 4) {
                    System.out.println("Digite [1], [2], [3] ou [4] ");
                    resposta = leia.nextInt();
                }
                if (resposta == 1){
                    Scanner user = new Scanner(System.in);
                    System.out.print("Nome: ");
                    nome = user.next();
                    System.out.println("Telefone: ");
                    telefone = user.next();
                    System.out.println("Email: ");
                    email = user.next();
                    System.out.println("CNPJ: ");
                    cpf_cnpj = user.nextInt();
                    Usuario u = empresa.addUsuario(usuario.criarUsuario("O", cpf_cnpj, nome, telefone, email));
                    System.out.println("Favor informar o endereço: ");
                    System.out.println("Logradouro: ");
                    logradouro = user.next();
                    System.out.println("Referência: ");
                    referencia = user.next();
                    System.out.println("Bairro: ");
                    bairro = user.next();
                    System.out.println("CEP: ");
                    cep = user.nextInt();
                    u.cadastrarEndereco(logradouro, referencia, bairro, cep);
                    System.out.println("");
                }
                else if (resposta == 2) {
                	Scanner user = new Scanner(System.in);
                    System.out.print("Nome: ");
                    nome = user.next();
                    System.out.print("Telefone: ");
                    telefone = user.next();
                    System.out.print("Email: ");
                    email = user.next();
                    System.out.print("CPF: ");
                    cpf_cnpj = user.nextInt();
                    empresa.addUsuario(usuario.criarUsuario("R", cpf_cnpj, nome, telefone, email));
                    Recolhedor r = empresa.getLocalizarRecolhedor(cpf_cnpj, usuario.getListaRecolhedor());
                    System.out.println("Informe o veículo: ");
                    System.out.print("Placa: ");
                    placa = user.next();
                    System.out.println("Modelos: (1)PICAPE,\r\n"
                    		+ "    	(2)CAMINHAO,\r\n"
                    		+ "    	(3)SEDAN,\r\n"
                    		+ "    	(4)FURGAO,\r\n"
                    		+ "    	(5)HATCH; ");
                    modelo = user.nextInt();
                    System.out.println("Marca: ");
                    marca = user.next();
                    r.cadastrarVeiculo(placa, marca, modelo);
                    System.out.println("");
                }
                else if (resposta == 3) {
                	Scanner user = new Scanner(System.in);
                    System.out.println("Nome: ");
                    nome = user.next();
                    System.out.println("Telefone: ");
                    telefone = user.next();
                    System.out.println("Email: ");
                    email = user.next();
                    System.out.println("CPF: ");
                    cpf_cnpj = user.nextInt();
                    Usuario u = empresa.addUsuario(usuario.criarUsuario("D",cpf_cnpj, nome, telefone, email));
                    System.out.println("Favor informar o endereço: ");
                    System.out.println("Logradouro: ");
                    logradouro = user.next();
                    System.out.println("Referência: ");
                    referencia = user.next();
                    System.out.println("Bairro: ");
                    bairro = user.next();
                    System.out.println("CEP: ");
                    cep = user.nextInt();
                    u.cadastrarEndereco(logradouro, referencia, bairro, cep);
                    System.out.println("");
                }
                else if (resposta == 4) {
                	Scanner user = new Scanner(System.in);
                    System.out.print("Informe o CPF do residente: ");
                    cpf_cnpj = user.nextInt();
                    Usuario residente = empresa.getLocalizaResidente(cpf_cnpj);
                    System.out.println("Escolha um dos modelos: (1)PICAPE,\r\n"
                    		+ "    	(2)CAMINHAO,\r\n"
                    		+ "    	(3)SEDAN,\r\n"
                    		+ "    	(4)FURGAO,\r\n"
                    		+ "    	(5)HATCH; ");
                    modelo = user.nextInt();
                    Recolhedor recolhedor = empresa.getLocalizaRecolhedor(modelo, usuario.getListaRecolhedor());
                    Organizacao organizacao = empresa.getLocalizarOrganizacao(usuario.getListaOrganizacao());
                    System.out.println("Qual data para recolher o reciclável? ");
                    dataStr = user.next();
                    data = new SimpleDateFormat("dd/MM/yyyy").parse(dataStr);
                    Agendamento agendamento = new Agendamento(residente, recolhedor, organizacao, data);
                    indicarMateriais(agendamento, material, empresa);
                    recolhedor.setDisponivel(false);
                    System.out.println("Agendamento criado com sucesso!");
                    agendamento.imprimirRecibo();
                    System.out.println("");
                }
                
            } catch(UsuarioException erro) {
            	System.out.println("Erro de usuário: " + erro.getMessage());
            } catch(MaterialException erro) {
            	System.out.println("Erro de material: " + erro.getMessage());
            } catch(DataException erro) {
            	System.out.println("Erro de data: " + erro.getMessage());
            } catch (Exception erro) {
                System.out.println("Erro encontrado: \n" + erro.getMessage());
            }
            
        }
    }
    public static int mostraMenu(){
        Scanner leia = new Scanner (System.in);
        System.out.println("escolha uma das opções abaixo:");
        System.out.println("\n Digite [1]- cadastrar organização de recicláveis");
        System.out.println("\n Digite [2]- cadastrar colaborador de recicláveis");
        System.out.println("\n Digite [3]- cadastrar usuário");
        System.out.println("\n Digite [4]- cadastrar agendamento");
        
        return Integer.parseInt(leia.nextLine());}
    
    public static void indicarMateriais(Agendamento agendamento, MaterialFactory material, Empresa empresa) throws MaterialException {
    	Scanner leia = new Scanner (System.in);
    	String ler;
    	double peso;
    	System.out.println("Informe os materiais: ");
    	System.out.println("É papel?(S)im ou (N)ão");
    	ler = leia.next();
    	
    	if(ler.equals("S")) { 
    		System.out.println("Qual o peso? ");
    		peso = leia.nextDouble();
    		agendamento.addMateriais(material.criarMaterial("P", empresa.getPapel(), peso));
    	}
    	
    	
    	System.out.println("É plástico?(S)im ou (N)ão");
    	ler = leia.next();
    	
    	if(ler.equals("S")) {
    		System.out.println("Qual o peso? ");
    		peso = leia.nextDouble();
    		agendamento.addMateriais(material.criarMaterial("L", empresa.getPlastico(), peso));
    	}
    	
    	
    	System.out.println("É metal?(S)im ou (N)ão");
    	ler = leia.next();
    	
    	if(ler.equals("S")) {
    		System.out.println("Qual o peso? ");
    		peso = leia.nextDouble();
    		agendamento.addMateriais(material.criarMaterial("M", empresa.getMetal(), peso));
    	}
    	
    	
    	System.out.println("É Vidro?(S)im ou (N)ão");
    	ler = leia.next();
    	
    	if(ler.equals("S")) {
    		System.out.println("Qual o peso? ");
    		peso = leia.nextDouble();
    		agendamento.addMateriais(material.criarMaterial("V", empresa.getVidro(), peso));
    	}
    	
    	if(agendamento.getListaMaterial().isEmpty()) {
    		throw new MaterialException("Nenhum material foi informado, o agendamento será cancelado.");
    	}
    }
    
    public static void criarRecolhedorOrganizacao(Empresa empresa, UsuarioFactory usuario) throws UsuarioException {
    	empresa.addUsuario(usuario.criarUsuario("R", 1234567891,"Karina", "11111-1111", "karina@gmail.com"));
        Recolhedor r = empresa.getLocalizarRecolhedor(1234567891, usuario.getListaRecolhedor());
        r.cadastrarVeiculo("ABC102", "Renaut", 1);
        empresa.addUsuario(usuario.criarUsuario("R", 234561234,"João", "22222-2222", "joao@gmail.com"));
        Recolhedor r1 = empresa.getLocalizarRecolhedor(234561234, usuario.getListaRecolhedor());
        r1.cadastrarVeiculo("ACB345", "Fiat", 2);
        empresa.addUsuario(usuario.criarUsuario("R", 299493848,"Marcelo", "33333-3333", "marcelo@gmail.com"));
        Recolhedor r2 = empresa.getLocalizarRecolhedor(299493848, usuario.getListaRecolhedor());
        r2.cadastrarVeiculo("ABC458", "GM", 1);
        
        Usuario u = empresa.addUsuario(usuario.criarUsuario("O", 28384884, "Eco Vida", "00000000", "ecovida@gmail.com"));
        u.cadastrarEndereco("Rua 01", "Perto do parque", "Jd. das Flores", 29328382);
        Usuario u1 = empresa.addUsuario(usuario.criarUsuario("O", 459568968, "Ecologico", "111111111", "ecologico@gmail.com"));
        u1.cadastrarEndereco("Rua 02", "Perto da Padaria", "Jd. das Pedras", 395385946);
        Usuario u2 = empresa.addUsuario(usuario.criarUsuario("O", 934839539, "AmorEco", "22222222", "amoreco@gmail.com"));
        u2.cadastrarEndereco("Rua 03", "Perto do Posto de Gasolina", "Jd. das Aguas", 54968569);
        
    }
        
}

	
