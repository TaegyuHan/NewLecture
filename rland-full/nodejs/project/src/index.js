window.addEventListener('load', function() {

    // 템플릿 버전
    let template = "<div>hello node Template</div>";
    document.body.insertAdjacentHTML('beforeend', template);

    // 객체 버전
    let div = document.createElement('div');
    let txt = document.createTextNode('hello node Ojbect');
    div.appendChild(txt);
    document.body.appendChild(div);

    // add 함수 사용
    let addResult = `<div>add(1, 2) = ${add(1, 2)}</div>`;
    document.body.insertAdjacentHTML('beforeend', addResult);
});