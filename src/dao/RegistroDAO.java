/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelo.Registros;
import modelo.Reservas;
import org.mariadb.jdbc.Statement;

/**
 *
 * @author igor
 */
public class RegistroDAO {

    private Connection connection;

    public RegistroDAO(Connection connection) {
        this.connection = connection;
    }

    public void salvar(Registros registro) {
        try {
            String sql = "INSERT INTO hospedes (nome, sobrenome, data_nascimento, nacionalidade, telefone, reservas_id) VALUES (?,?,?,?,?,?)";

            try (PreparedStatement pst = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                pst.setString(1, registro.getNome());
                pst.setString(2, registro.getSobrenome());
                pst.setDate(3, registro.getDataNascimento());
                pst.setString(4, registro.getNacionalidade());
                pst.setString(5, registro.getTelefone());
                pst.setInt(6, registro.getReservas_id());
                

                pst.executeUpdate();

                try (ResultSet rst = pst.getGeneratedKeys()) {
                    while (rst.next()) {
                        registro.setId(rst.getInt(1));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
