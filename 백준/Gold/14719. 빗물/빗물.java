import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] HW = br.readLine().split(" ");
        int H = Integer.parseInt(HW[0]);
        int W = Integer.parseInt(HW[1]);
        String [] He = br.readLine().split(" ");
        int[][] gun = new int[H][W+1]; 
        for (int j = 0; j < H; j++){
            for (int i = 0; i < W; i++) {
                if(Integer.parseInt(He[i]) >= H-j) {
                    gun[j][i] = 1;
                }
            }
        }
        
        int biSum = 0;
        for (int j = 0; j < H; j++){
            for (int i = 0; i < W; i++) {
                if (gun[j][i] == 1) {
                    int bi = 0;
                    for (int s = i+1; s < W+1; s++) {
                        if (s == W) {
                            bi = 0;
                            break;
                        }
                        else if (gun[j][s] == 1) {
                            break;
                        }
                        else if (gun[j][s] == 0) {
                            bi += 1;
                        }
                    }
                    biSum += bi;
                }
            }    
        }
        bw.write(""+biSum);
        bw.flush();
        bw.close();
    }
}