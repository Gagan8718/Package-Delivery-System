package Com.Dao;


import java.sql.SQLException;
import java.util.List;

import Com.bean.Sender;
import Exception.PackageDeliveryException;

public interface Senderinterface {
      
	
	 public void insertSender();
	 public void updatePackageStatus();
	 public List<Sender> getSentDataWithStatus();
	 public void sendWithPackageId();
	 public void assignDeliveryMan();
	void insertSender(Sender sender);
	void updatePackageStatus(int senderId, String status);
	void sendWithPackageId(int packageId, String status, int senderId);
	void assignDeliveryMan(int senderId, int deliveryManId);
	public void deleteSender(int senderId);
	
	
}
