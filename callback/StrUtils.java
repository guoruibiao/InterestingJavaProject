package callback;

public class StrUtils {

	/**
	 * ģ��QueryRunnerʵ�ֵ�StrUtils����ܼ�
	 * 
	 * @param origin
	 * @param handler
	 * @return
	 */
	public static Object query(String origin, ResultSetHandler handler) {
		return handler.handler(origin);
	}

}
