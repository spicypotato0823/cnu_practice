package 스택;

import java.io.*;
import java.util.EmptyStackException;
import java.util.StringTokenizer;

public class Main
{
    public static class Node <E>
    {
        private E item;
        private Node<E> next;
        public Node(E newItem, Node<E> node)
        {
            item = newItem;
            next = node;
        }

        public E getItem() {return item;}
        public Node<E> getNext() {return next;}
        public void setItem(E newItem) {item = newItem;}
        public void setNext(Node<E> newNext) {next = newNext;}
    }

    public static class ListStack <E>
    {
        private Node<E> top;
        private int size;
        public ListStack()
        {
            top = null;
            size = 0;
        }
        public int size() {return size;}
        public boolean isEmpty() {return size == 0;}

        public void push(E newItem)
        {
            Node<E> newNode = new Node<>(newItem, top);
            top = newNode;
            size++;
        }
        public E pop()
        {
            if(isEmpty()) {
                throw new EmptyStackException();
            }
                E returnItem = top.getItem();
                top = top.getNext();
                size--;
                return returnItem;

        }
        public E peek()
        {
            if(isEmpty())
            {
                throw new EmptyStackException();
            }
            return top.getItem();
        }
    }
    public static int operation(int a, int b, String operator)
    {
        if(operator.equals("*")) return a * b;

        else if(operator.equals("/")) return a / b;

        else if(operator.equals("-")) return a - b;

        else return a + b;
    }

    public static int compareOperator(String op1, String op2)
    {
        int op1Num = 0;
        int op2Num = 0;

        if(op1.equals("*") || op1.equals("/")) op1Num = 2;

        else if(op1.equals("+") || op1.equals("-")) op1Num = 1;

        if(op2.equals("*") || op2.equals("/")) op2Num = 2;

        else if(op2.equals("+") || op2.equals("-")) op2Num = 1;

        return op1Num - op2Num;
    }

    public static int calc_infix(String s)
    {
        ListStack<Integer> operandList = new ListStack<Integer>();
        ListStack<String> operatorList = new ListStack<String>();
        StringTokenizer st = new StringTokenizer(s);
        int size = st.countTokens();

        for(int i = 0; i < size; i++)
        {
            String input = st.nextToken();
            int p;

            if(input.equals("(")) operatorList.push("(");

            else if(input.equals(")"))
            {
                while(!operatorList.peek().equals("("))
                {
                    int b = operandList.pop();
                    int a = operandList.pop();
                    p = operation(a, b, operatorList.pop());
                    operandList.push(p);
                }
                operatorList.pop();
            }
            else if(input.equals("*"))
            {
                if(!operatorList.isEmpty())
                {
                    if(compareOperator(input, operatorList.peek()) > 0)
                    {
                        operatorList.push("*");
                    }
                    else
                    {
                        int b = operandList.pop();
                        int a = operandList.pop();
                        p = operation(a, b, operatorList.pop());
                        operandList.push(p);
                        operatorList.push("*");
                    }
                }
                else
                {
                    operatorList.push("*");
                }
            }
            else if(input.equals("/"))
            {
                if(!operatorList.isEmpty())
                {
                    if(compareOperator(input, operatorList.peek()) > 0)
                    {
                        operatorList.push("/");
                    }
                    else
                    {
                        int b = operandList.pop();
                        int a = operandList.pop();
                        p = operation(a, b, operatorList.pop());
                        operandList.push(p);
                        operatorList.push("/");
                    }
                }
                else
                {
                    operatorList.push("/");
                }
            }
            else if(input.equals("+"))
            {
                if(!operatorList.isEmpty())
                {
                    if(compareOperator(input, operatorList.peek()) > 0)
                    {
                        operatorList.push("+");
                    }
                    else {
                        while (compareOperator(input, operatorList.peek()) <= 0 && operandList.size() >= 2) {
                            int b = operandList.pop();
                            int a = operandList.pop();
                            p = operation(a, b, operatorList.pop());
                            operandList.push(p);

                            if (operatorList.isEmpty()) {
                                break;
                            }
                        }
                        operatorList.push("+");
                    }
                }
                else
                {
                    operatorList.push("+");
                }
            }
            else if(input.equals("-"))
            {
                if(!operatorList.isEmpty())
                {
                    if(compareOperator(input, operatorList.peek()) > 0)
                    {
                        operatorList.push("-");
                    }
                    else
                    {
                        while (compareOperator(input, operatorList.peek()) <= 0 && operandList.size() >= 2) {
                            int b = operandList.pop();
                            int a = operandList.pop();
                            p = operation(a, b, operatorList.pop());
                            operandList.push(p);
                            if (operatorList.isEmpty()) {
                                break;
                            }
                        }
                        operatorList.push("-");
                    }
                }
                else
                {
                    operatorList.push("-");
                }
            }
            else
            {
                operandList.push(Integer.parseInt(input));
            }
        }

        while(!operatorList.isEmpty())
        {
            int b = operandList.pop();
            int a = operandList.pop();
            int p = operation(a, b, operatorList.pop());
            operandList.push(p);
        }
        return operandList.pop();
    }

    public static void main(String[] args) throws IOException
    {
        try
        {
            File file = new File("스택/test.txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();

            while(line != null)
            {
                System.out.println(calc_infix(line));
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
