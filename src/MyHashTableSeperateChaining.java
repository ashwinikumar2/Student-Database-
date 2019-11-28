import java.lang.Math; 

public class MyHashTableSeperateChaining<K, T> implements MyHashTable_<K, T> {
	
	K Key;
	T Obj;
	
	static int N;
	NodeBST<K, T>[] table;
	MyHashTableSeperateChaining(K key, T obj, int n)
	{
		this.Key=Key;
		this.Obj=Obj;
		N=n;
		table=new NodeBST[N];
	}
	
	int SizeOfHashTable=N;
	
	public static long djb2(String str, int hashtableSize) { 
	    long hash = 5381; 
	    hashtableSize=N;
	    for (int i = 0; i < str.length(); i++) { 
	        hash = ((hash << 5) + hash) + str.charAt(i); 
	    } 
	    return Math.abs(hash) % hashtableSize; 
	}
	// Insert new object with given key 
	public int insert(K key, T obj)
	{
		
		Pair key1=(Pair) key;
		String str1=key1.FirstName()+key1.LastName();
		int h=(int) djb2(str1, SizeOfHashTable);
		Student obj1=(Student) obj;
		
		if(table.length>h&&h>=0)
		{
//			System.out.println("value of h= "+h);
//			System.out.println("value of table[h]= "+table[h]);
			if(table[h]==null)
			{
//				System.out.println("lkaf");
				PairTree<Pair, Student> p=new PairTree<Pair, Student>(key1, obj1);
				
				TreeNode<PairTree<Pair, Student>> N=new TreeNode<PairTree<Pair, Student>>(p);
				
				BST<TreeNode<PairTree<Pair, Student>>> tree=new BST<TreeNode<PairTree<Pair, Student>>> (N);
				
				NodeBST<K, T> n=new NodeBST<K,T >(tree);
				
				table[h]=n;
				
				return 1;
			}
			
			else
			{		
//				System.out.println("jrhbfdbssbsdh");
//				System.out.println(1+ (int) table[h].tree.insert(key1, obj1));
//				System.out.println(table[h].tree.insert(key1,obj1));
	
				return (1+ (int) table[h].tree.insert(key1, obj1));
			}
		}
		
		else 
		{
//			System.out.println("reaching wrong");
			return -1;
		}
	}
	 
	// Update object for given key 
	public int update(K key, T obj)
	{
		Pair key1=(Pair) key;
		String str1=key1.FirstName()+key1.LastName();
		int h=(int) djb2(str1, SizeOfHashTable);
		Student obj1=(Student) obj;
		
		if(table.length>h&&h>=0)
		{
//			System.out.println("value of h= "+h);
//			System.out.println("value of table[h]= "+table[h]);
			if(table[h]==null)
			{
				System.out.println("lkaf");
				PairTree<Pair, Student> p=new PairTree<Pair, Student>(key1, obj1);
				
				TreeNode<PairTree<Pair, Student>> N=new TreeNode<PairTree<Pair, Student>>(p);
				
				BST<TreeNode<PairTree<Pair, Student>>> tree=new BST<TreeNode<PairTree<Pair, Student>>> (N);
				
				NodeBST<K, T> n=new NodeBST<K,T >(tree);
				
				table[h]=n;
				
				return 1;
			}
			
			else
			{		
//				System.out.println("jrhbfdbssbsdh");
//				System.out.println(1+ (int) table[h].tree.insert(key1, obj1));
//				System.out.println(table[h].tree.insert(key1,obj1));
	
				return (int) table[h].tree.update(key1, obj1);
			}
		}
		
		else 
			return -1;
		
		
		
		
//		Pair key1=(Pair) key;
//		String str1=key1.FirstName();
//		long h=djb2(str1, (int) SizeOfHashTable);
//		Student obj1=(Student) obj;
//		if(table[(int) h]!=null)
//		{
//			PairTree<Pair, Student> p=new PairTree<Pair, Student>(key1, obj1);
//			TreeNode<PairTree<Pair, Student>> NodeToBeUpdated=new TreeNode<PairTree<Pair, Student>>(p);
//			
//			BST<TreeNode<PairTree<Pair, Student>>> tree=table[(int) h].tree;
//			if(tree.update(key1, obj1)==0)
//			{
//				System.out.println("E");
//				return 0;
//			}
//			else
//			{
//				return 1+(int) tree.update(key1, obj1);
//			}
//		}
//		else
//		{
//			System.out.println("E");
//			return 0;
//		}
	}
	 
	// Delete object for given key 
	public int delete(K key)			//returns -1 if key is not found
	{
		Pair key1=(Pair) key;
		String str1=key1.FirstName()+key1.LastName();
		int h=(int) djb2(str1, SizeOfHashTable);
		
//		System.out.println("value of h= "+h);
//		System.out.println("value of table[h]= "+table[h]);
		
		if(table.length>h&&h>=0)
		{
			if(table[h]==null)
			{
				return -1;
				
			}
			else
			{
				BST<TreeNode<PairTree<Pair, Student>>> tr=table[h].tree;
				int x=tr.delete(key1);
	
				
				if(tr.Root!=null)
				{
//					System.out.println("Root of the table is "+tr.Root.data().key().FirstName()+" "+tr.Root.data().key().LastName());
					if(tr.Root.right()!=null)
					{
//						System.out.println("Right of Root is "+tr.Root.right().data().key().FirstName()+" "+tr.Root.right().data().key().LastName());
						if((tr.Root.data().key().FirstName()+" "+tr.Root.data().key().LastName()).compareTo(tr.Root.right().data().key().FirstName()+" "+tr.Root.right().data().key().LastName())==0)
						{
							x--;
						}
						if(tr.Root.right().right()!=null)
						{
//							System.out.println("right of Right of Root is "+tr.Root.right().right().data().key().FirstName()+" "+tr.Root.right().right().data().key().LastName());
							if(tr.Root.right().left()!=null)
							{
//								System.out.println("left of Right of Root is "+tr.Root.right().left().data().key().FirstName()+" "+tr.Root.right().left().data().key().LastName());
							}
							if(tr.Root.right().right().right()!=null)
							{
//								System.out.println("right of Right of Root is "+tr.Root.right().right().right().data().key().FirstName()+" "+tr.Root.right().right().right().data().key().LastName());
								if(tr.Root.right().right().left()!=null)
								{
//									System.out.println("left of right of Right of Root is "+tr.Root.right().right().left().data().key().FirstName()+" "+tr.Root.right().right().left().data().key().LastName());
								}
								if(tr.Root.right().right().right().right()!=null)
								{
//									System.out.println("right of right of Right of Root is "+tr.Root.right().right().right().right().data().key().FirstName()+" "+tr.Root.right().right().right().right().data().key().LastName());
									if(tr.Root.right().right().right().left()!=null)
									{
//										System.out.println("left of right of Right of Root is "+tr.Root.right().right().left().data().key().FirstName()+" "+tr.Root.right().right().left().data().key().LastName());
									}
									if(tr.Root.right().right().right().right().right()!=null)
									{
//										System.out.println("right of right of right of Right of Root is "+tr.Root.right().right().right().right().right().data().key().FirstName()+" "+tr.Root.right().right().right().right().right().data().key().LastName());
									}
								
								}
							
							}
						}
					}
					else if (tr.Root.left()!=null)
					{
						if( (tr.Root.data().key().FirstName()+" "+tr.Root.data().key().LastName()).compareTo(tr.Root.left().data().key().FirstName()+" "+tr.Root.left().data().key().LastName())==0)
						{
							x--;
						}
					}
				}
				return x;
				
			}
				
			
		}
		else
		{
			return -1;
		}
		
//		Pair key1=(Pair) key;
//		String str1=key1.FirstName();
//		long h=djb2(str1, (int) SizeOfHashTable);
//		if(table[(int) h]!=null)
//		{
//			return table[(int) h].tree.delete(key1);
//		}
//		else
//		{
//			System.out.println("E");
//			return 0;
//		}
		
		
	}
	 
	// Does an object with this key exist? 
	public boolean contains(K key)
	{
		Pair key1=(Pair) key;
		String str1=key1.FirstName()+key1.LastName();
		long h=djb2(str1, (int) SizeOfHashTable);
		if(table[(int) h]!=null)
		{
			return table[(int) h].tree.contains(key1);
		}
		else
		{
			return false;
		}
	}
	 
	// Return the object with given key 
	@SuppressWarnings("unchecked")
	
	public T get(K key) throws NotFoundException
	{
		try 
		{
			
			Pair key1=(Pair) key;
			String str1=key1.FirstName()+key1.LastName();
			long h=djb2(str1,  SizeOfHashTable);
			if(table[(int) h]!=null)
			{
//				System.out.println("aga");
				return (T) table[(int) h].tree.get(key1);
			}
			else
			{
				return null;
			}
		}
		catch(Exception e)
		{
			System.out.println("E");
			return null;
		}
	}
	 
	// ”Address” of object with given key (explained below) 
	public String address(K key) throws NotFoundException
	{
		try
		{
			
			Pair key1=(Pair) key;
			String str1=key1.FirstName()+key1.LastName();
			int h=(int) djb2(str1,  SizeOfHashTable);
//			System.out.println("value of h = "+h);
			
			if(table[h]!=null)
			{
//				System.out.println(table[h].tree.Root.left().data().key().FirstName()+" "+table[h].tree.Root.left().data().key().LastName());
				String h1=Integer.toString((int) h)+"-";		//convert h to string
				String h2=table[ h].tree.address(key1);
				h1=h1+h2;
				BST<TreeNode<PairTree<Pair, Student>>> tr=table[h].tree;
//				System.out.println("value of h2= "+h2);
//				if((tr.Root.data().key().FirstName()+" "+tr.Root.data().key().LastName()).compareTo(tr.Root.right().data().key().FirstName()+" "+tr.Root.right().data().key().LastName())==0 || (tr.Root.data().key().FirstName()+" "+tr.Root.data().key().LastName()).compareTo(tr.Root.left().data().key().FirstName()+" "+tr.Root.left().data().key().LastName())==0)
//				{
//					return "h1";
//				}
				if(h2.equals("Root"))
				{
					return h1;
				}
				else if(h2==null)
				{
					return "E";
				}
				else
				{
				return h1;
				}
			}
			else
			{
				return null;
			}
		}
		catch(Exception e)
		{
			return null;
		}
	}
	
	
}
