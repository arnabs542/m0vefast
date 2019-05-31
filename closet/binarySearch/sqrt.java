//Input: 18, Return: 4
public int sqrt(int x){
     //find the last number which sqaure of it<=x
     long low = 1;
     long high = x;
     while(low + 1 < high){
//high low中间至少隔了一个数（3，5), last iteration, middle value is mid, narroest bound
//其实这里有一个非常trick地地方：就是当循环终止的时候，l一定是偏小，r一定是偏大（实际的值是介于l和r之间的）：
        long mid = low + (high-low)/2;
        if (mid*mid <= x)   //3*3<=9
          low = mid;
        else high = mid;   //5*5>9    //4*4>9
     }
     if(high*high<=x)   //for n = 0,1
          return (int)high;
     return(int)low;
}
