import java.util.List;

public class Service {

	private String name;
	private String desc;
	private double price;
	private double duration;
	private List<Worker> providers;
	private boolean active;
	private int timesOrdered = 0;
	
	public Service(String name, String desc, double price, double duration, List<Worker> prov, boolean active, int timesOrdered)  {
		this.name = name;
		this.desc = desc;
		this.price = price;
		this.duration = duration;
		this.providers = prov;
		this.active = active;
		this.timesOrdered = timesOrdered;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public void setDuration(double duration) {
		this.duration = duration;
	}
	
	public void updateProviders(List<Worker> prov) {
		this.providers = prov;
	}
	
	public void setActive(boolean ac) {
		this.active = ac;
	}
	
	public void incTimesOrdered() { this.timesOrdered++; }
	
	public String getName() {
		return this.name;
	}
	
	public String getDesc() {
		return this.desc;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public double getDuration() {
		return this.duration;
	}
	
	public List<Worker> getProviders() {
		return this.providers;
	}
	
	public boolean isActive() {
		return this.active;
	}
	
	public int getTimesOrdered() {
		return this.timesOrdered;
	}
	
}