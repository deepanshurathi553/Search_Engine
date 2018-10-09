
public class SearchResult implements Comparable<SearchResult>{

	PageEntry thisEntry;
	float thisRelevance;

	public SearchResult(PageEntry p, float r){
		thisEntry = p;
		thisRelevance = r;	
	}
	public PageEntry getPageEntry(){
		return thisEntry;
	}
	public float getRelevance(){
		return thisRelevance;
	}

	public int compareTo(SearchResult otherObject){
	if(thisRelevance==otherObject.thisRelevance)return 0;
	else if(thisRelevance>otherObject.thisRelevance)return 1;
	else return -1;	
	}

}