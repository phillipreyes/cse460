//Begin
/**
 * 
 * @author 1208201614
 *
 */
public interface IRecipient {

	public abstract void subscribe(String group);

	public abstract void unsubscribe(String group);

	public abstract String get_name();

}
