package Com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Scanner;

import Com.bean.DeliveryMan;
import Com.bean.Sender;
import Com.connection.DatabaseConnection;

public class DeliveryManLogin {
	 private Connection connection;
   

    public DeliveryManLogin() {
    	connection = DatabaseConnection.getConnection();
    }

    public boolean authenticateDeliveryMan(String deliveryManId, String password) {
        String sql = "SELECT * FROM Dman WHERE login_id = ? AND password = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, deliveryManId);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
             e.printStackTrace();
            return false;  
        }
    }
}
