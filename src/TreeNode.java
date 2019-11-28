public class TreeNode<X> {

	
	public X Data;
	public TreeNode<X> Left, Right;
	TreeNode( X Data)
	{
		this.Data=Data;
		Left=null;
		Right=null;
	}
	
	public X data()
	{
		return Data;
	}
	
	public TreeNode<X> left()
	{
		return Left;
	}
	
	public TreeNode<X> right()
	{
		return Right;
	}
}
