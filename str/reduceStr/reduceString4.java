//Q3: zuma
public String deDup(String input) {
	if(input == null || input.length() <=1)
		return input;
	char[] arr = input.toCharArray();
	int slow = 0;  //INCLUSIVE to the final answer, like index
	int fast = 1;
	for(fast = 1; fast < arr.length; fast++){
		//slow = -1, stack is empty
		//or when no duplicate, we push on to the stack
		//only looks at next one
		if(slow == -1 || arr[fast] != arr[slow])
			arr[++slow] = arr[fast];  //fast not ++!!!
		else{
			//otherwise there is duplicate, pop the element at index cur
			slow--;  //this might cause cur = -1, cur stays at latest char index
			//1  2  2 2
			//s<-sf f f+1  => stack = 1,2...
			while(fast+1 < arr.length && arr[fast] == arr[fast+1])
				fast++;
		}
	}
	return new String(arr, 0, slow+1);  //slow is inclusive
}
print: input, slow, fast for each loop
abbbbcddc
1
1
abbbbcddc
0
4
acbbbcddc
1
5
acdbbcddc
2
6
acdbbcddc
1
7
acdbbcddc
0
8
a%
