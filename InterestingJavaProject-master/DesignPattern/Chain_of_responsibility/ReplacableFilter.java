package ResponsibilityChain;

public class ReplacableFilter implements Filter {

	@Override
	public String doFilte(String message) {
		// ������˵Ӧ���Ǹ��ʿ�ģ��Դʿ��е����ݽ���ƥ�䣬�����ȽϺ���һЩ���˴�Ϊ�����κ���˼�룬�ͼ����������
		String str = message.replaceAll("�滻��", "�ѱ��滻");
		return str;
	}

}
