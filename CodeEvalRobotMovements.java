package com.whatfix;


import java.util.Arrays;

public class CodeEvalRobotMovements
{
    // maze size = N x M (N is integer and M is integer)
    private static final Integer row_count = 4;
    private static final Integer col_count = 4;
    private static final Integer min_row_index = 0;
    private static final Integer min_col_index = 0;
    private static final Integer max_row_index = row_count - 1;
    private static final Integer max_col_index = col_count - 1;
    private static Integer count = 0;

    public static void main(String[] args) throws Exception
    {
        CodeEvalRobotMovements CERM = new CodeEvalRobotMovements();
        CERM.start();
    }

    private void start()
    {
        boolean[][] visited = new boolean[row_count][col_count];
        move(visited, min_row_index, min_col_index);
        System.out.println(count);
    }

    private void move(boolean[][] visited, int x, int y)
    {
        if (x == max_row_index && y == max_col_index) {
            ++count;
            return;
        }
        if (visited[x][y]) {return;}
        visited[x][y] = true;
        if (x > min_row_index) {move(new_pos_caller(visited), x - 1, y);}
        if (x < max_row_index) {move(new_pos_caller(visited), x + 1, y);}
        if (y > min_col_index) {move(new_pos_caller(visited), x, y - 1);}
        if (y < max_col_index) {move(new_pos_caller(visited), x, y + 1);}
    }

    public static boolean[][] new_pos_caller(boolean[][] visited)
    {
        boolean[][] new_pos = new boolean[visited.length][];
        for (int i = 0; i < visited.length; ++i)
        {
            new_pos[i] = Arrays.copyOf(visited[i], visited[i].length);
        }
        return new_pos;
    }
}
