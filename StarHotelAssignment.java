package starhotelassignment;

import java.util.*;
import javax.swing.*;
import java.sql.*;

public class StarHotelAssignment {

   
    
   
    public static void main(String[] args) {
        
        
        mainMenu();
    }

    private static void mainMenu() {

        String inputStr = JOptionPane.showInputDialog(null, "-----Main Menu-----\n (1) - Make Reservation \n (2) - Check In \n (3) - Check Out \n (4) - Exit");
        
        int choice = Integer.parseInt(inputStr);
        Guest guest = new Guest();

        switch(choice){
            case 1:                             
                guest.makeReservation();
                mainMenu();
                break;
            case 2:
                guest.checkIn();
                mainMenu();
                break;
            case 3:
                guest.checkOut();
                mainMenu();
                break;
            case 4:
                break;
            default:
                JOptionPane.showMessageDialog(null, "Please Enter only (1), (2), (3) or (4) ");
                mainMenu();
                break;
        }
        
    }

}
