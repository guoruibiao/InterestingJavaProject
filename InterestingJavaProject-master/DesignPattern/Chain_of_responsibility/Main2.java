package ResponsibilityChain;

public class Main2 {

	public static void main(String[] args) {
		// ��������û�����������
		String message = "<script>while(1){alert('HaHa,���дʣ��滻��')</script>";

		MyProcessor2 myProcessor2 = new MyProcessor2();
		myProcessor2.setMsg(message);
		String result = myProcessor2.process();

		System.out.println("δ�����������Ϊ��" + message);
		System.out.println("�������������Ϊ��" + result);
	}

}
