import java.util.*;
class Main {
 static int top = -1,size=100;
 static char arr[] = new char[size];

 public static boolean isFull() {
    return (top==size) ? true : false;
 }

 public static boolean isEmpty() {
    return (top==-1) ? true : false;
 }

 public static void push(char v) {
      arr[++top] = v;
 }

 public static char pop() {
      char temp = arr[top];
      arr[top--]  = 0;
      return temp;
   }
 

 public static char peek() {
    return arr[top];
 }

 public static void display() {
     for(int i=top;i > -1;i--)
        System.out.println(arr[i]);
 }

 public static void main(String[] args) {
   Scanner kbd = new Scanner(System.in);
   try {
      System.out.print("Enter : ");
      String inp = kbd.nextLine();
      char temp;
      boolean interrupt = false;
      for(int i=0; !interrupt && i < inp.length(); i++) {
        temp = inp.charAt(i);
        if(temp == '(' || temp == '{' || temp == '[' || temp == '<') {
          if(isFull()) {
             System.out.println("ERROR OCCURRED : Stack overflow");
             interrupt = true;
          } 
          else 
            push(temp);
        }
        else if(temp == ')' || temp == '}' || temp == ']' || temp == '>') {
          if(isEmpty()) {
            System.out.println("ERROR OCCURRED : no value to pop");
            interrupt = true;
          }
          else {
            char peekedValue = peek();
            if((int)peekedValue == (int)temp-2 || (int)peekedValue == (int)temp-1) 
               pop();
            else {
               interrupt = true;
               System.out.println("Mismatching brackets");
            }
          }
        }
        else {
          System.out.println("ERROR OCCURRED : String contains invalid characters");
          interrupt = true;
        }
      }
      if(!interrupt)
         System.out.println("Successfull");
    } catch(Exception err) {
       System.out.print("Something went wrong");
    } 
 }   
}

