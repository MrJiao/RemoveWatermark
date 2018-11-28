package com.jackson.pic.core;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Create by: Jackson
 */
public class ImageCompont {

    public void handle(File file) throws IOException {
        BufferedImage image = ImageIO.read(file);
        MyImage pic = remove(image);
        MyImage myImage = clip(pic);
        File resultFolder = new File(file.getParentFile(), "result");
        resultFolder.mkdir();
        ImageIO.write(myImage.getOutput(), "jpg", new File(resultFolder,file.getName()));
    }

    private MyImage clip(MyImage pic) {
        CopyAreaCompont copyAreaCompont = new CopyAreaCompont();
        copyAreaCompont.init(pic);

        List<CopyArea> copyAreaList = copyAreaCompont.getCopyArea();
        BufferedImage removeBuf = pic.getOutput();

        MyImage clipImage = create(copyAreaCompont.getWidth(), copyAreaCompont.getHeight());
        clipImage.setBackGround(new Color(-1));
        for (CopyArea copyArea : copyAreaList) {
            BufferedImage subimage = removeBuf.getSubimage(copyArea.x, copyArea.y, copyArea.width, copyArea.height);
            clipImage.getGraphics().drawImage(subimage, copyArea.toX, copyArea.toY, null);
        }

        return clipImage;
    }


    private MyImage create(int width, int height) {
        BufferedImage output = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
        Graphics2D graphics = output.createGraphics();
        return new MyImage(graphics, output);
    }


    public MyImage remove(BufferedImage image) throws IOException {
        AreaCompont areaCompont = new AreaCompont();
        int height = image.getHeight();
        int width = image.getWidth();
        BufferedImage output = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
        Graphics2D graphics = output.createGraphics();
        MyImage myImage = new MyImage(graphics, output);
        int a = 210;
        graphics.drawImage(image, 0, 0, null); //画图
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (!areaCompont.isContains(i, j)) continue;
                int rgb = image.getRGB(i, j);
                Color color = new Color(rgb);
                int red = color.getRed();
                int blue = color.getBlue();
                int green = color.getGreen();
                if (red > a && blue > a && green > a) {
                    output.setRGB(i, j, -1);

                }
            }
        }
        return myImage;
    }


    public static class MyImage {
        private Graphics2D graphics;
        private BufferedImage output;

        public MyImage(Graphics2D graphics, BufferedImage output) {
            this.graphics = graphics;
            this.output = output;
        }

        public Graphics2D getGraphics() {
            return graphics;
        }

        public void setGraphics(Graphics2D graphics) {
            this.graphics = graphics;
        }

        public BufferedImage getOutput() {
            return output;
        }

        public void setOutput(BufferedImage output) {
            this.output = output;
        }

        public void setBackGround(Color color) {
            getGraphics().setColor(color);
            getGraphics().fillRect(0, 0, output.getWidth(), output.getHeight());
        }
    }

}
