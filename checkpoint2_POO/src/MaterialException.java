public class MaterialException extends Exception{
	
	public MaterialException() {
		
	}
	
	public MaterialException(String mensagem) {
		super(mensagem);
	}

	@Override
	public String toString() {
		return "Exce��o: " + this.getClass().getName() + "\n" + "Mensagem: " + this.getMessage();
	}
	
}
