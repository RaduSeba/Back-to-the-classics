package uo.cpm.rules;

import java.util.List;

import uo.cpm.model.Store;
import uo.cpm.model.Ticket;
import uo.cpm.model.TicketList;
import uo.cpm.util.FileUtil;





public class TicketCheck {
	
	private List<Ticket> tickets;
	private List<Store> stores;
	TicketList ticketslist= new TicketList();

	public TicketCheck() {
		
		tickets =ticketslist.getListTickets();
		stores= ticketslist.getStoreList();
		
	}
	
	public Ticket[] getTickets() {
		return ticketslist.getArticulos();
}

	
	
	public void remove(Ticket t) {
		Ticket ticketserched = null;
		int i=0;
		for (Ticket a : tickets) {
			if (a.getNumber().equals(t.getNumber()))
			{
				ticketserched = a;
				break;
			}
				
			i++;
		}
				ticketslist.getListTickets().remove(ticketserched);
				//save();
			
		}
	
	
	public Ticket getTicket(String code)
	{
		Ticket ticketserched = null;
		for (Ticket a : tickets) {
			if (a.getNumber().equals(code))
				ticketserched = a;
		}
		return ticketserched;
	}
	
	public void save() {
		FileUtil.saveToFile("tickets", ticketslist.getListTickets());
	}
	
	public boolean checkValidityPrice(Ticket t)
	{
		for(Store s: stores)
		{
			
				if(t.getPrice()>=20)
				{
					return true;
				}
				
			
		}
		return false;
	}
	
	
	public boolean checkValidityStore(Ticket t)
	{
		for(Store s: stores)
		{
			if(t.getNumber().substring(0,8).equals(s.getCode()))
			{
				
					return true;
				
				
			}
		}
		return false;
	}
	
	
	public Store getStore()
	{
		return stores.get(0);
	}
	
	}
