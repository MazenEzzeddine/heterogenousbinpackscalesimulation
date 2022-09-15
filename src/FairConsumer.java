import java.util.ArrayList;

public class FairConsumer implements Comparable{

    private final double capacity;
    private double currentCapacity;
    private ArrayList<Partition> Items;

    public void setCurrentCapacity(double currentCapacity) {
        this.currentCapacity = currentCapacity;
    }

    public double getCurrentCapacity() {
        return currentCapacity;
    }

    public FairConsumer(double capacity) {
        this.capacity = capacity;
        Items = new ArrayList<>();
        this.currentCapacity = capacity;
    }

    public ArrayList<Partition> getItems() {
        return Items;
    }

    public double currentCapacity(){
        return currentCapacity;
    }

    public void  assign(Partition i) {
        Items.add(i);
        currentCapacity -= i.getSize();
    }

    public double getCapacity() {
        return capacity;
    }

    public void setItems(ArrayList<Partition> items) {
        Items = items;
    }

    public void  removeAssignment() {
        Items.clear();
        currentCapacity= capacity;

    }

    @Override
    public String toString() {
        return "Bin{" +
                "capacity=" + capacity +
                ", currentCapacity=" + currentCapacity +
                ", Items=" + Items +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        return Double.compare(currentCapacity , ((FairConsumer)o).currentCapacity);
    }
}
