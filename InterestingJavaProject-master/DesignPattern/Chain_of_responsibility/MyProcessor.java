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
		// ������صĹ��������дʻ�Ĺ���
		HTMLFilter htmlFilter = new HTMLFilter();
		String result = htmlFilter.doFilte(msg);

		// �������дʹ�����
		SesitiveFilter sesitiveFilter = new SesitiveFilter();
		result = sesitiveFilter.doFilte(result);
		
		ReplacableFilter replacableFilter = new ReplacableFilter();
		result = replacableFilter.doFilte(result);
		
		return result;
	}

}
