package 이중연결리스트;

import java.io.*;
import java.util.StringTokenizer;


public class Main
{
    public static class DNode
    {
        private int item;
        private DNode previous;
        private DNode next;

        DNode(int item, DNode p, DNode n)
        {
            this.item = item;
            this.previous = p;
            this.next = n;
        }
        public int getItem() {return item;}
        public DNode getPrevious() {return previous;}
        public DNode getNext() {return next;}
        public void setItem(int newItem) {item = newItem;}
        public void setPrevious(DNode p) {previous = p;}
        public void setNext(DNode n) {next = n;}

    }

    public static class DList
    {
        protected DNode head, tail;
        public DList()
        {
            head = null;
            tail = null;
        }

        public void print()
        {
            if(head == null)
            {
                System.out.println("empty");
                return;
            }
            DNode cursor = head;
            while (cursor != null)
            {
                System.out.print(cursor.getItem() + " ");
                cursor = cursor.getNext();
            }
            System.out.println();

        }
        public void insertFront(int X)
        {
            DNode newNode = new DNode(X, null,null);

            if(head == null)
            {
                head = newNode;
                tail = newNode;
                return;
            }
            newNode.setNext(head);
            head.setPrevious(newNode);
            head = newNode;
        }
        public void deleteFront()
        {
            if(head == null)
            {
                System.out.println("empty");
                return;
            }
            if(head.getNext() == null)
            {
                head = null;
                tail = null;
                return;
            }
            head = head.getNext();
            head.setPrevious(null);
        }
    }


    public static void main(String[] args) throws IOException
    {
        try
        {
            File file = new File("이중연결리스트/test.txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();

            while(line != null)
            {
                DList list = new DList();
                StringTokenizer st = new StringTokenizer(line);
                while (st.hasMoreElements())
                {
                    list.insertFront(Integer.parseInt(st.nextToken()));
                }
                list.print();

                list.deleteFront();
                list.deleteFront();

                list.print();

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