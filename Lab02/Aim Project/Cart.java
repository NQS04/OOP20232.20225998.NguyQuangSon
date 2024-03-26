
public class Cart {
    public static final int MAX_ORDER = 20;
    private DVD list[] = new DVD[MAX_ORDER];
    private int quantity = 0;
    //RemoveDVD
    public void removeDVD(DVD disc) {
        for (int i = 0; i < quantity;i++) {
            if (disc.equals(list[i])) {
                for (int j = i; j < quantity - 1; j++) list[j] = list[j+1];
                quantity--;
                System.out.println("Remove successfully");
                break;
            }
        }
    }
    //addDVD
    public void addDVD(DVD disc) {
        if (quantity == MAX_ORDER) System.out.println("The cart is almost full");
        else {
            list[quantity] = disc;
            quantity++;
            System.out.println("The disc has been added");
        }
    }
    //Cost
    public void totalCost() {
        float totalCost = 0;
        for (int i = 0; i < quantity; i++) {
            float cost = list[i].getCost();
            totalCost += cost;
        }
        System.out.println("Total cost is: " + totalCost);
    }

}
