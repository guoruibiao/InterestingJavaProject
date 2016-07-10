package tcp.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server {

	public static void main(String[] args) throws Exception {

		//快递员上班了，他在10000端口等着为我们服务
		DatagramSocket socket = new DatagramSocket(10000);

		int counter = 0;
		while (counter<=10) {
			counter++;
			//创建一个带缓冲的字节数组
			byte[] buf = new byte[1024];
			//创建一个具有一定容量的包裹
			DatagramPacket recvPacket = new DatagramPacket(buf, buf.length);
			//从快递公司（也就是我们的网络的底层）接收到我们的包裹
			socket.receive(recvPacket);
			//将接收到的数据转换成字符串，方便打印
			String recvStr = new String(recvPacket.getData(), 0, recvPacket.getLength());
			//打印出接收到的数据
			System.out.println("收到的来自客户端的消息是： " + recvStr);
			//这里是我们想要发送的包裹的里面的内容。要一个字节一个字节的叠好（就像包裹内一个个的衣服一样）
			buf = "Hello Client,I am your server!".getBytes();
			//包裹一下，准备投递咯，我们可以从刚才的寄件人哪里找到发送的目的地和目的端口，也即是我们要回复的人的姓名和住址呗
			DatagramPacket sendPacket = new DatagramPacket(buf, buf.length, recvPacket.getAddress(),
					recvPacket.getPort());
			//让快递员帮我们投递包裹，发出包
			socket.send(sendPacket);
		}
		//快递员下班了，套接字要进行关闭
		socket.close();
	}

}
