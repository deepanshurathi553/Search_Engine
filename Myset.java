import java.util.*;

public class Myset<X>{
	
	MyLinkedList<X> set1 = new MyLinkedList<X>();

	public void addElement(X element){
		set1.addElem(element);
	}

	public boolean isMember(X element){
		return set1.isMember(element);
	}
	public X getElement(int i){
		return set1.getElem(i);
	}
	public int getSizeSet(){
		return set1.getSize();
	}

	public Myset<X> union(Myset<X> otherSet, Myset<X> thisSet){
		Myset<X> UnionSet = new Myset<X>();
		for(int i=0; i<thisSet.set1.getSize(); i++){
			//	System.out.println("for me aaya");
				UnionSet.set1.addElem(thisSet.set1.getElem(i));
			//	System.out.println(UnionSet.getSizeSet());
			}
		//System.out.println(UnionSet.getSizeSet());
			
		for(int i=0; i<otherSet.set1.getSize(); i++){
				UnionSet.set1.addElem(otherSet.set1.getElem(i));
			}
		//System.out.println(UnionSet.getSizeSet());
		
		Myset<X> xset = new Myset<X>();
		xset = intersection(otherSet, thisSet);
		//System.out.println(xset.getSizeSet());
		for(int i=0; i<xset.set1.getSize(); i++){
				UnionSet.set1.delElem(xset.set1.getElem(i));
			}		
		//System.out.println(UnionSet.getSizeSet()); 	
		/*if(thisSet.set1.getSize()>otherSet.set1.getSize()){
			System.out.println("If me aa gya"); 
			for(int i=0; i<thisSet.set1.getSize(); i++){
				System.out.println("for me aaya");
				UnionSet.set1.addElem(thisSet.set1.getElem(i));
				System.out.println(UnionSet.getSizeSet());
			}
			for(int i=0; i<otherSet.set1.getSize(); i++){
				System.out.println("for dusra");
				System.out.println(otherSet.set1.list1.get(i));
				System.out.println(thisSet.set1.list1.get(i));
				boolean bb = thisSet.set1.list1.contains(otherSet.set1.list1.get(i));
				System.out.println(bb);
				if(thisSet.set1.list1.contains(otherSet.set1.list1.get(i)) == false){
					System.out.println("if m aaya");
					UnionSet.set1.addElem(otherSet.set1.getElem(i));
				}
			}
		}
		if(thisSet.set1.getSize()<otherSet.set1.getSize()){
			for(int i=0; i<otherSet.set1.getSize(); i++){
				UnionSet.set1.addElem(otherSet.set1.getElem(i));
			}
			for(int i=0; i<thisSet.set1.getSize(); i++){
				if(otherSet.set1.isMember(thisSet.set1.getElem(i)) != true){
					UnionSet.set1.addElem(thisSet.set1.getElem(i));
				}
			}
		}*/
		return UnionSet;
	}

	public Myset<X> intersection(Myset<X> otherSet, Myset<X> thisSet){
		Myset<X> IntersectionSet = new Myset<X>();
		for(int i=0; i<thisSet.set1.getSize(); i++){
			if(otherSet.set1.isMember(thisSet.set1.getElem(i)) == true){
				IntersectionSet.set1.addElem(thisSet.set1.getElem(i));
			}
		}
		return IntersectionSet;
	}
}