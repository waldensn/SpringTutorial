/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springtutorial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author walde
 */
public class PostgresConnection {
    final private Connection con;
    
    public PostgresConnection() throws SQLException, ClassNotFoundException {
       Class.forName("org.postgresql.Driver");
       String host = System.getProperty("pg_host");
       String port = System.getProperty("pg_port");
       String database = System.getProperty("pg_database");
       String url = "jdbc:postgresql://" + host + ":" + port + "/" + database;
       String username = System.getProperty("pg_username");
       String password = System.getProperty("pg_password");
       con = DriverManager.getConnection(url, username, password);
    }
    
    public Connection getConnection(){
        return con;
    }
}
