public class Node<K, T>{
	
	public K Key;
	public T value;
	
	Node(K Key, T value )
	{
		this.Key=Key;
		this.value=value;
	}
	
	public K key() 
	{
		return Key;
	}
	public T Value()
	{
		return value;
	}
}
