import java.util.Scanner;
public class MaxOfThree
{
 public static void main(String args[])
 {
 int max,a,b,c;
 Scanner scn=new Scanner(System.in);
 System.out.println("Enter the first number: ");
 a=scn.nextInt();
 System.out.println("Enter the second number: ");
 b=scn.nextInt();

 System.out.println("Enter the third number: ");
 c=scn.nextInt();

 max=a>b?(a>c?a:c):(b>c?b:c);
 System.out.println("\n The maximum number is " +max);
 }
}
