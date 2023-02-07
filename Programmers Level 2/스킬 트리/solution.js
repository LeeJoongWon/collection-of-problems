function solution(skill, skill_trees) {
    var answer = 0;

    let filtered = skill_trees.map((tree) => {
        return [...tree].filter((el) => skill.includes(el));
    });

    for (let i = 0; i < filtered.length; i++) {
        let isRight = true;
        for (let j = 0; j < filtered[i].length; j++) {
            if (skill[j] !== filtered[i][j]) {
                isRight = false;
                break;
            }
        }
        if (isRight) answer++;
    }

    return answer;
}
