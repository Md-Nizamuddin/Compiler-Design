import java.io.*;

public class check2 {
    public static void main(String[] args)

    {

        // File Creation
        File file = new File("test.txt");
        try {
            if (file.createNewFile()) {
                System.out.println("File created : " + file.getName());
            } else {
                System.out.println("File already exists");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // File Writing
        try (FileWriter writer = new FileWriter("test.txt"))
        {   writer.write("How are you \n cool boi");
            System.out.println("File Written");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // File Reading
        try (BufferedReader reader = new BufferedReader(new FileReader("test.txt"))) 
        {
            String line;
            while((line = reader.readLine()) != null)
            {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //File Copying
        File sourceFile = new File("test.txt");
        File destFile = new File("test2.txt");
        try (FileInputStream inputStream = new FileInputStream(sourceFile);
            FileOutputStream outputStream = new FileOutputStream(destFile);)
            {
                byte[] buffer = new byte[1024];
                int length;
                while( (length = inputStream.read(buffer)) > 0)
                {
                    outputStream.write(buffer, 0, length);
                }
                System.out.println("File Copied Successfully");
            }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        if(file.delete())
            System.out.println("File deleted Successfully");
        else
            System.out.println("Error in file deletion");
    }
}
