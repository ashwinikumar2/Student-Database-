
public class Student implements Student_ {

	public String firstname,lastname,hostel, department, cgpa;
	static long index;
	Student(String firstname, String lastname, String hostel, String department, String cgpa)
	{
		this.firstname=firstname;
		this.lastname=lastname;
		this.hostel=hostel;
		this.department=department;
		this.cgpa=cgpa;
		index=0;
	}
	@Override
	public String fname() {
		return firstname;
	}

	@Override
	public String lname() {
		return lastname;
	}

	@Override
	public String hostel() {
		return hostel;
	}

	@Override
	public String department() {
		return department;
	}

	@Override
	public String cgpa() {
		return cgpa;
	}
	
}
