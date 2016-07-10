package colorhelper;

public class TestHex {
	
	public static void main(String[] args) {
//		testHexMethod();
		testColorMethod();
	}

	/**
	 * test the hex mothod for color values
	 */
	private static void testHexMethod() {
		String GLOBAL_INPUTVALUE = "321234";
		int r = (int) (Long.parseLong(GLOBAL_INPUTVALUE)/10000);
		int g = (int) (Long.parseLong(GLOBAL_INPUTVALUE)/100)- r*100;
		int b = (int) (Long.parseLong(GLOBAL_INPUTVALUE)%100);
		
		System.out.println("R=:"+ r+"\n" +"G=: "+ g + "\n"+"B=:" + b);
	}

	/**
	 * test the color original values by Color.rgb()
	 */
	public static void testColorMethod() {
		String GLOBAL_INPUTVALUE = "12.234.221";
		String [] arr = GLOBAL_INPUTVALUE.split("\\.");
		int [] colors = new int[]{0,1,2};
		for (int i = 0 ; i< arr.length;i++) {
			colors[i] = Integer.parseInt(arr[i]);
		}
		
		System.out.println(colors[0]+"\n" + colors[1]+ "\n" + colors[2]);
	}
	
}
