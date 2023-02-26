package ija.ija2022.homework1.game;

import ija.ija2022.homework1.common.Maze;

public class MazeConfigure {

    private MazeMap maze;

    public MazeConfigure() {
        this.maze = null;
    }

    /**
     * Vytvoří hru (bludiště) podle nacteného mapového podkladu.
     * 
     * @return
     */
    public Maze createMaze() {
        return this.maze;
    }

    /**
     * Nacte (příjme) jeden řádek mapového podkladu.
     * 
     * @param line
     * @return
     */
    public boolean processLine(String line) {
        if (this.maze == null)
            return false;
        
        if (this.maze.insertLine("X" + line + "X")) {
            return true;
        }
        else {
            this.maze = null;
            return false;
        }
    }

    /**
     * Zahájí ctení mapového podkladu zadaného rozměru.
     * 
     * @param rows
     * @param cols
     */
    public void startReading(int rows, int cols) {
        this.maze = new MazeMap(rows, cols);
        this.maze.createWall();
    }

    /**
     * Ukoncí ctení mapového podkladu.
     * 
     * @return
     */
    public boolean stopReading() {
        if (this.maze == null) {
            return false;
        }

        return this.maze.createWall();
    }
}
