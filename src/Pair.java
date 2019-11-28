public class Pair
{
	public String firstname;
	public String lastname;
	public static long index;
	
	Pair(String firstname, String lastname)
	{
		this.firstname=firstname;
		this.lastname=lastname;
	}
	
	public String FirstName()
	{
		return firstname;
		
	}
	public String LastName()
	{
		return lastname;
	}
}
