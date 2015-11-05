package selfpractice.graphs;

public class Vertex {
	private int distanceFromSource = 0;
	private boolean isExplored = false;
	private Vertex parent = null;
	private String name;

	public Vertex(String _name) {
		super();
		name = _name;
	}

	public String getName() {
		return name;
	}

	public int getDistanceFromSource() {
		return distanceFromSource;
	}

	public boolean isExplored() {
		return isExplored;
	}

	public Vertex getParent() {
		return parent;
	}

	public void setDistanceFromSource(int distanceFromSource) {
		this.distanceFromSource = distanceFromSource;
	}

	public void setExplored(boolean isExplored) {
		this.isExplored = isExplored;
	}

	public void setParent(Vertex parent) {
		this.parent = parent;
	}
	
	@Override
	public String toString() {
		return getName();
	}

}
