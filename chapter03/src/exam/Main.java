package exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            // 初始化城市名
            List<String> cityNames = new ArrayList<>();
            while (true) {
                String next = in.next();
                if ("###".equals(next)) break;
                cityNames.add(next);
            }

            // 距离的二维数组
            int n = cityNames.size();
            int[][] distances = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    distances[i][j] = in.nextInt();
                }
            }

            // 找出城市距离
            String city = in.next();
            String nextCity = in.next();
            int i = cityNames.indexOf(city);
            int j = cityNames.indexOf(nextCity);
            System.out.println(distances[i][j]);
        }
    }
}