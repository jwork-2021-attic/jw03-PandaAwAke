package S191220080;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;

import S191220080.classloader.SteganographyClassLoader;


import S191220080.encoder.SteganographyEncoder;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class Scene {

    public static void main(String[] args) throws Exception {
        
        // // Generation

        // BufferedImage img;
        // SteganographyEncoder encoder;

        // img = ImageIO.read(new URL("https://box.nju.edu.cn/seafhttp/files/12f7d36d-aa23-4f1b-90e2-fb0ad9ee49d7/Picture.png"));
        // encoder = new SteganographyEncoder(img);
        // img = encoder.encodeFile(new File("S191220080/SimpleSelectionSorter.class"));
        // ImageIO.write(img, "png", new File("S191220080/SimpleSelectionSorter.png"));

        // img = ImageIO.read(new URL("https://box.nju.edu.cn/seafhttp/files/12f7d36d-aa23-4f1b-90e2-fb0ad9ee49d7/Picture.png"));
        // encoder = new SteganographyEncoder(img);
        // img = encoder.encodeFile(new File("S191220080/SwapBasedQuickSorter.class"));
        // ImageIO.write(img, "png", new File("S191220080/SwapBasedQuickSorter.png"));



        Line line = new Line(7);
        line.put(Gourd.ONE, 6);
        line.put(Gourd.TWO, 3);
        line.put(Gourd.THREE, 1);
        line.put(Gourd.FOUR, 5);
        line.put(Gourd.FIVE, 2);
        line.put(Gourd.SIX, 4);
        line.put(Gourd.SEVEN, 0);

        Geezer theGeezer = Geezer.getTheGeezer();

        SteganographyClassLoader loader = new SteganographyClassLoader(
                new URL("file:///C:/S191220080.SwapBasedQuickSorter.png"));
        
        Class c = loader.loadClass("S191220080.SwapBasedQuickSorter");


        Sorter sorter = (Sorter) c.newInstance();

        theGeezer.setSorter(sorter);

        String log = theGeezer.lineUp(line);

        BufferedWriter writer;
        writer = new BufferedWriter(new FileWriter("result.txt"));
        writer.write(log);
        writer.flush();
        writer.close();

    }

}
