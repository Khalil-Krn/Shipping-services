package montrealintercampusShippingService;

import java.util.Scanner;

public class MissDemo {
	
	//------------------------------------
		//Assignment 4
		//Written by Abderraouf El Khalil Karoun, student ID: 40315753
		//For COMP 248 section P - Fall 2024
		//------------------------------------
		
		/* This algorithm stimulates a shipping system for all of Montreal
		 * universities. It tracks and manages parcel stamps and prepaid label.
		 * The stamps class manages stamps counts and their total value for a registry.
		 * It keeps tracks of five stamps categories and have method to add stamps and
		 * calculate total. It has a toString method returning the stamps counts and an equal
		 * method comparing two stamps. The label class manages label with their type, id unit 
		 * and expiry date. The toString ensure good formating of the expiry dates and the equals
		 * method verify if two labels are the same. The registry class manages shipment label.
		 * It used the two previous classes to ensure great functioning. It provides method to 
		 * compare registries based on the total stamps value, the number of stamps in each category,
		 * adding stamps, adding labels and removing labels. It also return the number of labels and 
		 * update the expiry date. The method toString and breakdown helps give a summarize of the inventory.
		 * Then the missDemo driver class welcomes the user into the program.
		 * It starts by asking him what he would like to do between 10 options: 1. See the content of all Registries.
		 * 2. See the content of one Registry. 3. List Registries with the same $ amount of shipment Stamps.
		 * 4. List Registries with same number of shipment Stamp types. 5.List Registries with same $ amount
		 * of Stamps and same number of prepaid Labels. 6. Add a prepaid label to an existing Registry.
		 * 7. Remove an existing prepaid label from a Registry. 8. Update the expiry date of an existing prepaid label.
		 * 9. Add Stamps to a Registry. 0. To quit the program. Each option perform exactly what it is ask to do.
		 * When the user input 0. The program says goodbye to the user and end the program.
		 */

	// Creating a scanner object for user's input across all methods
	private static final Scanner ww = new Scanner(System.in);

	public static void main(String[] args) {
		// Welcoming the user
		System.out
				.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out
				.println("|  Welcome to Montreal Intercampuses Shipping Service(MISS) Application                  |");
		System.out
				.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

		// Creating at least 5 Registries
		Stamps stamps1 = new Stamps(5, 2, 1, 3, 4);
		Stamps stamps2 = new Stamps(5, 2, 1, 3, 4);
		Stamps stamps3 = new Stamps(3, 1, 4, 2, 6);
		Stamps stamps4 = new Stamps(6, 2, 1, 2, 3);
		Stamps stamps5 = new Stamps(6, 2, 1, 2, 3);

		Label[] labels1 = { new Label("Standard", 98000001, 15, 12), new Label("Express", 98000002, 20, 12) };
		Label[] labels2 = { new Label("Standard", 98000001, 15, 12) };
		Label[] labels3 = { new Label("Express", 98000002, 20, 12), new Label("Standard", 98000003, 25, 12), new Label("Standard", 98000004, 31, 12) };

		Registry registry1 = new Registry(stamps1, labels3);
		Registry registry2 = new Registry(stamps2, labels1);
		Registry registry3 = new Registry(stamps3, labels2);
		Registry registry4 = new Registry(stamps4, null);
		Registry registry5 = new Registry(stamps5, null);

		Registry[] allRegistries = { registry1, registry2, registry3, registry4, registry5 };

		boolean works = true;

		while (works) {

			// Displaying the menu
			displayMenu();

			// Receiving the user's input using scanner
			int userInput = ww.nextInt();

			// Executing the user's choice
			switch (userInput) {
			case 1:
				displayAllRegistries(allRegistries);
				break;
			case 2:
				displayRegistry(allRegistries);
				break;
			case 3:
				listRegistriesWithSameAmount(allRegistries);
				break;
			case 4:
				listRegistriesWithSameStampTypes(allRegistries);
				break;
			case 5:
				listRegistriesWithSameAmountAndLabels(allRegistries);
				break;
			case 6:
				addLabelToRegistry(allRegistries);
				break;
			case 7:
				removeLabelFromRegistry(allRegistries);
				break;
			case 8:
				updateLabelExpiryDate(allRegistries);
				break;
			case 9:
				addStampsToRegistry(allRegistries);
				break;
			case 0:
				System.out.println("Goodbye and thank you for using Montreal Intercampuses Shipping Service!");
				works = false;
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
			}

		}

		// Closing the scanner
		ww.close();

	}

	// displayMenu method displays the menu
	private static void displayMenu() {
		System.out.println("|  What would you like to do?                                                            |");
		System.out.println("|  1 >> See the content of all Registries                                                |");
		System.out.println("|  2 >> See the content of one Registry                                                  |");
		System.out.println("|  3 >> List Registries with same $ amount of shipment Stamps                            |");
		System.out.println("|  4 >> List Registries with same number of shipment Stamp types                         |");
		System.out.println("|  5 >> List Registries with same $ amount of Stamps and same number of prepaid Labels   |");
		System.out.println("|  6 >> Add a prepaid label to an existing Registry                                      |");
		System.out.println("|  7 >> Remove an existing prepaid label from a Registry                                 |");
		System.out.println("|  8 >> Update the expiry date of an existing prepaid label                              |");
		System.out.println("|  9 >> Add Stamps to a Registry                                                         |");
		System.out.println("|  0 >> To quit                                                                          |");
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.print("Please enter your choice and press <Enter> : ");

	}

	// User's 1st choice
	private static void displayAllRegistries(Registry[] allRegistries) {
		System.out.println("Content of each Registry:");
		System.out.println("-------------------------");

		for (int i = 0; i < allRegistries.length; i++) {
			System.out.println("\nRegistry " + "#" + (i) + ":\n" + allRegistries[i]);
		}
		System.out.println("\n");
	}

	// User's 2nd choice
	private static void displayRegistry(Registry[] allRegistries) {

		boolean work = true;
		System.out.print("Which Registry you want to see the content of? (Enter number 0 to "
				+ (allRegistries.length - 1) + "): ");

		while (work) {
			int index = ww.nextInt();
			if (index >= 0 && index < allRegistries.length) {
				System.out.println("\nRegistry " + "#" + (index) + ":\n" + allRegistries[index]);
				work = false;
			} else {
				System.out.println("Sorry but there is no Registry number " + index);
				System.out.print("--> Try again: (Enter number (0 to " + (allRegistries.length - 1) + "): ");
			}

		}

		System.out.println("\n");
	}

	// User's 3rd choice
	private static void listRegistriesWithSameAmount(Registry[] allRegistries) {
		System.out.println("List of Registries with same total $ Stamps:\n");
		for (int i = 0; i < allRegistries.length; i++) {
			for (int j = i + 1; j < allRegistries.length; j++) {
				if (allRegistries[i].totalShipmentStampsValue() == allRegistries[j].totalShipmentStampsValue()) {
					System.out.println(" \tRegistries " + (i) + " and " + (j) + " both have $"
							+ allRegistries[i].totalShipmentStampsValue());
				}
			}
		}
		System.out.println("\n");
	}

	// User's 4th choice
	private static void listRegistriesWithSameStampTypes(Registry[] allRegistries) {
		System.out.println("List of Registries with same Stamps categories:\n");
		for (int i = 0; i < allRegistries.length; i++) {
			for (int j = i + 1; j < allRegistries.length; j++) {
				if (allRegistries[i].areStampsEqualCategory(allRegistries[j])) {
					System.out.println(
							" \tRegistries " + (i) + " and " + (j) + " both have " + allRegistries[i].stampBreakdown());
				}
			}
		}
		System.out.println("\n");
	}

	// User's 5th choice
	private static void listRegistriesWithSameAmountAndLabels(Registry[] allRegistries) {
		System.out.println("List of Registries with same $ amount of Stamps and same number of Labels :\n");
		for (int i = 0; i < allRegistries.length; i++) {
			for (int j = i + 1; j < allRegistries.length; j++) {
				if (allRegistries[i].equals(allRegistries[j])) {
					System.out.println("\tRegistries " + (i) + " and " + (j));
				}
			}
		}
		System.out.println("\n");
	}

	// User's 6th choice
	private static void addLabelToRegistry(Registry[] allRegistries) {

		System.out.print("Which Registry do you want to add a Label to? (Enter number 0 to "
				+ (allRegistries.length - 1) + "): ");
		int index = ww.nextInt();
		if (index >= 0 && index < allRegistries.length) {
			System.out.print("Please enter the following information so that we may complete the Label-\n");
			System.out.print("--> Type of Label (Confidential, Small, Oversize, Express, Standard, Fragile): ");
			String type = ww.next();
			System.out.print("--> Id of the prepaid label processor: ");
			int unitID = ww.nextInt();
			ww.nextLine();
			System.out.print("--> Expiry day number and month (seperate by a space): ");
			String expiry = ww.nextLine();
			int day = Integer.parseInt(expiry.substring(0, 2)); // First 2 characters are the day
			int month = Integer.parseInt(expiry.substring(3, 5)); // Characters 3 and 4 are the month

			Label newLabel = new Label(type, unitID, day, month);
			allRegistries[index].addLabel(newLabel);
			System.out.println("Label added. You now have " + allRegistries[index].nbOfLabels() + " Label(s)");
		} else {
			System.out.println("Invalid registry number.");
			System.out.println("\n");
		}
	}

	// User's 7th choice
	private static void removeLabelFromRegistry(Registry[] allRegistries) {
		System.out.print("Which Registry do you want to remove a Label from? (Enter number 0 to "
				+ (allRegistries.length - 1) + "): ");
		int index = ww.nextInt();
		if (index > 0 && index < allRegistries.length) {
		if (allRegistries[index].nbOfLabels() == 0) {
			System.out.println("Sorry that Registry has no Labels");

		} else {
			System.out.println("(Enter number 0 to " + (allRegistries[index].nbOfLabels() - 1) + "):\n");
			int input = ww.nextInt();

			// getting the label that is set to be removed
			Label labelToRemove = allRegistries[index].getLabel(input);

			boolean status = allRegistries[index].removeLabel(labelToRemove);

			if (status == true) {
				System.out.println("Label was removed successfully");
			} else {
				System.out.println("Label was not removed successfully");
			}
		}
		System.out.println("\n");
	}else {
		System.out.println("Invalid choice please try again.");
	}
	} 

	// User's 8th choice
	private static void updateLabelExpiryDate(Registry[] allRegistries) {
		System.out.print("Which Registry do you want to update a Label from? (Enter number 0 to "
				+ (allRegistries.length - 1) + "): ");
		int index = ww.nextInt();
		if ( index > 0 && index < allRegistries.length) {
		if (allRegistries[index].nbOfLabels() == 0) {
			System.out.println("There are no labels to be updated in this Registry");

		} else {

			System.out.println("Which Label do you want to update? (Enter number 0 to "
					+ (allRegistries[index].nbOfLabels() - 1) + "):\n");
			int label = ww.nextInt();
			ww.nextLine();
			System.out.print("--> Enter new expiry date day number and month (seperated by a space): ");
			String expiry = ww.nextLine();
			int day = Integer.parseInt(expiry.substring(0, 2)); // First 2 characters are the day
			int month = Integer.parseInt(expiry.substring(3, 5)); // Characters 3 and 4 are the month

			// getting the label that is set to be updated
			Label labelToUpdate = allRegistries[index].getLabel(label);

			allRegistries[index].updateExpiryDate(labelToUpdate, day, month);

			System.out.println("Expiry date updated");

		}
		System.out.println("\n");
		}else {
			System.out.println("Invalid choice please try again.");
		}
	}

	// User's 9th choice
	private static void addStampsToRegistry(Registry[] allRegistries) {
		System.out.print("Which Registry do you want to update a Label from? (Enter number 0 to "
				+ (allRegistries.length - 1) + "): ");
		int index = ww.nextInt();
		ww.nextLine();
		if (index > 0 && index < allRegistries.length) {
		System.out.println(
				"How many category_A($2), category_A($5), category_C($10), category_D($15), and category_E($20) parcel stamps do you want to add?");
		System.out.print("Enter 5 numbers seperated by a space: ");
		String numbers = ww.nextLine();

		String[] parts = numbers.split(" ");

		if (parts.length == 5) { // Ensure exactly 5 numbers are entered
			int nbCategoryA = Integer.parseInt(parts[0].trim());
			int nbCategoryB = Integer.parseInt(parts[1].trim());
			int nbCategoryC = Integer.parseInt(parts[2].trim());
			int nbCategoryD = Integer.parseInt(parts[3].trim());
			int nbCategoryE = Integer.parseInt(parts[4].trim());

			int total = allRegistries[index].addShipmentStamps(nbCategoryA, nbCategoryB, nbCategoryC, nbCategoryD,
					nbCategoryE);
			System.out.println("You now have $" + total);

		} else {
			System.out.println("Invalid input. Please enter exactly 5 numbers separated by spaces.");
		}
		System.out.println("\n");

	}else {
		System.out.println("Invalid choice please try again.");
	}
	}

}
