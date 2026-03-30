package 단순연결리스트;

import java.io.*;
import java.util.StringTokenizer;

public class assignment3
{
    public static class Node // 1
    {
        private int item;
        private Node next;

        public Node(int item, Node node)
        {
            this.item = item;
            this.next = node;
        }
        // 2
        public int getItem() {return item;}
        public Node getNext() {return next;}
        public void setItem(int item) {this.item = item;}
        public void setNext(Node node) {this.next = node;}
    }

    public static class sList
    {
        protected Node head;

        public sList()
        {
            head = null;
        }

        public void print()
        {
            Node cursor = head; // 3

            if(head == null)// 4
            {
                System.out.println("empty");
                return;
            }
            while (cursor != null) // 5
            {
                System.out.print(cursor.getItem() + " ");
                cursor = cursor.getNext(); // 6
            }
        }

        public void insert_inc(int newItem)
        {
            if(head == null) // 7
            {
                head = new Node(newItem, null); // 새 노드를 head로 지정.
                return;
            }
            else
            {
                Node cursor = head; // 8

                if(cursor.getItem() > newItem)// 9
                {
                    Node newNode = new Node(newItem, cursor);
                    head = newNode;
                    return;
                }

                while (cursor.getNext() != null) // 10
                {
                    if(cursor.getNext().getItem() > newItem) // 11
                    {
                        Node newNode = new Node(newItem, cursor.getNext());
                        cursor.setNext(newNode);
                        return;
                    }
                    cursor = cursor.getNext();
                }
                // 12
                    Node newNode = new Node(newItem, null);
                    cursor.setNext(newNode);
                    return;
            }

        }

        public void delete(int dItem)
        {
            while (head != null)
            {
                if(head.item == dItem)// 13
                {
                    head = head.getNext();
                }
                else
                {
                    break;
                }
            }
            if(head == null)
            {
                return;
            }

            Node cursor = head;

            while (cursor.getNext() != null) // 14
            {
                if(cursor.getNext().getItem() == dItem)
                {
                    cursor.setNext(cursor.getNext().getNext());
                }
                else
                {
                    cursor = cursor.getNext();
                }
            }

        }
    }

    public static void main(String[] args) throws IOException
    {
        try
        {
            File file = new File("단순연결리스트/test1.txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();

            while(line != null)
            {
                sList list = new sList();

                StringTokenizer st = new StringTokenizer(line);

                while (st.hasMoreTokens())
                {
                    list.insert_inc(Integer.parseInt(st.nextToken()));
                }

                list.print();
                System.out.println();

                line = br.readLine();
                st = new StringTokenizer(line);

                while (st.hasMoreTokens())
                {
                    list.delete(Integer.parseInt(st.nextToken()));
                }
                list.print();
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