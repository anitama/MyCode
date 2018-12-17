package qa.testcases;

import java.util.ArrayList;

import org.testng.TestNG;

public class TestRunner {

	public static void main(String[] args)
	{
		
		TestNG ng= new TestNG();
		ArrayList<String>al=new ArrayList<String>();
		al.add("C://Users//anita.mahra//Desktop//BDD//Test//test-output//SanitySuite//testng-failed.xml");
		ng.setTestSuites(al);
		ng.run();
		
	}

}
