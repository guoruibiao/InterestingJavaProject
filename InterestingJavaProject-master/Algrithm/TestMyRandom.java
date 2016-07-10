package randomnumber;

public class TestMyRandom {

	public static void main(String[] args) {
		MyRandom random = new MyRandom();
		int[] result = new int[10];
		System.out.println(random.randomInt());
		System.out.println(random.randomFloat());
		System.out.println(random.randomDouble());
		System.out.println(random.randomLong());
	}
	
}
