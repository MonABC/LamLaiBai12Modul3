
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
  <title>Title</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<div class="container">

  <h1>Chi Tiet Mot San Pham</h1>
  <form >
    <div class="mb-3">
      <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="id" value="${product.id}" disabled>
    </div>
    <div class="mb-3">
      <label for="exampleInputEmail1" class="form-label">Ten San Pham</label>
      <input type="text" class="form-control" id="name" aria-describedby="emailHelp" name="name" value="${product.name}" disabled>
    </div>
    <div class="mb-3">
      <label for="exampleInputEmail1" class="form-label">Gia San Pham</label>
      <input type="text" class="form-control" id="price" aria-describedby="emailHelp" name="price" value="${product.price}" disabled>
    </div>
    <div class="mb-3">
      <label for="exampleInputEmail1" class="form-label">Mo Ta San Pham</label>
      <input type="text" class="form-control" id="description" aria-describedby="emailHelp" name="description" value="${product.description}" disabled>
    </div>


    <a href="/products" >Danh Sach San Pham</a>
  </form>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>
