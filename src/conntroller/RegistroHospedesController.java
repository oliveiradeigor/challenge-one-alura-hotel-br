/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conntroller;

import dao.RegistroHospedesDAO;
import dao.ReservaDAO;
import factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.RegistrosHospedes;

/**
 *
 * @author igor
 */
public class RegistroHospedesController {

    private RegistroHospedesDAO registroHospedeDAO;

    public RegistroHospedesController() {
        Connection connection = new ConnectionFactory().recuperarConexao();
        this.registroHospedeDAO = new RegistroHospedesDAO(connection);
    }

    public void salvar(RegistrosHospedes registro) {
        this.registroHospedeDAO.salvar(registro);
    }

    public List<RegistrosHospedes> listarHospedes() throws SQLException {  
        return this.registroHospedeDAO.listar();

    }
}
