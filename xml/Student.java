/**
 * @Date 2016年7月19日
 *
 * @author Administrator
 */
package xml;

/**
 * @author 郭瑞彪
 *
 */
public class Student {

	private String name;
	private int age;
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

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}
	
}
