package callback;

public class UpperCaseHandler implements ResultSetHandler {

	/**
	 * ���ַ���ת��Ϊ��д��ʽ�����
	 */
	@Override
	public Object handler(String str) {
		return str.toUpperCase();
	}

}
