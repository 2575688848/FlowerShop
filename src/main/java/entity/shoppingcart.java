package entity;

public class shoppingcart {
	  int id;
	  int flowerid;
	  String flowername;
	  int userid;
	  String username;
	  int count=1;
	  
	public shoppingcart(int flowerid, String flowername, int userid, String username) {
		super();
		this.flowerid = flowerid;
		this.flowername = flowername;
		this.userid = userid;
		this.username = username;
		
	}
	
	public shoppingcart(int id, int flowerid, String flowername, int userid, String username, int count) {
		super();
		this.id = id;
		this.flowerid = flowerid;
		this.flowername = flowername;
		this.userid = userid;
		this.username = username;
		this.count = count;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getFlowerid() {
		return flowerid;
	}
	public void setFlowerid(int flowerid) {
		this.flowerid = flowerid;
	}
	public String getFlowername() {
		return flowername;
	}
	public void setFlowername(String flowername) {
		this.flowername = flowername;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "shoppingcart [id=" + id + ", flowerid=" + flowerid + ", flowername=" + flowername + ", userid=" + userid
				+ ", username=" + username + ", count=" + count + "]";
	}
	  
}
