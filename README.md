# Solar Valley static website

The deployable website is in `docs/` and uses only HTML, CSS, and JavaScript. Shared navigation and footer markup live once under `docs/assets/components/` and are loaded by `docs/assets/js/site.js`.

## Contact email

The forms submit to FormSubmit and email `info@solarvalley.co.in`; this repository does not use a database. On the first real submission, FormSubmit sends an activation message to that mailbox. Confirm it once before launch. The configured autoresponse acknowledges the customer after a successful submission.

Do not add SMTP or database passwords to browser code. Everything under `docs/` is public.

SMTP environment-variable names are documented in `.env.example` for an optional server-side mail relay. GitHub Pages cannot read private runtime environment variables, so the current static FormSubmit integration does not consume SMTP credentials. Never copy `MAIL_USERNAME` or `MAIL_PASSWORD` into HTML, CSS, or JavaScript.

## Local preview

Serve `docs/` over HTTP because browser security prevents shared HTML components from loading via `file://`.

```powershell
python -m http.server 8000 --directory docs
```

Then open `http://localhost:8000/`.

## GitHub Pages

In repository settings, configure Pages to deploy from the `main` branch and the `/docs` folder.
