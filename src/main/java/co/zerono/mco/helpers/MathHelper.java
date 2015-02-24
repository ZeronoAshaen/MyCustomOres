package co.zerono.mco.helpers;

public class MathHelper 
{
	public static float[] intArrayToFloatArray(int[] intArray)
	{
		float[] floatArray;
		floatArray = new float[intArray.length];
		
		for(int i=0; i<intArray.length; i++)
		{
			floatArray[i] = (float) intArray[i];
		}
		return floatArray;
	}
	public static float[] doubleArrayToFloatArray(double[] doubleArray)
	{
		if(doubleArray == null) return null;
		float[] floatArray;
		floatArray = new float[doubleArray.length];
		for(int i=0; i<doubleArray.length; i++)
		{
			floatArray[i] = (float)doubleArray[i];
		}
		return floatArray;
	}
}
