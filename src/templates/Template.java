package templates;

import java.io.*;

public class Template {
    private String inputFile;

    public Template(String fileName) {
        this.inputFile = fileName;
    }

    public String getContent() {
        try {
            InputStream inputStream = getClass().getResourceAsStream(inputFile+".txt");
//            FileInputStream fis = new FileInputStream(this.file);
//            byte[] data = new byte[(int) this.inputStream.length()];
//            fis.read(data);
            String content;
            InputStreamReader isReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(isReader);
            StringBuffer stringBuffer = new StringBuffer();
            String string;
            while ((string = bufferedReader.readLine()) != null) {
                stringBuffer.append(string + '\n');
            }

            return stringBuffer.toString();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return "ooh";
        }
    }
}
