package parkinglot;
import java.sql.*;
import mycon.Myconn;
public class Car{
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    String sql;
    public boolean insertNewCar (CarDetails carDetails) throws Exception {
        sql = "insert into car values (?,?,?)";
        connection = Myconn.getConnection();
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, carDetails.slot_no);
        preparedStatement.setString(2, carDetails.reg_no);
        preparedStatement.setString(3, carDetails.color);
        return preparedStatement.executeUpdate() > 0;
    }
    public boolean deleteCar (int n) throws Exception {
        sql = "delete from car where slot_no="+n+"";
        connection = Myconn.getConnection();
        preparedStatement = connection.prepareStatement(sql);
        return preparedStatement.executeUpdate() > 0;
    }
    public void carDetails () throws Exception {
        sql = "select * from car";
        connection = Myconn.getConnection();
        Statement st = connection.createStatement();
        resultSet = st.executeQuery(sql);
        while(resultSet.next()){
            int slot_no=resultSet.getInt("Slot_no");
            String reg_no=resultSet.getString("Reg_no");
            String color=resultSet.getString("Color");
            
            System.out.format("%s, %s, %s\n", slot_no, reg_no, color);
        }
    }
    public void carDetailsColor (String color) throws Exception {
        sql = "select reg_no from car where color= "+color+"";
        connection = Myconn.getConnection();
        Statement st = connection.createStatement();
        resultSet = st.executeQuery(sql);
        while(resultSet.next()){
            String reg_no=resultSet.getString("Reg_no");
            
            System.out.format("%s, ", reg_no);
        }
    }
    public void carDetailsColor1 (String color) throws Exception {
        sql = "select slot_no from car where color= "+color+"";
        connection = Myconn.getConnection();
        Statement st = connection.createStatement();
        resultSet = st.executeQuery(sql);
        while(resultSet.next()){
            String slot_no=resultSet.getString("slot_no");
            
            System.out.format("%s, ", slot_no);
        }
    }
    public void carDetailsRegno (String reg_no) throws Exception {
        sql = "select slot_no from car where reg_no= "+reg_no+"";
        connection = Myconn.getConnection();
        Statement st = connection.createStatement();
        resultSet = st.executeQuery(sql);
        while(resultSet.next()){
            String slot_no=resultSet.getString("slot_no");
            
            System.out.format("%s, ", slot_no);
        }
    }
}