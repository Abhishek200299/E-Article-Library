<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

       <form:form method="post" action="editsave">
        <table >
            <tr>
              <td>ID : </td>
              <td><form:input path="id" value = "${article.id}" /></td>
            </tr>
         <tr>
          <td>AuthorName : </td>
          <td><form:input path="authorname" value = "${article.authorname}"  /></td>
         </tr>
         <tr>
          <td>Title :</td>
          <td><form:input path="title" value = "${article.content}"/></td>
         </tr>
         <tr>
          <td>Description :</td>
          <td><form:input path="description" value = "${article.description}" /></td>
         </tr>
         <tr>
           <td>Category :</td>
           <td><form:input path="category" value = "${article.category}"/></td>
         </tr>
         <tr>
           <td>Content :</td>
           <td><textarea id="content" name="content" rows="10" cols="100">${article.content}</textarea></td>
         </tr>

         <tr>
          <td><input type="submit" value="Edit" name="edit"/></td>
         </tr>
        </table>
       </form:form>
       <a href="/deletearticle/${article.id}"><button>Delete</button></a>