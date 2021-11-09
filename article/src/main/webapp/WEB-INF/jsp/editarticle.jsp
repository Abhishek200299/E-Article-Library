<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<form:form action="editthearticle">
    <table >
        <tr>
          <td>ID : </td>
          <td><input name="id" id="id" /></td>
        </tr>
         <tr>
          <td colspan="2"><input type="submit" value="Edit" /></td>
         </tr>
    </table>
</form:form>