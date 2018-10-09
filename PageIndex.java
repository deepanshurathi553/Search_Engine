import java.util.*;

public class PageIndex{

	MyLinkedList<WordEntry> wordEntry = new MyLinkedList<WordEntry>();
	
	public void addPositionForWord(String str, Position p){
		//System.out.println("addPositionForWord me ghus gya");
		int d=1;
		
		//System.out.println("Yaha tak pahuch gya");
		//System.out.println(wordEntry.list1.size());
		//System.out.println(wordEntry.list1.size());
		for(int k=0;k<wordEntry.getSize();k++){
			if(wordEntry.getElem(k).str == str){
				wordEntry.getElem(k).addPosition(p);
				d = 0;
				break;
			}
		}

		//System.out.println(wordEntry.list1.size());
		if(d != 0){
			WordEntry newWordEntry = new WordEntry(str);
			newWordEntry.addPosition(p);
			wordEntry.addElem(newWordEntry);
		}
	}

	public MyLinkedList<WordEntry> getWordEntries(){
		return wordEntry;
	}
}