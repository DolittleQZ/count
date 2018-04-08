import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

import org.junit.Before;
import org.junit.Test;

public class countWordTest {

	String [] strArray = new String [20];
	String pattern = "wcPro.exe .+(\\.)txt";
	
	 
	@Before
	public void setUp() throws Exception {
	}

	/***************************************
	**countWord测试
	****************************************/
	
	
	@Test
	public void test() {
		//fail("Not yet implemented");
		strArray[0] = "wcPro.exe";
		strArray[1]="source.txt";
		String com = strArray[0] + " " + strArray[1];
		boolean isMatch = Pattern.matches(pattern, com);
		assertEquals(true,isMatch);
	}
	
	
	@Test
	public void test1() {
		//fail("Not yet implemented");
		strArray[0] = "";
		strArray[1]="";
		String com = strArray[0] + " " + strArray[1];
		boolean isMatch = Pattern.matches(pattern, com);
		assertEquals(false,isMatch);
	}
	
	
	@Test
	public void test2() {
		//fail("Not yet implemented");
		strArray[0] = "wcPro.exe";
		strArray[1]="";
		String com = strArray[0] + " " + strArray[1];
		boolean isMatch = Pattern.matches(pattern, com);
		assertEquals(false,isMatch);
	}
	
	
	@Test
	public void test3() {
		//fail("Not yet implemented");
		strArray[0] = "";
		strArray[1]="source.txt";
		String com = strArray[0] + " " + strArray[1];
		boolean isMatch = Pattern.matches(pattern, com);
		assertEquals(false,isMatch);
	}
	
	
	@Test
	public void test4() {
		//fail("Not yet implemented");
		strArray[0] = "wcPro.exe";
		strArray[1]="source.txt";
		strArray[2]="source.txt";
		String com = strArray[0] + " " + strArray[1] + " " + strArray[2];
		boolean isMatch = Pattern.matches(pattern, com);
		assertEquals(true,isMatch);
	}
	
	
	@Test
	public void test5() {
		//fail("Not yet implemented");
		strArray[0] = "wcPro.exe";
		strArray[1]="source.c";
		String com = strArray[0] + " " + strArray[1];
		boolean isMatch = Pattern.matches(pattern, com);
		assertEquals(false,isMatch);
	}
	
	
	@Test(timeout = 10)
	public void test6() {
		//fail("Not yet implemented");
		strArray[0] = "wcPro.exe";
		strArray[1]="source.txt";
		String com = strArray[0] + " " + strArray[1];
		boolean isMatch = Pattern.matches(pattern, com);
		assertEquals(true,isMatch);
	}
	
	
	@Test
	public void test7() {
		//fail("Not yet implemented");
		strArray[0] = "wcPro.exe";
		strArray[1]="source.txt";
		String com = strArray[0] + " " + strArray[1];
		assertEquals("wcPro.exe source.txt",com);
	}

	/***************************************
	**word测试
	****************************************/
	
	
	@Test
	public void test8() {
		word wd = new word("word");
		assertEquals(1,wd.num);
	}
	
	
	@Test
	public void test9() {
		word wd = new word("word");
		assertEquals("word",wd.word);
	}
	
	
	@Test
	public void test10() {
		word wd = new word("word");
		wd.add();
		System.out.println("num is "+wd.num);
		assertEquals(2,wd.num);
	}
	
	
	@Test(timeout = 1)
	public void test11() {
		word wd = new word("WORD");
		wd.change();
		assertEquals("word",wd.word);
	}
	
	/***************************************
	**readFileByLines测试
	****************************************/
	
	
	@Test
	public void test12() {
		String filename = "sources.txt";
		readFileByLines rfbl = new readFileByLines(filename);
		assertEquals("sources.txt",rfbl.fileName);
	}
	
	
	//不存在的文件名
	@Test
	public void test13() {
		String filename = "sources.txt";
		ArrayList<String>  lineArray = new ArrayList<String> ();
		readFileByLines rfbl = new readFileByLines(filename);
		lineArray = rfbl.fileString();
		System.out.println(lineArray.size());
		assertEquals(0,lineArray.size());
	}
	
	
	//文件测试
	@Test
	public void test14() {
		String filename = "source.txt";
		ArrayList<String>  lineArray = new ArrayList<String> ();
		readFileByLines rfbl = new readFileByLines(filename);
		lineArray = rfbl.fileString();
		System.out.println(lineArray.size());
		assertEquals(8,lineArray.size());
	}
	
	
	//空文件测试
	@Test 
	public void test15() {
		String filename = "abc.txt";
		ArrayList<String>  lineArray = new ArrayList<String> ();
		readFileByLines rfbl = new readFileByLines(filename);
		lineArray = rfbl.fileString();
		System.out.println(lineArray.size());
		assertEquals(0,lineArray.size());
	}
	
	
	/***************************************
	**count测试
	****************************************/
	
	
	@Test 
	public void test16() {
		String filename = "source.txt";
		count _count = new count(filename);
		assertEquals("source.txt",_count.getFile());
	}
	
	
	@Test 
	public void test17() {
		String filename = "source.txt";
		count tar = new count(filename);
		tar.countWord();
		for(int i =0; i!= tar.getWordArray().size(); ++i)
			System.out.println(tar.getWordArray().get(i).word+" "+tar.getWordArray().get(i).num);
		assertEquals(13,tar.getWordArray().size());
	}
	
	@Test 
	public void test18() {
		String filename = "source1.txt";
		count tar = new count(filename);
		tar.countWord();
		for(int i =0; i!= tar.getWordArray().size(); ++i)
			System.out.println(tar.getWordArray().get(i).word+" "+tar.getWordArray().get(i).num);
		assertEquals(13,tar.getWordArray().size());
	}
	
	@Test 
	public void test19() {
		String filename = "abc.txt";
		count tar = new count(filename);
		tar.countWord();
		for(int i =0; i!= tar.getWordArray().size(); ++i)
			System.out.println(tar.getWordArray().get(i).word+" "+tar.getWordArray().get(i).num);
		assertEquals(0,tar.getWordArray().size());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
