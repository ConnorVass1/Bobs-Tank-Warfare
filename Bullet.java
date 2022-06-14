import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Actor
{
    int FrameCount;
    int deltaX;
    int deltaY;
    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        move(deltaX);
        if(Bullet.class!=null &&touchingcond() == true)
        {
            FrameCount++;
            if(FrameCount > 6)
            {
                getWorld().removeObject(this);
                FrameCount = 0;
            }
        }   
    }
    
    public boolean touchingcond()
    {
        if(isTouching(PlayerOne.class))
        {
            return true;
        }
        
        if(isTouching(PlayerTwo.class))
        {
            return true;
        }
        
        if(getX() > getWorld().getWidth()-getImage().getWidth())
        {
            return true;
        }
        
        if(getX() < getImage().getWidth())
        {
            return true;
        }
        
        if(getY() > getWorld().getHeight()-getImage().getHeight())
        {
            return true;
        }
        
        if(getY() < getImage().getHeight())
        {
            return true;
        }
        
        else
        {
            return false;
        }
        
    }
    
    
    public Bullet(int nDeltaX, int nDeltaY)
    {
        deltaX= nDeltaX;
        deltaY= nDeltaY;
    }
    

}

