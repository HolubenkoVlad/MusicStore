package sk.musicstore.interfaces;

public interface IOrderUser {
	public int getId();

	public int getLoginId();

	public void setLoginId(int loginid);

	public String getAddress();

	public void setAddress(String address);
}
