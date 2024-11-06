package Backend.Tiles.Unit.Player;

import java.util.List;

import Backend.Board;
import Backend.Tiles.Tile;
import Backend.Tiles.Unit.HeroicUnit;
import Backend.Tiles.Unit.Unit;
import Backend.Tiles.Unit.Enemy.Enemy;
import Backend.VisitorInterfaces.Visitor;

public abstract class Player extends Unit implements HeroicUnit{
    protected int experience;
    protected int level;


    public Player(char tile, int x, int y, String name, int healthPool, int attackPoints, int defensePoints){
        super(tile, x, y, name, healthPool, attackPoints, defensePoints);

        this.experience = 0;
        this.level = 1;
    }


    protected boolean canLevelUp(){
        return experience >= level * 50;
    }

    protected void levelUp() throws Exception{
        if(!canLevelUp()){
            throw new Exception("cannot level up");
        }

        experience -= 50 * level;
        level++;
        healthPool += 10 * level;
        currentHealth = healthPool;
        attackPoints += 4 * level;
        defensePoints += level;
    }

    @Override
    public void accept(Visitor visitor){
        visitor.visit(this);
    }

    @Override
    public void visit(Player player){
        return;
    }

    @Override
    public void visit(Enemy enemy){
        attack(enemy);

        if(enemy.isDead()){
            experience += enemy.getExperienceValue();
            enemy.setTile('1');

            int x = position.getX();
            int y = position.getY();

            position.setX(enemy.getPosition().getX());
            position.setY(enemy.getPosition().getY());
            enemy.getPosition().setX(x);
            enemy.getPosition().setY(y);

            if(canLevelUp()){
                try{
                    levelUp();
                }
                catch(Exception e){
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public void onTick(char action, Board board, List<Enemy> enemies) throws Exception{
        if(action == 'q')
        return;

        if(action == 'e'){
            castAbility(enemies);
            return;
        }

        Tile tile = null;

        switch (action) {
            case 'w' -> {
                tile = board.getTile(position.getX(), position.getY() - 1);
            }
            case 's' -> {
                tile = board.getTile(position.getX(), position.getY() + 1);

            }
            case 'd' -> {
                tile = board.getTile(position.getX() + 1, position.getY());

            }
            case 'a' -> {
                tile = board.getTile(position.getX() - 1, position.getY());
            }
            default -> {
                throw new Exception("illegal action");
            }
        }

        interact(tile);

        board.updatePositions(this, tile);
    }

    

}
