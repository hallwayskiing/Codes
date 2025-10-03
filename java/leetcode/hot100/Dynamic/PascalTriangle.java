package hot100.Dynamic;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 */
public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>(List.of(1)));
        if (numRows == 1) return res;
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();

            List<Integer> lastRow = res.get(res.size() - 1);
            row.add(1);
            for (int j = 1; j < i; j++) {
                row.add(lastRow.get(j) + lastRow.get(j - 1));
            }
            row.add(1);

            res.add(row);
        }
        return res;
    }
}
