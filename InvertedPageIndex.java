import java.util.*;
import java.io.*;

public class InvertedPageIndex {
	
	MyHashTable ftable = new MyHashTable();
	Myset<PageEntry> set = new Myset<PageEntry>();
	public InvertedPageIndex(){
	}
	public void addPage(PageEntry p) throws IOException{
		PageEntry newEntry = new PageEntry(p.fileName);
		set.addElement(p);
		for(int uq=0;uq<p.getPageIndex().wordEntry.getSize();uq++){
		//	System.out.println("for loop of addPage");
			ftable.addPositionsForWord(p.getPageIndex().wordEntry.list1.get(uq));
		}
	}

	public Myset<PageEntry> getPagesWhichContainWord(String str1){
		//System.out.println("getPagesWhichContainWord me hu");
		Myset<PageEntry> x = new Myset<PageEntry>();
		int fuck = ftable.getHashIndex(str1);
		//System.out.println(fuck);
		int cool = ftable.hashtable[fuck].list1.size();
		//System.out.println(cool);
		for(int bc=0;bc<cool;bc++){
			if(ftable.hashtable[fuck].getElem(bc).str.equals(str1)){
				WordEntry xd = ftable.hashtable[fuck].getElem(bc);
				MyLinkedList<Position> pos = xd.getAllPositionsForThisWord();
				for(int xp=0;xp<pos.getSize();xp++){
					Position xs = pos.getElem(xp);
					if(x.isMember(xs.getPageEntry())!=true){
						x.addElement(xs.getPageEntry());
					}
				}
			}
		}
		//System.out.println(x.set1.list1.size());
		return x;
	}

	public Myset<PageEntry> getPagesWhichContainAllWords(String drf[]){
		int c = drf.length;
		Myset<PageEntry> xy = new Myset<PageEntry>();
		xy = getPagesWhichContainWord(drf[0]);
		for(int vg=1;vg<c;vg++){
			xy = xy.intersection(getPagesWhichContainWord(drf[vg]), xy);
		}
		return xy;
	}
	public Myset<PageEntry> getPagesWhichContainAtLeastOneWord(String drf[]){
		int c = drf.length;
		Myset<PageEntry> xy = new Myset<PageEntry>();
		xy = getPagesWhichContainWord(drf[0]);
		for(int k=1;k<drf.length;k++){
			xy = xy.union(getPagesWhichContainWord(drf[k]), xy);
		}
		return xy;
	}

	public Myset<PageEntry> getPagesWhichContainPhrase(String drf[]){
		//System.out.println("imside the func");
		Myset<PageEntry> xy = new Myset<PageEntry>();
		xy = getPagesWhichContainWord(drf[0]);
		for(int vg=1;vg<drf.length;vg++){
			xy = xy.intersection(getPagesWhichContainWord(drf[vg]), xy);
		}
		Myset<PageEntry> thug = new Myset<PageEntry>();
		for(int nj=0;nj<xy.getSizeSet();nj++){
			//System.out.println("first for");
			for(int z=0;z<xy.getElement(nj).getPageIndex().getWordEntries().list1.size();z++){
				//System.out.println("second for");
				if(xy.getElement(nj).getPageIndex().getWordEntries().getElem(z).str.equals(drf[0])){		
			//		System.out.println("first if");
					MyLinkedList<WordEntry> kl = new MyLinkedList<WordEntry>();
						for(int i=0;i<drf.length;i++){
							if((z+i)<xy.getElement(nj).getPageIndex().getWordEntries().list1.size())
							kl.addElem(xy.getElement(nj).getPageIndex().getWordEntries().getElem(z+i));
							else{
								kl=null;
								break;
							}
						}
			//			System.out.println(kl.list1.size());
						if(kl!=null){
							int k=0;
							for(int y=0;y<drf.length;y++){
			//					System.out.println("kl wala for");
								
								if(kl.getElem(y).str.equals(drf[y])){
			//						System.out.println("seonf if");
									k++;
			//						System.out.println(k);
			//						System.out.println(drf.length);
								}
								
							}
							if(k==drf.length){
								thug.addElement(xy.getElement(nj));
							}
						}					
				}	
			}				
		}
		return thug;
	}
}