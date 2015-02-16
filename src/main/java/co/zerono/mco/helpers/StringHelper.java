package co.zerono.pc.helpers;

public class StringHelper 
{
	public String capitalizeFirstChar(String string)
	{
		return Character.toUpperCase(string.charAt(0)) + string.substring(1);
	}
}
