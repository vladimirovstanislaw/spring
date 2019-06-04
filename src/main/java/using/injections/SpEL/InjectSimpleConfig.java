package using.injections.SpEL;

public class InjectSimpleConfig {
	private String name = "Chris Schaefer";
	private int age = 32;
	private float height = 1.778f;
	private boolean programmer = true;
	private Long ageInSeconds = 1009843200L;

	@Override
	public String toString() {
		return "InjectSimpleConfig [name=" + name + ", age=" + age + ", height=" + height + ", programmer=" + programmer
				+ ", ageInSeconds=" + ageInSeconds + ", getName()=" + getName() + ", getAge()=" + getAge()
				+ ", getHeight()=" + getHeight() + ", isProgrammer()=" + isProgrammer() + ", getAgeInSeconds()="
				+ getAgeInSeconds() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public boolean isProgrammer() {
		return programmer;
	}

	public void setProgrammer(boolean programmer) {
		this.programmer = programmer;
	}

	public Long getAgeInSeconds() {
		return ageInSeconds;
	}

	public void setAgeInSeconds(Long ageInSeconds) {
		this.ageInSeconds = ageInSeconds;
	}

}
