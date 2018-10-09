
public class AVLTree
{
    private AVLNode root;  
     
    public AVLTree()
    {
        root = null;
    }
    public boolean isEmpty()
    {
        return root == null;
    }
     
    public AVLNode getRoot()
    {
	    return root;
    }
    public void insert(Position data)
    {
        root = insert1(root, data);
    }
    public int height(AVLNode node)
    {
        if (node == null)
            return 0;
        return node.getHeight();
    }

    public int max(int first, int second)
    {
        if(first>second) return first;
        else return second;
    }
    public boolean search(int wordIndex,PageEntry page)
    {
        return search(root,wordIndex,page);
    }
    
    public int isThisCorrect(AVLNode node)
    {
        if (node == null)
            return 0;
        return height(node.getLeft()) - height(node.getRight());
    }

    private boolean search(AVLNode r, int wordIndex,PageEntry page)
    {
        if(r==null)   
            return false;
        Position current = r.getPosition();
        int cIndex=current.getWordIndex();
        if (wordIndex< cIndex)
            return search(r.getLeft(),wordIndex,page);
        else if (wordIndex >cIndex)
             return search(r.getRight(),wordIndex,page);
        else  if(page.equals(current.getPageEntry())) 
            return true;
        else return search(r.getRight(),wordIndex,page) || search(r.getLeft(),wordIndex,page);

    }
 
    public AVLNode insert1( AVLNode node, Position key)
    {
        if (node == null)
            return(new AVLNode(key));
 
        if (key.getWordIndex()<=node.getPosition().getWordIndex())
            node.setLeft(insert1(node.getLeft(), key));
        else
            node.setRight(insert1(node.getRight(), key));
        node.setHeight( max(height(node.getLeft()), height(node.getRight())) + 1);

        int is = isThisCorrect(node);
        if (is > 1 && key.getWordIndex() <= node.getLeft().getPosition().getWordIndex())
            return rightRotate(node);
 
        if (is < -1 && key.getWordIndex() >node.getRight().getPosition().getWordIndex())
            return leftRotate(node);
 
        if (is > 1 && key.getWordIndex() > node.getLeft().getPosition().getWordIndex())
        {
            node.setLeft(leftRotate(node.getLeft()));
            return rightRotate(node);
        }
   
        if (is < -1 && key.getWordIndex() <= node.getRight().getPosition().getWordIndex())
        {
            node.setRight(rightRotate(node.getRight()));
                return leftRotate(node);
        }
        return node;
    }

    public AVLNode leftRotate(AVLNode node)
    {
        AVLNode n = node.getRight();
        AVLNode r = n.getLeft();
        n.setLeft(node);
        node.setRight(r);
        
        node.setHeight(max(height(node.getLeft()), height(node.getRight()))+1);
        n.setHeight(max(height(n.getLeft()), height(n.getRight()))+1);
        
        return n;
    }
    public AVLNode rightRotate(AVLNode node)
    {
        AVLNode l = node.getLeft();
        AVLNode r = l.getRight();
        l.setRight(node);
        node.setLeft(r);
        node.setHeight(max(height(node.getLeft()), height(node.getRight()))+1);
        l.setHeight(max(height(l.getLeft()), height(l.getRight()))+1);
        return l;
    }
 }

     