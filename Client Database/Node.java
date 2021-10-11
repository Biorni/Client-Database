class Node
{
	double key;
	Node leftChild;
	Node rightChild;
	
	public Node(double key)
	{
		this.key = key;
		leftChild = null;
		rightChild = null;
	}

	public void display()      
    {
    	System.out.print('{');
    	System.out.print(key);
        System.out.print("} ");
    }
}