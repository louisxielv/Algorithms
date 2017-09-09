package edu.nyu.lx463.questions.DFS;

/**
 * Created by LyuXie on 5/30/17.
 */
public class PrintIf {
    public String print(int n) {
        StringBuilder sb = new StringBuilder();

        dfs(sb , 0, 0, n);
        return sb.toString();
    }

    private void dfs(StringBuilder sb, int left, int right, int n) {
        if (left + right == 2 * n) {
            System.out.println(sb.toString());
            return;
        }

        if (right < n && left > right) {


            sb.append("}\n");
            dfs(sb, left, right + 1, n);
            sb.delete(sb.length() - 1, sb.length());

        }
        if (left < n) {
            if (left != 0) {
                sb.append(" ");
            }
            sb.append("if {\n");
            dfs(sb, left + 1, right, n);
            if (left == 0) {
                sb.delete(sb.length() - 3, sb.length());
            }

            sb.delete(sb.length() - 4, sb.length());

        }
    }

    public static void main(String[] args) {
        PrintIf pi = new PrintIf();
        System.out.print(pi.print(3));
    }
}
