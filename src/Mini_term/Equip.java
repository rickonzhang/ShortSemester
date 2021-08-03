package Mini_term;

public class Equip {
	
	private String eID = null;
    private String ename = null;
    private String instruction = null;
    private String manufacturer_mID = null;
    private String class_cID = null;
    private String family_fID = null;
    private int isDelete = 0;
    
    public String geteID() {
		return eID;
	}
	public void seteID(String eID) {
		this.eID = eID;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getInstruction() {
		return instruction;
	}
	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}
	public String getManufacturer_mID() {
		return manufacturer_mID;
	}
	public void setManufacturer_mID(String manufacturer_mID) {
		this.manufacturer_mID = manufacturer_mID;
	}
	public String getClass_cID() {
		return class_cID;
	}
	public void setClass_cID(String class_cID) {
		this.class_cID = class_cID;
	}
	public String getFamily_fID() {
		return family_fID;
	}
	public void setFamily_fID(String family_fID) {
		this.family_fID = family_fID;
	}
	public int getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}
	

}
