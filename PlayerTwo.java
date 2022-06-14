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
    int stopspeedX;
    int stopspeedY;
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
        stopspeedX = speedX - speedX;
        stopspeedY = speedY - speedY;
        
        if(Greenfoot.isKeyDown("Right"))
        {
            turn(speedX);
        }
        if(Greenfoot.isKeyDown("Left"))
        {
            turn(-speedX);
        }
        if(Greenfoot.isKeyDown("Up"))
        {
            move(speedX);
        }
        if(Greenfoot.isKeyDown("Down"))
        {
            move(-speedX);
        }
    
    }
    
    public void bulletmovement()
    {
        FrameCount++;
        
        if(Greenfoot.isKeyDown("Shift") && FrameCount > 30)
        {
             Bullet bullet = new Bullet(5,0);
             bullet.setRotation(getRotation());
             getWorld().addObject(bullet, getX() - 25, getY() + 25);
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
        
        if (HP==0)
        {
            getWorld().addObject(new PlayerOneWins(), 500, 300);
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
