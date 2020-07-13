package tests;

import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class TestNGConcepts {
	
	// we creat two method and we depend sign in to our second test it mean if 
	// sign in succesful execute the second test case. if sign in failed it will skip the seond test case.
	// the below test case will fialed and we can run the failed test case from testNG- fialed.xmal whihc is under test output folder
	@Test
	
	public void signIn() {
		String a = "school";
		String b = "coleage";
		Assert.assertEquals(a,b);
	}
	// Test HomePage depends on successful execution of SignIn test. 
	@Test (dependsOnMethods = {"signIn"})
	public void homePage() {
		System.out.println("This test is depended on Sign In test cases");
	}
	
	// to just run this test case we ignore the rest test cases
	// if we want to run a test case 10 time or any number of time we want we use the below syntax
	@Test (invocationCount = 10)
	@Ignore
	public void checkTitle() {
		System.out.println("this test case will run 10 times");
	}
	// if we want to run a gruoup of test case like just the smoke test we group all those test case 
	//which is belong to smoke test and we can just run that particular group.
	//and we creat the group tag, run and include tag in test NG.XMAL and in include tag we mention the group name.
	

	@Test(groups = {"smokeTest"} )
	public void logout() {
		System.out.println("log out test");
	}
	@Test(groups = {"smokeTest"} )
	public void dashboard() {
		System.out.println("dashboard test");
	}
	@Test(groups = {"smokeTest"})

	public void customerPage() {
		System.out.println("customer page test");
	}
	










}
