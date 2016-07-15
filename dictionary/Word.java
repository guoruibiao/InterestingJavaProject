package dictionary;

public class Word {

	private String name;
	private String value;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Word [name=" + name + ", value=" + value + "]";
	}

	public Word() {
		super();
		// TODO Auto-generated constructor stub
	}

}
