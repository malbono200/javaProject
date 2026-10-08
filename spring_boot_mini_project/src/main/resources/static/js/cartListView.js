$(document).ready(function () {

  // ===== 수량 변경 시 상품 금액, 총 금액 다시 계산 =====
  $('.cartQty').on('input', function () {
    let qty = parseInt($(this).val()) || 0;
	let max = parseInt($(this).attr('max'));
	if (qty > max) {
	  alert('재고가 부족합니다 (최대 ' + max + '개)');
	  qty = max;
	  $(this).val(max);
	}
    let li = $(this).closest('li');
    let price = parseInt(li.find('.price').data('price'));

    li.find('.amount').attr('data-amount', price * qty).text((price * qty).toLocaleString());

    let sum = 0;
    $('.amount').each(function () {
      sum += parseInt($(this).attr('data-amount'));
    });
    $('#total').text(sum.toLocaleString());
  });

  // ===== 전체 선택 =====
  $('#allCheck').on('click', function () {
    $('.chkDelete').prop('checked', $(this).prop('checked'));
  });

  // 개별 체크에 따라 전체 선택 체크 상태 맞추기
  $('.chkDelete').on('click', function () {
    let total = $('.chkDelete').length;
    let checked = $('.chkDelete:checked').length;
    $('#allCheck').prop('checked', total == checked);
  });

  // ===== 선택 삭제 (Ajax) =====
  $('#deleteCartBtn').on('click', function () {
    if (!$('.chkDelete').is(':checked')) {
      alert('선택된 상품이 없습니다');
      return;
    }
    if (!confirm('선택된 상품을 삭제하시겠습니까?')) return;

    let checkArr = [];
    $('.chkDelete:checked').each(function () {
      checkArr.push($(this).val());
    });

    $.ajax({
      url: '/product/deleteCart',
      type: 'post',
      traditional: true,          // 배열을 delPrd 이름 그대로 전송
      data: { delPrd: checkArr },
      success: function (result) {
        if (result == 1) location.href = '/product/cartList';
      },
      error: function () {
        alert('오류가 발생했습니다');
      }
    });
  });
});