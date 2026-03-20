import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main 
{

    public static void call_to(int[] a, int i)// 1
    {
        if(a[i] == 0) // 2
        {
            System.out.println(i);
        }
        else
        {
            System.out.print(i + " "); // 3
            call_to(a, a[i]);// 4
        }
    }

    public static void call_from(int[] a, int j)// 5
    {
        if(a[j] == 0) // 6
        {
            System.out.print(j + " ");// 7
        }
        else
        {
            call_from(a, a[j]);// 8
            System.out.print(j + " ");// 9
        }
    }

    public static void main(String[] args) 
    {
        
        try
        {
        File file = new File("dataStructure/TEST.txt");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine();

        while(line != null) 
        {
            
            StringTokenizer st = new StringTokenizer(line);
            int [] num = new int[st.countTokens()]; 

            for(int i = 0; i < num.length; i++) 
            {
                num[i] = Integer.parseInt(st.nextToken());
            }

            call_to(num, 0);
            call_from(num, 0);
            System.out.println();

            line = br.readLine();
        }
        br.close();
    }
    catch(FileNotFoundException e)
    {
        System.out.println("file is not found");
    }   
    catch(IOException e)
    {
        System.out.println("I/O exception");
    }

    }
    
}
