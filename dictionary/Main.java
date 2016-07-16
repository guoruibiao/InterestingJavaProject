package dictionary;

import java.util.Scanner;

/**
 * 要求从控制台输入英语单词及单词解释两项数据，<br>
 * 把录入的数据追加到文件中<br>
 * 。要求提供单词查询功能。 <br>
 * 用户输入单词后，从单词库文件中查找，<br>
 * 如果存在则输出 该单词的解释。<br>
 * 注意，单词不能有重复，如果重复则覆盖替换 以前的解释数据。<br>
 * 
 * @author 郭瑞彪
 *
 */
public class Main {

	/**
	 * 主程序入口
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// 显示好看的初始化界面
		showView();
		WordManager wordManager = new WordManager();
		Scanner scanner = new Scanner(System.in);
		int command = scanner.nextInt();
		if (command != 1 && command != 2 && command != 3) {
			System.out.println("请输入合法的数字后重试！");
			System.exit(0);
		}
		switch (command) {
		case 1:
			System.out.println("请输入您要查找的单词的名称:\n");
			String wordName = scanner.next();
			String wordValue = wordManager.findByName(wordName);
			System.out.println("您查找的单词的含义为：" + wordValue);

			break;

		case 2:
			System.out.println("请输入单词名称：");
			String newWordName = scanner.next();
			System.out.println("请输入单词释义：");
			String newWordValue = scanner.next();
			Word word = new Word();
			word.setName(newWordName);
			word.setValue(newWordValue);
			wordManager.storeToDatabase(word);
			System.out.println("单词已经成功存储到了database.properties文件中！");
			break;
		case 3:
			System.out.println("请输入要修改的单词的名称：");
			String modifyName = scanner.next();
			System.out.println("请输入单词释义：");
			String modifyValue = scanner.next();
			Word modifyWord = new Word();
			modifyWord.setName(modifyName);
			modifyWord.setValue(modifyValue);
			wordManager.storeToDatabase(modifyWord);
			System.out.println("单词已经成功修改并存储到了database.properties文件中！");
			break;
		}
	}

	public static void showView() {
		System.out.println("******************************命名行词典***************************");
		System.out.println("*                                                              *");
		System.out.println(
				"*          1.查找单词                                   2.存储单词                                           3.修改单词                             *");
		System.out.println("*                                                              *");
		System.out.println("***************************************************************");
	}

}
