package ResponsibilityChain;

public class MyProcessor {

	private String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String process() {
		// 调用相关的过滤器进行词汇的过滤
		HTMLFilter htmlFilter = new HTMLFilter();
		String result = htmlFilter.doFilte(msg);

		// 调用敏感词过滤器
		SesitiveFilter sesitiveFilter = new SesitiveFilter();
		result = sesitiveFilter.doFilte(result);
		
		ReplacableFilter replacableFilter = new ReplacableFilter();
		result = replacableFilter.doFilte(result);
		
		return result;
	}

}
