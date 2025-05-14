package sort;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class CoordinateSort {
    public static class Coordinate {
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static class Point implements Comparable<Point> {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(CoordinateSort.Point o) {
            if(this.x == o.x) return this.y - o.y;
            else return this.x - o.x;
        }
    }


    public static ArrayList<Coordinate> solution1(int n, ArrayList<Coordinate> list) {
        list.sort(Comparator.comparing((Coordinate coordinate) -> coordinate.x).thenComparing(coordinate -> coordinate.y));
        return list;
    }



    public void main() {
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Coordinate> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            list.add(new Coordinate(x, y));
        }

        for (Coordinate coordinate : solution1(n, list)) {
            System.out.printf(coordinate.x + " " + coordinate.y);
            System.out.println();
        }
    }
}
