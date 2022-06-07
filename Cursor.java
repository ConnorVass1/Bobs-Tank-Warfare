import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cursor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cursor extends Actor
{
    int dx=0;
    int dy=0;
    public void act()
    {
        movement();
        setLocation(getX()+dx, getY()+dy);
    }
    
    public void movement()
    {
        if (Greenfoot.isKeyDown("a"))
        {
            dx=-5;
        }
        
        if (Greenfoot.isKeyDown("d"))
        {
            dx=5;
        }
        
        if (Greenfoot.isKeyDown("w"))
        {
            dy=-5;
        }
        
        if (Greenfoot.isKeyDown("s"))
        {
            dy=5;
        }
    }
}
