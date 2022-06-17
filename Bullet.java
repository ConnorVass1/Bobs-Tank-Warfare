import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Actor
{
    int deltaX;
    int deltaY;
    int FrameCount;
    int touchytouchy=0;
    int touchytouchycounter=0;
    public void act()
    {
        //if a bullet touches a player, it sets the explosion effect, and removes the bullet.
        move(deltaX);
        if(Bullet.class!=null &&touchingcond() == true)
        {
            FrameCount++;

            touchytouchycounter++;
            if (Bullet.class!=null&touchytouchy==0&&touchingcond() == true)



            if (touchytouchy==0&&Bullet.class!=null&&isTouching(Wall.class)||isTouching(Players.class))

            {
                explode();
                touchytouchy=1;
            }

            if(FrameCount > 5)

            {
                getWorld().removeObject(this);  
                FrameCount = 0;
                
            }   
        }

        if(touchytouchycounter > 30)
        {  
            touchytouchycounter = 0;
        } 
        
        
    }
    
    public void explode()
    {
        //adds explosion effect.
        if (Bullet.class!=null&&touchytouchy==0&&isTouching(Wall.class)||isTouching(PlayerTwo.class))
        {
            getWorld().addObject(new Explosion(), getX(), getY());
        }  
    }
    
    public boolean touchingcond()
    {
        //checks if bullet is in contact with player.
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

