<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="learning_logs.learninglogs.User.model.Topic" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Topics</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100 min-h-screen">

<div class="mx-auto w-full max-w-5xl px-4 py-10">
    <div class="mb-4">
        <a href="${pageContext.request.contextPath}/home.jsp" class="text-sm font-medium text-indigo-600 hover:text-indigo-700">
            Back to Home
        </a>
    </div>

    <div class="rounded-lg bg-white p-6 shadow-lg">
        <h1 class="mb-4 text-2xl font-bold text-gray-800">Your Topics</h1>

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
                <td colspan="5" class="py-4 text-center text-gray-500">No topics found.</td>
            </tr>
            <% } %>
            </tbody>
        </table>
    </div>
</div>

</body>
</html>
