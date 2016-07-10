package convertion;

public class Parent {
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Parent [name=" + name + "]";
	}
	
	public void say() {
		// TODO Auto-generated method stub
		System.out.println(toString());
	}
	
}
