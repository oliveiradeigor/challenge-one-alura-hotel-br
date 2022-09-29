/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conntroller;

import dao.RegistroDAO;
import dao.ReservaDAO;
import factory.ConnectionFactory;
import java.sql.Connection;
import modelo.Registros;


/**
 *
 * @author igor
 */
public class RegistroController {
    private RegistroDAO registroDAO;
    
    public RegistroController(){
        Connection connection = new ConnectionFactory().recuperarConexao();
        this.registroDAO = new RegistroDAO(connection);
    }
    
    public void salvar(Registros registro){
        this. registroDAO.salvar(registro);
    }
}
