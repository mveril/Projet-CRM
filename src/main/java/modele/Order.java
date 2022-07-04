package model;

public class Order {

	private Long id;
	private Client client;
	private String typePresta;
	private String designation;
	private long nbDays;
	private float unitPrice;
	private long state;
	private float totalExcludeTaxe;
	private float totalWithTaxe;
	
	public Order() {
		
	}
	
	

	public Order(Client client, String typePresta, String designation, long nbDays, float unitPrice, long state,
			float totalExcludeTaxe, float totalWithTaxe) {
		super();
		this.client = client;
		this.typePresta = typePresta;
		this.designation = designation;
		this.nbDays = nbDays;
		this.unitPrice = unitPrice;
		this.state = state;
		this.totalExcludeTaxe = totalExcludeTaxe;
		this.totalWithTaxe = totalWithTaxe;
	}
	
	
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}


	public Client getClient() {
		return client;
	}



	public void setClient(Client client) {
		this.client = client;
	}



	public String getTypePresta() {
		return typePresta;
	}



	public void setTypePresta(String typePresta) {
		this.typePresta = typePresta;
	}



	public String getDesignation() {
		return designation;
	}



	public void setDesignation(String designation) {
		this.designation = designation;
	}



	public long getNbDays() {
		return nbDays;
	}



	public void setNbDays(long nbDays) {
		this.nbDays = nbDays;
	}



	public float getUnitPrice() {
		return unitPrice;
	}



	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}



	public long getState() {
		return state;
	}



	public void setState(long state) {
		this.state = state;
	}



	public float getTotalExcludeTaxe() {
		return totalExcludeTaxe;
	}



	public void setTotalExcludeTaxe(float totalExcludeTaxe) {
		this.totalExcludeTaxe = totalExcludeTaxe;
	}



	public float getTotalWithTaxe() {
		return totalWithTaxe;
	}

	public void setTotalWithTaxe(float totalWithTaxe) {
		this.totalWithTaxe = totalWithTaxe;
	}
	
	@Override
	public String toString() {
		return String.format(
				"Order [id=%s, client=%s, typePresta=%s, designation=%s, nbDays=%s, unitPrice=%s, state=%s, totalExcludeTaxe=%s, totalWithTaxe=%s]",
				id, client, typePresta, designation, nbDays, unitPrice, state, totalExcludeTaxe, totalWithTaxe);
	}	
}
