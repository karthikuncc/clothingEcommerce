package com.clothingcloset.models;

public class Donation {

	private Integer id;
	private String email;
	private String dateOfDonation;
	private Integer checked;
	private String itemName;
	private String size;
	private Integer quantity;
	private String color;
	private String item_Condition;
	private String description;
	private String gender;
	private String brand;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDateOfDonation() {
		return dateOfDonation;
	}

	public void setDateOfDonation(String dateOfDonation) {
		this.dateOfDonation = dateOfDonation;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getChecked() {
		return checked;
	}

	public void setChecked(Integer checked) {
		this.checked = checked;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getItem_Condition() {
		return item_Condition;
	}

	public void setItem_Condition(String item_Condition) {
		this.item_Condition = item_Condition;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	@Override
	public String toString() {
		return "Donation [id=" + id + ", email=" + email + ", dateOfDonation=" + dateOfDonation + ", checked=" + checked
				+ ", itemName=" + itemName + ", size=" + size + ", quantity=" + quantity + ", color=" + color
				+ ", item_Condition=" + item_Condition + ", description=" + description + ", gender=" + gender
				+ ", brand=" + brand + "]";
	}

}
