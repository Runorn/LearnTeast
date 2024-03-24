import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class FileVisitorLearn {
    public static void main(String[] args) throws IOException {
        String folderPath = "C:\\Users\\runor\\Desktop\\JavaJoker";
        Path path = Paths.get(folderPath);
        Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult preVisitDirectory (Path dir, BasicFileAttributes attrs) throws IOException {
                createFiles(dir);
                return FileVisitResult.CONTINUE;
            }
        });
    }
    public static void createFiles(Path dir) {
        int NUMBER_OF_JOKES_IN_DIRECTORY = 5;
        String code = """
                public class HelloWorld {
                    public static void main(String[] args) {
                        System.out.println("Hello World!");
                    }
                """;
        for (int i = 1; i <= NUMBER_OF_JOKES_IN_DIRECTORY; i++) {
            Path filePath = dir.resolve("joker" + i + ".txt");
            try {
                Files.createFile(filePath);
                Files.writeString(filePath, code);
            } catch (IOException e) {
                System.err.println("Ошибка создания файла error : " + filePath + ",ошибка: " + e.getMessage());
            }
        }
    }
}

