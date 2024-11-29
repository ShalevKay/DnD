package Backend;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Backend.Tiles.EmptyTile;
import Backend.Tiles.Tile;
import Backend.Tiles.Unit.Unit;

public class Board {
    private Tile[][] board;
    private Factory factory;
    private Factory.Heroes playerChoise;


    public Board(){
        board = null;
        factory = new Factory();
        playerChoise = null;
    }

    public void setPlayerChoise(Factory.Heroes hero){
        playerChoise = hero;
    }

    public void loadLevel(int level) throws Exception{
        if(playerChoise == null){
            throw new Exception("the player's choise of hero is not set!");
        }

        List<String> list = file2List("levels/level" + level + ".txt");
        String line;

        board = new Tile[list.size()][list.get(0).length()];

        for(int i=0; i<list.size(); i++){
            line = list.get(i);

            for(int j=0; j<line.length(); j++){
                board[i][j] = charToTile(line.charAt(j), j, i);
            }
        }
    }

    private List<String> file2List(String path) throws FileNotFoundException{
        List<String> list = new ArrayList<>();

        File file = new File(path);
            Scanner reader = new Scanner(file);

            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                list.add(line);
            }

            reader.close();

        return list;
    }

    private Tile charToTile(char c, int x, int y) throws Exception{
        Tile t;

        switch(c){
            case '.' -> {
                t = factory.makeEmptyTile(x, y);
            }
            case '#' -> {
                t = factory.makeWall(x, y);
            }
            case '@' -> {
                t = factory.makePlayer(playerChoise, x, y);
            }
            case 's' -> {
                t = factory.makeMonster(Factory.Monsters.NIMBLE_PARSHENDI, x, y);
            }
            case 'k' -> {
                t = factory.makeMonster(Factory.Monsters.WORK_PARSHENDI, x, y);
            }
            case 'q' -> {
                t = factory.makeMonster(Factory.Monsters.SADEAS_SOLDIER, x, y);
            }
            case 'z' -> {
                t = factory.makeMonster(Factory.Monsters.WAR_PARSHENDI, x, y);
            }
            case 'b' -> {
                t = factory.makeMonster(Factory.Monsters.WHITESPINE, x, y);
            }
            case 'g' -> {
                t = factory.makeMonster(Factory.Monsters.STORM_PARSHENDI, x, y);
            }
            case 'w' -> {
                t = factory.makeMonster(Factory.Monsters.SHARD_PARSHENDI, x, y);
            }
            case 'M' -> {
                t = factory.makeMonster(Factory.Monsters.ESHONAI, x, y);
            }
            case 'C' -> {
                t = factory.makeMonster(Factory.Monsters.TYN, x, y);
            }
            case 'K' -> {
                t = factory.makeMonster(Factory.Monsters.CHASMFIEND, x, y);
            }
            case 'B' -> {
                t = factory.makeTrap(Factory.Traps.BONUS, x, y);
            }
            case 'Q' -> {
                t = factory.makeTrap(Factory.Traps.ILLUSION, x, y);
            }
            case 'D' -> {
                t = factory.makeTrap(Factory.Traps.UNMADE, x, y);
            }
            default -> {
                throw new Exception("bad character at: <" + x + ", " + y + ">");
            }
        }

        return t;
    }
    
    public Tile getTile(int x, int y){
        if(x < 0 || x > board[0].length || y < 0 || y > board.length){
            return null;
        }

        return board[y][x];
    }

    public void updatePositions(Unit u, Tile tile){
        board[u.getPosition().getY()][u.getPosition().getX()] = u;

        // a dead enemy
        if(tile.getTile() == '1'){
            // TODO: use factory
            tile = new EmptyTile('.', tile.getPosition().getX(), tile.getPosition().getY());
        }

        board[tile.getPosition().getY()][tile.getPosition().getX()] = tile;
    }

}
