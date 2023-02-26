package uo.cpm.util;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import uo.cpm.model.Ticket;


public abstract class FileUtil {

    public static void loadFile(String fileName, List<Ticket> productsList) {

	String line;
	String[] productData = null;

	try {
	    BufferedReader file = new BufferedReader(new FileReader(fileName));
	    while (file.ready()) {
		line = file.readLine();
		productData = line.split("@");
		productsList.add(new Ticket(productData[0],
			Float.parseFloat(productData[1])));
	    }
	    file.close();
	} catch (FileNotFoundException fnfe) {
	    System.out.println("File not found.");
	} catch (IOException ioe) {
	    new RuntimeException("I/O Error.");
	}
    }

    public static void saveToFile(String fileName, List<Ticket> orderList) {
	try {
	    BufferedWriter file = new BufferedWriter(new FileWriter("files/" + fileName + ".dat"));
	    String line = "";
	    for(Ticket p:orderList)
        {
        	line = line+p.getNumber()+"@"+p.getPrice()+"\n";
        }
	    file.write(line);
	    file.close();
	}

	catch (FileNotFoundException fnfe) {
	    System.out.println("The file could not be saved.");
	} catch (IOException ioe) {
	    new RuntimeException("I/O Error.");
	}
    }

    public static String setFileName() {
	String code = "";
	String base = "0123456789abcdefghijklmnopqrstuvwxyz";
	int length = 8;
	for (int i = 0; i < length; i++) {
	    int numero = (int) (Math.random() * (base.length()));
	    code += base.charAt(numero);
	}
	return code;
    }
}

