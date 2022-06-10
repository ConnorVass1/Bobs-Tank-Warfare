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
    int select=0;
    public void act()
    {
        
        dx=0;
        dy=0;
        
        movement();          
         
        classes();
    
        setLocation(getX()+dx, getY()+dy);
        
        
        
        
        if (selected==true)
        {
            Greenfoot.setWorld(new Player2Selection(select));          
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
        if (Greenfoot.isKeyDown("enter")&&isTouching(AmogusMKII.class))
        {
            select=1;
        }
        
        else if (Greenfoot.isKeyDown("enter")&&isTouching(BigChonkers.class))
        {
            select=2;
        }
        
        else if (Greenfoot.isKeyDown("enter")&&isTouching(Bob.class))
        {
            select=3;
        }
        
        else if (Greenfoot.isKeyDown("enter")&&isTouching(GlassCannon.class))
        {
            select=4;
        }
        
        if (Greenfoot.isKeyDown("enter"))
        {
            System.out.println(""+select);
        }
    }
 
}
    
    
