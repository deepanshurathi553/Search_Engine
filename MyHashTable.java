import java.util.*;
import java.io.*;

public class MyHashTable{
	
	// My hashtable is an array of linked lists of word entries
	MyLinkedList<WordEntry>[] hashtable = new MyLinkedList[26];

	public MyHashTable(){
		for(int j=0;j<26;j++){
			hashtable[j] = new MyLinkedList<WordEntry>();
		}
	}
	public int getHashIndex(String str){
		int fuckthisshit =0;
		for(int f =0;f<str.length();f++){
			fuckthisshit = fuckthisshit + str.charAt(f);
		}
		fuckthisshit = fuckthisshit%26;
		return fuckthisshit;
	}

	public void addPositionsForWord(WordEntry w){
		try{
		int hash = getHashIndex(w.str);
		//System.out.println(hash);
		
		//System.out.println(hashtable[hash].list1.size());
		for(int i=0;i<hashtable[hash].list1.size();i++){
		//	System.out.println("ek or for loop");
			WordEntry w1=hashtable[hash].list1.get(i);
			if(w1.str.equals(w.str)){
				hashtable[hash].list1.get(i).addPositions(w.wordPosition);
				return;
			}
		}
		WordEntry pe = new WordEntry(w.str);
		pe.addPositions(w.wordPosition);
		hashtable[hash].list1.add(pe);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
