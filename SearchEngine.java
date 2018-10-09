import java.util.*;

public class SearchEngine{
	InvertedPageIndex set = new InvertedPageIndex();
	MySort xnew = new MySort();
	public SearchEngine(){
		
	}
	public PageEntry findPageEntry(String cf){
		//System.out.println("isi me hu");
		for(int s=0;s<set.set.getSizeSet();s++){
		//	System.out.println("for me ghusa");
		//	System.out.println(set.set.getElement(s).fileName);
			if(set.set.getElement(s).fileName.equals(cf)){
		//		System.out.println("if me ghusa");
				return set.set.getElement(s);
			}
		}
		return null;		
	}
	public void performAction(String actionMessage) {
		String[] tmp = actionMessage.split(" ");
		//System.out.println("-----------------" +actionMessage);
		if(tmp[0].equals("addPage")){
			if(tmp.length == 2){
				PageEntry c = new PageEntry(tmp[1]);
				try{set.addPage(c);
					System.out.println("Page " + tmp[1] + " added");
				}
				catch(Exception e){
					System.out.println("Exception - No such File Found");
				}
			}
			else{
				System.out.println("Incorrect Input Format");
			}
		}
		//System.out.println(set.set.getSizeSet());
		if(tmp[0].equals("queryFindPagesWhichContainWord")){
			if(tmp.length ==2){
				//System.out.println("isme pahuch gya");
				Myset<PageEntry> c = set.getPagesWhichContainWord(tmp[1]);
				//System.out.println(c.set1.list1.size());
				String[] rachel = new String[1];
				rachel[0] = tmp[1];
				if(c.set1.list1.size()!=0){
				Myset<SearchResult> bkl = new Myset<SearchResult>();
				for(int hl=0;hl<c.getSizeSet();hl++){
					SearchResult x = new SearchResult(c.getElement(hl), c.getElement(hl).getRelevanceOfPage(rachel, false));
					bkl.addElement(x);
				}
			
				ArrayList<SearchResult> chandler = xnew.sortThisList(bkl);
				for(int i=0;i<chandler.size();i++){
					SearchResult s=chandler.get(i);
        				System.out.print(s.getPageEntry().fileName + ",");
				}
				/*for(int j=0;j<c.getSizeSet();j++){
				 	System.out.print(c.getElement(j).fileName + ",");

				}*/
				System.out.println("");
				}
				else{
					System.out.println("No Webpage Contain this Word");
				}
			}
			else{
				System.out.println("Incorrect Input Format");
			}
		}
		if(tmp[0].equals("queryFindPositionsOfWordInAPage")){
			if(tmp.length == 3){
		//		System.out.println(tmp[2]);
				PageEntry c = findPageEntry(tmp[2]);

				if(c!=null){
				int k = 0;
				for(int z=0;z<c.getPageIndex().getWordEntries().list1.size();z++){
					//System.out.println(c.getPageIndex().getWordEntries().list1.size());
					if(c.getPageIndex().getWordEntries().getElem(z).str.equals(tmp[1])){
						k++;
						MyLinkedList<Position> cd = new MyLinkedList<Position>();
						cd = c.getPageIndex().getWordEntries().getElem(z).getAllPositionsForThisWord();
						
						//System.out.println(cd.list1.size());
						for(int z1=0;z1<cd.list1.size();z1++){
							System.out.print(cd.getElem(z1).getWordIndex() + ",");
							
						}
						
					}
					//System.out.println(k);
				}
				System.out.println("");
				if(k==0)System.out.println("Webpage " + tmp[2] + " does not contain" + tmp[1] + " word");
			}
			else{
				System.out.println("Exception - Webpage " + tmp[2] + " does not exist");
			}
			}
			else{
				System.out.println("Incorrect Input Format");
			}
		}

		if(tmp[0].equals("queryFindPagesWhichContainAllWords")){
			int monica = tmp.length-1;
			String[] rachel = new String[monica];
			for(int i=0;i<monica;i++){
				rachel[i] = tmp[i+1];
			}
			Myset<PageEntry> phoebe = set.getPagesWhichContainAllWords(rachel);
			if(phoebe.getSizeSet()==0)System.out.println("No Such Page Exist");
			else{
				Myset<SearchResult> bkl = new Myset<SearchResult>();
				for(int hl=0;hl<phoebe.getSizeSet();hl++){
					SearchResult x = new SearchResult(phoebe.getElement(hl), phoebe.getElement(hl).getRelevanceOfPage(rachel, false));
					bkl.addElement(x);
				}
			
				ArrayList<SearchResult> chandler = xnew.sortThisList(bkl);
				for(int i=0;i<chandler.size();i++){
					SearchResult s=chandler.get(i);
        				System.out.print(s.getPageEntry().fileName + ",");
				}
			}	
			System.out.println("");	
		}
		if(tmp[0].equals("queryFindPagesWhichContainAnyOfTheseWords")){
			int monica = tmp.length-1;
			String[] rachel = new String[monica];
			for(int i=0;i<monica;i++){
				rachel[i] = tmp[i+1];
			}
			Myset<PageEntry> phoebe = set.getPagesWhichContainAtLeastOneWord(rachel);
			if(phoebe.getSizeSet()==0)System.out.println("No Such Page Exist");
			else{
				Myset<SearchResult> bkl = new Myset<SearchResult>();
				for(int hl=0;hl<phoebe.getSizeSet();hl++){
					SearchResult x = new SearchResult(phoebe.getElement(hl), phoebe.getElement(hl).getRelevanceOfPage(rachel, false));
					bkl.addElement(x);
				}
			
				ArrayList<SearchResult> chandler = xnew.sortThisList(bkl);
				for(int i=0;i<chandler.size();i++){
					SearchResult s=chandler.get(i);
        				System.out.print(s.getPageEntry().fileName + ",");
				}
			}	
			System.out.println("");	
		}

		if(tmp[0].equals("queryFindPagesWhichContainPhrase")){
			int monica = tmp.length-1;
			String[] rachel = new String[monica];
			for(int i=0;i<monica;i++){
				rachel[i] = tmp[i+1];
			}
			Myset<PageEntry> rathi = set.getPagesWhichContainPhrase(rachel);
			Myset<PageEntry> phoebe = new Myset<PageEntry>();
			for(int gh=0;gh<rathi.getSizeSet();gh++){
				if(phoebe.isMember(rathi.getElement(gh))==false){
					phoebe.addElement(rathi.getElement(gh));
				}
			}
			if(phoebe.getSizeSet()==0)System.out.println("No Such Page Exist");
			else{
				Myset<SearchResult> bkl = new Myset<SearchResult>();
				for(int hl=0;hl<phoebe.getSizeSet();hl++){
					SearchResult x = new SearchResult(phoebe.getElement(hl), phoebe.getElement(hl).getRelevanceOfPage(rachel, true));
					bkl.addElement(x);
				}
			
				ArrayList<SearchResult> chandler = xnew.sortThisList(bkl);
				for(int i=0;i<chandler.size();i++){
					SearchResult s=chandler.get(i);
        				System.out.print(s.getPageEntry().fileName + ",");
				}
			}	
			System.out.println("");
			}
	}
}
