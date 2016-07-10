package callback;

public class Test {

	public static void main(String[] args) {
		String testStr = "aBcDEfghIjKLMnoPQrStuVwXyZ";
		String result = (String) StrUtils.query(testStr, new HeadHandler());
		System.out.println("Origin Str: " + testStr);
		System.out.println("Result Str: " + result);
		System.out.println("---------------------------------");
		result = (String) StrUtils.query(testStr, new TailHandler());
		System.out.println("Origin Str: " + testStr);
		System.out.println("Result Str: " + result);
		System.out.println("---------------------------------");
		result = (String) StrUtils.query(testStr, new UpperCaseHandler());
		System.out.println("Origin Str: " + testStr);
		System.out.println("Result Str: " + result);
		System.out.println("---------------------------------");
		result = (String) StrUtils.query(testStr, new DownCaseHandler());
		System.out.println("Origin Str: " + testStr);
		System.out.println("Result Str: " + result);
	}

}
