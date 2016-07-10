package ideaslist;

/**
 * 日期： 2016年5月2日22:00:06
 * 
 * 描述：这个案例的功能是实现将一个输入的字符串反转输出
 * 
 * 算法：本例使用了分治的思想，采用首尾碰头的方式作为循环的终止条件， 在满足条件的情况下将首部字符与尾部字符进行交换。
 * 
 * 注意：需要维护首尾指针的迁移，这样才能实现整个字符串的反转交换
 * 
 * @author Administrator
 *
 */
public class ReverseStrings {

	/**
	 * 反转输入的字符串的方法
	 * 
	 * 使用了数组的方式，首尾交换
	 * 
	 * @param target
	 * @return
	 */
	public static String reverseStrings(final String target) {

		byte[] gotTheBytes;
		try {
			gotTheBytes = target.getBytes();
			int front = 0;
			int tail = gotTheBytes.length - 1;
			while (front < tail) {
				byte temp = gotTheBytes[front];
				gotTheBytes[front] = gotTheBytes[tail];
				gotTheBytes[tail] = temp;

				front++;
				tail--;
			}
		} catch (Exception e) {
			throw new RuntimeException("程序运行出现的错误为：" + e);
		}

		String result = new String(gotTheBytes, 0, gotTheBytes.length);

		return result;
	}

	/**
	 * 测试一下
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "IAMGUORUIBIAO";
		String result = reverseStrings(str);
		System.out.println(result);
	}

}
