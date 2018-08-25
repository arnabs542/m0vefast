 丑数的定义是，只包含质因子 2, 3, 5 的正整数。比如 6, 8 就是丑数，但是 14 不是丑数以为他包含了质因子 7。
 基本思路就是，对于num，如果取余数（2，3，5中其一）为0，说明对应的prime number能够被整除，
 所以一直除下去。最终如果是Ugly Number，该结果应当是1。时间复杂度是O(logn)。
 public boolean isUgly(int num) {
         if (num <= 0)
           return false;
         if (num == 1)
           return true;

         while (num >= 2 && num % 2 == 0)
           num /= 2;
         while (num >= 3 && num % 3 == 0)
           num /= 3;
         while (num >= 5 && num % 5 == 0)
           num /= 5;

         return num == 1;
     }
