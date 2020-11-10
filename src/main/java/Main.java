import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static StringBuilder stringBuilder;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine());


        stringBuilder = new StringBuilder();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(bufferedReader.readLine()));
        }

        average(list);
        median(list);
        frequency(list);
        range(list);

        System.out.print(stringBuilder);
    }

    static void average(ArrayList<Integer> list) {

        int tmp = 0;

        for (int value : list) {
            tmp += value;
        }
        stringBuilder.append((int) Math.round((double) tmp / list.size()));
        stringBuilder.append('\n');
    }

    static void median(ArrayList<Integer> list) {
        Collections.sort(list);

        int size = list.size();
        int tmpIndex;

        //짝수면
        if (size % 2 == 0) {

            tmpIndex = list.get(size / 2) - 1;

            stringBuilder.append(list.get(tmpIndex));
            stringBuilder.append('\n');
            //홀수면
        } else {
            tmpIndex = (int) Math.round(Double.parseDouble(String.valueOf((size / 2))));
            stringBuilder.append(list.get(tmpIndex));
            stringBuilder.append('\n');
        }


    }

    static void frequency(ArrayList<Integer> list) {
        Collections.sort(list);

        ArrayList<Integer> tmpList = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            tmpList.add(Collections.frequency(list, list.get(i)));
        }


        int tmpMax = Collections.max(tmpList);
        ArrayList<Integer> s = new ArrayList<>();

        for (int i = 0; i < tmpList.size(); i++) {

            if (tmpList.get(i) == tmpMax) {
                s.add(list.get(i));
            }
        }

        Set<Integer> set = new HashSet<>(s); //set으로 중복 제거
        ArrayList<Integer> sortList = new ArrayList<>(set); //중복 제거된 set 을 오름차순으로 정렬
        Collections.sort(sortList);

        if (set.size() > 1) {
            stringBuilder.append(sortList.get(1));
            stringBuilder.append('\n');
        } else {
            stringBuilder.append(sortList.get(0));
            stringBuilder.append('\n');
        }
    }

    static void range(ArrayList<Integer> list) {
        int max = Collections.max(list);
        int min = Collections.min(list);
        stringBuilder.append(max - min);
        stringBuilder.append('\n');
    }
}
