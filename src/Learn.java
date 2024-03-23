import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class Learn {
    public static void main(String[] args) {
        File dir = new File("C:/Users/runor/Desktop/JavaJoker/");
        checkDirection(dir);
    }

    public static void isCreate(File dir){
        for(int i = 1; i <= 5; i++) {
            try {
                FileWriter joker = new FileWriter(dir.getAbsolutePath() + "\\"+ "joker" + i +".txt");
                joker.write("Joker");
                joker.close();
        }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void checkDirection(File dir) {
        if (dir.isDirectory()) {
            File[] files = dir.listFiles();
            isCreate(dir);
            assert files != null;
            for (File file : files) {
                checkDirection(file);
            }
        }
    }
}



