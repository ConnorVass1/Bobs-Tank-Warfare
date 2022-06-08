import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Actor
{
    int bulletspeedX = 5;
    MyWorld myworld = (MyWorld) getWorld();
    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here
        setLocation(getX() + bulletspeedX, getY());
        
        if(touchingcond() == true)
        {
            myworld.removeObject(this);
        }
    }
    
    public boolean touchingcond()
    {
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
        
        if(getY() < getWorld().getHeight())
        {
            return true;
        }
        
        else
        {
            return false;
        }
        
        
    }
}

