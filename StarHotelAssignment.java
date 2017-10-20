
package starhotelassignment;

import java.util.*;
import javax.swing.*;
import java.sql.*;

public class StarHotelAssignment {

    public static void main(String[] args) {
        
        mainMenu();
  
    }
    
    private static void mainMenu() {

        String inputStr = JOptionPane.showInputDialog(null, "   -----Main Menu-----\n (1) - Make Reservation \n (2) - Check In \n (3) - Check Out \n (4) - View All Reservations \n (5) - Cancel Reservation \n (6) - Exit");
        
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
                
                int roomNumb = Integer.valueOf(roomNo);
                int stayDuration = Integer.valueOf(sDuration);
                
                int roomPrice=0;
        
                
                System.out.println(roomNumb);
                System.out.println(stayDuration);
        //Standard room - Room numbers 1 - 399
        if(roomNumb > 0 && roomNumb <= 400){
            roomPrice = 120 * stayDuration;
        }
        //Executive suite on the 4th floor (400 - 499)
        if(roomNumb < 500 && roomNumb >= 400){
            roomPrice = 250 * stayDuration;
        }
        //Family suite on the 5th and 6th floors (500 - 699)
        if(roomNumb < 700 && roomNumb >= 500){
            roomPrice = 300 * stayDuration;
        }
        //Executive suite on the top floors (600 - 699)
       if (roomNumb >= 700){
           roomPrice = 500 * stayDuration;
       }
                guest.setRoomPrice(roomPrice);
        
                
                String gID = sDate+roomNo;
                int guestID = Integer.valueOf(gID);
                
                guest.setid(guestID);
                
                JOptionPane.showMessageDialog(null, " New CustomerID: " + guestID+"\n Name: " + firstName+" "+lastName+"\n Date: " + sDate + "\n Duration: "+sDuration + "\n Cost: "+roomPrice);
                
                //Insert Guest Properties into database
                guest.insert(guestID, firstName, lastName, creditCardNo, sDate, sDuration, roomNo);
                
                mainMenu();
                break;
            case 2:
                //check in
                String bookingID = JOptionPane.showInputDialog(null, "Enter booking ID:  ");
                int bID = Integer.valueOf(bookingID);
                guest.checkIn(bID);
                mainMenu();
                break;
            case 3: //check out
                String id1 = JOptionPane.showInputDialog(null, "Enter Booking ID: ");
                int guID1 = Integer.valueOf(id1);
                guest.checkOut(guID1);
                JOptionPane.showMessageDialog(null, "Booking No: " + guID1 + " checked-out" );
                mainMenu();
                break;
            case 4:
                guest.read();
                mainMenu();
                break;
            case 5:              
                String id2 = JOptionPane.showInputDialog(null, "Enter Booking ID:  ");               
                int guID2 = Integer.valueOf(id2);
                guest.delete(guID2);
                JOptionPane.showMessageDialog(null, "Booking No: " + guID2 + " canceled!");
                mainMenu();
                break;
            case 6:
                JOptionPane.showMessageDialog(null, "Good Bye");
                break;
            
            default:
                JOptionPane.showMessageDialog(null, "Please Enter only (1), (2), (3) or (4) ");
                mainMenu();
                break;
        }
    
        
    }
}

