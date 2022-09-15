import java.util.Objects;

public class Partition implements Comparable{
    private double size;

    public Partition(double size) {
        this.size = size;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Partition{" +
                "size=" + size +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Partition item = (Partition) o;
        return Double.compare(item.size, size) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(size);
    }

    @Override
    public int compareTo(Object o) {
        return Double.compare(size , ((Partition)o).size);
    }
}
