package ResponsibilityChain;

public class MyProcessor2 {

	Filter[] filters = { new HTMLFilter(), new SesitiveFilter(), new ReplacableFilter() };

	private String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String process() {
		String result = msg;

		for (Filter f : filters) {
			result = f.doFilte(result);
		}

		return result;
	}

}
