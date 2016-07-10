package ideaslist;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * ���ڣ�2016��5��4��13:53:31
 * 
 * ������ͳ���ַ����е��ʵ���Ŀ�������ӵĻ���һ���ı��ж����ַ��������ɵ�����Ŀͳ�ƽ��
 * 
 * 
 * @author Administrator
 *
 */
public class WordCounts {

	/**
	 * �Ե�����һ���ı����е�����Ŀ�ļ���
	 * 
	 * ԭ����ʹ��������ʽ����ƥ��
	 * 
	 * Bug��������Щ����²�����ȷ��ƨƥ�����е��ı��е�����
	 * 
	 * @param target
	 * @return
	 */
	public static int countWords(String target) {

		try {
			int numbers = 0;
			String[] temp = target.split("\\ +|,+|^\\.");
			for (int i = 0; i < temp.length; i++) {
				if (!temp[i].equals(" ") && temp[i] != null) {
					numbers++;
				}
			}
			return numbers;
		} catch (Exception e) {
			throw new RuntimeException("����ԭ�� �� " + e);
		}
	}

	/**
	 * ��һ���ı��ļ��ڵ����ݽ��е��ʸ�����ƥ��
	 * 
	 * �ڲ�ʵ�ֵ��Ƕ��ļ����������е���ʽ���ж�ȡ��Ȼ��ֱ�����ÿһ�е������еĵ��ʵ����������ʵ���ۼ�
	 * 
	 * Bug�� ���е�ʱ����Զ��ĶԵ�������һ��Ȼ���Ⲣ���Ƿ���Ҫ��Ľ����
	 * 
	 * @param filePath
	 * @param fileName
	 * @return
	 */
	public static int countWords(String filePath, String fileName) {

		try {
			//���ļ���������·������ƴ��
			File file = new File(filePath+File.separator+fileName);
			if (!file.exists())
				throw new RuntimeException("�ļ������ڣ�");

			InputStreamReader fis = new InputStreamReader(new FileInputStream(file));
			BufferedReader reader = new BufferedReader(fis);
			int countNumbers = 0;
			String lengthStr = "";
			while ((lengthStr = reader.readLine()) != null) {
				countNumbers += countWords(lengthStr);
			}
			return countNumbers;

		} catch (Exception e) {
			throw new RuntimeException("����ԭ�� �� " + e);
		}
	}

	/**
	 * �ֱ���ַ������ı��ļ����в���
	 * 
	 * �ı��ļ����˷��õ���һ���̶����ļ������ˣ����߿��԰����Լ���������и���
	 * @param args
	 */
	public static void main(String[] args) {

		String testStr = "I am Guo,   gg. Rui   sd de Biao    we!".trim();
		int wordNumbers = countWords(testStr);

		System.out.println("������ַ����е��ʵĸ���Ϊ�� " + wordNumbers);

		System.out.println("�������ļ��ж�ȡ�����ݽ���� ");
		int numbers = countWords("E:\\Code\\Java\\Test4Android\\src", "test.txt");
		System.out.println(numbers);

	}

}
