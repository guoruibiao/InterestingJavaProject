package callback;

public class TailHandler implements ResultSetHandler {

	/**
	 * ��ȡ�ַ����ĺ������ַ�
	 */
	@Override
	public Object handler(String str) {
		return str.subSequence(str.length() - 3, str.length());
	}

}
