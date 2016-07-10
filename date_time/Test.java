package date_time;


public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(DateUtil.parseToDate("2016-4-22").toLocaleString());
		
		System.out.println(DateUtil.parseCurrentTimeMillions(System.currentTimeMillis()));
		
		System.out.println(DateUtil.parseCurrentTimeMillionsToChinese(System.currentTimeMillis()));
	}

}
