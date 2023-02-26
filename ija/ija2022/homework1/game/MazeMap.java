package ija.ija2022.homework1.game;

import ija.ija2022.homework1.common.Field;
import ija.ija2022.homework1.common.Maze;

public class MazeMap implements Maze {

    private int rows;
    private int cols;
    private Field[][] map;

    private int lastRow = 0; //row counter

    public MazeMap(int rows, int cols) {
        this.rows = rows + 2;
        this.cols = cols + 2;
        this.map = new Field[this.rows][this.cols];
    }
    
    /**
     * Vytvoří horizontální zed'
     * @return
     */
    public boolean createWall() {
        return this.insertLine("X".repeat(this.cols));
    }

    public boolean insertLine(String line) {
        if (line.length() != this.cols)
            return false;
        if (this.lastRow >= this.rows)
            return false;

        int col = 0;
        Field field;
        for (char ch : line.toCharArray()) {
            if (ch == 'X') {
                field = new WallField(this.lastRow, col);
            } else {
                field = new PathField(this.lastRow, col);
                field.setMaze(this);
                switch (ch) {
                    case 'T':
                        field.put(new FinishObject(field));
                        break;
                    case 'G':
                        field.put(new GhostObject(field));
                        break;
                    case 'K':
                        field.put(new KeyObject(field));
                        break;
                    case 'S':
                        field.put(new PacmanObject(field));
                        break;
                    case '.':
                        break;
                    default:
                        return false;
                }
            }
            this.map[this.lastRow][col] = field;
            col++;
        }

        this.lastRow++;

        return true;
    }

    @Override
    public Field getField(int row, int col) {
        return this.map[row][col];
    }

    @Override
    public int numRows() {
        return this.rows;
    }

    @Override
    public int numCols() {
        return this.cols;
    }

}
