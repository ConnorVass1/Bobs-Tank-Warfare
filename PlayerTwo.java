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
    /**
     * Act - do whatever the PlayerTwo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        movement();
    }
    public void movement()
    {
        speedX = 0;
        speedY = 0;

        if(Greenfoot.isKeyDown("Left"))
        {
            speedX = -5;
            setRotation(180);
        }
        if(Greenfoot.isKeyDown("Right"))
        {
            speedX = 5;
            setRotation(0);
        }
        if(Greenfoot.isKeyDown("Down"))
        {
            speedY = 5;
            setRotation(90);
        }
        if(Greenfoot.isKeyDown("Up"))
        {
            speedY = -5;
            setRotation(270);
        }
        
        setLocation(getX() + speedX, getY() + speedY);
    }
}
