public class PlantDemo {
    public static void main(String[] args) {
        Plant p1 = new Plant("Sunflower", 15.0, 40);
        Plant p2 = new Plant("Aloe", 8.5, 15);
        Plant p3 = new Plant("Fern", 12.2, 75);

        System.out.println("--- Before watering ---");
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);

        // Use the behavior: water each plant
        p1.water(200); // 200 mL
        p2.water(50);  // 50 mL
        p3.water(500); // heavy watering

        System.out.println("--- After watering ---");
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
    }
}
