package View;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;
import javax.swing.border.BevelBorder;

import Controller.Operatii;


public class NewMain extends JPanel 
{
	
	private JButton specializari,gestiune,diagnosticare,programare,addMedic,addSpecializare;
	private JMenuItem afisare,inserare,stergere,cautare;

	private JMenuBar menubar;
	
	final JPopupMenu menu1 = new JPopupMenu("Meniu Medici&Specializari");
	
	NewMain c ;


	public NewMain()
	{
		setOpaque(false);
		setLayout(null);
		
	}	
	
	public void componenteFP()
	{

		 menubar = new JMenuBar();
		 JMenu filemenu = new JMenu("File");
		 filemenu.add(new JSeparator());
		 JMenu editmenu = new JMenu("Help");
		 JMenuItem editItem1 = new JMenuItem("About");
		 editmenu.add(new JSeparator());
		 
		 JMenuItem fileItem1 = new JMenuItem("Close");
		 filemenu.add(fileItem1);
		 editmenu.add(editItem1);
		 menubar.add(filemenu);
		 menubar.add(editmenu);
		
				 
	
		 fileItem1.addActionListener(new ActionListener() { 
				public void actionPerformed(ActionEvent e) {
	            	System.exit(0);
	            }});
		 
		 editItem1.addActionListener(new ActionListener() { 
				public void actionPerformed(ActionEvent e) {
	            //	new AboutFrame(); mai tb implem
	            }});
		 //________________________________________________
		 
		 c = this; //new NewMain();
		
		//----Butoane Principale------------------------------------
		 
		specializari =new JButton("Medici&Specializari");
		gestiune = new JButton("Gestiunea Pacientilor");
		diagnosticare= new JButton("Diagnosticare Pacienti");
		programare		=new JButton("Programari");
		addMedic= new JButton("Adaugare Medic");
		addSpecializare= new JButton("Adaugare Specializare");
		
		Insets insets = c.getInsets();
		Dimension size = specializari.getPreferredSize();
		
		gestiune.setBounds( 10+ insets.left, 50+ insets.top, size.width +20,size.height+10);
		diagnosticare.setBounds( 10+ insets.left, 85+ insets.top, size.width +20, size.height+10);
	    programare.setBounds( 10+ insets.left, 120+ insets.top, size.width +20, size.height+10); 
	    specializari.setBounds( 10+ insets.left, 155+ insets.top, size.width +20, size.height+10);    
	    addMedic.setBounds( 10+ insets.left, 190+ insets.top, size.width +20, size.height+10);  
	    addSpecializare.setBounds(10+ insets.left, 230+ insets.top, size.width +20, size.height+10);
	    
	    c.add(addSpecializare);
	    c.add(addMedic);
	    c.add(specializari);
		c.add(gestiune);
		c.add(diagnosticare);
		c.add(programare);
		
		
		//--------Butoane Popupmenu2-------------------------
		
		afisare  = new JMenuItem("Afisare Lista Pacienti");
 		inserare = new JMenuItem("Inserare Pacient");
 		stergere = new JMenuItem("Stergere Pacient");
 		cautare  = new JMenuItem("Cautare Pacient");
 		
 	
		//____________________________________________________
		
			    
	    
	    final JPopupMenu menu2 = new JPopupMenu("Gestiune pacienti");
	    menu2.setBorder(new BevelBorder(BevelBorder.RAISED));
	    menu2.setLabel("Justification");
	
	    
	    menu2.add(inserare);
	    menu2.add(stergere);
	    menu2.add(cautare);
	    menu2.add(afisare);
	   
	    
	    
	    //____________________________________________________
	    
	    
	    	        	    
	    inserare.addActionListener(new ActionListener() { //ce face cand apasam inserare
            public void actionPerformed(ActionEvent e) {
            	try {
					new FereastraInserarePacient();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
            }});
		
		stergere.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
            	new FereastraStergerePacient();
            }});
		
		afisare.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				Operatii ooo= new Operatii();
            	new FereastraAfisarePacienti(ooo);
            }});
		
		cautare.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				Operatii ooo= new Operatii();
            	new FereastraCautarePacient(ooo);
            }});
		
	    //________________________________________________________
		specializari.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {							
				menu1.show(specializari, specializari.getWidth(), specializari.getHeight());
				
            }});
		
		
		gestiune.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {							
				menu2.show(gestiune, gestiune.getWidth(), gestiune.getHeight());
				
            }});
		
		diagnosticare.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
			
            	new FereastraConsultatie();
            }});
		
		programare.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
			
            	new FereastraProgramari();
            }});
		
		addMedic.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
			
            	new FereastraIntroMedic();
            }});
		
		addSpecializare.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
			
            	new FereastraSpecializare();
            }});
		
		createMenu1Buttons();	
		frameUI();
		
	}
	
	public void frameUI()
	{
		int latimeCadru=900;
		int inaltimeCadru=600;
		
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame fp=new JFrame("World Clinic");
			
		fp.setBounds(50, 150, latimeCadru, inaltimeCadru);
		fp.setJMenuBar(menubar);
		fp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	    fp.add(c);
	    fp.setVisible(true);
	}
	
	public void paint(Graphics g)
	{
		Image a= Toolkit.getDefaultToolkit().getImage("foto.jpg");
		g.drawImage(a, 0, 0,getSize().width,getSize().height,this);
		super.paint(g);
	}
	
	public void createMenu1Buttons()
	{
		JMenuItem[] buttons = new JMenuItem[8];
		String  nume_butoane[]={"Medicina de familie","Medicina interna","Oftalmologie","ORL","Stomatologie","Dermatologie","Cardiologie","Psihiatrie"
				};
				
		for(int i = 0; i < buttons.length; i++) {
			buttons[i] = new JMenuItem(nume_butoane[i]);
			
			menu1.setBorder(new BevelBorder(BevelBorder.RAISED));//
		    menu1.setLabel("Justification");//
		    
			menu1.add(buttons[i]);
			
			buttons[i].setSize(80, 80);
			
			buttons[i].setActionCommand(nume_butoane[i]);
		

			buttons[i].addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					String sss;
					Operatii ooo= new Operatii();
					if(e.getActionCommand()== "Medicina de familie")
					{
						sss="mf";
						new FereastraAfisareSpecializari(ooo,sss);
					}
					else if(e.getActionCommand()=="Medicina interna")
					{
						sss="mi";
						new FereastraAfisareSpecializari(ooo,sss);
					}
					else if(e.getActionCommand()=="Oftalmologie")
					{
						sss="oft";
						new FereastraAfisareSpecializari(ooo,sss);
					}
					else if(e.getActionCommand()=="ORL")
					{
						sss="orl";
						new FereastraAfisareSpecializari(ooo,sss);
					}
					else if(e.getActionCommand()=="Stomatologie")
					{
						sss="sto";
						new FereastraAfisareSpecializari(ooo,sss);
					}
					else if(e.getActionCommand()=="Dermatologie")
					{
						sss="der";
						new FereastraAfisareSpecializari(ooo,sss);
					}
					else if(e.getActionCommand()=="Cardiologie")
					{
						sss="car";
						new FereastraAfisareSpecializari(ooo,sss);
					}
					else if(e.getActionCommand()=="Psihiatrie")
					{
						sss="psi";
						new FereastraAfisareSpecializari(ooo,sss);
					}
									
					
				  }
				});
	
		}

	}
	
	public static void main(String[] args)
	{
		
		NewMain fer = new NewMain();
		fer.componenteFP();
		
		//DELETE FROM `medici_speci` WHERE `medic` in (SELECT `medic` FROM (SELECT `medic`,COUNT(`medic`) AS numar FROM `medici_speci` GROUP by `medic`) AS T WHERE T.numar=2)

		
	}
	
	
}
