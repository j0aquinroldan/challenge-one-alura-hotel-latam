package jdbc.controller;

import jdbc.dao.UsuarioDao;
import jdbc.factory.ConnectionFactory;
import jdbc.modelo.Usuario;

public class UsuarioController {
	
	private UsuarioDao usuarioDao;
	
	public UsuarioController() {
		this.usuarioDao = new UsuarioDao(new ConnectionFactory().creaConexion());
	}

	public boolean existe(Usuario u) {
		return this.usuarioDao.existe(u);
	}

}
