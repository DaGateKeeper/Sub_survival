public class SubSurvivalGame extends BaseGame
{
    public void create() 
    {     
        super.create();
           setActiveScreen( new LevelScreen() );
    }
}