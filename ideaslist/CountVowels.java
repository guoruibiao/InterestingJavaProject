package ideaslist;

/**
 * 日期：2016年5月2日23:29:25
 * 
 * 功能： 对输入的数据进行过滤，统计里面包含的元音字母的个数
 * 
 * 描述：输入一个字符串，统计处其中元音字母的数量。更复杂点的话统计出每个元音字母的数量。
 * 
 * @author Administrator
 *
 */
public class CountVowels {

	/**
	 * 功能：实现对输入的字符串中的元音字母的个数的统计 其中返回的整型数组中，值顺序依次是a/A,e/E,i/I,o/O,u/U以及总的元音字母的个数
	 * 
	 * @param target
	 * @return
	 */
	public static int[] countVowels(String target) {

		try {

			int[] details = new int[6];
			byte[] chars = target.getBytes();
			for (int i = 0; i < chars.length; i++) {
				switch (chars[i]) {
				case 'a':
				case 'A':
					details[0]++;
					break;
				case 'e':
				case 'E':
					details[1]++;
					break;
				case 'i':
				case 'I':
					details[2]++;
					break;
				case 'o':
				case 'O':
					details[3]++;
					break;
				case 'u':
				case 'U':
					details[4]++;
					break;
				}

			}
			for (int j = 0; j <= 4; j++) {
				details[5] += details[j];
			}
			return details;

		} catch (Exception e) {
			throw new RuntimeException("错误原因： " + e);
		}

	}

	public static void main(String[] args) {
		String testStr = "I am A GOod Boy，and You? ";
		int[] result = countVowels(testStr);
		System.out.println("元音a/A的个数为" + result[0]);
		System.out.println("元音e/E的个数为" + result[1]);
		System.out.println("元音i/I的个数为" + result[2]);
		System.out.println("元音o/O的个数为" + result[3]);
		System.out.println("元音u/U的个数为" + result[4]);
		System.out.println("元音字母的总个数为" + result[5]);
		
		
	}

}
