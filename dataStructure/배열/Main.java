import java.io.*;
import java.util.StringTokenizer;

public class Main 
{
    public static int[] findPair(int arr[], int S) 
    {
        int i = 0; // 1
        int j = arr.length - 1; // 2
        int count = 2;// 3

        while(i < j) // 4
        {
            int sum = arr[i] + arr[j];

            if(sum < S) // 5
            {
                i++;
                count++;
            }
            else if(sum > S) // 6
            {
                j--;
                count++;
            }
            else // 7
            {
                break;
            }
        }

        if(i == j) // 8
        {
            int [] arrReturn = {-1, -1 , count}; // 9
            return arrReturn; 
        }
        else // 10
        {
            int [] arrReturn = {arr[i], arr[j] ,count}; // 11
            return arrReturn;
        }
    }

    public static void main(String[] args) throws  IOException
    {
        try
        {
        File file = new File("test.txt");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine();

        while(line != null) 
        {

            StringTokenizer st = new StringTokenizer(line, " ");
            int [] num = new int[st.countTokens()]; // 1

            for(int i = 0; i < num.length; i++) 
            {
                num[i] = Integer.parseInt(st.nextToken()); // 2
            }
            
            line = br.readLine(); // 3
            int S = Integer.parseInt(line); // 4

            int [] arr = findPair(num, S); // 5

            if(arr[0] == -1 && arr[1] == -1)// 6
            {
                System.out.println("no answer");
                System.out.println("count: " + arr[2]);
            }
            else// 7
            {
                System.out.println(arr[0] + " " + arr[1]);
                System.out.println("count: " + arr[2]);
            }
            
            line = br.readLine(); // 8
        }
        
        br.close();



    }   catch(FileNotFoundException e)
    {
        System.out.println("file is not found");
    }   catch(IOException e)
    {
        System.out.println("I/O exception");
    }

    
    }
}