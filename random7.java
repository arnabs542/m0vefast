//random5(), the return value of random5() is 0 - 4 with equal probability
public class RandomSeven{
	public int random7(){
		while(true){
			//to generate a uniformally distributed 0-24 number
			int random = 5 * RandomFive.random5() + RandomFive.random5();
			//only care about the first 21 numbers and ignore and try again for the numbers >=21
			//21-24 will make 1234 has more chance 
			if(random < 21)
				return random % 7;
		}
	}
}

//random5(), the return value of random5() is 0 - 4 with equal probability
public class Solution{
	public int random1000(){
		while(true){
			//the following 4 lines usually used for compute a0*x^0 + a1*x^1 + ....ak*x^k
			int num = 0;
			for(int i = 0; i < 5; i++){
				num = num * 5 + RandomFive.random5();  //+Math.random(5); +5
			}// =>[0,3124=5^5-1]
			//choose 3000 not 1000 to reduce the numebr of the expected random5() calls
			if(random < 3000)
				return random % 1000;
		}
	}
}