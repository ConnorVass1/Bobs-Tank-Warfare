import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayerTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerTwo extends Actor
{           
    int HP;
    int speedX;
    int speedY;
    int damage;
    int FrameCount;
    /**
     * Act - do whatever the PlayerTwo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        movement();
        bulletmovement();
    }
    
    public void movement()
    {
        speedX = 0;
        speedY = 0;
        if(Greenfoot.isKeyDown("Left"))
        {
            speedX = -5;
            setRotation(270);
        }
        if(Greenfoot.isKeyDown("Right"))
        {
            speedX = 5;
            setRotation(90);
        }
        if(Greenfoot.isKeyDown("Down"))
        {
            speedY = 5;
            setRotation(180);
        }
        if(Greenfoot.isKeyDown("Up"))
        {
            speedY = -5;
            setRotation(0);
        }
        
        if(Greenfoot.isKeyDown("Up") && Greenfoot.isKeyDown("Right"))
        {
            speedX = 3;
            speedY = -3;
            setRotation(45);
        }
        
        if(Greenfoot.isKeyDown("Up") && Greenfoot.isKeyDown("Left"))
        {
            speedX = -3;
            speedY = -3;
            setRotation(315);
        }
        
        if(Greenfoot.isKeyDown("Down") && Greenfoot.isKeyDown("Right"))
        {
            speedX = 3;
            speedY = 3;
            setRotation(135);
        }
        
        if(Greenfoot.isKeyDown("Down") && Greenfoot.isKeyDown("Left"))
        {
            speedX = -3;
            speedY = 3;
            setRotation(225);
        }
        
        setLocation(getX() + speedX, getY() + speedY);
    
    }
    
    public void bulletmovement()
    {
        FrameCount++;
        if(getRotation() == 0 && Greenfoot.isKeyDown("Shift") && FrameCount > 30)
        {
            getWorld().addObject(new Bullet(0, -5), getX(), getY() - 50);
            FrameCount = 0;
        }
        
        if(getRotation() == 90 && Greenfoot.isKeyDown("Shift") && FrameCount > 30)
        {
            getWorld().addObject(new Bullet(5, 0), getX() + 50, getY());
            FrameCount = 0;
        }
        
        if(getRotation() == 180 && Greenfoot.isKeyDown("Shift") && FrameCount > 30)
        {
            getWorld().addObject(new Bullet(0, 5), getX(), getY() + 50);
            FrameCount = 0;
        }
        
        if(getRotation() == 270 && Greenfoot.isKeyDown("Shift") && FrameCount > 30)
        {
            getWorld().addObject(new Bullet(-5, 0), getX() - 50, getY());
            FrameCount = 0;
        }
        
        if(getRotation() == 45 && Greenfoot.isKeyDown("Shift") && FrameCount > 30)
        {
            getWorld().addObject(new Bullet(3, -3), getX() + 50, getY() - 50);
            FrameCount = 0;
        
        }
        
        if(getRotation() == 135 && Greenfoot.isKeyDown("Shift") && FrameCount > 30)
        {
            getWorld().addObject(new Bullet(3, 3), getX() + 50, getY() + 50);
            FrameCount = 0;
        
        }
        
        if(getRotation() == 225 && Greenfoot.isKeyDown("Shift") && FrameCount > 30)
        {
            getWorld().addObject(new Bullet(-3, 3), getX() - 50, getY() + 50);
            FrameCount = 0;
        
        }
        
        if(getRotation() == 315 && Greenfoot.isKeyDown("Shift") && FrameCount > 30)
        {
            getWorld().addObject(new Bullet(-3, -3), getX() - 50, getY() - 50);
            FrameCount = 0;
        
        }
    }
}
