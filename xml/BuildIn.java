/**
 * @Date 2016年7月19日
 *
 * @author Administrator
 */
package xml;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

/**
 * 
 * 使用JDK自带的ＸＭＬ解析来实现对XML的读写
 * 
 * @author 郭瑞彪
 *
 */
public class BuildIn {

	@Test
	public void read() throws Exception {
		File file = new File("src/xml/Student.xml");
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
		XMLDecoder decoder = new XMLDecoder(bis);
		Student s = (Student) decoder.readObject();
		System.out.println(s.toString());
		decoder.close();
	}

	@Test
	public void write() throws Exception {
		File file = new File("src/xml/Student.xml");
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
		XMLEncoder encoder = new XMLEncoder(bos);
		Student s = new Student();
		s.setAge(20);
		s.setName("GRB");
		encoder.writeObject(s);
		encoder.close();
	}

}
