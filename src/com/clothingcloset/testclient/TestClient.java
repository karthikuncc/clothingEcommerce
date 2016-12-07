package com.clothingcloset.testclient;

import java.util.Iterator;
import java.util.List;

import com.clothingcloset.handlers.ItemServiceHandler;
import com.clothingcloset.impl.DonationServiceImpl;
import com.clothingcloset.impl.LoginImpl;
import com.clothingcloset.models.Donation;
import com.clothingcloset.models.Item;
import com.clothingcloset.models.Person;
import com.clothingcloset.models.UserLogin;

public class TestClient {

	public static void main(String[] args) {
		
		TestClient testClient = new TestClient();
		boolean isUserRegistered= testClient.registerPerson();
		if(isUserRegistered){
			System.out.println("USER IS REGISTERED SUCCESSFULLY");
		}
		
//		boolean isValidUser = testClient.validateUser();
//		if(isValidUser){
//			System.out.println("VALID USER");
//		}else
//		{
//			System.out.println("INVALID USER");
//		}
//		boolean isItemDonated= testClient.donateItem();
//		if(isItemDonated){
//			System.out.println("SUCCESSFULLY DONATED WILL RECEIVE RECEIPT SHORTLY");
//		}else{
//			System.out.println("ITEM NOT DONATED PLEASE RETRY.");
//		}
		
		//testClient.displayItemsForChecking();
		
	}
	
	public  boolean registerPerson(){
		
		LoginImpl login = new LoginImpl();
		boolean isUserRegistered= false;
		
		Person person = new Person();
		person.setFirstName("Vijay");
		person.setLastName("Rawlani");
		person.setGender("Male");
		person.setMobileNumber("9803187958");
		person.setStreet("UTD");
		person.setCity("Charlotte");
		person.setState("NC");
		person.setPincode(28262);
		person.setEmail("vijay@yahoo.com");
		person.setSubscription("Y");
		person.setPassword("vijay");
		person.setRole("Alumni");
		person.setSubscriptionType("Weekly");
		
		
		isUserRegistered = login.registerPerson(person);
		
		return isUserRegistered;
	}
	
	public boolean validateUser(){
		LoginImpl login = new LoginImpl();
		UserLogin userLogin = new UserLogin();
		userLogin.setEmail("lollachaitanya@yahoo.com");
		userLogin.setPassword("xyz");
		
		boolean isValidUser = login.validateUser(userLogin);
		return isValidUser;
	}
	
	public boolean donateItem(){
		Donation donation = new Donation();
		donation.setEmail("lollachaitanya@yahoo.com");
		donation.setDateOfDonation("2016-11-11");
		donation.setChecked(1);
		donation.setItemName("Jeans");
		donation.setSize("M");
		donation.setQuantity(2);
		donation.setColor("Blue");
		donation.setItem_Condition("Good");
		donation.setDescription("BrandNew");
		donation.setGender("Male");
		donation.setBrand("Denimx");
		
		DonationServiceImpl donationServiceImpl = new DonationServiceImpl();
		return donationServiceImpl.donateItems(donation);
	}
	
	public void displayItemsForChecking(){
		DonationServiceImpl donationServiceImpl = new DonationServiceImpl();
		List<Donation> donations = donationServiceImpl.retrieveDonatedItems();
		
		Iterator<Donation> iterator = donations.iterator();
		while(iterator.hasNext()){
			Donation donation = iterator.next();
			System.out.println(donation.toString());
		}
		
	}
	
	public void displayItemsBasedOnCategory(){
		ItemServiceHandler itemServiceHandler = new ItemServiceHandler();
		List<Item> items = itemServiceHandler.retrieveAllItemsBasedOnCategory("T-Shirts");
		
		for (Item item: items){
			System.out.println(item.toString());
		}
	}
}
