package ideaslist;

import javax.swing.text.ChangedCharSetException;

/**
 * ���ڣ�2016��5��2��23:18:33
 * 
 * ����������һ��Ӣ��������Ϸ�����������ǽ�һ��Ӣ�ﵥ�ʵĵ�һ���������ص���ĸ�ƶ�����β���Ҽ��Ϻ�׺-ay
 * ��Ʃ�硰banana�����ɡ�anana-bay������������ά���ٿ����˽�������ݡ�
 * 
 * �㷨������ܼ��ˣ��Ͳ���˵��
 * 
 * @author Administrator
 *
 */
public class LatinaPig {

	/**
	 * ����StringBuilder�������Ҫ������
	 * 
	 * String���һЩ���õ�API�Ǻ����õģ�ʹ�����Ƕ����ַ����Ķ�������ӵķ���
	 * 
	 * @param target
	 * @return
	 */
	public static String change(String target) {

		try {

			StringBuilder sb = new StringBuilder();
			char temp = target.charAt(0);
			sb.append(target.substring(1));
			sb.append(temp);
			sb.append("-bay");

			String result = new String(sb);

			return result;
		} catch (Exception e) {
			throw new RuntimeException("������ԣ� " + e);
		}

	}

	public static void main(String[] args) {
		String testStr = "banana";
		String result = change(testStr);
		System.out.println(result);
	}

}
