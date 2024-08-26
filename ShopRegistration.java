import java.util.*;
import java.sql.*;
public class ShopRegistration {
    private static final String url="jdbc:mysql://localhost:3306/productmanagement";
    private static final String user="root";
    private static final String pass="8956756238";

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Your Shop name: ");
        String name=sc.nextLine();
        System.out.println("Enter Your email: ");
        String email=sc.nextLine();
        System.out.println("Enter Your Password: ");
        String password=sc.nextLine();
        System.out.println("Enter verification code: ");
        String verification_code=sc.nextLine();
        try{
            Class.forName("com.mysql.jdbc.Driver");

        }
        catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        try{
            Connection con=DriverManager.getConnection(url,user,pass);
PreparedStatement ps=con.prepareStatement("insert into shopowners (name,email,password,verification_code) values(?,?,?,?)");
ps.setString(1,name);
ps.setString(2,email);
ps.setString(3,password);
ps.setString(4,verification_code);
ps.executeUpdate();
System.out.println("Shop Registration Successful");
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
