package hw03;

public class CS232ArrayStack<E> implements CS232Stack<E> {

	private CS232ArrayList<E> stack;


	public CS232ArrayStack(){
		stack= new CS232ArrayList<E>();

	}
	public void push(E obj) {
		// TODO Auto-generated method stub
		stack.add(obj);
	}

	@Override
	public E pop() {
		// TODO Auto-generated method stub
		return stack.remove(size()-1);

	}

	@Override
	public E peek() {
		// TODO Auto-generated method stub
		return stack.get(size()-1);
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return stack.size();
	}

		



}
