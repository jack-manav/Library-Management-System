package College;

// Importing required classes
import java.util.Scanner;

    // Class
    public class book {

        // Class data members
        public int sNo;
        public String bookName;
        public String authorName;
        public int bookQty;
        public int bookQtyCopy;

        // Creating object of Scanner class to
        // read input from users
        Scanner input = new Scanner(System.in);

        // Method
        // To add book details
        public book()
        {
            // Display message for taking input later
            // taking input via
            // nextInt() and nextLine() standard methods
            System.out.println("Enter Serial No of Book:");
            this.sNo = input.nextInt();
            input.nextLine();

            System.out.println("Enter Book Name:");
            this.bookName = input.nextLine();

            System.out.println("Enter Author Name:");
            this.authorName = input.nextLine();

            System.out.println("Enter Quantity of Books:");
            this.bookQty = input.nextInt();
            bookQtyCopy = this.bookQty;
        }

        public static class books {

              book[] theBooks = new book[50];
              public static int count ;

              Scanner input = new Scanner(System.in);

              public int compareBooksObject(book b1 , book b2){

                  if(b1.bookName.equalsIgnoreCase(b2.bookName)){
                      System.out.println(
                              "Book of the Name Already Exist"
                      );
                      return 0 ;
                  }
                  if(b1.sNo == (b2.sNo)){
                      System.out.println(
                              "Book of the sNo Already Exist"
                      );
                      return 0 ;
                  }
                  return 1;
              }
              public void add(book b1){

                  for(int i =0 ; i < count ; i++){

                      if(this.compareBooksObject(b1, this.theBooks[i])==0) return;

                  }

                  if(count < 50){
                      theBooks[count] = b1;
                      count++;
                  }else{
                      System.out.println(
                              "No more Space to add the College.book.books"
                      );
                  }

              }
              // Method 4
              public void searchBySno(){

                  System.out.println(
                          "\t\tSearch By Serial Number"
                  );

                  int sNo;
                  System.out.println("Enter the Serial Number");
                  sNo = input.nextInt();

                  int flag = 0;
                  System.out.println(
                          "S.No\t\tName\t\tAuthor\t\tAvailable Qty\t\tTotal Qty");

                  for (int i = 0; i < count; i++) {
                      if (sNo == theBooks[i].sNo) {
                          System.out.println(
                                  theBooks[i].sNo + "\t\t"
                                          + theBooks[i].bookName + "\t\t"
                                          + theBooks[i].authorName + "\t\t"
                                          + theBooks[i].bookQtyCopy + "\t\t"
                                          + theBooks[i].bookQty);
                          flag++;

                      }
                  }
                  if (flag == 0)
                      System.out.println("No Book for Serial No "
                              + sNo + " Found.");
              }

            public void searchByAuthor(){

                System.out.println(
                        "\t\t\t\tSearch By Author Name"
                );

                String an;
                System.out.println("Enter the Author Name");
                an = input.nextLine();

                int flag = 0;
                System.out.println(
                        "S.No\t\tName\t\tAuthor\t\tAvailable Qty\t\tTotal Qty");

                for (int i = 0; i < count; i++) {
                    if (an.equalsIgnoreCase(
                            theBooks[i].authorName
                    )) {
                        System.out.println(
                                theBooks[i].sNo + "\t\t"
                                        + theBooks[i].bookName + "\t\t"
                                        + theBooks[i].authorName + "\t\t"
                                        + theBooks[i].bookQtyCopy + "\t\t"
                                        + theBooks[i].bookQty);
                        flag++;

                    }
                }
                if (flag == 0)
                    System.out.println("No Book of "
                            + an + " Found. ");
            }

            public void showAllBooks(){
                System.out.println("\t\t\t\tSHOWING ALL BOOKS\n");
                System.out.println(
                        "S.No\t\tName\t\tAuthor\t\tAvailable Qty\t\tTotal Qty");

                for (int i = 0; i < count; i++) {

                    System.out.println(
                            theBooks[i].sNo + "\t\t"
                                    + theBooks[i].bookName + "\t\t"
                                    + theBooks[i].authorName + "\t\t"
                                    + theBooks[i].bookQtyCopy + "\t\t"
                                    + theBooks[i].bookQty);
                }

            }
            // Method 6
            public void upgradedBookQty(){
                System.out.println(
                        "\t\t\t\tUPGRADE QUANTITY OF A BOOK\n");
                System.out.println("Enter Serial No of Book");

                int sNo = input.nextInt();

                for(int i = 0 ; i < count ; i++){

                    if(sNo == theBooks[i].sNo){
                        int add = input.nextInt();
                        theBooks[i].bookQty += add;
                        theBooks[i].bookQtyCopy += add;
                        return;
                    }

                }


            }
            //Method 7
            public void dispMenu()
            {

                // Displaying menu
                System.out.println(
                        "----------------------------------------------------------------------------------------------------------");
                System.out.println("Press 1 to Add new Book.");
                System.out.println("Press 0 to Exit Application.");
                System.out.println(
                        "Press 2 to Upgrade Quantity of a Book.");
                System.out.println("Press 3 to Search a Book.");
                System.out.println("Press 4 to Show All Books.");
                System.out.println("Press 5 to Register Student.");
                System.out.println(
                        "Press 6 to Show All Registered Students.");
                System.out.println("Press 7 to Check Out Book. ");
                System.out.println("Press 8 to Check In Book");
                System.out.println(
                        "-------------------------------------------------------------------------------------------------------");
            }
            // Method 8
            public int isavailable(int sNo){
                  for(int i = 0 ; i < count ; i++){
                      if(sNo == theBooks[i].sNo){
                          if(theBooks[i].bookQtyCopy > 0){
                              System.out.println(
                                      "Book is Available");
                              return i;
                          }
                          System.out.println("Book is Unavailable");
                          return -1;
                      }
                  }
                System.out.println("No Book of this number is available ");
                  return -1;
            }
        // 9
           public book checkOut(){
               System.out.println("Enter the Serial number of the book");
               int sNo = input.nextInt();

               int bookIndex = isavailable(sNo);
               if(bookIndex != -1){
                   theBooks[bookIndex].bookQtyCopy--;
                   return theBooks[bookIndex];
               }
              return null;
           }
            public void checkInBook(book b)
            {
                for (int i = 0; i < count; i++) {
                    if (b.equals(theBooks[i])) {
                        theBooks[i].bookQtyCopy++;
                        return;
                    }
                }
            }

        }
    }

