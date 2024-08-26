import java.util.*;
import java.sql.*;
public class UserRegistration {
    private static final String url="jdbc:mysql://localhost:3306/productmanagement";
    private static final String user="root";
    private static final String pass="8956756238";

    public static void main(String[] args){
      Scanner sc=new Scanner(System.in);
      System.out.println("Enter your name: ");
      String name=sc.nextLine();
      System.out.println("Enter your email: ");
      String email=sc.nextLine();
      System.out.println("Enter your password: ");
      String password=sc.nextLine();
      System.out.println("Enter the verification code: ");
      String verification_code=sc.nextLine();

        try{
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
          try{
              Connection con =DriverManager.getConnection(url,user,pass);
              PreparedStatement pst=con.prepareStatement("insert into users(name,email,password,verification_code) values(?,?,?,?)");
              pst.setString(1,name);
              pst.setString(2,email);
              pst.setString(3,password);
              pst.setString(4,verification_code);
              pst.executeUpdate();
              System.out.println("User Registration Successful");
          } catch (SQLException e){
              System.out.println(e.getMessage());
          }


    }
}
