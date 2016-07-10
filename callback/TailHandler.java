package callback;

public class TailHandler implements ResultSetHandler {

	/**
	 * 截取字符串的后三个字符
	 */
	@Override
	public Object handler(String str) {
		return str.subSequence(str.length() - 3, str.length());
	}

}
