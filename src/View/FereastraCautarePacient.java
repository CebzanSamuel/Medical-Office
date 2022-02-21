package View;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import Controller.Operatii;


public class FereastraCautarePacient extends JFrame {

	    Operatii factory;
	    JTextField query;                    
	    JTable table;                         
	    JLabel msgline;       
	    
	    Container cCautaPers;//

	    public FereastraCautarePacient(Operatii f) {
	    	
	    
	    JFrame fap=new JFrame("Nume pacient: ");
	    cCautaPers = fap.getContentPane();//
   		fap.setAlwaysOnTop(true);

	    addWindowListener(new WindowAdapter() {
	    	public void windowClosing(WindowEvent e) { System.exit(0); }
	     });

	    this.factory = f;

	    query = new JTextField();    
	    table = new JTable();         
	    msgline = new JLabel();       

	    
	    cCautaPers.add(query,BorderLayout.NORTH);
	    cCautaPers.add(new JScrollPane(table), BorderLayout.CENTER);
	    cCautaPers.add(msgline,BorderLayout.SOUTH);
	    

	    query.addActionListener(new ActionListener() {

	    public void actionPerformed(ActionEvent e) {
	     
	    	displayQueryResults(query.getText());
	    }
	    });
	    
	    fap.setSize(800, 400);
	    fap.setVisible(true);
	   
	    
	    }

	    public void displayQueryResults(final String q) {
	    	
	    	msgline.setText("Realizare conexiune...");
	    	
	    	EventQueue.invokeLater(new Runnable() {
	    		public void run() {
	    		    try {
	    		    	
	    		    	table.setModel(factory.cautaPacient(q));
	    		    	msgline.setText(" ");  
	    		    }
	    		    catch (SQLException ex) {
	    		    	
	    		    	msgline.setText(" ");
	    		    	JOptionPane.showMessageDialog(FereastraCautarePacient.this,
	    				          new String[] {  
	    					      ex.getClass().getName() + ": ",
	    					      ex.getMessage()
	    					  });
	    			    }
	    			}
	    		    });

	    }
	  
	    
}

	
