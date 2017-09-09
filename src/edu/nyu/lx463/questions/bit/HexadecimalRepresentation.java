package edu.nyu.lx463.questions.bit;

/**
 * Created by LyuXie on 5/2/17.
 */
public class HexadecimalRepresentation {
    public String hex(int num) {
        StringBuilder sb = new StringBuilder();
        if (num == 0) {
            sb.append(0);
        }

        while (num != 0) {
            int curr = num % 16;
            if (curr <= 9) {
                sb.append((char)(curr + '0'));
            }
            else {
                sb.append((char)(curr - 10 + 'a'));
            }
            num >>>= 4;
        }


        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        HexadecimalRepresentation hx = new HexadecimalRepresentation();
         String  result = hx.hex(-1);
         System.out.print(result);
    }


}
