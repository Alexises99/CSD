// CSD feb 2013 Juansa Sendra

public class Pool4 extends Pool { //kids cannot enter if there are instructors waiting to exit
   private int ins, kids,ki,cap,insWaiting;
    //no kids alone
    public void init(int ki, int cap){
        this.ki = ki;
        this.cap = cap;
        ins = kids = 0;
        insWaiting = 0;
        
    }
    
    public synchronized void kidSwims(){
        
        
        while( ki * ins < (kids + 1) || (kids+1 +ins > cap) || insWaiting != 0){
            try{
                log.waitingToSwim();
                wait();
            }catch(Exception e){}
        }
        
        kids++;
        notifyAll();
        log.swimming();
       
    }
    
    public synchronized void kidRests(){
        log.waitingToRest();
        kids--;
        notifyAll();
        log.resting(); 
        
    }
    public synchronized void instructorSwims(){
       while((kids + ins+1) > cap){
            try{
                log.waitingToSwim();
                wait();
            }catch(Exception e){}
        }
        ins++;
        notifyAll();
        log.swimming();
        
    }
    public  synchronized void instructorRests(){
        
        insWaiting++;
        while(ki * (ins - 1) < kids){
            try{
                log.waitingToRest();
                wait();
            }catch(Exception e){}
        }
        insWaiting--;
        ins--;
        notifyAll();
        log.resting();
      
    }
}

