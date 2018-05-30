package entity;

public class order {
  int id;
  int flowerid;
  String flowername;
  int userid;
  String username;
  int count;
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
	return "order [id=" + id + ", flowerid=" + flowerid + ", flowername=" + flowername + ", userid=" + userid
			+ ", username=" + username + ", count=" + count + "]";
}
  
}
