import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Heal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Heal extends Powerups
{
    int Framecount;
    /**
     * Act - do whatever the Heal wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        setImage("Heal.png");
        if(isTouching(Wall.class))
        {
            setLocation(getX()+5, getY());
        }
        if (isTouching(Players.class))
        {
            getWorld().removeObject(this);   
        }
        
    }
}
