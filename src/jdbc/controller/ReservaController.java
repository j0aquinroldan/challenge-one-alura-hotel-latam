package jdbc.controller;

import jdbc.dao.ReservaDao;
import jdbc.factory.ConnectionFactory;
import jdbc.modelo.Reserva;

public class ReservaController {
	
	private ReservaDao reservaDao;
	
	public ReservaController() {
		this.reservaDao = new ReservaDao(new ConnectionFactory().creaConexion());
	}
	
	public void guardar(Reserva r) {
		this.reservaDao.guardar(r);
	}

}
