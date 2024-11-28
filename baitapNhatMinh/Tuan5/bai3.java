package Tuan5.git;

import java.util.Scanner;

public class bai3 {
    static int [] A;
    static int N;
    static Scanner sc;
    static void Nhap()
    {
        for (int i=0; i < N; i++){
            System.out.println("M ["+i+"] = ");
            A[i] = sc.nextInt();
        }
    }
    static void Xuat(){
        for (int i=0; i < N; i++){
            System.out.println("M["+i+"]" +A[i]);
        }
    }
    static void SapXep (){
        for (int i=0; i < N; i++)
            for (int j=0; j < N - 1; j++){
                if (A[j] > A[j + 1]){
                    int temp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = temp;
                }
            }
    }
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        System.out.println("Nhap so phan tu mang: ");
        N = sc.nextInt();
        A = new int[N];
        Nhap();
        Xuat();
        SapXep();
        System.out.println("Mang moi sau khi sap xep la: ");
        Xuat();
    }
}
