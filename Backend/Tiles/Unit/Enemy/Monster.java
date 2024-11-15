package Backend.Tiles.Unit.Enemy;

import Backend.Board;
import Backend.Tiles.Unit.Player.Player;

public class Monster extends Enemy{
    private final int visionRange;


    public Monster(char tile, int x, int y, String name, int healthPool,
                    int attackPoints, int defensePoints, int experienceValue, int visionRange){
        super(tile, x, y, name, healthPool, attackPoints, defensePoints, experienceValue);

        this.visionRange = visionRange;
    }


    @Override
    public void onTick(Player player, Board board) {
        double range = range(player);
        int dx, dy;

        if(range < visionRange){
            dx = position.getX() - player.getPosition().getX();
            dy = position.getY() - player.getPosition().getY();

            if(Math.abs(dx) > Math.abs(dy)){
                if(dx > 0){
                    // move left
                }
                else{
                    // move right
                }
            }
            else{
                if(dy > 0){
                    // move up
                }
                else{
                    // move down
                }
            }
        }
        else{
            // random movement
        }
    }

    
}
