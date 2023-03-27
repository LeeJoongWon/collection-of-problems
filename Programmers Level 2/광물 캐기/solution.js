function solution(picks, minerals) {
    let answer = 0;

    for (let i = 0; i < minerals.length; i += 5) {
        let count = 0;
        let diamond = 0,
            iron = 0,
            stone = 0;

        // 사용할 곡괭이가 없는 경우 피로도 무한
        if (picks[0] === 0) diamond = Infinity;
        if (picks[1] === 0) iron = Infinity;
        if (picks[2] === 0) stone = Infinity;

        // 모든 곡괭이가 없는 경우
        if (diamond === Infinity && iron === Infinity && stone === Infinity) return answer;

        // 곡괭이를 한번 사용하면 5번 연속으로 사용해야됨
        while (count < 5) {
            if (i + count >= minerals.length) break;

            // 각 광물을 캘때 곡괭이마다 피로도를 계산
            switch (minerals[i + count]) {
                case 'diamond':
                    diamond += 1;
                    iron += 5;
                    stone += 25;
                    break;
                case 'iron':
                    diamond += 1;
                    iron += 1;
                    stone += 5;
                    break;
                case 'stone':
                    diamond += 1;
                    iron += 1;
                    stone += 1;
                    break;
                default:
                    break;
            }
            count++;
        }

        //stone, iron, diamond 곡괭이 순서대로 피로도가 같을 경우 제일 낮은 곡괭이를 사용
        if (stone <= iron && stone <= diamond) {
            answer += stone;
            picks[2]--;
        } else if (iron <= diamond) {
            answer += iron;
            picks[1]--;
        } else {
            answer += diamond;
            picks[0]--;
        }
    }

    return answer;
}

console.log(solution([0, 1, 1], ['iron', 'diamond', 'diamond', 'diamond', 'diamond', 'iron']));
