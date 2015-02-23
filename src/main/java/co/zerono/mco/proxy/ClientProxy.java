package co.zerono.mco.proxy;

public class ClientProxy extends CommonProxy
{
	@Override
	public void registerEventHandlers()
	{
		super.registerEventHandlers();
	}
	
	@Override
	public void registerKeybindings()
	{
		
	}
	
	@Override
    public void playSound(String soundName, float xCoord, float yCoord, float zCoord, float volume, float pitch)
    {
		
    }
	
	@Override
	public ClientProxy getClientProxy()
	{
		return this;
	}
	
	@Override
	public void initRenderingAndTextures()
	{
		
	}
}
