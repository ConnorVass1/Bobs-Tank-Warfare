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
    boolean selected = false;
    TankClasses tank;
    public void act()
    {
        
        dx=0;
        dy=0;
        movement();
        setLocation(getX()+dx, getY()+dy);
        
        
        
        
        
        
         if (selected==true&&getWorld() instanceof Player1Selection)
        {
            Greenfoot.setWorld(new Player2Selection());          
        } 
         
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
        
        if (Greenfoot.isKeyDown("enter")&&isTouching(TankClasses.class))
        {
            selected=true;
        }
    }
    
    public void classes()
    {
        Actor Amogus = getOneIntersectingObject(AmogusMKII.class);
        if (Amogus!= null)
        {
            
        }
    }
}
