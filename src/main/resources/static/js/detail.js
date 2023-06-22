(function() {
    const $title = document.querySelector('#title')
    const $content = document.querySelector('#content');
    const urlSearch = new URLSearchParams(location.search);
    const iproduct = urlSearch.get('iproduct');

    async function getCustomerList() {
        return await fetch(`/customer`)
            .then(res => res.json());
    }

    fetch(`/product/${iproduct}`)
        .then(res => res.json())
        .then(data => makeDisplay(data));

    const makeDisplay= async (item) => {
        $title.textContent = item.data.nm;

        const picDivList = item.pics.map(subItem => {
            const swiperDiv = document.createElement('div');
            swiperDiv.className = 'swiper-slide';
            swiperDiv.innerHTML = `
                <img src="/imgs/product/${item.data.iproduct}/pics/${subItem}" alt="제품 이미지">
            `;
            return swiperDiv;
        });

        const div = document.createElement('div');
        $content.appendChild(div);

        div.innerHTML = `
            <div class="swiper">  
                <div class="swiper-wrapper">
                </div>
                <div class="swiper-pagination"></div>
  
                <div class="swiper-button-prev"></div>
                <div class="swiper-button-next"></div>
  
                <div class="swiper-scrollbar"></div>
            </div>
            <h3>${item.data.nm} (${item.data.brand})</h3>
            <p>${item.data.price.toString().replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ",")}원</p>
            <div>${item.data.ctnt}</div>
            <div>
                <form id="buy_frm">
                    <input type="hidden" name="iproduct" value="${item.data.iproduct}">
                    <label for="icustomer">구매자</label>
                    <select name="icustomer" id="icustomer">                    
                    </select>
                    <label for="quantity">수량</label><input type="number" id="quantity" name="quantity">
                    <button name="btn_buy">구매</button>
                </form>                
            </div>
        `;

        const swiperWrapper = div.querySelector('.swiper-wrapper');
        picDivList.forEach(subItem => {
            swiperWrapper.appendChild(subItem);
        });

        const customerList = await fetch(`/customer`)
            .then(res => res.json());

        //customer list
        const options = customerList.map(item => {
            const opt = document.createElement('option');
            opt.value = item.icustomer;
            opt.textContent = `${item.nm} - ${item.ph}`;
            return opt;
        });

        const selectCustomer = div.querySelector('#icustomer');
        options.forEach(subItem => {
            selectCustomer.appendChild(subItem);
        });

        const buyFrm = div.querySelector('#buy_frm');
        buyFrm.addEventListener('submit', e => {
            e.preventDefault();
        });
        buyFrm.btn_buy.addEventListener('click', e => {
            const param = {
                'iproduct': buyFrm.iproduct.value,
                'icustomer': buyFrm.icustomer.value,
                'quantity': buyFrm.quantity.value
            }

            console.log(param);

            fetch('/buy', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(param)
            })
                .then(res => res.json())
                .then(res => {
                    console.log(res);
                })
        });

        const swiper = new Swiper('.swiper', {
            // Optional parameters
            direction: 'horizontal',
            loop: true,

            // If we need pagination
            pagination: {
                el: '.swiper-pagination',
            },

            // Navigation arrows
            navigation: {
                nextEl: '.swiper-button-next',
                prevEl: '.swiper-button-prev',
            },

            // And if we need scrollbar
            scrollbar: {
                el: '.swiper-scrollbar',
            },
        });
    }
})();