/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author Luis G
 */
public class ticketController {
    
    ticketModel tickModel;
    ticketView tickView;
    
    public ticketController(ticketModel tModel, ticketView tView){
        this.tickModel = tModel;
        this.tickView = tView;
        attachHandlers();
    }
    
    public void attachHandlers(){
        
        //adds a citation to a ticket list
        tickView.getAdd().setOnAction(
                new EventHandler<ActionEvent>()
                {    
                @Override
                public void handle(ActionEvent event) 
                {
                    String permitNo = tickView.getPermitNo().getText();
                    String vehicleMake = tickView.getVehicleMake().getText();
                    String vehicleModel = tickView.getVehicleModel().getText();
                    String color = tickView.getColor().getText();
                    String violationType = tickView.getViolationType().getText();
                    String date = tickView.getDate().getText();
                    String location = tickView.getLocation().getText();
                    String time = tickView.getTime().getText();
                    String issuedBy = tickView.getIssuedBy().getText();
                    String liscenseNo = tickView.getLiscenseNo().getText();
                    String state = tickView.getState().getText();
                    String check = "No";
                    
                    ticket cit = new ticket(permitNo, vehicleMake, vehicleModel, color, violationType, date,
                                            location, time, issuedBy, liscenseNo, state, check);
                    
                    
                    tickModel.setCurrentTicket(cit);
                    tickView.updateList(tickView.getIndex());
                } 
            }
        );
        //goes back 1 index on the ticket list
        tickView.getBack().setOnAction(
                new EventHandler<ActionEvent>(){
                @Override
                public void handle(ActionEvent event) {
                    
                    if(event.getSource() == tickView.getBack())
                    {
                          if(!tickModel.getCitations().isEmpty()){
                              if(tickView.getIndex() > 0){
                                  int temp = tickView.getIndex();
                                  temp -= 1;
                                  tickView.setIndex(temp);
                                  tickView.updateList(temp);
                              }
                          }
                    }
                } 
            }
        );
        //changes the list of tickets to next
        tickView.getNext().setOnAction(
                new EventHandler<ActionEvent>(){
                @Override
                public void handle(ActionEvent event) {
                    
                    if(event.getSource() == tickView.getNext())
                    {
                          if(!tickModel.getCitations().isEmpty()){
                              if(tickView.getIndex() < tickModel.getCitations().size() - 1){
                                  int temp = tickView.getIndex();
                                  temp += 1;
                                  tickView.setIndex(temp);
                                  tickView.updateList(temp);
                              }
                          }
                    }
                } 
            }
        );
        //buttons changes the ticket to paid "Yes"/"No"
        tickView.getPaid().setOnAction(
                new EventHandler<ActionEvent>(){
            @Override
                public void handle(ActionEvent event) {
                    if(event.getSource() == tickView.getPaid())
                    {
                        tickView.setsCheck(tickView.getsCheck());
                        if(tickView.getsCheck() == "No"){
                            tickModel.getCitations().get(tickView.getIndex()).setCheck("Yes");
                            tickView.updateList(tickView.getIndex());
                        }
                        else{
                            
                            tickModel.getCitations().get(tickView.getIndex()).setCheck("No");
                            tickView.updateList(tickView.getIndex());
                        }
                    }
                } 
            }
        );
        //exits out of app
        tickView.getExit().setOnAction(
                new EventHandler<ActionEvent>(){
            @Override
                public void handle(ActionEvent event) {
                    if(event.getSource() == tickView.getExit())
                    {
                        Platform.exit();
                        System.exit(0);
                    }
                } 
            }
        );
        
    }
    
}
