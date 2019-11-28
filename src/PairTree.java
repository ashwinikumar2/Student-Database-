
public class PairTree<K, T> {

	K Key;
	T Obj;
	
	PairTree(K key, T obj)
	{
		this.Key=key;
		this.Obj=obj;
	}
	
	public K key()
	{
		return Key;
	}
	
	public T value()
	{
		return Obj;
	}
}
