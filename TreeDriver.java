import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * TreeDriver class that is the main method of the program
 * @author Avish Parmar
 */
public class TreeDriver {

	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
	
		Tree tree = new Tree();
		while(true) {
			
			System.out.println("L - Load a Tree.\r\n" + 
					"H - Begin a Help Session.\r\n" + 
					"T - Traverse the Tree in preorder.\r\n" + 
					"Q - Quit");
			
			System.out.print("Choice> ");
			
			String choice = stdin.nextLine();
			
			if(choice.equalsIgnoreCase("L")) {
				
				System.out.println("\nWARNING: PLEASE MAKE SURE THE FILE IS IN THE PROJECT FOLDER!\n");
				System.out.print("Enter the file name> ");
				String file = stdin.nextLine();
				
				try {

					Scanner fileReader = new Scanner(new File(file));
					String parentLabel = "";
					
					while(fileReader.hasNext()) {
						
						String label = fileReader.nextLine();
						if(label.trim().contains(" ")) {
							String[] split = label.split(" ");
							parentLabel = split[0];
							parentLabel.trim();
							label = fileReader.nextLine();
						}
						
						while(label.trim().length() == 0) {
							label = fileReader.nextLine();
							label = label.trim();
						}
						
						String prompt = fileReader.nextLine();
						while(prompt.trim().length() == 0){
							prompt = fileReader.nextLine();
						}
						
						String message = fileReader.nextLine();
						while(message.trim().length() == 0) {
							message = fileReader.nextLine();
						}
						
						if(tree.addNode(label, message, prompt, parentLabel)) {
							continue;
						}
						else {
							System.out.println("\nERROR: NODE NOT ADDED!\n");
							break;
						}
					}
		
					fileReader.close();
					System.out.println("\nTree created successfully!\n");
					
				} catch (FileNotFoundException e) {
					System.out.println("\nFile not found\n");
				} 
			}
			else if(choice.equalsIgnoreCase("H")) {
				
				tree.beginSession();
				System.out.println("\nThank you for using this automated service! Bye!\n");
			}
			else if(choice.equalsIgnoreCase("T")) {
				
				tree.preOrder();
			}
			else if(choice.equalsIgnoreCase("Q")) {
				
				System.out.println("Terminating Program..");
				stdin.close();
				System.exit(1);
			}
		}
		
	}

}
