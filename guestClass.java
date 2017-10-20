
package starhotelassignment;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.*;
import java.sql.*;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class Guest {

        int id, roomPrice;
        String firstName, lastName, creditCardNo, sDate, sDuration, roomNo, customerID;
        Period bookingDuration;

    public Guest() {
    }

    public Guest(int id, String firstName, String lastName, String creditCardNo, String sDate, String sDuration, String roomNo, String customerID, Period bookingDuration) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.creditCardNo = creditCardNo;
        this.sDate = sDate;
        this.sDuration = sDuration;
        this.roomNo = roomNo;
        this.customerID = customerID;
        this.bookingDuration = bookingDuration;
    }

    public int getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(int roomPrice) {
        this.roomPrice = roomPrice;
    }

    public int getid() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCreditCardNo() {
        return creditCardNo;
    }

    public void setCreditCardNo(String creditCardNo) {
        this.creditCardNo = creditCardNo;
    }

    public String getsDate() {
        return sDate;
    }

    public void setsDate(String sDate) {
        this.sDate = sDate;
    }

    public String getsDuration() {
        return sDuration;
    }

    public void setsDuration(String sDuration) {
        this.sDuration = sDuration;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public Period getBookingDuration() {
        return bookingDuration;
    }

    public void setBookingDuration(Period bookingDuration) {
        this.bookingDuration = bookingDuration;
    }

    //Insert Guest information
    public void insert(int id, String firstName, String lastName, String creditCardNo, 
        String sDate, String sDuration, String roomNo){
        
        String sql = "INSERT INTO guest (id, FirstName, LastName, creditCardNo, startDate, startDuration, roomNo, bill)"
                + "VALUES('"+this.id+"','"+this.firstName+"','"+this.lastName+"','"+this.creditCardNo+"','"+this.sDate+"','"+this.sDuration+"','"+this.roomNo+"','"+this.roomPrice+"');";
        //'"+id+"', '"+firstName+"', '"+lastName+"');
        
        Connection conn = null;
        Statement stmt = null;
        
        try{
            //Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:C://Users//Jayden//Desktop//sqlite-tools-win32-x86-3200100/Example.db");
            conn.setAutoCommit(false);
            System.out.println("Opened DB");
            
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            
            stmt.close();
            conn.commit();
            conn.close();
        }
        catch(SQLException e){
            System.out.println(e);
        }

    }
    
    public void delete(int id){
        String sql = "DELETE FROM guest WHERE id = " + id + ";";
        
        Connection conn = null;
        Statement stmt = null;
        
        try{
            //Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:C://Users//Jayden//Desktop//sqlite-tools-win32-x86-3200100/Example.db");
            conn.setAutoCommit(false);
            System.out.println("Opened DB");
            
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            
            stmt.close();
            conn.commit();
            conn.close();
        }
        catch(SQLException e){
            System.out.println(e);
        }
        
        
    }
    
    public void read(){
     try{  
        String sql = "SELECT * FROM guest";
        
        Connection conn = null;
        Statement stmt = null;

        ResultSet rs = stmt.executeQuery(sql);     

        JTable table = new JTable(buildTableModel(rs));
        
        JOptionPane.showMessageDialog(null, new JScrollPane(table));
        
            //Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:C://Users//Jayden//Desktop//sqlite-tools-win32-x86-3200100/Example.db");
            conn.setAutoCommit(false);
            System.out.println("Opened DB");
            
            stmt = conn.createStatement();
            
            
            stmt.close();
            conn.commit();
            conn.close();
        }
        catch(SQLException e){
            System.out.println(e);
        }
         
         
         
    }

    public static DefaultTableModel buildTableModel(ResultSet rs) 
            throws SQLException 
    {
        ResultSetMetaData metaData = rs.getMetaData();
        
        //names of colums
        Vector<String> columnNames = new Vector<String>();
        int columnCount = metaData.getColumnCount();
        for (int column = 1; column <= columnCount; column++){
            columnNames.add(metaData.getColumnName(column));
        }
        
        //data of the table
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        while(rs.next()){
            Vector<Object> vector = new Vector<Object>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++){
                vector.add(rs.getObject(columnIndex));
            }
            data.add(vector);
        }
       
        return new DefaultTableModel(data, columnNames);
    }
    
    public void checkOut(int id){
        String sql = "DELETE FROM guest WHERE id = " + id + ";";
        
        Connection conn = null;
        Statement stmt = null;
        
        try{
            //Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:C://Users//Jayden//Desktop//sqlite-tools-win32-x86-3200100/Example.db");
            conn.setAutoCommit(false);
            System.out.println("Opened DB");
            
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            
            stmt.close();
            conn.commit();
            conn.close();
        }
        catch(SQLException e){
            System.out.println(e);
        }
        
        
    }
    
    
    public void checkIn(int id){
        
        
        String sql = "update guest set status = 'arrived' where id = " + id +";";
        
        Connection conn = null;
        Statement stmt = null;
        
        try{
            //Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:C://Users//Jayden//Desktop//sqlite-tools-win32-x86-3200100/Example.db");
            conn.setAutoCommit(false);
            System.out.println("Opened DB");
            
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            
            stmt.close();
            conn.commit();
            conn.close();
        }
        catch(SQLException e){
            System.out.println(e);
        }
        
    }
    
    
}
     
