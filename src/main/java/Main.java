import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static double calculateDistance(int[] point1, int[] point2) {
        return Math.sqrt(Math.pow(point1[0] - point2[0], 2) + Math.pow(point1[1] - point2[1], 2));
    }

    public static void assignOrders(List<Order> orders, List<Courier> couriers) {
        for (Order order : orders) {
            List<double[]> distances = new ArrayList<>();
            for (Courier courier : couriers) {
                double distance = calculateDistance(order.pointA, courier.location);
                distances.add(new double[]{courier.id, distance});
            }
            distances.sort(Comparator.comparingDouble(o -> o[1]));
            int fastestCourierId = (int) distances.get(0)[0];
            System.out.println("Order from point A " + order.pointA[0] + ", " + order.pointA[1] + " to point B " + order.pointB[0] + ", " + order.pointB[1] + " worth $" + order.cost + " assigned to courier " + fastestCourierId);
        }
    }

    public static void main(String[] args) {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order(new int[]{0, 0}, new int[]{5, 5}, 20));
        orders.add(new Order(new int[]{2, 3}, new int[]{3, 8}, 15));
        orders.add(new Order(new int[]{1, 1}, new int[]{7, 6}, 25));

        List<Courier> couriers = new ArrayList<>();
        couriers.add(new Courier(1, new int[]{1, 2}));
        couriers.add(new Courier(2, new int[]{4, 5}));
        couriers.add(new Courier(3, new int[]{0, 0}));

        assignOrders(orders, couriers);
    }
}
