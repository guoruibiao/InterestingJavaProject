package facetest;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 随机读取文件的一个比较好用的类
 * 
 * 核心在于： 可以想象成一个很大的文件数组，代表着整个文件，所以可以随机的访问到文件的任何的一个位置
 * 
 * @author Administrator
 *
 */
public class RandomAccessFileDemo {

	public static void main(String[] args) {

		RandomAccessFile raf = null;
		// 这个文件只是一个随便设置的文件，可以自己随意的指定
		String filepath = "F:\\pachong\\dlutdlut.html";

		try {
			raf = new RandomAccessFile(new File(filepath), "rw");
			System.out.println("文件的总长度是： " + raf.length());
			raf.seek(1000);
			System.out.println("文件在长度为1000开始的位置的一行数据为： " + raf.readLine());
			long filePointer = raf.getFilePointer();
			System.out.println("当前文件的指针位于： " + filePointer);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (raf != null) {
				try {
					raf.close();
					raf = null;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}
