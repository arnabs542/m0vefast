DFS template：
需要五个参数：结果，中间结果，原始数据集，满足target number的值, 当前指向的数据：
void dfs(type res, type path, type input, int remain, int cur){
	//termination condition
	if(invalid data)
		return;
	//收敛条件
	if(cur == input.size()) //if(remain == 0)
		res.add(path);
	if(可以剪枝)
		return;
	//implement all posisble 扩展动作)
	for(..){
		执行动作，修改path: path.add(input[i])
		dfs(res, path, input, step+1 or remain--, cur/i??);
		restore path: path.remove(path.size()-1)
	}
}

