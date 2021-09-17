package dfsbfs;

import java.io.*;
import java.util.*;

public class Main {
    //함수에서 사용할 변수들
    static int[][] edge; //간선 연결상태
    static boolean[] ch_edge; //확인 여부
    static int num; //정점개수
    static int nume; //간선개수
    static int start; //시작정점

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();
        nume = sc.nextInt();
        start = sc.nextInt();

        edge = new int[1001][1001]; //좌표를 받아들이기 위해 +1
        ch_edge = new boolean[1001];  // 초기값 false

        //간선 연결상태 저장
        for(int i = 0; i < nume; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            edge[a][b] = edge[b][a] = 1;
        }

        dfs(start);

        ch_edge = new boolean[1001];
        System.out.println();

        bfs();
    }

    public static void dfs(int i) {
        ch_edge[i] = true;
        System.out.print(i + " ");

        for(int j = 1; j <= num; j++) {
            if(edge[i][j] == 1 && ch_edge[j] == false) {
                dfs(j);
            }
        }
    }

    public static void bfs() {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(start); //시작점도 Queue에 넣어야 함
        ch_edge[start] = true;
        System.out.print(start + " ");


        while(!queue.isEmpty()) {
            int temp = queue.poll();

            for(int j = 1; j <= num; j++) {
                if(edge[temp][j] == 1 && ch_edge[j] == false) {
                    queue.offer(j);
                    ch_edge[j] = true;
                    System.out.print(j + " ");
                }
            }
        }
    }
}