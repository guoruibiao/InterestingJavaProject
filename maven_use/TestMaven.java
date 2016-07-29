/**
 * @Date 2016年7月16日
 *
 * @author Administrator
 */
package maven_use;

import com.grb.hello.hello_first.App;

/**
 * @author 郭瑞彪
 *
 */
public class TestMaven {
	
	public static void main(String[] args) {
		App app = new App();
		System.out.println(app.toString());
		app.sayHello("郭瑞彪");
	}

}
