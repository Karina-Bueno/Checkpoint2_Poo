/*
Autores: João Victor, Karina Bueno, Marcelo Barbosa

Idea do Projeto:
ReECOlha
    Vemos que a cada ano os recursos do nosso planeta estão ficando escassos e a população continua analfabeta em relação a separação dos
    materiais recicláveis dos orgânicos. Com base nessa informação, é cada vez mais preciso conscientizar as pessoas para a separação
    do lixo e o descarte correto.
    Para isso, é preciso que além de políticas públicas, também existam meios para que as pessoas possam encontrar lugares que recebam ou
    recolham os materiais recicláveis, uma vez que muitas das cidades não possuem tais recolhimentos. Como base, em uma cidade como o Paranoá
    e com aproximadamente umas 60 mil pessoas, só existe uma organização que recebe os materiais recicláveis, porém não existem formas de
    recolhimento e uma completa desinformação de como contribuir para a separação do lixo.
    A solução desse problema seria unir os habitantes dessa cidade, a organização e os possíveis recolhedores em um app que a princípio
    se chamaria ReECOlha. Esse app permitiria, a princípio, o cadastro dos habitantes que fariam parte dessa rede de separação do lixo,
    motoristas com disponibilidade para o recolhimento dos materiais recicláveis e organizações que realizam a separação dos materiais
    para a reciclagem. Com o pagamento de uma taxa, o Residente poderia solicitar um ReECOlhedor e esse levaria os materiais recicláveis
    para as Organizações recicladoras.

*/

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Checkpoint {
    public static void main(String[] args) {
        Empresa empresa = new Empresa("123456789");
        UsuarioFactory usuario = UsuarioFactory.getInstance();
        MaterialFactory material = MaterialFactory.getInstance();
        int x = 1;
        int resposta = 0;
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
        //Cria algumas informações dos objetos Recolhedor e Organização
        try {
			criarRecolhedorOrganizacao(empresa, usuario);
		} catch (UsuarioException e) {
			e.printStackTrace();
		}

        while (x != 0) {
            try {
                resposta = mostraMenu();

                while (resposta != 1 && resposta != 2 && resposta != 3 && resposta != 4 && resposta != 0) {
                    System.out.println("Digite: [1], [2], [3], [4] ou [0] ");
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

            x = resposta;
            
        }
    }
    public static int mostraMenu(){
        Scanner leia = new Scanner (System.in);
        System.out.println("Escolha uma das opções abaixo:");
        System.out.println("\n Digite [1]- Cadastrar Organização de recicláveis");
        System.out.println("\n Digite [2]- Cadastrar Coletor de recicláveis");
        System.out.println("\n Digite [3]- Cadastrar Residente com lixo reciclável");
        System.out.println("\n Digite [4]- Cadastrar agendamento");
        System.out.println("\n Digite [0]- para Sair");
        
        return Integer.parseInt(leia.nextLine());}
    
    public static void indicarMateriais(Agendamento agendamento, MaterialFactory material, Empresa empresa) throws MaterialException {
    	Scanner leia = new Scanner (System.in);
    	String ler;
    	double peso;
    	System.out.println("Informe os materiais: ");
    	System.out.println("É papel? (S)im ou (N)ão");
    	ler = leia.next();
    	
    	if(ler.equals("S")) { 
    		System.out.println("Qual o peso? ");
    		peso = leia.nextDouble();
    		agendamento.addMateriais(material.criarMaterial("P", empresa.getPapel(), peso));
    	}

    	System.out.println("É plástico? (S)im ou (N)ão");
    	ler = leia.next();
    	
    	if(ler.equals("S")) {
    		System.out.println("Qual o peso? ");
    		peso = leia.nextDouble();
    		agendamento.addMateriais(material.criarMaterial("L", empresa.getPlastico(), peso));
    	}

    	System.out.println("É metal? (S)im ou (N)ão");
    	ler = leia.next();
    	
    	if(ler.equals("S")) {
    		System.out.println("Qual o peso? ");
    		peso = leia.nextDouble();
    		agendamento.addMateriais(material.criarMaterial("M", empresa.getMetal(), peso));
    	}

    	System.out.println("É Vidro? (S)im ou (N)ão");
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

        //Criação de Recolhedores do lixo reciclável
    	empresa.addUsuario(usuario.criarUsuario("R", 1234567891,"Karina", "11111-1111", "karina@gmail.com"));
        Recolhedor r = empresa.getLocalizarRecolhedor(1234567891, usuario.getListaRecolhedor());
        r.cadastrarVeiculo("ABC102", "Renaut", 1);
        empresa.addUsuario(usuario.criarUsuario("R", 234561234,"Jo�o", "22222-2222", "joao@gmail.com"));
        Recolhedor r1 = empresa.getLocalizarRecolhedor(234561234, usuario.getListaRecolhedor());
        r1.cadastrarVeiculo("ACB345", "Fiat", 2);
        empresa.addUsuario(usuario.criarUsuario("R", 299493848,"Marcelo", "33333-3333", "marcelo@gmail.com"));
        Recolhedor r2 = empresa.getLocalizarRecolhedor(299493848, usuario.getListaRecolhedor());
        r2.cadastrarVeiculo("ABC458", "GM", 1);
        empresa.addUsuario(usuario.criarUsuario("R", 829282922,"Maria Silva", "4444-4444", "mariasilva@gmail.com"));
        Recolhedor r3 = empresa.getLocalizarRecolhedor(829282922, usuario.getListaRecolhedor());
        r3.cadastrarVeiculo("PLR6454", "FORD", 3);
        empresa.addUsuario(usuario.criarUsuario("R", 787879790,"Carlos Jorge", "5555-5555", "carlosjorge@gmail.com"));
        Recolhedor r4 = empresa.getLocalizarRecolhedor(787879790, usuario.getListaRecolhedor());
        r4.cadastrarVeiculo("ITC6AD4", "FORD", 4);
        empresa.addUsuario(usuario.criarUsuario("R", 565678333,"Jurandir Borges", "6666-6666", "jurandirborges@gmail.com"));
        Recolhedor r5 = empresa.getLocalizarRecolhedor(565678333, usuario.getListaRecolhedor());
        r5.cadastrarVeiculo("PAS5SE1", "CHEVROLET", 5);

        //Criação das Organizações de recicláveis
        Usuario u = empresa.addUsuario(usuario.criarUsuario("O", 28384884, "Eco Vida", "00000000", "ecovida@gmail.com"));
        u.cadastrarEndereco("Rua 01", "Perto do parque", "Jd. das Flores", 29328382);
        Usuario u1 = empresa.addUsuario(usuario.criarUsuario("O", 459568968, "Ecologico", "111111111", "ecologico@gmail.com"));
        u1.cadastrarEndereco("Rua 02", "Perto da Padaria", "Jd. das Pedras", 395385946);
        Usuario u2 = empresa.addUsuario(usuario.criarUsuario("O", 934839539, "AmorEco", "22222222", "amoreco@gmail.com"));
        u2.cadastrarEndereco("Rua 03", "Perto do Posto de Gasolina", "Jd. das Aguas", 54968569);
        Usuario u3 = empresa.addUsuario(usuario.criarUsuario("O", 635373833, "Arvoreco", "3333333", "arvoreco@gmail.com"));
        u3.cadastrarEndereco("Rua 04", "Perto do Bar do Zico", "Vila das Almas", 75683739);

        //Usuários residentes com lixos recicláveis
        Usuario d = empresa.addUsuario(usuario.criarUsuario("D",124245667, "Marcelo", "8873939390", "marogoba@gmail.com"));
        d.cadastrarEndereco("Rua das Oliverias", "Perto do restaurante Caverna", "Brasil 21", 15262627);
        Usuario d1 = empresa.addUsuario(usuario.criarUsuario("D",130898454, "Luiz", "983938388", "luiz@gmail.com"));
        d1.cadastrarEndereco("Avenida Brasil", "Lucas Car Lavajato", "Centro", 42525272);
    }
        
}

	
