package convertion;

public class Test {

	public static void main(String[] args) {
		Parent parent = new Parent();
		parent.say();

		Parent son = new Son();
		son.say();

		Parent dauther = new Dauther();
		dauther.say();

		System.out.println("--------------------------------");

		Son lowcase = (Son) new Parent();

		((Parent) lowcase).say();
		System.out.println("��������Կ����������������ת�ͺ����ף���Ϊ���Ƕ�̬�Ļ�����������ת��û�б���ʱ�쳣��ȴ������ʱ�쳣���ʲ��Ƽ�ʹ�ã�");
	}
}
