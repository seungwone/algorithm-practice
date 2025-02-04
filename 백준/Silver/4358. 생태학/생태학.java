import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Double> map = new HashMap<>();
        List<String> keyList = new ArrayList<>();
        int size = 0;

        while (sc.hasNext()) {
            String temp = sc.nextLine();
            size++;
            if (map.containsKey(temp)) {
                map.put(temp, map.get(temp) + 1);
            }
            else {
                map.put(temp, 1.0);
            }
        }

        for (String str : map.keySet()) keyList.add(str);

        Collections.sort(keyList);

        for (String s : keyList) {
            String per = String.format("%.4f", map.get(s) / size * 100);
            System.out.println(s + " " + per);
        }        
    }
}