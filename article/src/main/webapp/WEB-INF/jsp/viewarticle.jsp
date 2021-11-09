<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<table border="2" width="70%" cellpadding="2">
<tr><th>Id</th><th>Author Name</th><th>Title</th><th>Description</th><th>Category</th><th>Content</th><th>Created Date</th></tr>
   <c:forEach var="article" items="${articles}">
   <tr>
   <td>${article.id}</td>
   <td>${article.authorname}</td>
   <td>${article.title}</td>
   <td>${article.description}</td>
   <td>${article.category}</td>
   <td>${article.content}</td>
   <td>${article.createdDate}</td>
   </tr>
   </c:forEach>
   </table>
