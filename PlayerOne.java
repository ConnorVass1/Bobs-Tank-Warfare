import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
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
    int P1class;
    int P2class;
    int stopspeedX;
    int stopspeedY;
    
    
    AmogusMKII amog= new AmogusMKII();
    BigChonkers chonk= new BigChonkers();
    Bob bob= new Bob();
    GlassCannon glass= new GlassCannon();
    
    
    MyWorld myworld = (MyWorld) getWorld();
    
    public PlayerOne(int sel, int sel2)
    {
        P1class=sel;
        P2class=sel2;
    }
    
    public void act()
    {
        setclass();
        movement();
        HPMechanics();
        bulletmovement();
        collision();
        //System.out.println("stats are:HP1 "+HP+"SPeed1"+speedX+"Damage1"+damage);

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
        stopspeedX = speedX - speedX;
        stopspeedY = speedY - speedY;
        
        if(Greenfoot.isKeyDown("D"))
        {
            turn(speedX);
        }
        if(Greenfoot.isKeyDown("A"))
        {
            turn(-speedX);
        }
        if(Greenfoot.isKeyDown("W"))
        {
            move(speedX);
        }
        if(Greenfoot.isKeyDown("S"))
        {
            move(-speedX);
        }
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
        
        
        
        
        
    }
    
    public void PowerUps()
    {
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
        
        if(isTouching(Damage.class))
        {
            PowerUpframecount++;
            if(PowerUpframecount<=100)
            {
                damage=damage+1;
            }
        }
        
        if (PowerUpframecount>=100)
        {
            damage=1;
            speedX=speedX-1;
        }
    }
    
    public void setclass()
    {
        if(P1class==1)
        {
            HP= amog.HP;
            speedX=amog.speedX;
            speedY=amog.speedX;
            damage= amog.damage;
        }
        
        if(P1class==2)
        {
            HP= chonk.HP;
            speedX=chonk.speedX;
            speedY=chonk.speedX;
            damage= chonk.damage;
        }
        
        if(P1class==3)
        {
            HP= bob.HP;
            speedX=bob.speedX;
            speedY=bob.speedX;
            damage= bob.damage;
        }
        
        if(P1class==4)
        {
            HP= glass.HP;
            speedX=glass.speedX;
            speedY=glass.speedX;
            damage= glass.damage;
        }
    }
}
