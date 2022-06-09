import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayerOne here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerOne extends Players
{
    //String setImage("folder/hp"+player.hp+".png"):
    int HP=0;
    int speedX = 0;
    int speedY = 0;
    int damage;
    int FrameCount = 0;
    int HPFrameCount;
    int PowerUpframecount=0;
    
    MyWorld myworld = (MyWorld) getWorld();
    /**
     * Act - do whatever the PlayerOne wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        movement();
        HPMechanics();
        bulletmovement();
        collision();
    }
    
    public void collision()
    {
        Wall s1=(Wall) getOneObjectAtOffset(0- getImage().getWidth()/2,0, Wall.class);
        if (s1!=null) 
        {
            setLocation(s1.getX()+s1.getImage().getWidth()/2
            +getImage().getWidth()/2,getY());
        }
        
        Wall s2=(Wall) getOneObjectAtOffset(0+ getImage().getWidth()/2,0, Wall.class);
        if (s2!=null) 
        {
            setLocation(s2.getX()-s2.getImage().getWidth()/2
            -getImage().getWidth()/2,getY());
        }
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
        
        if(Greenfoot.isKeyDown("w") && Greenfoot.isKeyDown("d"))
        {
            speedX = 3;
            speedY = -3;
            setRotation(45);
        }
        
        if(Greenfoot.isKeyDown("w") && Greenfoot.isKeyDown("a"))
        {
            speedX = -3;
            speedY = -3;
            setRotation(315);
        }
        
        if(Greenfoot.isKeyDown("s") && Greenfoot.isKeyDown("d"))
        {
            speedX = 3;
            speedY = 3;
            setRotation(135);
        }
        
        if(Greenfoot.isKeyDown("s") && Greenfoot.isKeyDown("a"))
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
        if(getRotation() == 0 && Greenfoot.isKeyDown("Space") && FrameCount > 30)
        {
            getWorld().addObject(new Bullet(0, -5), getX(), getY() - 55);
            FrameCount = 0;
        }
        
        if(getRotation() == 90 && Greenfoot.isKeyDown("Space") && FrameCount > 30)
        {
            getWorld().addObject(new Bullet(5, 0), getX() + 55, getY());
            FrameCount = 0;
        }
        
        if(getRotation() == 180 && Greenfoot.isKeyDown("Space") && FrameCount > 30)
        {
            getWorld().addObject(new Bullet(0, 5), getX(), getY() + 55);
            FrameCount = 0;
        }
        
        if(getRotation() == 270 && Greenfoot.isKeyDown("Space") && FrameCount > 30)
        {
            getWorld().addObject(new Bullet(-5, 0), getX() - 55, getY());
            FrameCount = 0;
        }
        
        if(getRotation() == 45 && Greenfoot.isKeyDown("Space") && FrameCount > 30)
        {
            getWorld().addObject(new Bullet(3, -3), getX() + 55, getY() - 55);
            FrameCount = 0;
        
        }
        
        if(getRotation() == 135 && Greenfoot.isKeyDown("Space") && FrameCount > 30)
        {
            getWorld().addObject(new Bullet(3, 3), getX() + 55, getY() + 55);
            FrameCount = 0;
        
        }
        
        if(getRotation() == 225 && Greenfoot.isKeyDown("Space") && FrameCount > 30)
        {
            getWorld().addObject(new Bullet(-3, 3), getX() - 55, getY() + 55);
            FrameCount = 0;
        
        }
        
        if(getRotation() == 315 && Greenfoot.isKeyDown("Space") && FrameCount > 30)
        {
            getWorld().addObject(new Bullet(-3, -3), getX() - 55, getY() - 55);
            FrameCount = 0;
        
        }
        

        
    }
    
    public void HPMechanics()
    {
        HPFrameCount++;
        if(isTouching(Bullet.class) && HPFrameCount > 96)
        {
            HP = HP - 1;
            HPFrameCount = 0;
        }
        
        if(HP == 0)
        {
            Greenfoot.setWorld(new MyWorld());
        }
        
        if(isTouching(Heal.class))
        {
            HP = HP + 1;
        }
        
        if(isTouching(Speed.class))
        {
            PowerUpframecount++;
            if(PowerUpframecount<=100)
            {
                speedX=speedX+5;
            }
        }
        
    }
}
