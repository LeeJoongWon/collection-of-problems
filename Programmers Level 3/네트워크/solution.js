function solution(n, computers) {
    let answer = 0;
    let visited = new Array(n).fill(false);

    function dfs(network) {
        visited[network] = true;
        computers[network].forEach((el, index) => {
            if (el === 1 && !visited[index]) dfs(index);
        });
    }

    for (let i = 0; i < n; i++) {
        if (visited[i]) continue;
        dfs(i);
        answer++;
    }

    return answer;
}
