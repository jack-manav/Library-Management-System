import College.book;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Displaying menu
        System.out.println(
                "********************Welcome to the GFG Library!********************");
        System.out.println(
                "                  Select From The Following Options:               ");
        System.out.println(
                "**********************************************************************");
        book.books ob = new book.books();

        students  obStudent = new students();

        int choice ;
        int searchChoice;

        do{
            ob.dispMenu();
            choice = input.nextInt();

            switch (choice){

                case 1:
                    book b = new book();
                    ob.add(b);
                    break;
                case 2:
                    ob.upgradedBookQty();
                    break;
                case 3:
                    System.out.println("Press 1 to search by serial Number");
                    System.out.println("Press 2 ro search by author name");
                    int sea = input.nextInt();
                    switch (sea){
                        case 1:
                            ob.searchBySno();
                            break;
                        case 2:
                            ob.searchByAuthor();
                    }
                    break;
                case 4:
                    ob.showAllBooks();
                    break;
                case 5:
                    student s = new student();
                    obStudent.addStudents(s);
                    break;
                case 6:
                    obStudent.showAllStudents();
                    break;
                case 7:
                    obStudent.checkOutBook(ob);
                    break;
                case 8:
                    obStudent.checkInBook(ob);
                    break;
                default:
                    System.out.println("Enter Between 0 and 8 ");
            }



        }while (choice != 0);

    }
}