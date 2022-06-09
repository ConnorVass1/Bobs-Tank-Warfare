import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CursorP2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CursorP2 extends Actor
{
    int dx=0;
    int dy=0;
    boolean selected = false;
    boolean selected2 = false;
    TankClasses tank;
    int select=0;
    int select2=0;
    int  press= 0;
    public void act()
    {
        
        dx=0;
        dy=0;
         if (getWorld() instanceof Player2Selection)
        {
            movement2();          
        } 
        classes2();
        setLocation(getX()+dx, getY()+dy);
        
        if (Greenfoot.isKeyDown("enter"))
        {
            select=1;
        }
        
        
        
        
         if (selected==true&&getWorld() instanceof Player1Selection)
        {
            Greenfoot.setWorld(new Player2Selection());          
        } 
        
         if (selected2==true&&getWorld() instanceof Player2Selection)
        {
            Greenfoot.setWorld(new MyWorld());          
        } 
         
    }
    
    
    
    public void classes()
    {
        if (Greenfoot.isKeyDown("enter")&&isTouching(AmogusMKII.class)&&press==0)
        {
            select=1;
        }
        
        if (Greenfoot.isKeyDown("enter")&&isTouching(BigChonkers.class)&&press==0)
        {
            select=2;
        }
        
        if (Greenfoot.isKeyDown("enter")&&isTouching(Bob.class)&&press==0)
        {
            select=3;
        }
        
        if (Greenfoot.isKeyDown("enter")&&isTouching(GlassCannon.class)&&press==0)
        {
            select=4;
        }
        
        if (Greenfoot.isKeyDown("enter"))
        {
            System.out.println(""+select);
        }
    }
    
    //--------------------------------------------------------------------------
    public void movement2()
    {
        if (Greenfoot.isKeyDown("left"))
        {
            dx=-5;
        }
        
        if (Greenfoot.isKeyDown("right"))
        {
            dx=5;
        }
        
        if (Greenfoot.isKeyDown("up"))
        {
            dy=-5;
        }
        
        if (Greenfoot.isKeyDown("down"))
        {
            dy=5;
        }
        
        if (Greenfoot.isKeyDown("enter")&&isTouching(TankClasses.class)
        &&getWorld() instanceof Player2Selection)
        {
            selected2=true;
        }
        
        
    }
    
    public void classes2()
    {
        if (Greenfoot.isKeyDown("enter")&&isTouching(AmogusMKII.class)&&press==0)
        {
            select2=1;
        }
        
        if (Greenfoot.isKeyDown("enter")&&isTouching(BigChonkers.class)&&press==0)
        {
            select2=2;
        }
        
        if (Greenfoot.isKeyDown("enter")&&isTouching(Bob.class)&&press==0)
        {
            select2=3;
        }
        
        if (Greenfoot.isKeyDown("enter")&&isTouching(GlassCannon.class)&&press==0)
        {
            select2=4;
        }
        
        if (Greenfoot.isKeyDown("enter")&&press==0)
        {
            System.out.println(""+select2);
        }
    }
    
    
}
