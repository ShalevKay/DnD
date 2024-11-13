package Backend.Tiles.Unit.Player;

import Backend.Board;
import Backend.Tiles.Unit.Enemy.Enemy;

import java.util.List;
import java.util.Random;

public class Mage extends Player{

    private int manaPool;
    private int currentMana;
    private int manaCost;
    private int spellPower;
    private int hitsCount;
    private int abilityRange;

    public Mage(char tile, int x, int y, String name, int healthPool, int attackPoints, int defensePoints, int manaPool,
                int manaCost, int spellPower, int hitsCount, int abilityRange){
        super(tile, x, y, name, healthPool, attackPoints, defensePoints);

        this.manaPool = manaPool;
        this.currentMana = manaPool / 4;
        this.manaCost = manaCost;
        this.spellPower = spellPower;
        this.hitsCount = hitsCount;
        this.abilityRange = abilityRange;
    }

    @Override
    public void levelUp() throws Exception {
        super.levelUp();
        manaPool += 25 * level;
        currentMana = Math.min(currentMana + manaPool / 4, manaPool);
        spellPower += 10 * level;
    }

    @Override
    public void onTick(char action, Board board, List<Enemy> enemies) throws Exception {
        super.onTick(action, board, enemies);
        currentMana = Math.min(manaPool, currentMana + level);
    }

    @Override
    public void castAbility(List<Enemy> enemies){
        currentMana -= manaCost;
        int hits = 0;
        Random random = new Random();
        List<Enemy> closeEnemies = enemies.stream().filter(enemy -> this.range(enemy) < abilityRange).toList();
        while((hits < hitsCount) && !closeEnemies.isEmpty()){
            Enemy enemyToHit = closeEnemies.get(random.nextInt(0, closeEnemies.size()));
            enemyToHit.defend(spellPower);
            hits++;
            closeEnemies = enemies.stream().filter(enemy -> this.range(enemy) < abilityRange).toList();
        }
    }

    @Override
    public void castAbility(Player player){
        return;
    }

}
