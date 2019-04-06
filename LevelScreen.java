import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.audio.Music;

public class LevelScreen extends BaseScreen
{
    BaseActor background;
    
    //the initial things we need to get like the sounds and the name of objects
    Sound missile,Ph;//any variation of PH is just a placeholder
    Music PIM;
    
    EnemySub enemysub;

    Submarine submarine;
    Core mainCore;
    int score;
    Label coreLabel, scoreLabel, ammoLabel;

    Label laserStatus;
    double enemyTimer;

    public void initialize()
    {
       background = new BaseActor(0,0, mainStage);
       background.setAnimator( new Animator("assets/images/water.jpg") );
       background.setSize(800,600);
         
       submarine = new Submarine(190, 25, mainStage);
       
       mainCore = new Core(0,0, mainStage);
       mainCore.setSize(150, 800);
       mainCore.setBoundaryRectangle();

       /*Wall bottomWall = new Wall(0,0, mainStage);
       bottomWall.setSize(100,100);
       bottomWall.setBoundaryRectangle();
       bottomWall.setVisible(false);

       Wall topWall = new Wall(0,700, mainStage);
       topWall.setSize(800,100);
       topWall.setBoundaryRectangle();*/

       //Alien spawn timer
       enemyTimer = 0;

       score = 0;
       scoreLabel = new Label("Score: " + score, BaseGame.labelStyle);
       scoreLabel.setFontScale(0.5f);
       
       ammoLabel = new Label("Ammo: " + submarine.normalAmmo, BaseGame.labelStyle);
       ammoLabel.setFontScale(0.5f);
       
       coreLabel = new Label("Core: " + mainCore.health, BaseGame.labelStyle);
       coreLabel.setFontScale(0.5f);

        uiTable.add().expandX();
        uiTable.add( scoreLabel );
        uiTable.row();
        uiTable.add();
        uiTable.add( ammoLabel );
        uiTable.row();
        uiTable.add();
        uiTable.add().expandY();
        uiTable.add(coreLabel).right().bottom().pad(10);
        

        
       PIM = Gdx.audio.newMusic( Gdx.files.internal("assets/audio/bgm/Safe.ogg"));
       missile = Gdx.audio.newSound( Gdx.files.internal("assets/audio/sfx/Missile-Launch.wav"));
        
       PIM.setLooping(true);
        PIM.play();
        
       
       
      
    }

    public void update(float deltaTime)
    {
        // move paddle to the left and to the right
        if (Gdx.input.isKeyPressed(Keys.UP))
            submarine.physics.accelerateAtAngle(90);

        if (Gdx.input.isKeyPressed(Keys.DOWN))
            submarine.physics.accelerateAtAngle(-90);

        submarine.shotTimer += deltaTime;
        enemyTimer += deltaTime;

        if ( submarine.isOnStage() )
        {
            // you can only shoot if:
            // 1. you just pressed the space key
            // 2. the submarine is still on the stage (still visible)
            // 3. at least one second has passed since previous shot (laserTimer > 1)
            if (Gdx.input.isKeyJustPressed( Keys.SPACE ))
            {
                submarine.fire(this);
                ammoLabel.setText("Ammo: " + submarine.normalAmmo);
            }

            if (enemyTimer >= 1)
            {
                //float f;
                //double RAND=Math.random() *600;
 
              EnemySub e = new EnemySub(0, 0, mainStage);
              e.setPosition(800, (float)(Math.random() * (600 - e.getHeight()) + (e.getHeight() / 2)));
              enemyTimer = 0;
            }
        }
        
        for (BaseActor e : BaseActor.getList(mainStage, "EnemySub"))
            for (BaseActor l : BaseActor.getList(mainStage, "Laser"))
                if (l.overlaps(e))
                {
                    Explosion exp = new Explosion(0, 0, mainStage);
                    exp.centerAt(e);
                    e.remove();
                    l.remove();
                    
                        double itemChance = 0.99;
                    if (Math.random() < itemChance)
                    {
                        Item item = new Item(0,0, mainStage);
                        item.centerAt(e);
                    } 
                }
                
        // stop paddle from passing through walls
        /*for (BaseActor wall : BaseActor.getList(mainStage, "Wall"))
        {
            submarine.preventOverlap(wall);
        }*/
          
        
        
        //ITEMS SPAWN
        for (BaseActor actor : BaseActor.getList(mainStage, "Item"))
        {
            Item item = (Item)actor;
            if ( submarine.overlaps(item) )
            {
                switch(item.itemName)
                {
                    case "Pierce":
                        // goes through the enemies


                        //if(laser.overlaps(
                        break;
                    case "Rapid":
                        // fire shots faster



                        break;
                    case "extra-ammo":
                        // Adds normal bullets 
                        submarine.normalAmmo += 15;
                        ammoLabel.setText("Ammo: " + submarine.normalAmmo);
                        break;
                    
                    default:
                        submarine.weapon = 0;
                        submarine.specialAmmo = 0;
                        break;
                }
                item.remove();
            }
        }
        
        // Core health
        for (BaseActor e : BaseActor.getList(mainStage, "EnemySub"))
            if (e.overlaps(mainCore))
            {
                e.remove();
                mainCore.health -= 1;
                coreLabel.setText("Core: " + mainCore.health);
                if (mainCore.health <= 0)
                    endGame();
            }
    }
    
    
    public void endGame()
    {
        GameOver msg = new GameOver(0, 0, mainStage);
        msg.centerAt(background);
        Explosion e = new Explosion(0, 0, mainStage);
        e.centerAt(submarine);
        submarine.remove();
        // Play multiple explosions over core (or something).
        for (BaseActor e : BaseActor.getList(mainStage, "EnemySub"))
        {
            new Explosion(e.getX(), e.getY(), mainStage);
            e.remove();
        }
    }
}