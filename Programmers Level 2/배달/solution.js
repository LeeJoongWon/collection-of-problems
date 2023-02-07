function solution(N, road, K) {
    const costByDist = Array(N + 1).fill(Infinity);
    const moveCost = Array.from(Array(N + 1), () => []);

    road.forEach((value) => {
        let [a, b, c] = value;
        moveCost[a].push({ to: b, cost: c });
        moveCost[b].push({ to: a, cost: c });
    });

    let queue = [{ to: 1, cost: 0 }];
    costByDist[1] = 0;

    while (queue.length) {
        let { to } = queue.pop();
        moveCost[to].forEach((next) => {
            if (costByDist[next.to] > costByDist[to] + next.cost) {
                costByDist[next.to] = costByDist[to] + next.cost;
                queue.push(next);
            }
        });
    }
    return costByDist.filter((item) => item <= K).length;
}

solution(
    5,
    [
        [1, 2, 1],
        [2, 3, 3],
        [5, 2, 2],
        [1, 4, 2],
        [5, 3, 1],
        [5, 4, 2],
    ],
    3,
);
