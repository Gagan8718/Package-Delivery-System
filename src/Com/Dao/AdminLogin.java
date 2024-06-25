package Com.Dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Com.connection.DatabaseConnection;

public class AdminLogin {
    private Connection connection;

    public AdminLogin() {
        // Assign the database connection to the class field
        connection = DatabaseConnection.getConnection();
    }

    public boolean authenticateAdmin(String loginId, String password) {
        String sql = "SELECT * FROM admin WHERE login_id = ? AND password = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, loginId);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ResultSet getSenderData() {
        String sql = "SELECT * FROM senders";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public void displaySenderData() {
        ResultSet senderData = getSenderData();
        if (senderData != null) {
            try {
                System.out.println("Sender Data:");
                while (senderData.next()) {
                    int id = senderData.getInt("id");
                    String name = senderData.getString("name");
                    String address = senderData.getString("address");
                    String mobileNumber = senderData.getString("mobile_number");

                    System.out.println("ID: " + id);
                    System.out.println("Name: " + name);
                    System.out.println("Address: " + address);
                    System.out.println("Mobile Number: " + mobileNumber);
                    System.out.println();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Failed to fetch sender data.");
        }
    }
    
    public void assignDeliveryMan(int senderId, int deliveryManId) {
        SenderDAO senderDAO = new SenderDAO(); // Create an instance of SenderDAO
        senderDAO.assignDeliveryMan(senderId, deliveryManId);
    }
}

