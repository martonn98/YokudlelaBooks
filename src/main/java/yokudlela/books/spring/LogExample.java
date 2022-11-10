package yokudlela.books.spring;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.slf4j.MDC;

import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author oe
 */
public class LogExample {

    public static void main(String[] args) {
        LogThread lt = new LogThread(0);
        lt.start();
        for(int i=0;i<10;i++){
            lt.index = i;
        }
    }

}

@Slf4j
class LogThread extends Thread{
    public int index;

    public LogThread(int index) {
        this.index = index;
    }

    @Override
    public void run() {
        try {
            MDC.put("index", ""+index);
            sleep(1000);
            log.info("---"+index);
            MDC.clear();
        } catch (InterruptedException ex) {
            Logger.getLogger(LogThread.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
