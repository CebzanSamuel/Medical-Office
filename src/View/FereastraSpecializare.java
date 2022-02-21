package View;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

import Controller.Operatii;
import Model.Specializare;

public class FereastraSpecializare implements ActionListener {
	
	protected JLabel lblCod=new JLabel("Cod Specializare");
	protected JTextField txtCod=new JTextField(20);
	
	protected JLabel lblDenumire=new JLabel("Denumire Specializare");
	protected JTextField txtDenumire=new JTextField(20);
	
	protected JButton buton=new JButton("Introducere ");
	
	private Container cProgr;
	private Operatii operatii=new Operatii();
	
	public FereastraSpecializare(){
		int latimeCadru=700;
		int inaltimeCadru=400;
		
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame fco=new JFrame("World Clinic-Introducere Specializare");
		
		fco.setBounds(50, 150, latimeCadru, inaltimeCadru);
		fco.setAlwaysOnTop(true);

		cProgr = fco.getContentPane();
   		cProgr.setLayout(null);

		this.buton.addActionListener(this);
		
		Insets insets = cProgr.getInsets();
		Dimension size = this.lblCod.getPreferredSize();
		
		this.lblCod.setBounds(70 + insets.left,60 + insets.top, size.width +60, size.height+10);
		this.txtCod.setBounds(200+insets.left, 60+insets.top, size.width +60, size.height+10);
		
		this.lblDenumire.setBounds(70 + insets.left,95 + insets.top, size.width +60, size.height+10);
		this.txtDenumire.setBounds(200+insets.left, 95+insets.top, size.width +60, size.height+10);
		
		this.buton.setBounds(70 + insets.left,130 + insets.top, size.width +60, size.height+10);
		
		this.cProgr.add(this.lblCod);
		this.cProgr.add(this.txtCod);
		this.cProgr.add(this.lblDenumire);
		this.cProgr.add(this.txtDenumire);
		this.cProgr.add(this.buton);
		
		fco.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == this.buton) {
			try {

				introducereSpecializare();
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null,
				"Eroare!!!");
				e1.printStackTrace();
			}
		}
		
	}
	
	public void introducereSpecializare(){
		
		String cod=this.txtCod.getText().trim();
		String nume=this.txtDenumire.getText().trim();
		
		Specializare spec=new Specializare(cod,nume);
		try {
			this.operatii.addSpecializare(spec);
			JOptionPane.showMessageDialog(null,"Specializare Introdusa!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
