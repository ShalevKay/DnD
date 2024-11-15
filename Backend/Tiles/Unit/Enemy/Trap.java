package Backend.Tiles.Unit.Enemy;

import Backend.Board;
import Backend.Tiles.Unit.Player.Player;

public class Trap extends Enemy{

    private int visibilityTime;
    private int invisibilityTime;
    private int ticksCount;
    private boolean visible;
    private char originalTile;

    public Trap(char tile, int x, int y, String name, int healthPool, int attackPoints, int defensePoints,
                int visibilityTime, int invisibilityTime, int experienceValue){
        super(tile, x, y, name, healthPool, attackPoints, defensePoints, experienceValue);

        this.visibilityTime = visibilityTime;
        this.invisibilityTime = invisibilityTime;
        this.ticksCount = 0;
        this.visible = true;
        this.originalTile = tile;
    }

    @Override
    public void onTick(Player player, Board board){
        visible = ticksCount < visibilityTime;
        if(ticksCount == visibilityTime + invisibilityTime){
            ticksCount = 0;
        }
        else{
            ticksCount++;
        }
        if(range(player) < 2){
            attack(player);
        }

        if(visible){
            tile = originalTile;
        }
        else{
            tile = '.';
        }
    }

}
