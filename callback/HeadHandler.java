package callback;

public class HeadHandler implements ResultSetHandler {

	/**
	 * 截取字符串的前三个字符
	 */
	@Override
	public Object handler(String str) {
		return str.substring(str.length() - str.length() + 1, str.length() - str.length() + 3);
	}

}
