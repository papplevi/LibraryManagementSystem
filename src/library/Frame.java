package library;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Frame extends JFrame implements ActionListener{

	private JTextField myText1;
	private JTextField myText2;
	private JTextField myText3;
	private JButton myBtn1;
	private JButton myBtn2;
	private JButton myBtn3;
	DefaultListModel myModel;
	JList myList;
	
	private Vector carti;
	
	public Frame()
	{
		super ("Carti");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,400);
		
		setLayout(new BorderLayout());
		JPanel myPanel0 = new JPanel();
		myPanel0.setLayout(new FlowLayout());
		
		JPanel myPanel1 = new JPanel();
		myPanel1.setLayout(new BoxLayout(myPanel1, BoxLayout.Y_AXIS));
		JLabel myLabel1 = new JLabel("Titlu");
		JLabel myLabel2 = new JLabel("Autor");
		JLabel myLabel3 = new JLabel("An");
		myPanel1.add(myLabel1);
		myPanel1.add(myLabel2);
		myPanel1.add(myLabel3);
		
		JPanel myPanel2 = new JPanel();
		myPanel2.setLayout(new BoxLayout(myPanel2, BoxLayout.Y_AXIS));
		myText1 = new JTextField(10);
		myText2 = new JTextField(10);
		myText3 = new JTextField(10);
		myPanel2.add(myText1);
		myPanel2.add(myText2);
		myPanel2.add(myText3);
		
		myPanel0.add(myPanel1);
		myPanel0.add(myPanel2);
		
		JPanel myPanel3 = new JPanel();
		myPanel3.setLayout(new FlowLayout());
		
		myBtn1 = new JButton("Adaugare");		
		myBtn2 = new JButton("Afisare");	
		myBtn3 = new JButton("Afisare ordonata");
		
		myPanel3.add(myBtn1);
		myPanel3.add(myBtn2);
		myPanel3.add(myBtn3);
		
		JPanel myPanel4 = new JPanel();
		myPanel4.setLayout(new FlowLayout());
		
		myModel = new DefaultListModel();
		myList = new JList (myModel);
		myList.setPreferredSize(new Dimension(300,250));
		
		myPanel4.add(myList);
		getContentPane().add(myPanel0,BorderLayout.NORTH);
		getContentPane().add(myPanel3,BorderLayout.CENTER);
		getContentPane().add(myPanel4,BorderLayout.SOUTH);
		
		myBtn1.addActionListener(this);
		myBtn2.addActionListener(this);
		myBtn3.addActionListener(this);
		
		setVisible(true);
		
		carti = new Vector();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton source = (JButton) e.getSource();
		
		if (source == myBtn1)
		{
			String titlu = myText1.getText();
			String autor = myText2.getText();
			int an = Integer.parseInt(myText3.getText());
			
			Carte c = new Carte(titlu,autor,an);
			
			carti.addElement(c);

			myText1.setText("");
			myText2.setText("");
			myText3.setText("");
		}
		
		if (source == myBtn2)
		{
			myModel.clear();
			for (int i=0; i<carti.size(); i++)
			{
				if (carti.elementAt(i) instanceof Carte)
				{
					Carte cr = (Carte) carti.elementAt(i);
					myModel.addElement(cr.toString());
				}
			}
		}
		
		if (source == myBtn3)
		{
			myModel.clear();
			ComparaTitlu cmp = new ComparaTitlu();
			Collections.sort(carti,cmp);
			
			for (int i=0; i<carti.size(); i++)
			{
				if (carti.elementAt(i) instanceof Carte)
				{
					Carte cr = (Carte) carti.elementAt(i);
					myModel.addElement(cr.toString());
				}
			}
		}
	}
	
}
