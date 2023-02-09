function solution(n, computers) {
    let answer = 0;
    let visited = new Array(n).fill(false);

    function dfs(network) {
        visited[network] = true;
        computers[network].forEach((connected, network) => {
            if (connected === 1 && !visited[network]) dfs(network);
        });
    }

    for (let network = 0; network < n; network++) {
        if (visited[network]) continue;
        dfs(network);
        answer++;
    }

    return answer;
}
