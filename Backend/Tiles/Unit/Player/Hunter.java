package Backend.Tiles.Unit.Player;

public class Hunter extends Player {
    private final int range;
    private int currentArrows;
    private int ticksCount;


    public Hunter(char tile, int x, int y, String name, int healthPool, int attackPoints, int defensePoints, int range) {
        super(tile, x, y, name, healthPool, attackPoints, defensePoints);

        this.range = range;
        this.currentArrows = 10;
        this.ticksCount = 0;
    }

    @Override
    protected void levelUp() throws Exception {
        super.levelUp();

        currentArrows += 10 * level;
        attackPoints += 2 * level;
        defensePoints += level;
    }




}
