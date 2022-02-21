package View;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Controller.Operatii;


public class FereastraStergerePacient implements ActionListener {

	private JButton stergereP;
	private Container cSterg;

	private JLabel jlbCNP;
	private JTextField jtfCNP;
	
	private String cnp;
	
	private Operatii o;
	
	public FereastraStergerePacient() 
	{
		cnp = "";	
		
		creareUISterg();
		
		o = new Operatii();
		
	}
	
	public void creareUISterg()
	{
		int latimeCadru=400;
		int inaltimeCadru=400;
		
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame fsp=new JFrame("World Clinic - Stergere Pacient");
		fsp.setBounds(50, 150, latimeCadru, inaltimeCadru);
		//fsp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fsp.setAlwaysOnTop(true);

		cSterg = fsp.getContentPane();
   		cSterg.setLayout(new GridBagLayout());

		componenteS();
		
		fsp.setVisible(true);
	    
	}
	
	public void componenteS()
	{
		stergereP = new JButton("Stergere Pacient din Baza de Date");

		jlbCNP = new JLabel("CNP");
		jtfCNP = new JTextField(13);
		
		GridBagConstraints gridBagConstraintsx01 = new GridBagConstraints();
		gridBagConstraintsx01.gridx = 0;
		gridBagConstraintsx01.gridy = 0;
		gridBagConstraintsx01.insets = new Insets(5, 5, 5, 5);
		cSterg.add(jlbCNP, gridBagConstraintsx01);
		GridBagConstraints gridBagConstraintsx02 = new GridBagConstraints();
		gridBagConstraintsx02.gridx = 1;
		gridBagConstraintsx02.insets = new Insets(5, 5, 5, 5);
		gridBagConstraintsx02.gridy = 0;
		gridBagConstraintsx02.gridwidth = 2;
		gridBagConstraintsx02.fill = GridBagConstraints.BOTH;
		cSterg.add(jtfCNP, gridBagConstraintsx02);
		
		GridBagConstraints gridBagConstraintsx05 = new GridBagConstraints();
		gridBagConstraintsx05.gridx = 1;
		gridBagConstraintsx05.gridy = 2;
		gridBagConstraintsx05.insets = new Insets(5, 5, 5, 5);
		cSterg.add(stergereP, gridBagConstraintsx05); 
	
		stergereP.addActionListener(this);
				
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == stergereP) {
			try {
				stergerePacient();
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null,
				"Stergere nereusita!!!");
				e1.printStackTrace();
			}
		}
	}
	
	public void stergerePacient() throws Exception
	{
		cnp = jtfCNP.getText();
		
		if (cnp.equals("")) {
			JOptionPane.showMessageDialog(null,
					"Introduceti CNP!");
		} else {
			
			 o.stergePacient(cnp);
			JOptionPane.showMessageDialog(null," Record(s) deleted.");
		}

	}
	
	/*public static void main(String args[]) {
		
		new FereastraStergerePacient();
	}*/
	
	
}

