import java.lang.Math; 

public class MyHashTableDoubleHashing<K, T> implements MyHashTable_<K, T> {

	K key;
	T obj;
	static int N;
	Node<Pair, Student> [] table;
	MyHashTableDoubleHashing(K key, T obj, int n)
	{
		this.key=key;
		this.obj=obj;
		N= n;

		table=new Node[N];;
	}
	static int SizeOfHashTable=N;
	
	public static long djb2(String str, int sizeOfHashTable2) 
	{ 
		long hash = 5381; 
	    for (int i = 0; i < str.length(); i++) { 
	        hash = ((hash << 5) + hash) + str.charAt(i); 
	    }
	    SizeOfHashTable=N;
	    return Math.abs(hash) % SizeOfHashTable;
	}
	
	public static long sdbm(String str, int hashtableSize) { 
		long hash = 0; 
	    for (int i = 0; i < str.length(); i++) { 
	        hash = str.charAt(i) + (hash << 6) + (hash << 16) - hash; 
	    } 
	    
	    return Math.abs(hash) % (hashtableSize - 1) + 1; 
	}
	
	@Override
	public int insert(K key, T obj) 
	{
		int i1=0;
		Pair key1=(Pair) key;
		String str1=key1.FirstName()+key1.LastName(); 				//K should be Pair
		int h1=(int) djb2(str1, SizeOfHashTable);
		int h2=(int) sdbm(str1,  SizeOfHashTable);
		Student obj1=(Student) obj;
		
		while(i1<SizeOfHashTable)
		{
			int hi=(h1+ i1*h2)%SizeOfHashTable;
			
//			System.out.println("VALUE OF h1= "+h1);
//			System.out.println("Value of i= "+i1);
//			System.out.println("Value of h2= "+h2);
//			System.out.println("Value of hi= "+hi);
			
			if(table.length>hi&&hi>=0)
			{
				if(table[ hi]==null)
				{
					Node<Pair, Student> NodeForInsertion=new Node<Pair, Student> (key1, obj1); 
					table[ hi]=NodeForInsertion;
					i1++;
					break;
				}
				
				else
				{
					i1++;
				}
			}
			else
			{
				i1++;				
			}
		}
		
		return i1;
	}
	
	
	@Override
	public int update(K key, T obj) {
		int i=0;
		Pair key1=(Pair) key;
		String str1=key1.FirstName()+key1.LastName(); 				//K should be Pair
		int h1=(int) djb2(str1, SizeOfHashTable);
		int h2=(int) sdbm(str1,  SizeOfHashTable);
		Student obj1=(Student) obj;
		
		while(i<SizeOfHashTable)
		{
			int hi=(h1+ i*h2)%SizeOfHashTable;
//			
//			System.out.println("VALUE OF h1= "+h1);
//			System.out.println("Value of i= "+i);
//			System.out.println("Value of h2= "+h2);
//			System.out.println("Value of hi= "+hi);
			
			if(table.length>hi&&hi>=0)
			{
				String s1=table[hi].key().FirstName()+table[hi].key().LastName();
				if(s1.equals(str1))
				{
					table[(int) hi].value=obj1;
					i++;
					break;
				}
				else
				{
					i++;
				}
			}
			else
			{
				i++;
			}
		}
		return  i;
		
	}
	
	@Override	
	public int delete(K key) {
		int i=0;
		
		SizeOfHashTable=N;
		Pair key1=(Pair) key;
		String str1=key1.FirstName()+key1.LastName(); 				//K should be Pair
		int h1=(int) djb2(str1,SizeOfHashTable);
		int h2=(int) sdbm(str1, SizeOfHashTable);
		while(i<SizeOfHashTable)
		{
			int hi=(h1+i*h2)%SizeOfHashTable;			
//			System.out.println("Node to be deleted has key= "+key1.FirstName()+key1.LastName());
			
//			System.out.println("VALUE OF h1= "+h1);
//			System.out.println("Value of i= "+i);
//			System.out.println("Value of h2= "+h2);
//			System.out.println("Value of hi= "+hi);
			if(table.length>hi&&hi>=0&&table[hi]!=null)
			{
//				System.out.println("Node checked has key= "+table[hi].key().FirstName()+table[hi].key().LastName());
				String s1=table[hi].key().FirstName()+table[hi].key().LastName();
				if(s1.equals(str1))
				{
					table[hi]=null;
					i++;
					break;
				}
				else
				{
					i++;
				}
			}
			else
			{
				i++;
			}
		}
		return i;
		
	}

	@Override
	public boolean contains(K key) {
		int i=0;
		
		Pair key1=(Pair) key;
		String str1=key1.FirstName(); 				//K should be Pair
		int h1=(int) djb2(str1, SizeOfHashTable);
		int h2=(int) sdbm(str1, SizeOfHashTable);
		while(i<SizeOfHashTable)
		{
			int hi=(h1+i*h2)%SizeOfHashTable;
			
			if(table.length>hi&&hi>=0&&table[hi]!=null)
			{
//				System.out.println("Node checked has key= "+table[hi].key().FirstName()+table[hi].key().LastName());
				String s1=table[hi].key().FirstName()+table[hi].key().LastName();
				if(s1.equals(str1))
				{
					return true;
				}
				else
				{
					i++;
				}
			}
			else
			{
				i++;
			}
		}
		return false;
	}
	
	public T get(K key) throws NotFoundException 			//Executing multiple times than required
	{
//		try
//		{
			int i=0;
			
			Pair key1=(Pair) key;
			String str1=key1.FirstName()+key1.LastName(); 				//K should be Pair
			int h1=(int) djb2(str1, SizeOfHashTable);
			int h2=(int) sdbm(str1, SizeOfHashTable);
			while(i<SizeOfHashTable)
			{
				int hi=(h1+i*h2)%SizeOfHashTable;
				
				if(table.length>hi&&hi>=0&&table[hi]!=null)
				{
//					System.out.println("Node checked has key= "+table[hi].key().FirstName()+table[hi].key().LastName());
					String s1=table[hi].key().FirstName()+table[hi].key().LastName();
					if(s1.equals(str1))
					{
//						System.out.println("klashf");
//						System.out.println("count= "+i);
						return (T) table[hi].Value();
					}
					else
					{
						i++;
					}
				}
				else
				{
					i++;
				}
			}
			
			return null;
//		}
//		
//		catch(Exception e)
//		{
//			System.out.println("E");
//			return null;
//		}
	}
	
	public String address(K key) throws NotFoundException
	{
//		try 
//		{
		int i=0;
		
		Pair key1=(Pair) key;
		String str1=key1.FirstName()+key1.LastName(); 				//K should be Pair
		int h1=(int) djb2(str1, SizeOfHashTable);
		int h2=(int) sdbm(str1, SizeOfHashTable);
		while(i<SizeOfHashTable)
		{
			int hi=(h1+i*h2)%SizeOfHashTable;
			
			if(table.length>hi&&hi>=0&&table[hi]!=null)
			{
//				System.out.println("Node checked has key= "+table[hi].key().FirstName()+table[hi].key().LastName());
				String s1=table[hi].key().FirstName()+table[hi].key().LastName();
				if(s1.equals(str1))
				{
//					System.out.println("klashf");
//					System.out.println("count= "+i);
					return Integer.toString(hi);
				}
				else
				{
					i++;
				}
			}
			else
			{
				i++;
			}
		}
		
		return "E";
//		 }
//		
//		catch(Exception e)
//		{
//			System.out.println("E");
//			return null;
//		}
	}
	
	
}
