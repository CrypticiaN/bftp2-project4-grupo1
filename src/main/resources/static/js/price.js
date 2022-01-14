let originalPrice = document.getElementById('price');
let priceValue = parseFloat(document.getElementById('price').innerHTML);
let discount = document.getElementById('discount');
let priceWithDiscount = document.getElementById('priceWithDiscount');
let discountValue = parseFloat(document.getElementById('discount').innerHTML);
let discountPrice;

document.addEventListener("DOMContentLoaded", function() {
    alert("Funciona");
});

const getPrice = () => {
    if (discountValue > 0) {
        discountPrice = ((priceValue - ((discountValue / 100) * priceValue)).toFixed(2)).toString();

        document.write(discountPrice + "€");

    }
    else {
        originalPrice.id = "no-discount";
        priceWithDiscount.style.display = "none";
        discount.style.display = "none";
    }

}

getPrice();
