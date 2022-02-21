package View;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Controller.Operatii;
import Model.Programare;

public class FereastraProgramari implements ActionListener {

	private JButton progr_noua;
	private Container cProgr;
	private JLabel jlbNume,jlbNume_Medic,jlbSpecialitatea,jlbData,jlbOra;
	private JTextField jtfNume,jtfNume_Medic,jtfSpecialitatea,jtfData,jtfOra;

	JFormattedTextField time;


	private String nume,nume_medic,specializare;
	
	private Operatii oper;

	public FereastraProgramari() 
	{
		nume="";
		//telefon="";
		//email="";
		nume_medic="";
		specializare="";
		
		creareUI();			
		oper = new Operatii();
		
	}
	
	public void creareUI()
	{
		int latimeCadru=400;
		int inaltimeCadru=400;
		
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame fco=new JFrame("World Clinic-Programari");
			
		fco.setBounds(50, 150, latimeCadru, inaltimeCadru);
		fco.setAlwaysOnTop(true);

		cProgr = fco.getContentPane();
   		cProgr.setLayout(null);

		 
		componente();
		fco.setVisible(true);
	}
	
	public void componente()
	{
		jlbNume				= new JLabel("Nume:");
		jlbNume_Medic 		= new JLabel ("Nume Medic: ");
		jlbSpecialitatea    = new JLabel ("Specialitatea: ");
		jlbData				=new JLabel("Data programare:");
		jlbOra				=new JLabel("Ora:");
		
		jtfNume				= new JTextField(13);
		jtfNume_Medic		= new JTextField(30);
		jtfSpecialitatea	= new JTextField(20);		
		jtfData				=new JTextField(10);
		jtfOra				= new JTextField(8);
		
		
		//______________________________________
		
		progr_noua = new JButton("Programare noua");
		
		cProgr.add(jlbNume);
		cProgr.add(jlbNume_Medic);
		cProgr.add(jlbSpecialitatea);
		cProgr.add(jlbData);
		cProgr.add(jlbOra);
		
		cProgr.add(jtfNume);
		cProgr.add(jtfNume_Medic);
		cProgr.add(jtfSpecialitatea);
		cProgr.add(jtfData);
		cProgr.add(jtfOra);
		
	
		cProgr.add(progr_noua);
		
		
		Insets insets = cProgr.getInsets();
		Dimension size = jlbNume.getPreferredSize();
		
		jlbNume.setBounds(70 + insets.left,60 + insets.top, size.width +60, size.height+10);
		jtfNume.setBounds(180 + insets.left, 60 + insets.top, size.width + 100,size.height+10);
	    
	    
	    jlbNume_Medic.setBounds(70 + insets.left, 95 + insets.top, size.width +50,size.height+10); 	    
	    jtfNume_Medic.setBounds(180+ insets.left, 95 + insets.top, size.width +100,size.height+10);
	    
	    jlbSpecialitatea.setBounds(70 + insets.left, 130 + insets.top, size.width +50,size.height+10); 	    
	    jtfSpecialitatea.setBounds(180+ insets.left, 130 + insets.top, size.width +100,size.height+10);
	    
	    
	    jlbData.setBounds(70 + insets.left, 165 + insets.top, size.width +80,size.height+10); 	    
	    jtfData.setBounds(180+ insets.left, 165 + insets.top, size.width +100,size.height+10);
	    
	    jlbOra.setBounds(70 + insets.left, 200 + insets.top, size.width +50,size.height+10); 	    
	    jtfOra.setBounds(180+ insets.left, 200 + insets.top, size.width +100,size.height+10);
	    
	  		
	    progr_noua.setBounds(80+ insets.left, 280 + insets.top, size.width +190,size.height+10);
		
		progr_noua.addActionListener(this);
	}
	
	
	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == progr_noua) {
			try {
				programare_noua();
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null,
				"Eroare!!!");
				e1.printStackTrace();
			}
		}
	}
	
	public void programare_noua() throws Exception
	{
		nume 		 = jtfNume.getText();	
		nume_medic   = jtfNume_Medic.getText();
		specializare = jtfSpecialitatea.getText();
		
		SimpleDateFormat fm = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date utilDate = fm.parse(jtfData.getText());
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		
		
		SimpleDateFormat ffm = new SimpleDateFormat("HH:mm");
		java.util.Date utilDate1 = ffm.parse(jtfOra.getText());		
		java.sql.Time sqlDate1 = new java.sql.Time(utilDate1.getTime());
		
				

		if (nume.equals("") ||  nume_medic.equals("")  || specializare.equals("") ) {
			JOptionPane.showMessageDialog(null,
				"Nu ati complectat toate campurile!");
		}
		else 
		{
			Programare p = new Programare(nume,nume_medic,specializare,sqlDate,sqlDate1);
			
			oper.efectueaza_programare(p);		
				JOptionPane.showMessageDialog(null, "Programare memorata");
		
		}
		
	}
	
}
