package list;

/**
 * 专门测试 SingleLinkedList的类
 * 
 * @author Administrator
 *
 */
public class Test {
	/**
	 * 测试用主方法
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SingleList singleList = new SingleList();
		singleList.add(49);
		singleList.add(38);
		singleList.add(65);
		singleList.add(97);
		singleList.add(76);
		singleList.add(13);
		singleList.add(27);
		singleList.add(49);
		singleList.printByRecursing(singleList.getSize(), singleList.head);
	}
}
