package Backend;
import java.util.List;

public class Service {

	private String name;
	private double price;
	private double duration;
	public static int timesOrdered = 0;
	
	public Service(String name, double price, double duration)  {
		this.name = name;
		this.price = price;
		this.duration = duration;
		timesOrdered++;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public void setDuration(double duration) {
		this.duration = duration;
	}
	
	public String getName() {
		return this.name;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public double getDuration() {
		return this.duration;
	}
	
	public int getTimesOrdered() {
		return this.timesOrdered;
	}

	public String toString() {
		return this.name + ":" + this.price + ":" + this.duration;
	}

}