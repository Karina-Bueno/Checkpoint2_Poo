import java.util.Arrays;

public class DataException extends Exception{
	
	public DataException() {
		
	}
	
	public DataException(String mensagem) {
		super(mensagem);
	}

	@Override
	public String toString() {
		return "Exceção: " + this.getClass().getName() + "\n" + "Mensagem: " + this.getMessage(); 
	}

}
