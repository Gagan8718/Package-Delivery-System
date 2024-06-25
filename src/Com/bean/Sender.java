package Com.bean;

public class Sender {
    private int id;
    private String name;
    private String address;
    private String mobileNumber;
    public Sender(int id, String name, String address, String mobileNumber, int packageId, String packageStatus) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.mobileNumber = mobileNumber;
		this.packageId = packageId;
		this.packageStatus = packageStatus;
	}
	private int packageId;
    private String packageStatus; // New field
    private int deliveryManId;
	public Sender(int id, String name, String address, String mobileNumber, int packageId, String packageStatus,
			int deliveryManId) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.mobileNumber = mobileNumber;
		this.packageId = packageId;
		this.packageStatus = packageStatus;
		this.deliveryManId = deliveryManId;
	}
	public int getId() {
		return id;
	}
	public Sender(int packageId) {
		super();
		this.packageId = packageId;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public Sender(int id, String name, String address, String mobileNumber) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.mobileNumber = mobileNumber;
	}
	public Sender() {
		// TODO Auto-generated constructor stub
	}
	public int getPackageId() {
		return packageId;
	}
	public void setPackageId(int packageId) {
		this.packageId = packageId;
	}
	public String getPackageStatus() {
		return packageStatus;
	}
	public void setPackageStatus(String packageStatus) {
		this.packageStatus = packageStatus;
	}
	public int getDeliveryManId() {
		return deliveryManId;
	}
	public void setDeliveryManId(int deliveryManId) {
		this.deliveryManId = deliveryManId;
	}

    // Constructors, getters, and setters
}