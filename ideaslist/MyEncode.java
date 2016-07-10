package ideaslist;

/**
 * 日期：2016年5月3日22:03:45
 * 
 * 描述：对输入的数据进行加密解密的简单的两个对称操作
 * 
 * 
 * 算法：对于加密操作，简单的令每一个字节加上一个ASCII码值 对于解密操作，对称的减去即可
 * 
 * @author Administrator
 *
 */
public class MyEncode {

	/**
	 * 加密
	 * 
	 * 对于每一个字节进行加密，即对于每一个字节加上ASCII码值
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
			throw new RuntimeException("错误信息： " + e);
		}
	}

	/**
	 * 解密
	 * 
	 * 对于每一个字节进行解密，即对于每一个字节减去加密中对应的ASCII码值
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
			throw new RuntimeException("错误信息： " + e);
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
