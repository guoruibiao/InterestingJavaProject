package callback;

/**
 * 模拟实现的接口回调
 * 
 * @author Administrator
 *
 */
public interface ResultSetHandler {
	/**
	 * 用于分配给实现类的抽象方法
	 * 
	 * @param str
	 * @return
	 */
	public Object handler(String str);

}
