import java.util.*;

public class WordEntry{
	
	String str;
	MyLinkedList<Position> wordPosition = new MyLinkedList<Position>();
	AVLTree tree = new AVLTree();
	public WordEntry(String word){
		str = word;
	}

	public void addPosition(Position position){
		//System.out.println(wordPosition.list1.size());
		wordPosition.addElem(position);
		tree.insert(position);
	}

	public void addPositions(MyLinkedList <Position> positions){
		for(int i=0;i<positions.getSize();i++){
			wordPosition.addElem(positions.list1.get(i));
			tree.insert(positions.list1.get(i));
		}

	}
	public MyLinkedList <Position> getAllPositionsForThisWord(){
		return wordPosition;
	}

	public AVLTree getPositionsAsAVLTree(){
		return tree;
	}
}