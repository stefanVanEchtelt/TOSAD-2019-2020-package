import java.io.File;
import java.io.FileInputStream;

public class Template {
    private File file;

    public Template(String fileName) {
        this.file = new File("src/templates/" + fileName + ".txt");
    }

    public String getContent() {
        try {
            FileInputStream fis = new FileInputStream(this.file);
            byte[] data = new byte[(int) this.file.length()];
            fis.read(data);
            fis.close();

            return new String(data, "UTF-8");
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return "";
        }
    }
}
