package ideaslist;

/**
 * ���ڣ�2016��5��3��22:21:04
 * 
 * �������ж��û�������ַ����Ƿ�Ϊ���ġ�������ָ����ƴд��ʽ����һ���Ĵʣ�Ʃ�硰racecar��
 * 
 * @author Administrator
 *
 */
public class Palindrome {

	/**
	 * ͨ����������ַ���ת�����ֽ���������жϣ���Ҫע����Ƕ�������ָ���λ�õ�ά��
	 * 
	 * @param target
	 * @return
	 */
	public static boolean isPalindrome(String target) {
			
		try {
			byte[] temp = target.getBytes();
			int front= 0, tail = temp.length-1;
		
			while(front<=tail) {
				if(temp[front] != temp[tail]) return false;
				front++;
				tail--;
			}
			return true;
		} catch (Exception e) {
			throw new RuntimeException("������ԣ� " + e );
		}
		
	}
	
	
	
	/**
	 * �򵥵Ľ��в���һ��
	 * @param args
	 */
	public static void main(String[] args) {
		String testStr = "abcdedcba";
		boolean flag = isPalindrome(testStr);
		System.out.println("�ǻ����� " + flag);
	}

}
