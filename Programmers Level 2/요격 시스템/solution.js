function Ascend(a, b) {
    return a[1] - b[1];
}

function solution(targets) {
    const arr = [...targets];
    let intercept = [];

    // 타켓을 오름차순으로 정렬
    arr.sort(Ascend);

    //첫 요격위치
    intercept.push(arr[0][1] - 0.1);
    // 타겟갯수만큼 반복
    for (let i = 0; i < arr.length; i++) {
        // intercept범위내 요격가능한 위치라면 건너뜀
        if (intercept[intercept.length - 1] > arr[i][0]) continue;
        // intercept범위내 요격이 불가능하다면 새로운 요격위치를 추가
        intercept.push(arr[i][1] - 0.1);
    }

    return intercept.length;
}
