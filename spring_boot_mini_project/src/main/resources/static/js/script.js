const panel = document.getElementById('slidePanel');
const dots = document.querySelectorAll('.dot');
const cnt = document.querySelectorAll('.slide').length;
let idx = 0;

function moveSlide(i) {
  idx = (i + cnt) % cnt;
  panel.style.transform = 'translateX(' + (-100 * idx) + '%)';
  dots.forEach((d, n) => d.classList.toggle('on', n === idx));
}

document.getElementById('nextBtn').onclick = () => moveSlide(idx + 1);
document.getElementById('prevBtn').onclick = () => moveSlide(idx - 1);
dots.forEach((d, n) => d.onclick = () => moveSlide(n));

setInterval(() => moveSlide(idx + 1), 4000);   // 4초마다 자동 넘김
