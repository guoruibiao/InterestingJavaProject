package facetest;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * �����ȡ�ļ���һ���ȽϺ��õ���
 * 
 * �������ڣ� ���������һ���ܴ���ļ����飬�����������ļ������Կ�������ķ��ʵ��ļ����κε�һ��λ��
 * 
 * @author Administrator
 *
 */
public class RandomAccessFileDemo {

	public static void main(String[] args) {

		RandomAccessFile raf = null;
		// ����ļ�ֻ��һ��������õ��ļ��������Լ������ָ��
		String filepath = "F:\\pachong\\dlutdlut.html";

		try {
			raf = new RandomAccessFile(new File(filepath), "rw");
			System.out.println("�ļ����ܳ����ǣ� " + raf.length());
			raf.seek(1000);
			System.out.println("�ļ��ڳ���Ϊ1000��ʼ��λ�õ�һ������Ϊ�� " + raf.readLine());
			long filePointer = raf.getFilePointer();
			System.out.println("��ǰ�ļ���ָ��λ�ڣ� " + filePointer);

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
