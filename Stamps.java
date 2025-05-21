package montrealintercampusShippingService;

public class Stamps {

	// Categories of parcel stamps
	private int nbCategoryA;
	private int nbCategoryB;
	private int nbCategoryC;
	private int nbCategoryD;
	private int nbCategoryE;

	// Static constants of the categories of parcel stamps
	private static final int STAMPCATEGORYA = 2;
	private static final int STAMPCATEGORYB = 5;
	private static final int STAMPCATEGORYC = 10;
	private static final int STAMPCATEGORYD = 15;
	private static final int STAMPCATEGORYE = 20;

	// Default constructor - why not give it the static values instead of 0?
	public Stamps() {
		this.nbCategoryA = 0;
		this.nbCategoryB = 0;
		this.nbCategoryC = 0;
		this.nbCategoryD = 0;
		this.nbCategoryE = 0;
	}

	// Constructor which sets the number of each stamp category
	public Stamps(int nbCategoryA, int nbCategoryB, int nbCategoryC, int nbCategoryD, int nbCategoryE) {
		this.nbCategoryA = nbCategoryA;
		this.nbCategoryB = nbCategoryB;
		this.nbCategoryC = nbCategoryC;
		this.nbCategoryD = nbCategoryD;
		this.nbCategoryE = nbCategoryE;
	}

	// Copy constructor
	public Stamps(Stamps copyStamps) {
		this.nbCategoryA = copyStamps.nbCategoryA;
		this.nbCategoryB = copyStamps.nbCategoryB;
		this.nbCategoryC = copyStamps.nbCategoryC;
		this.nbCategoryD = copyStamps.nbCategoryD;
		this.nbCategoryE = copyStamps.nbCategoryE;
	}

	// Getters
	public int getNbCategoryA() {
		return nbCategoryA;
	}

	public int getNbCategoryB() {
		return nbCategoryB;
	}

	public int getNbCategoryC() {
		return nbCategoryC;
	}

	public int getNbCategoryD() {
		return nbCategoryD;
	}

	public int getNbCategoryE() {
		return nbCategoryE;
	}

	// Setters
	public void setNbCategoryA(int nbCategoryA) {
		this.nbCategoryA = nbCategoryA;
	}

	public void setNbCategoryB(int nbCategoryB) {
		this.nbCategoryB = nbCategoryB;
	}

	public void setNbCategoryC(int nbCategoryC) {
		this.nbCategoryC = nbCategoryC;
	}

	public void setNbCategoryD(int nbCategoryD) {
		this.nbCategoryD = nbCategoryD;
	}

	public void setNbCategoryE(int nbCategoryE) {
		this.nbCategoryE = nbCategoryE;
	}

	// addStamp method allows the user to increase each parcel stamp category by the
	// inputed number
	public void addStamps(int nbCategoryA, int nbCategoryB, int nbCategoryC, int nbCategoryD, int nbCategoryE) {
		this.nbCategoryA += nbCategoryA;
		this.nbCategoryB += nbCategoryB;
		this.nbCategoryC += nbCategoryC;
		this.nbCategoryD += nbCategoryD;
		this.nbCategoryE += nbCategoryE;
	}

	// stampsTotal method returns the total value of all the stamps in the registry
	public int stampsTotal() {
		return ((nbCategoryA * STAMPCATEGORYA) + (nbCategoryB * STAMPCATEGORYB) + (nbCategoryC * STAMPCATEGORYC)
				+ (nbCategoryD * STAMPCATEGORYD) + (nbCategoryE * STAMPCATEGORYE));
	}

	// toString returns a string indicating the count of each stamp category
	public String toString() {
		return " This is the count of each stamp in the registry: \nCategory A: " + this.nbCategoryA + "\nCategory B: "
				+ this.nbCategoryB + "\nCategory C: " + this.nbCategoryC + "\nCategory D: " + this.nbCategoryD
				+ "\nCategory E: " + this.nbCategoryE;
	}

	// equals method returns true if two objects of type Stamps have the same
	// breakdown of stamp type
	public boolean equals(Stamps otherStamps) {
		if (this == otherStamps) {
			return true;
		} else if (otherStamps == null) {
			return false;
		}

		return nbCategoryA == otherStamps.nbCategoryA && nbCategoryB == otherStamps.nbCategoryB
				&& nbCategoryC == otherStamps.nbCategoryC && nbCategoryD == otherStamps.nbCategoryD
				&& nbCategoryE == otherStamps.nbCategoryE;
	}

}
