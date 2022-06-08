import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayerOne here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerOne extends Actor
{
    int HP;
    int speedX = 0;
    int speedY = 0;
    int damage;
    int FrameCount = 0;
    /**
     * Act - do whatever the PlayerOne wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        movement();
        combat();
    }
    
    
    public void movement()
    {
        speedX = 0;
        speedY = 0;
        if(Greenfoot.isKeyDown("a"))
        {
            speedX = -5;
            setRotation(270);
        }
        if(Greenfoot.isKeyDown("d"))
        {
            speedX = 5;
            setRotation(90);
        }
        if(Greenfoot.isKeyDown("s"))
        {
            speedY = 5;
            setRotation(180);
        }
        if(Greenfoot.isKeyDown("w"))
        {
            speedY = -5;
            setRotation(0);
        }
        
        setLocation(getX() + speedX, getY() + speedY);
    
    }
    
    public void combat()
    {
        FrameCount++;
        MyWorld myworld = (MyWorld) getWorld();
        if(Greenfoot.isKeyDown("Space") && FrameCount > 30)
        {
            myworld.addObject(new Bullet(), getX(), getY());
            FrameCount = 0;
        }
    
    }
    
}
