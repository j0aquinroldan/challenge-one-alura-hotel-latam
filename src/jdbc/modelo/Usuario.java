package jdbc.modelo;

public class Usuario {
	
	public Usuario(String id, String contrasenha) {
		this.id = id;
		this.contrasenha = contrasenha;
	}
	private String id;
	private String contrasenha;
	public String getId() {
		return id;
	}
	public String getContrasenha() {
		return contrasenha;
	}
	
	

}
