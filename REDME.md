Hard Asserts vs Soft Asserts
==============================
 Hard Assertions	                                        Soft Assertions
=================                                         ===================  
1.Test Execution will be aborted if the       1.Test execution will continue till the end of the 
  assert condition is not met.	                test case even if the assert condition is not met.
                                          
2.Does not have to invoke any methods to      2.To view assertions result at the end of the
  capture the assertions.	                    test, the tester has to invoke assertAll()
                                                by invoking assertAll() method maven showing build
                                                failure and in result section you can see like this 
                                                message.
                                                "Failed tests:   items(driverTest.DriveTest): 
                                                The following asserts failed:(..)"
                                            
Hard Assertions
===============
Hard Assertions are ones in which test execution is aborted if the test does not meet the assertion 
condition. The test case is marked as failed. In case of an assertion error, it will throw the 
“java.lang.AssertionError” exception.
Let’s explore different types of hard assertions with examples.

assertEquals() is a method that takes a minimum of 2 arguments and compares actual results with 
expected results. If both match, the assertion is passed, and the test case is marked as passed. 
assertEquals() can compare Strings, Integers, Doubles, and many more variables, as shown in the 
image below.
Example:-
-------
1.Assert.assertEquals(ExpectedTitle, ActualTitle);
2.Assert.assertNotEquals(ActualTitle, ExpectedTitle);
3.Boolean verifyTitle = driver.getTitle().equalsIgnoreCase("Most Reliable App & Cross Browser Testing     Platform | BrowserStack");
assertTrue(verifyTitle);
4.Boolean verifyTitle = driver.getTitle().equalsIgnoreCase("Most Reliable App & Cross Browser Testing Platform");
assertFalse(verifyTitle);
5.String verifyAssertNull = null;
assertNull(verifyAssertNull);
6.Boolean verifyTitle = driver.getTitle().equalsIgnoreCase("Most Reliable App & Cross Browser Testing Platform");
assertNotNull(verifyTitle);

Soft Assertions
================
In a hard assertion, when the assertion fails, it terminates or aborts the test. If the tester does not want to terminate the script, they cannot use hard assertions. To overcome this, one can use soft assertions.
Example:-
-------
1.softAssert.assertEquals(getActualTitle, "Most Reliable App & Cross Browser Testing Platform | BrowserStack");
2.softAssert.assertNotEquals(getActualTitle, "Most Reliable App & Cross Browser Testing Platform | BrowserStack");
3.softAssert.assertNull(verifyTitle);
4.softAssert.assertNotNull(verifyTitle);
5.softAssert.assertTrue("BrowserStack".equals("Browserstack"), "First soft assert failed");
6.softAssert.assertFalse("BrowserStack".equals("BrowserStack"), "Second soft assert failed");
7.softAssert.assertAll(); //for getting fail or pass message last of test in result section

Closing Notes
=============
Hard and Soft Assertions are very important for designing and running Selenium Webdriver tests.
They are instrumental in verifying application behavior at critical stages.By using assertions, testing teams can determine if an application is working as expected.
They can also save teams the trouble of running tests that don’t need to be run if a condition is not met.

