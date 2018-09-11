
//Begin
/**
 * @author 1208201614
 */

import java.awt.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
//End


public class EntryPointMain {
	//begin
	public static void main(String[]args) throws FileNotFoundException{
	
		
		//HashMap <"Subscribers name", IRecipient Object > 
		HashMap<String, IRecipient> subscribersHashMp = new HashMap<String,IRecipient>();
		//HashMap <"Publishers name", ISender Object> 
		HashMap<String,ISender> publishersHashMp = new HashMap<String, ISender>();
		
		NotificationSystem ns = new NotificationSystem();
		String subscriberName;
		String groupName;
		String publisherName;
		String text;
		
		Scanner scan = new Scanner(System.in);
		
		  scan.useDelimiter(",");
		  while(scan.hasNext()){
			  String Command = scan.next();
			  if(Command.equalsIgnoreCase("Subscribe")){ 
				  subscriberName = scan.next();
				  
				  groupName = scan.next();
				 // System.out.println(subscriberName);
				  //checks to see if subscriber is in hashmap using
				 if(subscribersHashMp.containsKey(subscriberName)){
					 // this will get the subscriber object then invoke subscribe method.
					 subscribersHashMp.get(subscriberName).subscribe(groupName);
				 
				 }else{//subscribe doesnt exist yet
					 
					 IRecipient sub = new Subscriber(subscriberName,ns);
					 //add a new element to hashmap
					 subscribersHashMp.put(subscriberName,sub);
					 subscribersHashMp.get(subscriberName).subscribe(groupName);
				 }
		
			  }else if(Command.equalsIgnoreCase("Unsubscribe")){
				  subscriberName = scan.next();
				  
				  groupName = scan.next();
				 //checks if subscriber is in haspmp first
				  if(subscribersHashMp.containsKey(subscriberName)){//subscribe still exist in EntryPointMain HashMap
					  //gets subscriber object from subscriberName key then invoke unsubscribe
					  subscribersHashMp.get(subscriberName).unsubscribe(groupName);
				  }
				  
			}else if(Command.equalsIgnoreCase("Register")){
				  publisherName = scan.next();
				  groupName = scan.next();
				  //check if publisher is in hashmap by its key name
				  if(publishersHashMp.containsKey(publisherName)){
					  //gets objet invokes register
					  publishersHashMp.get(publisherName).register(groupName);
				 
				  }else{//if publisher doesn't exist yet . create object add new element to hashmap
					  ISender pub = new Publisher(publisherName,ns);
					  publishersHashMp.put(publisherName, pub);
					  publishersHashMp.get(publisherName).register(groupName);
					  					  
				  }
				  
				 
			}else if(Command.equalsIgnoreCase("Send")){
				 publisherName = scan.next();
				 groupName = scan.next();
				 text = scan.next();
				 //if exist in hashmap get publisher obj and invoke send_email
				 if(publishersHashMp.containsKey(publisherName)){
					 publishersHashMp.get(publisherName).send_email(groupName, text);
				 }else {
					 //not sure how to handle this. because publisher doesnt exist yet. in main class
					 //so create publisher object and add element to hashmap  and
					 // get object from hashmp and have NotificationSystem handle it. 
					  ISender pub = new Publisher(publisherName,ns);
					  publishersHashMp.put(publisherName, pub);
					  publishersHashMp.get(publisherName).send_email(groupName, text);
					  
				 }
				 
				 
			}
		  }
		  scan.close();
		
		
	  }
	
	
	
	//end	
		
}
