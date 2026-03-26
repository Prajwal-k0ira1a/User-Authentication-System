<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <title>Register</title>
  <script src="https://cdn.tailwindcss.com"></script>
</head>

<body class="min-h-screen bg-slate-50">
  <div class="flex min-h-screen items-center justify-center px-4 py-10">
    <div class="w-full max-w-lg">
      <div class="mb-6 text-center">
        <h1 class="text-2xl font-semibold text-slate-900">Create your account</h1>
        <p class="mt-2 text-sm text-slate-600">Just the basics to get started.</p>
      </div>

      <div class="rounded-2xl border border-slate-200 bg-white p-6 shadow-sm">
        <% String error = (String) request.getAttribute("error"); %>
        <% if (error != null) { %>
          <div class="mb-4 rounded-xl border border-red-200 bg-red-50 px-4 py-3 text-sm text-red-700">
            <%= error %>
          </div>
        <% } %>

        <form class="space-y-5" action="register" method="post">
          <!-- userName -->
          <div>
            <label for="userName" class="block text-sm font-medium text-slate-900">User name</label>
            <div class="mt-2">
              <input
                id="userName"
                name="username"
                type="text"
                autocomplete="username"
                required
                class="w-full rounded-xl border border-slate-200 bg-white px-4 py-2.5 text-slate-900 placeholder:text-slate-400
                       focus:border-indigo-500 focus:outline-none focus:ring-4 focus:ring-indigo-100"
                placeholder="yourname"
              />
            </div>
          </div>

          <!-- email -->
          <div>
            <label for="email" class="block text-sm font-medium text-slate-900">Email</label>
            <div class="mt-2">
              <input
                id="email"
                name="email"
                type="email"
                autocomplete="email"
                required
                class="w-full rounded-xl border border-slate-200 bg-white px-4 py-2.5 text-slate-900 placeholder:text-slate-400
                       focus:border-indigo-500 focus:outline-none focus:ring-4 focus:ring-indigo-100"
                placeholder="jane@example.com"
              />
            </div>
          </div>

          <!-- password -->
          <div>
            <label for="password" class="block text-sm font-medium text-slate-900">Password</label>
            <div class="mt-2">
              <input
                id="password"
                name="password"
                type="password"
                autocomplete="new-password"
                required
                minlength="8"
                class="w-full rounded-xl border border-slate-200 bg-white px-4 py-2.5 text-slate-900 placeholder:text-slate-400
                       focus:border-indigo-500 focus:outline-none focus:ring-4 focus:ring-indigo-100"
                placeholder="At least 8 characters"
              />
            </div>
          </div>

          <button
            type="submit"
            class="w-full rounded-xl bg-indigo-600 px-4 py-2.5 text-white font-semibold
                   hover:bg-indigo-700 focus:outline-none focus:ring-4 focus:ring-indigo-100"
          >
            Register
          </button>

          <p class="text-center text-sm text-slate-600">
            Already have an account?
            <a href="login" class="font-medium text-indigo-600 hover:text-indigo-700 underline">Sign in</a>
          </p>
        </form>
      </div>
    </div>
  </div>
</body>
</html>
