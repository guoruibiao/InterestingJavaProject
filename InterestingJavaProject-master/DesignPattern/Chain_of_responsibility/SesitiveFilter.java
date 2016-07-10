package ResponsibilityChain;

public final class SesitiveFilter implements Filter {

	@Override
	public String doFilte(String message) {

		// 正常来说应该是个词库的，对词库中的数据进行匹配，这样比较合理一些，此处为了掩饰核心思想，就简化了这个操作
		String str = message.replaceAll("敏感词", "不敏感了");
		return str;
	}

}
