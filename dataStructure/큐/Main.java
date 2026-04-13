package 큐;

import java.util.NoSuchElementException;
import java.io.*;
import java.util.StringTokenizer;

public class Main
{
    public static class Node <E>
    {
        private E item;
        private Main.Node<E> next;

        public Node(E newItem, Main.Node<E> node)
        {
            item = newItem;
            next = node;
        }

        public E getItem() {return item;}
        public Node<E> getNext() {return next;}
        public void setItem(E newItem) {item = newItem;}
        public void setNext(Node<E> newNext) {next = newNext;}
    }

    public static class CListQueue
    {
        private Node <Integer> last;

        public CListQueue()
        {
            last = null;
        }
        public void add(int newItem)
        {
            if(last == null)
            {
                Node<Integer> newNode = new Node<Integer>(newItem, null);
                last = newNode;
                last.setNext(last);
                return;
            }
            else
            {
                Node<Integer> newNode = new Node<Integer>(newItem, last.getNext());
                last.setNext(newNode);
                last = newNode;
            }
        }

        public void remove()
        {
            if(last == null)
            {
                System.out.println("Queue is empty");
                return;
            }
            else if(last.getNext() == last)
            {
                last = null;
                return;
            }
            else
            {
                last.setNext(last.getNext().getNext());
                return;
            }
        }
        public void print()
        {
            if(last == null)
            {
                System.out.println("Queue is empty!");
                return;
            }
            Node <Integer> cursor = last;
            do
            {
                System.out.print(cursor.getItem() + " ");
                cursor = cursor.getNext();

            }while(cursor != last);
            System.out.println();
        }

    }
    public static void main(String[] args) throws IOException
    {
        try
        {
            File file = new File("큐/test.txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String line = br.readLine();
            CListQueue cq = new CListQueue();
            while(line != null)
            {
                StringTokenizer st = new StringTokenizer(line);

                while (st.hasMoreTokens())
                {
                    int item = Integer.parseInt(st.nextToken());
                    cq.add(item);
                }
                cq.print();
                cq.remove();
                cq.remove();
                cq.remove();
                cq.print();

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
