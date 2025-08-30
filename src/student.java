import College.book;

import java.util.Scanner;

public class student {

    String studentName  ;
    String regNum ;

    book borrowedBooks[] = new book[3];
    public int booksCount  = 0;

    Scanner input = new Scanner(System.in);
    student(){

        System.out.println("Enter the Student name ");
        studentName = input.nextLine();
        System.out.println("Enter the registration Number");
        regNum = input.nextLine();
        System.out.println("Student is Register");

    }
}
