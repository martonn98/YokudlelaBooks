package yokudlela.books.utils.request;

import org.springframework.util.StopWatch;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Krisztian
 */
@Data
@Slf4j
public class RequestBean {

    private String requestId ;

    private String user;

    private String token;

    private String client;

    private StopWatch watcher;

    public RequestBean(){
        this.watcher= new StopWatch();
        this.watcher.start();
    }

}