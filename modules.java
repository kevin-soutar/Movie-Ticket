//Kevin Soutar
//CMP 128
//Final Project
//December 9 2019

import javax.swing.*;                                                                                                   //inport for java until
import java.awt.*;                                                                                                      //inport for java Abstract Window Toolkit
import java.util.Arrays;                                                                                                //inport for java arrays

public class modules {                                                                                                  //main class
    public static int ticketinput2(int ninput, String[] moviesin) {                                                     //module that asks what movie that you would to see, takes in movie titles from sting, also asks fi you want to buy matinee or regular tickets.
        String nn = (String) JOptionPane.showInputDialog(null,
                "What Movie would you like to See?",
                "Sell Tickets", JOptionPane.QUESTION_MESSAGE, null, moviesin, moviesin);                                //module that asks what movie you would like to see based on string array

        Object[] options = {"Matinee",                                                                                  //object array that displays answers for the next joption pane
                "Regular"};

        Component frame = null;
        ninput = JOptionPane.showOptionDialog(frame,                                                                    //joption pane that asks what type of tickets you would like to buy, then outputs it
                "What type of tickets would you like to buy?",
                "Sell Tickets",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,     //do not use a custom Icon
                options,  //the titles of buttons
                options[0]); //default button title
        return ninput;                                                                                                  //returns output from last joption pane
    }
    public static int ticketinput1(int n1input) {                                                                       //module that determins weather you are buying for an adult or a child
        Object[] options2 = {"Adult",                                                                                   //object array for joption pane
                "Child"};

        Component frame1 = null;
        n1input = JOptionPane.showOptionDialog(frame1,                                                                  //joption pane that takes in the object array, then outpust the result to n1input
                "What type of tickets would you like to buy?",
                "Sell Tickets",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,     //do not use a custom Icon
                options2,  //the titles of buttons
                options2[0]); //default button title
        return n1input;                                                                                                 //returns n1input to main method
    }
    public static void listings(String[] moviesin) {                                                                    //module that allows you to enter listings into the string array
        for (int i = 0; i < moviesin.length; ++i) {                                                                     //for statement that controls how many movies you can enter
            moviesin[i] = JOptionPane.showInputDialog("Enter Movie Number " + (i + 1));                                 //joption pane that allows you to enter movies into string array
        }
    }
    public static void exit() {                                                                                         //module that allows you to exit, promts you any way you try to exit
        int response = JOptionPane.showConfirmDialog(null,
                "Are you sure that you would like to Exit?  This means that all your data," +
                        " including movies will be lost?", "Exit",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);                                               //joption pane that confirms that you want to exit before exiting
        if (response == JOptionPane.YES_OPTION) {                                                                       //if statement that = yes or no
            System.exit(0);                                                                                             //if response = yes, program exits with 0, otherwise you go back to where you were
        }
    }
    public static int ticketinput0(int ticketinput) {                                                                   //module that controlls how many tickets are bing sold, adds existing tickets to new tickets
        int ticket = 0;                                                                                                 //integer tht controlls how many tickets are being sold

        String tickets;                                                                                                 //string that recives the tickets from joption pane

        tickets = JOptionPane.showInputDialog(
                "How Many Tickets would you like to sell?");                                                            //Joptionane for entering how many tickets you want to buy
        ticket = Integer.parseInt(tickets);                                                                             //parce int that takes string and makes it in to an integer

        if (ticket >= 0) {                                                                                              //if statement that prompts if you have a negative #
            ticket = ticketinput + ticket;                                                                              //takes the ticket input and adds it to running total
        } else {
            System.out.println("Error, Please restart program and enter positive numer!");                              //println that tells you to enter positive number
            tickets = JOptionPane.showInputDialog(
                    "How Many Adult Tickets would you like to sell?");                                                  //Joptionane for rentering how many tickets you want to buy
            ticket = Integer.parseInt(tickets);                                                                         //parce int that takes string and makes it in to an integer
        }
        return ticket;                                                                                                  //returns the total tickets
    }
    public static void calcTicketSale(int adultTicketsin, int childTicketsin, String[] moviesin,double dollarsin) {                      //takes the amount of adult tickets and the number of child tickets in, also takes the array string, and takes the total amount of money
        int ticketstotal;                                                                                               //integer for tickets total
        ticketstotal = adultTicketsin + childTicketsin;                                                                 //adds up all tickets to create total tickets for reports

        JFrame parent = new JFrame();                                                                                   //jframe that creates for joption pane

        JOptionPane.showMessageDialog(parent, "These Movies are playing" + Arrays.toString(moviesin)+
                "\nyou sold " + ticketstotal + " Tickets  They cost $ "+ dollarsin +"\nYou sold " + adultTicketsin +
                " Adult Tickets"+ "\nYou sold " + childTicketsin +
                " Child Tickets");                                                                                      //joption pane that outputs the report to the user with all data on seperate lines
    }
    public static double calcticketprice(int typeofticket, int adultticketsin, int childticketsin,
                                         double adultregularin, double adultmatineein,
                                         double childregularin, double childmatineein) {                                //module that takes in data then determines how much you have to pay for the tickets

        double total = 0;                                                                                               //double that sets the total to 0 when method is initiated

        if (typeofticket == 1) {                                                                                        //if statement that runs method ticketprice based on the type of ticket, and what values are brought in
            total=ticketprice(adultticketsin, adultregularin, childticketsin, childregularin);                          //runs method ticket price
        }
        if (typeofticket == 0) {                                                                                        //if statement that runs method ticketprice based on the type of ticket, and what values are brought in
            total=ticketprice(adultticketsin, adultmatineein, childticketsin, childmatineein);                          //runs method ticketprice
        }
        JFrame parent = new JFrame();                                                                                   //new jframe for joptionpane
        JOptionPane.showMessageDialog(parent, "Your total is $" +total);                                                //joptionpane that displays total
        return total;                                                                                                   //return total to main method
    }
    public static double ticketprice(int adultticket, double adultprice, int childticket, double childprice) {          //method that determines price based on calcticketprice if statement
        double priceoutput;                                                                                             //double that initializes priceoutput
        priceoutput = (adultticket * adultprice) + (childticket * childprice);                                          //calculation for total output cost
        return priceoutput;                                                                                             //returns double cost in dollars
    }
    public static int ticketyesno() {                                                                                   //method that takes in nothing, but outputs n1input back to the main method
        int n1input;                                                                                                    //integer initialies m1input

        Object[] options2 = {"Yes",
                "No"};                                                                                                  //object array the is used by joption pane

        Component frame1 = null;
        n1input = JOptionPane.showOptionDialog(frame1,                                                                  //joption pane dialog that asks the user if they would like to by more tickets
                "would you like to purchase more tickets?",
                "Sell Tickets",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,     //do not use a custom Icon
                options2,  //the titles of buttons
                options2[0]); //default button title
        return n1input;                                                                                                 //returns output from joption pane
    }
}