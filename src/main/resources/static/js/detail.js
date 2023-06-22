(function() {
    const $title = document.querySelector('#title')
    const $content = document.querySelector('#content');
    const urlSearch = new URLSearchParams(location.search);
    const iproduct = urlSearch.get('iproduct');


    fetch(`/product/${iproduct}`)
        .then(res => res.json())
        .then(data => makeDisplay(data));

    const makeDisplay = item => {
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
        `;

        const swiperWrapper = div.querySelector('.swiper-wrapper');
        picDivList.forEach(subItem => {
            swiperWrapper.append(subItem);
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