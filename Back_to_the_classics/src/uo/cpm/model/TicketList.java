package uo.cpm.model;

import java.util.ArrayList;
import java.util.List;

import uo.cpm.util.FileUtil;
import uo.cpm.util.FileUtilStore;


public class TicketList {




	private static final String FICHERO_ARTICULOS = "files/tickets.dat";
	private static final String FICHERO_Store= "files/config.dat";
	private List<Ticket> tiketslist = null;
	private List<Store> storelist=null;


	public TicketList() {
		tiketslist = new ArrayList<Ticket>();
		storelist= new ArrayList<Store>();
		loadTickets();
		loadStores();
	}
	
	

	

	private void loadTickets() {
		FileUtil.loadFile(FICHERO_ARTICULOS, tiketslist);
	}
	
	private void loadStores()
	{
		FileUtilStore.loadFile(FICHERO_Store, storelist);
	}

	public Ticket[] getArticulos() {
		Ticket[] articulos = tiketslist.toArray(new Ticket[tiketslist.size()]);
		return articulos;
	}
	
	public Store[] getStores()
	{
		Store[] stores= storelist.toArray(new Store[storelist.size()]);
		return stores;
	}

	public List<Ticket> getListTickets() {
		return tiketslist;
	}
	
	public List<Store> getStoreList()
	{
		return storelist;
	}
}
