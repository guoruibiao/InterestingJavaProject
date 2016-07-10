package ideaslist;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * 日期：2016年5月4日13:53:31
 * 
 * 描述：统计字符串中单词的数目，更复杂的话从一个文本中读出字符串并生成单词数目统计结果
 * 
 * 
 * @author Administrator
 *
 */
public class WordCounts {

	/**
	 * 对单独的一行文本进行单词书目的计算
	 * 
	 * 原理是使用正则表达式进行匹配
	 * 
	 * Bug：在于有些情况下不能正确的屁匹配所有的文本中的情形
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
			throw new RuntimeException("错误原因 ： " + e);
		}
	}

	/**
	 * 对一个文本文件内的数据进行单词个数的匹配
	 * 
	 * 内部实现的是对文件的数据以行的形式进行读取，然后分别计算出每一行的数据中的单词的数量，最后实现累加
	 * 
	 * Bug： 换行的时候会自动的对单词数加一，然而这并不是符合要求的结果。
	 * 
	 * @param filePath
	 * @param fileName
	 * @return
	 */
	public static int countWords(String filePath, String fileName) {

		try {
			//对文件的完整的路径进行拼接
			File file = new File(filePath+File.separator+fileName);
			if (!file.exists())
				throw new RuntimeException("文件不存在！");

			InputStreamReader fis = new InputStreamReader(new FileInputStream(file));
			BufferedReader reader = new BufferedReader(fis);
			int countNumbers = 0;
			String lengthStr = "";
			while ((lengthStr = reader.readLine()) != null) {
				countNumbers += countWords(lengthStr);
			}
			return countNumbers;

		} catch (Exception e) {
			throw new RuntimeException("错误原因 ： " + e);
		}
	}

	/**
	 * 分别对字符串和文本文件进行测试
	 * 
	 * 文本文件本人放置到了一个固定的文件夹下了，读者可以按照自己的情况进行更改
	 * @param args
	 */
	public static void main(String[] args) {

		String testStr = "I am Guo,   gg. Rui   sd de Biao    we!".trim();
		int wordNumbers = countWords(testStr);

		System.out.println("输入的字符串中单词的个数为： " + wordNumbers);

		System.out.println("下面是文件中读取的数据结果： ");
		int numbers = countWords("E:\\Code\\Java\\Test4Android\\src", "test.txt");
		System.out.println(numbers);

	}

}
