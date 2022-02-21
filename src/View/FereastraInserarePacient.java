package View;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Controller.Operatii;
import Model.Pacient;


public class FereastraInserarePacient{ //implements ActionListener {

	private JButton inserareP;
	private Container cPane;

	private JLabel jlbNume,jlbDataN,jlbCNP,jlbLocalitate,jlbAdresa,jlbTelefon,jlbEmail;
	private JTextField jtfNume,jtfDataN,jtfCNP,jtfLocalitate,jtfAdresa,jtfTelefon,jtfEmail;
	
	private String nume,CNP, localitate, adresa,telefon,email;
	private int id_pacient=0;
	

	
	private Operatii op;
	
	public FereastraInserarePacient() throws SQLException
	{
		nume  = "";
		CNP   = "";
		localitate="";
		adresa="";
		telefon="";
		email="";
		
		creareUI();			
		op = new Operatii();
		
	}
	public void creareUI()
	{

		int latimeCadru=400;
		int inaltimeCadru=400;
		
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame fip=new JFrame("World Clinic-Inserare Pacient Nou");
			
		fip.setBounds(50, 150, latimeCadru, inaltimeCadru);
		fip.setAlwaysOnTop(true);

		cPane = fip.getContentPane();
   		cPane.setLayout(null);

		 
		componente();
		fip.setVisible(true);
	    
	        
	}
	
	public void componente()
	{
	
		jlbNume 		= new JLabel("Nume: ");
		jlbDataN 		= new JLabel ("Data nasterii: ");
		jlbCNP 			= new JLabel("CNP: ");
		jlbLocalitate	= new JLabel("Localitate");
		jlbAdresa		= new JLabel("Adresa");
		jlbTelefon 		= new JLabel("Telefon: ");
		jlbEmail		= new JLabel("Email");
		
		jtfNume 		= new JTextField(20);
		jtfDataN		= new JTextField(8);
		jtfCNP			= new JTextField(13);
		jtfLocalitate	= new JTextField(20);
		jtfAdresa		= new JTextField(20);
		jtfTelefon 		= new JTextField(15);
		jtfEmail		= new JTextField(20);
		
		inserareP = new JButton("Inserare Pacient in Baza de Date");

		

		cPane.add(jlbNume);
		cPane.add(jtfNume);
		cPane.add(jlbDataN);
		cPane.add(jtfDataN);
		cPane.add(jlbCNP);
		cPane.add(jtfCNP);
		cPane.add(jlbLocalitate);
		cPane.add(jtfLocalitate);
		cPane.add(jlbAdresa);
		cPane.add(jtfAdresa);
		cPane.add(jlbTelefon);
		cPane.add(jtfTelefon);
		cPane.add(jtfEmail);
		cPane.add(jlbEmail);
		
		cPane.add(inserareP);
		
		Insets insets = cPane.getInsets();
		Dimension size = jlbNume.getPreferredSize();
		
		jlbNume.setBounds(70 + insets.left,60 + insets.top, size.width +50, size.height+10);
		jtfNume.setBounds(160 + insets.left, 60 + insets.top, size.width + 100,size.height+10);
	    
	    jlbDataN.setBounds(70 + insets.left, 95 + insets.top, size.width +50,size.height+10);     
	    jtfDataN.setBounds(160 + insets.left, 95 + insets.top, size.width +100,size.height+10); 
	    
	    jlbCNP.setBounds(70 + insets.left, 130 + insets.top, size.width +50,size.height+10); 	    
	    jtfCNP.setBounds(160+ insets.left, 130 + insets.top, size.width +100,size.height+10);
	    
	    jlbLocalitate.setBounds(70 + insets.left, 165 + insets.top, size.width +50,size.height+10); 	    
	    jtfLocalitate.setBounds(160+ insets.left, 165 + insets.top, size.width +100,size.height+10);
	    
	    jlbAdresa.setBounds(70 + insets.left, 195 + insets.top, size.width +50,size.height+10); 	    
	    jtfAdresa.setBounds(160+ insets.left, 195 + insets.top, size.width +100,size.height+10);
	    
	    jlbTelefon.setBounds(70 + insets.left, 230 + insets.top, size.width +50,size.height+10); 	    
	    jtfTelefon.setBounds(160+ insets.left, 230 + insets.top, size.width +100,size.height+10);
	   
	    jlbEmail.setBounds(70 + insets.left, 265 + insets.top, size.width +50,size.height+10); 	    
	    jtfEmail.setBounds(160+ insets.left, 265 + insets.top, size.width +100,size.height+10);
	   
	    
		inserareP.setBounds(70+ insets.left, 320 + insets.top, size.width +250,size.height+10);
		
		//inserareP.addActionListener(this);
		
		inserareP.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == inserareP) {
					try {
						inserarePacient();
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null,
						"Inserare nereusita!!!");
						e1.printStackTrace();
					}
				}	
            }});

	}
	
	
	public void inserarePacient() throws Exception{
		
				
		nume 		= jtfNume.getText();	
		CNP   		= jtfCNP.getText();
		
		SimpleDateFormat fm = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date utilDate = fm.parse(jtfDataN.getText());
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		
		localitate	=jtfLocalitate.getText();
		adresa		=jtfAdresa.getText();
		telefon 	=jtfTelefon.getText();
		email		=jtfEmail.getText();
		
		if (nume.equals("") ||  CNP.equals("")  || adresa.equals("") || localitate.equals("") || telefon.equals("") || email.equals("")) {
			JOptionPane.showMessageDialog(null,
				"Nu ati complectat toate campurile!");
		}else if(CNP.length()!=13 )
		{
			JOptionPane.showMessageDialog(null,
			"CNP gresit!");
		}
		else {
			
			Pacient person = new Pacient(nume,sqlDate,CNP,localitate,adresa,telefon,email);
			
			if(op.inserarePacientNou(person)== false)
			{
				JOptionPane.showMessageDialog(null, "Pacientul a fost salvat in baza de date.");
			
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Pacientul exista deja in baza de date!");
			}
			
	}

		clear();

	}
	
	
	public void clear() {
		jtfNume.setText("");
		jtfDataN.setText("");
		jtfCNP.setText("");
		jtfLocalitate.setText("");
		jtfAdresa.setText("");
		jtfTelefon.setText("");
		jtfEmail.setText("");
	}

	
		
	/*public static void main(String args[]) {
		
		new FereastraInserarePacient();
	}*/
	
	

}


