<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<style type="text/css">
body{
 background-image:url("images/book.jpg");
 height:100%;
 background-position:center;
 background-repeat:no repeat;
 background-size:cover;
 
}         
        </style>
<title>Book Entry</title>
</head>
<body>

<div class="card" style=" text-align:center; width:500px; border:10px; padding: 10px; border-radius: 15px; border: 1px solid; margin-top:7%; margin-left:3%">
    <h1>Book Entry</h1>
    <form method="post" action="insert">
    <div class="card" style=" text-align:left;width:400px; border:10px; padding: 10px; border-radius: 15px; border: 1px solid; margin-top:7%; margin-left:3%; margin-bottom:4%">
    
        <div class="form-group">
          <label for="title">Title</label>
          <input type="text" class="form-control" id="title" name="title" placeholder="Enter title">
        </div>
        <div class="form-group">
            <label for="Author">Author</label>
            <input type="text" class="form-control" id="author" name="author" placeholder="Enter book author">
          </div>
          <div class="form-group">
            <label for="Price">Price</label>
            <input type="text" class="form-control" id="price" name="price" placeholder="Enter Book Price">
          </div>
        
        <button type="submit" name="submit" class="btn btn-primary">Submit</button>
              </div>
        
      </form>
</div>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>