package callback;

public class DownCaseHandler implements ResultSetHandler {

	/**
	 * ���ַ���ת��ΪСд��ʽ�����
	 */
	@Override
	public Object handler(String str) {
		return str.toLowerCase();
	}

}
