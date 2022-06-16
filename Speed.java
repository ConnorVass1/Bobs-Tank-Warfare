import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Speed here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Speed extends Powerups
{
    /**
     * Act - do whatever the Speed wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
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
