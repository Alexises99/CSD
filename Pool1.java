// CSD feb 2015 Juansa Sendra

public class Pool1 extends Pool {  
    private int ins, kids, cap;
    //no kids alone
    public void init(int ki, int cap){
        ki = 0;
        this.cap = cap;
        ins = kids = 0;
        
    }
    
    public synchronized void kidSwims(){
        while(ins <= 0){
            try{
                log.waitingToSwim();
                wait();
            }catch(Exception e){}
        }
        kids++;
        log.swimming();
        notifyAll();
    }
    
    public synchronized void kidRests(){
        log.waitingToRest();
        kids--;
        log.resting(); 
        notifyAll();
    }
    public synchronized void instructorSwims(){
        log.waitingToSwim();
        ins++;
        log.swimming();
        notifyAll();
    }
    public  synchronized void instructorRests(){
        while(kids>0){
            try{
                log.waitingToRest();
                wait();
            }catch(Exception e){}
        }
        ins--;
        log.resting();
        notifyAll();
    }
}
