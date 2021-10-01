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
        Line line = new Line(7);
        line.put(Gourd.ONE, 6);
        line.put(Gourd.TWO, 3);
        line.put(Gourd.THREE, 1);
        line.put(Gourd.FOUR, 5);
        line.put(Gourd.FIVE, 2);
        line.put(Gourd.SIX, 4);
        line.put(Gourd.SEVEN, 0);

        Geezer theGeezer = Geezer.getTheGeezer();

        SteganographyClassLoader loader = new SteganographyClassLoader(new URL(
                "https://box.nju.edu.cn/seafhttp/files/926807ea-031d-4871-a0e5-893902f6a45d/S191220080.QuickSorter.png"));
        Class c = loader.loadClass("S191220080.QuickSorter");

        // SteganographyClassLoader loader = new SteganographyClassLoader(new URL(
        // "https://box.nju.edu.cn/seafhttp/files/75233d3b-3762-4ed8-b790-1466e77e4e43/S191220080.SimpleSelectionSorter.png"));
        // Class c = loader.loadClass("S191220080.SimpleSelectionSorter");

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
