import java.util.*;

public class Main {

    public static void main(String[] args) {

        double[] it = new double[]{70, 40, 30, 20, 10, 20};
        double[] it2 = new double[]{70, 40, 30, 20, 30, 20};
        List<Double> capacities = new ArrayList<>();
        capacities.add(100.0);
        capacities.add(150.0);

        Map<Double, Integer> recommendedConsumersByCapacity = new HashMap<>();
        Map<Double, Integer> ExistingConsumersByCapacity = new HashMap<>();

        ExistingConsumersByCapacity.put(100.0,0);
        ExistingConsumersByCapacity.put(150.0,0);



        ArrayList<Partition> partitions = new ArrayList<>();


        for (int i = 0; i < 6; i++) {
            partitions.add(new Partition(it[i]));
        }





        FirstFitDecHetero ffdh = new FirstFitDecHetero(partitions, capacities /*Arrays.asList(100.0, 150.0)*/);
        List<Consumer> recommendedconsumers = ffdh.fftFFDHetero();

        System.out.println("==========================================");


        for(Consumer nc: recommendedconsumers) {
            recommendedConsumersByCapacity.put(nc.getCapacity(), recommendedConsumersByCapacity.getOrDefault(nc, 0) + 1);
        }
        boolean scale = false;
        for(Double capacity: capacities) {
            int factor = recommendedConsumersByCapacity.get(capacity) - ExistingConsumersByCapacity.get(capacity);

            if (factor > 0) {
                System.out.println("we shall upscale by " +  factor + " for consumer of capacity " + capacity);
                //call statefulset consumer+capacity and up scale this sts
                //the  name of the consumer , start by the ordinalIndex ExistingConsumersByCapacity.get(capacity)
            }
            else if (factor <0) {
                System.out.println("we shall downscale by " +  factor + " for consumer of capacity " + capacity);
                //call statefulset consumer+capacity and up scale this sts
            }
        }











    }
}




   // System.out.println(bins);

        //////////////////////////////////////////////////////////////////////////////

   /*     List<Integer> original = Arrays.asList(12,16,17,19,101);
        List<Integer> selected = Arrays.asList(16,19,107,108,109);

        ArrayList<Integer> add = new ArrayList<Integer>(selected);
        add.removeAll(original);
        System.out.println("Add: " + add);

        ArrayList<Integer> remove = new ArrayList<Integer>(original);
        remove.removeAll(selected);
        System.out.println("Remove: " + remove);*/

