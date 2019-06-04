package using.injections;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("injectSimple")
public class InjectSimple {
	@Value("Chris Schaefer")
	private String name;
	@Value("32")
	private int age;
	@Value("1.777")
	private float height;
	@Value("false")
	private boolean programmer;
	@Value("1009843200")
	private Long ageInSeconds;

	@Override
	public String toString() {
		return "InjectSimple [name=" + name + ", age=" + age + ", height=" + height + ", programmer=" + programmer
				+ ", ageInSeconds=" + ageInSeconds + "]";
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
