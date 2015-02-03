package co.zerono.pc.helpers;

public class MathHelper 
{
	public static Integer[] stringToInteger(String[] strings)
	{
		Integer[] intArray = new Integer[strings.length-1];
		int i=0;
		if(i<strings.length-1)
		{
			for (String str:strings)
			{
				intArray[i]=Integer.parseInt(str.trim());
			}
			i++;
		}
		return intArray;
	}
}
