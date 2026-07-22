document.addEventListener('DOMContentLoaded', () => {
    let submitted = false;

    try {
        submitted = window.sessionStorage.getItem('solarValleyFormSubmitted') === 'true';
        window.sessionStorage.removeItem('solarValleyFormSubmitted');
    } catch (error) {
        console.warn('Unable to read form submission state.', error);
    }

    if (!submitted) {
        window.location.replace('contact-us.html#contactFormSection');
        return;
    }

    const successMessage = document.getElementById('submissionSuccess');
    if (successMessage) successMessage.hidden = false;
});
