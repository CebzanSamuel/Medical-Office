package View;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;

import Controller.Operatii;


public class FereastraAfisareSpecializari extends JFrame {

	    Operatii factory;                    
	    JTable table,table1;                                
	    String cod_s;
	    Container cAfisSpec;
	    
	    
	    
	    public FereastraAfisareSpecializari(Operatii f,String cod_s) {
	    	
	    	JFrame fas=new JFrame();
	    	fas.setAlwaysOnTop(true);
	    	cAfisSpec = fas.getContentPane();//
   		
	    	addWindowListener(new WindowAdapter() {
	    		public void windowClosing(WindowEvent e) { System.exit(0); }
	    	});

	    	this.factory = f;
 
	    	table = new JTable();         
	         
	  
	    	cAfisSpec.add(new JScrollPane(table), BorderLayout.CENTER);
	   	    
		    		displayQueryResults(cod_s);
		      
		    //_____________________
		    	
		    table1= new JTable();
		    table.setBorder(new BevelBorder(BevelBorder.RAISED));
		    table1.setBorder(new BevelBorder(BevelBorder.RAISED));
		    table.setGridColor(Color.DARK_GRAY);
		    table1.setGridColor(Color.DARK_GRAY);
		   
		    
		    Box box = Box.createVerticalBox();
		    box.add(Box.createVerticalStrut(30));
		    box.add(table.getTableHeader());
		    box.add(table);
		    box.add(Box.createVerticalStrut(100));   //pt spatiu intre JTable-uri


		    Box.createVerticalStrut(5);
		    box.add(table1.getTableHeader());
		    box.add(table1);
		 
		   cAfisSpec.add(box);
		  //_______________________________
	 
	    
		    fas.setSize(800, 450);
		    fas.setVisible(true);
	   
	    
	    }

	    public void displayQueryResults(final String cod_s) {
	    	
	    	   	
	    	EventQueue.invokeLater(new Runnable() {
	    		public void run() {
	    		    try {
	    		    	
	    		    	table.setModel(factory.afisareSpecializari(cod_s)); //(g)
	    		    	table1.setModel(factory.afisareServicii(cod_s));
	    		    
	    		    }
	    		    catch (SQLException ex) {
	    		    	
	    		    
	    		    	JOptionPane.showMessageDialog(FereastraAfisareSpecializari.this,
	    				          new String[] {  
	    					      ex.getClass().getName() + ": ",
	    					      ex.getMessage()
	    					  });
	    			    }
	    			}
	    		    });

	    }
	  
	    
}

	
