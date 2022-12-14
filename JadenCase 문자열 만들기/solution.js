function solution(s) {
    s = isNaN(s[0]) ? s.charAt(0).toUpperCase() + s.slice(1) : s;

    let empty = false;
    for (let i = 1; i < s.length; i++) {
        if (s[i] === ' ') empty = true;
        else if (empty) {
            s = `${s.slice(0, i)}${s.charAt(i).toUpperCase()}${s.slice(i + 1)}`;
            empty = false;
        } else {
            s = `${s.slice(0, i)}${s.charAt(i).toLowerCase()}${s.slice(i + 1)}`;
        }
    }
    return s;
}
