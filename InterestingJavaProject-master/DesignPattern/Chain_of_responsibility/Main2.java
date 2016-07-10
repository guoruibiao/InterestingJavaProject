package ResponsibilityChain;

public class Main2 {

	public static void main(String[] args) {
		// 待处理的用户的输入数据
		String message = "<script>while(1){alert('HaHa,敏感词，替换词')</script>";

		MyProcessor2 myProcessor2 = new MyProcessor2();
		myProcessor2.setMsg(message);
		String result = myProcessor2.process();

		System.out.println("未被处理的数据为：" + message);
		System.out.println("经过处理的数据为：" + result);
	}

}
