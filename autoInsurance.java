package autoInsurance;
import java.util.Scanner;
import java.io.*;



public class autoInsurance {

	public static void main(String[] args) throws IOException {
		
		// TODO Auto-generated method stub
		// Creates the scanner class
		Scanner scan = new Scanner(System.in);
		// creates a printwriter and writes to local file.
		PrintWriter outFile = new PrintWriter(new File("E:\\Progra\\AutoInsuranceMonthlyFee.txt"));
		
		// instantiates variables
		int carColor = 0; 
		int colorCost = 0;
		int genderRate = 0;
		int storedAge = 0;
		int insuranceType = 0;
		int vehicleTypeX = 0;
		int carCost = 0;// 2
		int coverageCost = 0;
		// asks for the user to input the driver age
		System.out.println("------------------------------------------------------------------------------------");
		System.out.println("What is the Driver's Age?");
		int driverAge = scan.nextInt();
		// sets boundaries and prices based on the drivers age and stored the value in storedAge
		if(driverAge == 18) {
			storedAge = 4;
		}else if(driverAge <= 25){
			
			storedAge = 2;
		}else {
			storedAge = 1;
		}
		// asks the users to pick between M and F for gender pricing
		System.out.println("------------------------------------------------------------------------------------");
		System.out.println("Please Tell us your gender. M  ||  F");
		String gender = scan.next();  // 2
		// sets gender equal to user input to calc genderRate
		if(gender.equals("M")) {
			genderRate = 2;
		} 
		if(gender.equals("F")){
			genderRate = 1;
		}
		// asks the user to select the vehicle type they wish to insure
		System.out.println("------------------------------------------------------------------------------------");
		System.out.println("Please Select Which Insurance you would like an auto-generated quote for!");
		System.out.println(" 1 FOR CAR \n 2 TRUCK \n 3 FOR VAN \n 4 FOR SPORTS CAR");
		vehicleTypeX = scan.nextInt();
		// the user picks a number corresponding to a vehicle type  && gets a cost 
		switch(vehicleTypeX) {
		
		case 1: 
			System.out.println("You are looking to insure a: CAR");
			carCost = 1;
			break;
		case 2:
			System.out.println("You are looking to insure a: TRUCK");
			carCost = 2;
		case 3:
			System.out.println("You are looking to insure a: VAN");
			carCost = 1;
			break;
		case 4:
			System.out.println("You are looking to insure a: SPORTS CAR");
			carCost = 4;
			break;
		default:
			System.out.println("What kind of vehicle are you looking to insure?");
		
		
		}
		//asks the user what colors their vehicle is && adds a cost accordingly
		System.out.println("------------------------------------------------------------------------------------");
		System.out.println("Please Select Which Insurance you would like an auto-generated quote for!");
		System.out.println(" 1 FOR RED \n 2 FOR BLUE \n 3 FOR GREY \n 4 FOR WHITE");
		carColor = scan.nextInt();
		switch(carColor) {
		
		case 1: 
			System.out.println("Your vehicle is: RED");
			colorCost = 4; 
			break;
		case 2:
			System.out.println("Your vehicle is: BLUE");
			colorCost = 2;
		case 3:
			System.out.println("Your vehicle is: GREY");
			colorCost = 1;
			break;
		case 4:
			System.out.println("Your vehicle is: WHITE");
			colorCost = 1;
			break;
		default:
			System.out.println("What COLOR is your vehicle?");
		}
	// asks the user what level of insurance they would like
	System.out.println("------------------------------------------------------------------------------------");
	System.out.println("Please Select Which Insurance you would like an auto-generated quote for!");
	System.out.println(" 1 FOR Comprehensive INSURANCE \n 2 FOR Driver INSURANCE \n 3 FOR Full Coverage INSURANCE ");
	
	insuranceType = scan.nextInt();
	// case statements have alternate outcomes based on user input
	switch(insuranceType) {
	case 1: 
		System.out.println("You selected Comprehensive Insurance");
		coverageCost = 100;
		break;
	case 2:
		System.out.println("You selected Driver Insurance:");
		coverageCost = 50;
		break;
		
	case 3: 
		System.out.println("You have selected Full: ");
		coverageCost = 200;
		break;
	default:
		// Default report
		System.out.println("Always a Silver Lining");
	}
	// calculates all the values by multiple the rates based on the user inputs and then divided by 12 (#of months in a year
	int monthlyFee = ((coverageCost * colorCost * carCost * genderRate * storedAge) / 12);
	// prints to console their monthlyFee as $ per month.
	// and to the note pad.
	
	outFile.write("Your auto insurance quote estimate is priced at: " + monthlyFee + "$ per month.");
	System.out.println("Your auto insurance quote estimate is priced at: " + monthlyFee + "$ per month.");
	// closes the scanner and print writer.
	scan.close();
	outFile.close();
	
	
	}
	}


