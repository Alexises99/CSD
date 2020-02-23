// CSD feb 2015 Juansa Sendra

public class Pool2 extends Pool{ //max kids/instructor
   private int ins, kids,ki,cap;
    //no kids alone
    public void init(int ki, int cap){
        this.ki = ki;
        this.cap = cap;
        ins = kids = 0;
        
    }
    
    public synchronized void kidSwims(){
       
        
        while(ki * ins < (kids + 1)){
            try{
                log.waitingToRest();
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
        
        while(ki * (ins - 1) < kids){
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
