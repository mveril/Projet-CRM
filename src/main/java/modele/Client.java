package modele;

public class Client {

	private Long   id;
    private String companyName;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private String zipCode;
    private String country;
    private String city ;
    private long state;
    
    
       
    public Client() { 
    }
    
	public Client(String companyName, String firstName, String lastName, String email, String phone, String address,
			String zipCode, String country, String city, long state) {
		super();
		this.companyName = companyName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.zipCode = zipCode;
		this.country = country;
		this.city = city;
		this.state = state;
	}
	
	







	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompany(String companyName) {
		this.companyName = companyName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public long getState() {
		return state;
	}

	public void setState(long state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", company=" + companyName + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", phone=" + phone + ", adresse=" + address + ", zipCode=" + zipCode
				+ ", country=" + country + ", city=" + city + ", state=" + state + "]";
	}

/*	@Override
	public boolean equals(Object obj) {
		if(((Client) obj).getId() != this.id) {
			return false;
		}
		
		return true;
	}*/
		

}
