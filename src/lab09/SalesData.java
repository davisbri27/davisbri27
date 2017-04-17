package lab09;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

import lab09.CS232LinkedAVLTree.AVLNode;
import lab09.CS232LinkedBinaryTree.BTNode;

public class SalesData  {
	private CS232LinkedAVLTree<Calendar, Double> tree;


	public SalesData(){
		tree= new CS232LinkedAVLTree<Calendar, Double>();

	}


	public void readFile(){
		Scanner scr= new Scanner(System.in);


		while(scr.hasNext()){
			String firstLine= scr.nextLine();
			String[] separateLine= firstLine.split(" ");

			char letter= firstLine.charAt(0);
			//Calendar date= getDate(separateLine[1]);
			//double sales= Double.parseDouble(separateLine[2]);

			if(letter=='A'){
				//add to tree
				Calendar date= getDate(separateLine[1]);
				double sales= Double.parseDouble(separateLine[2]);
				tree.add(date, sales);

			}else if(letter=='D'){
				Calendar date= getDate(separateLine[1]);
				tree.remove(date);

			}else if(letter=='S'){
				//get the amount of the most recent sale
				double most= getMostRecent(tree.root);
				System.out.println("$" + most);

			}else if(letter=='K'){
				//get the total amount of the k most recent sales
				int k= Integer.parseInt(separateLine[1]);
				double total= getTotalMostRecent(tree.root, k); 
				System.out.println("$" + total);

			}else if(letter=='G'){
				Calendar date= getDate(separateLine[1]);
				double k= Integer.parseInt(separateLine[2]);
				//get the total amount of sales in the k days starting on a given date
				
			}


		}



	}
	
	public double getAtStartingDate(Calendar startDate, int k){
		BTNode curNode= tree.root;
		int i=0;
		double val=0;
		
		while(i<k){
		if(((GregorianCalendar) curNode.key).compareTo(startDate) != -1){
			val=+ (double) curNode.value;
	
		
		
		
		}		
		}
		
			
			
			
			return 0;
		
		
	}
	
	

	public double succosor(BTNode<Calendar, Double> node){

		if(node.right==null){
			return node.parent.value;
		}else{
			node=node.right;
			while(!node.isLeaf()){
				node= node.left;
			}

			return node.value;
		}

	}
	
	public double predecessor(BTNode<Calendar, Double> node){
		if(node.left==null){
			return node.parent.value;
			
		}else{
			node=node.left;
			while(!node.isLeaf()){
				node=node.right;
			}
			return node.value;
		}

	}

	private double getTotalMostRecent(BTNode<Calendar, Double> node, int k) {
		int i=0; 
		double total=0;
		while(i<k){
			total= total+ getMostRecent(node);
			i++;
		}

		return total;
	}


	private double getMostRecent(BTNode<Calendar, Double> node) {
		while(!node.isLeaf()){

			if(node.right !=null){
				node=node.right;
			}else if(node.left !=null){
				node=node.left;
			}

		}
		return node.value;
	}


	public GregorianCalendar getDate(String str){
		String[] date= str.split("/");
		int month= Integer.parseInt(date[0]);
		int day= Integer.parseInt(date[1]);
		int year= Integer.parseInt(date[2]);

		GregorianCalendar cal= new GregorianCalendar(year, month, day);

		return cal;

	}







	public static void main(String[] args) {



	}
}
