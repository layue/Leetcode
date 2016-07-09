/**
 * Created by X on 09/07/2016.
 */
public class MinRotateArray {
    public static int findMin(int [] num) {
        if (num == null) {
            return -1;
        }

        int left = 0;
        int right = num.length - 1;
        int mid;

        while(num[left] > num[right]) {
            mid = (right + left) / 2;
            if(num[mid] < num[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return num[left];
    }

    public static void main(String [] args) {
        int [] num = {266,267,268,269,271,278,282,292,293,298,6,9,15,19,21,26,33,35,37,38,39,46,49,54,65,71,74,77,79,82,83,88,92,93,94,97,104,108,114,115,117,122,123,127,128,129,134,137,141,142,144,147,150,154,160,163,166,169,172,173,177,180,183,184,188,198,203,208,210,214,218,220,223,224,233,236,241,243,253,256,257,262,263};
        System.out.println(findMin(num));
    }
}