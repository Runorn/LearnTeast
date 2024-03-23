import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class FileVisitorLearn {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("C:\\Users\\runor\\Desktop\\JavaJoker");
        Files.walkFileTree(path, new MyFileVisitor());
    }
}

class MyFileVisitor implements FileVisitor<Path> {

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        System.out.println("Входим в директорию: " + dir);
        CreateFileJoker.createFiles(dir);
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        System.out.println("Имя файла: " + file.getFileName());
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        System.out.println("Ошибка при посещении файла: " + file.getFileName() + ", îøèáêà: " + exc.getMessage());  // Include error message
        return FileVisitResult.TERMINATE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        System.out.println("Выходим из директории: " + dir);
        return FileVisitResult.CONTINUE;
    }
}

class CreateFileJoker {
    public static void createFiles(Path dir) {
        for (int i = 1; i <= 5; i++) {
            Path filePath = dir.resolve("joker" + i + ".txt");
            try {
                Files.createFile(filePath);
                String code = "public class HelloWorld {\n"
                        + "    public static void main(String[] args) {\n"
                        + "        System.out.println(\"Hello World!\");\n"
                        + "    }\n"
                        + "}";
                Files.writeString(filePath, code);
            } catch (IOException e) {
                System.err.println("Ошибка создания файла error : " + filePath + ",ошибка: " + e.getMessage());
            }
        }
    }
}
