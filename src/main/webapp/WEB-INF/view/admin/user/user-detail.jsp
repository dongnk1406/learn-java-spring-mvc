<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
            <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

                <html lang="en">

                <head>
                    <meta charset="UTF-8" />
                    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
                    <title>Create Users</title>
                    <!-- Latest compiled and minified CSS -->
                    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
                        rel="stylesheet" />

                    <!-- Latest compiled JavaScript -->
                    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

                    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
                    <!-- <link href="/css/demo.css" rel="stylesheet"> -->
                </head>

                <body>
                    <div class="container mt-5">
                        <div class="row">
                            <div class="col-12 mx-auto">
                                <h3>User detail</h3>
                                <hr />
                                <table class="table table-border table-hover">
                                    <thead class="thead-dark">
                                        <tr>
                                            <th scope="col">Id</th>
                                            <th scope="col">User name</th>
                                            <th scope="col">Email</th>
                                            <th scope="col">Phone</th>
                                            <th scope="col">Address</th>
                                            <th scope="col">Actions</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <th scope="row">${user.id}</th>
                                            <td>${user.userName}</td>
                                            <td>${user.email}</td>
                                            <td>${user.phone}</td>
                                            <td>${user.address}</td>
                                            <td>

                                                <a href="/admin/user/${user.id}/update" type="button"
                                                    class="btn btn-primary">Update</a>
                                                <a href="/admin/user/${user.id}/delete" type="button"
                                                    class="btn btn-danger">Delete</a>
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </body>

                </html>