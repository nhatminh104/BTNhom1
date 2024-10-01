package Tuan5.git;

import java.util.Scanner;

public class bai4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, count;
        int [] a, res;
        n = sc.nextInt();
        a = new int[n];
        res= new int[n];
        System.out.println("moi nhap so phan tu cua mang: ");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            res[i] = -1;
        }
        for (int i = 0; i < n; i++) {
            count = 1;
            for (int j = i + 1; j < n; j++) {
                if (res[j] != 0 && a[i] == a[j]){
                    count++;
                    res[j] = 0;
                }
            }
            if (res[i] != 0 ){
                res[i] = count;
            }
        }
        int max = res[0];
        for (int i = 0; i < n; i++) {
            if (res[i] > max){
                max = res[i];
            }
        }
        System.out.print(" So lan xuat hien nhieu nhat: " +max+ ", cac phan tu: ");
        for (int i = 0; i < n; i++) {
            if (res[i] == max){
                System.out.print(a[i]+ " ");
            }
        }
    }
}
