
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<div class="container">

    <h1>Sửa San Pham</h1>
    <c:if test="${flag == 1}">
        <p class="alert alert-success">${message}</p>
    </c:if>
    <c:if test="${flag == 2}">
        <p class="alert alert-danger">${message}</p>
    </c:if>

    <form action="/products?action=edit&id=${product.id}" method="post">

        <div class="mb-3">
            <label for="name" class="form-label">Nhap ten San Pham</label>
            <input type="text" class="form-control" id="name" aria-describedby="emailHelp" name="name" value="${product.name}" >
        </div>
        <div class="mb-3">
            <label for="price" class="form-label">Nhap Gia San Pham</label>
            <input type="text" class="form-control" id="price" aria-describedby="emailHelp" name="price" value="${product.price}" >
        </div>
        <div class="mb-3">
            <label for="description" class="form-label">Nhap Mo Ta San Pham</label>
            <input type="text" class="form-control" id="description" aria-describedby="emailHelp" name="description" value="${product.description}" >
        </div>

        <button type="submit" class="btn btn-primary">Cập Nhật</button>
        <a href="/products">Danh Sach San Pham</a></form>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>
