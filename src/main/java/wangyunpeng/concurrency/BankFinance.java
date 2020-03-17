package main.java.wangyunpeng.concurrency;

import main.java.wangyunpeng.concurrency.Thread.TicketWindow;

public class BankFinance {

    public static void main(String[] args) {
        TicketWindow ticketWindow = new TicketWindow("一号柜台");
        ticketWindow.start();
        TicketWindow ticketWindow2 = new TicketWindow("二号柜台");
        ticketWindow2.start();
        TicketWindow ticketWindow3 = new TicketWindow("三号柜台");
        ticketWindow3.start();
    }
}
