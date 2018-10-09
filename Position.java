import java.util.*;

public class Position{
	
	PageEntry pageEntry;
	int wordIndex;
	public Position(PageEntry p,int wordindex){
		pageEntry = p;
		wordIndex = wordindex; 
	}
	public PageEntry getPageEntry(){
		return pageEntry;
	}

	public int getWordIndex(){
		return wordIndex;
	}
}