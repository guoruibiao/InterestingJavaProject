package callback;

public class DownCaseHandler implements ResultSetHandler {

	/**
	 * 将字符串转换为小写方式来输出
	 */
	@Override
	public Object handler(String str) {
		return str.toLowerCase();
	}

}
