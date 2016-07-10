package tcp.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server {

	public static void main(String[] args) throws Exception {

		//���Ա�ϰ��ˣ�����10000�˿ڵ���Ϊ���Ƿ���
		DatagramSocket socket = new DatagramSocket(10000);

		int counter = 0;
		while (counter<=10) {
			counter++;
			//����һ����������ֽ�����
			byte[] buf = new byte[1024];
			//����һ������һ�������İ���
			DatagramPacket recvPacket = new DatagramPacket(buf, buf.length);
			//�ӿ�ݹ�˾��Ҳ�������ǵ�����ĵײ㣩���յ����ǵİ���
			socket.receive(recvPacket);
			//�����յ�������ת�����ַ����������ӡ
			String recvStr = new String(recvPacket.getData(), 0, recvPacket.getLength());
			//��ӡ�����յ�������
			System.out.println("�յ������Կͻ��˵���Ϣ�ǣ� " + recvStr);
			//������������Ҫ���͵İ�������������ݡ�Ҫһ���ֽ�һ���ֽڵĵ��ã����������һ�������·�һ����
			buf = "Hello Client,I am your server!".getBytes();
			//����һ�£�׼��Ͷ�ݿ������ǿ��ԴӸղŵļļ��������ҵ����͵�Ŀ�ĵغ�Ŀ�Ķ˿ڣ�Ҳ��������Ҫ�ظ����˵�������סַ��
			DatagramPacket sendPacket = new DatagramPacket(buf, buf.length, recvPacket.getAddress(),
					recvPacket.getPort());
			//�ÿ��Ա������Ͷ�ݰ�����������
			socket.send(sendPacket);
		}
		//���Ա�°��ˣ��׽���Ҫ���йر�
		socket.close();
	}

}
