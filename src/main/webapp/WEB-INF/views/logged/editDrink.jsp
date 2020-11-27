<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="loggedHeader.jsp"%>

<section class="dashboard-section">
    <div class="row dashboard-nowrap">

        <%@include file="loggedList.jsp" %>

        <div class="m-4 p-3 width-medium text-color-darker">
            <div class="dashboard-content border-dashed p-3 m-4 view-height">
                <div class="mt-4 ml-4 mr-4">
                    <!-- fix action, method -->
                    <!-- add name attribute for all inputs -->
                    <form:form method="post" modelAttribute="drink">
                        <div class="row border-bottom border-3">
                            <div class="col"><h3 class="color-header text-uppercase">Edycja drinku</h3></div>
                            <div class="col d-flex justify-content-end mb-2">
                                <button type="submit" class="btn btn-color rounded-0 pt-0 pb-0 pr-4 pl-4">Zapisz
                                </button>
                            </div>
                        </div>

                        <table class="table borderless">
                            <tbody>
                            <tr>
                                <td>
<%--                                    <input name="${item.id}" hidden> --%>
<%--                                    <form:input path="name" hidden />--%>

                                </td>
                            </tr>
                            <tr class="d-flex">
                                <th scope="row" class="col-2">Nazwa Drinku</th>
                                <td class="col-7">
                                    <form:input class="w-100 p-1" value="${drink1.name}" path="name" />
                                </td>
                            </tr>
                            <tr class="d-flex">
                                <th scope="row" class="col-2">Opis</th>
                                <td class="col-7"><form:form><textarea path="description" class="w-100 p-1" rows="5"
                                                                 name="description" >${drink1.description}</textarea></form:form>
                                </td>
                            </tr>
                            <tr class="d-flex">
                                <th scope="row" class="col-2">Przygotowanie</th>
                                <td class="col-7">
                                    <form:form><textarea path="preparation" class="w-100 p-1" rows="5" name="preparation" >${drink1.preparation}</textarea></form:form>

                                </td>
                            </tr>
                            </tbody>
                        </table>


                    </form:form>
                </div>
            </div>
        </div>
    </div>
</section>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
        integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
        integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>
</body>
</html>