
package starhotelassignment;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.*;

public class Guest {
        int guestID, roomNo;
        String name, address, contactNo, bookingStart;
        Period bookingDuration;
        
        ArrayList custID = new ArrayList();

    public Guest() {
    }

    public Guest(int guestID, int roomNo, String bookingStart, String name, String address, String contactNo, Period bookingDuration) {
        this.guestID = guestID;
        this.roomNo = roomNo;
        this.bookingStart = bookingStart;
        this.name = name;
        this.address = address;
        this.contactNo = contactNo;
        this.bookingDuration = bookingDuration;
    }
        
    

    public int getGuestID() {
        return guestID;
    }

    public void setGuestID(int guestID) {
        this.guestID = guestID;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    public String getBookingStart() {
        return bookingStart;
    }

    public void setBookingStart(String bookingStart) {
        this.bookingStart = bookingStart;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public Period getBookingDuration() {
        return bookingDuration;
    }

    public void setBookingDuration(Period bookingDuration) {
        this.bookingDuration = bookingDuration;
    }

    @Override
    public String toString() {
        return "Guest{" + "guestID=" + guestID + ", roomNo=" + roomNo + ", bookingStart=" + bookingStart + ", name=" + name + ", address=" + address + ", contactNo=" + contactNo + ", bookingDuration=" + bookingDuration + '}';
    }

        public void makeReservation(){
             System.out.println("\n-----Make Reservation-----\n");
             
        
        //Enter guest details
        String firstName = JOptionPane.showInputDialog(null, "Enter guest first name: ");
        String lastName = JOptionPane.showInputDialog(null, "Enter guest last name: ");
         //input creditcard No
        String creditCardNo = JOptionPane.showInputDialog(null, "Enter Credit Card Number (10 digits):  ");
        
        //Check guest records in DB - must be 3 way match
        //if (record exists in DB){use alter records query)
       
        //else{use insert query}
            
        //input booking start date
        //Use calandar in GUI if possible
        String sDate = JOptionPane.showInputDialog(null, "Enter Booking Start Date (ddmmyy) : ");
        setBookingStart(sDate);
        
        //input booking duration
        String sDuration = JOptionPane.showInputDialog(null, "Enter Booking Duration (days) : ");

        //input room number
        String roomNo = JOptionPane.showInputDialog(null, "Enter Room Number (3 digits):  ");
        
        //Check room availability on this date
        //DB connection - do-while loop press 00 to exit loop and reenter booking date?
        
        //creation of customerID
        String customerID = sDate + roomNo;
        
        //custID.add(customerID);
        
        this.guestID = Integer.valueOf(customerID);
        
        try
            {
            Class.forName("org.sqlite.JDBC");
            System.out.println("DB connection made");
            }
        catch(Exception err)
            {
            
            System.out.println("Exception 1: "+err);
            }
        
        Connection conn = null;
      try
      {
          conn = DriverManager.getConnection("jdbc:sqlite:Example.db");
          System.out.println("Connected to example DB");
      }
      catch(SQLException s){
           System.out.println("Exception 1: "+s);
      }
       
        
        //Enter fields into DB
        JOptionPane.showMessageDialog(null, "New Customer ID: "+customerID+"\n Booking Duration: " +sDuration+" days\n Guest Name: " + firstName+" "+lastName);
        
        String insertSql = "INSERT INTO guest (id, FirstName, LastName, creditCardNo) VALUES ( '"+customerID+"' , '"+firstName+"' , '"+lastName+"' , '"+creditCardNo+"');";
            
            PreparedStatement p = null;
            ResultSet r = null;
        
        //insert entry into DB
         try
        {
  
            p=conn.prepareStatement(insertSql);
            p.clearParameters();
            
            r = p.executeQuery();
            
            //display info

            r.close();
            p.close();
            conn.close();
            
        }
        catch(SQLException x)
        {
            System.out.println("SQL exception: "+x);
        }
         
         }
        
        public void checkIn() {
   
        }
        
        public void checkOut(){
            
        }
        
        public void payBill(){
            
        }
}
