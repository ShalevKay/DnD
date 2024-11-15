package Backend.Tiles.Unit.Player;

public class Hunter extends Player {
    private final int range;
    private int quiverSize;
    private int currentArrows;
    private int ticksCount;


    public Hunter(char tile, int x, int y, String name, int healthPool, int attackPoints, int defensePoints, int range) {
        super(tile, x, y, name, healthPool, attackPoints, defensePoints);

        this.range = range;
        this.quiverSize = 10;
        this.currentArrows = this.quiverSize;
        this.ticksCount = 0;
    }




}
