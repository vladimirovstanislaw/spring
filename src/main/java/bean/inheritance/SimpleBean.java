package bean.inheritance;

public class SimpleBean {
	private String name;
	private int age;

	public SimpleBean() {

	}

	public SimpleBean(String name, int age) {
		super();
		this.age = age;
		this.name = name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String toString() {
		return "Name: " + name + "\n" + "Age: " + age;
	}
}
