import com.jackson.pic.core.Area;
import com.jackson.pic.core.ImageCompont;
import com.jackson.pic.funny.request.DownloadRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;
import sun.net.www.http.HttpClient;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * Create by: Jackson
 */
public class Temp {

    @Test
    public void temp() throws IOException {
        File source = new File("/Users/jiaoyubing/work_space/localworkspace/remove_watermark/src/test/997.jpg");
        File target = new File("/Users/jiaoyubing/work_space/localworkspace/remove_watermark/src/test/aaa.jpg");


        ImageCompont imageCompont = new ImageCompont();
        ImageCompont.MyImage handle = imageCompont.handle(source);
        storeImage(handle,target);
    }


    private void storeImage(ImageCompont.MyImage image, File file) throws IOException {
        File resultFolder = new File(file.getParentFile(), "result");
        resultFolder.mkdir();
        File originFile = new File(resultFolder, file.getName());
        ImageIO.write(image.getOutput(), "jpg",originFile );
    }
}
