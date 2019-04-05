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
    //the initial things we need to get like the sounds and the name of objects
    Sound missile,Ph;//any variation of PH is just a placeholder
    Music PIM;
    
    EnemySub enemysub;

    Submarine submarine;
    int coreHealth, score, ammo;
    Label coreLabel, scoreLabel, ammoLabel;

    double laserTimer;
    Label laserStatus;
    double alienTimer;

    public void initialize()
    {
        BaseActor background = new BaseActor(0,0, mainStage);
        background.setAnimator( new Animator("assets/images/water.jpg") );
        background.setSize(800,600);
         
        submarine = new Submarine(190, 25, mainStage);
       

        // Why do we need walls
        Core mainCore = new Core(0,0, mainStage);
        mainCore.setSize(150, 800);
        mainCore.setBoundaryRectangle();
       

        Wall bottomWall = new Wall(0,0, mainStage);
       bottomWall.setSize(100,100);
        bottomWall.setBoundaryRectangle();
        bottomWall.setVisible(false);

        Wall topWall = new Wall(0,700, mainStage);
        topWall.setSize(800,100);
        topWall.setBoundaryRectangle();
        
        
        // ready to shoot immediately
        laserTimer = 1;
        //Alien spawn timer
        alienTimer = 0;

        
        score = 0;
        scoreLabel = new Label("Score: " + score, BaseGame.labelStyle);
        scoreLabel.setFontScale(0.5f);
        
        ammo = 15;
        ammoLabel = new Label("Ammo: " + ammo, BaseGame.labelStyle);
        ammoLabel.setFontScale(0.5f);


        uiTable.add( scoreLabel ).expandX().expandY().left().top().pad(20);
        uiTable.add().expandX();
        uiTable.add().expandX();
        uiTable.add( ammoLabel ).expandX().expandY().right().top().pad(20);
        uiTable.add();
        uiTable.row();
        uiTable.add();
        uiTable.row();
        uiTable.add().expandY();
        uiTable.add();
        uiTable.add();

        
        //PIM = Gdx.audio.newMusic( Gdx.files.internal("assets/audio/bgm/Plans_in_Motion.ogg"));
         missile = Gdx.audio.newSound( Gdx.files.internal("assets/audio/sfx/Missile-Launch.wav"));
        
       // PIM.setLooping(true);
       // PIM.play();
        
        
        
    }

    public void update(float deltaTime)
    {
        // move paddle to the left and to the right
        if (Gdx.input.isKeyPressed(Keys.UP))
            submarine.physics.accelerateAtAngle(90);

        if (Gdx.input.isKeyPressed(Keys.DOWN))
            submarine.physics.accelerateAtAngle(-90);

        laserTimer += deltaTime;
        alienTimer += deltaTime;

if ( submarine.isOnStage() )
        {
            // you can only shoot if:
            // 1. you just pressed the space key
            // 2. the submarine is still on the stage (still visible)
            // 3. at least one second has passed since previous shot (laserTimer > 1)
            if ( Gdx.input.isKeyJustPressed( Keys.SPACE ) && laserTimer > 1 && ammo > 0)
            {
                Laser laser = new Laser(0,0, mainStage);
                missile.play();
                ammo--;
                ammoLabel.setText( "Ammo: " + ammo);
                laser.centerAt( submarine );
                // reset timer, so player can not shoot until time goes by
                laserTimer = 0;
            }


            if (alienTimer >= 10)
            {
                //float f;
                //double RAND=Math.random() *600;
 
              new EnemySub(800, (float) (Math.random() * 600), mainStage);
                alienTimer= 0;
            }
}
 
        
                // stop paddle from passing through walls
        for (BaseActor wall : BaseActor.getList(mainStage, "Wall"))
        {
            submarine.preventOverlap(wall);
        }
        //ITEMS SPAWN
        for (BaseActor actor : BaseActor.getList(mainStage, "Item"))
        {
            Item item = (Item)actor;

            if ( submarine.overlaps(item) )
            {
                item.remove();

                if (item.itemName.equals("NAMED"))
                {
                    //WHAT IT DOES
                }
                else if (item.itemName.equals("")){
                }
            }
        }

    }
}