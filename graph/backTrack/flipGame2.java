//Write a function to determine if the starting player can guarantee a win.
//O(n^n). The reason is each recursion takes O(n) and there are totally n recursions.
public boolean canWin(String s) {
    if(s==null||s.length()==0){
        return false;
    }
   return dfs(s.toCharArray());
}

public boolean dfs(char[] arr){
    for(int i=0; i<arr.length-1;i++){
        if(arr[i]=='+'&&arr[i+1]=='+'){
            arr[i]='-';
            arr[i+1]='-';
            //if the next person is able to flip
            boolean ableToFlip = dfs(arr);

            arr[i]='+';
            arr[i+1]='+';

            if(!ableToFlip){
                return true;
            }
        }
    }

    return false;
}
