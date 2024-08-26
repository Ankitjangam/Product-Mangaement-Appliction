import java.util.*;
import java.sql.*;
public class Products {
    private static final String url = "jdbc:mysql://localhost:3306/productmanagement";
    private static final String user = "root";
    private static final String pass = "8956756238";

    public static void product() {

        Scanner sc = new Scanner(System.in);
     while (true) {
      System.out.println();
      System.out.println("1. ViewProducts");
      System.out.println("2. My Profile");
      System.out.println("3. Exit");
      int choice = sc.nextInt();

          if (choice == 1) {
              ViewProducts();
          } else if (choice == 2) {
              MyProfile(null);
          } else if (choice == 3) {
              System.out.println("Exiting..........");
              System.exit(0);

          } else {
              System.out.println("Invalid choice");
          }
      

        try {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try{
            Connection con=DriverManager.getConnection(url,user,pass);
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public static void ViewProducts() {
        try {
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from products");
            System.out.println("Product list");
            while (rs.next()) {
                System.out.println("====================================================+");
                System.out.println("Product Id           :"+" "+rs.getString(1));
                System.out.println("----------------------------------------------------|");
                System.out.println("Product Name         :"+" "+rs.getString(2));
                System.out.println("----------------------------------------------------|");
                System.out.println("Product Description  :"+" "+rs.getString(3));
                System.out.println("----------------------------------------------------|");
                System.out.println("Product Price        :"+" "+rs.getString(4));
                System.out.println("====================================================+");
                System.out.println();
                System.out.println();

            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());

        }
    }
    protected static void MyProfile(Scanner sc) {
      System.out.println("Enter Registered Email: ");
       try {
           Connection con = DriverManager.getConnection(url, user, pass);
           Statement stmt = con.createStatement();
           ResultSet rs = stmt.executeQuery("select id, name,email from users where email='" + sc + "'");
           if (rs.next()) {
               System.out.println("My Profile");
               while (rs.next()) {
                   System.out.println("Id : "+rs.getString(1) + " " + "Name : "+rs.getString(2) + " " + "Email : "+rs.getString(3));
                   System.out.println();
                   System.out.println();
               }
           }else{
               System.out.println("invalid Email");
           }
       }
       catch (SQLException e) {
           System.out.println(e.getMessage());
       }
    }
}
