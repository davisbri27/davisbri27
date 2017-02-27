package hw03;

public class Pair<E>{
	private E first;
	private E second;


	public Pair(E initFirst, E initSecond){
		first=initFirst;
		second= initSecond;

	}


	public E getFirst(){
		return first;

	}
	
	public E getSecond(){
		return second;
		
	}
	
	
	public void setFirst(E val){
		first=val;
	}


	public void setSecond(E val){
		second=val;
	}


public static void main(String [] args){
	Integer intOne= 10;
	Integer intTwo= 10;
	Double num= 2.0;
	String word= "hi";
	
	Pair intPair= new Pair(intOne, intTwo);
	Pair mixPair= new Pair(num, word);
	Pair pairPair=new Pair(intPair, mixPair);
}




}
