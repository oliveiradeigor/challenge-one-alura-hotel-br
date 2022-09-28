/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;

/**
 *
 * @author igor
 */
public class ConnectionFactory {
    public DataSource dataSource;
    
    public ConnectionFactory(){
        ComboPooledDataSource combo = new ComboPooledDataSource();
        combo.setJdbcUrl("jdbc:mariadb://localhost/holtelalura?useTimezone=true&serverTimezone=UTC");
        //combo.setJdbcUrl("jdbc:mariadb://localhost/hotelalura");
        //combo.setJdbcUrl("jdbc:mariadb://localhost/holtelalura");
        combo.setUser("igor");
        combo.setPassword("0122");
        
        dataSource = combo;
    }
    
    public Connection recuperarConexao(){
        try {
            return this.dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
       
    }
    
}
