package ideaslist;

/**
 * ���ڣ� 2016��5��2��22:00:06
 * 
 * ��������������Ĺ�����ʵ�ֽ�һ��������ַ�����ת���
 * 
 * �㷨������ʹ���˷��ε�˼�룬������β��ͷ�ķ�ʽ��Ϊѭ������ֹ������ ����������������½��ײ��ַ���β���ַ����н�����
 * 
 * ע�⣺��Ҫά����βָ���Ǩ�ƣ���������ʵ�������ַ����ķ�ת����
 * 
 * @author Administrator
 *
 */
public class ReverseStrings {

	/**
	 * ��ת������ַ����ķ���
	 * 
	 * ʹ��������ķ�ʽ����β����
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
			throw new RuntimeException("�������г��ֵĴ���Ϊ��" + e);
		}

		String result = new String(gotTheBytes, 0, gotTheBytes.length);

		return result;
	}

	/**
	 * ����һ��
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "IAMGUORUIBIAO";
		String result = reverseStrings(str);
		System.out.println(result);
	}

}
