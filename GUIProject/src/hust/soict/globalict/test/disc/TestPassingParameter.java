package hust.soict.globalict.test.disc;

import hust.soict.globalict.aims.media.*;

public class TestPassingParameter {
    public static void main (String[] args) {
        DVD jungleDVD = new DVD("Jungle");
        DVD cinderellaDVD = new DVD("Cinderella");

        swap(jungleDVD, cinderellaDVD);
        System.out.println("Jungle DVD title: " + jungleDVD.getTitle());
        System.out.println("Cinderella DVD title: " + cinderellaDVD.getTitle());

        changeTitle(jungleDVD, cinderellaDVD.getTitle());
        System.out.println("Jungle DVD title: " + jungleDVD.getTitle());
        System.out.println("Cinderella DVD title: " + cinderellaDVD.getTitle());
    }   
     
        public static void swap(Object o1, Object o2) {
            Object temp = o1;
            o1 = o2;
            o2 = temp;
        }

        public static void changeTitle(DVD dvd, String title) {
            String oldTitle = dvd.getTitle();
            dvd.setTitle(title);
            dvd = new DVD(oldTitle);
        }
    }