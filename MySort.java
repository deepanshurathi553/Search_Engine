import java.util.ArrayList;
public class MySort<Sortable extends Comparable<? super Sortable>>{

	
	public ArrayList<Sortable> sortThisList(Myset<Sortable> listOfSortableEntries){
		ArrayList<Sortable> list=new ArrayList<Sortable>();
		int n=listOfSortableEntries.getSizeSet();
		for(int i=0;i<n;i++)
		{
			list.add(listOfSortableEntries.getElement(i));
		}
		ArrayList<Sortable> out=new ArrayList<Sortable>();
		Sortable temp;
		for(int i=0;i<n;i++)
		{
			temp=list.get(0);
			for(int j=1;j<n-i;j++)
			{
				Sortable c=list.get(j);
			//	TODO comparison
				if(c.compareTo(temp)>0)
					temp=c;
			}
           list.remove(temp);
           out.add(temp);

		}
		return out;
	}
}