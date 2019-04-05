
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.audio.Music;

public class InstructionScreen extends BaseScreen
{
    public void initialize()
    {
        BaseActor background = new BaseActor(0,0, mainStage);
        background.setAnimator( new Animator("assets/images/water.jpg") );
        background.setSize(800,600);

       BaseActor tenMore = new BaseActor(0,0, mainStage);
       tenMore.setAnimator( new Animator ("assets/images/extra-ammo.png"));
       tenMore.setSize(64,64);
       
       BaseActor core = new BaseActor(0,0, mainStage);
       core.setAnimator( new Animator ("assets/images/the-core.png"));
       core.setSize(64,64);

        Label title = new Label("Instructions", BaseGame.labelStyle);
        title.setFontScale(1.5f);
        title.setColor( Color.BLUE );

        Label back = new Label("Press 'F' to Return", BaseGame.labelStyle);
        back.setColor( Color.CYAN );
        
        Label goal = new Label("Defend the Core!", BaseGame.labelStyle);
        goal.setColor( Color.CYAN );
        
         Label powerup1 = new Label("Powerup gives +10 Ammo", BaseGame.labelStyle);
        powerup1.setColor( Color.CYAN );
        
        //Label controls = new Label("Arrow Keys Move Turtle", BaseGame.labelStyle2);
       // instructions.setColor( Color.CYAN);
        
        //Label credits = new Label("Made by Angelo Morales", BaseGame.labelStyle2);
        //instructions.setColor( Color.CYAN );

        uiTable.add(title).colspan(2);
        uiTable.row();
        uiTable.add(core);
        uiTable.add(goal);
       // uiTable.row();
        uiTable.row();
        uiTable.add(tenMore);
        uiTable.add(powerup1);
        uiTable.row();
       // uiTable.add(ballSmall);
       // uiTable.add(smallballLabel).pad(10);
       // uiTable.row();
       // uiTable.add(ballLarge);
       // uiTable.add(largeballLabel).pad(10);
       // uiTable.row();
       // uiTable.add(ballSpawn);
       // uiTable.add(spawnballLabel).pad(10);
        //uiTable.row();
        //uiTable.add(destroyPaddle);
       // uiTable.add(destroypaddleLabel).pad(10);
       // uiTable.row();
       // uiTable.add(ballSpeed);
       // uiTable.add(ballspeedLabel).pad(10);
        uiTable.row();
       // uiTable.add(paddle);
       // uiTable.add(instructions).pad(5);
        uiTable.row();
        //uiTable.add(instructions);
        uiTable.row();
        //uiTable.add(credits);
        
        

    }

    public void update(float deltaTime)
    {
        
         if (Gdx.input.isKeyPressed(Keys.F))
            BaseGame.setActiveScreen( new MenuScreen() );    
    }

    
}