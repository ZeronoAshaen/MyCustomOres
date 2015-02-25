package co.zerono.mco.helpers;

public class StringHelper 
{
	private static String[] seperateOnComma(String string)
	{
		string = string.replaceAll("\\s+", "");
		string = string.trim();
		
		String[] stringArray = string.split(",", -1);
		return stringArray;
	}
}
