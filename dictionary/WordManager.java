package dictionary;

/**
 * 查询单词的管家，提供了查单词和存储单词的方法
 * 
 * @author 郭瑞彪
 *
 */
public class WordManager {

	/**
	 * 根据名称返回单词的释义
	 * 
	 * @param name
	 *            单词名称
	 * @return 对应的单词的释义
	 */
	public String findByName(String name) {
		String value = WordUtils.read(name);
		return value != null ? value : null;
	}

	/**
	 * 将给定的单词写入到硬盘上的文件中
	 * 
	 * @param word
	 *            根据用户输入而重组好的的单词
	 */
	public void storeToDatabase(Word word) {
		WordUtils.write(word);
	}

	/**
	 * 根据命令行传递过来的参数来封装成一个Bean。然后交给WordUtils来实现修改的操作
	 * 
	 * @param wordName
	 *            要进行修改的单词的名称
	 * @param wordValue
	 *            要进行修改的单词的新释义
	 */
	public void modify(String wordName, String wordValue) {
		Word word = new Word();
		word.setName(wordName);
		word.setValue(wordValue);
		WordUtils.modify(word);
	}

}
