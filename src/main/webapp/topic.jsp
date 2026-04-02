Here’s a clean JSP example that will display your Topic list in a Tailwind CSS styled table. It assumes you’ve set the topics list as a request attribute (e.g., request.setAttribute("topics", topics); in your servlet/DAO layer).
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="learning_logs.learninglogs.User.model.Topic" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>User Topics</title>
    <!-- Tailwind CSS CDN -->
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100 min-h-screen flex items-center justify-center">

<div class="w-full max-w-5xl bg-white shadow-lg rounded-lg p-6">
    <h1 class="text-2xl font-bold mb-4 text-gray-800">Topics</h1>

    <table class="min-w-full border-collapse border border-gray-200">
        <thead class="bg-gray-50">
        <tr>
            <th class="border border-gray-200 px-4 py-2 text-left text-sm font-medium text-gray-600">ID</th>
            <th class="border border-gray-200 px-4 py-2 text-left text-sm font-medium text-gray-600">Title</th>
            <th class="border border-gray-200 px-4 py-2 text-left text-sm font-medium text-gray-600">Created At</th>
            <th class="border border-gray-200 px-4 py-2 text-left text-sm font-medium text-gray-600">Updated At</th>
            <th class="border border-gray-200 px-4 py-2 text-left text-sm font-medium text-gray-600">User ID</th>
        </tr>
        </thead>
        <tbody>
        <%
            List<Topic> topics = (List<Topic>) request.getAttribute("topics");
            if (topics != null && !topics.isEmpty()) {
                for (Topic topic : topics) {
        %>
        <tr class="hover:bg-gray-100">
            <td class="border border-gray-200 px-4 py-2 text-sm text-gray-700"><%= topic.getId() %></td>
            <td class="border border-gray-200 px-4 py-2 text-sm text-gray-700"><%= topic.getTitle() %></td>
            <td class="border border-gray-200 px-4 py-2 text-sm text-gray-700"><%= topic.getCreatedAt() %></td>
            <td class="border border-gray-200 px-4 py-2 text-sm text-gray-700"><%= topic.getUpdatedAt() %></td>
            <td class="border border-gray-200 px-4 py-2 text-sm text-gray-700"><%= topic.getUser_id() %></td>
        </tr>
        <%
            }
        } else {
        %>
        <tr>
            <td colspan="5" class="text-center text-gray-500 py-4">No topics found.</td>
        </tr>
        <% } %>
        </tbody>
    </table>
</div>

</body>
</html>

