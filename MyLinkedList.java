import java.util.*;
import java.util.LinkedList;

public class MyLinkedList<X>{
	LinkedList<X> list1 = new LinkedList<X>();

	public void addElem(X o){
		list1.add(o);
	}
	public void delElem(X o){
		list1.remove(o);
	}
	public X getElem(int i){
		return list1.get(i);
	}
	public int getSize(){
		//System.out.println("getSize tak pahuch gya");
				
		if(this == null)return 0;
		return list1.size();
	}
	public boolean isMember(X o){
		return list1.contains(o);
	}
}