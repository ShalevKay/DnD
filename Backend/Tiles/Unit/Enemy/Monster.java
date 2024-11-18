package Backend.Tiles.Unit.Enemy;

import java.util.Random;

import Backend.Board;
import Backend.Tiles.Tile;
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
        Tile tile;
        int x = position.getX(), y = position.getY();

        if(range < visionRange){
            dx = position.getX() - player.getPosition().getX();
            dy = position.getY() - player.getPosition().getY();

            if(Math.abs(dx) > Math.abs(dy)){
                if(dx > 0){
                    x -= 1;
                }
                else{
                    x += 1;
                }
            }
            else{
                if(dy > 0){
                    y -= 1;
                }
                else{
                    y += 1;
                }
            }
        }
        else{
            Random random = new Random();

            int movement = random.nextInt(1, 6);

            switch(movement){
                case 1 -> {x -= 1;} // left
                case 2 -> {x += 1;} // right
                case 3 -> {y -= 1;} // up
                case 4 -> {y += 1;} // down
                case 5 -> {return;} // nothing
            }
        }

        tile = board.getTile(x, y);

        interact(tile);
    }

    
}
