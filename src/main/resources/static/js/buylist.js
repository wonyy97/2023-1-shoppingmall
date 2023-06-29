(function() {
    const urlSearch = new URLSearchParams(location.search);
    const icustomer = urlSearch.get('icustomer');

    const $content = document.querySelector('#content');

    fetch(`/buy/${icustomer}`)
        .then(res => res.json())
        .then(data => makeList(data));

    const makeList = data => {
        const table = document.createElement('table');
        $content.appendChild(table);
        table.innerHTML = `
            <thead>
                <tr>
                    <th>구매번호</th>
                    <th>구매일시</th>
                    <th>제품명</th>
                    <th>사진</th>
                    <th>금액</th>                
                </tr>
            </thead>
            <tbody>            
            </tbody>
        `;

        const tbody = table.querySelector('tbody');

        data.forEach(item => {
            tbody.appendChild(makeItem(item));
        });
    }

    const makeItem = item => {
        const tr = document.createElement('tr');
        tr.innerHTML = `
            <td>${item.ibuy}</td>
            <td>${item.buyAt}</td>
            <td>${item.productNm}</td>
            <td><img src="/imgs/product/${item.iproduct}/${item.productMainPic}"></td>
            <td>${item.productPrice.toString().replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ",")}원</td>
        `;
        return tr;
    }
})();