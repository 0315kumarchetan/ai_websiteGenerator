const button = document.getElementById('greetBtn');
const greeting = document.querySelector('.greeting');

button.addEventListener('click', () => {
    greeting.textContent = 'Hello, World! 🎉';
});
