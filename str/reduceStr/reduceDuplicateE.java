//Q3: reduct all e to one e, keep one copy
public String reduceDuplicateE(String s){
	if(s == null || s.length() == 0)
		return null;
	if(s.contains("ee"))
		return reduceDuplicateE(s.replace("ee", "e"));
	else
		return s;
}
//antoehr version  not using recursion
public String reduceDuplicateE(String s){
	if(s == null)
		return null;
	StringBuilder sb = new StringBuilder();
	for(int i = 0; i < s.length()){
		if(s.charAt(i) == 'e'){
			sb.append(s.charAt(i));
			while(i < s.length() && s.charAt(i) == 'e')
				i++;
		}else{
			sb.append(s.charAt(i));
			i++;
		}
	}
	return sb.toString();
}
