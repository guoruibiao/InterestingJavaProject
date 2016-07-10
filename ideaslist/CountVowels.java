package ideaslist;

/**
 * ���ڣ�2016��5��2��23:29:25
 * 
 * ���ܣ� ����������ݽ��й��ˣ�ͳ�����������Ԫ����ĸ�ĸ���
 * 
 * ����������һ���ַ�����ͳ�ƴ�����Ԫ����ĸ�������������ӵ�Ļ�ͳ�Ƴ�ÿ��Ԫ����ĸ��������
 * 
 * @author Administrator
 *
 */
public class CountVowels {

	/**
	 * ���ܣ�ʵ�ֶ�������ַ����е�Ԫ����ĸ�ĸ�����ͳ�� ���з��ص����������У�ֵ˳��������a/A,e/E,i/I,o/O,u/U�Լ��ܵ�Ԫ����ĸ�ĸ���
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
			throw new RuntimeException("����ԭ�� " + e);
		}

	}

	public static void main(String[] args) {
		String testStr = "I am A GOod Boy��and You? ";
		int[] result = countVowels(testStr);
		System.out.println("Ԫ��a/A�ĸ���Ϊ" + result[0]);
		System.out.println("Ԫ��e/E�ĸ���Ϊ" + result[1]);
		System.out.println("Ԫ��i/I�ĸ���Ϊ" + result[2]);
		System.out.println("Ԫ��o/O�ĸ���Ϊ" + result[3]);
		System.out.println("Ԫ��u/U�ĸ���Ϊ" + result[4]);
		System.out.println("Ԫ����ĸ���ܸ���Ϊ" + result[5]);
		
		
	}

}
