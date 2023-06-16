(function() {
    const $container = document.querySelector('.container');
    function getList() {
        fetch('/product')
            .then(res => {
                if(res.ok) { return res.json() }
                throw new Error('통신 에러');
            })
            .then(data => {
                if(data.length == 0) {
                    alert('상품이 없습니다.')
                    return;
                }
                makeList(data);
            })
            .catch(e => {
                console.log(e);
            })
    }
    function makeList(data) {
        $container.innerHTML = null;
        data.forEach(item => {
            $container.appendChild(makeItems(item));
        });
    }

    function makeItems(item) {
        const div = document.createElement('div');
        div.className = 'item pointer';
        div.innerHTML = `
            <div class="main-pic" style="background-image:url('/imgs/product/${item.iproduct}/${item.mainPic}')"></div>
            <div class="info">${item.nm}</div>
          `;
        return div;
    }
    getList();


})();