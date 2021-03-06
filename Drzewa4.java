class Node
{
	 int key;
	 int number;
	 Node  parent;
	 Node  left;
	 Node  right;
 
	 Node(int k, int nr, Node p, Node l, Node r)
    {
        this.key    = k;
        this.number = nr;
        this.parent = p;
        this.left   = l;
        this.right  = r;
    }
}
 
class Tree
{
    Node root;

    Tree()
    {
    }

//wezly maja nry odpowiadajace ilosci ich wystepowania, moga sie powtarzac
public void  wstaw(int k) 
    {
        Node n;
        if (root == null){
            n = new Node (k, 1, null, null, null);
        	root = n;
        }
        else
        {
        Node m = root;
        while (true)
        	{
        	if(k<m.key){
        		if (m.left==null){
        			n = new Node (k, 1, m, null, null);
        			m.left=n;
        			break;
        		 	}
        		else m=m.left;
        		}
        	
        	if(k>m.key){
        		if (m.right==null){
        			n = new Node (k, 1, m, null, null);
        			m.right=n;
        			break;
    		 		}
    		else m=m.right;
        		}
        	if (k==m.key) {
        			m.number+=1;
        			break;
        			}
        	}
        }
    }

    
//metoda post-order 
public   void drukuj(Node n)
 {
 // Node n = root;
  if (n!=null){
	  
  drukuj(n.left);
  drukuj(n.right);
  System.out.printf(n.key+"	");
  }
  }
	


    
public	void usun(int k)
	{
	Node n=szukaj2(k);
	if(n==null)	{
	System.out.println("Klucza "+k+" nie ma w drzewie"); 
	return;
	} else {
		
	//System.out.println("W drzewie jest "+ n.number+" podanych kluczy ");
	if (n!=null && n.number==1) {
		//jesli root jest lisciem
		if (n==root && n.left==null && n.right==null) {
			root=null;
			return;
		}
	Node m; //wezel pomocniczy

	//lisc, usuwam odwolanie u rodzica:
	if (n.left==null && n.right==null) {
		m=n.parent;
		if(n.key<m.key)m.left=null; else m.right=null;
		return;
	}
	//dwoch potomkow, zamieniam za najmniejszego z wiekszych:
	if (n.left!=null && n.right!=null) {
		m=n.right;	
		while (m.left!=null)
 		{
			m=m.left;
 		}
		n.key=m.key;//podmiana wartosci
		if (m.right!=null){
			m.right.parent=m.parent;
			m.parent.right=m.right;
		}else m.parent.left=null;
		return;
	}
	//jeden potomek, lewy:
	if (n.left!=null && n.right==null) {
	if(n.left.left==null && n.left.right==null) {
	n.key=n.left.key;
	n.left=null;
	}
	else {
	n.left.parent=n.parent;
	n=n.left;	
	m=n.parent;
	if(n.key<m.key)m.left=n; else m.right=n;
	}
	return;	
	}
	//jeden potomek, prawy:
		if (n.left==null && n.right!=null) {
		if(n.right.left==null && n.right.right==null) {
		n.key=n.right.key;
		n.right=null;
		}
		else {
		n.right.parent=n.parent;
		n=n.right;	
		m=n.parent;
		if(n.key<m.key)m.left=n; else m.right=n;
		}
		return;	
		}
		
	}
		else n.number-=1;
	}}

//szukaj zwracajace czy wezel znajduje sie w drzewie 
public boolean szukaj(int k)
    {
    Node n = root;
    if (n!=null) {
    while (true)
    	{
    	if(k<n.key){
    		if (n.left==null)break;
    		else n=n.left;
    		}
    	if(k>n.key){
    		if (n.right==null)break;
		else n=n.right;
    		}
    	if(k==n.key) {System.out.println("W drzewie jest podany klucz"); return true;}
    	}
    System.out.println("W drzewie nie ma podanego klucza");
    return false;
    }
    else {System.out.println("W drzewie nie ma podanego klucza"); return false;}
    }
//szukaj zwracajace sam wezel, jesli znajduje sie w drzewie, metoda pomocnicza dla usuwania
public Node szukaj2(int k)
{
Node n = root;
if (n!=null) {
while (true)
	{
	if(k<n.key){
		if (n.left==null)break;
		else n=n.left;
		}
	if(k>n.key){
		if (n.right==null)break;
	else n=n.right;
		}
	if(k==n.key)return n;
	}
return null;
}
else {
	//System.out.println("W drzewie nie ma podanego klucza"); 
	return null;}
}
}    
    


//---------------------------------------------------------------------------------------------



//---------------------------------------------------------------------------------------------

public class Drzewa4 {
 
    public static void main(String[] args) {
 
    	Tree t1 = new Tree(); //tworzymy drzewo
    	t1.wstaw(6);
    	t1.wstaw(7);
    	t1.wstaw(7);
    	t1.wstaw(7);
    	t1.wstaw(8);
    	t1.wstaw(9);
    	t1.wstaw(3);
    	t1.usun(12);
    	t1.usun(7);
    	t1.usun(7);
    	t1.szukaj(12);
    	System.out.println("Drzewo w notacji post-order:");
    	t1.drukuj(t1.root);
    }
}
