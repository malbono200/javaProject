window.onload = function () {
  let qty = 1;
  const stock = parseInt(document.getElementById('stock').dataset.stock);
  const price = parseInt(document.getElementById('price').dataset.price);

  document.getElementById('plusBtn').addEventListener('click', () => qtyChange(1));
  document.getElementById('minusBtn').addEventListener('click', () => qtyChange(-1));

  function qtyChange(val) {
    qty += val;
    if (qty < 1) qty = 1;
    if (qty > stock) {
      alert('재고가 부족합니다');
      qty = stock;
    }
    document.getElementById('cartQty').value = qty;
    document.getElementById('amount').innerHTML = (qty * price).toLocaleString();
  }
};