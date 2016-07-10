package ideaslist;

/**
 * ���ڣ�2016��5��3��22:03:45
 * 
 * ����������������ݽ��м��ܽ��ܵļ򵥵������ԳƲ���
 * 
 * 
 * �㷨�����ڼ��ܲ������򵥵���ÿһ���ֽڼ���һ��ASCII��ֵ ���ڽ��ܲ������ԳƵļ�ȥ����
 * 
 * @author Administrator
 *
 */
public class MyEncode {

	/**
	 * ����
	 * 
	 * ����ÿһ���ֽڽ��м��ܣ�������ÿһ���ֽڼ���ASCII��ֵ
	 * 
	 * @param target
	 * @return
	 */
	public static String encode(String target) {

		try {

			byte[] temp = target.getBytes();
			byte[] middle = new byte[target.length()];
			for (int i = 0; i < temp.length; i++) {
				middle[i] = (byte) ((temp[i] + 12) % 127);
			}
			String result = new String(middle, 0, middle.length);

			return result;

		} catch (Exception e) {
			throw new RuntimeException("������Ϣ�� " + e);
		}
	}

	/**
	 * ����
	 * 
	 * ����ÿһ���ֽڽ��н��ܣ�������ÿһ���ֽڼ�ȥ�����ж�Ӧ��ASCII��ֵ
	 * 
	 * @param target
	 * @return
	 */
	public static String decode(String target) {

		try {
			byte[] temp = target.getBytes();
			byte[] middle = new byte[temp.length];
			for (int i = 0; i < temp.length; i++) {
				middle[i] = (byte) ((temp[i] - 12) % 127);
			}
			String result = new String(middle, 0, middle.length);
			return result;

		} catch (Exception e) {
			throw new RuntimeException("������Ϣ�� " + e);
		}
	}

	public static void main(String[] args) {
		String testStr = "I AM THE STRING";
		String encode_result = encode(testStr);
		System.out.println(encode_result);
		String decode_result = decode(encode_result);
		System.out.println(decode_result);
	}

}
