package View;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.*;

import Controller.Operatii;
import Model.Medic;

public class FereastraIntroMedic implements ActionListener {
	
	
	private Container cProgr;
	
	JLabel lSpecialitate;
	JComboBox comboSpecialitate;
	
	JLabel lnume;
	JTextField txtNume;
	
	JLabel luni;
	JSpinner startLuni;
	JSpinner endLuni;
	
	JLabel marti;
	JSpinner startMarti;
	JSpinner endMarti;
	
	JLabel miercuri;
	JSpinner startMiercuri;
	JSpinner endMiercuri;
	
	JLabel joi;
	JSpinner startJoi;
	JSpinner endJoi;
	
	JLabel vineri;
	JSpinner startVineri;
	JSpinner endVineri;
	
	JButton butonIntroMedic;
	
	private Operatii oper; // lucreaza cu baza de date 

	public FereastraIntroMedic() 
	{
			
		oper = new Operatii();
		creareUI();	
		
	}
	
	public void creareUI(){
		
		int latimeCadru=700;
		int inaltimeCadru=400;
		
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame fco=new JFrame("World Clinic-Introducere Medic");
		
		fco.setBounds(50, 150, latimeCadru, inaltimeCadru);
		fco.setAlwaysOnTop(true);

		cProgr = fco.getContentPane();
   		cProgr.setLayout(null);

		 
		componente();
		fco.setVisible(true);
	}
	
	public void componente(){
		
		this.lSpecialitate=new JLabel("Specialitate: ");
		
		ArrayList<String> specializari=new ArrayList<String>();
		try {
			ResultSet rs_specializari=oper.getSpecializari();
			while(rs_specializari.next()){
				String cod=rs_specializari.getString("codSpecializare");
				String specializare=rs_specializari.getString("specializare");
				specializari.add(specializare);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		String specializari2[]=new String[specializari.size()];
		specializari.toArray(specializari2);
		
		this.comboSpecialitate=new  JComboBox<String>(specializari2);
		
		this.lnume=new JLabel("Nume medic: ");
		this.txtNume=new JTextField(30);
		
		this.luni=new JLabel("Orar Luni: ");
		
		Date date = new Date();
		SpinnerDateModel sm = new SpinnerDateModel(date, null, null, Calendar.MINUTE);
		this.startLuni= new JSpinner(sm);
		JSpinner.DateEditor de = new JSpinner.DateEditor(this.startLuni, "hh:mm a");
		de.getTextField().setEditable( false );
		this.startLuni.setEditor(de);
		

		SpinnerDateModel sm2 = new SpinnerDateModel(date, null, null, Calendar.MINUTE);
		this.endLuni= new JSpinner(sm2);
		JSpinner.DateEditor de2 = new JSpinner.DateEditor(this.endLuni, "hh:mm a");
		de2.getTextField().setEditable( false );
		this.endLuni.setEditor(de2);
		
		
		this.marti=new JLabel("Orar Marti: ");
		
		SpinnerDateModel sm3 = new SpinnerDateModel(date, null, null, Calendar.MINUTE);
		this.startMarti= new JSpinner(sm3);
		JSpinner.DateEditor de3 = new JSpinner.DateEditor(this.startMarti, "hh:mm a");
		de3.getTextField().setEditable( false );
		this.startMarti.setEditor(de3);
		

		SpinnerDateModel sm4 = new SpinnerDateModel(date, null, null, Calendar.MINUTE);
		this.endMarti= new JSpinner(sm4);
		JSpinner.DateEditor de4 = new JSpinner.DateEditor(this.endMarti, "hh:mm a");
		de4.getTextField().setEditable( false );
		this.endMarti.setEditor(de4);
		
		
		this.miercuri=new JLabel("Orar Miercuri: ");
		
		SpinnerDateModel sm5 = new SpinnerDateModel(date, null, null, Calendar.MINUTE);
		this.startMiercuri= new JSpinner(sm5);
		JSpinner.DateEditor de5 = new JSpinner.DateEditor(this.startMiercuri, "hh:mm a");
		de5.getTextField().setEditable( false );
		this.startMiercuri.setEditor(de5);
		

		SpinnerDateModel sm6 = new SpinnerDateModel(date, null, null, Calendar.MINUTE);
		this.endMiercuri= new JSpinner(sm6);
		JSpinner.DateEditor de6 = new JSpinner.DateEditor(this.endMiercuri, "hh:mm a");
		de6.getTextField().setEditable( false );
		this.endMiercuri.setEditor(de6);
		
		
		this.joi=new JLabel("Orar Joi: ");
		
		SpinnerDateModel sm7 = new SpinnerDateModel(date, null, null, Calendar.MINUTE);
		this.startJoi= new JSpinner(sm7);
		JSpinner.DateEditor de7 = new JSpinner.DateEditor(this.startJoi, "hh:mm a");
		de7.getTextField().setEditable( false );
		this.startJoi.setEditor(de7);
		

		SpinnerDateModel sm8 = new SpinnerDateModel(date, null, null, Calendar.MINUTE);
		this.endJoi= new JSpinner(sm8);
		JSpinner.DateEditor de8 = new JSpinner.DateEditor(this.endJoi, "hh:mm a");
		de8.getTextField().setEditable( false );
		this.endJoi.setEditor(de8);
		
		
		this.vineri=new JLabel("Orar Vineri: ");
		

		SpinnerDateModel sm9 = new SpinnerDateModel(date, null, null, Calendar.MINUTE);
		this.startVineri= new JSpinner(sm9);
		JSpinner.DateEditor de9 = new JSpinner.DateEditor(this.startVineri, "hh:mm a");
		de9.getTextField().setEditable( false );
		this.startVineri.setEditor(de9);
		

		SpinnerDateModel sm10 = new SpinnerDateModel(date, null, null, Calendar.MINUTE);
		this.endVineri= new JSpinner(sm10);
		JSpinner.DateEditor de10 = new JSpinner.DateEditor(this.endVineri, "hh:mm a");
		de10.getTextField().setEditable( false );
		this.endVineri.setEditor(de10);
		
		this.butonIntroMedic=new JButton("Introducere");
		this.butonIntroMedic.addActionListener(this);
		
		this.cProgr.add(this.lSpecialitate);
		this.cProgr.add(this.comboSpecialitate);
		
		this.cProgr.add(this.luni);
		this.cProgr.add(this.startLuni);
		this.cProgr.add(this.endLuni);
		
		this.cProgr.add(this.marti);
		this.cProgr.add(this.startMarti);
		this.cProgr.add(this.endMarti);
		
		this.cProgr.add(this.miercuri);
		this.cProgr.add(this.startMiercuri);
		this.cProgr.add(this.endMiercuri);
		
		this.cProgr.add(this.joi);
		this.cProgr.add(this.startJoi);
		this.cProgr.add(this.endJoi);
		
		this.cProgr.add(this.vineri);
		this.cProgr.add(this.startVineri);
		this.cProgr.add(this.endVineri);
		
		this.cProgr.add(this.lnume);
		this.cProgr.add(this.txtNume);
		
		this.cProgr.add(this.butonIntroMedic);
		
		Insets insets = cProgr.getInsets();
		Dimension size = this.lnume.getPreferredSize();
		
		this.lSpecialitate.setBounds(70 + insets.left,60 + insets.top, size.width +60, size.height+10);
		this.comboSpecialitate.setBounds(180+insets.left, 60+insets.top, size.width +60, size.height+10);
		
		this.lnume.setBounds(70 + insets.left,95 + insets.top, size.width +60, size.height+10);
		this.txtNume.setBounds(180+insets.left, 95+insets.top, size.width +60, size.height+10);
		

		this.luni.setBounds(70 + insets.left,130 + insets.top, size.width +60, size.height+10);
		this.startLuni.setBounds(180+insets.left, 130+insets.top, size.width +60, size.height+10);
		this.endLuni.setBounds(350+insets.left, 130+insets.top, size.width +60, size.height+10);
		
		this.marti.setBounds(70 + insets.left,165 + insets.top, size.width +60, size.height+10);
		this.startMarti.setBounds(180+insets.left, 165+insets.top, size.width +60, size.height+10);
		this.endMarti.setBounds(350+insets.left, 165+insets.top, size.width +60, size.height+10);
		
		this.miercuri.setBounds(70 + insets.left,200 + insets.top, size.width +60, size.height+10);
		this.startMiercuri.setBounds(180+insets.left, 200+insets.top, size.width +60, size.height+10);
		this.endMiercuri.setBounds(350+insets.left, 200+insets.top, size.width +60, size.height+10);
		
		this.joi.setBounds(70 + insets.left,235 + insets.top, size.width +60, size.height+10);
		this.startJoi.setBounds(180+insets.left, 235+insets.top, size.width +60, size.height+10);
		this.endJoi.setBounds(350+insets.left, 235+insets.top, size.width +60, size.height+10);
		
		this.vineri.setBounds(70 + insets.left,270 + insets.top, size.width +60, size.height+10);
		this.startVineri.setBounds(180+insets.left, 270+insets.top, size.width +60, size.height+10);
		this.endVineri.setBounds(350+insets.left, 270+insets.top, size.width +60, size.height+10);
		
		this.lnume.setBounds(70 + insets.left,305 + insets.top, size.width +60, size.height+10);
		this.txtNume.setBounds(180+insets.left, 305+insets.top, size.width +60, size.height+10);
		
		this.butonIntroMedic.setBounds(70 + insets.left,340 + insets.top, size.width +60, size.height+10);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == this.butonIntroMedic) {
			try {

				introducereMedic();
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null,
				"Eroare!!!");
				e1.printStackTrace();
			}
		}
		
	}
	
	public void introducereMedic(){
		
		String specializare=this.comboSpecialitate.getSelectedItem().toString().trim();
		
		ResultSet rs;
		String cod=null;
		
		try {
			rs = this.oper.getSpecializari();
			while(rs.next()){
				String codd=rs.getString("codSpecializare");
				String specializare2=rs.getString("specializare");
				if(specializare2.equals(specializare)){
					cod=codd;
					break;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		String nume=this.txtNume.getText().trim();
		
		if(cod!=null && nume.length()>0){
			
			
			String s=this.startLuni.getValue().toString();
			String v[]=s.split(" ");
			String luniStart=v[3].substring(0,5);
			
			s=this.endLuni.getValue().toString();
			v=s.split(" ");
			String luniEnd=v[3].substring(0,5);
			
			s=this.startMarti.getValue().toString();
			v=s.split(" ");
			String martiStart=v[3].substring(0,5);
			
			s=this.endMarti.getValue().toString();
			v=s.split(" ");
			String martiEnd=v[3].substring(0,5);
			
			s=this.startMiercuri.getValue().toString();
			v=s.split(" ");
			String miercuriStart=v[3].substring(0,5);
			
			s=this.endMiercuri.getValue().toString();
			v=s.split(" ");
			String miercuriEnd=v[3].substring(0,5);
			
			s=this.startJoi.getValue().toString();
			v=s.split(" ");
			String joiStart=v[3].substring(0,5);
			
			s=this.endJoi.getValue().toString();
			v=s.split(" ");
			String joiEnd=v[3].substring(0,5);
			
			s=this.startVineri.getValue().toString();
			v=s.split(" ");
			String vineriStart=v[3].substring(0,5);
			
			s=this.endVineri.getValue().toString();
			v=s.split(" ");
			String vineriEnd=v[3].substring(0,5);
			
			String orarLuni=luniStart+" - "+luniEnd;
			String orarMarti=martiStart+" - "+martiEnd;
			String orarMiercuri=miercuriStart+" - "+miercuriEnd;
			String orarJoi=joiStart+" - "+joiEnd;
			String orarVineri=vineriStart+" - "+vineriEnd;
			
			Medic medic=new Medic(nume,cod,orarLuni,orarMarti,orarMiercuri,orarJoi,orarVineri);
			try {
				this.oper.addMedic(medic);
				JOptionPane.showMessageDialog(null,"Medic Introdus");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		else{
			JOptionPane.showMessageDialog(null,"Nu ati specificat numele medicului");
		}
		
		
		
		
	}

}
