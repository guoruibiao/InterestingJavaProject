package ResponsibilityChain;

public final class SesitiveFilter implements Filter {

	@Override
	public String doFilte(String message) {

		// ������˵Ӧ���Ǹ��ʿ�ģ��Դʿ��е����ݽ���ƥ�䣬�����ȽϺ���һЩ���˴�Ϊ�����κ���˼�룬�ͼ����������
		String str = message.replaceAll("���д�", "��������");
		return str;
	}

}
