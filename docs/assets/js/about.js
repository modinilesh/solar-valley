document.addEventListener('DOMContentLoaded', () => {
    const counters = document.querySelectorAll('.counter');
    const speed = 200;

    counters.forEach((counter) => {
        const target = Number(counter.dataset.target || 0);
        let value = 0;
        const increment = Math.max(1, target / speed);

        const update = () => {
            value = Math.min(target, value + increment);
            counter.textContent = value >= target ? `${target}+` : Math.ceil(value);
            if (value < target) window.requestAnimationFrame(update);
        };

        update();
    });
});

let currentImageIndex = 0;

function showImage(index) {
    const images = document.querySelectorAll('.carousel-image');
    if (!images.length) return;
    currentImageIndex = (index + images.length) % images.length;
    images.forEach((image, imageIndex) => image.classList.toggle('active', imageIndex === currentImageIndex));
}

window.nextImage = () => showImage(currentImageIndex + 1);
window.prevImage = () => showImage(currentImageIndex - 1);
window.setInterval(window.nextImage, 5000);
showImage(currentImageIndex);
