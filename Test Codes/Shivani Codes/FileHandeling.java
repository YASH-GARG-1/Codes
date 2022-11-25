import java.io.*;

public class FileHandeling {
    public static void main(String[] args) {
        File f;
        FileWriter fw = null;
        FileReader fr = null;
        try{
            f = new File("D:\\pepcoding codes\\Codes\\Test Codes\\Shivani Codes\\sample.txt");
            fw = new FileWriter("sample.txt", true);
            fr = new FileReader("sample.txt");
            if(f.createNewFile())
            {
                System.out.println("New File created!!");
            }
            else
            {
                System.out.println("File already Exists!!");
            }

            if(f.exists())
            {
                System.out.println("Can we read the file : " + f.canRead());
                System.out.println("Length of the file is : "+ f.length());
            }
            else{
                System.out.println("File does not exists!!!");
            }
            System.out.println(f.getAbsolutePath());
            fw.write("\njava programming\n");
            // if (f.delete()) {
            //     System.out.println("File deleted successfully");
            // }
            // else {
            //     System.out.println("Failed to delete the file");
            // }
            int i = fr.read();
            while(i != -1)
            {
               System.out.print((char)i); 
               i = fr.read();
            }
        }
        catch(Exception e)
        {
            System.out.print("Exception occured!!");
        }
        finally
        {
            try{
                // fw.close();
                fr.close();
                fr.close();
            }
            catch(Exception e)
            {

            }
        }
        // f.close();
    }
}
