async function loadComponent(selector, path) {
    const host = document.querySelector(selector);
    if (!host) return;

    try {
        const response = await fetch(path);
        if (!response.ok) throw new Error(`HTTP ${response.status}`);
        host.innerHTML = await response.text();
    } catch (error) {
        console.error(`Unable to load ${path}`, error);
        host.innerHTML = '<p class="component-error">Part of this page could not be loaded. Please refresh and try again.</p>';
    }
}

function initialiseNavigation() {
    const sidebar = document.getElementById('sidebar');
    const openButton = document.getElementById('openSidebar');
    const closeButton = document.getElementById('closeSidebar');
    const backdrop = document.getElementById('sidebarBackdrop');
    const header = document.getElementById('mainHeader');

    const setSidebarOpen = (isOpen, restoreFocus = false) => {
        sidebar?.classList.toggle('active', isOpen);
        backdrop?.classList.toggle('active', isOpen);
        document.body.classList.toggle('sidebar-open', isOpen);
        sidebar?.setAttribute('aria-hidden', String(!isOpen));
        openButton?.setAttribute('aria-expanded', String(isOpen));

        if (isOpen) closeButton?.focus();
        if (!isOpen && restoreFocus) openButton?.focus();
    };

    openButton?.addEventListener('click', () => setSidebarOpen(true));
    closeButton?.addEventListener('click', () => setSidebarOpen(false, true));
    backdrop?.addEventListener('click', () => setSidebarOpen(false, true));
    sidebar?.querySelectorAll('a').forEach((link) => {
        link.addEventListener('click', () => setSidebarOpen(false));
    });

    document.addEventListener('keydown', (event) => {
        if (event.key === 'Escape' && sidebar?.classList.contains('active')) {
            setSidebarOpen(false, true);
        }
    });

    const updateHeader = () => header?.classList.toggle('scrolled', window.scrollY > 80);
    updateHeader();
    window.addEventListener('scroll', updateHeader, { passive: true });

    const currentPage = window.location.pathname.split('/').pop() || 'index.html';
    document.querySelectorAll('[data-nav-page]').forEach((link) => {
        if (link.dataset.navPage === currentPage) link.setAttribute('aria-current', 'page');
    });
}

function initialiseFaq() {
    document.querySelectorAll('.faq-toggle').forEach((toggle) => {
        toggle.addEventListener('click', () => {
            const content = toggle.nextElementSibling;
            const shouldOpen = !toggle.classList.contains('active');

            document.querySelectorAll('.faq-toggle').forEach((item) => {
                item.classList.remove('active');
                item.setAttribute('aria-expanded', 'false');
                item.nextElementSibling?.classList.add('hidden');
            });

            if (shouldOpen) {
                toggle.classList.add('active');
                toggle.setAttribute('aria-expanded', 'true');
                content?.classList.remove('hidden');
            }
        });
    });
}

function initialiseEmailForms() {
    document.querySelectorAll('.email-contact-form').forEach((form) => {
        form.addEventListener('submit', () => {
            try {
                window.sessionStorage.setItem('solarValleyFormSubmitted', 'true');
            } catch (error) {
                console.warn('Unable to record form submission state.', error);
            }

            const nextInput = form.querySelector('input[name="_next"]');
            if (nextInput) nextInput.value = new URL('thanks.html', window.location.href).href;

            const submitButton = form.querySelector('button[type="submit"]');
            if (submitButton) {
                submitButton.disabled = true;
                submitButton.innerHTML = 'Sending&hellip;';
            }
        });
    });
}

document.addEventListener('DOMContentLoaded', async () => {
    await Promise.all([
        loadComponent('[data-component="site-header"]', 'assets/components/site-header.html'),
        loadComponent('[data-component="site-footer"]', 'assets/components/site-footer.html')
    ]);

    initialiseNavigation();
    initialiseFaq();
    initialiseEmailForms();
    document.querySelectorAll('[data-current-year]').forEach((node) => {
        node.textContent = new Date().getFullYear();
    });
});
