package View;


import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Controller.Operatii;


public class FereastraAfisarePacienti extends JFrame {

	    Operatii factory;               
	    JTable table;                         
	    JLabel msgline;       
	    
	    Container cAfis;

	    public FereastraAfisarePacienti(Operatii f) {
	    	
	    
	    JFrame fap=new JFrame("Pacientii din baza de date ");
	    cAfis = fap.getContentPane();
   		fap.setAlwaysOnTop(true);

	    addWindowListener(new WindowAdapter() {
	    	public void windowClosing(WindowEvent e) { System.exit(0); }
	     });

	    this.factory = f;
  
	    table = new JTable();         
	    msgline = new JLabel();       

	    cAfis.add(new JScrollPane(table), BorderLayout.CENTER);
	    cAfis.add(msgline,BorderLayout.SOUTH);
	    	  	    
	    
	    fap.setSize(800, 400);
	    fap.setVisible(true);
	   
	    displayQueryResults();
	    
	    }
	    	  

	    public void displayQueryResults() {
	    	
	    	msgline.setText("Realizare conexiune...");
	    	
	    	EventQueue.invokeLater(new Runnable() {
	    		public void run() {
	    		    try {
	    		    	
	    		    	table.setModel(factory.afisareListaPacienti());
	    		    	msgline.setText(" ");  
	    		    }
	    		    catch (SQLException ex) {
	    		    	
	    		    	msgline.setText(" ");
	    		    	JOptionPane.showMessageDialog(FereastraAfisarePacienti.this,
	    				          new String[] {  
	    					      ex.getClass().getName() + ": ",
	    					      ex.getMessage()
	    					  });
	    			    }
	    			}
	    		    });

	    }
	  
	    
}

	
