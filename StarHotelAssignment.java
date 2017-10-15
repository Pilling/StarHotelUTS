
package starhotelassignment;

import java.util.*;
import javax.swing.*;
import java.sql.*;

public class StarHotelAssignment {

    public static void main(String[] args) {
        
        mainMenu();
  
    }
    
    private static void mainMenu() {

        String inputStr = JOptionPane.showInputDialog(null, "-----Main Menu-----\n (1) - Make Reservation \n (2) - Check In \n (3) - Check Out \n (4) - Cancel Reservation (5) - Exit");
        
        int choice = Integer.parseInt(inputStr);
        Guest guest = new Guest();

        switch(choice){
            case 1:                             
                String firstName = JOptionPane.showInputDialog(null, "Enter guest first name: ");               
                guest.setFirstName(firstName);
                
                String lastName = JOptionPane.showInputDialog(null, "Enter guest last name: ");
                guest.setLastName(lastName);
                
                String creditCardNo = JOptionPane.showInputDialog(null, "Enter Credit Card Number (10 digits):  ");
                guest.setCreditCardNo(creditCardNo);
                
                String sDate = JOptionPane.showInputDialog(null, "Enter Booking Start Date (ddmmyy):  ");
                guest.setsDate(sDate);
                
                String sDuration = JOptionPane.showInputDialog(null, "Enter Duration of Stay (1 to 7 days):  ");
                guest.setsDuration(sDuration);
                
                String roomNo = JOptionPane.showInputDialog(null, "Enter Room Number (3 digits):  ");
                guest.setRoomNo(roomNo);
                
                String gID = sDate+roomNo;
                int guestID = Integer.valueOf(gID);
                
                guest.setid(guestID);
                
                JOptionPane.showMessageDialog(null, " New CustomerID: " + guestID+"\n Name: " + firstName+" "+lastName+"\n Date: " + sDate + "\n Duration: "+sDuration);
                
                //Insert Guest Properties into database
                guest.insert(guestID, firstName, lastName, creditCardNo, sDate, sDuration, roomNo);
                
                mainMenu();
                break;
            case 2:
                //guest.checkIn();
                mainMenu();
                break;
            case 3:
                //guest.checkOut();
                mainMenu();
                break;
            case 4:
                //guest.delete();
                mainMenu();               
            case 5:
                JOptionPane.showMessageDialog(null, "Good Bye");
                break;
            default:
                JOptionPane.showMessageDialog(null, "Please Enter only (1), (2), (3) or (4) ");
                mainMenu();
                break;
        }
    
        
    }
}

