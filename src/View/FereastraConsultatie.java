package View;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Controller.Operatii;
import Model.Consultatie;

public class FereastraConsultatie implements ActionListener {

	private JButton consult_nou;
	Container cConsult;
	private JLabel jlbDataConsult,jlbDiagnostic,jlbMedicatie,jlbCNP,jlbNumeMedic;
	private JTextField jtfDataConsult,jtfDiagnostic,jtfMedicatie,jtfCNP,jtfNumeMedic;
	private String diagnostic,medicatie,cnp,nume_medic;
	
	private Operatii oper;
	
	
	public FereastraConsultatie()
	{
		
		cnp="";
		diagnostic ="";
		medicatie="";
		nume_medic="";
		
		creareUI();			
		oper = new Operatii();
	}
	
	public void creareUI()
	{
		int latimeCadru=400;
		int inaltimeCadru=400;
		
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame fco=new JFrame("World Clinic - Consultatii");
			
		fco.setBounds(50, 150, latimeCadru, inaltimeCadru);
		fco.setAlwaysOnTop(true);

		cConsult = fco.getContentPane();
   		cConsult.setLayout(null);

		 
		componente();
		fco.setVisible(true);
	}
	
	public void componente()
	{
		jlbCNP				= new JLabel("CNP Pacient");
		jlbDataConsult      = new JLabel("Data consultatiei");
		jlbDiagnostic 		= new JLabel("Diagnostic: ");
		jlbMedicatie 		= new JLabel ("Medicatie: ");
		jlbNumeMedic        = new JLabel ("Nume Medic: ");
		
		jtfCNP				= new JTextField(13);
		jtfDataConsult      = new JTextField(10);		
		jtfDiagnostic 		= new JTextField(20);
		jtfMedicatie		= new JTextField(30);
		jtfNumeMedic		= new JTextField(20);
		
		consult_nou = new JButton("Memoreaza");
		
		cConsult.add(jlbCNP);
		cConsult.add(jlbDataConsult);
		cConsult.add(jlbDiagnostic);
		cConsult.add(jlbMedicatie);
		cConsult.add(jlbNumeMedic);
		
		cConsult.add(jtfCNP);
		cConsult.add(jtfDataConsult);
		cConsult.add(jtfDiagnostic);
		cConsult.add(jtfMedicatie);
		cConsult.add(jtfNumeMedic);
		
		cConsult.add(consult_nou);
		
		Insets insets = cConsult.getInsets();
		Dimension size = jlbCNP.getPreferredSize();
		
		jlbCNP.setBounds(70 + insets.left,60 + insets.top, size.width +60, size.height+10);
		jtfCNP.setBounds(170 + insets.left, 60 + insets.top, size.width + 100,size.height+10);
	    
	    jlbDataConsult.setBounds(70 + insets.left, 90 + insets.top, size.width +60,size.height+10);     
	    jtfDataConsult.setBounds(170 + insets.left, 90 + insets.top, size.width +100,size.height+10); 
	    
	    jlbNumeMedic.setBounds(70 + insets.left, 125 + insets.top, size.width +50,size.height+10); 	    
	    jtfNumeMedic.setBounds(170+ insets.left, 125 + insets.top, size.width +100,size.height+10);
	    
	    
	    jlbDiagnostic.setBounds(70 + insets.left, 160 + insets.top, size.width +50,size.height+10); 	    
	    jtfDiagnostic.setBounds(170+ insets.left, 160 + insets.top, size.width +100,size.height+10);
	    
	    jlbMedicatie.setBounds(70 + insets.left, 195 + insets.top, size.width +50,size.height+10); 	    
	    jtfMedicatie.setBounds(170+ insets.left, 195 + insets.top, size.width +100,size.height+10);
	    
	  //  jlbDozaj.setBounds(70 + insets.left, 265 + insets.top, size.width +50,size.height+10); 	    
	   // jtfDozaj.setBounds(170+ insets.left, 265 + insets.top, size.width +100,size.height+10);
	    
	  //  jlbFrecventa.setBounds(70 + insets.left, 300 + insets.top, size.width +50,size.height+10); 	    
	   // jtfFrecventa.setBounds(170+ insets.left, 300 + insets.top, size.width +100,size.height+10);
	    
	    
	    
	    
		consult_nou.setBounds(70+ insets.left, 300 + insets.top, size.width +190,size.height+10);
		
		consult_nou.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == consult_nou) {
			try {
				memoreazaConsult();
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null,
				"Eroare!!!");
				e1.printStackTrace();
			}
		}
	}
	
	public void memoreazaConsult() throws Exception
	{
		cnp 		= jtfCNP.getText();
		
		SimpleDateFormat ffm = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date utilDate = ffm.parse(jtfDataConsult.getText());
		java.sql.Date dataConsult = new java.sql.Date(utilDate.getTime());
		
		diagnostic = jtfDiagnostic.getText();
		medicatie =jtfMedicatie.getText();
		nume_medic=jtfNumeMedic.getText();
		
		if (cnp.equals("") ||  diagnostic.equals("")  || medicatie.equals("") || nume_medic.equals("")) {
			JOptionPane.showMessageDialog(null,
				"Nu ati complectat toate campurile!");
		}
		else if(cnp.length()!=13)
		{
			JOptionPane.showMessageDialog(null,
			"CNP INCORECT!");
		}
		else {
			
			Consultatie ccc = new Consultatie(cnp,dataConsult,nume_medic,
					diagnostic,medicatie);
			
			if(oper.memoreazaConsult(ccc) == true)
			{
				JOptionPane.showMessageDialog(null, "Pacientul a fost salvat in baza de date.");
			}
			else{
				JOptionPane.showMessageDialog(null, "Pacientul cu acest CNP NU EXISTA in baza de date!");
			}
		}
	}
	
}
