//Kevin Soutar
//CMP 128
//Final Project
//December 9 2019

import javax.swing.*;                                                                                                   //inport for all java util

import modules.java;

enum TopLevelOption {                                                                                                   //enum that controls the joption pane
    REPORTS("Generate Reports"),                                                                                        //generate reports enum
    TICKETS("Sell Tickets"),                                                                                            //generate tickets enum
    LISTINGS("Set Movie Listings"),                                                                                     //colect listings enum
    EXIT("Exit");                                                                                                       //exit enum

    private String name;                                                                                                //string name for joption pane
    public String toString() { return name; }                                                                           //converts string to enum name (allows you to not have to do string conversion
    TopLevelOption(String name) {
        this.name = name;
    }
}

public class Main                                                                                                       //public class
{
    public static void main(String[] args)
    {
        final double ADULT_REGULAR = 12.50;                                                                             //FINAL adult regular ticket price
        final double CHILD_REGULAR = 9.50;                                                                              //FINAL child regular ticket price
        final double ADULT_MATINEE = 9.50;                                                                              //FINAL adult matinee ticket price
        final double CHILD_MATINEE = 6.50;                                                                              //FINAL child matinee ticket price

        double totalticketsdollars =0;                                                                                  //double that shows how many tickets in dollars have been sold
        double currentprice=0;                                                                                          //double that shows how many tickets in dollars are being sold

        int adultTickets = 0;                                                                                           //# of adult tickets, reset every time that enum tickets successfully runs
        int childTickets = 0;                                                                                           //# of child tickets, reset every time that enum tickets successfully runs
        int adultTickets1 = 0;                                                                                          //# of tickets, running total, outputs when enum reports successfully runs
        int childTickets1 = 0;                                                                                          //# of tickets, running total, outputs when enum reports successfully runs
        int NUM_MOVIES = 5;                                                                                             //# of movies that can be showing at any time
        int n=2;                                                                                                        //variable that controls if statement in tickets
        int n1=2;                                                                                                       //variable that controls next if statement in tickets
        int n2=2;                                                                                                       //variable that controls next last statement in tickets

        String[] movies = new String[NUM_MOVIES];                                                                       //array that controls movie entries and # of movies playing

        while (true)                                                                                                    //while statement that controls main joption pane selection
        {
            TopLevelOption option = (TopLevelOption) JOptionPane.showInputDialog(null,
                    "What would you like to do?",
                    "Super Fancy Ticketing Machine", JOptionPane.QUESTION_MESSAGE, null,
                    TopLevelOption.values(), TopLevelOption.TICKETS);                                                   //Joption pane that controls where you go in the program

            if (option == null) {                                                                                       //if statement that sees weather output = null
                option = TopLevelOption.EXIT;                                                                           //Option that moves you to exit if you try to exit cancel or hit x.
            }

            switch (option)                                                                                             //switch statement that runs based on the output of the joption pane and enum
            {
                case REPORTS: {                                                                                         //Switch case for enum reports
                    modules.calcTicketSale(adultTickets,childTickets,movies,totalticketsdollars);                       //modules that controls reports
                    break;
                }
                case TICKETS: {                                                                                         //switch case for enum tickets
                    n = modules.ticketinput2(n, movies);                                                                //shows the movies to chose from

                    adultTickets1=0;                                                                                    //sets ticket sales to 0 before running tickets
                    childTickets1=0;                                                                                    //sets ticket sales to 0 before running tickets
                    currentprice=0;                                                                                     //sets ticket price to 0 before running tickets

                    do {                                                                                                // do while loop that controls how many times you sell tickets before ending
                    n1 = modules.ticketinput1(n1);                                                                      //module in tickets that asks which tickets you want to sell

                    if (n1 == 0) {                                                                                      //if statement based on output of the ticketsinput1 module
                        adultTickets1 = modules.ticketinput0(adultTickets1);                                            //module that asks the user to input the number of tickets they want, outputs back to the adult tickets1
                    }
                    if (n1 == 1) {                                                                                      //if statement based on output of the ticketsinput1 module
                        childTickets1 = modules.ticketinput0(childTickets1);                                            //module that asks the user to input the number of tickets they want, outputs back to the adult tickets1
                    }
                    n2=modules.ticketyesno();                                                                           //tells the while statement weather or not to continue or final
                    }while (n2==0);                                                                                     //end of while statement, determines weather to continue or move on

                    adultTickets=adultTickets+adultTickets1;                                                            //calculation that adds the current ticket sales to the running total
                    childTickets=childTickets+childTickets1;                                                            //calculation that adds the current ticket sales to the running total

                    currentprice=modules.calcticketprice(n,adultTickets1,childTickets1,ADULT_REGULAR,                   //calculate price method from file modules.java
                            ADULT_MATINEE,CHILD_REGULAR,CHILD_MATINEE);
                    totalticketsdollars=totalticketsdollars+currentprice;                                               //calculation that adds the curent ticket sales in dollars to the running total
                            break;
                    }

                case LISTINGS: {                                                                                        //switch case for enum listings
                    modules.listings(movies);                                                                           //modules that pulls from file modules.java
                    break;
                }
                case EXIT: {                                                                                            //switch case for enum exit
                    modules.exit();                                                                                     //output module that pulls from file modules.java
                    }
            }
        }
    }
}