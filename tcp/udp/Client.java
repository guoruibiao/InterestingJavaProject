package tcp.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {

	public static void main(String[] args) {
		try {
			//����һ���������������൱�ڿ��Ա�������ǵġ�DatagramPacket��������
			DatagramSocket socket = new DatagramSocket();
			int counter = 0;
			while (counter<=10) {
				counter ++;
				//һ���ֽ����飬��Ϊ��������е�������������һ���ֽ�һ���ֽڵķ�����
				byte[] buf = "Hello Server ! I am Client!".getBytes();
				//���ǵİ���������Ŀ�ĵغͶ˿ڻ������ǵ�����
				DatagramPacket sendPacket = new DatagramPacket(buf, buf.length, InetAddress.getByName("192.168.59.210"),
						10000);
				//�ÿ��Ա�������ǵİ�����ʣ�µ����飬�ͽ����ײ���ʵ����
				socket.send(sendPacket);
				//����һ�����ǽ�Ҫ���յİ���
				DatagramPacket receivePacket = new DatagramPacket(buf, buf.length);
				//�ӿ��Ա�����յ�һ���������������������Ŷ����Ҳ����˵�����ض���ʱ����û���յ����������ǻ�һֱ����ȥ�����ڵĻ����Ż��뿪������������
				socket.receive(receivePacket);
				//�����յ����ֽ�ת�����ַ����������ӡ������̨��
				String recvStr = new String(receivePacket.getData(), 0, receivePacket.getLength());
				//��ӡ�����յ���������Ϣ
				System.out.println("�������˴�������Ϣ�ǣ� " + recvStr);
			}
			//�ر��׽��֣����Ա�°࿩
			socket.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
