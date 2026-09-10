public class Dame {
    private boolean placed = false;
    private int[] coords = {0,0};

    public Dame(){

    }

    public boolean isPlaced(){
        return placed;
    }

    public int getX(){
        return coords[0];
    }

    public int getY(){
        return coords[1];
    }

    public void place(){
        this.placed = true;
    }

    public void remove(){
        this.placed = false;
    }

    public void setCoords(int x, int y){
        this.coords[0] = x;
        this.coords[1] = y;
    }

    public boolean beats(Dame d){
        return this.getX() == d.getX() || this.getY() == d.getY() || Math.abs(this.getX() - d.getX()) == Math.abs(this.getY() - d.getY());
    }
}
