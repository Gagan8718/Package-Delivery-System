package Com.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import Com.Dao.AdminLogin;
import Com.Dao.DeliveryManLogin;
import Com.Dao.SenderDAO;
import Com.bean.Sender;
import Com.connection.DatabaseConnection;

public class Main {
    public static void main(String[] args) { 
        Scanner scanner = new Scanner(System.in);
        SenderDAO senderDAO = new SenderDAO();
        AdminLogin adminLogin = new AdminLogin();
        boolean isAdminLoggedIn = false;
        Sender sender = new Sender();
        
        DeliveryManLogin deliveryManLogin = new DeliveryManLogin();
      

        while (true) {
        	System.out.println("<<****************************************>>");
        	System.out.println("<<                                        >>");
        	System.out.println("<<***Welcome To Package Delivery System***>>");
        	System.out.println("<<                                        >>");
        	System.out.println("<<****************************************>>");
        	System.out.println("<<________________________________________>>");	
        	System.out.println("<<                                        >>");
        	System.out.println("<<            1.Package Send              >>");
            System.out.println("<<            2.Admin Login               >>");
            System.out.println("<<         3.Delivery Man Login           >>");         
            System.out.println("<<________________________________________>>");
            System.out.println("<<****************************************>>");
            System.out.println("<<            Enter your choice:          >>");
            System.out.println("<<****************************************>>");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                   
//                    System.out.print("Enter Sender ID: ");
//                    int id = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Enter Sender Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Sender Address: ");
                    String address = scanner.nextLine();
                    System.out.print("Enter Sender Mobile Number: ");
                    String mobileNumber = scanner.nextLine();

                    // Set sender data using setter methods
//                    sender.setId(id);
                    sender.setName(name);
                    sender.setAddress(address);
                    sender.setMobileNumber(mobileNumber);

                    senderDAO.insertSender(sender);
                    System.out.println("Sender data added successfully.");
                    break;

                case 2:
                    // Admin login
                    System.out.print("Enter login ID: ");
                    String loginId = scanner.next();
                    System.out.print("Enter password: ");
                    String password = scanner.next();
                    if (adminLogin.authenticateAdmin(loginId, password)) {
                        System.out.println("Login successful.");

                        

                        // Admin menu
                        while (true) {
 
                        	System.out.println("<<****************************************>>");
                        	System.out.println("<<                                        >>");
                            System.out.println("<<***************Admin Menu:**************>>");
                        	System.out.println("<<________________________________________>>");	
                        	System.out.println("<<                                        >>");
                            System.out.println("<<          1. Assign Delivery Man        >>");
                            System.out.println("<<    2. Display Sender Data with Status  >>");
                            System.out.println("<<           3. Delete Sender Data        >>");
                            System.out.println("<<                4. Logout               >>");
                            System.out.println("<<________________________________________>>");
                        	System.out.println("<<****************************************>>");
                            System.out.println("<<            Enter your choice:          >>");
                        	System.out.println("<<****************************************>>");
 
                            int adminChoice = scanner.nextInt();
                            scanner.nextLine(); // Consume the newline character

                            if (adminChoice == 1) {
                                // Code for assigning delivery man
                                System.out.print("Enter Sender ID to assign a delivery man: ");
                                int senderIdToAssign = scanner.nextInt();
                                System.out.print("Enter Delivery Man ID: ");
                                int deliveryManIdToAssign = scanner.nextInt();
                                adminLogin.assignDeliveryMan(senderIdToAssign, deliveryManIdToAssign);
                            } else if (adminChoice == 2) {
                                // Display sender data with status
                            	   // Display sent data with delivery statuses
                                List<Sender> sentDataWithStatus = senderDAO.getSentDataWithStatus();
                                System.out.println("Sent Data with Delivery Status:");
                                for (Sender sent : sentDataWithStatus) {
                                    System.out.println("Sender ID: " + sent.getId());
                                    System.out.println("Name: " + sent.getName());
                                    System.out.println("Address: " + sent.getAddress());
                                    System.out.println("Mobile Number: " + sent.getMobileNumber());
                                    System.out.println("Package ID: " + sent.getPackageId());
                                    System.out.println("Package Status: " + sent.getPackageStatus());
                                    System.out.println();
                                }
                            } else if (adminChoice == 3) {
                                // Delete Data
                          
                            	 System.out.print("Enter Sender ID to delete: ");
                            	    int senderIdToDelete = scanner.nextInt();
                            	    senderDAO.deleteSender(senderIdToDelete);
                            	    // System.out.println("Sender data deleted successfully.");
                            } else if (adminChoice == 4) {
                                // Logout admin
                                break;
                            } else {
                                System.out.println("Invalid choice. Please try again.");
                            }
                        }
                    } else {
                        System.out.println("Login failed. Invalid credentials.");
                    }
                    break;
               
                case 3:
                    
                    // Delivery man login
                    System.out.println("Enter Delivery Man ID: ");
                    String deliveryManid =scanner.next();
                    System.out.println("Enter password: ");
                    String deliveryManPassword =scanner.next();
                    if (deliveryManLogin.authenticateDeliveryMan(deliveryManid, deliveryManPassword)) {
                        System.out.println("Delivery Man Login Successful.");
                        

                        // Admin menu
                        while (true) {
                        	System.out.println("<<****************************************>>");
                        	System.out.println("<<                                        >>");
                            System.out.println("<<***********Delivery Man Menu:***********>>");
                        	System.out.println("<<________________________________________>>");	
                        	System.out.println("<<                                        >>");
                            System.out.println("<<      1. Show available sender data     >>");
                            System.out.println("<<        2. Send with package id         >>");
                            System.out.println("<<               3. Logout                >>");
                            System.out.println("<<                4.)exit                 >>");
                        	System.out.println("<<________________________________________>>");	
                        	System.out.println("<<****************************************>>");
                            System.out.println("<<            Enter your choice:          >>");
                        	System.out.println("<<****************************************>>");
                            int Choice = scanner.nextInt();
                            scanner.nextLine(); // Consume the newline character
                            if (Choice == 1) {
                                // Code for Display data
  adminLogin.displaySenderData();
                            } else if (Choice == 2) {
                                // send with package id
  System.out.print("Enter package Id: ");
                        int packageId = scanner.nextInt();
                        System.out.print("Enter Sender Id: ");
                        int senderId = scanner.nextInt();
                        scanner.nextLine(); 

                        // Update the package ID and status in the database
                        senderDAO.sendWithPackageId(packageId, "Delivered", senderId);
                            	  
                                }
                             else if (Choice == 3) {
                                // Logout admin
                                break;
                            } else {
                                System.out.println("Invalid choice. Please try again.");
                            }
                        }
                    } else {
                        System.out.println("Login failed. Invalid credentials.");
                    }
                    break;
                    
                case 4:
                    // Exit the program
                	boolean consoleExit = true; // Set the exit flag to true
                    System.out.println("Exiting Console From Package Delivery System. Goodbye!!!!");
                    System.exit(0); 
                    break;
               
                
               

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
