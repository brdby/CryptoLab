package com.haskellish;

/**
 * Represents simple extended Euclidean algorithm calculated using Knuth algorithm
 */

public class EGCD {

    private int r, q, x, y;
    private int old_r, old_x, old_y;
    private Result result;

    public static void main(String[] args) {
        //Testing EGCD algorithm
        System.out.println("\nTesting EGCD with numbers 1234 and 54:");
        EGCD egcd = new EGCD(1234, 54);
        EGCD.Result result = egcd.getResult();
        System.out.println(result.getResX()+" * 1234 + "+result.getResY()+" * 54 = "+result.getResD());
    }

    EGCD(int a, int b){
        //initializing
        old_r = a;
        r = b;
        old_x = 1;
        x = 0;
        old_y = 0;
        y = 1;

        //calculating
        result = calculate();
    }

    /**
     * Performs calculation for EGCD
     * @return result in a Result class
     */
    private Result calculate(){
        while (r!=0){
            //shifting "table"
            int temp_r = old_r;
            int temp_x = old_x;
            int temp_y = old_y;
            old_r = r;
            old_x = x;
            old_y = y;

            //calculating new values
            q = temp_r/r;
            r = temp_r%r;
            x = temp_x - q*old_x;
            y = temp_y - q*old_y;
        }
        return new Result(old_x, old_y, old_r);
    }

    public Result getResult() {
        return result;
    }

    static class Result{

        /**
         * Class representing result of EGCD calculation
         */

        private int resX, resY, resD;

        /**
         * Default constructor
         * @param resX Bezout's identity x
         * @param resY Bezout's identity y
         * @param resD GCD
         */
        Result(int resX, int resY, int resD) {
            this.resX = resX;
            this.resY = resY;
            this.resD = resD;
        }

        public int getResX() {
            return resX;
        }

        public int getResY() {
            return resY;
        }

        public int getResD() {
            return resD;
        }
    }
}
