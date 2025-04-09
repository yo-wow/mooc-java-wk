package exam;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> citiesDistances = new HashMap<>();
        try (Scanner in = new Scanner(System.in)){
            putCityName(citiesDistances, in);
            putCityDistance(citiesDistances, in);

//            System.out.println(citiesDistances);

            String name = in.next();
            String nextName = in.next();
            System.out.println(citiesDistances.get(name + "-" + nextName));
        }
    }

    private static void putCityName(Map<String, Integer> citiesDistances, Scanner in) {
        List<String> cityNames = new ArrayList<>();
        while (true) {
            String next = in.next();
            // ###表示输入完毕
            if ("###".equals(next)) break;
            cityNames.add(next);
        }

        for (String cityName : cityNames) {
            for (String nextCityName : cityNames) {
                citiesDistances.put(cityName + "-" + nextCityName, null);
            }
        }
    }

    private static void putCityDistance(Map<String, Integer> citiesDistances, Scanner in) {
        Set<String> cities = citiesDistances.keySet();
        for (String city : cities) {
            citiesDistances.put(city, in.nextInt());
        }
    }
}