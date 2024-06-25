package Com.Dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Com.bean.Sender;
import Com.connection.DatabaseConnection;
import Exception.PackageDeliveryException;

public class SenderDAO  implements Senderinterface{
    private Connection connection;

    public SenderDAO() {
    	connection = DatabaseConnection.getConnection();
    }
@Override
    public void insertSender(Sender sender) {
        String sql = "INSERT INTO senders (id, name, address, mobile_number) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, sender.getId());
            preparedStatement.setString(2, sender.getName());
            preparedStatement.setString(3, sender.getAddress());
            preparedStatement.setString(4, sender.getMobileNumber());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
@Override
    public void updatePackageStatus(int senderId, String status) {
        String sql = "UPDATE senders SET package_status = ? WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, status);
            preparedStatement.setInt(2, senderId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
@Override
    public List<Sender> getSentDataWithStatus() {
        List<Sender> senders = new ArrayList<>();
        String sql = "SELECT * FROM senders";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Sender sender = new Sender();
                sender.setId(resultSet.getInt("id"));
                sender.setName(resultSet.getString("name"));
                sender.setAddress(resultSet.getString("address"));
                sender.setMobileNumber(resultSet.getString("mobile_number"));
                sender.setPackageId(resultSet.getInt("package_id"));
                sender.setPackageStatus(resultSet.getString("package_status"));
                senders.add(sender);
                
          
              
            }
        }
         catch (SQLException e) {
            e.printStackTrace();
        }
        return senders;
    }
@Override
    public void sendWithPackageId(int packageId, String status, int senderId){
        String sql = "UPDATE senders SET package_id=?, package_status=? WHERE id=?";
        String checkSql = "SELECT package_status FROM senders WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, packageId);
            preparedStatement.setString(2, status);
            preparedStatement.setInt(3, senderId);
            preparedStatement.executeUpdate();
            System.out.println("Package ID and Status updated successfully.");
            
            // Check statement
            PreparedStatement checkStatement = connection.prepareStatement(checkSql);
            checkStatement.setInt(1, senderId);
            ResultSet resultSet = checkStatement.executeQuery();

            if (resultSet.next()) {
                String currentStatus = resultSet.getString("package_status");
                
                // Check if the package has already been delivered
                if ("Delivered".equals(currentStatus)) {
                	//throw new PackageDeliveryException("Package has already been delivered and cannot be delivered again.");
                    System.out.println("Package has already been delivered and cannot be delivered again.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
@Override
public void deleteSender(int Id) {
    String sql = "DELETE FROM senders WHERE id = ?";
    try {
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,Id);
        
int rowsAffected = preparedStatement.executeUpdate();
        
        if (rowsAffected > 0) {
            System.out.println("Record deleted successfully.");
        } else {
            System.out.println("Cannot delete: ID not found in the database.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

 
    
@Override
    public void assignDeliveryMan(int senderId, int deliveryManId) {
        String sql = "UPDATE senders SET delivery_man_id = ? WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, deliveryManId);
            preparedStatement.setInt(2, senderId);
            preparedStatement.executeUpdate();
            System.out.println("Delivery man assigned successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
@Override
public void insertSender() {
	// TODO Auto-generated method stub
	
}
@Override
public void updatePackageStatus() {
	// TODO Auto-generated method stub
	
}
@Override
public void sendWithPackageId() {
	// TODO Auto-generated method stub
	
}
@Override
public void assignDeliveryMan() {
	// TODO Auto-generated method stub
	
}

}
