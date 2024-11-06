package Backend.Tiles.Unit.Player;

import Backend.Board;
import Backend.Tiles.Unit.Enemy.Enemy;

import java.util.List;

public class Warrior extends Player{

    private int cooldown;
    private int remainingCooldown;

    public Warrior(char tile, int x, int y, String name, int healthPool, int attackPoints, int defensePoints,
                   int experience, int level, int cooldown){
        super(tile, x, y, name, healthPool, attackPoints, defensePoints);

        this.cooldown = cooldown;
        this.remainingCooldown = 0;
    }

    @Override
    public void levelUp() throws Exception {
        super.levelUp();
        remainingCooldown = 0;
        healthPool += 5 * level;
        attackPoints += 2 * level;
        defensePoints += level;
    }

    @Override
    public void onTick(char action, Board board, List<Enemy> enemies) throws Exception {
        super.onTick(action, board, enemies);
        remainingCooldown--;
    }

    @Override
    public void castAbility(List<Enemy> enemies){
        remainingCooldown = cooldown;

    }

}
