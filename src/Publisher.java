//Begin
/**
 * 
 * @author 1208201614
 *
 */
//End
public class Publisher implements ISender {

	private String publisherName;

	private NotificationSystem ns;


	

	public Publisher(String publisherName, NotificationSystem ns) {
		//@Begin
		this.publisherName = publisherName.toLowerCase();
		this.ns = ns;
		//@End
	}

	public void register(String group) {
		//Begin
		ns.register(group.toLowerCase(), this);
		//@End
	}

	public void send_email(String group, String text) {
		//@Begin
		Email email = new Email(group,text,publisherName);
		
		ns.send(this,email);
		//@End
	}

	public String get_name() {
		//@Being
		return publisherName;
		//@End
	}

}
