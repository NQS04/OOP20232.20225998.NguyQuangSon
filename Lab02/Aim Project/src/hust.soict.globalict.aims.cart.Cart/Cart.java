import java.util.ArrayList;

public class Cart {
    public static final int MAX_ORDER = 20;
    private DVD list[] = new DVD[MAX_ORDER];
    private int quantity = 0;
    
    public int getQuantity() {
        return quantity;
    }

    public DVD[] getList() {
        return list;
    }

    //RemoveDVD
    public void removeDVD(DVD disc) {
        for (int i = 0; i < quantity;i++) {
            if (disc.equals(list[i])) {
                for (int j = i; j < quantity - 1; j++) list[j] = list[j+1];
                quantity--;
                System.out.println("Remove "+  disc.getTitle() +" successfully");
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
            System.out.println("The disc "+ disc.getTitle() +" has been added");
        }
    }

    //addDVD #2
    public void addDVD(ArrayList<DVD> discList) {
            if (quantity == MAX_ORDER) System.out.println("the cart is almost full");
            else {
                // System.out.println(quantity);
                int count = 0;
                for (int i = quantity; i < discList.size() + quantity; i++) {
                    list[i] = discList.get(count);
                    count++;
                }
                quantity += discList.size();
            }
    }

    //addDVD #3
    public void addDVD(DVD disc1, DVD disc2) {
        if (quantity == MAX_ORDER) System.out.println("the cart is almost full");
        else {
            list[quantity] = disc1;
            list[quantity+1] = disc2;
            quantity += 2;
            
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
