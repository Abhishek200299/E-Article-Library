<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

       <form:form method="post" action="save">
        <table >
            <tr>
              <td>ID : </td>
              <td><form:input path="id"  /></td>
            </tr>
         <tr>
          <td>AuthorName : </td>
          <td><form:input path="authorname"  /></td>
         </tr>
         <tr>
          <td>Title :</td>
          <td><form:input path="title" /></td>
         </tr>
         <tr>
          <td>Description :</td>
          <td><form:input path="description" /></td>
         </tr>
         <tr>
           <td>Category :</td>
           <td><form:input path="category" /></td>
         </tr>
         <tr>
           <td>Content :</td>
           <td><textarea id="content" name="content" rows="10" cols="100"></textarea></td>
         </tr>

         <tr>
          <td colspan="2"><input type="submit" value="Save" /></td>
         </tr>
        </table>
       </form:form>