实现 pow(x, n) ，即计算 x 的 n 次幂函数
class Solution {
    public double myPow(double x, int n) {
        int m=n;
        double res=1.0;
        while(m!=0){
            if((m&1)==1){
                res*=x;
            }
            x*=x;
            m/=2;
        }
        return n>0?res:1/res;
    }
}

给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。

返回被除数 dividend 除以除数 divisor 得到的商。

整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/divide-two-integers
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend==Integer.MIN_VALUE&&divisor==-1){
            return Integer.MAX_VALUE;
        }
        int res=0;
        long a=Math.abs((long)dividend);
        long b=Math.abs((long)divisor);
        for(int i=31;i>=0;i--){
            if((a>>>i)>=b){
                res+=(1<<i);
                a-=(b<<i);
            }
        }
        return (dividend^divisor)>=0?res:-res;
    }
}

//在其他数都出现k次的数组中找出只出现一次的数字
public class Main {
    private static int findOnce(int[] arr,int k){
        int res=0;
        for(int i=0;i<32;i++){
            int sum=0;
            for (int value : arr) {
                sum += (value >>> i) & 1;
            }
            res+=((sum%k)<<i);
        }
        return res;
    }
}

顺时针打印矩阵
public class SpiralOrder {
    public int[] spiralOrder(int[][] matrix) {
        int up=0;
        int left=0;
        int down=matrix.length-1;
        if(down==-1) return new int[0];
        int right=matrix[0].length-1;
        int[] res=new int[(down+1)*(right+1)];
        int j=0;
        while(true){
            for(int i=left;i<=right;i++){
                res[j++]=matrix[up][i];
            }
            if(++up>down) break;
            for(int i=up;i<=down;i++){
                res[j++]=matrix[i][right];
            }
            if(--right<left) break;
            for(int i=right;i>=left;i--){
                res[j++]=matrix[down][i];
            }
            if(--down<up) break;
            for(int i=down;i>=up;i--){
                res[j++]=matrix[i][left];
            }
            if(++left>right) break;
        }
        return res;
    }
}


对角线打印数组
public class FindDiagonalOrder {
    private int j;
    public int[] findDiagonalOrder(int[][] matrix){
        int row1=0;
        int col1=0;
        int row2=0;
        int col2=0;
        int row=matrix.length-1;
        if(row==-1) return new int[0];
        int col=matrix[0].length-1;
        int[] res=new int[(col+1)*(row+1)];
        boolean fromUp=false;
        while(row1!=row+1){
            printLevel(matrix,row1,col1,row2,col2,fromUp,res);
            row1=col1==col?row1+1:row1;
            col1=col1==col?col1:col1+1;
            col2=row2==row?col2+1:col2;
            row2=row2==row?row2:row2+1;
            fromUp=!fromUp;
        }
        return res;
    }

    private void printLevel(int[][] matrix, int row1, int col1, int row2, int col2, boolean fromUp, int[] res) {
        if(fromUp){
            while(row1!=row2+1){
                res[j++]=matrix[row1++][col1--];
            }
        }else{
            while(row2!=row1-1){
                res[j++]=matrix[row2--][col2++];
            }
        }
    }
}

public class Main{
    private static int transform(String s){
        String[] arr=s.split("\\.");
        int num1=Integer.parseInt(arr[0])*17*29;
        int num2=Integer.parseInt(arr[1])*29;
        return num1+num2+Integer.parseInt(arr[2]);
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String s=sc.next();
            String t=sc.next();
            int num1=transform(s);
            int num2=transform(t);
            int num=num2-num1;
            if(num>=0){
                int a=num/(17*29);
                num-=17*29*a;
                int b=num/29;
                num-=b*29;
                System.out.println(a+"."+b+"."+num);
            }else{
                num=-num;
                int a=num/(17*29);
                num-=17*29*a;
                int b=num/29;
                num-=b*29;
                System.out.println("-"+a+"."+b+"."+num);
            }
        }
    }
}

2的个数
public class Count2 {
    public int countNumberOf2s(int n) {
        int res=0;
        int low=0;
        int cur=0;
        int high=0;
        int index=1;
        while((n/index)!=0){
            high=n/(index*10);
            cur=(n/index)%10;
            low=n-(n/index*index);
            if(cur<2){
                res+=high*index;
            }else if(cur==2){
                res+=high*index+low+1;
            }else {
                res+=(high+1)*index;
            }
            index*=10;
        }
        return res;
    }
}