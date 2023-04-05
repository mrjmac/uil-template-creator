import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.io.FileWriter;


public class uil {
    public static void main(String args[]) throws IOException {

        // Grab the names of all dat files
        Path currentRelativePath = Paths.get("");
        File folder = new File(currentRelativePath.toAbsolutePath().toString());
        File[] files = folder.listFiles();

        // Grab the original code and prepare our additional string
        Path template = Path.of("uilTemplate.java");
        String code = Files.readString(template);

        //create starter files
        for (int i = 0; i < files.length; i++)
        {
            if (files[i].getName().indexOf("uil") != -1 || files[i].getName().startsWith(".") == true)
            {
                continue;
            }
            System.out.println(files[i].getName());
            FileWriter FileWriter = new FileWriter(files[i].getName().substring(0, 1).toUpperCase() + files[i].getName().substring(1, files[i].getName().length() - 4) + ".java", false);
            FileWriter.write(code.substring(0, code.indexOf("uil")) + files[i].getName().substring(0, files[i].getName().length() - 4) + code.substring(code.indexOf("uil") + 11, code.indexOf("File(") + 6) + files[i].getName() + "\"" + code.substring(code.indexOf("File(") + 7));
            FileWriter.close();
        }

        //win competition
    }
}