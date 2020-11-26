<%--
  Created by IntelliJ IDEA.
  User: justyna
  Date: 27.10.2020
  Time: 19:57
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="loggedHeader.jsp" %>

<section class="dashboard-section">
    <div class="row dashboard-nowrap">

        <%@ include file="loggedList.jsp" %>

        <div class="m-4 p-4 width-medium">
            <div class="dashboard-header m-4">
                <div class="dashboard-menu">
                    <div class="menu-item border-dashed">
                        <a href="<c:url value="/add" />">
                            <i class="far fa-plus-square icon-plus-square"></i>
                            <span class="title">dodaj drink</span>
                        </a>
                    </div>

                </div>

                <div class="dashboard-alerts">
                    <div class="alert-item alert-info">
                        <i class="fas icon-circle fa-info-circle"></i>
                        <span class="font-weight-bold">Liczba drinków: ${countDrinks}</span>
                    </div>

                </div>
            </div>



                <div class="m-4 p-4 border-dashed">
                    <h2 class="dashboard-content-title">
                        <span>Ostatnio dodany drink: </span>
                    </h2>

                    <table class="table">
<c:forEach items="${recipePlanList}" var="list">
                        <thead>

                        <tr class="d-flex">
                            <th class="col-2">${list.dayName}</th>


                        </tr>
                        </thead>
                        <tbody>
                        <tr class="d-flex">
                            <td class="col-2">${list.mealName}</td>
                            <td class="col-8">${list.recipeDescription}</td>
                            <td class="col-2">
                                <a href="/planDetails?id=${planId}" class="btn btn-info rounded-0 text-light m-1">Szczegóły</a>
                            </td>
                        </tr>


                        </tbody>
                        </c:forEach>
                    </table>


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
