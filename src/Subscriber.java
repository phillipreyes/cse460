//Begin
/**
 * 
 * @author 1208201614
 *
 */
//End
public class Subscriber implements IRecipient {

	private String name;

	private NotificationSystem ns;

	public Subscriber(String name, NotificationSystem ns) {
		//Begin
		this.name = name.toLowerCase();
		this.ns= ns;
		//End
	}

	public void subscribe(String group) {
		//Begin
		ns.addSubscriber(group.toLowerCase(), this);//new input
		//End
	}

	public void unsubscribe(String group) {
		//Begin
		ns.removeSubscriber(group.toLowerCase(), this);
		//End
	}

	public String get_name() {
		//Begin
		return name;
		//End
	}

	public static void notify(String subscriberName, Email email) {
		//Begin
		System.out.println(subscriberName + " received email from " + email.getPublisherName() + ": " + email.getMessage());
		//End
	}

}
