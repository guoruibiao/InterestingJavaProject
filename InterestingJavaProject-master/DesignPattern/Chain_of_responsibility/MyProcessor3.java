package ResponsibilityChain;

public class MyProcessor3 {

	private FilterChain filterChain;

	public FilterChain getFilterChain() {
		return filterChain;
	}

	public void setFilterChain(FilterChain filterChain) {
		this.filterChain = filterChain;
	}

	private String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String process() {
		String result = msg;

		result = filterChain.doFilte(result);

		return result;
	}

}
