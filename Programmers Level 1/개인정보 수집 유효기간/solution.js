function solution(today, terms, privacies) {
    var answer = [];
    const map = new Map();

    terms.forEach((el) => {
        const [key, value] = el.split(' ');
        map.set(key, Number(value) * 28);
    });

    const [yyyy, mm, dd] = today.split('.');
    const pivot = Number(yyyy) * 336 + Number(mm) * 28 + Number(dd);

    privacies.forEach((el, index) => {
        const [date, type] = el.split(' ');
        const [yyyy, mm, dd] = date.split('.');
        const day = Number(yyyy) * 336 + Number(mm) * 28 + Number(dd) + map.get(type);
        if (day <= pivot) answer.push(index + 1);
    });

    return answer;
}
