
public class AVLNode 
{

	Position p;
    AVLNode left;
	AVLNode right;
	int height;
	
	public AVLNode(Position pos)
	{
		p=pos;
		height=1;	
	}
	public AVLNode(){}
	public void setPosition(Position pos)
	{
		p=pos;
	}
	public Position getPosition()
	{
		return p;
	}
	
	public int getHeight()
	{
		return height;
	}
	public void setHeight(int h)
	{
		height=h;
	}	
	public void setLeft(AVLNode l)
	{
		left=l;
	}
	public void setRight(AVLNode l)
	{
		right=l;
	}
	public AVLNode getLeft()
	{
		return left;
	}
	public AVLNode getRight()
	{
		return right;
	}
}