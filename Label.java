package montrealintercampusShippingService;

public class Label {

	// Attributes
	private String parcelType;
	private int unitID;
	private int expiryDay;
	private int expiryMonth;

	// Default constructor
	public Label() {
		this.parcelType = "Standard";
		this.unitID = 98000000;
		this.expiryDay = 0;
		this.expiryMonth = 0;
	}

	// Constructor which sets the initial value of each attribute
	public Label(String parcelType, int unitID, int expiryDay, int expiryMonth) {
		this.parcelType = parcelType;

		// Shouldn't it be less than 98999999 because we want them to always have 98 at
		// beginning?
		if (unitID >= 98000000 && unitID <= 98999999) {
			this.unitID = unitID;
		} else {
			this.unitID = 98000000;
		}

		setExpiryDay(expiryDay);

		setExpiryMonth(expiryMonth);
	}

	// Copy constructor
	public Label(Label copyLabel) {
		this.parcelType = copyLabel.parcelType;
		this.unitID = copyLabel.unitID;
		this.expiryDay = copyLabel.expiryDay;
		this.expiryMonth = copyLabel.expiryMonth;
	}

	// Getters
	public String getParcelType() {
		return parcelType;
	}

	public int getUnitID() {
		return unitID;
	}

	public int getExpiryDay() {
		return expiryDay;
	}

	public int getExpiryMonth() {
		return expiryMonth;
	}

	// Setters for the due day and month
	public void setExpiryDay(int expiryDay) {
		if (expiryDay >= 1 && expiryDay <= 31) {
			this.expiryDay = expiryDay;
		} else {
			this.expiryDay = 0;
		}
	}

	public void setExpiryMonth(int expiryMonth) {
		if (expiryMonth >= 1 && expiryMonth <= 12) {
			this.expiryMonth = expiryMonth;
		} else {
			this.expiryMonth = 0;
		}
	}

	// toString method
	public String toString() {

		String proposedDay = "";
		if (expiryDay < 10) {
			proposedDay = "0" + expiryDay;
		} else {
			proposedDay = "" + expiryDay;
		}

		String proposedMonth = "";
		if (expiryMonth < 10) {
			proposedMonth = "0" + expiryMonth;
		} else {
			proposedMonth = "" + expiryMonth;
		}

		return this.parcelType + " - " + this.unitID + " - " + proposedDay + "/" + proposedMonth;
	}

	// equals method
	public boolean equals(Label otherLabel) {

		if (this == otherLabel) {
			return true;
		} else if (otherLabel == null) {
			return false;
		}

		return parcelType.equals(otherLabel.parcelType) && unitID == otherLabel.unitID
				&& expiryDay == otherLabel.expiryDay && expiryMonth == otherLabel.expiryMonth;
	}

}
