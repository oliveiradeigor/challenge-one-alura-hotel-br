/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conntroller;

import dao.ReservaDAO;
import factory.ConnectionFactory;
import java.sql.Connection;
import modelo.Reservas;

/**
 *
 * @author igor
 */
public class ReservasController {
    private ReservaDAO reservaDAO;
    
    public ReservasController(){
        Connection connection = new ConnectionFactory().recuperarConexao();
        this.reservaDAO = new ReservaDAO(connection);
    }
    
    public void salvar(Reservas reserva){
        this.reservaDAO.salvar(reserva);
    }
}
