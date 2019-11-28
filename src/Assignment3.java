import java.io.*;

public class Assignment3 
{
	public static void main (String[] args) throws IOException, NotFoundException
	{
		int N=Integer.parseInt(args[0]);
		String approach=args[1];
		String filename=args[2];
	
	
//		int N=1;
//		String approach="SCBST";
//		String filename="H:\\1 sem 2019-20\\col106\\Practice\\Assignment3\\question.txt";
		
		if(approach.equals("DH"))
		{
			MyHashTableDoubleHashing<Pair, Student> HashTable;
			HashTable=new MyHashTableDoubleHashing<Pair, Student>( null,null ,N );
			FileReader file1=new FileReader(filename);
			BufferedReader file=new BufferedReader(file1);
			
			while(file.ready())
			{
				
				String line=file.readLine();
				String [] word=line.split(" ");
				
				if(word[0].equals("insert"))
				{
//					System.out.println(word[0]+word[1]+" "+word[2]+" "+word[3]);
					String firstname=word[1],lastname=word[2],hostel=word[3],department=word[4],cgpa=word[5];
					Student obj=new Student(firstname, lastname, hostel, department, cgpa);
					Pair p=new Pair(firstname, lastname);					
					System.out.println(HashTable.insert(p, obj));
				}
				else if(word[0].equals("update"))
				{
//					System.out.println(word[0]+word[1]+" "+word[2]+" "+word[3]);
					String firstname=word[1],lastname=word[2],hostel=word[3],department=word[4],cgpa=word[5];
					Student obj=new Student(firstname, lastname, hostel, department, cgpa);
					Pair p=new Pair(firstname, lastname);
					
					System.out.println(HashTable.update(p, obj));
				}
//				
				else if(word[0].equals("delete"))
				{
//					System.out.println(word[0]+" "+word[1]+" "+word[2]);
					String firstname=word[1],lastname=word[2];
					
					Pair p=new Pair(firstname, lastname);
					int x=HashTable.delete(p);
					if(x==-1)
					{
						System.out.println("E");
					}
					else
					System.out.println(x);
				}
				
				else if(word[0].equals("contains"))
				{
//					System.out.println(word[0]+" "+word[1]+" "+word[2]);
					String firstname=word[1],lastname=word[2];
					
					Pair p=new Pair(firstname, lastname);
					String s;
					if(HashTable.contains(p)==false)
					{
						s="F";
					}
					
					else if(HashTable.contains(p)==true)
					{
						s="T";
					}
					else
					{
						s="E";
					}
			
					System.out.println(s);
				}
				
				else if(word[0].equals("get"))
				{
//					System.out.println(word[0]+" "+word[1]+" "+word[2]);
					String firstname=word[1],lastname=word[2];
					
					Pair p=new Pair(firstname, lastname);
					Student s=HashTable.get(p);
					if(s==null)
					{
						System.out.println("E");
					}
					else
					{
					System.out.println(s.fname()+" "+s.lname()+" "+s.hostel+" "+s.department+" "+s.cgpa);
					}
				}
				else if(word[0].equals("address"))
				{
//					System.out.println(word[0]+" "+word[1]+" "+word[2]);
					String firstname=word[1],lastname=word[2];
					
					Pair p=new Pair(firstname, lastname);
					
					String s=HashTable.address(p);
					
					if(s==null)
					{System.out.println("E");
					}
					else
						System.out.println(s);
					}
				}
			
			file1.close();
		}
		
		if(approach.equals("SCBST"))
		{
			MyHashTableSeperateChaining<Pair, Student> HashTable;
			HashTable=new MyHashTableSeperateChaining<Pair, Student>( null,null ,N );
			FileReader file1=new FileReader(filename);
			BufferedReader file=new BufferedReader(file1);
			
			while(file.ready())
			{
				
				String line=file.readLine();
				String [] word=line.split(" ");
				
				if(word[0].equals("insert"))
				{
//					System.out.println(word[0]+" "+word[1]+" "+word[2]+" "+word[3]);
					String firstname=word[1],lastname=word[2],hostel=word[3],department=word[4],cgpa=word[5];
					Student obj=new Student(firstname, lastname, hostel, department, cgpa);
					Pair p=new Pair(firstname, lastname);					
					System.out.println(HashTable.insert(p, obj));
//					System.out.println("");
				}
				
				else if(word[0].equals("update"))
				{
//					System.out.println(word[0]+word[1]+" "+word[2]+" "+word[3]);
					String firstname=word[1],lastname=word[2],hostel=word[3],department=word[4],cgpa=word[5];
					Student obj=new Student(firstname, lastname, hostel, department, cgpa);
					Pair p=new Pair(firstname, lastname);
					int x=HashTable.update(p, obj);
					if(x==-1)
					{
						System.out.println("E");
					}
					else
					System.out.println(x);
					
				}
				
				else if(word[0].equals("delete"))
				{
//					System.out.println(word[0]+word[1]+" "+word[2]);
//					
					String firstname=word[1],lastname=word[2];
					Student obj=new Student(firstname, lastname, null, null, null);
					
					Pair p=new Pair(firstname, lastname);
					int x=HashTable.delete(p);
					if(x!=-1)
					{
						System.out.println(x);
					}
					else
						System.out.println("E");
					
					
					
				}
				
				else if(word[0].equals("contains"))
				{
//					System.out.println(word[0]+" "+word[1]+" "+word[2]);
					String firstname=word[1],lastname=word[2];
					
					Pair p=new Pair(firstname, lastname);
					String s;
					if(HashTable.contains(p)==false)
					{
						s="F";
					}
					
					else if(HashTable.contains(p)==true)
					{
						s="T";
					}
					else
					{
						s="E";
					}
			
					System.out.println(s);
				}
				
				else if(word[0].equals("get"))
				{
//					System.out.println(word[0]+" "+word[1]+" "+word[2]);
					String firstname=word[1],lastname=word[2];
					
					Pair p=new Pair(firstname, lastname);
					Student s=HashTable.get(p);
					if(s==null)
					{
						System.out.println("E");
					}
					else
					{
					System.out.println(s.fname()+" "+s.lname()+" "+s.hostel+" "+s.department+" "+s.cgpa);
					}
				}
				
				else if(word[0].equals("address"))
				{
//					System.out.println(word[0]+" "+word[1]+" "+word[2]);
					String firstname=word[1],lastname=word[2];
					
					Pair p=new Pair(firstname, lastname);
					
					String s=HashTable.address(p);
					
					if(s==null)
					{System.out.println("E");
					}
					else
						System.out.println(s);
					}
				}
			}
		}
	}	

	
