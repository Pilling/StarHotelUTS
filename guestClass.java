
package starhotelassignment;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.*;

public class Guest {

        int id;
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
        String sql = "INSERT INTO guest (id, FirstName, LastName, creditCardNo, startDate, startDuration, roomNo)"
                + "VALUES('"+this.id+"','"+this.firstName+"','"+this.lastName+"','"+this.creditCardNo+"','"+this.sDate+"','"+this.sDuration+"','"+this.roomNo+"');";
       
   
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
        
