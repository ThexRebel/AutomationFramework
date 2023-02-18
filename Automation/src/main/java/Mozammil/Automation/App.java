package Mozammil.Automation;

import org.testng.annotations.Test;

/**
 * Hello world!
 *
 */
public class App 
{
	public static String name="saba";
    public static void main( String[] args )
    {
    	String path=System.getProperty("user.dir");
        System.out.println( path +" Hello World!" );
    }
    @Test
    public static void getName()
    {
    	String path=System.getProperty("user.dir");
        System.out.println( path +" Hello World!" );
    }
}
