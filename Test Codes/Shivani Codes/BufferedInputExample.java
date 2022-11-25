import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class BufferedInputExample {
    public static void main(String[] args) {
        try{
            FileInutStream fis = new FileInputStream("sample.txt");
            BufferedInputStream bin = new BufferedInputStream(fis);
        }
        catch(Exception e)
        {

        }
    }
}
