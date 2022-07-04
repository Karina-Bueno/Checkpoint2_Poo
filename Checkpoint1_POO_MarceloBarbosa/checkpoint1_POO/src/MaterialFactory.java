public class MaterialFactory {
    private static MaterialFactory instance;
    private MaterialFactory(){};
    public static MaterialFactory getInstance(){
        if(instance == null){
            instance = new MaterialFactory();
        }
        return instance;
    }

    public Material criarMaterial(String tipo, double valor, double peso){
        if (tipo.equals("V")){
            Vidro vidro= new Vidro();
            vidro.setValor(valor);
            vidro.setPeso(peso);
            return vidro;
        }
        else if (tipo.equals("M")){
            Metal metal= new Metal();
            metal.setValor(valor);
            metal.setPeso(peso);
            return metal;
        }
        else if (tipo.equals("L")){
            Plastico plastico= new Plastico();
            plastico.setValor(valor);
            plastico.setPeso(peso);
            return plastico;
        }
        else if (tipo.equals("P")){
            Papel papel= new Papel();
            papel.setValor(valor);
            papel.setPeso(peso);
            return papel;
        }
        return null;
    };
}
