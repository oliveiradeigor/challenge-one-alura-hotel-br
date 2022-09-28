/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author igor
 */
public class Test {
    public static void main(String[] args) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection conexao = connectionFactory.recuperarConexao();
        
        //System.out.println(conexao);
        
        
        
        System.out.println("fechando conexão");
        conexao.close();
        
    }
}
