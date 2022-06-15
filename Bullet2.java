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
    int touchytouchycounter=0;
    public void act()
    {
        move(deltaX);
        if(Bullet2.class!=null &&touchingcond() == true)
        {
            FrameCount++;
            touchytouchycounter++;
            if (Bullet2.class!=null&&touchytouchy==0&&isTouching(Wall.class)||isTouching(PlayerOne.class))
            {
                explode();
                touchytouchy=1;
            }
            if(FrameCount > 5)
            {
                getWorld().removeObject(this);
                FrameCount = 0;
                touchytouchy=0;
            }   
        }

         if(touchytouchycounter > 30)
        {  
            touchytouchycounter = 0;
        } 

    }
    
    public void explode()
    {   if (Bullet2.class!=null&&touchytouchy==0)
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

