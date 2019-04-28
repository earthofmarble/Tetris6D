package Tetris;

enum Direction {
    LEFT(0,-1),
    DOWN(1,0),
    RIGHT(0,1),
    NONE(0,0);
    //
    private final int xSteps;
    private final int ySteps;

    private Direction(int xSteps, int ySteps) {
        this.xSteps = xSteps;
        this.ySteps = ySteps;
    }

    public int getNewXId(int currentXId)  {
        return  (currentXId + getXSteps());
    }
    public int getNewYId(int currentYId)  {
        return  (currentYId + getYSteps());
    }
    public int getXSteps()  {
        return  xSteps;
    }
    public int getYSteps()  {
        return  ySteps;
    }

}