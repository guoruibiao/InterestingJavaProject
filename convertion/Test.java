package convertion;

public class Test {

	public static void main(String[] args) {
		Parent parent = new Parent();
		parent.say();

		Parent son = new Son();
		son.say();

		Parent dauther = new Dauther();
		dauther.say();

		System.out.println("--------------------------------");

		Son lowcase = (Son) new Parent();

		((Parent) lowcase).say();
		System.out.println("从这里可以看出，面向对象向上转型很容易，因为这是多态的基础！而向下转型没有编译时异常，却有运行时异常。故不推荐使用！");
	}
}
