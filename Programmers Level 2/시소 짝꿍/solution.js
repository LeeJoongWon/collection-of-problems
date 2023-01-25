function solution(weights) {
    let result = 0;

    // weights길이만큼 생성
    const arr = new Array(1001).fill(0);

    for (const w of weights) {
        arr[w] += 1;
    }

    // weights는 100 ~ 1000이하의 숫자이기 때문에 100~1000까지 반복
    for (var i = 100; i < arr.length; i++) {
        // arr[i] => weights값
        if (arr[i] !== 0) {
            // 동일한 weights값이 존재할때(중복 짝궁을 허용) => 100,100,100 => (총갯수 x 중복횟수) = 6
            result += (arr[i] * (arr[i] - 1)) / 2;

            // 조건 weights는 1000초과하지 못한다

            // 현재값 : 비교값, 1 : 2 비율인 경우 1:2, 2:4
            if (i * 2 <= 1000) {
                result += arr[i] * arr[i * 2];
            }

            // 현재값 : 비교값, 2 : 3 비율인 경우
            if ((i * 3) % 2 === 0 && (i * 3) / 2 <= 1000) {
                result += arr[i] * arr[(i * 3) / 2];
            }

            // 현재값 : 비교값, 3 : 4 비율인 경우
            if ((i * 4) % 3 === 0 && (i * 4) / 3 <= 1000) {
                result += arr[i] * arr[(i * 4) / 3];
            }
        }
    }
    return result;
}

solution([100, 180, 360, 200, 100, 270, 400]);
