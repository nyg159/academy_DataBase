package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        System.out.println(N);
        int[] arr = new int[N];

        int M = scanner.nextInt();
        System.out.println(M);

        if ((N >= 1 && N <= 100) && (M >= 1 && M <= 100)) {
            for (int a = 0; a < M; a++) {
                int i = scanner.nextInt();
                int j = scanner.nextInt();
                int k = scanner.nextInt();

                if (1 <= i && i <= j && j <= N && (1 <= k && k <= N)) {
                    for (int b = 1; b <= N; b++) {
                        if (b >= i && b <= j) {
                            arr[b] = k;
                        }
                    }
                    for (int c = 1; c <= N; c++) {
                        System.out.print(arr[c] + " ");
                    }
                }
            }
        }


    }
}