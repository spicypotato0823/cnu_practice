import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main 
{

    public static void call_to(int[] a, int i)// i => 출력해야 할 다음 값의 인덱스
    {
        if(a[i] == 0) // 종료 조건
        {
            System.out.println(i);
        }
        else
        {
            System.out.print(i + " "); //i 값을 먼저 출력
            call_to(a, a[i]);//인덱스 i가 가지고 있는 값을 i로 넣어 재귀함수 호출 
        }
    }

    public static void call_from(int[] a, int j)// j => 출력해야 할 마지막 값??
    {
        if(a[j] == 0) // 종료 조건
        {
            System.out.print(j + " ");// 0이 가장 먼저 출력 
        }
        else
        {
            call_from(a, a[j]);//출력하기 전에 재귀함수를 호출해 다음값으로 넘어가기
            System.out.print(j + " ");// 0이 출력된 후 그 다음 요소를 출력
        }
    }

    public static void main(String[] args) 
    {
        
        try
        {
        File file = new File("test.txt");
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
