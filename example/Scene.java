package example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;

import example.classloader.SteganographyClassLoader;

public class Scene {

    public static void main(String[] args) throws Exception {

        Line line = new Line(7);
        line.put(Gourd.ONE, 6);
        line.put(Gourd.TWO, 3);
        line.put(Gourd.THREE, 1);
        line.put(Gourd.FOUR, 5);
        line.put(Gourd.FIVE, 2);
        line.put(Gourd.SIX, 4);
        line.put(Gourd.SEVEN, 0);

        Geezer theGeezer = Geezer.getTheGeezer();

        // SteganographyClassLoader loader = new SteganographyClassLoader(
        // new URL("https://cdn.njuics.cn/example.BubbleSorter.png"));

        // Class c = loader.loadClass("example.BubbleSorter");

        SteganographyClassLoader loader = new SteganographyClassLoader(new URL(
                "https://box.nju.edu.cn/seafhttp/files/a9399862-fcaa-42ae-81a6-e9a7966aaf22/example.SelectSorter.png"));

        Class c = loader.loadClass("example.SelectSorter");

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
