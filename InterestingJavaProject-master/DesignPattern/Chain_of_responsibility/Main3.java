package ResponsibilityChain;

public class Main3 {

	public static void main(String[] args) {
		// ��������û�����������
		String message = "<script>while(1){alert('HaHa,���дʣ��滻��')</script>";

		MyProcessor3 myProcessor3 = new MyProcessor3();
		myProcessor3.setMsg(message);

		FilterChain filterChain = new FilterChain();
		// filterChain.addFilter(new HTMLFilter());
		// filterChain.addFilter(new SesitiveFilter());
		// filterChain.addFilter(new ReplacableFilter());

		myProcessor3.setFilterChain(filterChain);
		// ��Ϊһ�����ķ�ʽ������ӹ��������������ʽ��̵ĺô�
		filterChain.addFilter(new HTMLFilter()).addFilter(new SesitiveFilter()).addFilter(new ReplacableFilter());
		String result = filterChain.doFilte(message);	
		System.out.println("δ�����������Ϊ��" + message);
		System.out.println("�������������Ϊ��" + result);
	}

}
