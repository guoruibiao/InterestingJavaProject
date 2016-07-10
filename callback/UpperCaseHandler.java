package callback;

public class UpperCaseHandler implements ResultSetHandler {

	/**
	 * 将字符串转换为大写方式来输出
	 */
	@Override
	public Object handler(String str) {
		return str.toUpperCase();
	}

}
