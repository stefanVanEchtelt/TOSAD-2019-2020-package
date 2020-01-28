package templates;

import java.io.*;

public class Template {
    private String inputFile;

    public Template(String fileName) {
        this.inputFile = fileName;
    }

    public String getContent() {
        // get content of the inputFile
        try {
            InputStream inputStream = getClass().getResourceAsStream(inputFile+".txt");
            InputStreamReader isReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(isReader);
            StringBuffer stringBuffer = new StringBuffer();
            String string;
            while ((string = bufferedReader.readLine()) != null) {
                stringBuffer.append(string + '\n');
            }

            return stringBuffer.toString();
        } catch (Exception exception) {
            exception.printStackTrace();
            return "ooh";
        }
    }
}
