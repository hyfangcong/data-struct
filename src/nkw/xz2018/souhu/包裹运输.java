package nkw.xz2018.souhu;

import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/7/2
 */
public class 包裹运输 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int sum = 0;
            int[] packet = new int[7];
            for(int i = 1; i <= 6 ; i ++){
                int x = scanner.nextInt();
                sum += x;
                packet[i] = x;
            }
            if(sum == 0)
                break;

            int minPacket = 0;
            for(int i = 6; i >= 1; i --){
                if(i == 6)
                    minPacket += packet[i];
                else if(i == 5){
                    minPacket += packet[i];
                    packet[1] = packet[1] - packet[5] >= 0 ? packet[1] - packet[5] : 0;
                }else if(i == 4){
                    minPacket += packet[4];
                    int x = packet[4] * 2;
                    if(packet[2] >= packet[4]){
                        packet[2] -= packet[4];
                    }else{
                        packet[2] = 0;
                        x -= packet[2] * 2;
                        packet[1] = packet[1] - x >= 0 ? packet[1] - x : 0;
                    }
                }else if(i == 3){
                    if(packet[i] % 2 == 0){
                        minPacket += packet[i] / 2;
                    }else{
                        minPacket += packet[i] / 2 + 1;
                        if(packet[2] >= 1){
                            packet[2]--;
                            packet[1] = packet[1] - 1 >= 0 ? packet[1] - 1 : 0;
                        }else{
                            packet[1] = packet[1] - 3 >= 0 ? packet[1] - 3 : 0;
                        }
                    }
                }else if(i == 2){
                    if(packet[i] % 3 == 0){
                        minPacket += packet[i] / 3;
                    }else{
                        minPacket += packet[i] / 3 + 1;
                        int x = 6 - (packet[i] % 3) * 2;
                        packet[1] = packet[1] - x >= 0 ? packet[1] - x : 0;
                    }
                }else{
                    if(packet[i] % 6 == 0)
                        minPacket += packet[i] / 6;
                    else
                        minPacket += packet[i] / 6 + 1;
                }
            }
            System.out.println(minPacket);
        }
    }
}
