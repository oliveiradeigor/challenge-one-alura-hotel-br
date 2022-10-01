/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.RegistrosHospedes;
import modelo.Reservas;
import org.mariadb.jdbc.Statement;

/**
 *
 * @author igor
 */
public class RegistroHospedesDAO {

    private Connection connection;

    public RegistroHospedesDAO(Connection connection) {
        this.connection = connection;
    }

    public void salvar(RegistrosHospedes registro) {
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

    public List<RegistrosHospedes> listar() throws SQLException {
        List<RegistrosHospedes> rh = new ArrayList<RegistrosHospedes>();
        String sql = "SELECT * FROM hospedes";

        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.execute();

            trasformarResultSetEmrh(rh, pstm);
        }
        return rh;
    }
    
    /*public List<RegistrosHospedes> listar() {
        try {
            List<RegistrosHospedes> rh = new ArrayList<>();
            String sql = "SELECT * FROM hospedes";
            try (PreparedStatement pstm = connection.prepareStatement(sql)) {
                pstm.execute();
t               
                trasformarResultSetEmrh(rh, pstm);
               

                    }
                }
        return rh;*/
     

    

    

    private void trasformarResultSetEmrh(List<RegistrosHospedes> rhs, PreparedStatement pstm) throws SQLException {

        try (ResultSet rst = pstm.getResultSet()) {
            while (rst.next()) {
                RegistrosHospedes rh = new RegistrosHospedes(
                        rst.getInt(1),
                        rst.getString(2),
                        rst.getString(3),
                        rst.getDate(4),
                        rst.getString(5),
                        rst.getString(6),
                        rst.getInt(7)
                );
                rhs.add(rh);
            }
        }
    }

}
