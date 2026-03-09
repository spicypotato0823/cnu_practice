import java.io.*;
import java.util.StringTokenizer;

public class Main 
{
    public static void findPair(int arr[], int S) // 합이 S가 되는 원소 2개 찾기.
    {
        int i = 0; // i는 배열의 가장 앞 원소로 초기 설정.
        int j = arr.length - 1; //j는 배열의 가장 뒤 원소로 초기 설정
        int count = 2;//맨 처음 i와 j를 접근했기에 2로 초기 설정

        for(int t = 0; t < arr.length; t++) // for문 반복 횟수를 arr 배열 크기로 설정헤 가능한 S의 최댓값보다 크거나 작은 경우
        {
            int sum = arr[i] + arr[j];

            if(sum < S) // 두 원소를 더한 값이 S보다 작을 경우 i를 1더하기.
            {
                i++;
                count++;
            }
            else if(sum > S) // 두 원소를 더한 값이 S보다 클 경우 j를 1빼기.
            {
                j--;
                count++;
            }
            else // 두 원소의 합이 S가 되는 경우를 찾은 경우 즉시 종료.
            {
                break;
            }
        }
        if(i == j) // 합이 S가 되지 못하는 경우 i혹은 j의 값이 다른 하나의 값과 같아질 것이기에 no answer의 기준을 i == j로 설정
        {
            System.out.println("no answer");
            System.out.println("count: " + count);
        }
        else // 합이 S가 되는 경우 그 원소 값과 카운트 값 출력
        {
            System.out.println(arr[i] + " " + arr[j]);
            System.out.println("count: " + count);
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
            int [] num = new int[st.countTokens()]; // 배열의 크기를 st.countTokens값으로 설정.

            for(int i = 0; i < num.length; i++) 
            {
                num[i] = Integer.parseInt(st.nextToken()); // num 배열에 입력 값 저장.
            }
            
            line = br.readLine(); // 다음 줄 입력 받기
            int S = Integer.parseInt(line); // S값 입력 받기

            findPair(num, S); // findPair 함수에 num과 S값 입력.
            line = br.readLine(); // 다음 입력 값이 있을 경우 다음 루프 진행을 위해 wihle문 마지막에 한번 더 읽어주기.
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