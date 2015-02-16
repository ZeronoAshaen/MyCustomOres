package co.zerono.pc.proxy;

public class ServerProxy extends CommonProxy
{
	@Override
	public ClientProxy getClientProxy()
	{
		return null;
	}
	
	
	@Override
	public void initRenderingAndTextures() 
	{
		// NOOP
	}
	
	@Override
	public void registerKeybindings()
	{
		// NOOP
	}

	@Override
    public void playSound(String soundName, float xCoord, float yCoord, float zCoord, float volume, float pitch)
    {
		// NOOP
    }
}

