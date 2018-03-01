/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket;

import java.util.ArrayList;

/**
 *
 * @author Luis G
 */
public class ticketModel {
    
    ArrayList<ticket> ticketDB = new ArrayList<ticket>();
    ticket currentTicket = new ticket();
    
    public void setCurrentTicket(ticket currTicket){
        currentTicket = currTicket;
        ticketDB.add(currentTicket);
    }
    
    public ticket getCurrentTicket(){
        return currentTicket;
    }
    
    public ArrayList<ticket> getCitations(){
        return ticketDB;
    }
    
}
