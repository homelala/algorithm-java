package backjune.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class backjune_좋다 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int answer = 0;
//        int answer = solution1(arr, n);

        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = n - 1;

            while (left < right) {
                if (left == i || right == i) {
                    if (left == i) left++;
                    else right--;
                }else{
                    int sum = arr[left] + arr[right];
                    if (sum == arr[i]) {
                        answer++;
                        break;
                    } else if (sum > arr[i]) {
                        right--;
                    }else{
                        left++;
                    }
                }
            }
        }

        System.out.println(answer);
    }

    private static int solution1(int[] arr, int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        int answer = 0;
        for (int left = 0; left < n - 1; left++) {
            int right = n - 1;
            while (left < right) {
                int sum = arr[left] + arr[right];
                if (map.containsKey(sum) && map.get(sum) > 0) {
                    if (arr[left] == sum && arr[right] == sum && map.get(sum) <= 2) {
                        right--;
                        continue;
                    } else if (arr[left] == sum || arr[right] == sum) {
                        if (map.get(sum) <= 1) {
                            right--;
                            continue;
                        }
                        answer += (map.get(sum) - 1);
                        map.put(sum, 1);
                    }
                    answer += map.get(sum);
                    map.put(sum, 0);
                }
                right--;
            }
        }
        return answer;
    }
}
