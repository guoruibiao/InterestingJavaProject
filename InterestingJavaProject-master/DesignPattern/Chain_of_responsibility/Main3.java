package ResponsibilityChain;

public class Main3 {

	public static void main(String[] args) {
		// 待处理的用户的输入数据
		String message = "<script>while(1){alert('HaHa,敏感词，替换词')</script>";

		MyProcessor3 myProcessor3 = new MyProcessor3();
		myProcessor3.setMsg(message);

		FilterChain filterChain = new FilterChain();
		// filterChain.addFilter(new HTMLFilter());
		// filterChain.addFilter(new SesitiveFilter());
		// filterChain.addFilter(new ReplacableFilter());

		myProcessor3.setFilterChain(filterChain);
		// 作为一个链的方式进行添加过滤器，这就是链式编程的好处
		filterChain.addFilter(new HTMLFilter()).addFilter(new SesitiveFilter()).addFilter(new ReplacableFilter());
		String result = filterChain.doFilte(message);	
		System.out.println("未被处理的数据为：" + message);
		System.out.println("经过处理的数据为：" + result);
	}

}
