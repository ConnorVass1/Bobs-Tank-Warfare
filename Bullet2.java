import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet2 extends Actor
{
    int deltaX;
    int deltaY;
    int FrameCount;
    int touchytouchy=0;
    
    public void act()
    {
        move(deltaX);
        if(Bullet2.class!=null &&touchingcond() == true)
        {
            FrameCount++;
            if (touchytouchy==0&&Bullet.class!=null&&isTouching(Wall.class)||isTouching(Players.class))
            {
                getWorld().addObject(new Explosion(), getX(), getY());
            }
            if(FrameCount > 10)
            {
                getWorld().removeObject(this);
                FrameCount = 0;
                touchytouchy=0;
            }   
        }

        if (isTouching(Wall.class)||isTouching(Players.class))
        {
            getWorld().addObject(new Explosion(), getX(), getY());
        }

    }
    
    public boolean touchingcond()
    {
        if(isTouching(PlayerOne.class))
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
    
    
    public Bullet2(int nDeltaX, int nDeltaY)
    {
        deltaX= nDeltaX;
        deltaY= nDeltaY;
    }
    

}

