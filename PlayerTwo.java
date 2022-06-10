import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayerTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerTwo extends Players
{           
    int HP=0;
    int speedX;
    int speedY;
    int damage;
    int FrameCount;
    int HPFrameCount;
    int P1class;
    int P2class;
    //class initializations
    AmogusMKII amog= new AmogusMKII();
    BigChonkers chonk= new BigChonkers();
    Bob bob= new Bob();
    GlassCannon glass= new GlassCannon();
    
    
    public PlayerTwo(int sel, int sel2)
    {
        P1class=sel;
        P2class=sel2;
    }
    
    public void act()
    {
        setclass();
        movement();
        bulletmovement();
        HPMechanics();
        System.out.println("stats are:HP "+HP+"SPeed"+speedX+"Damage"+damage);
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
        if(getRotation() == 0 && Greenfoot.isKeyDown("Enter") && FrameCount > 30)
        {
            getWorld().addObject(new Bullet(0, -5), getX(), getY() - 55);
            FrameCount = 0;
        }
        
        if(getRotation() == 90 && Greenfoot.isKeyDown("Enter") && FrameCount > 30)
        {
            getWorld().addObject(new Bullet(5, 0), getX() + 55, getY());
            FrameCount = 0;
        }
        
        if(getRotation() == 180 && Greenfoot.isKeyDown("Enter") && FrameCount > 30)
        {
            getWorld().addObject(new Bullet(0, 5), getX(), getY() + 55);
            FrameCount = 0;
        }
        
        if(getRotation() == 270 && Greenfoot.isKeyDown("Enter") && FrameCount > 30)
        {
            getWorld().addObject(new Bullet(-5, 0), getX() - 55, getY());
            FrameCount = 0;
        }
        
        if(getRotation() == 45 && Greenfoot.isKeyDown("Enter") && FrameCount > 30)
        {
            getWorld().addObject(new Bullet(3, -3), getX() + 55, getY() - 55);
            FrameCount = 0;
        
        }
        
        if(getRotation() == 135 && Greenfoot.isKeyDown("Enter") && FrameCount > 30)
        {
            getWorld().addObject(new Bullet(3, 3), getX() + 55, getY() + 55);
            FrameCount = 0;
        
        }
        
        if(getRotation() == 225 && Greenfoot.isKeyDown("Enter") && FrameCount > 30)
        {
            getWorld().addObject(new Bullet(-3, 3), getX() - 55, getY() + 55);
            FrameCount = 0;
        
        }
        
        if(getRotation() == 315 && Greenfoot.isKeyDown("Enter") && FrameCount > 30)
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
        
        
    }
    
    public void setclass()
    {
        if(P2class==1)
        {
            HP= amog.HP;
            speedX=amog.speedX;
            damage= amog.damage;
        }
        
        if(P2class==2)
        {
            HP= chonk.HP;
            speedX=chonk.speedX;
            damage= chonk.damage;
        }
        
        if(P2class==3)
        {
            HP= bob.HP;
            speedX=bob.speedX;
            damage= bob.damage;
        }
        
        if(P2class==4)
        {
            HP= glass.HP;
            speedX=glass.speedX;
            damage= glass.damage;
        }
    }
}
