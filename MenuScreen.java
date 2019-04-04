import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

public class MenuScreen extends BaseScreen
{
    public void initialize()
    {
        BaseActor background = new BaseActor(0,0, mainStage);
        background.setAnimator( new Animator("assets/space.png") );
        background.setSize(800,600);

        // BaseActor title = new BaseActor(150, 300, mainStage);
        // title.setAnimator( new Animator("assets/starfish-collector.png") );

        // BaseActor instructions = new BaseActor(150, 100, mainStage);
        // instructions.setAnimator( new Animator("assets/message-start.png") );

        Label title = new Label(" Brick\nDestroyer", BaseGame.labelStyle);
        title.setFontScale(2);
        title.setColor( Color.WHITE );

        Label instructions = new Label("Press 'S' to Start\nPress 'I' for info on the game", BaseGame.labelStyle);
        instructions.setColor( Color.CYAN );

        // Label Exit = new Label("Press 'X' to Exit", BaseGame.labelStyle);
        // Exit.setColor( Color.RED );
        Label Creator = new Label("Game made by John Kulins", BaseGame.labelStyle);
        Creator.setFontScale(0.5f);
        Creator.setColor( Color.WHITE );
        Label Controls = new Label
            ("Arrow keys are your movement\nGoal:Destroy all bricks\n"
                +"there are buffs and debuffs."
            , BaseGame.labelStyle);
        Controls.setFontScale(.5f);

        uiTable.add(title);
        uiTable.row();

        uiTable.add(instructions);

        uiTable.row();
        uiTable.add().pad(10);
        // uiTable.add(Exit);
        // uiTable.row();
        uiTable.row();
        uiTable.add(Controls);

        uiTable.row();
        uiTable.add().pad(32);
        uiTable.row();
        uiTable.add(Creator);
    }

    public void update(float deltaTime)
    {
        if (Gdx.input.isKeyPressed(Keys.S))
            BaseGame.setActiveScreen( new LevelScreen() );


    } 
}