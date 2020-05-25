package sk.musicstore.interfaces;
/**
 * The interface in which the methods that will be implemented in the OrderUser class are defined.
 * */
public interface IOrderUser {
	public int getId();

	public int getLoginId();

	public void setLoginId(int loginid);

	public String getAddress();

	public void setAddress(String address);
}
