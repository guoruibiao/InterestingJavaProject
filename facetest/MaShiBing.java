package facetest;

public class MaShiBing {
	
	
	public static void main(String[] args) {
//		int count = 0;
//		count += ++count;
//		
//		System.out.println("The result is : "+count);
		
		try {
			System.out.println("Try statement first!");
			System.exit(0);
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			System.out.println("Finally first !");
		}
		
		
	}

}
