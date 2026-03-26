<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="learning_logs.learninglogs.User.model.User" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Home</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>

<body class="min-h-screen bg-slate-50">
<%
    String username = (String) request.getAttribute("username");
    if (username == null) {
        User loggedInUser = (User) session.getAttribute("loggedInUser");
        if (loggedInUser != null) {
            username = loggedInUser.getUserName();
        }
    }
%>
<div class="mx-auto max-w-2xl px-4 py-10">
    <div class="rounded-2xl border border-slate-200 bg-white p-6 shadow-sm">
        <h1 class="text-2xl font-semibold text-slate-900">Welcome</h1>

        <p class="mt-3 text-slate-700">
            Hello, <span id="username" class="font-semibold text-indigo-600"><%= username != null ? username : "Learner" %></span>!
        </p>

        <div class="mt-6 flex gap-3">
            <a href="#" class="rounded-xl bg-indigo-600 px-4 py-2 text-white font-semibold hover:bg-indigo-700">
                Go to Dashboard
            </a>
            <a href="#" class="rounded-xl border border-slate-200 px-4 py-2 text-slate-700 font-semibold hover:bg-slate-50">
                Logout
            </a>
        </div>
    </div>
</div>


</body>
</html>
