// CSD feb 2015 Juansa Sendra

public class Pool0 extends Pool {//free access
    
    private int kids, ins, cap;
    public void init(int ki, int cap){
    kids = ins = 0;
    ki = 0;
    this.cap = cap;
    }
    public void kidSwims(){
        log.waitingToSwim();
        kids++;
        notifyAll();
        log.swimming();
    }
    public void kidRests(){
        log.waitingToRest();
        kids--;
        notifyAll();
        log.resting(); 
    }
    public void instructorSwims(){
        log.waitingToSwim();
        ins++;
        notifyAll();
        log.swimming();
    }
    public void instructorRests(){
        log.waitingToRest();
        ins--;
        notifyAll();
        log.resting(); 
    }
}
