package sort;

class Student implements Comparable{

	private int id ; 
	private String name;
	
	public Student (int id, String name){
		this.id = id;
		this.name = name;
	}
 
	public int getId(){return id;}
	
	public String getName(){return name;}
	
	
	@Override
	public int compareTo(Object obj) {
		 
		Student stu = (Student) obj;
		
		if(this.id < stu.id)
			return -1 ; 
		else if(this.id==stu.id)
			return 0;
		else
			return 1;
		
	} 
	
	public String toString(){	
		return "[" + Integer.toString(id) +","+  name + "]";
	}
	
	
}
