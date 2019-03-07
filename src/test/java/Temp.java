import com.jackson.pic.core.Area;
import com.jackson.pic.funny.request.DownloadRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;
import sun.net.www.http.HttpClient;

import java.io.File;

/**
 * Create by: Jackson
 */
public class Temp {

    @Test
    public void temp(){
        File f = new File("/Users/jiaoyubing/work_space/localworkspace/remove_watermark/src/test/java");
        File file = new File(f, "/aa/bb/a.txt");
        file.getParentFile().mkdirs();

    }
}
