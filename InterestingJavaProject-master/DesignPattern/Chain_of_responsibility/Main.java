package ResponsibilityChain;

public class Main {

	public static void main(String[] args) {
		// ��������û�����������
		String message = "<script>while(1){alert('HaHa,���дʣ��滻��')</script>";

		 MyProcessor myProcessor = new MyProcessor();
		 myProcessor.setMsg(message);
		 String result = myProcessor.process();

		System.out.println("δ�����������Ϊ��" + message);
		System.out.println("�������������Ϊ��" + result);
	}

}
