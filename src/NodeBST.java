public class NodeBST<K, T> {

	public long data;
	public NodeBST<K,T> Left;
	public NodeBST<K, T> Right;
	
	public BST<TreeNode<PairTree<Pair, Student>>> tree;
	
	NodeBST(BST<TreeNode<PairTree<Pair, Student>>> tree)
	{
		this.tree=tree;
	}

	public TreeNode<PairTree<Pair, Student>> root()
	{
		return tree.root();
	}
}
