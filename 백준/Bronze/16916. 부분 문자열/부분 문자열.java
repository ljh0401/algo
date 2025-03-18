import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String word = br.readLine();
        String find = br.readLine();
        int ans = 0;
        int W = word.length();
        int F = find.length();
        int [] where = new int[F];
        int tmp = 0;
        int idx = 1;
        where[0] = 0;
        while(idx <F) {
            if (find.charAt(idx) == find.charAt(tmp)) {
                tmp++;
                where[idx] = tmp;
                idx++;
            }
            else {
                if (tmp != 0) {
                    tmp = where[tmp-1];
                }
                else {
                    where[idx] = tmp;
                    idx++;
                }
            }
        }
        int idxW = 0;
        int idxF = 0;
        while(idxW < W) {
            if (word.charAt(idxW) == find.charAt(idxF)) {
                idxW++;
                idxF++;
            }
            if (idxF == F) {
                ans = 1;
                break;
            }
            else if (idxW < W && word.charAt(idxW) != find.charAt(idxF)) {
                if (idxF != 0) {
                    idxF = where[idxF-1];
                }
                else {
                    idxW++;
                }
            }
        }
        System.out.print(ans);
    }
}