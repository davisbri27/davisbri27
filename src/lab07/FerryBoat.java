package lab07;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class FerryBoat {
	private Queue<Car> leftQueue;
	private Queue<Car> rightQueue;
	private int ferryLen;
	private int numCars;
	private int numTrips;


	public void readFile(){
		leftQueue= new LinkedList<Car>();
		rightQueue= new LinkedList<Car>();

		Scanner scr= new Scanner(System.in);
		ferryLen= scr.nextInt()*100;
		numCars= scr.nextInt();

		while(scr.hasNext()){
			Car curCar= new Car(scr.nextInt(), scr.next(), scr.next());

			if( curCar.getSide().equals("left")){
				leftQueue.add(curCar);

			}else if(curCar.getSide().equals("right")){
				rightQueue.add(curCar);

			}

		}
		scr.close();

	}

	public void ferryRide(){


		if(numCars==0){
			System.out.println("Day Off!");

		}else{


			int space=0;
			numTrips=0;
			
			while(!leftQueue.isEmpty()&& !rightQueue.isEmpty()){
				space=0;
				numTrips++;
				System.out.println(numTrips+ " : ");

				while(!leftQueue.isEmpty() && leftQueue.peek().getLength()+space <=ferryLen){
					space=space+ leftQueue.peek().getLength();
					System.out.print(leftQueue.remove().getPlate());	
				}
				numTrips++;
				System.out.println(numTrips+ " : ");
				space=0;

				while(!rightQueue.isEmpty() &&rightQueue.peek().getLength()+space <=ferryLen){
					space=space+ rightQueue.peek().getLength();
					System.out.print(rightQueue.remove().getPlate());	
				}
				
			}

			if(numTrips %2 !=0){ //if the ferry trip is on the right side
				numTrips++;
				System.out.println(numTrips+ " : empty");



			}
		}







	}






	public class Car{
		private int length;
		private String plate;
		private String side;

		public Car(int length, String plate, String side){
			this.length=length;
			this.plate=plate;
			this.side=side;
		}

		public int getLength(){
			return length;
		}

		public String getPlate(){
			return plate;
		}

		public String getSide(){
			return side;
		}


	}






	public static void main(String[] args) {

	}
}
