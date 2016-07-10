package ResponsibilityChain;

import java.util.ArrayList;
import java.util.List;

public class FilterChain implements Filter{

	private List<Filter> filters = new ArrayList<Filter>();

	/**
	 * return itself for better usage the Chain
	 * 
	 * @param f
	 * @return
	 */
	public FilterChain addFilter(Filter f) {
		filters.add(f);
		return this;
	}

	public void remove(Filter f) {
		filters.remove(f);
	}

	/**
	 * For the chain , it's also a chain for filter
	 * 
	 * @param message
	 *            message need to be filtered
	 * @return
	 */
	public String doFilte(String message) {
		String result = message;
		for (Filter f : filters) {
			result = f.doFilte(result);
		}
		return result;
	}

}
