//Begin
/**
 * @author 1208201614
 * Notification System.
 * methods: 
 * addSubscriber(String groupName, IRecipient sub)
 * removeSubscriber(String groupName, IRecipient subscrber)
 * register(String groupName, ISender publisher) 
 * send(ISender publisher,Email email)
 */
import java.util.HashMap;
import java.util.LinkedList;
//End


public class NotificationSystem {

	private  HashMap<String, LinkedList<IRecipient>> subscribersHashMp = new HashMap<String, LinkedList<IRecipient>>();
	private  HashMap<String, LinkedList<ISender>> publishersHashMp = new HashMap<String, LinkedList<ISender>>();
	

	//Begin
	/**
	 * Add subscriber by searching HashMap by key(i.e. group name) if exist add subscribe if subscribe is not in linklist of hashmap
	 * if key(e.g group name) doesn't exist create a group and add new sub to groups linkedlist 
	 * @param groupName
	 * @param sub
	 */
	//End
	public void addSubscriber(String groupName, IRecipient sub) {
		//Begin
		if(subscribersHashMp.containsKey(groupName)){
			//System.out.println(sub.get_name());
			if(!subscribersHashMp.get(groupName).contains(sub)){	
				
				subscribersHashMp.get(groupName).addLast(sub);
			}
			
		}else{//if there is group has not been created yet// 
			
			LinkedList<IRecipient>subscriberLinkList = new LinkedList<IRecipient>();
			subscriberLinkList.addLast(sub);
			subscribersHashMp.put(groupName, subscriberLinkList);
		}			
		//End
	}
	//Begin
	/**
	 * Search HashMap by key (i.e. group name) if exist remove subscriber.
	 * @param groupName
	 * @param subscrber
	 */
	//End
	public void removeSubscriber(String groupName, IRecipient subscrber) {
		//Begin
		if(subscribersHashMp.containsKey(groupName)){
			
			subscribersHashMp.get(groupName).remove(subscrber);
			
		}
		//End			
	}
	//Begin
	/**
	 * Adds publisher to publisher HashMap using groupName as key and adds publisher to LinkedList<ISender>
	 * If group does not exist in HashMap . new group is created with added new LinkedList with new publisher. 
	 * @param groupName
	 * @param publisher
	 */
	//End
	public void register(String groupName, ISender publisher) {
		//Begin
		if( publishersHashMp.containsKey(groupName)){
			
			//if groupname linkedlist does not have pub then add pub
			if(!publishersHashMp.get(groupName).contains(publisher)){	
				publishersHashMp.get(groupName).addLast(publisher);
			}
			
		}else{//add new publisher and group if group doesn't exist
			
			LinkedList<ISender>publisherLinkList = new LinkedList<ISender>();
			publisherLinkList.addLast(publisher);
			publishersHashMp.put(groupName, publisherLinkList);
		}
		//@End		
	}
	//Begin
	/**
	 * 	Sending notification of email to subscribes of subscriber HashMap. 
	 * if publisher is not registed to group in HashMap then unauthorized publication
	 * @param publisher
	 * @param email
	 */
	//End
	public void send(ISender publisher, Email email) {
		//Begin
		//does group name exist
		if( publishersHashMp.containsKey(email.getGroupName())){
			//does publisher object in the groupname linkedlist
			if( publishersHashMp.get(email.getGroupName()).contains(publisher)){
				//does email group name exist in haspmap
				if(subscribersHashMp.containsKey(email.getGroupName())){
			           
		        	   for(int i=0; i<subscribersHashMp.get(email.getGroupName()).size(); i++){
		        		   //notify in email. 
		        		   Subscriber.notify(subscribersHashMp.get(email.getGroupName()).get(i).get_name(),email);
		        	   }
				
				}else {
					//if there isnt a group created and no subscribers in hash map
				}
			
			}else{
				System.out.println("Unauthorized publication by " + publisher.get_name());
			}
			
		}else {
			System.out.println("Unauthorized publication by " + publisher.get_name());
		}			
		//End
	}

}
