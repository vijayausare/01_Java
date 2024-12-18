package interfaces_and_inheritance.inheritance;

public class Polymorphism {
	public static void main(String[] args) {
		Bicycle bike01, bike02, bike03;

		bike01 = new Bicycle(20, 10, 1);
		bike02 = new MountainBike(20, 10, 5, "Dual");
		bike03 = new RoadBike(40, 20, 8, 23);

		bike01.printDescription();
		bike02.printDescription();
		bike03.printDescription();
	}
}

class Bicycle {
	int startCadence, startSpeed, startGear;

	public Bicycle(int startCadence, int startSpeed, int startGear) {
		this.startCadence = startCadence;
		this.startSpeed = startSpeed;
		this.startGear = startGear;
	}

	public void printDescription() {
		System.out.println("\nBike is " + "in gear " + this.startGear + " with a cadence of " + this.startCadence
				+ " and travelling at a speed of " + this.startSpeed + ". ");
	}

}

class MountainBike extends Bicycle {
	private String suspension;

	public MountainBike(int startCadence, int startSpeed, int startGear, String suspensionType) {
		super(startCadence, startSpeed, startGear);
		this.setSuspension(suspensionType);
	}

	public String getSuspension() {
		return this.suspension;
	}

	public void setSuspension(String suspensionType) {
		this.suspension = suspensionType;
	}

	public void printDescription() {
		super.printDescription();
		System.out.println("The " + "MountainBike has a " + getSuspension() + " suspension.");
	}
}

class RoadBike extends Bicycle {
	private int tireWidth;

	public RoadBike(int startCadence, int startSpeed, int startGear, int newTireWidth) {
		super(startCadence, startSpeed, startGear);
		this.setTireWidth(newTireWidth);
	}

	public int getTireWidth() {
		return this.tireWidth;
	}

	public void setTireWidth(int newTireWidth) {
		this.tireWidth = newTireWidth;
	}

	public void printDescription() {
		super.printDescription();
		System.out.println("The RoadBike" + " has " + getTireWidth() + " MM tires.");
	}

}
