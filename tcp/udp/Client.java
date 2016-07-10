package tcp.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {

	public static void main(String[] args) {
		try {
			//创建一个“发射器”，相当于快递员，将我们的“DatagramPacket”发和收
			DatagramSocket socket = new DatagramSocket();
			int counter = 0;
			while (counter<=10) {
				counter ++;
				//一个字节数组，作为传输过程中的容器，将数据一个字节一个字节的发和收
				byte[] buf = "Hello Server ! I am Client!".getBytes();
				//我们的包裹，包含目的地和端口还有我们的数据
				DatagramPacket sendPacket = new DatagramPacket(buf, buf.length, InetAddress.getByName("192.168.59.210"),
						10000);
				//让快递员发出我们的包裹，剩下的事情，就交给底层来实现了
				socket.send(sendPacket);
				//创建一个我们将要接收的包裹
				DatagramPacket receivePacket = new DatagramPacket(buf, buf.length);
				//从快递员那里收到一个包裹。这个方法会阻塞哦。（也就是说，在特定的时间内没有收到包裹，我们会一直等下去。过期的话，才会离开，即不阻塞）
				socket.receive(receivePacket);
				//将接收到的字节转换成字符串，方便打印到控制台上
				String recvStr = new String(receivePacket.getData(), 0, receivePacket.getLength());
				//打印出接收到的数据信息
				System.out.println("服务器端传来的消息是： " + recvStr);
			}
			//关闭套接字，快递员下班咯
			socket.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
