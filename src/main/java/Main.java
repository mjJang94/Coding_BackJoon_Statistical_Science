import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main {

    /**
     * 문제
     * 수를 처리하는 것은 통계학에서 상당히 중요한 일이다. 통계학에서 N개의 수를 대표하는 기본 통계값에는 다음과 같은 것들이 있다. 단, N은 홀수라고 가정하자.
     * <p>
     * 산술평균 : N개의 수들의 합을 N으로 나눈 값
     * 중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
     * 최빈값 : N개의 수들 중 가장 많이 나타나는 값
     * 범위 : N개의 수들 중 최댓값과 최솟값의 차이
     * N개의 수가 주어졌을 때, 네 가지 기본 통계값을 구하는 프로그램을 작성하시오.
     * <p>
     * 입력
     * 첫째 줄에 수의 개수 N(1 ≤ N ≤ 500,000)이 주어진다. 그 다음 N개의 줄에는 정수들이 주어진다. 입력되는 정수의 절댓값은 4,000을 넘지 않는다. - (-4000 ~ 4000)
     * <p>
     * 출력
     * 첫째 줄에는 산술평균을 출력한다. 소수점 이하 첫째 자리에서 반올림한 값을 출력한다.
     * <p>
     * 둘째 줄에는 중앙값을 출력한다.
     * <p>
     * 셋째 줄에는 최빈값을 출력한다. 여러 개 있을 때에는 최빈값 중 두 번째로 작은 값을 출력한다.
     * <p>
     * 넷째 줄에는 범위를 출력한다.
     */


    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine());

        int[] arr = new int[8001];


        int sum = 0; //--총 합계
        int max = Integer.MIN_VALUE; //--최대값
        int min = Integer.MAX_VALUE; //--최소값
        int median = 5000; //--중앙값
        int freq = 5000; //--최빈값


        //최댓값 구하기
        for (int i = 0; i < N; i++) {
            int insertValue = Integer.parseInt(bufferedReader.readLine());
            sum += insertValue;

            arr[insertValue + 4000]++;

            if (max < insertValue) {
                max = insertValue;
            }

            if (min > insertValue) {
                min = insertValue;
            }
        }

        int medianCount = 0; //-- 중앙값 노출 누적
        int mode_max = 0; //--최빈값의 최대값

        boolean expose = false; //--이전의 동일한 최빈값이 1번만 등장했을 경우 true 아니면 false

        for (int i = min + 4000; i <= max + 4000; i++) {

            if (arr[i] > 0) {

                //중앙값 찾기

                if (medianCount < (N + 1) / 2) {
                    medianCount += arr[i];
                    median = i - 4000;
                }


                //최빈값
                if (mode_max < arr[i]) {
                    mode_max = arr[i];
                    freq = i - 4000;
                    expose = true; //--첫 등장

                } else if (mode_max == arr[i] && expose == true) {
                    freq = i - 4000;
                    expose = false;
                }
            }
        }


        System.out.println((int) Math.round((double) sum / N));
        System.out.println(median);
        System.out.println(freq);
        System.out.println(max - min);
    }
}
