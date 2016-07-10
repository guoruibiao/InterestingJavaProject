package randomnumber;

public class MyRandom {

	private final static long TIMESEED = System.currentTimeMillis();

	private long disOrganize() {
		long temp = TIMESEED * (long) 2.8f << (int)(Math.random() * 7);
		return temp;
	}

	public int randomInt() {
		return (int) disOrganize();
	}

	public float randomFloat() {
		return (float) disOrganize();
	}

	public double randomDouble() {
		return (double) disOrganize();
	}

	public long randomLong() {
		return disOrganize();
	}

}
