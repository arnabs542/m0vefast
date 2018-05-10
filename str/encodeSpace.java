//Q3: string encoding
public String reduceString(String s){
	if(s == null || s.length() == 0)
		return null;
	StringBuilder sb = new StringBuilder();
	char cur = s.charAt(0);
	int count = 0;
	for(int i = 0; i < s.length(); i++){
		if(s.charAt(i) == cur){
			count++;
		else{
			//if sb is string type, we can just use: sb+=(target to append)
			sb.append(Integer.toString(count));
			sb.append(String.valueOf(cur));
			count = 1;
			cur = s.charAt(i);
		}
	}
	sb.append(count);  //sb+=Integer.toString(count) if sb==string
	sb.append(cur);
	return sb.toString();
}
