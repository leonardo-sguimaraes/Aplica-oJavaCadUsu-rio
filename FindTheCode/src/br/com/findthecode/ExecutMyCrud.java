package br.com.findthecode;
import java.util.*;
import javax.swing.*;

public class ExecutMyCrud extends MyCrud{
	
	
	
	
	private static Scanner in;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ExecutMyCrud cd  = new ExecutMyCrud();
		String codx, namex, adressx, phonex;
		Client person = new Client();
		String data = "Cod Name Adress Phone \n\n";
		try{
			in = new Scanner(System.in);
			int opc, cod;
			
			do{
				
				System.out.print("\n Choose the Operation\n ");
				System.out.println("1 - Register");
				System.out.println("2 - Registration of all clients");
				System.out.println("3 - Registration of a client");
				System.out.println("4 - Update");
				System.out.println("5 - Exclude");
				System.out.println("6 - Close");
				
				
				opc = in.nextInt();
				
				switch(opc){
				
				case 1: 
					do{
						codx = JOptionPane.showInputDialog("Input the cod: ");
						if(!(codx.equals("0"))){
							person.setCod(Integer.parseInt(codx));
							person.setName(JOptionPane.showInputDialog("Input the name: "));
							person.setAdress(JOptionPane.showInputDialog("Input the Adress: "));
							person.setPhone(JOptionPane.showInputDialog("Input the phone: "));
							
							cd.register(person);
						}
					}while(!(codx.equals("0")));
					break;
				case 2: 
					System.out.println("Open the program");
					for (Client client : cd.query()){
						data =  data + client.getCod() + " " +  client.getName() + " " +
								client.getAdress() + " " + client.getPhone()+ "\n";
												
					}
					JOptionPane.showMessageDialog(null, "The data listed in the database are \n\n\n" + data);
					System.out.println("End of exhibition");
					break;
				case 3: 
					System.out.println("Enter the client code:");
					cod = in.nextInt();
					if(cd.findByCod(cod).getCod()!= 0){
						System.out.println("Cod: "+cd.findByCod(cod).getCod());
						System.out.println("Name: "+cd.findByCod(cod).getName());
						System.out.println("Aress: "+cd.findByCod(cod).getAdress());
						System.out.println("Phone: "+cd.findByCod(cod).getPhone());
					}
					break;
				case 4: 
					Client person2 = new Client();
					do{
						System.out.println("Enter the client code:");
						cod = in.nextInt();
						if(cd.findByCod(cod).getCod() != 0){
							System.out.println("Cod: "+cd.findByCod(cod).getCod());
							System.out.println("Name: "+cd.findByCod(cod).getName());
							System.out.println("Aress: "+cd.findByCod(cod).getAdress());
							System.out.println("Phone: "+cd.findByCod(cod).getPhone());
							
							namex = cd.findByCod(cod).getName();
							adressx = cd.findByCod(cod).getAdress();
							phonex = cd.findByCod(cod).getPhone();
							
							person2.setName(JOptionPane.showInputDialog("Input the name: ", namex));
							person2.setAdress(JOptionPane.showInputDialog("Input the adress: ", adressx));
							person2.setPhone(JOptionPane.showInputDialog("Input the phone: ", phonex));
							person2.setCod(cod);
							
							cd.update(person2);
						}
						
					}while(cod != 0);
					break;
				case 5: 
					System.out.println("Enter the client code to delete: ");
					
					cod = in.nextInt();
					
					if(cd.findByCod(cod).getCod() != 0){
						System.out.println("Cod: "+cd.findByCod(cod).getCod());
						System.out.println("Name: "+cd.findByCod(cod).getName());
						System.out.println("Adress: "+cd.findByCod(cod).getAdress());
						System.out.println("Phone: "+cd.findByCod(cod).getPhone());
						
						cd.delete(cod);
						
						System.out.println("successfully excluded record");
					}			
				}				
			}while(opc != 6);
		}catch(Exception e){
			System.out.println("ERROR:"+e);
		}

	}

}
