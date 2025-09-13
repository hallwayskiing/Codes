package hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 *
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 */
public class YangHuiTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>>res=new ArrayList<>();
        res.add(new ArrayList<>(Arrays.asList(1)));
        if(numRows==1)
            return res;

        for (int i=1;i<numRows;i++){
            List<Integer>lastRow=res.get(i-1);
            List<Integer>newRow=new ArrayList<>();
            newRow.add(1);
            for (int j=0;j<lastRow.size()-1;j++){
                newRow.add(lastRow.get(j)+lastRow.get(j+1));
            }
            newRow.add(1);
            res.add(newRow);
        }

        return res;
    }

    public static void main(String[] args) {
        new YangHuiTriangle().generate(5);
    }
}
