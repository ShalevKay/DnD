package Backend.Tiles.Unit;

import java.util.Random;

import Backend.Tiles.EmptyTile;
import Backend.Tiles.Position;
import Backend.Tiles.Tile;
import Backend.Tiles.Wall;
import Backend.VisitorInterfaces.Visitor;

public abstract class Unit extends Tile implements Visitor{
    protected String name;
    protected int healthPool;
    protected int currentHealth;
    protected int attackPoints;
    protected int defensePoints;


    public void interact(Tile tile){
        tile.accept(this);
    }

    @Override
    public void visit(Wall wall) {
        return;
    }

    @Override
    public void visit(EmptyTile emptyTile) {
        int x = this.position.getX();
        int y = this.position.getY();

        Position other = emptyTile.getPosition();
        this.position.setX(other.getX());
        this.position.setY(other.getY());

        other.setX(x);
        other.setY(y);
    }

    public String  description(){
        return "--- " + name + "---\n" + 
                currentHealth + " / " + healthPool + " 🩸\n" +
                attackPoints + " ⚔️    " + defensePoints + " 🛡️\n";
    }

    public boolean isDead(){
        return currentHealth <= 0;
    }

    public void attack(Unit opponent){
        Random random = new Random();

        int dmg = random.nextInt(attackPoints + 1);

        opponent.defend(dmg);
    }

    public void defend(int dmg){
        Random random = new Random();

        int defense = random.nextInt(defensePoints + 1);

        if(dmg > defense){
            currentHealth -= dmg - defense;
        }
    }
     
    public String getName(){
        return name;
    }







}
