package fr.fms.dao;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class CreateConfigFile 
{
	public static Properties readFile (String fileName) throws IOException
	{
		FileInputStream fis = null;
		Properties prop = null;
		try 
		{
			fis = new FileInputStream(fileName);
			prop = new Properties();
			prop.load(fis);
		} 
		catch (Exception e) 
		{
			e.fillInStackTrace();
		}
		finally 
		{
			fis.close();
		}
		return prop;
	}
}