package arrays;

/**
 * There are n total piles of products.
 * The number of products in each pile is represented by the array numProducts
 * Select any subarray from the array numProducts and pick up products from that subarray such that the number of products you pick from
 * the i-th pile is strictly less than the number of products you pick from the (i+1)-th pile for all indices i of the subarray
 * Find the maximum number of products that can be picked
 */


public class AmazonFresh {

    public static int findMaxProducts (int[] numProducts) {
        int maxsum = 0;
        for (int i = numProducts.length-1; i >= 0; i--) {
            int val = numProducts[i];
            int sum = val;
            if (val == 1)
                continue;

            for (int j = i-1; j >= 0; j--) {
                int prevval = numProducts[j];
                if (prevval == 0)
                    break;

                if (prevval < val) {
                    sum = sum + numProducts[j];
                    val = prevval;
                } else {
                    sum = sum + (val - 1);
                    val = val - 1;
                }
            }

            maxsum = Math.max(maxsum, sum);

        }


        return maxsum;

    }

    public static void main(String[] args) {
        int[] arr = {7,4,5,2,6,5};
        System.out.println (findMaxProducts(arr));
    }

}
