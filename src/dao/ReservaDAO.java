/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelo.Reservas;
import org.mariadb.jdbc.Statement;

/**
 *
 * @author igor
 */
public class ReservaDAO {

    private Connection connection;

    public ReservaDAO(Connection connection) {
        this.connection = connection;
    }

    public void salvar(Reservas reservas) {
        try {
            String sql = "INSERT INTO reservas (data_entrada, data_saida, valor, forma_pagamento) VALUES(?,?,?,?)";

            try (PreparedStatement pst = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                pst.setDate(1, reservas.getDataEntrada());
                pst.setDate(2, reservas.getDataSaida());
                pst.setInt(3, reservas.getValor());
                pst.setString(4, reservas.getFormaPagamento());

                pst.executeUpdate();

                try (ResultSet rst = pst.getGeneratedKeys()) {
                    while (rst.next()) {
                        reservas.setId(rst.getInt(1));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
