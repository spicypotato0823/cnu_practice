import java.io.*;
import java.util.StringTokenizer;

public class Main
{
    public static class Node
    {
        private int item;
        private Node next;

        public Node(int item, Node node)
        {
            this.item = item;
            this.next = node;
        }

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
            Node cursor = head;
            if(head == null)
            {
                System.out.println("empty");
                return;
            }
            while (cursor.next != null)
            {
                System.out.print(cursor.item + " ");
                cursor = cursor.next;
            }
            System.out.print(cursor.item + " ");

        }

        public void insert_inc(int newItem)
        {
            if(head == null) // node가 없을때
            {
                head = new Node(newItem, null);
                return;
            }

            else
            {
                Node cursor = head;

                if(cursor.item > newItem)//head 값보다 더 작은 수가 들어올 때
                {
                    Node newNode = new Node(newItem, cursor);
                    head = newNode;
                    return;
                }

                while (cursor.next != null) //head 다음 노드와 비교
                {
                    if(cursor.next.item > newItem)
                    {
                        Node newNode = new Node(newItem, cursor.next);
                        cursor.setNext(newNode);
                        return;
                    }
                    cursor = cursor.next;
                }

                    Node newNode = new Node(newItem, null);
                    cursor.setNext(newNode);
                    return;
            }

        }

        public void delete(int dItem)
        {
            while (head != null)
            {
                if(head.item == dItem)
                {
                    head = head.next;
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

            Node cursur = head;

            while (cursur.next != null)
            {
                if(cursur.next.getItem() == dItem)
                {
                    cursur.setNext(cursur.next.getNext());
                }
                else
                {
                    cursur = cursur.getNext();
                }
            }

        }
    }

    public static void main(String[] args) throws IOException
    {
        try
        {
            File file = new File("test1.txt");
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