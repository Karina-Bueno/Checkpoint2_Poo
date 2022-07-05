public class UsuarioException extends Exception{
	
	public UsuarioException() {}
	
	public UsuarioException(String mensagem) {
		super(mensagem);
	}

	@Override
	public String toString() {
		return "Exceção: " + this.getClass().getName() + "\n" + "Mensagem: " + this.getMessage();
	}
	
}
