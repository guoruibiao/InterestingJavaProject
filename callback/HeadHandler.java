package callback;

public class HeadHandler implements ResultSetHandler {

	/**
	 * ��ȡ�ַ�����ǰ�����ַ�
	 */
	@Override
	public Object handler(String str) {
		return str.substring(str.length() - str.length() + 1, str.length() - str.length() + 3);
	}

}
