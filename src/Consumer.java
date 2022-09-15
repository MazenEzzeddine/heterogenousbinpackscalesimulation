import java.util.ArrayList;

public class Consumer implements Comparable {
    private final double capacity;
    private double remainingCapacity;
    private  ArrayList<Partition> partitions;

    public void setCurrentCapacity(double currentCapacity) {
        this.remainingCapacity = currentCapacity;
    }

    public double getCurrentCapacity() {
        return remainingCapacity;
    }

    public Consumer(double capacity) {
        this.capacity = capacity;
        partitions = new ArrayList<>();
        this.remainingCapacity = capacity;
    }

    public ArrayList<Partition> getItems() {
        return partitions;
    }

    public double currentCapacity(){
      return remainingCapacity;
    }

    public void  assign(Partition i) {
        partitions.add(i);
        remainingCapacity -= i.getSize();
    }

    public double getCapacity() {
        return capacity;
    }

    public void setItems(ArrayList<Partition> items) {
        partitions = items;
    }

    public void  removeAssignment() {
         partitions.clear();
         remainingCapacity= capacity;
    }

    @Override
    public String toString() {
        return "Bin{" +
                "capacity=" + capacity +
                ", remainingCapacity=" + remainingCapacity +
                ", partitions=" + partitions +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        return Double.compare(remainingCapacity , ((Consumer)o).remainingCapacity);
    }
}
