package ideaslist;

/**
 * 日期：2016年5月3日22:21:04
 * 
 * 描述：判断用户输入的字符串是否为回文。回文是指正反拼写形式都是一样的词，譬如“racecar”
 * 
 * @author Administrator
 *
 */
public class Palindrome {

	/**
	 * 通过对输入的字符串转换成字节数组进行判断，需要注意的是对于两个指针的位置的维护
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
			throw new RuntimeException("错误出自： " + e );
		}
		
	}
	
	
	
	/**
	 * 简单的进行测试一下
	 * @param args
	 */
	public static void main(String[] args) {
		String testStr = "abcdedcba";
		boolean flag = isPalindrome(testStr);
		System.out.println("是回文吗？ " + flag);
	}

}
