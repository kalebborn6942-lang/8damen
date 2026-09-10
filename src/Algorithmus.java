class Algorithmus{
    private static Dame[] damen = new Dame[4];
    private static int[] spalten_Y = {0,0,0,0};
    public static void main(String[] args){
        initDamen();
        loesen(0);
    }
    
    public static void loesen(int spalte){
        loesenRek(spalte);
    }
    public static void loesenRek(int spalte){
        boolean canbeplaced;
        System.out.println("Rek aufgerufen " + spalte);
        if(spalte == 4){
            gibLoesungAus();
        }
        else{
            placeDame(damen[spalte],spalte,spalten_Y[spalte]);
            canbeplaced = checkDamen();
            if(canbeplaced){
                System.out.println("Rek aufruf Spalte " + spalte);
                loesenRek(spalte+1);
                canbeplaced = !canbeplaced;
            }
            if(!canbeplaced){
                if (damen[spalte].getY() == 3) {
                    clearSpalte(spalte);
                }
                else{
                    spalten_Y[spalte]++;
                    loesenRek(spalte);
                }
                
            }
        }
    }
    public static void initDamen(){
        for(int i = 0;i < 4;i++){
            damen[i] = new Dame();
        }
    }
    
    public static void placeDame(Dame d,int x, int y){
        d.place();
        d.setCoords(x,y);
        System.out.println("Dame platziert bei " + x +" " + y);
    }
    
    public static void removeDame(Dame d){
        d.remove();
        System.out.println("Damen entfernt bei "+d.getX() +" " + d.getY());
    }

    public static void clearSpalte(int x){
        for(int i = 0;i < 4;i++){
            if(damen[i].getX() == x) {
                removeDame(damen[i]);
            }
        }
        spalten_Y[x] = 0;
    }

    public static boolean checkDamen(){
        for(int i = 0;i < 4;i++){
            for(int o = 0;o < 4;o++){
                if(damen[o].isPlaced() && damen[i].isPlaced() && o != i){
                    if(damen[i].beats(damen[o])){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void gibLoesungAus(){
        System.out.println("Lösung gefunden!");
        for(int i = 0;i < 4;i++){
            System.out.println("Dame " + i + ": " +damen[i].getX() + " " + damen[i].getY());
        }
    }
}