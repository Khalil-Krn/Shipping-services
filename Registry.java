package montrealintercampusShippingService;

public class Registry {
	// Attributes
	private Stamps stamps;
	private Label[] labels;

	// Default constructor
	public Registry() {
		this.stamps = new Stamps();
		this.labels = null;
	}

	// Constructor which sets the initial value of each attribute
	public Registry(Stamps stamps, Label[] labels) {
		this.stamps = new Stamps(stamps);
		// Creating a copy of the array to avoid privacy leak
		if (labels != null) {
			this.labels = new Label[labels.length];
			for (int i = 0; i < labels.length; i++) {
				this.labels[i] = new Label(labels[i]);
			}
		} else {
			this.labels = null;
		}
	}

	// Getter of a label in the array labels using an index
	public Label getLabel(int index) {
		return labels[index];
	}

	// areStampsEqualValue method returns true if the total value of stamps of two
	// registry objects is equal
	public boolean areStampsEqualValue(Registry otherRegistry) {
		if (otherRegistry == null) {
			return false;
		}

		return this.stamps.stampsTotal() == otherRegistry.stamps.stampsTotal();
	}

	// areStampsEqualCategory method returns true if the number of each stamps
	// category is equal for two registries
	public boolean areStampsEqualCategory(Registry otherRegistry) {
		if (otherRegistry == null) {
			return false;
		}
		return this.stamps.getNbCategoryA() == otherRegistry.stamps.getNbCategoryA()
				&& this.stamps.getNbCategoryB() == otherRegistry.stamps.getNbCategoryB()
				&& this.stamps.getNbCategoryC() == otherRegistry.stamps.getNbCategoryC()
				&& this.stamps.getNbCategoryD() == otherRegistry.stamps.getNbCategoryD()
				&& this.stamps.getNbCategoryE() == otherRegistry.stamps.getNbCategoryE();
	}

	// totalShipmentStampsValue method returns the total amount of shipment stamps
	// of registry
	public int totalShipmentStampsValue() {
		return stamps.stampsTotal();
	}

	// nbOfLabels method returns the number of labels in a registry
	public int nbOfLabels() {
		if (labels == null) {
			return 0;
		} else {
			return labels.length;
		}
	}

	// addLabel method adds a new label to the registry and returns the number of
	// labels of the registry after addition
	public int addLabel(Label newLabel) {

		if (labels == null) {
			labels = new Label[1];
			labels[0] = new Label(newLabel);
		} else {
			Label[] newLabels = new Label[labels.length + 1];
			// iterating through all existing labels and adding them to the new array
			for (int i = 0; i < (labels.length); i++) {
				newLabels[i] = labels[i];
			}
			// adding the new label to the last index of the array
			newLabels[labels.length] = newLabel;

			// replacing the old array with the new one
			labels = newLabels;

		}

		return labels.length;
	}

	// removeLabel is a method with removes a label from a registry and returns true
	// if the removal was successful and false otherwise
	public boolean removeLabel(Label removedLabel) {
		// accounting for an empty registry
		if (labels == null || labels.length == 0) {
			return false;
		}

		// searching for the label to delete
		int indexToRemove = -1;
		for (int i = 0; i < labels.length; i++) {
			if (labels[i].equals(removedLabel)) {
				indexToRemove = i;
				break;
			}
		}

		// if the indexToRemove variable is equal to -1, it means that the label does
		// not exist in the registry - returns false
		if (indexToRemove == -1) {
			return false;
		}

		// if it exists, a new array with length-1 is created
		Label[] updatedLabels = new Label[labels.length - 1];

		// then, a for loop iterates through all elements in existing array to move them
		// to the new array.
		// When it finds the label to be removed, the new array's index is not
		// increased.
		for (int i = 0, j = 0; i < labels.length; i++) {
			if (i != indexToRemove) {
				updatedLabels[j++] = labels[i];
			}
		}

		labels = updatedLabels;

		return true;
	}

	// updateExpiryDate method updates the due day and month of a label
	public void updateExpiryDate(Label updateLabel, int updateDay, int updateMonth) {
		for (Label label : labels) {
			if (label.equals(updateLabel)) {
				label.setExpiryDay(updateDay);
				label.setExpiryMonth(updateMonth);

			}
		}
	}

	// addShipmentStamps method adds shipment stamps to the registry for each stamp
	// category and returns the new total shipment
	public int addShipmentStamps(int nbCategoryA, int nbCategoryB, int nbCategoryC, int nbCategoryD, int nbCategoryE) {
		stamps.addStamps(nbCategoryA, nbCategoryB, nbCategoryC, nbCategoryD, nbCategoryE);
		return stamps.stampsTotal();
	}

	// equals method
	public boolean equals(Registry otherRegistry) {
		if (otherRegistry == null) {
			return false;
		}
		return this.totalShipmentStampsValue() == otherRegistry.totalShipmentStampsValue()
				&& this.nbOfLabels() == otherRegistry.nbOfLabels();
	}

	// toString method
	public String toString() {
		String labelsDetail;

		if (labels == null || labels.length == 0) {
			labelsDetail = "No prepaid labels";
		} else {
			labelsDetail = "";
			for (int i = 0; i < labels.length; i++) {
				labelsDetail += labels[i].toString();
				if (i < labels.length - 1) {
					labelsDetail += ", \n";
				}
			}
		}
		return stampBreakdown() + "\n" + labelsDetail;
	}

	// stampBreakdown method returns a string which details the breakdown of the
	// stamps
	public String stampBreakdown() {
		return stamps.getNbCategoryA() + " x $2 + " + stamps.getNbCategoryB() + " x $5 + " + stamps.getNbCategoryC()
				+ " x $10 + " + stamps.getNbCategoryD() + " x $15 + " + stamps.getNbCategoryE() + " x $20 ";
	}

}
