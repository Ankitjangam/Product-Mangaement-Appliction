import java.sql.*;
import java.util.Scanner;

public class ShopLogin {
        private static final String url = "jdbc:mysql://localhost:3306/productmanagement";
        private static final String user = "root";
        private static final String pass= "8956756238";
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter your Email: ");
            String email = sc.nextLine();
            System.out.println("Enter your Password: ");
            String password = sc.nextLine();
            try{
                Class.forName("com.mysql.jdbc.Driver");
            }
            catch(ClassNotFoundException e){
                System.out.println(e.getMessage());
            }

            try{
                Connection con= DriverManager.getConnection(url,user,pass);
                PreparedStatement pst=con.prepareStatement("select * from shopowners where email = ? and password = ?");
                pst.setString(1,email);
                pst.setString(2,password);
                ResultSet rs=pst.executeQuery();
                if(rs.next()){
                    System.out.println("Login Success");
                    Products.product();
                } else {
                    System.out.println("Invalid Email or Password");
                }
            }
            catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }
    }


