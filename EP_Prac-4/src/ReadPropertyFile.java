import java.io.FileInputStream;
import java.util.Properties;

public class ReadPropertyFile {
    public static void main(String[] args) throws Exception {
        Properties prop = new Properties();
        FileInputStream is = null;
        try {
            is = new FileInputStream("./config.properties");
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            prop.load(is);
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
