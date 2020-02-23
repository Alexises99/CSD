// CSD feb 2015 Juansa Sendra

public class Pool3 extends Pool{ //max capacity
 
   private int ins, kids, ki, cap;
    //no kids alone
    public void init(int ki, int cap){
        this.ki = ki;
        this.cap = cap;
        ins = kids = 0;
        
    }
    
    public synchronized void kidSwims(){
       
        
        while( ki * ins < (kids + 1) || (kids+1 +ins > cap)){
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
       while((kids + ins+1) > cap){
            try{
                log.waitingToSwim();
                wait();
            }catch(Exception e){}
        }
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

