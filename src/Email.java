//Begin
/**
 * 
 * @author 1208201614
 *
 */
//End
public class Email {

	private String groupName;

	private String message;

	private String publisherName;

	public Email(String groupName, String message, String publisherName) {
		//Begin
		this.groupName = groupName.toLowerCase();
		this.message = message;
		this.publisherName = publisherName.toLowerCase();
		//End
	}
	public String getMessage() {
		//Begin
		return message;
		//End
	}

	public String getGroupName() {
		// Begin
		return groupName;
		//finish
	}

	

	public String getPublisherName() {
		//Begin
		return publisherName;
		//End
	}

}
