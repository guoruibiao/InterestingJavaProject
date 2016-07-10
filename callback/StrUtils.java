package callback;

public class StrUtils {

	/**
	 * 模拟QueryRunner实现的StrUtils，大管家
	 * 
	 * @param origin
	 * @param handler
	 * @return
	 */
	public static Object query(String origin, ResultSetHandler handler) {
		return handler.handler(origin);
	}

}
