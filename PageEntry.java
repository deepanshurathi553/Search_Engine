import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PageEntry{
	String sCurrLine;
	String fileName;
	PageIndex fileIndex = new PageIndex();
	String[] commWords = {"a","an","the","they","these","for","is","are","of","or","and","does","will","whose"};
	
	public boolean isCommWord(String s){
		boolean d =false;
		for(int k=0;(k<commWords.length); k++){
			if(s.equals(commWords[k])){
				d= true;
			}
		}
		return d;
	}


	PageEntry(String pageName){
		fileName = pageName;
		//String text = "";
		String sCurrLine;
		//String text = new String(Files.readAllBytes(Paths.get(fileName)), StandardCharsets.UTF_8);
		try{
		String text = new String(Files.readAllBytes(Paths.get("webpages/"+fileName)), StandardCharsets.UTF_8);
		
		/*BufferedReader br = new BufferedReader(new FileReader("webpages/"+pageName));
		while ((sCurrLine = br.readLine()) != null) {
			text += sCurrLine;		
		}*/
		/*InputStream fish = new FileInputStream("webpages/"+pageName);
		InputStreamReader isr = new InputStreamReader(fish);
		BufferedReader brr = new BufferedReader(isr);
		//FileOutputStream fos = new FileOutputStream("new"+pageName+".txt",true);
		//PrintStream p = new PrintStream(fos);
		while ((sCurrLine = brr.readLine()) != null) {
			text += sCurrLine;		
		}*/
		text = text.replaceAll("[-{}\\[\\]<>=().,_;'\"?#!@:]"," ").replaceAll("\\s+"," ");
		text = text.toLowerCase();
		String[] words = text.split(" ");
		for(int y=0; y<words.length;y++){
			String dr = words[y];
			if(isCommWord(dr) == false){
				if(dr.equals("stacks")){
					words[y] = "stack";
				}
				if(dr.equals("functions")){
					words[y] = "function";
				}
				if(dr.equals("applications")){
					words[y] = "application";
				}
				if(dr.equals("structures")){
					words[y] = "structure";
				}
				Position drpos = new Position(this, y+1);
				//System.out.println("Yaha tak pahuch gya");
				//System.out.println(dr);
				//System.out.println(drpos.pageEntry.fileName);
				
				fileIndex.addPositionForWord(dr, drpos);
			}
		}
	}
	catch(Exception e){
		e.printStackTrace();
	}
	}

	public PageIndex getPageIndex(){
		return fileIndex;
	}

	/*public boolean isTheGivenWordsAreAPhrase(String jhg[]){
		MyLinkedList<Position> gunther = new MyLinkedList<Position>();
		for(int i=0;i<this.getPageIndex().getWordEntries().list1.size();i++){
			if(this.getPageIndex().getWordEntries().getElem(i).str.equals(jhg[0])){
				for(int l=0;l<this.getPageIndex().getWordEntries().getElem(i).getAllPositionsForThisWord().list1.size();l++){
					gunther.addElem(this.getPageIndex().getWordEntries().getElem(i).getAllPositionsForThisWord().getElem(l));
				}
			}
		}

	}*/	

	public float getRelevanceOfPage(String str[], boolean doTheseWordsRepresentAPhrase){
		float ross = 0;
		if(this!=null){
		if(doTheseWordsRepresentAPhrase == true){
		//int k = 0;
		/*MyLinkedList<Position> gunther = new MyLinkedList<Position>();
		for(int z=0;z<this.getPageIndex().getWordEntries().list1.size();z++){
			for(int bg=0;bg<str.length;bg++){
				if(this.getPageIndex().getWordEntries().getElem(z).str.equals(str[bg])){
					for(int l=0;l<this.getPageIndex().getWordEntries().getElem(z).getAllPositionsForThisWord().list1.size();l++){
						gunther.addElem(this.getPageIndex().getWordEntries().getElem(z).getAllPositionsForThisWord().getElem(l));
					}					
				}
			}		
		}
		for(int h=0;h<gunther.list1.size();h++){
			ross = ross + ((1/gunther.list1.get(h).wordIndex)*(1/gunther.list1.get(h).wordIndex));			
		}*/
		for(int z=0;z<this.getPageIndex().getWordEntries().list1.size();z++){
				//System.out.println("second for");
				if(this.getPageIndex().getWordEntries().getElem(z).str.equals(str[0])){		
			//		System.out.println("first if");
					MyLinkedList<WordEntry> kl = new MyLinkedList<WordEntry>();
						for(int i=0;i<str.length;i++){
							kl.addElem(this.getPageIndex().getWordEntries().getElem(z+i));
						}
			//			System.out.println(kl.list1.size());
						if(kl.list1.size()!=0){
							int k=0;
							for(int y=0;y<str.length;y++){
			//					System.out.println("kl wala for");
								
								if(kl.getElem(y).str.equals(str[y])){
			//						System.out.println("seonf if");
									k++;
			//						System.out.println(k);
			//						System.out.println(drf.length);
								}
								
							}
							if(k==str.length){
								MyLinkedList<Position> cv = new MyLinkedList<Position>();
								cv=this.getPageIndex().getWordEntries().getElem(z).getAllPositionsForThisWord();
								for(int lkp=0;lkp<cv.list1.size();lkp++){
									float cn=(float)1/cv.list1.get(lkp).wordIndex;
									ross +=(float)(cn*cn);
								}
							}
						}					
				}	
			}	
		}
		
		else{
			MyLinkedList<Position> gunther = new MyLinkedList<Position>();
			for(int z=0;z<this.getPageIndex().getWordEntries().list1.size();z++){
			for(int bg=0;bg<str.length;bg++){
				if(this.getPageIndex().getWordEntries().getElem(z).str.equals(str[bg])){
					for(int l=0;l<this.getPageIndex().getWordEntries().getElem(z).getAllPositionsForThisWord().list1.size();l++){
						gunther.addElem(this.getPageIndex().getWordEntries().getElem(z).getAllPositionsForThisWord().getElem(l));
					}					
				}
			}		
			}
			//System.out.println(gunther.list1.size());
			for(int h=0;h<gunther.list1.size();h++){
			float cn=(float)1/gunther.list1.get(h).wordIndex;
				
			//System.out.println(gunther.list1.get(h).wordIndex);
			//System.out.println(cn);	
			ross +=(float)(cn*cn);			
			}
		}	
	}
	//System.out.println(ross);
	return ross;
	}
}