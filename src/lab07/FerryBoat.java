package lab07;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

import lab06.ParadeShuffle;

/**
 * Using rightSide and leftSide to find how many trips it takes to transport all the cars on each side of the bay. 
 * The ferry must always start from the left side and end up in left side at the end of the day.
 * @author JuHyung Jeong and Briona Davis
 * @version March 23, 2017
 *
 */
public class FerryBoat{

	private int lengthFerry; // length of the ferry
	private int numCars; // number of cars waiting
	private Queue<car> rightSide; // queue for the cars on the right side
	private Queue<car> leftSide; // queue for the cars on the left side
	private int numTrips; // number of trips

	/**
	 *Private class to make car objects to add to the Queues
	 */
	private class car {

		private int length;
		private String plate;
		private String side;
		
		/**
		 * constructor that will create car objects
		 * @param length length of the car
		 * @param plate the plate 
		 * @param side the side where the car is in
		 */
		private car(int length, String plate, String side){
			this.length = length;
			this.plate = plate;
			this.side = side;
		}
		
		/**
		 * gets the length of the car
		 * @return length of the car
		 */
		private int getCarLength(){
			return length;
		}
		
		/**
		 * gets the plate of the car
		 * @return plate of the car
		 */
		private String getCarPlate(){
			return plate;
		}
		
		/**
		 * gets which side the car is on
		 * @return side of the car
		 */
		private String getCarSide(){
			return side;
		}

	}
	
	/**
	 * Constructor for the FerryBoat class and sets up the leftSide queue and rightSide queue to use
	 */
	public FerryBoat() {
		leftSide = new LinkedList<car>();
		rightSide = new LinkedList<car>();
	}

	/**
	 * reads the input and sets up all the variables that will be used later
	 */
	public void init(){
		Scanner in = new Scanner(System.in);
		lengthFerry = in.nextInt() * 100;
		numCars = in.nextInt();
		numTrips = 1;
		while(in.hasNext()){
			car curCar = new car(in.nextInt(), in.next(), in.next());
			if(curCar.getCarSide().equals("left")){
				leftSide.add(curCar);
			} else {
				rightSide.add(curCar);
			}
		}
	}

	/**
	 * Prints out the number of trips and cars that were transported to the other side
	 */
	public void ferryRide(){
		if(numCars == 0){
			// if there are no cars on both sides of the bay, then the captain gets a day off
			System.out.print("Day Off!");
		} else {
			while (!leftSide.isEmpty() || !rightSide.isEmpty()){
				if (numTrips % 2 != 0){
					System.out.print(numTrips + " :");
					leftToRight();
					System.out.println();
					numTrips++;
				} else {
					System.out.print(numTrips + " :");
					rightToLeft();
					System.out.println();
					numTrips++;
				}
			}
		}
		//if the ferry trip ends on the right side and there are no more cars on the both sides
		if(numTrips % 2 == 0){ 
			System.out.print(numTrips + " :"+ " empty");
		}
	}
	
	/**
	 * Helper method to transfer the cars from the left side to the right side
	 */
	private void leftToRight(){
		int space = 0;
		int carNumber = 0; // the number of cars that are getting transported during 1 trip
		while (!leftSide.isEmpty()){
			//checks if the car can fit into the ferry
			if(leftSide.peek().getCarLength() + space <= lengthFerry){
				space += leftSide.peek().getCarLength();
				// prints out the plate number
				System.out.print(" " + leftSide.peek().getCarPlate());
				leftSide.remove();
				carNumber++;
			} else {
				break;
			}
		}
		if(carNumber == 0){
			//if no cars were transported 
			System.out.print(" empty");
		}
	}

	/**
	 * Helper method to transfer the cars from the left side to the right side
	 */
	private void rightToLeft(){
		int space = 0;
		int carNumber = 0; // the number of cars that are getting transported during 1 trip
		while(!rightSide.isEmpty()){
			//checks if the car can fit into the ferry
			if(rightSide.peek().getCarLength() + space <= lengthFerry){
				space += rightSide.peek().getCarLength();
				//prints out the plate number
				System.out.print(" " + rightSide.peek().getCarPlate());
				rightSide.remove();
				carNumber++;
			} else {
				break;
			}
		}
		if(carNumber == 0){
			//if no cars were transported
			System.out.print(" empty");
		}
	}

	public static void main(String[] args) {
		FerryBoat p = new FerryBoat();
		p.init(); // initializes the values to use
		p.ferryRide(); // prints out the results of each ferry rides
	}
}
