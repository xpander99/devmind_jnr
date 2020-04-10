package metode_abstracte;

public abstract class Shape {
	private String text;
	private String material;
	
	public Shape(String text,String material) {
		this.text = text;
		this.material = material;
	}
	
	public Shape() {
		this("","");
	}
	
	public abstract double getSize();
	
	@Override
	public String toString() {
		return "made of " + this.material + " contains text " + this.text;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((material == null) ? 0 : material.hashCode());
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Shape))
			return false;
		Shape other = (Shape) obj;
		if (material == null) {
			if (other.material != null)
				return false;
		} else if (!material.equals(other.material))
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		return true;
	}
	
}
